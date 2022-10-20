package com.gildedrose

class ConjuredItem(name: Name, sellIn: SellIn, quality: Quality) : Item(name, sellIn, quality) {

    private val LAST_DAY = 0

    override fun update() {
        decreaseSellIn()
        decreaseQualityTwiceTimesFaster()
        if (hasToBeSoldInLessThan(LAST_DAY)) {
            decreaseQualityTwiceTimesFaster()
        }
    }
    private fun decreaseQualityTwiceTimesFaster(){
        decreaseQuality()
        decreaseQuality()
    }
}