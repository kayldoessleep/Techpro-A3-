//task 3

import java.util.Random;

public class TASK3 {
    public static void main(String[] args) {

        Random random = new Random();

        int number;
        boolean isHeads;

        // Fixed line 11: Compatible with all Java versions
        // nextInt(6) gives 0-5; add 1 to get 1-6
        number = random.nextInt(6) + 1;

        isHeads = random.nextBoolean();

        System.out.println(number);

        if(isHeads){
            System.out.println("HEADS");
        }
        else{
            System.out.println("TAILS");
        }
    }
}
