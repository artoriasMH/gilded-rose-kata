package com.gildedrose

class AgedBrieItem(name: Name, sellIn: SellIn, quality: Quality) : Item(name, sellIn, quality) {

    private val NO_MORE_DAYS = 0

    override fun update() {
        decreaseSellIn()
        increaseQuality()
        if (hasToBeSoldInLessThan(NO_MORE_DAYS)) {
            increaseQuality()
        }
    }

}
