package studio.crunchyiee.sampleapp

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import studio.crunchyiee.sampleapp.adapters.ActivityNewsAdapter
import studio.crunchyiee.sampleapp.adapters.HomePagerAdapter
import studio.crunchyiee.sampleapp.fragments.HomeFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val data = intent?.getIntExtra("data",0)

        Toast.makeText(this@MainActivity, data.toString(), Toast.LENGTH_SHORT).show()

        back_btn.title = data.toString()

        back_btn.setNavigationOnClickListener{
            finish()
        }

        activity_recycler_view.apply {
            layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
            adapter = ActivityNewsAdapter(arrayListOf("Breaking", "Not breaking"))
        }
    }






}
