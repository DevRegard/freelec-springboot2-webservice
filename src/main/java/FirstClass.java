import java.util.Scanner;

public class FirstClass {
    public static void main(String[] args) {
        System.out.println("Hello, i am Spring boot" +
                "\n Who are you?");

        Scanner scan = new Scanner(System.in);
        String whoIs = scan.nextLine();

        System.out.print(whoIs + ", Nice me you");
        commitA();
        commitB();
        commitC();
        commitD();
    }

    public static void commitA(){
        System.out.println("Commit A");
    }

    public static void commitB() { System.out.println("Commit B"); }

    public static void commitC() { System.out.println("Commit C"); }

    public static void commitD() { System.out.println("Commit D"); }

//  def commitE() : print('Commit E')
}