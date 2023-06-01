package com.colinbeuttler.dragonchronicles

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.colinbeuttler.dragonchronicles.chapterselection.ChapterSelection
import com.colinbeuttler.dragonchronicles.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

 private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        createCardViews()
        startNewGame()
        chapterSelectMenu()
    }

    private fun createCardViews() {
        binding.startLogin.setOnClickListener {
            binding.startLogin.visibility = View.INVISIBLE
            binding.startMenu.visibility = View.VISIBLE
        }
    }

    private fun startNewGame() {
        binding.newGameCard.setOnClickListener {
            val newGameIntent = Intent(this@MainActivity, GameActivity::class.java)
            startActivity(newGameIntent)
        }
    }

    private fun chapterSelectMenu() {
        binding.chapterSelectionCard.setOnClickListener {
            val chapterSelectionIntent = Intent(this@MainActivity, ChapterSelection::class.java)
            startActivity(chapterSelectionIntent)
        }
    }
}