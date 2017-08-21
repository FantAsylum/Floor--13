package com.floor13.game.core.map

class EmptyMapGenerator(
        val width: Int,
        val height: Int
): MapGenerator {
    override fun generate(): Map {
        return Array(
                width,
                { Array(height, { Tile(TileType.GROUND) }) }
        )
    }
}
