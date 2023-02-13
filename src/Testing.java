public class Testing {
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";

    /***
     * This main method is used to test my methods in the AuctionHouse class and methods in my Reporting class
     * @param args
     */
    public static void main(String[] args) {

        Reporting r = new Reporting();

        /*
        Testing values
         */
        AuctionHouse auctionHouse1 = new AuctionHouse("Bid to buy", "123 Auction street", "SE1 1IG");
        AuctionHouse auctionHouse2 = new AuctionHouse("Bidders Dream", "33 Bidster Ave", "B16 4UU");
        Item item1 = new Item("Mona Lisa", 1, 2023, "Jackie Chan", "Painting", 12000000);
        Item item2 = new Item("Couch", 2, 2023, "Jenny Baptiste", "Furniture", 50);
        Item item3 = new Item("Julius Caesar", 3, 2022, "Justin Jackson", "Sculpture", 50000000);
        Item item4 = new Item("The Starry Night", 4, 2023, "Katie Birch", "Painting", 2000000);
        Item item5 = new Item("Old Chair", 5, 2021, "Craig Jones", "Furniture", 600);
        Item item6 = new Item("Vintage Table", 6, 2022, "Sonia Watson", "Furniture", 900);

        r.addAuctionHouse(auctionHouse1);//PASSED Auction houses successfully added
        r.addAuctionHouse(auctionHouse2);//PASSED Auction houses successfully added
        auctionHouse1.addSoldItem(item1);//PASSED Item added successfully
        auctionHouse1.addSoldItem(item2);//PASSED Item added successfully
        auctionHouse1.addSoldItem(item3);//PASSED Item added successfully
        auctionHouse2.addSoldItem(item4);//PASSED Item added successfully
        auctionHouse2.addSoldItem(item5);//PASSED Item added successfully
        auctionHouse2.addSoldItem(item6);//PASSED Item added successfully

        /*
        Reporting Class Tests
         */
        System.out.println(ANSI_RED + "The most expensive item is \n" + ANSI_GREEN + r.mostExpensiveItemReporting());//PASSED Returns Julius Caesar Item
        System.out.println(ANSI_RED + "List of all items over 1000 \n" + ANSI_GREEN + r.filterItemByGreaterPrice(1000));//PASSED Returns Julius Caesar Item, The Starry Night Item, Mona Lisa Item
        System.out.println(ANSI_RED + "The best performing Auction House based on Average Item price in year 2022 is \n" + ANSI_GREEN +r.bestAuctionHouseAverageYear(2023));//PASSED Returned Bid to Buy
        /*
        AuctionHouse class Tests
         */
        System.out.println(ANSI_RED + "A list of items in Bid to buy's Auction house is \n" + ANSI_GREEN + auctionHouse1.getItemsInAuctionHouse());//PASSED Returns Julius Caesar Item, Mona List Item, Couch Item
        System.out.println(ANSI_RED + "A list of items in Bidders Dream's Auction house is \n" + ANSI_GREEN + auctionHouse2.getItemsInAuctionHouse());//PASSED Returns The Starry Night, Old Chair, Vintage Table
        System.out.println(ANSI_RED + "Average price of Items in Bid to buy's Auction house in 2023 is \n" + ANSI_GREEN + auctionHouse1.averageItemPriceGivenYear(2023));//PASSED Returns 6000025
        System.out.println(ANSI_RED + "Average price of Items in Bidders Dream's Auction house in 2022 is \n" + ANSI_GREEN + auctionHouse2.averageItemPriceGivenYear(2022));//PASSED Returns 1000450.0
        System.out.println(ANSI_RED + "The number of Items in Bid to Buy's Auction house is \n" + ANSI_GREEN + auctionHouse1.numOfItems);//PASSED Returned 3
        System.out.println(ANSI_RED + "The number of Items in Bidders Dream's Auction house is \n" + ANSI_GREEN + auctionHouse2.numOfItems);//PASSED Returned 3
        System.out.println(ANSI_RED + "The most expensive item in Bid to Buy's Auction house is \n" + ANSI_GREEN + auctionHouse1.mostExpensiveItem());//PASSED Returned Julius Caesar Item
        System.out.println(ANSI_RED + "The most expensive item in Bidders Dream's Auction house is \n" + ANSI_GREEN + auctionHouse2.mostExpensiveItem());//PASSED Returned Starry Night Item
        System.out.println(ANSI_RED + "Items greater than the inputted price of 100 in Bid to Buy's Auction house is \n" + ANSI_GREEN + auctionHouse1.filterItemsByPrice(100));//PASSED Returned Mona Lisa Item, Julius Caesar Item
        System.out.println(ANSI_RED + "Items greater than the inputted price of 600 in Bidders Dream Auction house is \n" + ANSI_GREEN + auctionHouse2.filterItemsByPrice(600));//PASSED Returned Vintage table Item, The Starry Night Item


    }
}
