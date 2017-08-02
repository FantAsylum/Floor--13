package com.floor13.game.core.map

/**
 * @see <a href="http://www.roguebasin.com/index.php?title=Dungeon-Building_Algorithm">Dungeon-Building Algorithm</a>
 */
class TyrantLikeMapGanerator(
        val width: Int,
        val height: Int,
        val roomWidth: IntRange,
        val roomHeight: IntRange
): MapGenerator {
    override fun generate(): Map {
        //  1. Fill the whole map with solid earth 
        val map = Array(width, { Array(height, { Tile(TileType.WALL) }) })
        
        // 2. Dig out a single room in the centre of the map
        throw NotImplementedError()
    }
}
