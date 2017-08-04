package com.floor13.game
import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen
import com.floor13.game.core.MyStack
import com.floor13.game.core.screens.SplashScreen

class FloorMinus13(): ApplicationAdapter() {

    private val screenStack = MyStack<Screen>()

    override fun create() {
        val splashScreen = SplashScreen()
        screenStack.push(splashScreen)
    }

    override fun render () {
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
