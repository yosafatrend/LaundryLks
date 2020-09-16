package com.spect.laundry;

public class Item {
    private String itemName;
    private String itemQty;

    public Item(String itemName, String itemQty) {
        this.itemName = itemName;
        this.itemQty = itemQty;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemQty() {
        return itemQty;
    }

    public void setItemQty(String itemQty) {
        this.itemQty = itemQty;
    }


}
