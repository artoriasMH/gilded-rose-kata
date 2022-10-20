package com.gildedrose

class SulfurasItem(name: Name, sellIn: SellIn, quality: Quality) : Item(name, sellIn, quality){

    override fun update() {
        //Legendary item. Nothing can affect it.
    }

}
