import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ASD3 {
    public static void main(String[] args) throws FileNotFoundException {
//        File file = new File(args[0]);
        Scanner scanner = new Scanner(new FileReader("C:\\Users\\Filip\\Desktop\\ASD3test1.txt"));
        int k = scanner.nextInt(); // k - number of operations to do

        Number number = new Number();
        Number nextNumber = number;

        while(scanner.hasNextInt()) {
            number.actualValue = scanner.nextInt();

            if(scanner.hasNextInt()) {
                number.nextNumber = new Number();
                number = number.nextNumber;
            }

        }
        scanner.close();

        number.nextNumber = nextNumber;
        number = nextNumber;

        for(int operation = 0; operation < k; operation++) {
            if(number.actualValue % 2 == 0) {

            } else {
                Number n = number.nextNumber;
                number.nextNumber.actualValue = number.actualValue - 1;
                number.nextNumber = new Number();
                number.nextNumber.nextNumber = n;
            }
        }




    }
}

/*
p --> NIEPARZYSTY
ADD – dodanie elementu o wartości X-1 na pozycję P+1,
    a następnie przesunięcie wskaźnika P o X elementów w prawo,
    gdzie X jest wartością elementu znajdującego się na pozycji P.
*/

/*
p --> PARZYSTY
DELETE – usunięcie elementu znajdującego się na pozycji P+1,
    a następnie przesunięcie wskaźnika P o X elementów w prawo,
    gdzie X jest wartością usuniętego elementu.
*/

class Number {
    public int actualValue;
    public Number nextNumber;
}
