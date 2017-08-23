package com.floor13.game.screens

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.ScreenAdapter
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.utils.viewport.ExtendViewport
import com.badlogic.gdx.InputMultiplexer
import com.badlogic.gdx.InputAdapter

import com.floor13.game.core.World
import com.floor13.game.actors.MapActor

class GameScreen(world: World) : ScreenAdapter() {
    val levelStage = Stage(ExtendViewport(
            Gdx.graphics.width.toFloat(),
            Gdx.graphics.height.toFloat()
    ))
    val hudStage = Stage() // TODO: pick viewport

    val mapScroller = object: InputAdapter() {
        var x = 0
        var y = 0
        
        override fun touchDown(x: Int, y: Int, pointer: Int, button: Int): Boolean {
            this.x = x
            this.y = y
            return true
        }

        override fun touchDragged(x: Int, y: Int, pointer: Int): Boolean {
            val dx = this.x - x
            val dy = this.y - y
            this.x = x
            this.y = y
            levelStage.camera.translate(dx.toFloat(), -dy.toFloat(), 0f)
            return true
        }
    }

    init {
        levelStage.addActor(MapActor(world.map))

        Gdx.input.inputProcessor = InputMultiplexer(
                mapScroller
        )
    }
    
    override fun render(delta: Float) {
        levelStage.act(delta)
        levelStage.draw()
    }
}
