package com.floor13.game.screens

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.ScreenAdapter
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.utils.viewport.ExtendViewport

import com.floor13.game.core.World
import com.floor13.game.actors.MapActor

class GameScreen(world: World) : ScreenAdapter() {
    val levelStage = Stage(ExtendViewport(
            Gdx.graphics.width.toFloat(),
            Gdx.graphics.height.toFloat()
    ))
    val hudStage = Stage() // TODO: pick viewport

    init {
        levelStage.addActor(MapActor(world.map))
    }
    
    override fun render(delta: Float) {
        levelStage.act(delta)
        levelStage.draw()
    }
}
