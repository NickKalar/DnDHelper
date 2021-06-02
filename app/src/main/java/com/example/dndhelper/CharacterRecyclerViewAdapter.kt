package com.example.dndhelper

import android.graphics.drawable.Drawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


/*
 * Created by Nicholas Kalar on 3/12/21
 */


private const val TAG = "CharRecViewAdapter"

class CharacterRecyclerViewAdapter(private var charList: List<Sheet>) :
        RecyclerView.Adapter<CharacterRecyclerViewAdapter.CharacterViewHolder>() {

    class CharacterViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var classImage : ImageView = view.findViewById(R.id.classImg)
        var charName : TextView = view.findViewById(R.id.charNameSelect)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        // Called by layout manager when it needs a new view
        Log.d(TAG, ".onCreateViewHolder new view requested")
        val view = LayoutInflater.from(parent.context).inflate(R.layout.browse_character, parent, false)
        return CharacterViewHolder(view)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val charItem = charList[position]
        Log.d(TAG, ".onBindViewHolder: ${charItem.charName} --> $position")
        val image : Drawable = Drawable.createFromPath("drawable/cleric")!!
        holder.classImage.setImageDrawable(image)

        holder.charName.text = charItem.charName
     }

    override fun getItemCount(): Int {
        Log.d(TAG, ".getItemCount called")
        return if (charList.isNotEmpty()) charList.size else 0
    }

}