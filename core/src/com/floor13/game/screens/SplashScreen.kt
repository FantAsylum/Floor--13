package com.floor13.game.screens

import com.badlogic.gdx.ScreenAdapter
import com.badlogic.gdx.assets.AssetManager

import com.floor13.game.FloorMinus13

class SplashScreen(val assetManager: AssetManager) : ScreenAdapter() {
    override fun render(deltaTime: Float) {
        if (assetManager.update()) {
            FloorMinus13.replaceScreen(MainMenuScreen())
        }
        // loading...
    }
}
