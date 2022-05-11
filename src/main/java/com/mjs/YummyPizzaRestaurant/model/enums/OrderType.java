package com.mjs.YummyPizzaRestaurant.model.enums;

public enum OrderType {
    counterOrder,
    phoneOrder,
    onlineOrder;

    public static final String[] descriptions = {
            "Order provided on Front Counter",
            "Order provided over Phone call",
            "Ordered Online"
    };

    public String getDescription() {
        return descriptions[this.ordinal()];
    }
}
