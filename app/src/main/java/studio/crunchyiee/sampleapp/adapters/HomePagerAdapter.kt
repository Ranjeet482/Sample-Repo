package studio.crunchyiee.sampleapp.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

/**
 * Created by rk on 8/23/18.
 */
class HomePagerAdapter(fm: FragmentManager, val fragments: ArrayList<Fragment>, val titles: Array<String> ) : FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return  fragments[position]
    }

    override fun getCount(): Int {
        return  fragments.size
    }

    override fun getPageTitle(position: Int): CharSequence {
        return  titles[position]
    }
}