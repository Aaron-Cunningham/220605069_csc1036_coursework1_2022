
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class AuctionHouse {

    //Variables to store information about auction houses
    private String name;
    private String[] address = new String[2];
    int numOfItems;
    private double averagePrice;

    //List containing items in auction house
    private ArrayList<Item> itemsInAuctionHouse;


    /**
     * Constructor for the Item class
     * **/
    AuctionHouse(String name, String firstLineAddress, String postCode){
        this.name = name;
        this.address[0] = firstLineAddress;
        this.address[1] = postCode;
        this.numOfItems = numOfItems;
        this.itemsInAuctionHouse = new ArrayList();
        this.averagePrice = averagePrice;
    }

    public double getAveragePrice() {
        return averagePrice;
    }

    public String getName() {
        return name;
    }

    public void setAveragePrice(double averagePrice) {
        this.averagePrice = averagePrice;
    }

    /**
     * Returns the items stored in an auction house
     * **/
    public ArrayList<Item> getItemsInAuctionHouse() {

        return itemsInAuctionHouse;
    }

    public int amountOfItemsInAuctionHouse(){
        numOfItems = getItemsInAuctionHouse().size();
        return numOfItems;
    }


    @Override
    public String toString() {
        return "Auction House: \n" +
                "Name: " + name + "\n" +
                "Address: " + Arrays.toString(address) + "\n"+
                "Items in Auction House: " + amountOfItemsInAuctionHouse() + "\n" + "\n";
    }


    /**
     * This method adds an item to the itemsSoldByAuctionHouse ArrayList
     * @param item
     * **/
    public void addSoldItem(Item item){
        itemsInAuctionHouse.add(item);
    }

    /**
     * Code adapted from [source] https://github.com/newcastleuniversity-computing/csc1035-csc1036_practicals_2022/blob/solutions/part1/practical-9/src/Garage.java
     * This method takes a price from a user and adds it to the itemsGreaterPrice list if the item price is > than the user input price
     * @param price
     * @return Arraylist with items greater than inputted price
     * **/
    public ArrayList<Item> filterItemsByPrice(double price){
        ArrayList<Item> itemsGreaterThanPrice = new ArrayList<>();
        if(itemsInAuctionHouse.size() == 0){
            return null;
        }
        for (Item item : itemsInAuctionHouse){
            if(item.getPrice() > price){
                itemsGreaterThanPrice.add(item);
            }
        }
        return itemsGreaterThanPrice;
    }


    /**
     * References [source] https://www.youtube.com/watch?v=ofDV5Ywdgl8&ab_channel=KKJavaTutorials(Java 8 Comparator’s comparing() methods, 2017)
     * This method returns the most expensive product from the itemsInAuctionHouse list.
     * @return Most expensive product.
     * **/
    public Item mostExpensiveItem() {
        if(itemsInAuctionHouse.size() == 0){
            return null;
        }
        Comparator<Item> comp = Comparator.comparing(Item::getPrice);
        Item mostExpensiveItem = Collections.max(itemsInAuctionHouse, comp);
        return mostExpensiveItem;
    }


    /**
     * This returns the average price of the Items stored in the itemsInAuctionHouse Array
     * Formula: Average = sum of values/number of values
     * @param year
     * @return Average price of items
     * **/
    public double averageItemPriceGivenYear(int year){
        double price = 0;
        int itemCount = 0;
        for (Item item: itemsInAuctionHouse){
            if(year == item.getYearSold()){
                price += item.getPrice();
                itemCount++;
            }
        }
        return price/itemCount;
    }

}