package com.floor13.game.core.creatures

import com.floor13.game.core.Action
import com.floor13.game.core.Position

abstract class Creature(
        val kindId: String,
        var position: Position,
        var xp: Int = 0,
        var energyPoints: Int = 0,
        var nextAction: Action? = null
) {
    abstract val perception: Int
    abstract val connectivity: Int
    abstract val intelligence: Int
    
    abstract val canSeeThroughWalls: Boolean
    abstract val isAlive: Boolean
    
    /**
    * Hit creature with specified damage
    */
    abstract fun hit(damagePoints: Int)
    // TODO: add function for hitting specified part

    abstract fun levelUp(level: Int)
            
    open val speed: Int
        get() = BASIC_SPEED + connectivity * SPEED_PER_CONNECTIVITY
    
    open val sightRange: Int
        get() = (perception * SIGHT_PER_PERCEPTION).toInt()

    val xpModifier: Float
        get() = 1 + intelligence * XP_MODIFIER_PER_INTELLIGENCE

    
    fun addXp(xp: Int) {
        this.xp += xp
        // TODO: check for level up
    }
     
    companion object Creature {
        val BASIC_SPEED = 50
        val SPEED_PER_CONNECTIVITY = 10
        val SIGHT_PER_PERCEPTION = 0.5f
        val XP_MODIFIER_PER_INTELLIGENCE = 0.1f
    }
}
