package com.floor13.game.core.map

class EmptyMapGenerator(
        val width: Int,
        val height: Int
): MapGenerator {
    override fun generate(): Map {
        return Array(
                width,
                { Array(height, { Ground() as Tile }) }
        )
    }
}

class CrossMapGenerator(
        val width: Int,
        val height: Int
): MapGenerator {
    override fun generate(): Map {
        val map = Array(width, { Array(height, { Ground() as Tile })})

        val mx = width / 2
        val my = height / 2

        map.fillRect(mx..mx, 0 until height, { Wall() }) // vertical line
        map.fillRect(0 until width, my..my, { Wall() }) // horizontal line

        // TODO: add doors

        return map
    }
}
