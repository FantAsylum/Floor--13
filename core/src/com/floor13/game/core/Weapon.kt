package com.floor13.game.core

class Weapon(
        override val weight: Int,
        override val descriptionKey: String,
        val baseDamage: IntRange,
        val damageType: DamageType
        // val ammo: AmmoType
) : Item

enum class DamageType {
    MECHANICAL, ENERGETIC
}
