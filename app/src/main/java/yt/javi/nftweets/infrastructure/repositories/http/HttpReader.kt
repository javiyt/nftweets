package yt.javi.nftweets.infrastructure.repositories.http

import android.support.v4.util.LruCache
import java.net.URL


class HttpReader(private val cache: LruCache<String, StringBuilder>) {
    fun getText(url: URL): StringBuilder {
        var content = cache.get(url.toString())
        if (content == null) {
            content = StringBuilder(url.readText())
            cache.put(url.toString(), content)
        }

        return content
    }
}