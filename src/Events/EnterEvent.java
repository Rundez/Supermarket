package Events;

import Models.Customer;
import Models.Time;


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
        setStats(customerList);
    }

    private void setStats(ArrayList<Customer> customerList){
        statList.addAll(customerList);
    }

    public void printStatistics(){
        for(int i = 0; i < statList.size(); i++){
            System.out.println(statList.get(i));
        }
    }
}
