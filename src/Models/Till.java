package Models;

import Models.Customer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class Till {

    private final int SCANSPEED = 1;
    public Queue<Customer> q;
    private int maxCustInQueue;
    private int averageCustInQueue;
    private int id;
    private int goodScanned;

    public int getGoodScanned() {
        return goodScanned;
    }
    public void incrementGoodsScanned(){
        goodScanned = goodScanned + 1;
    }

    public void setGoodScanned(int goodScanned) {
        this.goodScanned = goodScanned;
    }

    public int getSCANSPEED() {
        return SCANSPEED;
    }

    public Queue<Customer> getQ() {
        return q;
    }

    public void setQ(Queue<Customer> q) {
        this.q = q;
    }

    public int getMaxCustInQueue() {
        return maxCustInQueue;
    }

    public void setMaxCustInQueue(int maxCustInQueue) {
        this.maxCustInQueue = maxCustInQueue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void incrementMaxCustInQueue() {
        this.maxCustInQueue = maxCustInQueue +1;
    }

    public int getAverageCustInQueue() {
        return averageCustInQueue;
    }

    public void setAverageCustInQueue(int averageCustInQueue) {
        this.averageCustInQueue = averageCustInQueue;
    }

    public Till(int id) {
        q = new LinkedList<Customer>();
        this.id = id;
    }

    public void treatCustomer(Customer cust)   {
        int custGoods = cust.getGoods();

        while(custGoods > 0) {
            custGoods--;
            Time.incrementTime();
        }
    }
}
