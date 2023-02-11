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
            Scanner input = new Scanner(System.in);
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
                "4: Most Expensive Item" +
                "5: \n\n");
    }

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
        return new Item(itemName, itemLotNumber, yearSold, buyer, category, price);

    }



}
