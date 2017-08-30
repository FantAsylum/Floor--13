package com.floor13.game.actors

import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.graphics.g2d.Batch

import com.floor13.game.core.creatures.Creature
import com.floor13.game.TILE_SIZE

class CreatureActor(val creature: Creature): BaseActor() {

	val texture: TextureRegion = TODO() // TODO: get from atlas
	
	init {
		setBounds(
				creature.position.x * TILE_SIZE,
				creature.position.y * TILE_SIZE,
				TILE_SIZE,
				texture.regionHeight.toFloat()
		)
	}

	override fun draw(batch: Batch, parentAlpha: Float) =
		batch.draw(texture, x, y)
}
