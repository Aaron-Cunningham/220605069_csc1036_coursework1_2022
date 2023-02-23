public class Testing {
    private static final String ANSI_RED = "\u001B[31m";
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
        Item item1 = new Item("Mona Lisa", "K543", 2023, "Jackie Chan", "Painting", 12000000);
        Item item2 = new Item("Couch", "F442", 2023, "Jenny Baptiste", "Furniture", 50);
        Item item3 = new Item("Julius Caesar", "F432", 2022, "Justin Jackson", "Sculpture", 50000000);
        Item item4 = new Item("The Starry Night", "R44", 2023, "Katie Birch", "Painting", 2000000);
        Item item5 = new Item("Old Chair", "D222", 2021, "Craig Jones", "Furniture", 600);
        Item item6 = new Item("Vintage Table", "A123", 2022, "Sonia Watson", "Furniture", 900);

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

        //Test to view most expensive item
        if(r.mostExpensiveItemReporting().equals(item3)){
            System.out.println(ANSI_GREEN + "Most expensive item: Pass");
        }else {
            System.out.println(ANSI_RED + "Most expensive item: Fail");
        }

        //Test to filter item by given price
        if(r.filterItemByGreaterPrice(1000).contains(item1) && r.filterItemByGreaterPrice(1000).contains(item4) && r.filterItemByGreaterPrice(1000).contains(item3)){
            System.out.println(ANSI_GREEN + "Filter item given price: Pass");
        }else{
            System.out.println(ANSI_RED + "Filter item given price: Fail");
        }

        //Test the auction house with the highest average given the year method
        if(r.bestAuctionHouseAverageYear(2023).equals(auctionHouse1)){
            System.out.println(ANSI_GREEN + "Auction house with highest average given year: Pass");
        }else{
            System.out.println("Auction house with highest average given year: Fail");
        }


        /*
        AuctionHouse class Tests
         */

        //Test to view items in auction house 1
        if(auctionHouse1.getItemsInAuctionHouse().contains(item1) && auctionHouse1.getItemsInAuctionHouse().contains(item2) && auctionHouse1.getItemsInAuctionHouse().contains(item3)){
            System.out.println(ANSI_GREEN + "Items in auction house 1: Pass");
        } else {
            System.out.println(ANSI_RED + "Items in auction house 1: Fail");
        }

        //Test to view average item price in auction house 1
        if(auctionHouse1.averageItemPriceGivenYear(2023) == 6000025){
            System.out.println(ANSI_GREEN + "Average item price auction house 1: Pass");
        } else{
            System.out.println(ANSI_RED + "Average item price auction house 1: Fail");
        }

        //Test to view average item price in auction house 2
        if(auctionHouse2.averageItemPriceGivenYear(2022) == 900){
            System.out.println(ANSI_GREEN + "Average item price auction house 2: Pass");
        } else{
            System.out.println(ANSI_RED + "Average item price auction house 2: Fail");
        }

        //Test on most expensive item method in auction house 1
        if(auctionHouse1.mostExpensiveItem().equals(item3)) {
            System.out.println(ANSI_GREEN + "Most expensive item in auction house 1: Pass");
        }else{
            System.out.println(ANSI_RED + "Most expensive item in auction house 1: Fail");
        }

        //Test on most expensive item method in auction house 2
        if(auctionHouse2.mostExpensiveItem().equals(item4)){
            System.out.println(ANSI_GREEN + "Most expensive item in auction house 2: Pass");

        }else {
            System.out.println(ANSI_RED + "Most expensive item in auction house 2: Fail");
        }

        //Test on filter items by price in auction house 1
        if (auctionHouse1.filterItemsByPrice(100).contains(item1) && auctionHouse1.filterItemsByPrice(100).contains(item3)){
            System.out.println(ANSI_GREEN + "Filter items by price auction house 1: Pass");
        }else {
            System.out.println(ANSI_RED + "Filter items by price auction house 1: Fail");
        }

        //Test on filter items by price in auction house 2
        if(auctionHouse2.filterItemsByPrice(600).contains(item6) && auctionHouse2.filterItemsByPrice(600).contains(item4)){
            System.out.println(ANSI_GREEN + "Filter items by price auction house 2: Pass");
        }else {
            System.out.println(ANSI_RED + "Filter items by price auction house 2: Fail");
        }

        //Test on auction house 1 getName method
        if(auctionHouse1.getName().equals("Bid to buy")){
            System.out.println(ANSI_GREEN + "Auction house 1 name: Pass");
        }else {
            System.out.println(ANSI_RED + "Auction house 1 name: Fail");
        }

        //Test on auction house 2 getName method
        if(auctionHouse2.getName().equals("Bidders Dream")){
            System.out.println(ANSI_GREEN + "Auction house 2 name: Pass");
        }else {
            System.out.println(ANSI_RED + "Auction house 2 name: Fail");
        }

        //Test to check if validation works for yearCheck
        Item item8 = new Item("Test", "A123", 2024, "Sonia Watson", "Furniture", 90012121);//PASSED
        auctionHouse1.addSoldItem(item8);

        //Test to check if validation works for priceCheck
        Item item9 = new Item("Vintage Table", "A123", 2022, "Sonia Watson", "Furniture", -1);//PASSED
        auctionHouse2.addSoldItem(item9);



    }



}
