import java.util.Scanner;

public class InpuFromKeyboard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("What is your name?");
        String strName = sc.nextLine();
        System.out.println("How old are you?");
        int iAge = sc.nextInt();
        System.out.println("How tall are you (m)?");
        double height = sc.nextDouble();

        System.out.println("Mrs/Ms. " + strName + ", " + iAge + " years old. " + "Your height is " +height);

    }
}
