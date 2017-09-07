package com.floor13.game.core.actions

import com.floor13.game.core.World

interface Action {
    val energyCost: Int
	val isValid: Boolean
    
    fun apply()
	
} 
