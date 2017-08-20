package com.floor13.game.screens

import com.badlogic.gdx.ScreenAdapter

import com.floor13.game.FloorMinus13

class MainMenuScreen : ScreenAdapter() {

    init {
        // TODO: make UI setup here
    }
    
    override fun render(delta: Float) {
        // TODO: remove and replace with actual rendering logic
        FloorMinus13.pushScreen(GameScreen())
    }
}
