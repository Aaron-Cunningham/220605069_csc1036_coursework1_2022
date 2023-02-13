public class Item {

    private int lotNumber, yearSold;
    private String buyerName, category, itemName;
    private double price;

    /**
     * This constructor represents a Item
     * @param itemName
     * @param lotNumber
     * @param yearSold
     * @param buyerName
     * @param category
     * @param price
     */
    public Item(String itemName, int lotNumber, int yearSold, String buyerName, String category, double price) {
        this.lotNumber = lotNumber;
        this.yearSold = yearSold;
        this.buyerName = buyerName;
        this.category = category;
        this.price = price;
        this.itemName = itemName;
    }

    public int getYearSold() {
        return yearSold;
    }

    public double getPrice() {
        return price;
    }


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
