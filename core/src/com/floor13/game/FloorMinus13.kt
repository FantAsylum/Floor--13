package com.floor13.game
import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen
import com.floor13.game.util.MyStack
import com.floor13.game.screens.SplashScreen

object FloorMinus13: ApplicationAdapter() {

    private val screenStack = MyStack<Screen>()

    override fun create() {
        val splashScreen = SplashScreen()
        screenStack.push(splashScreen)
    }

    override fun render () {
        Gdx.gl.glClearColor(0f, 0f, 0f, 0f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        screenStack.peek()?.render(Gdx.graphics.deltaTime)
    }

    fun removeScreen() {
        screenStack.pop()
    }

    fun replaceScreen(screen : Screen) {
        screenStack.pop()
        screenStack.push(screen)
    }

    fun pushScreen(screen : Screen) {
        screenStack.push(screen)
    }
}
