//---------------------------------------------------------------------------------------------------Class TypingTest

import java.time.LocalTime;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class TypingTest {

//------------------------------------------------------------------------------------------------------Functionality

    public static void test(String testList) throws InterruptedException{
        //Countdown
        System.out.println("3...");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("2...");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("1...\n");
        TimeUnit.SECONDS.sleep(1);
        
        //Print test
        System.out.println(testList);
        
        //Start time
        double startTime = LocalTime.now().toNanoOfDay();
        
        //Take input
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        
        //Stop time
        double stopTime = LocalTime.now().toNanoOfDay();
        
        //Get test stats
        TestStat stats = new TestStat(testList, input, startTime, stopTime);
        
        //Print stats
        System.out.println("\nWPM:" + stats.getwpm());
        System.out.println("Raw:" + stats.getRawwpm());
        System.out.println("Accuracy: " + String.format("%.2f", stats.getAccuracy()) + "%");
    }

//---------------------------------------------------------------------------------------------------Class TypingTest

}
