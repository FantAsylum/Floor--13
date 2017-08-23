package com.floor13.game.util

import com.badlogic.gdx.graphics.g2d.TextureAtlas
import com.badlogic.gdx.graphics.g2d.TextureRegion

import ktx.collections.*

import com.floor13.game.core.map.Map
import com.floor13.game.core.map.Tile
import com.floor13.game.core.map.Ground
import com.floor13.game.core.map.Wall
import com.floor13.game.core.map.Door

/**
 * @param atlas atlas for resolving textures
 */
class SidedTextureResolver(
        private val atlas: TextureAtlas,
        private val map: Map
) {
    private val cache: Array<Array<TextureRegion?>> = Array(
            map.size,
            { Array(map.getOrNull(0)?.size ?: 0, { null as TextureRegion? })}
    )

    private val variants = gdxArrayOf<TextureRegion>()
    
    fun getTexture(name: String, x: Int, y: Int): TextureRegion {
        return cache[x][y] ?: {
            val suffix = StringBuilder()

            val tile = map[x][y]
        
            // order convention: urld
            if (y == (map.getOrNull(0)?.size ?: 0) - 1 || map[x][y + 1] sameTileTypeAs tile)
                suffix.append('u')
            if (x == map.size - 1 || map[x + 1][y] sameTileTypeAs tile)
                suffix.append('r')
            if (x == 0 || map[x - 1][y] sameTileTypeAs tile)
                suffix.append('l')
            if (y == 0 || map[x][y - 1] sameTileTypeAs tile)
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

    private infix fun Tile.sameTileTypeAs(tile: Tile): Boolean {
        // review this solution if you added additional Tile types
        return this is Ground && tile is Ground || (!(this is Ground) && !(tile is Ground))
    }
}
