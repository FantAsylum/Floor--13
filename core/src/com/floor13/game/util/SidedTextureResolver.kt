package com.floor13.game.util

import com.badlogic.gdx.graphics.g2d.TextureAtlas
import com.badlogic.gdx.graphics.g2d.TextureRegion

import ktx.collections.*

import com.floor13.game.core.map.Map
import com.floor13.game.core.map.width
import com.floor13.game.core.map.height
import com.floor13.game.core.map.Tile
import com.floor13.game.core.map.Ground
import com.floor13.game.core.map.Wall
import com.floor13.game.core.map.Door

/**
 * @param atlas atlas for resolving textures
 */
class SidedTextureResolver(
        private val atlas: TextureAtlas,
		private val width: Int,
		private val height: Int,
		private val isSameTexture: (Int, Int, Int, Int) -> Boolean
) {

    private val cache: Array<Array<TextureRegion?>> = Array(
            width,
            { Array(height, { null as TextureRegion? })}
    )

    private val variants = gdxArrayOf<TextureRegion>()

	constructor(atlas: TextureAtlas, map: Map)
			: this(
			atlas,
			map.width,
			map.height,
			{ x1, y1, x2, y2 -> map[x1][y1] sameTileTypeAs map[x2][y2] }
	)
	
    fun getTexture(name: String, x: Int, y: Int): TextureRegion {
        return cache[x][y] ?: {
            val suffix = StringBuilder()

            // order convention: urld
            if (y == height - 1 || isSameTexture(x, y + 1, x, y))
                suffix.append('u')
            if (x == width - 1 || isSameTexture(x + 1, y, x, y))
                suffix.append('r')
            if (x == 0 || isSameTexture(x - 1, y, x, y))
                suffix.append('l')
            if (y == 0 || isSameTexture(x, y - 1, x, y))
                suffix.append('d')

            val exactName = "${name}_${suffix}"
            val genericName = "${name}_a"

            variants.clear()
            for (region in atlas.getRegions())
                if (region.name == exactName || region.name == genericName)
                    variants.add(region)

            cache[x][y] = variants.random()
            cache[x][y]!!
        }()
    }

	companion object {
		private infix fun Tile.sameTileTypeAs(tile: Tile): Boolean {
			// review this solution if you added additional Tile types
			return this is Ground && tile is Ground || (!(this is Ground) && !(tile is Ground))
		}
	}

}
