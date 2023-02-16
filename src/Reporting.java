import java.time.Year;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Reporting {

    //Sets console text to Red
    private static final String ANSI_RED = "\u001B[31m";
    //Resets console text to default
    private static final String ANSI_RESET = "\u001B[0m";
    //Sets console text to Green
    public static final String ANSI_GREEN = "\u001B[32m";


    //List containing auction houses
    public ArrayList<AuctionHouse> auctionHouses = new ArrayList<>();


    /**
     * This method takes an added auction house and checks if it already exists in the auctionHouses Array.
     * If it does exist the user will receive a message saying it exists, else, it gets added to the list of auction houses.
     * @param addedAuctionHouse
     * **/
    public boolean addAuctionHouse(AuctionHouse addedAuctionHouse){
        //Iterates through all the auction houses
        for (AuctionHouse auctionHouse: auctionHouses){
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
     * This method takes user input relating to the sold Item they wish to add.
     * It then asks the user which Auction House they want to add the Item to.
     * It then adds that Item to that Auction House.
     * **/
    public boolean addItem(Item addedItem) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name of auction house to add to");
        String auctionHouseName = sc.nextLine();
        for (AuctionHouse auctionHouse: auctionHouses){
            if(auctionHouse.getName().equalsIgnoreCase(auctionHouseName)){
                System.out.println(auctionHouse.getName());
                System.out.println(ANSI_RED + "Items successfully added to " + auctionHouse + addedItem);
                //Adds item to auction house
                auctionHouse.addSoldItem(addedItem);
                return true;
            }
        }
        return false;

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
        ArrayList<Item> items = new ArrayList<>();
        for (AuctionHouse auctionHouse: auctionHouses){
            items.add(auctionHouse.mostExpensiveItem());
        }
        if(items.size() == 0){
            return null;
        }
        Comparator<Item> comp = Comparator.comparing(Item::getPrice);
        Item mostExpensive = Collections.max(items, comp);
        return mostExpensive;

    }


    /**
     * This method limits the amount of characters a user can input into a certain field
     * @param userInput - Relates to the input the user inputs
     * @param limit - This is the limit set on the number of characters a user can input
     * @return userInput
     * **/
    public String lengthLimit(String userInput, int limit){
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
     *
     * This method restricts what year they are allowed to input when adding an item.
     * It checks the year is between 1950 and the current year.
     *
     * @param userYear - Year the user inputs.
     * @return userYear.
     **/
    public int yearCheck(int userYear) {
        Scanner sc = new Scanner(System.in);
        //Gets the current year
        Year year = Year.now();
        int thisYear = year.getValue();

        do {
            System.out.println("Please enter the year the Item sold between 1950 and " + thisYear);
            while (!sc.hasNextInt()) {
                System.err.println("That's not a valid year. Please enter a year between 1950 and " + thisYear);
                sc.next(); // this is important!
            }
            userYear = sc.nextInt();
        } while (userYear > thisYear || userYear < 1950);
        return userYear;
    }


    /**
     * References [source] https://www.youtube.com/watch?v=ofDV5Ywdgl8&ab_channel=KKJavaTutorials(Java 8 Comparator’s comparing() methods, 2017)
     * This method returns The Auction House with the largest average price for a given year.
     * @param year - This is the year of which the user wants to check for the best auction house average price
     * @return The AuctionHouse with the largest average price for a given year.
     * **/
    public AuctionHouse bestAuctionHouseAverageYear(int year){
        ArrayList<AuctionHouse> bestPerforming = new ArrayList<>();

        for (AuctionHouse auctionHouse: auctionHouses){
            double average = auctionHouse.averageItemPriceGivenYear(year);
            auctionHouse.setAveragePrice(average);
            if(average > 0) {
                bestPerforming.add(auctionHouse);
            }
        }
        if(bestPerforming.size() == 0){
            return null;
        }
        Comparator<AuctionHouse> comp = Comparator.comparing(AuctionHouse::getAveragePrice);
        AuctionHouse mostExpensive = Collections.max(bestPerforming, comp);

        return mostExpensive;



    }


    public String auctionHouseItems(String name){
        for(AuctionHouse auctionHouse:auctionHouses){
            if(auctionHouse.getName().equalsIgnoreCase(name)){
                return ANSI_RED + auctionHouse + ANSI_GREEN + auctionHouse.getItemsInAuctionHouse();
            }
        }
        return ANSI_RED + "Auction Hose doesn't exist";
    }


    /**
     * Code adapted from [soruce] https://stackoverflow.com/questions/35936799/validation-so-input-is-only-integer-in-java
     * This method restricts what price users can input to only positive doubles
     * @param price - The price the user inputs
     * @return price
     **/
    public double priceCheck(double price) {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Please enter the price the item sold for");
            while (!sc.hasNextDouble()) {
                System.err.println("Not a valid price, must be positive or equal to 0");
                sc.next(); // this is important!
            }
            price = sc.nextInt();
        } while (price < 0);
        return price;
    }




}
