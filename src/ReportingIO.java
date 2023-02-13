import java.util.ArrayList;
import java.util.Scanner;

public class ReportingIO {
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_RESET = "\u001B[0m";
    public static void main(String[] args) {
        new ReportingIO().menuSystem();

    }
    Reporting r = new Reporting();


    /**
     * This method allows the user to interact with the menu system in the console.
     * **/
    public void menuSystem(){
        Scanner sc = new Scanner(System.in);
        int option = 0;
        while(option==0){
            System.out.println(ANSI_RESET + "Welcome to the Auction Company Menu System!\n" +
                    "1: To add an Auction House\n" +
                    "2: To add an item to a Auction House\n" +
                    "3: Show items more expensive than inputted price\n" +
                    "4: Most expensive Item\n" +
                    "5: The AuctionHouse with the largest average price for a given year.\n" +
                    "6: Quit");
            int choice = sc.nextInt();
            switch (choice){
                case 1:
                    r.addAuctionHouse(recordAuctionHouse());
                    break;
                case 2:
                    r.recordItem();
                    break;
                case 3:
                    System.out.println("Please input a price");
                    double price = sc.nextDouble();
                    sc.nextLine();
                    System.out.println(r.filterItemByGreaterPrice(price));
                    break;
                case 4:
                    System.out.println(r.mostExpensiveItemReporting());
                    break;
                case 5:
                    System.out.println("Please enter a year");
                    int year = sc.nextInt();
                    sc.nextLine();//Buffer
                    System.out.println(r.bestAuctionHouseAverageYear(year));
                    break;
                case 6:
                    System.out.println("Thank you for using the Auction House Menu system.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("This option isn't valid");
                    option = 0;
                    break;

            }
        }
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
}
