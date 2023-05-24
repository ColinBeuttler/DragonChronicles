package com.colinbeuttler.dragonchronicles

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.colinbeuttler.dragonchronicles.databinding.GameActivityBackgroundBinding

class GameActivity : AppCompatActivity() {

    private lateinit var binding: GameActivityBackgroundBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = GameActivityBackgroundBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        loadDialog()
        binding.titleScreenBackgroundView.setOnClickListener(View.OnClickListener { binding.titleScreenBackgroundView.visibility =
            View.GONE })
    }

//    private fun loadDialog() {
//        supportFragmentManager.beginTransaction()
//            .add(R.id.dialog_fragment, DialogFragment::class.java, null).commit()
//    }
}