import java.util.*;

class Input {

    public static Scanner scan = new Scanner(System.in);

    public static void pressEnterToContinue(){
        System.out.println("\nPRESS ENTER TO CONTINUE");
        Input.scan.nextLine();
    }

    public static int getInt(){
        int i = Input.scan.nextInt();
        Input.scan.nextLine();

        return i;
    }

    public static int getInt(String msg){
        System.out.print(msg);
        int i = Input.scan.nextInt();
        Input.scan.nextLine();

        return i;
    }
    
    public static double getDouble(String msg){
        System.out.print(msg);
        double d = Input.scan.nextDouble();
        Input.scan.nextLine();

        return d;
    }

    public static double getDouble(){
        double d = Input.scan.nextDouble();
        Input.scan.nextLine();

        return d;
    }



    public static String getString(){
        return Input.scan.nextLine();
    }


    public static String getString(String msg){
        System.out.print(msg);
        return Input.scan.nextLine();
    }

}