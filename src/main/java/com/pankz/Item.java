package com.pankz;

import java.math.BigDecimal;

public class Item {
    private final String id;
    private final String name;
    private final ItemType itemType;
    private final BigDecimal price;

    public Item(String id, String name, ItemType itemType, BigDecimal price) {
        this.id=id;
        this.name=name;
        this.itemType=itemType;
        this.price=price;
    }

    private Item(Builder builder) {
        id = builder.id;
        name = builder.name;
        itemType = builder.itemType;
        price = builder.price;
    }


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public static final class Builder {
        private String id;
        private String name;
        private ItemType itemType;
        private BigDecimal price;

        public Builder() {
        }

        public Builder withId(String val) {
            id = val;
            return this;
        }

        public Builder withName(String val) {
            name = val;
            return this;
        }

        public Builder withItemType(ItemType val) {
            itemType = val;
            return this;
        }

        public Builder withPrice(BigDecimal val) {
            price = val;
            return this;
        }

        public Item build() {
            return new Item(this);
        }
    }
}
