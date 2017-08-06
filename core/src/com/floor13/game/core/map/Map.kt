package com.floor13.game.core.map

typealias Map = Array<Array<Tile>>
data class Tile(val type: TileType)
data class TileWithIndices(val x: Int, val y: Int, val tile: Tile)

enum class TileType {
    GROUND,
    WALL,
}

fun Map.tiles(): Iterable<TileWithIndices> {
    return object : Iterable<TileWithIndices> {
        override fun iterator() =
            object: Iterator<TileWithIndices> {
                var x = 0
                var y = 0
                
                override fun hasNext() =
                    when {
                        x < size -> true
                        y < get(0).size - 1 -> {
                            x = 0
                            y += 1
                            true
                        }
                        else -> false
                    }

                override fun next(): TileWithIndices {
                    return TileWithIndices(x, y, get(x).get(y))      
                } 
            }
    }
}
