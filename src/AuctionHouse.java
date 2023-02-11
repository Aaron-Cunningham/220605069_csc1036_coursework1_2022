
import java.util.ArrayList;
import java.util.Arrays;

public class AuctionHouse {

    private String name;
    private String[] address = new String[2];
    int numOfItems;


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
    }


    public String[] getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



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




}