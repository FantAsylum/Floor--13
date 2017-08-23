package com.floor13.game

import com.floor13.game.core.map.Tile
import com.floor13.game.core.map.Ground
import com.floor13.game.core.map.Wall
import com.floor13.game.core.map.Door

val Tile.texture: String
    get() = when(this) {
        is Ground -> "floor"
        is Wall -> "wall"
        is Door -> "door"
        else -> throw RuntimeException("Invalid tile")
    }

