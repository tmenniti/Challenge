package com.intermedia.challenge.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.intermedia.challenge.core.setImageGlide
import com.intermedia.challenge.R
import com.intermedia.challenge.core.BACKDROP_SIZE
import com.intermedia.challenge.data.model.EventResult
import com.intermedia.challenge.databinding.ItemRowEventsBinding

class EventsAdapter(
    private val context: Context,
    private val eventsList: List<EventResult>
) : RecyclerView.Adapter<EventsAdapter.ViewHolder>() {

    private val mutableSelectedList = mutableListOf<EventResult>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row_events, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        setEvent(position, holder)
        setComics(position, holder)

        val event = eventsList[position]

        if (mutableSelectedList.contains(event)) {
            holder.binding.constraintDiscuss.visibility = View.VISIBLE
            holder.binding.imgArrow.setBackgroundResource(R.drawable.ic_up)
        } else {
            holder.binding.constraintDiscuss.visibility = View.GONE
            holder.binding.imgArrow.setBackgroundResource(R.drawable.ic_down)
        }

        holder.binding.imgArrow.setOnClickListener {

            if (mutableSelectedList.contains(event)) {
                mutableSelectedList.remove(event)
            } else {
                mutableSelectedList.add(event)
            }
            notifyItemChanged(position)
        }
    }

    override fun getItemCount(): Int {
        return eventsList.size
    }

    private fun setEvent(position: Int, holder : ViewHolder) {
        val title : String = eventsList[position].title
        val date : String? = eventsList[position].start
        var thumbnailPath : String = eventsList[position].thumbnail.path.replace("http","https")
        val thumbnailExtension : String = eventsList[position].thumbnail.extension
        thumbnailPath = "$thumbnailPath/$BACKDROP_SIZE.$thumbnailExtension"

        holder.binding.tvEvent.text = title
        if (!date.isNullOrEmpty()) {
            val finalDate = date.split(" ")[0]
            holder.binding.tvEventDescription.text = finalDate
        }

        context.setImageGlide(thumbnailPath, holder.binding.imgEvent)
        holder.binding.imgArrow.setBackgroundResource(R.drawable.ic_down)
    }

    private fun setComics(position: Int, holder : ViewHolder) {
        val totalComics = eventsList[position].comics.items.size

        if (totalComics > 0) {
            if (totalComics >= 1) {
                val comic1 : String = eventsList[position].comics.items[0].name
                val year1 : String = comic1.substring(
                    (comic1.indexOf("(") + 1) , (comic1.indexOf(")"))
                )
                holder.binding.tvComic1.text = comic1
                holder.binding.tvYear1.text = year1
            }
            if (totalComics >= 2) {
                val comic2 : String = eventsList[position].comics.items[1].name
                val year2 : String = comic2.substring(
                    (comic2.indexOf("(") + 1) , (comic2.indexOf(")"))
                )
                holder.binding.tvComic2.text = comic2
                holder.binding.tvYear2.text = year2
            }
            if (totalComics >= 3) {
                val comic3 : String = eventsList[position].comics.items[2].name
                val year3 : String = comic3.substring(
                    (comic3.indexOf("(") + 1) , (comic3.indexOf(")"))
                )
                holder.binding.tvComic3.text = comic3
                holder.binding.tvYear3.text = year3
            }
            if (totalComics >= 4) {
                val comic4 : String = eventsList[position].comics.items[3].name
                val year4 : String = comic4.substring(
                    (comic4.indexOf("(") + 1) , (comic4.indexOf(")"))
                )
                holder.binding.tvComic4.text = comic4
                holder.binding.tvYear4.text = year4
            }
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemRowEventsBinding.bind(view)
    }
}