package studio.crunchyiee.sampleapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import studio.crunchyiee.sampleapp.R

class ActivityNewsAdapter(val activityNewsItem: ArrayList<String>): RecyclerView.Adapter<ActivityNewsAdapter.ActivityNewsHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivityNewsHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_item_activity, parent, false)

        return ActivityNewsHolder(view)
    }

    override fun getItemCount(): Int {

        return  activityNewsItem.size
    }

    override fun onBindViewHolder(holder: ActivityNewsHolder, position: Int) {

        holder.description.text = activityNewsItem[position]
    }


    class ActivityNewsHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val description = itemView.findViewById<AppCompatTextView>(R.id.text_description)

    }
}