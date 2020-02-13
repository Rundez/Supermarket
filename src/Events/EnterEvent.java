package Events;

import Models.Customer;


import java.util.ArrayList;


public class EnterEvent extends Event {
    private ArrayList<Customer> customerList = new ArrayList<>();

    // Starts the event, adding customers to the event and how often they will be added.
    public EnterEvent() {

    }

    private void arrivalTime(Customer cust){

    }

    public void generateCustomers(){

        // Temp variable for creating customers.
        int customers = 10;

        for(int i = 0; i <= customers; i++){

            Customer cust = new Customer(i);
            customerList.add(cust);

        }
    }

    public void printCustomerInfo(){
        for (Customer cust: customerList) {

            System.out.println("Customer id: " + cust.getId() + ", created at: " + cust.getTotalTime());
        }
    }



}
