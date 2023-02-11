import java.util.ArrayList;
import java.util.Scanner;

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


    public void auctionHouseItems(String name){
        for(AuctionHouse auctionHouse:auctionHouses){
            if(auctionHouse.getName().equalsIgnoreCase(name))
            System.out.println(ANSI_RED +  auctionHouse + ANSI_GREEN +auctionHouse.getItemsInAuctionHouse());
            else {
                System.out.println(ANSI_RED + "Auction House doesn't exist");
            }
        }
    }

    /**
     * This method takes user input relating to the sold Item they wish to add.
     * It then asks the user which Auction House they want to add the Item to.
     * It then adds that Item to that Auction House.
     * **/
    public void recordItem() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Item name");
        String itemName = sc.nextLine();
        System.out.println("Please Enter Item lot number");
        int itemLotNumber = sc.nextInt();
        System.out.println("Please Enter year sold");
        int yearSold = sc.nextInt();
        sc.nextLine();
        System.out.println("Please enter buyer name");
        String buyer = sc.nextLine();
        System.out.println("Please enter category");
        String category = sc.nextLine();
        System.out.println("Please enter price");
        double price = sc.nextDouble();
        sc.nextLine();
        System.out.println("Enter name of auction house to add to");
        String auctionHouseName = sc.nextLine();
        for (AuctionHouse auctionHouse:auctionHouses){
            if(auctionHouse.getName().equalsIgnoreCase(auctionHouseName)){
                Item item = new Item(itemName, itemLotNumber, yearSold, buyer, category, price);
                System.out.println(ANSI_RED + "Items successfully added to " + auctionHouse + item);
                //Adds item to auction house
                auctionHouse.addSoldItem(item);
                break;
            }
        }

    }

    public ArrayList<Item> filterItemByGreaterPrice(double price){
        ArrayList<Item> itemsWithGreaterPrice = new ArrayList<Item>();
        for (AuctionHouse auctionHouse : auctionHouses){
            itemsWithGreaterPrice.addAll(auctionHouse.filterItemsByPrice(price));
        }
        return itemsWithGreaterPrice;
    }

}
