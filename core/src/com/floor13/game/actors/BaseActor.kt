package com.floor13.game.actors

import com.badlogic.gdx.scenes.scene2d.Actor

open class BaseActor() : Actor() {

    open val needResources = listOf<Pair<String, Class<*>>>()
}
