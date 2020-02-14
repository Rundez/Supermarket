package Events;

import Models.Customer;


import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


public class EnterEvent extends Event {
    private ArrayList<Customer> customerList = new ArrayList<>();

    // Starts the event, adding customers to the event and how often they will be added.
    public EnterEvent() {

    }

    private void arrivalTime(Customer cust){

    }

    public void generateCustomers(long custFrequency) throws InterruptedException {



        // Temp variable for creating customers.
        int customers = 10;

        for(int i = 0; i <= customers; i++){
            // Sleeps the program to differenciate the arrival of each customer.
            TimeUnit.MILLISECONDS.sleep(custFrequency);

            Customer cust = new Customer(i);
            customerList.add(cust);
            System.out.println("Customer created");

        }
    }

    public void printCustomerInfo()  {
        for (Customer cust: customerList) {

            cust.setTotalTime();
            System.out.println("Customer id: " + cust.getId() + ", created at time: " + cust.getTotalTime());
        }
    }



}
