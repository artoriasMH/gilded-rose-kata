package com.gildedrose

class StandardItem(name: Name, sellIn: SellIn, quality: Quality) : Item(name, sellIn, quality) {

    private val LAST_DAY = 0

    override fun update() {
        decreaseSellIn()
        decreaseQuality()
        if (hasToBeSoldInLessThan(LAST_DAY)) {
            decreaseQuality()
        }
    }

}
