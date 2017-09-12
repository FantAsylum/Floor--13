package com.floor13.game.core

data class Position(val x: Int, val y: Int) {
	infix fun adjacentTo(that: Position) =
		Math.abs(this.x - that.x) + Math.abs(this.y - that.y) == 1

	fun withinBounds(width: Int, height: Int) =
		x >= 0 && x < width && y >= 0 && y < height

	fun translated(dx: Int, dy: Int) =
		Position(x + dx, y + dy)
}
