class Worker{
    String name;
    
    void displayName(){
        System.out.println("Worker Name: " + name);
    }
}

public class seatwork6{
    public static void main (String[]args){
        Worker w1 = new Worker();
        w1.name = "Mr Nee G";
        
        try{
            w1.displayName();
        }catch (Exception e){
            System.out.println("Error:Worker  Object is not created");
        }
    }
}
