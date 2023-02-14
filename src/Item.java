public class Item {

    private int yearSold;
    private String buyerName, category, itemName, lotNumber;
    private double price;

    /**
     * This constructor represents an Item
     * @param itemName - Relates to the name of the Item
     * @param lotNumber - Relateds to the lot number the Item has
     * @param yearSold - Relates to the year the Item was sold
     * @param buyerName - Relates to the name of the buyer of the Item
     * @param category - Relates to the category of the Item
     * @param price - Relates to the price of an Item
     */
    public Item(String itemName, String lotNumber, int yearSold, String buyerName, String category, double price) {
        this.lotNumber = lotNumber;
        this.yearSold = yearSold;
        this.buyerName = buyerName;
        this.category = category;
        this.price = price;
        this.itemName = itemName;
    }

    /**
     * This getter gets the year an Item was sold
     * @return The year the Item was sold
     */
    public int getYearSold() {
        return yearSold;
    }

    /***
     * This getter gets the price of an Item
     * @return The price of an Item
     */
    public double getPrice() {
        return price;
    }


    /***
     * This toString method returns the deatails of an item
     * @return A String with all of an Items details
     */
    @Override
    public String toString() {
        return "Items" + "\n" +
                "Lot Number: " + lotNumber + "\n" +
                "Year sold: " + yearSold + "\n" +
                "Buyers name: " +  buyerName + "\n" +
                "Category: " + category + "\n" +
                "Price: " + price + "\n" +
                "item name: " + itemName + "\n";
    }
}
