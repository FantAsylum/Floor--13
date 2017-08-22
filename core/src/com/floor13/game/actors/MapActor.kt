package com.floor13.game.actors

import com.badlogic.gdx.scenes.scene2d.Actor
import com.badlogic.gdx.graphics.g2d.Batch

import com.floor13.game.FloorMinus13
import com.floor13.game.core.map.Map
import com.floor13.game.util.SidedTextureResolver
import com.floor13.game.texture

class MapActor(val map: Map): BaseActor() {

    // TODO: pick atlas basing on theme (bunker (1-4 lvl), lab (5-8) etc.)
    val textureResolver =
        SidedTextureResolver(
            FloorMinus13.getAtlas("graphics/terrain/level1/atlas.atlas"), map)
    
    init {
        setBounds(
                0f,
                0f,
                map.size * TILE_SIZE,
                (map.getOrNull(0)?.size ?: 0) * TILE_SIZE
        )
    }

    override fun draw(batch: Batch, parentAlpha: Float) {
        for (x in 0 until map.size) {
            for (y in 0 until map[x].size) {
                val tile = map[x][y]
                batch.draw(
                        textureResolver.getTexture(tile.texture, x, y),
                        x * TILE_SIZE,
                        y * TILE_SIZE
                )
                // TODO: drawing tile based on type
                // TODO: drawing creature (if present)
                // TODO: drawing items (if present)
            }
        }
    }

    companion object {
        val TILE_SIZE = 64f
    }
}
