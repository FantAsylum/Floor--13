package com.floor13.game.actors

import com.badlogic.gdx.scenes.scene2d.Actor
import com.badlogic.gdx.graphics.g2d.Batch

import com.floor13.game.FloorMinus13
import com.floor13.game.core.map.Map
import com.floor13.game.core.map.Door
import com.floor13.game.util.SidedTextureResolver
import com.floor13.game.texture
import com.floor13.game.TILE_SIZE

class MapActor(val map: Map): BaseActor() {

    // TODO: pick atlas basing on theme (bunker (1-4 lvl), lab (5-8) etc.)
    val textureResolver =
        SidedTextureResolver(
            FloorMinus13.getAtlas("graphics/terrain/level1/atlas.atlas"),
			map)

	val fogOfWarResolver =
		SidedTextureResolver(
				FloorMinus13.getAtlas("graphics/fow/atlas.atlas"),
				map.width,
				map.height,
				{ x1, y1, x2, y2 ->
					map.isExplored(x1, y1) == map.isExplored(x2, y2)
					// TODO: handle also invisibilty fog of war
				}
		)
				
	
    init {
        setBounds(
                0f,
                0f,
                map.width * TILE_SIZE,
                map.height * TILE_SIZE
        )
    }

    override fun draw(batch: Batch, parentAlpha: Float) {
        for (x in 0 until map.width) {
            for (y in 0 until map.height) {
                val tile = map[x, y]

                batch.draw(
                        textureResolver.getTexture(tile.texture, x, y),
                        x * TILE_SIZE,
                        y * TILE_SIZE
                )

				if (!map.isExplored(x, y))
					batch.draw(
							fogOfWarResolver.getTexture(UNEXPLORED_TEXTURE_NAME, x, y),
							x * TILE_SIZE,
							y * TILE_SIZE
					)

				// TODO: handle also insibility fog of war
                // TODO: drawing creature (if present)
                // TODO: drawing items (if present)
            }
        }
    }

	companion object {
		val UNEXPLORED_TEXTURE_NAME = "unexplored"
	}
}
