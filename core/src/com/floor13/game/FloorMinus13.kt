package com.floor13.game
import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Screen
import com.floor13.game.core.MyStack
import com.floor13.game.core.screens.GameScreen
import com.floor13.game.core.screens.InventoryScreen
import com.floor13.game.core.screens.MainMenuScreen

class FloorMinus13(): ApplicationAdapter() {

    private val mainMenuScreen = MainMenuScreen()
    private val gameScreen = GameScreen()
    private val inventoryScreen = InventoryScreen()
    private var screenList : MutableList<Screen> = arrayListOf()
    private val screenStack = MyStack<Screen>(screenList)
    private var fpsRate = 1f/60f

    override fun create() {
        screenStack.push(inventoryScreen)
        screenStack.push(gameScreen)
        screenStack.push(mainMenuScreen)
    }

    override fun render () {
        screenStack.peek()?.render(fpsRate)
    }

}
