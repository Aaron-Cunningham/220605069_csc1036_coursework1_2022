import java.util.ArrayList;

public class Reporting {
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";


    //List containing auction houses
    public ArrayList<AuctionHouse> auctionHouses = new ArrayList<>();


    /**
     * This method takes an added auction house and checks if it already exists in the auctionHouses Array.
     * If it does exist the user will recieve a message saying it exists, else, it gets added to the list of auction houses.
     * @param addedAuctionHouse
     * **/
    public boolean addAuctionHouse(AuctionHouse addedAuctionHouse){
        //Iterates through all the auction houses
        for (AuctionHouse auctionHouse:auctionHouses){
            //If there's an auction house with the same name as the one been added
            if(auctionHouse.getName().equals(addedAuctionHouse.getName())){
                //It returns false and prints a message to the user
                System.out.println(ANSI_RED + "Auction house already exists" + ANSI_RESET);
                return false;
            }
        }
        //If it doesn't exist, it will be added to the auction houses array.
        auctionHouses.add(addedAuctionHouse);
        System.out.println(ANSI_RED + addedAuctionHouse + ANSI_GREEN + "Successfully added");
        return true;
    }


    /**
     * This method takes an Item and adds it to an auction house
     * @@param Item
     * @return True - Adds item to the auction house
     * **/
    public boolean addItem(Item item) {
        for (AuctionHouse auctionHouse:auctionHouses){
            if(auctionHouse.addItem(item)){
                return true;
            }
        }
        return false;

    }

    public void auctionHouseItems(String name){
        for(AuctionHouse auctionHouse:auctionHouses){
            if(auctionHouse.getName().equalsIgnoreCase(name))
            System.out.println(ANSI_RED +  auctionHouse + ANSI_GREEN +auctionHouse.getItemsInAuctionHouse());
        }
    }

}
