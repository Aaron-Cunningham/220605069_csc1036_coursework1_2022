public class Item {

    private int lotNumber, yearSold;
    private String buyerName, category, itemName;
    private double price;

    public Item(String itemName, int lotNumber, int yearSold, String buyerName, String category, double price) {
        this.lotNumber = lotNumber;
        this.yearSold = yearSold;
        this.buyerName = buyerName;
        this.category = category;
        this.price = price;
        this.itemName = itemName;
    }

    public int getLotNumber() {
        return lotNumber;
    }

    public String getItemName() {
        return itemName;
    }

    public void setLotNumber(int lotNumber) {
        this.lotNumber = lotNumber;
    }

    public int getYearSold() {
        return yearSold;
    }

    public void setYearSold(int yearSold) {
        this.yearSold = yearSold;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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
