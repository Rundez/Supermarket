package Models;

import java.util.Random;

public class Customer implements Comparable<Customer>  {
    private int goods;
    private int id;
    private int startTime;
    private int totalTime;
    private int currentTime;
    private int shoppingTime;


    // Initializing the customer
    public Customer(int id) {

        // The goods will define for how long the customer will stay in the shopping phase.
        Random rand = new Random();
        goods = rand.nextInt(45) + 5;
        this.id = id;

        // When the customer arrives at the store
        int time  = rand.nextInt(650);
        startTime = time;
        currentTime = time;


    }

    public int getGoods() {
        return goods;
    }

    public int getTotalTime() {
        return Time.getTime() - startTime;
    }

    public Integer getStartTime(){
        return startTime;
    }

    public int getId(){
        return id;
    }

    public void setTime(int time){
        currentTime = time;
    }

    public int getShoppingTime(){
        return shoppingTime;
    }

    public void setShoppingTime(int shoppingTime){
        this.shoppingTime = shoppingTime;
    }

    public Integer getCurrentTime(){
        return currentTime;
    }

    @Override
    public int compareTo(Customer c) {

        return getCurrentTime().compareTo(c.getCurrentTime());
    }
}
