package Events;

import Models.Customer;


import java.util.LinkedList;
import java.util.Queue;

public class EnterEvent extends Event {
    private Queue<Customer> customers = new LinkedList<>();


    public EnterEvent(Customer cust) {
        customers.add(cust);
    }



}
