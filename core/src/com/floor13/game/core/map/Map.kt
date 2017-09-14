package com.floor13.game.core.map

import com.floor13.game.core.Item
import com.floor13.game.core.creatures.Creature
import com.floor13.game.core.Position


class Map private constructor(val tiles: Array<Array<Tile>>) {
	constructor(width: Int, height: Int)
			: this(Array(width, { Array(height, { Ground() as Tile })}))

	val width: Int
		get() = tiles.size

	val height: Int
		get() = tiles.get(0)?.size ?: 0

	operator fun get(x: Int, y: Int) = tiles[x][y]
	operator fun get(position: Position) = tiles[position.x][position.y]

	operator fun set(x: Int, y: Int, tile: Tile) { tiles[x][y] = tile }
	operator fun set(position: Position, tile: Tile) { tiles[position.x][position.y] = tile }
	
	fun getTilesWithIndices() =
		tiles.withIndex().flatMap { (x, row) ->
			row.withIndex().map { (y, tile) ->
				TileWithIndices(x, y, tile)
			}
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
