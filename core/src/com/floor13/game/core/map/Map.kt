package com.floor13.game.core.map

import com.floor13.game.core.Item
import com.floor13.game.core.creatures.Creature
import com.floor13.game.core.Position

typealias Map = Array<Array<Tile>>

operator fun Map.get(position: Position) = this[position.x][position.y]

val Map.width: Int
	get() = this.size
val Map.height: Int
	get() = this.get(0)?.size ?: 0

fun Map.getTilesWithIndices() =
	this.withIndex().flatMap { (x, row) ->
		row.withIndex().map { (y, tile) ->
			TileWithIndices(x, y, tile)
		}
	}


data class TileWithIndices(val x: Int, val y: Int, val tile: Tile)

abstract class Tile(
        var creature: Creature? = null,
        val items: MutableList<Item> = mutableListOf()
) {
	open val isPassable = creature == null
}

class Ground: Tile()
class Wall: Tile() {
	override val isPassable = false
}

class Door(var opened: Boolean = false): Tile() {
	override val isPassable = opened && super.isPassable
}
