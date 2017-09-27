package yt.javi.nfltweets.view.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter


class TeamsPageAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
    private var fragments = mutableListOf<Fragment>()

    private var fragmentsTitle = mutableListOf<String>()

    override fun getItem(position: Int): Fragment = fragments[position]

    override fun getCount(): Int = fragments.size

    fun addFragment(fragment: Fragment, title: String) {
        fragments.add(fragment)
        fragmentsTitle.add(title)
    }

    override fun getPageTitle(position: Int): CharSequence = fragmentsTitle[position]
}