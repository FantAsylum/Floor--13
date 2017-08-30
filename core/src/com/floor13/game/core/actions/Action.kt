package com.floor13.game.core.actions

import com.floor13.game.core.World

interface Action {
    val energyCost: Int
    
    fun apply(world: World)
} 
