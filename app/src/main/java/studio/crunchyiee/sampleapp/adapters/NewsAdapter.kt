package studio.crunchyiee.sampleapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import studio.crunchyiee.sampleapp.R

class NewsAdapter(val newsItems : ArrayList<String>) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return NewsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return newsItems.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.mNewsHeading.text = newsItems[position]
    }


    class NewsViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val mNewsImage = itemView.findViewById<AppCompatImageView>(R.id.imageView)
        val mNewsHeading = itemView.findViewById<AppCompatTextView>(R.id.tv_news_heading)

    }
}