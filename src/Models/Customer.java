package Models;

import java.util.Random;

public class Customer {
    private int goods;
    private int id;
    private long time;
    private long totalTime;
    // Initializing the customer, using the time parameter to handle the timing throughout the events.
    Customer(long time) {
        this.time = time;

        // The goods will define for how long the customer will stay in the shopping phase.
        Random rand = new Random();
        goods = rand.nextInt(45) + 5;

    }

    public int getGoods() {
        return goods;
    }

    public void setGoods(int goods) {
        this.goods = goods;
    }

    public long getObjectTime() {
        return Time.getTime() - time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
