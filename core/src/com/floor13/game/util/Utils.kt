package com.floor13.game.util

infix fun Any.sameTypeAs(other: Any) = this.javaClass == other.javaClass
