package com.floor13.game.core.map

import java.util.Random

private val rand = Random()

fun Map.fillRect(xs: IntRange, ys: IntRange, tileType: TileType) {
    for (x in xs)
        for (y in ys)
            this[x][y] = Tile(tileType)
}

/**
  * @param x horizontal center coordinate
  * @param y vertical center coordinate
  * @param width width
  * @param height height
  * @param tileType desired tile type
  */
fun Map.fillRect(x: Int, y: Int, width: Int, height: Int, tileType: TileType) {
    val xn = Math.max(x - width / 2, 0)
    val yn = Math.max(y - height / 2, 0)
    val xk = xn + width
    val yk = yn + height
    fillRect(xn..xk, yn..yk, tileType)
}

val IntRange.random: Int
    get() = start + rand.nextInt(endInclusive - start)

enum class Direction {
    RIGHT, LEFT, UP, DOWN
}
