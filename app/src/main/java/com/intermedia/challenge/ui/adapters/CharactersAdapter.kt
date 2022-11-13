package com.intermedia.challenge.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.intermedia.challenge.core.BACKDROP_SIZE
import com.intermedia.challenge.core.setImageGlide
import com.intermedia.challenge.R
import com.intermedia.challenge.data.model.Result
import com.intermedia.challenge.databinding.ItemRowCharactersBinding
import com.intermedia.challenge.ui.interfaces.CharactersInterface

class CharactersAdapter(
    private val context: Context,
    private val characterInterface : CharactersInterface,
    private val charactersList: List<Result>
) : RecyclerView.Adapter<CharactersAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row_characters, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val name : String = charactersList[position].name
        val description : String = charactersList[position].description
        var thumbnailPath : String = charactersList[position].thumbnail.path.replace("http","https")
        val thumbnailExtension : String = charactersList[position].thumbnail.extension
        thumbnailPath = "$thumbnailPath/$BACKDROP_SIZE.$thumbnailExtension"

        holder.binding.tvCharacterName.text = name
        holder.binding.tvCharacterDescription.text = description

        context.setImageGlide(thumbnailPath, holder.binding.imgCharacter)

        holder.binding.cardViewCharacter.setOnClickListener {
            characterInterface.onCharacterClicked(charactersList[position])
        }
    }

    override fun getItemCount(): Int {
        return charactersList.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemRowCharactersBinding.bind(view)
    }
}