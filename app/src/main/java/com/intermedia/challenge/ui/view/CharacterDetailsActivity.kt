package com.intermedia.challenge.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.intermedia.challenge.databinding.ActivityCharacterDetailsBinding

class CharacterDetailsActivity : AppCompatActivity() {

    private lateinit var binding : ActivityCharacterDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharacterDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imgClose.setOnClickListener {
            onBackPressed()
        }
    }
}