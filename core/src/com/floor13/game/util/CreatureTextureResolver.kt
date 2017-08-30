package com.floo13.game.util

import java.util.regex.Pattern

import com.badlogic.gdx.graphics.g2d.TextureAtlas
import com.badlogic.gdx.graphics.g2d.TextureRegion

import com.floor13.game.FloorMinus13
import com.floor13.game.CREATURE_ATLAS_PATH

object CreatureTextureResolver {

	// example: player:cyborg_cyborg_mercenary2
	// first group - id (for example: "player:")
	// second group - type
	// third group - name
	// fifth group (inside forth) - kind
	val kindIdPattern = Pattern.compile("(\\w+:)?([a-z]+)_([a-z_]+)(_(\\d+))?")
	val atlas: TextureAtlas
		get() = FloorMinus13.getAtlas(CREATURE_ATLAS_PATH)

	fun getTexture(kindId: String): TextureRegion {
		val m = kindIdPattern.matcher(kindId)
		if (m.matches()) {
			val type = m.group(2)
			val name = m.group(3)
			val kind = Integer.parseInt(m.group(5))
			val textureName = "${type}/${name}_kind${kind}"
	
			return atlas.findRegion(textureName)
		} else {
			throw RuntimeException("Invalid kind id")
		}
	}
}
