package Events;

import Models.Customer;


import java.util.LinkedList;
import java.util.Queue;

public class EnterEvent extends Event {
    private Queue<Customer> customers = new LinkedList<>();

    // Starts the event, adding customers to the event and how often they will be added.
    public EnterEvent(Customer cust, long frequency) {
        customers.add(cust);
    }



}
