package Events;

import Models.Customer;
import Models.Time;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import java.util.ArrayList;


public class EnterEvent extends Event {

    private ArrayList<Customer> statList = new ArrayList<>();


    // Prints the arrival time for the customers which enters the shop
    public void customersEntering(ArrayList<Customer> customerList)  {
        for (Customer cust: customerList) {

            System.out.println("Customer id: " + cust.getId() + ", entered at time: " + cust.getStartTime());
            Time.setTime(cust.getStartTime());
        }
        System.out.println("\n");

        // Sort the list of costumers to be used in the next event.
        sortCustByTime(customerList);
    }

    public void printStatistics(){
        for(Customer cust : statList){
            System.out.println(cust.getStartTime());
        }
    }

    private void sortCustByTime(ArrayList<Customer> customerList){

        Collections.sort(customerList);
        statList = customerList;
    }

    public ArrayList<Customer> getCustomers(){
        return statList;
    }
}
