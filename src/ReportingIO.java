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

                    break;
                case 2:

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



}
