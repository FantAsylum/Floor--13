package com.floor13.game.util

import com.badlogic.gdx.graphics.g2d.TextureAtlas
import com.badlogic.gdx.graphics.g2d.TextureRegion

import ktx.collections.*

import com.floor13.game.core.map.Map

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

            val type = map[x][y].type
        
            // order convention: urld
            if (y == 0 || map[x][y - 1].type == type)
                suffix.append('u')
            if (x == map.size - 1 || map[x + 1][y].type == type)
                suffix.append('r')
            if (x == 0 || map[x - 1][y].type == type)
                suffix.append('l')
            if (y == (map.getOrNull(0)?.size ?: 0) - 1 || map[x][y + 1].type == type)
                suffix.append('d')

            val exactName = "${name}_${suffix}"
            val genericName = "${name}_a"

            variants.clear()
            for (region in atlas.getRegions())
                if (region.name == exactName || region.name == genericName)
                    variants.add(region)

            cache[x][y] = variants.random()
            System.out.println("${cache[x][y]}")
            cache[x][y]!!
        }()
    }
}
