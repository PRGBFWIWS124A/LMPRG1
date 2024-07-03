import java.util.Scanner;

public class AGE_Control {
   
public static void main(String[] args){

    Scanner scan = new Scanner(System.in);
    System.out.println("Geben Sie ihr Alter ein:");

    int age = scan.nextInt();
    scan.close();

if(age <=  30){
    if(age >= 18){
        System.out.println("Du darfst rein");
    }
    else System.out.println("Du bist zu Jung");
}
else System.out.println("Du bist zu Alt");
}
}

