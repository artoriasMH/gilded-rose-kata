package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class GildedRoseTest {

    @Test
    fun `should decrease by 1 the sellIn of an item when is updated`() {
        val items = listOf(Item("fantastic item", 5, 0))
        val app = GildedRose(items)

        app.updateQuality()

        val expected = 4
        assertEquals(expected, app.items.first().sellIn)
    }

    @Test
    fun `should decrease by 1 the quality of an item when is updated`() {
        val items = listOf(Item("fantastic item", 5, 3))
        val app = GildedRose(items)

        app.updateQuality()

        val expected = 2
        assertEquals(expected, app.items.first().quality)
    }

    @Test
    fun `should decrease by 2 the quality of an item if the sellIn date has passed when is updated`() {
        val items = listOf(Item("fantastic item", 0, 3))
        val app = GildedRose(items)

        app.updateQuality()

        val expected = 1
        assertEquals(expected, app.items.first().quality)
    }

    @Test
    fun `should not decrease the quality of an item to less than 0 when is updated`() {
        val items = listOf(Item("fantastic item", 0, 1))
        val app = GildedRose(items)

        app.updateQuality()

        val expected = 0
        assertEquals(expected, app.items.first().quality)
    }

    @Test
    fun `should increase by 1 the quality of an item if it's an 'Aged Brie' when is updated`() {
        val items = listOf(Item("Aged Brie", 8, 5))
        val app = GildedRose(items)

        app.updateQuality()

        val expected = 6
        assertEquals(expected, app.items.first().quality)
    }

    @Test
    fun `should never decrease the quality of an item if it's a 'Sulfuras, Hand of Ragnaros' when is updated`() {
        val items = listOf(Item("Sulfuras, Hand of Ragnaros", -100, 80))
        val app = GildedRose(items)

        app.updateQuality()

        val expected = 80
        assertEquals(expected, app.items.first().quality)
    }

    @Test
    fun `should increase by 1 the quality of an item if it's a 'Backstage passes' and sellIn is greather than 10 when is updated`() {
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 20, 20))
        val app = GildedRose(items)

        app.updateQuality()

        val expected = 21
        assertEquals(expected, app.items.first().quality)
    }

    @Test
    fun `should increase by 2 the quality of an item if it's a 'Backstage passes' and sellIn is between 10 and 5 when is updated`() {
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 6, 20))
        val app = GildedRose(items)

        app.updateQuality()

        val expected = 22
        assertEquals(expected, app.items.first().quality)
    }

    @Test
    fun `should increase by 3 the quality of an item if it's a 'Backstage passes' and sellIn is 5 or less when is updated`() {
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 5, 20))
        val app = GildedRose(items)

        app.updateQuality()

        val expected = 23
        assertEquals(expected, app.items.first().quality)
    }
    
    @Test
    fun `should drop to 0 the quality of an item if it's a 'Backstage passes' and sellIn is less than 0 when is updated`() {
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 0, 20))
        val app = GildedRose(items)

        app.updateQuality()

        val expected = 0
        assertEquals(expected, app.items.first().quality)
    }

}
