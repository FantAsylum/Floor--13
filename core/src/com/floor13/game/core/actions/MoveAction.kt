package com.floor13.game.core.actions

import com.floor13.game.core.map.width
import com.floor13.game.core.map.height
import com.floor13.game.core.creatures.Creature
import com.floor13.game.core.Position
import com.floor13.game.core.World

class MoveAction(val world: World, val creature: Creature, val newPosition: Position): Action {
    override val energyCost = 10 // TODO: change hardcode with complex calculation

	override val isValid: Boolean
		get() =
			newPosition adjacentTo creature.position &&
			newPosition.withinBounds(world.map.width, world.map.height)
			
    
    override fun apply() {
		// TODO: implement
	}
} 
