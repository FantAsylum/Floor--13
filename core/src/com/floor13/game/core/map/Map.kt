package com.floor13.game.core.map

import com.floor13.game.core.Item
import com.floor13.game.core.creatures.Creature
import com.floor13.game.core.Position

typealias Map = Array<Array<Tile>>

operator fun Map.get(position: Position) = this[position.x][position.y]

abstract class Tile(
        var creature: Creature? = null,
        val items: MutableList<Item> = mutableListOf()
)

class Ground: Tile()
class Wall: Tile()
class Door(var opened: Boolean = false): Tile()

val Map.width: Int
	get() = this.size
val Map.height: Int
	get() = this.get(0)?.size ?: 0
