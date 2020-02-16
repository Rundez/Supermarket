package Models;

import java.util.Random;

public class Customer implements Comparable<Customer>  {
    private int goods;
    private int id;
    private int startTime;
    private int totalTime;
    private int currentTime;
    private int shoppingTime;
    public int timeInQueue;



    // Initializing the customer
    public Customer(int id) {

        // The goods will define for how long the customer will stay in the shopping phase.
        Random rand = new Random();
        goods = rand.nextInt(45) + 5;
        this.id = id;

        // When the customer arrives at the store
        int time  = rand.nextInt(719);
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

    public void incrementCurrentTime(){
        currentTime++;
    }

    public int getTimeInQueue(){
        return timeInQueue;
    }

    public void incrementTimeInQueue(){
        timeInQueue++;
    }

    public void setTimeInQueue(int timeInQueue){
        this.timeInQueue = timeInQueue;
    }

    @Override
    public int compareTo(Customer c) {

        return getCurrentTime().compareTo(c.getCurrentTime());
    }
}
