package Events;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import Models.Customer;
import Models.Supermarket;
import Models.Time;

public class TillEvent extends Event {
    private Queue<Customer> q;
    private ArrayList<Customer> finishedCustomers;
    public static int maxCustInQueue;
    public static int avgQueueTime;

    public TillEvent() {
        q = new LinkedList<>();
        finishedCustomers = new ArrayList<>();

    }


    public void treatCustomer(ArrayList<Customer> custList) {
        int goodsScanned = 0;
        Time.setTime(custList.get(0).getCurrentTime());


        while (custList.size() > 0 || q.size() > 0) {
            if (custList.size() > 0) {
                Time.incrementTime();
                if (custList.get(0).getCurrentTime() <= Time.getTime()) {
                    if(custList.get(0).getGoods() < 1){
                        System.out.println("Customer " + custList.get(0).getId() + " has left the building with zero groceries");
                        custList.remove(0);
                    } else {
                        addCustToQueue(custList.get(0));
                        custList.remove(0);
                    }
                }
            }

            if (q.size() > 0) {
                if (goodsScanned < q.peek().getGoods()) {
                    goodsScanned++;
                } else if (goodsScanned == q.peek().getGoods()) {
                    System.out.println("Customer id: " + q.peek().getId() + " is done in the till queue. Total queue time: " + q.peek().getTimeInQueue());
                    Customer finished = q.remove();
                    // Adds the finished customer to the list
                    finishedCustomers.add(finished);
                    goodsScanned = 0;
                }
            }

            for (Customer cust : q) {
                cust.incrementTimeInQueue();
                cust.incrementCurrentTime();
            }

            // checking and setting the queue size for each iteration
            setMaxCustInQueue();
        }
    }


    // Ads a customer to the till queue when they are done shopping.
    private void addCustToQueue(Customer customer) {

        if (customer.getCurrentTime() <= Time.getTime()) {
            q.add(customer);
        }
    }


    private void setMaxCustInQueue(){

        if(q.size() > maxCustInQueue){
            maxCustInQueue = q.size();
        }
    }

    public int getMaxCustInQueue(){
        return maxCustInQueue;
    }

    public void setAvgQueueTime(){
        int totalTime = 0;

        for(Customer cust : finishedCustomers){
            totalTime += cust.getTimeInQueue();
        }
        avgQueueTime = totalTime/finishedCustomers.size();
    }

    public int getAvgQueueTime(){
        return avgQueueTime;
    }
}

