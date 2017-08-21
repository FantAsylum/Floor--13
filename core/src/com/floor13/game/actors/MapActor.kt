package com.floor13.game.actors

import com.badlogic.gdx.scenes.scene2d.Actor
import com.badlogic.gdx.graphics.g2d.Batch

import com.floor13.game.FloorMinus13
import com.floor13.game.core.map.Map

class MapActor(val map: Map): BaseActor() {

    // TODO: pick atlas basing on theme (bunker (1-4 lvl), lab (5-8) etc.)
    val atlas = FloorMinus13.getAtlas("graphics/terrain/level1/atlas.atlas")
    
    init {
        setBounds(
                0f,
                0f,
                (map.size * TILE_SIZE).toFloat(),
                ((map.getOrNull(0)?.size ?: 0) * TILE_SIZE).toFloat())
    }

    override fun draw(batch: Batch, parentAlpha: Float) {
        for (x in 0 until map.size) {
            for (y in 0 until map[x].size) {
                val tile = map[x][y]
                // TODO: drawing tile based on type
                // TODO: drawing creature (if present)
                // TODO: drawing items (if present)
            }
        }
    }

    companion object {
        val TILE_SIZE = 64
    }
}
