class PasswordException extends Exception{
    public PasswordException(String message){
        super(message);
    }
}

public class seatwork7b{
    static void checkPassword(String password) throws PasswordException{
        if (password.length()<10){
            throw new PasswordException(" password must be 10 characters long ");
        }else{
            System.out.println("Access granted");
        }
    }
    public static void main (String[]args){
        try{
            checkPassword("ampogiko67");
        }catch (PasswordException e) {
            System.out.println("Error :" + e.getMessage());
            }
        }
}
