package Events;

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

    public void addToQueue(Customer customer){
        q.add(customer);

    }

    public void treatCustomer(){
        int goodsScanned = 0;

        if (goodsScanned < q.peek().getGoods()){
            goodsScanned++;
            Time.incrementTime();
            q.peek().incrementTimeInQueue();
            q.peek().incrementCurrentTime();
        } else {
            System.out.println(q.peek().getId() + "Is done in the Queue");
            q.remove();

        }

    }




}
