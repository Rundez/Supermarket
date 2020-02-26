package Events;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import Models.Customer;
import Models.Supermarket;
import Models.Till;
import Models.Time;

public class TillEvent2 extends Event {
    private ArrayList<Customer> finishedCustomers;
    private ArrayList<Till> tillList;
    private int avgQueueTime;

    public TillEvent2(int numberOfTills) {
        finishedCustomers = new ArrayList<>();
        tillList = new ArrayList<>();


        // Initialize all the tills
        int id = 0;
        for (int i = 0; i <= numberOfTills; i++) {
            tillList.add(new Till(id));
            id++;
        }
    }

    // Main method of treating customers in the till event. 
    public void treatCustomer(ArrayList<Customer> custList) {
        //int goodsScanned = 0;
        Time.setTime(custList.get(0).getCurrentTime());

        // Adds a customer to the till queue and deletes the customer from the ArrayList
        while (custList.size() > 0 || isQueueFilled()) {
            setMaxCustInQueue();
            if (custList.size() > 0) {
                Time.incrementTime();
                if (custList.get(0).getCurrentTime() <= Time.getTime()) {
                    addCustToQueue(custList.get(0));
                    custList.remove(0);
                }
            }

            // Iterates through the queues, scans the goods and removes the customer from the queue if all the goods is scanned
            for (Till till : tillList) {
                incrementCustomerTime();

                if (till.q.size() > 0) {
                    if (till.getGoodScanned() < till.q.peek().getGoods()) {
                        till.incrementGoodsScanned();
                    } else if (till.getGoodScanned() >= till.q.peek().getGoods()) {
                        System.out.println("Customer id: " + till.q.peek().getId() + " is done in the till queue. Total queue time: " + till.q.peek().getTimeInQueue());
                        Customer finished = till.q.remove();
                        // Adds the finished customer to the list
                        finishedCustomers.add(finished);
                        till.setGoodScanned(0);
                    }
                }

                // Increments the time each customer have spent in the queue
                for (Customer cust : till.q) {
                    cust.incrementTimeInQueue();
                }
            }
        }
    }


    // Increments the time each customer have spent in the simulation
    private void incrementCustomerTime() {
        for (int i = 0; i < tillList.get(i).q.size(); i++) {
            for (Customer cust : tillList.get(i).q) {
                cust.incrementCurrentTime();
            }
        }
    }

    // Returns the queue which have the lowest number of customers waiting.
    private Till returnShortestQueue() {
        Till lowestQueue = new Till(0);

        for (int i = 0; i < tillList.size(); i++) {
            if (tillList.get(i).q.size() <= lowestQueue.q.size()) {
                lowestQueue = tillList.get(i);
            }
        }
        return lowestQueue;
    }

    // Returns true if any of the queues is filled with 1 or more persons
    private boolean isQueueFilled() {
        int filled = 0;

        for (Till till : tillList) {
            if (till.q.size() > 0) {
                filled++;
            }
        }
        return filled > 0;
    }

    // Ads a customer to the till queue when they are done shopping.
    private void addCustToQueue(Customer customer) {

        if (customer.getCurrentTime() <= Time.getTime()) {
            returnShortestQueue().q.add(customer);
        }
    }

    private void setMaxCustInQueue() {

        for (Till till : tillList) {
            if (till.q.size() >= till.getMaxCustInQueue()) {
                till.incrementMaxCustInQueue();
            }
        }
    }

    public void printMaxCustInQueue() {
        for (Till till : tillList) {
            System.out.println("Maximum customers in queue: " + till.getId() + " is : " + till.getMaxCustInQueue());
        }
    }

    public void setAvgQueueTime() {
        int totalTime = 0;

        for (Customer cust : finishedCustomers) {
            totalTime += cust.getTimeInQueue();
        }
        avgQueueTime = totalTime / finishedCustomers.size();
    }

    public int getAvgQueueTime() {
        return avgQueueTime;
    }

    public ArrayList<Customer> getFinishedCustomers() {
        return finishedCustomers;
    }
}

