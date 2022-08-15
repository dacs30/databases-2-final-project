import java.util.Scanner;

public class App {

    // isQuit function
    public static boolean isQuit(String input) {
        return input.equals("Q");
    }

    // create process command that checks for SQL commands
    // create function that interpret which command to execute
    public static void processCommand(String[] commStrings) {

        // create a string from cmdStrings
        String cmdString = "";
        for (int i = 0; i < commStrings.length; i++) {
            cmdString += commStrings[i] + " ";
        }

        cmdString = cmdString.trim();

        System.out.println("Command: " + cmdString);

        

        // check if cmdString is a SQL command
        if(cmdString.equals("SELECT A.COL1, A.COL2, B.COL1, B.COL2 FROM A, B WHERE A.RANDOMV = B.RANDOMV")){
            System.out.println("Hash based join...");
            HashBasedJoin hbj = new HashBasedJoin();
            hbj.createHashMap(commStrings);
            hbj.join();	
        } else if(cmdString.equals("SELECT count(*) FROM A, B WHERE A.RandomV > B.RandomV")){
            // NOT WORKING
            System.out.println("Block level nested loop join...");
        } else if(commStrings.length > 5){
            if(commStrings[5].trim().equals("GROUP")){
                if(commStrings[2].equals("SUM(RANDOMV)")){
                    // create an instance of the HashBasedAggregation class
                    HashBasedAggregation hba = new HashBasedAggregation("SUM", commStrings[4]);
                    // call the aggregation function
                    hba.aggregation();
                } else if(commStrings[2].equals("AVG(RANDOMV)")){
                    // create an instance of the HashBasedAggregation class
                    HashBasedAggregation hba = new HashBasedAggregation("AVG", commStrings[4]);
                    // call the aggregation function
                    hba.aggregation();
                } 
            }
        } else {
            System.out.println("Invalid command");
        }

    }

    public static void main(String[] args) throws Exception {
        // create scanner
        Scanner scanner = new Scanner(System.in);
        int flag = 0;
        String letter = "";

        do {

            System.out.println("\nProgram is ready and waiting for user command.");
            letter = scanner.nextLine();
            // make letter uppercase
            letter = letter.toUpperCase();
            if (isQuit(letter)) {
                flag = 2;
            } else if (letter.split(" ").length > 1) {
                System.out.println("\nGetting and processing input...");
                processCommand(letter.split(" "));
            } else {
                System.out.println("Invalid command");
            }

        } while (flag == 0);

    }
}
