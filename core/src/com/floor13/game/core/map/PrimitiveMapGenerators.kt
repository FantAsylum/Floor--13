package com.floor13.game.core.map

class EmptyMapGenerator(
        val width: Int,
        val height: Int
): MapGenerator {
    override fun generate() = Map(width, height)
}

class CrossMapGenerator(
        val width: Int,
        val height: Int
): MapGenerator {
    override fun generate(): Map {
        val map = Map(width, height)

        val mx = width / 2
        val my = height / 2

        // vertical lines
        map.fillRect(0..0, 0 until height, { Wall() })
        map.fillRect(mx..mx, 0 until height, { Wall() }) 
        map.fillRect(width - 1..width - 1, 0 until height, { Wall() })
        
        // horizontal line
        map.fillRect(0 until width, 0..0, { Wall() })
        map.fillRect(0 until width, my..my, { Wall() })
        map.fillRect(0 until width, height - 1..height - 1, { Wall() })
        
        // TODO: add doors
        map[mx, my / 2] = Door()
        map[mx, my + my / 2] = Door()
        map[mx / 2, my] = Door()
        map[mx + mx / 2, my] = Door()

        return map
    }
}
