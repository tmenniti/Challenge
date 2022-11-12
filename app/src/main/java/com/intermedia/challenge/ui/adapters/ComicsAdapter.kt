package com.intermedia.challenge.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.intermedia.challenge.R
import com.intermedia.challenge.data.model.ComicsItem
import com.intermedia.challenge.databinding.ItemRowComicsBinding

class ComicsAdapter(
    private val context: Context,
    private val comicsList: List<ComicsItem>
) : RecyclerView.Adapter<ComicsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row_comics, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val comic : String = comicsList[position].name
        val year : String = comic.substring(
            (comic.indexOf("(") + 1) , (comic.indexOf(")"))
        )
        holder.binding.tvComic.text = comic
        holder.binding.tvYear.text = year
    }

    override fun getItemCount(): Int {
        return comicsList.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemRowComicsBinding.bind(view)
    }
}