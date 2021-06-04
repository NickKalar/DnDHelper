package com.example.dndhelper

import android.graphics.drawable.Drawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


/*
 * Created by Nicholas Kalar on 6/1/21
 */

private const val TAG = "SpellListRecycle"

class SpellViewHolder(view: View) : RecyclerView.ViewHolder(view){
    var spellName : TextView = view.findViewById(R.id.spellName)
    var spellLevel : TextView = view.findViewById(R.id.spellLevel)
    var spellClasses : TextView = view.findViewById(R.id.spellClasses)
}

class SpellListRecyclerViewAdapter(private var spellList: List<SpellList>) :
        RecyclerView.Adapter<SpellViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpellViewHolder {
        // Called by layout manager when it needs a new view
//        Log.d(TAG, ".onCreateViewHolder new view requested")
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.browse_spells, parent, false)
        return SpellViewHolder(view)
    }

    override fun onBindViewHolder(holder: SpellViewHolder, position: Int) {
        val spellItem = spellList[position]
//        Log.d(TAG, ".onBindViewHolder: ${spellItem.name} --> $position")
//        val image : Drawable = Drawable.createFromPath("drawable/cleric")!!

        holder.spellName.text = spellItem.name
        holder.spellLevel.text = spellItem.level
        holder.spellClasses.text = spellItem.casterClass
    }

    override fun getItemCount(): Int {
//        Log.d(TAG, ".getItemCount called")
        return if (spellList.isNotEmpty()) spellList.size else 0
    }

    fun loadNewData(newSpells: List<SpellList>){
        spellList = newSpells
        notifyDataSetChanged()
    }
}
