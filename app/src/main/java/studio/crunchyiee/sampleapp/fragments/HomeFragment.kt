package studio.crunchyiee.sampleapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_home.*
import studio.crunchyiee.sampleapp.R
import studio.crunchyiee.sampleapp.adapters.NewsAdapter

/**
 * Created by rk on 8/23/18.
 */

class HomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //text.text = .arguments?.getString("title")

        recyclerView.apply {
            layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
            adapter = NewsAdapter(arrayListOf("Chaos in Nepal due to Bimstec","Nimantrana launched..app of the decade"))
        }
    }
}