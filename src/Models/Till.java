package Models;

import Models.Customer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class Till {

    private final int SCANSPEED = 1;
    public Queue<Customer> q;

    public Till() {
        q = new LinkedList<Customer>();
    }

    public void treatCustomer(Customer cust)   {
        int custGoods = cust.getGoods();

        while(custGoods > 0) {
            custGoods--;
            Time.incrementTime();
        }
    }
}
