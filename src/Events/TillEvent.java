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


    public void treatCustomer() {
        int goodsScanned = 0;

        while (goodsScanned <= q.peek().getGoods()) {
            if (goodsScanned < q.peek().getGoods()) {
                goodsScanned++;
                Time.incrementTime();
                q.peek().incrementTimeInQueue();
                q.peek().incrementCurrentTime();
            } else {
                System.out.println(q.peek().getId() + " is done in the Queue. Total queue time: " + q.peek().getTimeInQueue());
                q.remove();
            }
        }

    }


    // Ads a customer to the till queue when they are done shopping.
    public void addToQueue(ArrayList<Customer> customers) {

        int i = 0;
        while (Time.getTime() < Time.getMaxTime() && i < customers.size()) {
            if (customers.get(i).getCurrentTime() >= Time.getTime()) {
                q.add(customers.get(i));
            }

            i++;
        }

        treatCustomer();
    }
}
