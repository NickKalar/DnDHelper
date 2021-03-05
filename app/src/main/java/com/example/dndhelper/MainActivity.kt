package com.example.dndhelper

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import com.example.dndhelper.databinding.ActivityMainBinding
import java.lang.IllegalArgumentException

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.characterSelect.setOnClickListener(this)
        binding.spellList.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        val intent = when (view.id) {
            R.id.characterSelect -> Intent(this, CharactersActivity::class.java)
            R.id.spellList -> Intent(this, SpellListActivity::class.java)
            else -> throw IllegalArgumentException("Undefined buttonClicked")
        }
        startActivity(intent)
    }
}