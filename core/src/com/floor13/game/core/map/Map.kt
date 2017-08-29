package com.floor13.game.core.map

import com.floor13.game.core.Item
import com.floor13.game.core.creatures.Creature

typealias Map = Array<Array<Tile>>

abstract class Tile(
        var creature: Creature? = null,
        val items: MutableList<Item> = mutableListOf()
)

class Ground: Tile()
class Wall: Tile()
class Door(var opened: Boolean = false): Tile()
