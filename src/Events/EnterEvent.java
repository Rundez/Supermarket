package Events;

import Models.Customer;
import Models.Time;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import java.util.ArrayList;


public class EnterEvent extends Event {

    private ArrayList<Customer> statList = new ArrayList<>();

    // Calls the super method to inherit the created customers from the super class.
    public EnterEvent() {
        super();
    }

    public void customersEntering(ArrayList<Customer> customerList)  {
        for (Customer cust: customerList) {

            System.out.println("Customer id: " + cust.getId() + ", entered at time: " + cust.getStartTime());
            Time.setTime(cust.getStartTime());
        }

        // Sort the list of costumers to be used in the next event. 
        sortCustByTime(customerList);
    }


    public void printStatistics(){
        for(Customer cust : statList){
            System.out.println(cust.getStartTime());
        }
    }

    public void sortCustByTime(ArrayList<Customer> customerList){

        Collections.sort(customerList);
        statList = customerList;

    }
}
