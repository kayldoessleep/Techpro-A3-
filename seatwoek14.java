public class seatwoek14 { 

    public static void main(String[] args) {
        Boat m = new Boat();
        m.make = "Boat maliit";
        m.color = "blue";

        System.out.println("Calling showAtts...");
        m.showAtts();

        System.out.println("----------"); 
        
        System.out.println("Starting engine...");
        m.startEngine();

        System.out.println("----------"); 
        System.out.println("Calling showAtts...");
        m.showAtts();

        System.out.println("----------"); 
        System.out.println("Starting engine...");
        m.startEngine();
    }
}

class Boat { 
    String make;
    String color;
    boolean engineRunning;

    public Boat() {
        engineRunning = false;
    }
    void showAtts() {
        System.out.println("make new boat:" + make);
        System.out.println("color:" + color);
        System.out.println("naandar ba? :" + engineRunning);
    }

    void startEngine() {
        if (!engineRunning) {
            System.out.println("Engine started.");
            engineRunning = true;
        } else {
            System.out.println("Engine is already running.");
        }
    }
}
