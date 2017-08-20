package com.floor13.game

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen
import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.graphics.g2d.TextureAtlas

import com.floor13.game.util.MyStack
import com.floor13.game.screens.SplashScreen

object FloorMinus13: ApplicationAdapter() {

    private val assetManager = AssetManager()
    private val screenStack = MyStack<Screen>()

    override fun create() {
        setResourcesToBeLoaded()
        val splashScreen = SplashScreen(assetManager)
        screenStack.push(splashScreen)
    }

    override fun render() {
        Gdx.gl.glClearColor(0f, 0f, 0f, 0f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        screenStack.peek()?.render(Gdx.graphics.deltaTime)
    }

    override fun dispose() {
        assetManager.dispose()
    }

    fun getTexture(atlas: String, name: String): TextureAtlas.AtlasRegion {
        return assetManager.get<TextureAtlas>(atlas).findRegion(name)
    }

    fun removeScreen() {
        screenStack.pop()?.dispose()
    }

    fun replaceScreen(screen : Screen) {
        screenStack.pop()?.dispose()
        screenStack.push(screen)
    }

    fun pushScreen(screen : Screen) {
        screenStack.push(screen)
    }

    private fun setResourcesToBeLoaded() {
        assetManager.apply {
            load("graphics/terrain/level1/atlas.atlas", TextureAtlas::class.java)
        }
    }
}
