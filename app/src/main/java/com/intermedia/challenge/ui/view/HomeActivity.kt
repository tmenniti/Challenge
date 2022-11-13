package com.intermedia.challenge.ui.view

import android.graphics.Typeface
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.intermedia.challenge.R
import com.intermedia.challenge.databinding.ActivityHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
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
        binding.imgCharacters.setBackgroundResource(R.drawable.ic_superhero_enabled)
        binding.imgEvents.setBackgroundResource(R.drawable.ic_calendar_disabled)

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.navHostFragment, fragment)
        fragmentTransaction.commit()
    }

    private fun selectCharacters() {
        binding.imgCharacters.setBackgroundResource(R.drawable.ic_superhero_enabled)
        binding.imgEvents.setBackgroundResource(R.drawable.ic_calendar_disabled)
        binding.tvCharacters.setTextColor(ContextCompat.getColor(this, R.color.light_black))
        binding.tvEvents.setTextColor(ContextCompat.getColor(this, R.color.dark_gray))
        binding.tvCharacters.typeface = Typeface.DEFAULT_BOLD
        binding.tvEvents.typeface = Typeface.DEFAULT
    }

    private fun selectEvents() {
        binding.imgEvents.setBackgroundResource(R.drawable.ic_calendar_enabled)
        binding.imgCharacters.setBackgroundResource(R.drawable.ic_superhero_disabled)
        binding.tvEvents.setTextColor(ContextCompat.getColor(this, R.color.light_black))
        binding.tvCharacters.setTextColor(ContextCompat.getColor(this, R.color.dark_gray))
        binding.tvEvents.typeface = Typeface.DEFAULT_BOLD
        binding.tvCharacters.typeface = Typeface.DEFAULT
    }

    override fun onBackPressed() {

    }

}