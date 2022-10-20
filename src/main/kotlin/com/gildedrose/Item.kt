package com.gildedrose

abstract class Item(
    var name: Name,
    var sellIn: SellIn,
    var quality: Quality
) {

    abstract fun update()
    override fun toString(): String {
        return "Item(name=$name, sellIn=$sellIn, quality=$quality)"
    }

    open fun decreaseSellIn() {
        sellIn = sellIn.decrease()
    }

    open fun hasToBeSoldInLessThan(days: Int): Boolean {
        return sellIn.isLessThan(days)
    }

    open fun increaseQuality() {
        quality = quality.increase()
    }

    open fun decreaseQuality() {
        quality = quality.decrease()
    }

    open fun resetQuality() {
        quality = quality.reset()
    }



}

data class Quality(
    val value: Int
) {
    private val MAX_VALUE = 50
    private val MIN_VALUE = 0

    fun decrease() = if (value - 1 < MIN_VALUE) {
        Quality(value)
    } else {
        Quality(value - 1)
    }

    fun increase() = if (value + 1 < MAX_VALUE) {
        Quality(value)
    } else {
        Quality(value + 1)
    }

    fun reset() = Quality(MIN_VALUE)
}

data class SellIn(
    val value: Int
) {
    private val EXPIRED_SELL_IN = 0
    fun decrease() = SellIn(value - 1)
    fun isLessThan(days: Int) = value < days
}

data class Name(
    val value: String
) {
    private val AGED_BRIE = "Aged Brie"
    private val BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert"
    private val SULFURAS = "Sulfuras, Hand of Ragnaros"

    fun isAgedBrie() = value == AGED_BRIE
    fun isBackstagePasses() = value == BACKSTAGE_PASSES
    fun isSulfuras() = value == SULFURAS
}
