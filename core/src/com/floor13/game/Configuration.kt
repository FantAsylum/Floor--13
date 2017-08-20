package com.floor13.game

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.utils.GdxRuntimeException

import java.util.Properties
import java.io.FileInputStream

object Configuration {
    val previousVersion by lazy {
        val properties = Properties()
        try {
            properties.load(Gdx.files.local("prev_version.properties").read())
            properties.getProperty("version") ?: null
        } catch (ex: GdxRuntimeException) {
            null
        }

    }
    
    val version by lazy {
        previousVersion // just for evaluation
        val properties = Properties()
        properties.load(Gdx.files.internal("version.properties").read())
        properties.store(Gdx.files.local("prev_version.properties").writer(false), null)
        properties.getProperty("version")!!
    }

    val isFirstStartup by lazy {
        previousVersion != version
    }
}

