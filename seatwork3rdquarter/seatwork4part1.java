public class seatwork4part1 {
    public void processPayment(double amount, String currency) {
        System.out.println("Processing payment of " + amount + " " + currency);
    }

    public void processPayment(double amount, String currency, String paymentMethod) {
        System.out.println("Processing payment of " + amount + " " + currency + " via " + paymentMethod);
    }
//main class below
    public static void main(String[] args) {
        Sw4part1 processor = new Sw4part1();
        processor.processPayment(100.0, "pira");
        processor.processPayment(250.0, "yen", "pounds"); //brokeahh
    }
}
