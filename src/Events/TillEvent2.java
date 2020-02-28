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
    private Till lowestQueue;

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

        Time.setTime(custList.get(0).getCurrentTime());

        // Adds a customer to the till queue and deletes the customer from the ArrayList
        while (custList.size() > 0 || isQueueFilled()) {

            if (custList.size() > 0) {
                Time.incrementTime();
                if (custList.get(0).getCurrentTime() <= Time.getTime()) {

                    setShortestQueue();
                    lowestQueue.q.add(custList.get(0));
                    custList.remove(0);
                }
            }

            // Iterates through the queues, scans the goods and removes the customer from the queue if all the goods is scanned
            for (Till till : tillList) {
                incrementCustomerTime();
                setMaxCustInQueue();
                if (till.q.size() > 0) {
                    if (till.getGoodScanned() < till.q.peek().getGoods()) {
                        till.incrementGoodsScanned();

                    } else if (till.getGoodScanned() >= till.q.peek().getGoods()) {
                        System.out.println("Customer id: " + till.q.peek().getId() + " is done in the till queue. Total queue time: " + till.q.peek().getTimeInQueue());
                        // Adds the finished customer to the list
                        finishedCustomers.add(till.q.poll());
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
        int x = 0;
        if (tillList.get(x).q.size() != 0) {
            for (int i = 0; i < tillList.size(); i++) {
                for (Customer cust : tillList.get(i).q) {
                    cust.incrementCurrentTime();
                }
                x++;
            }
        }
    }

    // Returns the queue which have the lowest number of customers waiting.
    private void setShortestQueue() {
        this.lowestQueue = tillList.get(0);

        for (Till till : tillList) {
            if (till.q.size() <= lowestQueue.q.size()) {
                lowestQueue = till;
            }
        }
    }

    // Returns true if any of the queues is filled with 1 or more persons
    private boolean isQueueFilled() {
        int filled = 0;

        for (Till till : tillList) {
            if (till.q.size() > 0) {
                filled = till.q.size();
            }
        }
        return filled > 0;
    }


    private void setMaxCustInQueue() {

        for (Till till : tillList) {
            if (till.q.size() >= till.getMaxCustInQueue()) {
                till.setMaxCustInQueue(till.q.size());
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

