package com.floor13.game.core.actions

import com.floor13.game.core.creatures.Creature
import com.floor13.game.core.Position
import com.floor13.game.core.World

class MoveAction(
		world: World,
		val creature: Creature,
		val newPosition: Position
): Action {
    override val energyCost = 10 // TODO: change hardcode with complex calculation

	private val map = world.floors[creature.floor]

	override val isValid: Boolean
		get() =
			newPosition adjacentTo creature.position &&
			newPosition.withinBounds(map.width, map.height) &&
			map[newPosition].isPassable
			
    
    override fun apply() {
		assert(isValid)
		map[creature.position].creature = null
		map[newPosition].creature = creature
		creature.position = newPosition
	}
} 
