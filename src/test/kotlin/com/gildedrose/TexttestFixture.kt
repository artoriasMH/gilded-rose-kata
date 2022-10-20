package com.gildedrose

fun main(args: Array<String>) {

    println("OMGHAI!")

    val items = listOf(StandardItem(Name("+5 Dexterity Vest"), SellIn(10), Quality(20)), //
        AgedBrieItem(Name("Aged Brie"), SellIn(2), Quality( 0)), //
        StandardItem(Name("Elixir of the Mongoose"), SellIn(5), Quality( 7)), //
        SulfurasItem(Name("Sulfuras, Hand of Ragnaros"), SellIn(0), Quality( 80)), //
        SulfurasItem(Name("Sulfuras, Hand of Ragnaros"), SellIn(-1), Quality( 80)),
        BackstagePassesItem(Name("Backstage passes to a TAFKAL80ETC concert"), SellIn(15), Quality( 20)),
        BackstagePassesItem(Name("Backstage passes to a TAFKAL80ETC concert"), SellIn(10), Quality( 49)),
        BackstagePassesItem(Name("Backstage passes to a TAFKAL80ETC concert"), SellIn(5), Quality( 49)),
        ConjuredItem(Name("Conjured Mana Cake"), SellIn(3), Quality( 6)))

    val app = GildedRose(items)

    var days = 2
    if (args.size > 0) {
        days = Integer.parseInt(args[0]) + 1
    }

    for (i in 0..days - 1) {
        println("-------- day $i --------")
        println("name, sellIn, quality")
        for (item in items) {
            println(item)
        }
        println()
        app.updateQuality()
    }


}
