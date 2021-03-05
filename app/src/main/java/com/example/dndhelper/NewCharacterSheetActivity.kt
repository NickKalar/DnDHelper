package com.example.dndhelper

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.dndhelper.databinding.ActivityNewCharacterSheetBinding

private const val TAG = "NewCharacterSheet"

class NewCharacterSheetActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNewCharacterSheetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate called")

        binding = ActivityNewCharacterSheetBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}