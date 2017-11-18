package com.floor13.game.core.actions

import com.floor13.game.core.creatures.Creature
import com.floor13.game.core.Position
import com.floor13.game.core.World
import com.floor13.game.core.map.Door

class OpenDoorAction(
        world: World,
        val creature: Creature,
        val doorPosition: Position
): Action {
    override val energyCost = 0

    private val map = world.floors[creature.floor]

    override val isValid: Boolean
        get() {
            val tile = map[doorPosition]
            return tile is Door &&
                   !tile.opened &&
                   creature.position adjacentTo doorPosition
        }


    override fun apply() {
        assert(isValid)
        (map[doorPosition] as Door).opened = true
    }
}
