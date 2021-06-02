package com.example.dndhelper

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.*
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

class SpellListActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySpellListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySpellListBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

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
                    val list = parseJson(this@apply)

                    withContext(Dispatchers.Main){
                        Log.d(TAG, "url tostring ${list[0].name}")
                    }
                }
            }
        }
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
