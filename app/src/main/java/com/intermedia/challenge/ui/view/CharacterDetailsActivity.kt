package com.intermedia.challenge.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.intermedia.challenge.core.BACKDROP_SIZE2
import com.intermedia.challenge.core.setImageGlide
import com.intermedia.challenge.data.model.ComicsItem
import com.intermedia.challenge.data.model.Result
import com.intermedia.challenge.databinding.ActivityCharacterDetailsBinding
import com.intermedia.challenge.ui.adapters.ComicsAdapter

class CharacterDetailsActivity : AppCompatActivity() {

    private lateinit var character : Result

    private lateinit var binding : ActivityCharacterDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharacterDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        character = intent.getSerializableExtra("character") as Result
        setCharacterInformation()
        setComics()

        binding.imgClose.setOnClickListener {
            onBackPressed()
        }
    }

    private fun setCharacterInformation() {
        var thumbnailPath : String = character.thumbnail.path.replace("http","https")
        val thumbnailExtension : String = character.thumbnail.extension
        thumbnailPath = "$thumbnailPath/$BACKDROP_SIZE2.$thumbnailExtension"

        binding.tvCharacterName.text = character.name
        setImageGlide(thumbnailPath, binding.imgCharacter)

        val description = character.description
        if (description.isNotEmpty()) {
            binding.tvCharacterDescription.visibility = View.VISIBLE
            binding.tvCharacterDescription.text = description
        }
    }

    private fun setComics() {
        val comicsList : List<ComicsItem> = character.comics.items

        if (comicsList.isNotEmpty()) {
            binding.tvAppearsIn.visibility = View.VISIBLE

            val comicsAdapter = ComicsAdapter(this, comicsList)
            binding.recyclerComics.layoutManager = LinearLayoutManager(
                this, LinearLayoutManager.VERTICAL, false
            )
            binding.recyclerComics.adapter = comicsAdapter
        }
    }
}