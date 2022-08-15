import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class HashBasedJoin {

    private HashMap<String, List<String>> hashMap;

    // create constructor that initializes a 50 size hashmap
    public HashBasedJoin() {
        this.hashMap = new HashMap<String, List<String>>(50);
    }

    // getter for hashmap
    public HashMap<String, List<String>> getHashMap() {
        return this.hashMap;
    }

    // create a setter to the hashmap
    public void setHashMap(HashMap<String, List<String>> hashMap) {
        this.hashMap = hashMap;
    }

    public void join() {
        // read data from dataset 2
        try {

            // start a timer in milliseconds
            long startTime = System.currentTimeMillis();

            for (int i = 1; i < 100; i++) {

                File file = new File("Project3Dataset-B/B" + i + ".txt");

                Scanner reader = new Scanner(file);

                String content = reader.nextLine();

                String[] array = content.split("(?=B)");

                // go over each record on the file that is now inside an array
                for (int j = 0; j < array.length; j++) {

                    if (this.hashMap.containsKey(array[j].substring(33, 37))) {
                        // add the current to the array
                        for (String s : this.hashMap.get(array[j].substring(33, 37))) {
                            System.out.println(s.substring(0, 18) + " | " + array[j].substring(0, 18));
                        }

                    }

                }

            }

            // end the timer in milliseconds
            long endTime = System.currentTimeMillis();

            // print performace
            System.out.println("\nPerformance: " + (endTime - startTime) + " ms");

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    // create with randomV from project 3 dataset A
    public void createHashMap(String[] randomV) {

        System.out.println("Creating hashmap...");

        // create a hashmap to store the data and an array to store the data
        HashMap<String, List<String>> resultHashMap = new HashMap<String, List<String>>(50);

        try {

            for (int i = 1; i < 100; i++) {

                File file = new File("Project3Dataset-A/A" + i + ".txt");

                Scanner reader = new Scanner(file);

                String content = reader.nextLine();

                String[] array = content.split("(?=A)");

                // go over each record on the file that is now inside an array
                for (int j = 0; j < array.length; j++) {

                    if (resultHashMap.containsKey(array[j].substring(33, 37))) {
                        List<String> temp = resultHashMap.get(array[j].substring(33, 37));
                        temp.add(array[j]);

                        // if it is, add the location to the value
                        resultHashMap.put(array[j].substring(33, 37), temp);
                    } else {
                        List<String> temp = new java.util.ArrayList<String>();
                        temp.add(array[j]);

                        // if it is not, add the location to the value
                        resultHashMap.put(array[j].substring(33, 37), temp);
                    }

                }

            }

            setHashMap(resultHashMap);

            // print the keys and values
            // for (String key : resultHashMap.keySet()) {
            // for (String s : resultHashMap.get(key)) {
            // System.out.println(s);
            // }
            // }

            System.out.println("Hashmap for dataset in A created.");

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

}
