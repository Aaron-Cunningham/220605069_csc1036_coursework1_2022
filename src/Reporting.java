import java.time.Year;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Reporting {


    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public String userInput;
    public int convertedYear;


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
     * This method iterates through all the auction houses and finds a match to the one the user inputted
     * then it returns the items in that auction house.
      * If the auction house isn't found it returns a message that the auction house wasn't found
      * @param name
     **/
    public String auctionHouseItems(String name){
        for(AuctionHouse auctionHouse:auctionHouses){
            if(auctionHouse.getName().equalsIgnoreCase(name)){
                return ANSI_RED + auctionHouse + ANSI_GREEN + auctionHouse.getItemsInAuctionHouse();
            }
        }
        return ANSI_RED + "Auction Hose doesn't exist";
    }

    /**
     * This method takes user input relating to the sold Item they wish to add.
     * It then asks the user which Auction House they want to add the Item to.
     * It then adds that Item to that Auction House.
     * **/
    public void recordItem() {
        Scanner sc = new Scanner(System.in);
        System.out.println(ANSI_RESET + "Please Item name");
        String itemName = lengthLimit(userInput, 30);
        System.out.println("Please Enter Item lot number");
        int itemLotNumber = sc.nextInt();
        int yearSold = yearCheck(convertedYear);
        sc.nextLine();
        System.out.println("Please enter buyer name");
        String buyer = lengthLimit(userInput, 50);
        System.out.println("Please enter category");
        String category = lengthLimit(userInput, 50);
        System.out.println("Please enter price");
        double price = sc.nextDouble();
        sc.nextLine();
        System.out.println("Enter name of auction house to add to");
        String auctionHouseName = sc.nextLine();
        for (AuctionHouse auctionHouse:auctionHouses){
            if(auctionHouse.getName().equalsIgnoreCase(auctionHouseName)){
                Item item = new Item(itemName, itemLotNumber, yearSold, buyer, category, price);
                System.out.println(auctionHouse.getName());
                System.out.println(ANSI_RED + "Items successfully added to " + auctionHouse + item);
                //Adds item to auction house
                auctionHouse.addSoldItem(item);
                break;
            }
        }

    }


    /**
     * This method returns an array list containing items from the auction houses that are greater
     * than the given price inputted by the user.
     * @param price
     * @return ArrayList with items greater than price
     * **/
    public ArrayList<Item> filterItemByGreaterPrice(double price){
        ArrayList<Item> itemsWithGreaterPrice = new ArrayList<>();
        for (AuctionHouse auctionHouse : auctionHouses){
            itemsWithGreaterPrice.addAll(auctionHouse.filterItemsByPrice(price));
        }
        return itemsWithGreaterPrice;
    }

    /**
     * References [source] https://www.youtube.com/watch?v=ofDV5Ywdgl8&ab_channel=KKJavaTutorials(Java 8 Comparator’s comparing() methods, 2017)
     * This method returns the highest priced Item out of all the auction houses
     * @return Highest priced Item
     * @return null if tempList has no items.
     * **/
    public Item mostExpensiveItemReporting() {
        ArrayList<Item> tempList = new ArrayList<>();
        for (AuctionHouse auctionHouse:auctionHouses){
            tempList.add(auctionHouse.mostExpensiveItem());
        }
        if(tempList.size() == 0){
            return null;
        }
        Comparator<Item> comp = Comparator.comparing(Item::getPrice);
        Item mostExpensive = Collections.max(tempList, comp);
        return mostExpensive;

    }


    /**
     * This method limits the amount of characters a user can input into a certain field
     * @param userInput
     * @param limit
     * @return userInput
     * **/
    private String lengthLimit(String userInput, int limit){
        Scanner sc = new Scanner(System.in);
        //do while loop starts
        do{
            //Takes user input as a String
            userInput = sc.nextLine();
            //Checks condition is met
            if(userInput.length() > limit){
                //Prints warning if condition isn't met
                System.err.println("This cant be longer than " + limit + " characters");
            }else {
                //Breaks out of the loop
                break;
            }
        }
        while (true);
        return userInput;
    }


    /**
     * Code adapted from [soruce] https://stackoverflow.com/questions/35936799/validation-so-input-is-only-integer-in-java
     * This method takes year initially as a String which checks that is a userYear between 0-9 and not larger than 4 characters.
     * If them conditions are met, it converts the String into an integer which is then checked to make sure it's not less than
     * the year 2000 and larger than the current year.
     *
     * @param userYear - Year the user inputs.
     * @return converted year input as an integer
     **/
    private int yearCheck(int userYear) {
        Scanner sc = new Scanner(System.in);
        //Gets the current year
        Year year = Year.now();
        int thisYear = year.getValue();

        do {
            System.out.println("Please enter the year the Item sold between 1980 and " + thisYear);
            while (!sc.hasNextInt()) {
                System.err.println("That's not a year. Please enter a year between 1980 and " + thisYear);
                sc.next(); // this is important!
            }
            userYear = sc.nextInt();
        } while (userYear > thisYear || userYear < 1980);
        return userYear;
    }






}
