package collections;

import java.util.HashMap;

class HashMapDemo {
    public static void main(String args[]) {
        HashMap<String, Double> balance = new HashMap<>();
        //ConcurrentHashMap balance<String, Double> = new ConcurrentHashMap<>(); // for multi-threading

        balance.put("John Doe", 3434.34);
        balance.put("Tom Smith", null);
        balance.put("Jane Baker", null);
        balance.put("Tod Hall", 99.22);
        balance.put("Ralph Smith", -19.08);
        balance.put(null, 0.0);

        // Iterate through all the keys and print the values
        for (String key : balance.keySet()) {
            System.out.println("Key: " + key + ", Value: " + balance.get(key));
        }
        System.out.println("");

        String key = "John Doe";
        // Deposit 1,000 into John Doe's account
        double bal = balance.get(key);
        balance.put(key, bal + 1000);
        System.out.println(key + "'s new balance: " + balance.get(key));

    }
}


