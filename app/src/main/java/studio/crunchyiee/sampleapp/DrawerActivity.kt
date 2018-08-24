package studio.crunchyiee.sampleapp

import android.content.Intent
import android.os.Bundle
import com.google.android.material.navigation.NavigationView
import androidx.core.view.GravityCompat
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import android.view.MenuItem
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_drawer.*
import kotlinx.android.synthetic.main.app_bar_drawer.*
import kotlinx.android.synthetic.main.content_drawer.*
import studio.crunchyiee.sampleapp.Model.NavMenu
import studio.crunchyiee.sampleapp.adapters.HomePagerAdapter
import studio.crunchyiee.sampleapp.fragments.HomeFragment

class DrawerActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var mFragments: ArrayList<Fragment>
    private val list = arrayOf("breaking", "flash", "sports", "studio", "breaking", "flash", "sports", "studio")
    private lateinit var menu1: NavMenu
    private lateinit var menu2: NavMenu

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drawer)
        setSupportActionBar(toolbar)


        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        mFragments = ArrayList()

        for (l in list) {

            mFragments.add(addFragmentWithArguments(l))
        }


        viewPager.adapter = HomePagerAdapter(supportFragmentManager, mFragments, list)

        tabs.setupWithViewPager(viewPager)

        addNavigationDynamically()
    }


    private fun addNavigationDynamically() {
        val navMenu = nav_view.menu


        menu1 = NavMenu(1, "item1")
        menu2 = NavMenu(2, "item2")
        val item = navMenu.add(0, menu1.id, menu1.id, menu1.name)
        item.setIcon(R.drawable.ic_menu_gallery)
        val item1 = navMenu.add(0, menu2.id, menu2.id, menu2.name)
        item1.setIcon(R.drawable.ic_menu_camera)

        nav_view.invalidate()
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

//    override fun onCreateOptionsMenu(menu: NavMenu): Boolean {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        menuInflater.inflate(R.menu.drawer, menu)
//        return true
//    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            1 -> {
                Toast.makeText(this@DrawerActivity, 1.toString(), Toast.LENGTH_LONG).show()
                val intent = Intent(this@DrawerActivity, MainActivity::class.java)
                intent.putExtra("data",item.itemId)
                startActivity(intent)
            }
            2 -> {
                Toast.makeText(this@DrawerActivity, 2.toString(), Toast.LENGTH_LONG).show()
                val intent = Intent(this@DrawerActivity, MainActivity::class.java)
                intent.putExtra("data",item.itemId)
                startActivity(intent)
            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun addFragmentWithArguments(tag: String): Fragment {
        val fragment: Fragment = HomeFragment()
        val bundle = Bundle()
        bundle.putString("title", tag)
        fragment.arguments = bundle
        return fragment
    }

}
