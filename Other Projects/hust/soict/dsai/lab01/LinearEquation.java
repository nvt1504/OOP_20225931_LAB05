import java.util.Scanner;
public class LinearEquation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a: ");
        double a = sc.nextDouble();
        System.out.print("Enter b: ");
        double b  = sc.nextDouble();
        double x;
        if(a == 0) {
            if (b != 0) {
                System.out.println("The equation has no solution.");
            }
            else System.out.println("The equation has infinitely many solutions.");
        }
        else {
            x = -b / a;
            System.out.println("The root of equation is: " + x);
        }
    }
}
