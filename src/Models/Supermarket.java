import java.util.concurrent.TimeUnit;

public class Supermarket {

    public static void main(String[] args) throws InterruptedException {

        Time.startTime();
        TimeUnit.SECONDS.sleep(5);
        System.out.println(Time.getTotalTime());
    }
}
