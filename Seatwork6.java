public class Seatwork6 {
    public static void main(String[] args) {
        System.out.println("SEATWORKSIX ampogi ni sir");
        int dice = 1;

        while (dice <= 6) {
            if (dice != 6) {
                System.out.println("No Yatzy.");
            } else {
                System.out.println("Yatzy!");
            }
            dice = dice + 1;
        }
    }
}

