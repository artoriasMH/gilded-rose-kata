package com.gildedrose

class GildedRose(var items: List<Item>) {

    private val AGED_BRIE = "Aged Brie"
    private val BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert"
    private val SULFURAS = "Sulfuras, Hand of Ragnaros"
    private val MINIMUM_QUALITY = 0
    private val MAXIMUM_QUALITY = 50

    private val EXPIRED_SELL_IN = 0
    private val BACKSTAGE_PASSES_FLAG_AT_10_SELL_IN = 10
    private val BACKSTAGE_PASSES_FLAG_AT_5_SELL_IN = 5

    fun updateQuality() {

        for (item in items) {

            when (item.name) {
                SULFURAS -> break
                AGED_BRIE -> {
                    decreaseSellIn(item)
                    updateAgedBrieItemQuality(item)
                }

                BACKSTAGE_PASSES -> {
                    decreaseSellIn(item)
                    updateBackstagePassesItemQuality(item)
                }

                else -> {
                    decreaseSellIn(item)
                    updateDefaultItemQuality(item)
                }
            }

        }
    }

    private fun decreaseSellIn(item: Item) {
        item.sellIn--
    }

    private fun resetItemQuality(item: Item) {
        item.quality = 0
    }

    private fun decreaseItemQuality(item: Item) {
        item.quality--
    }

    private fun increaseItemQuality(item: Item) {
        item.quality++
    }

    private fun updateDefaultItemQuality(item: Item) {
        decreaseItemQuality(item)
        if (item.sellIn < EXPIRED_SELL_IN && item.quality > MINIMUM_QUALITY) {
            decreaseItemQuality(item)
        }
    }

    private fun updateAgedBrieItemQuality(item: Item) {
        increaseItemQuality(item)
        if (item.sellIn < EXPIRED_SELL_IN && item.quality < MAXIMUM_QUALITY) {
            increaseItemQuality(item)
        }
    }

    private fun updateBackstagePassesItemQuality(item: Item) {
        increaseItemQuality(item)
        if(item.quality < MAXIMUM_QUALITY && item.sellIn < BACKSTAGE_PASSES_FLAG_AT_10_SELL_IN){
            increaseItemQuality(item)
        }
        if(item.quality < MAXIMUM_QUALITY && item.sellIn < BACKSTAGE_PASSES_FLAG_AT_5_SELL_IN){
            increaseItemQuality(item)
        }
        if (item.sellIn < EXPIRED_SELL_IN){
            resetItemQuality(item)
        }
    }

}
