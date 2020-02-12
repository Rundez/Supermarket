
public class Time {

    private static Time timeInstance = null;

    private static long start;
    private static long end;
    private static long totalTime;



    private Time(){

    }

    public static Time getInstance(){
        if(timeInstance == null){
            timeInstance = new Time();
        }
        return timeInstance;
    }

    public static void startTime(){
        start = System.currentTimeMillis();
    }


    public static long getTotalTime() {
        end = System.currentTimeMillis();
        totalTime = end - start;

        return totalTime;
    }
}
