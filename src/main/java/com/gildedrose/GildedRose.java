package com.gildedrose;

class GildedRose {
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String CONJURED = "Conjured";
    
    private static final int MAX_QUALITY = 50;
    private static final int MIN_QUALITY = 0;
    
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }
    
    private boolean isAgedBrie(Item item) {
        return item.name.equals(AGED_BRIE);
    }
    
    private boolean isBackstagePasses(Item item) {
        return item.name.equals(BACKSTAGE_PASSES);
    }
    
    private boolean isSulfuras(Item item) {
        return item.name.equals(SULFURAS);
    }
    
    private boolean isConjured(Item item) {
        return item.name.startsWith(CONJURED);
    }
    
    private void updateAgedBrie(Item item) {
        if (item.quality < MAX_QUALITY) {
            item.quality++;
        }
    }
    
    private void updateBackstagePasses(Item item) {
        if (item.quality < MAX_QUALITY) {
            item.quality++;
            
            if (item.sellIn < 11 && item.quality < MAX_QUALITY) {
                item.quality++;
            }
            
            if (item.sellIn < 6 && item.quality < MAX_QUALITY) {
                item.quality++;
            }
        }
    }
    
    private void updateNormalItem(Item item) {
        if (item.quality > MIN_QUALITY) {
            int decreaseAmount = isConjured(item) ? 2 : 1;
            item.quality = Math.max(MIN_QUALITY, item.quality - decreaseAmount);
        }
    }
    
    private void updateExpiredItem(Item item) {
        if (isAgedBrie(item)) {
            if (item.quality < MAX_QUALITY) {
                item.quality++;
            }
        } else if (isBackstagePasses(item)) {
            item.quality = MIN_QUALITY;
        } else if (!isSulfuras(item)) {
            int decreaseAmount = isConjured(item) ? 2 : 1;
            item.quality = Math.max(MIN_QUALITY, item.quality - decreaseAmount);
        }
    }

    public void updateQuality() {
        for (Item item : items) {
            updateItemQuality(item);
            updateItemSellIn(item);
            handleExpiredItem(item);
        }
    }
    
    private void updateItemQuality(Item item) {
        if (isAgedBrie(item)) {
            updateAgedBrie(item);
        } else if (isBackstagePasses(item)) {
            updateBackstagePasses(item);
        } else if (!isSulfuras(item)) {
            updateNormalItem(item);
        }
    }
    
    private void updateItemSellIn(Item item) {
        if (!isSulfuras(item)) {
            item.sellIn--;
        }
    }
    
    private void handleExpiredItem(Item item) {
        if (item.sellIn < 0) {
            updateExpiredItem(item);
        }
    }
}
