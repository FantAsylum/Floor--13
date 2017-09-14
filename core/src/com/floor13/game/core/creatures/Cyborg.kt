package com.floor13.game.core.creatures

import com.floor13.game.core.Position
import com.floor13.game.core.map.Map
import com.floor13.game.core.map.getTilesWithIndices

class Cyborg(kindId: String, position: Position): Creature(kindId, position) {
    override val perception: Int
        get() = basePerception // TODO: perception classes, item bonuses
    override val connectivity: Int
        get() = baseConnectivity // TODO: connectivity classes, item bonuses
    override val intelligence: Int
        get() = baseIntelligence // TODO: item bonuses, hunger penalty (possibly)
    
    override val canSeeThroughWalls = false // TODO: possible - with sonar sight system
    
    override fun hit(damagePoints: Int) {
        // TODO: implement
    }
    // TODO: add function for hitting specified part

    override fun levelUp(level: Int) {
        attributePoints++
    }
	
	override fun calculateFieldOfView(map: Map): List<Position> {
		fun dist(x1: Int, y1: Int, x2: Int, y2: Int): Float {
			val x = x2 - x1
			val y = y2 - y1
			return x.toFloat() * x.toFloat() + y.toFloat() * y.toFloat()
		}
		// TODO: pick FOV calculation method basing on Sight System item
		//       of the cyborg and optimize
		return map.getTilesWithIndices()
				.filter { (x, y, tile) -> dist(x, y, position.x, position.y) < sightRange * sightRange }
				.map { Position(it.x, it.y) }
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
