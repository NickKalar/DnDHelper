package com.example.dndhelper

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dndhelper.databinding.ActivitySpellListBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONException
import org.json.JSONObject
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.net.MalformedURLException
import java.net.URL

private const val TAG = "SpellListActivity"

class SpellListActivity : AppCompatActivity(),
        RecyclerItemClickListener.OnRecyclerClickListener {
    private lateinit var binding: ActivitySpellListBinding

    private val spellListRecyclerViewAdapter = SpellListRecyclerViewAdapter(ArrayList())

    private lateinit var list: List<SpellList>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySpellListBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val recyclerView = findViewById<RecyclerView>(R.id.spellRecyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addOnItemTouchListener((RecyclerItemClickListener(this, recyclerView, this)))
        recyclerView.adapter = spellListRecyclerViewAdapter

        val url : URL? = try{
            URL("https://www.kalar.codes/static/js/spelllist2.json")
        }catch (e:MalformedURLException){
            Log.d(TAG, e.toString())
            null
        }
        Log.d(TAG, url.toString())

        lifecycleScope.launch(Dispatchers.IO){
            url?.getString()?.apply {

                withContext(Dispatchers.Default){
                    list = parseJson(this@apply)

                    withContext(Dispatchers.Main){
                        Log.d(TAG, "url tostring ${list[0].name}")
                        Log.d(TAG, "url tostring ${list[409].name}")
                        spellListRecyclerViewAdapter.loadNewData(list)
                    }
                }
            }
        }
    }

    override fun onItemClick(view: View, position: Int) {
        Log.d(TAG, ".onItemClick: starts")
    }

    override fun onItemLongClick(view: View, position: Int) {
        Log.d(TAG, ".onItemLongClick: starts")
    }
}

fun URL.getString(): String {
    val stream = openStream()
    return try {
        val r = BufferedReader(InputStreamReader(stream))
        val result = StringBuilder()
        var line: String?
        while (r.readLine().also { line = it } != null) {
            result.append(line).appendln()
        }
        result.toString()
    } catch (e: IOException){
        e.toString()
    }
}

fun parseJson(data : String) : List<SpellList>{
    val list = mutableListOf<SpellList>()

    try {
        val array = JSONObject(data).getJSONArray("spells")
        Log.d(TAG, array.length().toString())
        for(i in 0 until array.length()){
            val obj = JSONObject(array[i].toString())
            val name = obj.getString("name")
            val desc = obj.getString("desc")
            val page = obj.getString("page")
            val spellRange = obj.getString("range")
            val components = obj.getString("components")
            val ritual = obj.getString("ritual")
            val duration = obj.getString("duration")
            val concentration = obj.getString("concentration")
            val castingTime = obj.getString("casting_time")
            val level = obj.getString("level")
            val school = obj.getString("school")
            val casterClass = obj.getString("class")
            list.add(SpellList(name, desc, page, spellRange, components, ritual, duration,
                    concentration, castingTime, level, school, casterClass))
        }
    }catch (e : JSONException) {
        Log.d("Exception", e.toString())
    }

//    Log.d(TAG, list[0].toString())
    return list
}
