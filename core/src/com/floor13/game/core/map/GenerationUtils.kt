package com.floor13.game.core.map

fun Map.fillRect(xs: IntRange, ys: IntRange, tileType: TileType) {
    for (x in xs)
        for (y in ys)
            this[x][y] = Tile(tileType)
}
