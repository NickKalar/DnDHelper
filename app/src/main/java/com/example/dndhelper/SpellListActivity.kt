package com.example.dndhelper

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.dndhelper.databinding.ActivitySpellListBinding

private const val TAG = "SpellListActivity"

class SpellListActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySpellListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = layoutInflater.inflate(R.layout.activity_spell_list, null) as ConstraintLayout
        setContentView(layout)

    }
}