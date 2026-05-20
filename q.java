import java.util.Scanner;
import java.util.Random;

public class QuickPress{
    public static void main(String[] args){
        RandomTimer t = new RandomTimer(5000);
        Scanner s = new Scanner(System.in);

        System.out.print("Hit Enter to start:");
        s.nextLine();

        t.start();

        s.nextLine();

        if(RandomTimer.responseTime() >= 0)
            System.out.println("Your time: " + RandomTimer.responseTime() + "(ms)");

        if(RandomTimer.responseTime() < 0)
            System.out.println("おてつきです");

        RandomTimer.stopRunning();
    }
}

class RandomTimer extends Thread{
    static int count;
    static boolean running = true;

    public void run(){
        while(running == true){
            try{
                Thread.sleep(10);
            }catch(InterruptedException e){
            }

            count = count - 10;

            if(count <= 0 && count >= -10){
                System.out.println("*");
                count = 0;
            }
        }
    }

    RandomTimer(int x){
        Random rand = new Random();

        int count = rand.nextInt(x);

        this.count = count;
    }

    public static int responseTime(){
        return -count;
    }

    public static void stopRunning(){
        running = false;
    }
}
