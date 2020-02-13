package Events;

import Models.Customer;


import java.util.ArrayList;


public class EnterEvent extends Event {
    private ArrayList<Customer> customerList = new ArrayList<>();

    // Starts the event, adding customers to the event and how often they will be added.
    public EnterEvent() {

    }

    private void arrivalTime(Customer cust){
        System.out.println(cust.getObjectTime());
    }

    private void addCustomer(Customer cust){
        customerList.add(cust);
    }



}
