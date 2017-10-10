package task;

import java.io.IOException;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by user on 10.10.2017.
 */
public class main {


    public static void main(String[] args) throws IOException {

        System.out.println(tasks.gcd(-15,-20));


        Scanner in = new Scanner(System.in);
        switch (in.nextInt()) {

            case 1:{
                System.out.println(tasks.gcd(-15,-20));
                break;
            }
            case 2: {
                System.out.println("Input message to encode");
                in = new Scanner(System.in);
                String str = in.nextLine();
                char[] res = tasks.decode(str.toCharArray());
                System.out.println(res);
                System.out.println(tasks.decode(res));
                break;
            }
            case 3: {
                System.out.println("Input hexademical string");
                in = new Scanner(System.in);
                String str = in.nextLine();
                long decimal = tasks.hexadecimal(str);
                System.out.println(decimal);
                break;
            }

            case 4: {
                in = new Scanner(System.in);
                Stream<String> myStream = tasks.streamScanner(in).limit(4);
                System.out.println(myStream.sorted().collect(Collectors.toList()));
                break;
            }
        }



    }


}
