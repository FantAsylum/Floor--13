package com.floor13.game.screens

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.ScreenAdapter
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.utils.viewport.ExtendViewport
import com.badlogic.gdx.InputMultiplexer
import com.badlogic.gdx.InputAdapter
import com.badlogic.gdx.Input

import com.floor13.game.core.World
import com.floor13.game.actors.MapActor
import com.floor13.game.actors.CreatureActor
import com.floor13.game.core.actions.MoveAction
import com.floor13.game.core.Position

class GameScreen(val world: World) : ScreenAdapter() {
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

	val keyboardProcessor = object: InputAdapter() {
		fun scheduleMove(position: Position) {
			val action = MoveAction(world, world.mainCharacter, position)
			if (action.isValid)
				world.mainCharacter.nextAction = action
		}
		override fun keyUp(keycode: Int) =
			when (keycode) {
				Input.Keys.UP -> {
					scheduleMove(world.mainCharacter.position.translated(0, 1))
					true
				}
				Input.Keys.DOWN -> {
					scheduleMove(world.mainCharacter.position.translated(0, -1))
					true
				}
				Input.Keys.RIGHT -> {
					scheduleMove(world.mainCharacter.position.translated(1, 0))
					true
				}
				Input.Keys.LEFT -> {
					scheduleMove(world.mainCharacter.position.translated(-1, 0))
					true
				}
				else -> false
			}
	}

    init {
        levelStage.addActor(MapActor(world.map))
        for (creature in world.creatures) {
			val actor = CreatureActor(creature, world)
			levelStage.addActor(actor)
        }

        Gdx.input.inputProcessor = InputMultiplexer(
                mapScroller,
				keyboardProcessor
        )
    }
    
    override fun render(delta: Float) {
		while (world.mainCharacter.nextAction != null)
			world.tick()
        levelStage.act(delta)
        levelStage.draw()
    }
}
