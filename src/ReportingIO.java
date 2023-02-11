import java.util.ArrayList;
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
                    r.recordItem();
                    break;
                case 3:
                    double price = sc.nextDouble();
                    sc.nextLine();
                    System.out.println(r.filterItemByGreaterPrice(price));
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
                "3: Show items more expensive than inputted price\n" +
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
