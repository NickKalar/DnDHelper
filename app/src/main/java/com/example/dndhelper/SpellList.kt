package com.example.dndhelper


/*
 * Created by Nicholas Kalar on 6/1/21
 */


class SpellList(val name: String,
                val desc: String,
                val page: String,
                val spellRange: String,
                val components: String,
                val ritual: String,
                val duration: String,
                val concentration: String,
                val castingTime: String,
                val level: String,
                val school: String,
                val casterClass: String) {
    override fun toString(): String {
        return "Sheet(Spell name='$name', Spell level='$level', classes='$casterClass'"
    }
}