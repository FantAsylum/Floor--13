package com.floor13.game.core

typealias Map = Array<Array<Tile>>
data class Tile(val type: TileType)

enum class TileType {
    GROUND,
    WALL,
}
