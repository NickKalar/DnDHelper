package com.example.dndhelper

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.dndhelper.databinding.ActivityCharactersBinding
import com.google.android.material.snackbar.Snackbar

private const val TAG = "CharactersActivity"

class CharactersActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCharactersBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharactersBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val fab: View = findViewById(R.id.btnAddChar)

        fab.setOnClickListener{ v ->
            val intent = Intent(this, NewCharacterSheetActivity::class.java)
            startActivity(intent)
        }
    }
}