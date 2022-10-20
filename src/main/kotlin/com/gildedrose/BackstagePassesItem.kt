package com.gildedrose

class BackstagePassesItem(name: Name, sellIn: SellIn, quality: Quality): Item(name, sellIn, quality) {

    private val FLAG_AT_10_TO_DOUBLE_INCREASE_QUALITY = 10
    private val FLAG_AT_5_TO_DOUBLE_INCREASE_QUALITY = 5
    private val NO_MORE_DAYS = 0

    override fun update() {
        decreaseSellIn()
        increaseQuality()
        if(hasToBeSoldInLessThan(FLAG_AT_10_TO_DOUBLE_INCREASE_QUALITY)){
            increaseQuality()
        }
        if(hasToBeSoldInLessThan(FLAG_AT_5_TO_DOUBLE_INCREASE_QUALITY)){
            increaseQuality()
        }
        if(hasToBeSoldInLessThan(NO_MORE_DAYS)){
            resetQuality()
        }
    }

}
