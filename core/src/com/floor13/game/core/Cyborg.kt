package com.floor13.game.core

class Cyborg(
        val name: String,
        // TODO: replace item types with concrete classes
        var neuralSystem: Item,
        var perceptionSystem: Item,
        var armor: Item?,
        var skull: Item?,
        var battery: Item?,
        var arms: Item?,
        var legs: Item?,
        val inventory: MutableList<Item> = mutableListOf()
)
