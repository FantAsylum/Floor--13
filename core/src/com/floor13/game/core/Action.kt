package com.floor13.game.core

interface Action {
    val energyCost: Int
    
    fun apply()
} 
