package com.floor13.game.core.actions

import com.floor13.game.core.creatures.Creature
import com.floor13.game.core.Position
import com.floor13.game.core.World

class MoveAction(val creature: Creature, val newPosition: Position) {
    val energyCost = 10 // TODO: change hardcode with complex calculation
    
    fun apply(world: World) {
		// TODO: implement
	}
} 
