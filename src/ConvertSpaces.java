import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by k.betlej on 1/20/16.
 */
public class ConvertSpaces {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("t1"));
        System.setOut(new PrintStream(new FileOutputStream("tt1")));
        System.out.println(sc.nextInt());
        while(sc.hasNextInt()) {
            int n = sc.nextInt();
            if(!sc.hasNextInt()) {
                continue;
            }
            int n2 = sc.nextInt();
            System.out.println(n + " " + n2);
        }
    }
}
