package com.example.dndhelper


/*
 * Created by Nicholas Kalar on 3/12/21
 */


class Sheet(val playerName: String, val charName: String, val charClass: String) {
    override fun toString(): String {
        return "Sheet(playerName='$playerName', charName='$charName', charClass='$charClass'"
    }
}