import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class HashBasedAggregation {

    private String aggregationQuery;
    private String dataset;
    private HashMap<String, Integer[]> hashMap;

    // constructor
    public HashBasedAggregation(String aggregationQuery, String dataset) {
        this.aggregationQuery = aggregationQuery;
        this.dataset = dataset;
        this.hashMap = new HashMap<String, Integer[]>(50);
    }

    // getter for query
    public String getQuery() {
        return this.aggregationQuery;
    }

    // getter for dataset
    public String getDataset() {
        return this.dataset;
    }

    // aggregation function
    public void aggregation() {
        // check if average or sum
        if (this.aggregationQuery.equals("AVG")) {
            // call the average function
            average();
        } else if (this.aggregationQuery.equals("SUM")) {
            // call the sum function
            sum();
        }
    }

    // average function
    public void average() {
        // read data from dataset
        try {

            // start a timer in milliseconds
            long startTime = System.currentTimeMillis();

            for (int i = 1; i < 100; i++) {

                File file = new File(this.dataset.equals("A") ? "Project3Dataset-A/A" + i + ".txt"
                        : "Project3Dataset-B/B" + i + ".txt");

                Scanner reader = new Scanner(file);

                String content = reader.nextLine();

                String[] array = content.split(this.dataset.equals("A") ? "(?=A)" : "(?=B)");

                // go over each record on the file that is now inside an array
                for (int j = 0; j < array.length; j++) {

                    // print the name of the record
                    // name: array[j].substring(12, 19)
                    // randomvalue: array[j].substring(33, 37)

                    // check if the hashmap contains the random value using the name as key
                    if (this.hashMap.containsKey(array[j].substring(12, 19))) {

                        // new sum of all values
                        int newValue = this.hashMap.get(array[j].substring(12, 19))[0]
                                + Integer.parseInt(array[j].substring(33, 37));

                        // add the current to the array
                        Integer[] ints = { newValue, this.hashMap.get(array[j].substring(12, 19))[1] + 1 };

                        // add the current to the array
                        this.hashMap.put(array[j].substring(12, 19), ints);
                    } else {
                        // create array to be inserted in the hashmap
                        Integer[] ints = { Integer.parseInt(array[j].substring(33, 37)), 1 };

                        // add the current to the hashmap
                        this.hashMap.put(array[j].substring(12, 19), ints);
                    }

                }

            }

            // end the timer in milliseconds
            long endTime = System.currentTimeMillis();

            // print names with average of random values per name
            for (String key : this.hashMap.keySet()) {
                System.out.println(key + " | " + (this.hashMap.get(key)[0] / this.hashMap.get(key)[1]));
            }

            // print performace
            System.out.println("Average time: " + (endTime - startTime) + " milliseconds");

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    // sum function
    public void sum() {
        // read data from dataset 2
        // read data from dataset
        try {

            // start a timer in milliseconds
            long startTime = System.currentTimeMillis();

            for (int i = 1; i < 100; i++) {

                File file = new File(this.dataset.equals("A") ? "Project3Dataset-A/A" + i + ".txt"
                        : "Project3Dataset-B/B" + i + ".txt");

                Scanner reader = new Scanner(file);

                String content = reader.nextLine();

                String[] array = content.split(this.dataset.equals("A") ? "(?=A)" : "(?=B)");

                // go over each record on the file that is now inside an array
                for (int j = 0; j < array.length; j++) {

                    // print the name of the record
                    // name: array[j].substring(12, 19)
                    // randomvalue: array[j].substring(33, 37)

                    // check if the hashmap contains the random value using the name as key
                    if (this.hashMap.containsKey(array[j].substring(12, 19))) {

                        // new sum of all values
                        int newValue = this.hashMap.get(array[j].substring(12, 19))[0]
                                + Integer.parseInt(array[j].substring(33, 37));

                        // add the current to the array
                        Integer[] ints = { newValue, 1 };

                        // add the current to the array
                        this.hashMap.put(array[j].substring(12, 19), ints);
                    } else {    
                        // create array to be inserted in the hashmap
                        Integer[] ints = { Integer.parseInt(array[j].substring(33, 37)), 1 };

                        // add the current to the hashmap
                        this.hashMap.put(array[j].substring(12, 19), ints);
                    }

                    // if(array[j].substring(12, 19).equals("Name044")) {
                    //     System.out.println(array[j].substring(12, 19) + " | " + array[j].substring(33, 37));
                    // }

                }

            }

            // end the timer in milliseconds
            long endTime = System.currentTimeMillis();

            // print names with average of random values per name
            for (String key : this.hashMap.keySet()) {
                System.out.println(key + " | " + this.hashMap.get(key)[0]);
            }

            // print performace
            System.out.println("Average time: " + (endTime - startTime) + " milliseconds");

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

    }
}
