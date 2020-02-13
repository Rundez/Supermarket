package Models;

import java.util.Random;

public class Customer {
    private int goods;
    private int id;
    private long startTime;
    private long totalTime;

    // Initializing the customer
    public Customer(int id) {

        // The goods will define for how long the customer will stay in the shopping phase.
        Random rand = new Random();
        goods = rand.nextInt(45) + 5;
        this.id = id;

        // As the customer is generated, the start time will be assigned.
        startTime = Time.getTime();

    }

    public int getGoods() {
        return goods;
    }

    public long getTotalTime() {
        return Time.getTime() - startTime;
    }

    public void setTotalTime() {
        totalTime = Time.getTime() - startTime;
    }

    public int getId(){
        return id;
    }
}
