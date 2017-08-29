package com.floor13.game.core.creatures

import com.floor13.game.core.Position

class Cyborg(kindId: String, position: Position): Creature(kindId, position) {
    override val perception: Int
        get() = basePerception // TODO: perception classes, item bonuses
    override val connectivity: Int
        get() = baseConnectivity // TODO: connectivity classes, item bonuses
    override val intelligence: Int
        get() = baseIntelligence // TODO: item bonuses, hunger penalty (possibly)
    
    override val canSeeThroughWalls = false // TODO: possible - with sonar sight system
    override val isAlive: Boolean = true // TODO: replace stub
    
    override fun hit(damagePoints: Int) {
        // TODO: implement
    }
    // TODO: add function for hitting specified part

    override fun levelUp(level: Int) {
        attributePoints++
    }

    var basePerception: Int = 0
        private set
    var baseConnectivity: Int = 0
        private set
    var baseIntelligence: Int = 0
        private set

    var attributePoints: Int = 0
        private set

    /**
    * Increase intelligence using one attribute point
    * @return true - if succeded, false - if cyborg has no attribute points
    */
    fun increasePerception(): Boolean {
        if (attributePoints > 0) {
            attributePoints--
            basePerception++
            return true
        }
        return false
    }

    /**
    * Increase intelligence using one attribute point
    * @return true - if succeded, false - if cyborg has no attribute points
    */
    fun increaseConnectivity(): Boolean {
        if (attributePoints > 0) {
            attributePoints--
            baseConnectivity++
            return true
        }
        return false
    }

    /**
    * Increase intelligence using one attribute point
    * @return true - if succeded, false - if cyborg has no attribute points
    */
    fun increaseIntelligence(): Boolean {
        if (attributePoints > 0) {
            attributePoints--
            baseIntelligence++
            return true
        }
        return false
    }
}
