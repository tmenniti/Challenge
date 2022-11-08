package com.intermedia.challenge.ui.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.intermedia.challenge.R
import com.intermedia.challenge.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragment(CharactersFragment())

        binding.linearCharacters.setOnClickListener {
            replaceFragment(CharactersFragment())
            selectCharacters()
        }

        binding.linearEvents.setOnClickListener {
            replaceFragment(EventsFragment())
            selectEvents()
        }

    }

    private fun replaceFragment(fragment : Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.navHostFragment, fragment)
        fragmentTransaction.commit()
    }

    private fun selectCharacters() {
        binding.tvCharacters.setTextColor(ContextCompat.getColor(this, R.color.dark_gray))
        binding.tvEvents.setTextColor(ContextCompat.getColor(this, R.color.light_gray2))
    }

    private fun selectEvents() {
        binding.tvEvents.setTextColor(ContextCompat.getColor(this, R.color.dark_gray))
        binding.tvCharacters.setTextColor(ContextCompat.getColor(this, R.color.light_gray2))
    }

}