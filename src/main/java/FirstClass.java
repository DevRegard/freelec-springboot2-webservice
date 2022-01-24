import java.util.Scanner;

public class FirstClass {
    public static void main(String[] args) {
        System.out.println("Hello, i am Spring boot" +
                "\n Who are you?");

        Scanner scan = new Scanner(System.in);
        String whoIs = scan.nextLine();

        System.out.print(whoIs + ", Nice me you");
    }

    public static void commitA(){
        System.out.println("Commit A");
    }
}