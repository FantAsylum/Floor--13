package com.floor13.game

import com.floor13.game.core.map.Tile
import com.floor13.game.core.map.Ground
import com.floor13.game.core.map.Wall

val Tile.texture: String
    get() = when(this) {
        is Ground -> "floor"
        is Wall -> "wall"
        else -> throw RuntimeException("Invalid tile")
    }

