package com.floor13.game.core.map

typealias Map = Array<Array<Tile>>
data class Tile(val type: TileType)

enum class TileType {
    GROUND,
    WALL,
}
