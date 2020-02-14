package Models;

import java.util.Random;

public class Customer {
    private int goods;
    private int id;
    private int startTime;
    private int totalTime;

    // Initializing the customer
    public Customer(int id) {

        // The goods will define for how long the customer will stay in the shopping phase.
        Random rand = new Random();
        goods = rand.nextInt(45) + 5;
        this.id = id;

        // When the customer arrives at the store
        this.startTime = rand.nextInt(650);

    }

    public int getGoods() {
        return goods;
    }

    public int getTotalTime() {
        return Time.getTime() - startTime;
    }

    public int getStartTime(){
        return startTime;
    }

    public int getId(){
        return id;
    }
}
