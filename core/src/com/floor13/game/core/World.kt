package com.floor13.game.core

import com.floor13.game.core.map.Map
import com.floor13.game.core.map.Tile
import com.floor13.game.core.creatures.Creature

class World(
        val map: Map,
        val creatures: MutableList<Creature> = mutableListOf()
) {
    
    fun tick(): List<Action> {
        val appliedActions = mutableListOf<Action>()
        for (creature in creatures) {
            creature.energyPoints += ENERGY_PER_TICK
            creature.nextAction?.let {
                if (it.energyCost < creature.energyPoints) {
                    it.apply()
                    creature.energyPoints -= it.energyCost
                    appliedActions.add(it)
                }
            }
        }
        return appliedActions
    }

    companion object {
        val ENERGY_PER_TICK = 10
    }
}
