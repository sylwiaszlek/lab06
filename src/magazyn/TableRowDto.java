package magazyn;

import magazyn.lab2.ItemCondition;

public class TableRowDto {
    private String fulfillmentCenterName;
    private double weight;
    private String itemName;
    private int count;
    private ItemCondition itemCondition;

    public TableRowDto(String fulfillmentCenterName, double weight, String itemName, int count, ItemCondition itemCondition) {
        this.fulfillmentCenterName = fulfillmentCenterName;
        this.weight = weight;
        this.itemName = itemName;
        this.count = count;
        this.itemCondition = itemCondition;
    }

    public String getFulfillmentCenterName() {
        return fulfillmentCenterName;
    }

    public double getWeight() {
        return weight;
    }

    public String getItemName() {
        return itemName;
    }

    public int getCount() {
        return count;
    }

    public ItemCondition getItemCondition() {
        return itemCondition;
    }
}
