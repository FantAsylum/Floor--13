package com.floor13.game

import com.floor13.game.core.map.Tile
import com.floor13.game.core.map.TileType

val TileType.texture: String
    get() = when(this) {
        TileType.GROUND -> "floor"
        TileType.WALL -> "wall"
    }

val Tile.texture: String
    get() = this.type.texture
