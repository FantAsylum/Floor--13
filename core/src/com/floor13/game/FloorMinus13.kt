package com.floor13.game
import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen
import com.floor13.game.core.MyStack
import com.floor13.game.core.screens.SplashScreen

class FloorMinus13(): ApplicationAdapter() {

    private var screenList : MutableList<Screen> = arrayListOf()
    private val screenStack = MyStack<Screen>(screenList)

    override fun create() {
        val splashScreen = SplashScreen()
        screenStack.push(splashScreen)
    }

    override fun render () {
        screenStack.peek()?.render(Gdx.graphics.deltaTime)
    }

    fun popScreenList() : Screen? {
        return screenStack.pop()
    }

    fun peekScreenList() : Screen? {
        return screenStack.peek()
    }

    fun pushScreenList(screen : Screen) {
        screenStack.push(screen)
    }
}
