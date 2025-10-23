package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }
    
    @Test
    void agedBrieIncreasesInQuality() {
        Item[] items = new Item[] { new Item("Aged Brie", 2, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, app.items[0].quality);
        assertEquals(1, app.items[0].sellIn);
    }
    
    @Test
    void agedBrieQualityNeverExceeds50() {
        Item[] items = new Item[] { new Item("Aged Brie", 2, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }
    
    @Test
    void agedBrieIncreasesTwiceAsFastWhenExpired() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(2, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }
    
    @Test
    void sulfurasNeverChanges() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
        assertEquals(0, app.items[0].sellIn);
    }
    
    @Test
    void backstagePassesIncreaseInQuality() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(21, app.items[0].quality);
        assertEquals(14, app.items[0].sellIn);
    }
    
    @Test
    void backstagePassesIncreaseBy2When10DaysOrLess() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(22, app.items[0].quality);
        assertEquals(9, app.items[0].sellIn);
    }
    
    @Test
    void backstagePassesIncreaseBy3When5DaysOrLess() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(23, app.items[0].quality);
        assertEquals(4, app.items[0].sellIn);
    }
    
    @Test
    void backstagePassesQualityDropsToZeroWhenExpired() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }
    
    @Test
    void backstagePassesQualityNeverExceeds50() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }
    
    @Test
    void normalItemDecreasesInQuality() {
        Item[] items = new Item[] { new Item("Normal Item", 5, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].quality);
        assertEquals(4, app.items[0].sellIn);
    }
    
    @Test
    void normalItemDecreasesTwiceAsFastWhenExpired() {
        Item[] items = new Item[] { new Item("Normal Item", 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(8, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }
    
    @Test
    void normalItemQualityNeverGoesBelowZero() {
        Item[] items = new Item[] { new Item("Normal Item", 5, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }
    
    @Test
    void conjuredItemDecreasesTwiceAsFast() {
        Item[] items = new Item[] { new Item("Conjured Item", 5, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(8, app.items[0].quality);
        assertEquals(4, app.items[0].sellIn);
    }
    
    @Test
    void conjuredItemDecreasesFourTimesAsFastWhenExpired() {
        Item[] items = new Item[] { new Item("Conjured Item", 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(6, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }
    
    @Test
    void conjuredItemQualityNeverGoesBelowZero() {
        Item[] items = new Item[] { new Item("Conjured Item", 5, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }
}
