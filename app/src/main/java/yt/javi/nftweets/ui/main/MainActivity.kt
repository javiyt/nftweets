package yt.javi.nftweets.ui.main

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.util.LruCache
import android.support.v7.app.AppCompatActivity
import android.util.Base64
import android.util.Log
import com.beust.klaxon.Parser
import com.crashlytics.android.Crashlytics
import com.twitter.sdk.android.core.DefaultLogger
import com.twitter.sdk.android.core.Twitter.initialize
import com.twitter.sdk.android.core.TwitterAuthConfig
import com.twitter.sdk.android.core.TwitterConfig
import io.fabric.sdk.android.Fabric
import kotlinx.android.synthetic.main.activity_main.*
import yt.javi.nftweets.BuildConfig
import yt.javi.nftweets.R
import yt.javi.nftweets.domain.service.news.GetLatestNewsService
import yt.javi.nftweets.infrastructure.repositories.http.ArticleHttpRepository
import yt.javi.nftweets.infrastructure.repositories.http.HttpReader
import yt.javi.nftweets.ui.fragments.TeamListFragment
import yt.javi.nftweets.ui.news.NewsFragment
import java.net.URL
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec


class MainActivity : AppCompatActivity() {
    companion object {
        init {
            System.loadLibrary("keys")
        }

        val ALGORITHM = "AES"
    }

    private external fun getCryptedTwitterKey(): String

    private external fun getCryptedTwitterSecret(): String

    private external fun getCryptedNewsApiKey(): String

    private external fun getEncryptionKey(): String

    private fun getDecryptedString(encryptedText: String): String {
        val key = SecretKeySpec(Base64.decode(getEncryptionKey().toByteArray(), Base64.DEFAULT), ALGORITHM)
        val cipher = Cipher.getInstance(ALGORITHM)
        cipher.init(Cipher.DECRYPT_MODE, key)

        return String(cipher.doFinal(Base64.decode(encryptedText, Base64.DEFAULT)))
    }

    private fun getTwitterKey(): String =
            getDecryptedString(getCryptedTwitterKey())

    private fun getTwitterSecret(): String =
            getDecryptedString(getCryptedTwitterSecret())


    private fun getNewsApiKey(): String =
            getDecryptedString(getCryptedNewsApiKey())


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Fabric.with(this, Crashlytics())

        setContentView(R.layout.activity_main)

        initialize(
                TwitterConfig.Builder(this)
                        .logger(DefaultLogger(Log.DEBUG))
                        .twitterAuthConfig(
                                TwitterAuthConfig(
                                        getTwitterKey(),
                                        getTwitterSecret()
                                )
                        )
                        .debug(true)
                        .build()
        )

        navigation.setOnNavigationItemSelectedListener { item ->
            var selectedFragment: Fragment? = null
            when (item.itemId) {
                R.id.action_item1 -> selectedFragment = TeamListFragment()
                R.id.action_item2 -> selectedFragment = NewsFragment(
                        GetLatestNewsService(
                                ArticleHttpRepository(
                                        Parser(),
                                        HttpReader(LruCache(100))
                                ),
                                URL(BuildConfig.NEWS_API_URL + getNewsApiKey())
                        )
                )

            }
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.main_view, selectedFragment)
            transaction.commit()
            true
        }

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.main_view, TeamListFragment())
        transaction.commit()
        navigation.menu.getItem(1).isChecked = true

        main_toolbar.setTitle(R.string.app_name)
    }
}