package Models;

import Models.Customer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class Till {

    private int scanFrequency = 5;


    public Till() {

    }

    public void treatCustomer(Customer cust) throws InterruptedException {
        int custGoods = cust.getGoods();

        while(custGoods >= 0) {
            TimeUnit.MILLISECONDS.sleep(scanFrequency);
            custGoods--;
        }

    }
}
