package Models;

public class Time {

    private static Time timeInstance = null;

    private final static int maxTime = 720;
    private static int currentTime = 0;

    private Time(){

    }

    public static Time getInstance(){
        if(timeInstance == null){
            timeInstance = new Time();
        }
        return timeInstance;
    }

    public static void incrementTime(){
        currentTime++;
    }

    public static long getElapsedTime(int custTime) {
       int customerTime = currentTime - custTime;
       return customerTime;
    }

    public static int getTime(){
        return currentTime;
    }

    public static void setTime(int value){
        currentTime = value;
    }
}
