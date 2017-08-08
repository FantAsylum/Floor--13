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
        map.fillRect(
                width / 2,
                height / 2,
                roomWidth.random,
                roomHeight.random,
                TileType.GROUND)

        // 3. Pick a wall of any room 
                map.tiles().find { (_
                , _, tile) -> tile.type == TileType.WALL }
        throw NotImplementedError()
    }

    // private val features = arrayOf(
    //         { x: Int, y: Int, direction: Direction -> // Room
    //             data class Measurements(
    //                     val xs: IntRange,
    //                     val ys: IntRange)
    //             val measurments = when direction {
    //                 Direction.UP -> Measurements(
    //                         Math.max(0, x - roomWidth.endInclusive) ..
    //                         Math.min(width - 1, x + roomWidth.endInclusive),
    //                         0,
    //                 }
    //             }
    //     )
}
