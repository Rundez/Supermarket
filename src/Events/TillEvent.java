package Events;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import Models.Customer;
import Models.Supermarket;
import Models.Time;

public class TillEvent extends Event {
    private Queue<Customer> q;
    private int maxQueue;
    private int currentQueue;

    public TillEvent() {
        q = new LinkedList<>();

    }


    public void treatCustomer(ArrayList<Customer> custList) {
        int goodsScanned = 0;
        Time.setTime(custList.get(0).getCurrentTime());

        while (custList.size() > 0 || q.size() > 0)  {
            if(custList.size() > 0) {
                Time.incrementTime();
                if (custList.get(0).getCurrentTime() <= Time.getTime()) {
                    addCustToQueue(custList.get(0));
                    custList.remove(0);
                }
            }

            if (q.size() > 0) {
                if (goodsScanned < q.peek().getGoods()) {
                    goodsScanned++;
                } else if (goodsScanned == q.peek().getGoods()){
                    System.out.println(q.peek().getId() + " is done in the till queue. Total queue time: " + q.peek().getTimeInQueue());
                    q.remove();
                    goodsScanned = 0;

                }
            }

            for (Customer cust : q) {
                cust.incrementTimeInQueue();
                cust.incrementCurrentTime();
            }

        }

    }


    // Ads a customer to the till queue when they are done shopping.
    private void addCustToQueue(Customer customer) {

        if (customer.getCurrentTime() <= Time.getTime()) {
            q.add(customer);
        }
    }
}

