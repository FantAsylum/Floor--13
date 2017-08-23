package com.floor13.game.screens

import com.badlogic.gdx.ScreenAdapter

import com.floor13.game.FloorMinus13
import com.floor13.game.core.World
import com.floor13.game.core.map.Map
import com.floor13.game.core.map.MapGenerator
import com.floor13.game.core.map.CrossMapGenerator

class MainMenuScreen : ScreenAdapter() {
    val generator = CrossMapGenerator(11, 11) // FIXME: stub logic
    
    init {
        // TODO: make UI setup here
    }
    
    override fun render(delta: Float) {
        // TODO: remove and replace with actual rendering logic
        FloorMinus13.pushScreen(GameScreen(World(generator.generate())))
    }
}
