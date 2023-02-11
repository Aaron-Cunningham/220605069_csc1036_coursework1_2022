import java.util.Scanner;

public class ReportingIO {
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_RESET = "\u001B[0m";
    public static void main(String[] args) {
        new ReportingIO().run();
    }
    Reporting r = new Reporting();


    /**
     * Code adapted from [source] https://github.com/newcastleuniversity-computing/csc1035-csc1036_practicals_2022/blob/solutions/part1/practical-10/src/IO.java
     * This method runs allows the user to interact with the menu system in the console.
     * menu() is called which prints out the option the user has which run() gives it functionality.
     * **/
    public void run() {
        boolean quit = false;
        Scanner sc = new Scanner(System.in);
        while (!quit) {
            menu();
            System.out.println("Please select an option");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    r.addAuctionHouse(recordAuctionHouse());
                    break;
                case 2:
                    r.addItem(recordItem());
                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:
                    sc.nextLine();
                    System.out.println("Enter auction house name");
                    String name = sc.nextLine();
                    r.auctionHouseItems(name);

                    break;
                case 6:
                    System.out.println("Quitting");
                    quit = true;
                    break;
                default:
                    System.out.println("Not a valid option");
            }
        }

    }




    private void menu() {
        System.out.println(ANSI_RESET + "1: Add an auction house\n" +
                "2: Add a Item\n" +
                "3: Filter Items by given price\n" +
                "4: Most Expensive Item\n" +
                "5: View Items in a specific Auction House");
    }


    /**
     * Code adapted from [source] https://github.com/newcastleuniversity-computing/csc1035-csc1036_practicals_2022/blob/solutions/part1/practical-10/src/IO.java
     * This method takes user relating to details of the auction house they wish to add
     * @return AuctionHouse
     * **/
    private AuctionHouse recordAuctionHouse() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Please Enter the Auction House Name");
        String name = sc.nextLine();
        System.out.println("Please Enter the Auction House first line of address");
        String address = sc.nextLine();
        System.out.println("Please Enter the Auction house postcode");
        String postcode = sc.nextLine();

        return new AuctionHouse(name, address, postcode);
    }


    /**
     * Code adapted from [source] https://github.com/newcastleuniversity-computing/csc1035-csc1036_practicals_2022/blob/solutions/part1/practical-10/src/IO.java
     * This method takes user input relating to the sold Item they wish to add.
     * It then asks the user which Auction House they want to add the Item to, and uses the searchAuctionouse method to find that Auction House.
     * It then returns that Item to that Auction House.
     * @return Item
     * **/
    private Item recordItem() {
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
        AuctionHouse auctionHouse = searchAuctionHouse(auctionHouseName);

        // if the auctionHouse is not equal to null it will add the Item to the auction house
        if (auctionHouse != null){
            //If auctionHouse not equal to null, print statement will run and will return Item
            System.out.println(ANSI_RED + "Items successfully added to " + auctionHouse);
            Item item = new Item(itemName, itemLotNumber, yearSold, buyer, category, price);
            //Adds item to auction house
            auctionHouse.addItem(item);

        }
        //If it is equal to null it will return null
        return null;
    }

    /**
     * This method searches for an Auction House given the name (not case-sensitive)
     * @param name
     * @return Auction house
     * **/
    private AuctionHouse searchAuctionHouse(String name){
        //Loops through the auctionHouses Array
        for (AuctionHouse auctionHouse: r.auctionHouses){
            //If the name inputted matches one in the auction houses array
            if (auctionHouse.getName().equalsIgnoreCase(name)){
                //It will return the auction house
                return auctionHouse;
            }
        }
        //Else the name doesn't match one in the Array it will tell the user it doesn't exist and return null
        System.out.println(ANSI_RED + "Auction house doesnt exist");
        return null;

    }



}
