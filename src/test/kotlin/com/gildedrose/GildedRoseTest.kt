package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class GildedRoseTest {

    @Test
    fun `should decrease by 1 the sellIn of an item when is updated`() {
        val items = listOf(StandardItem(Name("fantastic item"), SellIn(5), Quality(0)))
        val app = GildedRose(items)

        app.updateQuality()

        val expected = 4
        assertEquals(expected, app.items.first().sellIn.value)
    }

    @Test
    fun `should decrease by 1 the quality of an item when is updated`() {
        val items = listOf(StandardItem(Name("fantastic item"), SellIn(5), Quality(3)))
        val app = GildedRose(items)

        app.updateQuality()

        val expected = 2
        assertEquals(expected, app.items.first().quality.value)
    }

    @Test
    fun `should decrease by 2 the quality of an item if the sellIn date has passed when is updated`() {
        val items = listOf(StandardItem(Name("fantastic item"), SellIn(0), Quality(3)))
        val app = GildedRose(items)

        app.updateQuality()

        val expected = 1
        assertEquals(expected, app.items.first().quality.value)
    }

    @Test
    fun `should not decrease the quality of an item to less than 0 when is updated`() {
        val items = listOf(StandardItem(Name("fantastic item"), SellIn(0), Quality(1)))
        val app = GildedRose(items)

        app.updateQuality()

        val expected = 0
        assertEquals(expected, app.items.first().quality.value)
    }

    @Test
    fun `should increase by 1 the quality of an item if it's an 'Aged Brie' when is updated`() {
        val items = listOf(AgedBrieItem(Name("Aged Brie"), SellIn(8), Quality(5)))
        val app = GildedRose(items)

        app.updateQuality()

        val expected = 6
        assertEquals(expected, app.items.first().quality.value)
    }

    @Test
    fun `should never decrease the quality of an item if it's a 'Sulfuras, Hand of Ragnaros' when is updated`() {
        val items = listOf(SulfurasItem(Name("Sulfuras, Hand of Ragnaros"), SellIn(-100), Quality(80)))
        val app = GildedRose(items)

        app.updateQuality()

        val expected = 80
        assertEquals(expected, app.items.first().quality.value)
    }

    @Test
    fun `should increase by 1 the quality of an item if it's a 'Backstage passes' and sellIn is greather than 10 when is updated`() {
        val items = listOf(BackstagePassesItem(Name("Backstage passes to a TAFKAL80ETC concert"), SellIn(20), Quality(20)))
        val app = GildedRose(items)

        app.updateQuality()

        val expected = 21
        assertEquals(expected, app.items.first().quality.value)
    }

    @Test
    fun `should increase by 2 the quality of an item if it's a 'Backstage passes' and sellIn is between 10 and 5 when is updated`() {
        val items = listOf(BackstagePassesItem(Name("Backstage passes to a TAFKAL80ETC concert"), SellIn(6), Quality(20)))
        val app = GildedRose(items)

        app.updateQuality()

        val expected = 22
        assertEquals(expected, app.items.first().quality.value)
    }

    @Test
    fun `should increase by 3 the quality of an item if it's a 'Backstage passes' and sellIn is 5 or less when is updated`() {
        val items = listOf(BackstagePassesItem(Name("Backstage passes to a TAFKAL80ETC concert"), SellIn(5), Quality(20)))
        val app = GildedRose(items)

        app.updateQuality()

        val expected = 23
        assertEquals(expected, app.items.first().quality.value)
    }
    
    @Test
    fun `should drop to 0 the quality of an item if it's a 'Backstage passes' and sellIn is less than 0 when is updated`() {
        val items = listOf(BackstagePassesItem(Name("Backstage passes to a TAFKAL80ETC concert"), SellIn(0), Quality(20)))
        val app = GildedRose(items)

        app.updateQuality()

        val expected = 0
        assertEquals(expected, app.items.first().quality.value)
    }

    @Test
    fun `should decrease by 2 the quality of an item if it's a 'Conjured' when is updated`() {
        val items = listOf(ConjuredItem(Name("Conjured Mana Cake"), SellIn(5), Quality(20)))
        val app = GildedRose(items)

        app.updateQuality()

        val expected = 18
        assertEquals(expected, app.items.first().quality.value)
    }

    @Test
    fun `should decrease by 4 the quality of an item if it's a 'Conjured' and sellIn is less than 0 when is updated`() {
        val items = listOf(ConjuredItem(Name("Conjured Mana Cake"), SellIn(0), Quality(5)))
        val app = GildedRose(items)

        app.updateQuality()

        val expected = 1
        assertEquals(expected, app.items.first().quality.value)
    }


}
