package com.floor13.game.actors

import com.badlogic.gdx.scenes.scene2d.Actor
import com.badlogic.gdx.graphics.g2d.Batch

import com.floor13.game.core.map.Map

class MapActor(val map: Map): BaseActor() {

    init {
        setBounds(
                0f,
                0f,
                (map.size * TILE_SIZE).toFloat(),
                ((map.getOrNull(0)?.size ?: 0) * TILE_SIZE).toFloat())
    }

    override fun draw(batch: Batch, parentAlpha: Float) {
        for (x in 0..map.size) {
            for (y in 0..map[x].size) {
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
