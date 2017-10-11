package task;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Created by user on 11.10.2017.
 */
public  class tasks {

    static long gcd (long a, long b)
    {
        while (b != 0)
           b = a % (a = b);
        return a < 0 ? -a : a;
    }

    static char[] decode (char[] str)
    {

        for (int i=0;i<str.length;i++)
        {
            if ((str[i]<'n'&&str[i]>='a')||((str[i]<'N')&&(str[i])>='A'))
                str[i]=(char)(((int)str[i])+13);
           else if ((str[i]<='z'&&str[i]>='n')||((str[i]<='Z')&&(str[i])>='N'))
                str[i]=(char)(((int)str[i])-13);
        }
        return str;
    }


    public static long hexadecimal(String s) {
        List theNumbers = new ArrayList (Arrays.asList('0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'));
        s = s.toUpperCase();
        long val = 0;
        for (int i = 0; i < s.length(); i++) {
            val = 16*val + theNumbers.indexOf(s.charAt(i));
        }
        return val;
    }


    public static Stream<String> streamScanner(final Scanner scanner) {
        final Spliterator<String> splt = Spliterators.spliterator(scanner, Long.MAX_VALUE, Spliterator.ORDERED | Spliterator.NONNULL);
        return StreamSupport.stream(splt, false)
                .onClose(scanner::close);
    }

    public static void getFiles(String path) throws IOException {

        List allFiles = Files.walk(Paths.get(path))
                .filter(p -> p.toString().endsWith(".java"))
                .filter(Files::isRegularFile)
                .map(Path::toFile)
                .collect(Collectors.toList());

        for (Object file:allFiles) {
            String current = (new java.io.File( "." ).getCanonicalPath())+"\\"+file.toString();
            if (Files.lines(Paths.get(current), StandardCharsets.UTF_8)
                    .filter((s) -> s.contains("transient")||s.contains("volatile")).findFirst().orElse("false")!="false")
                System.out.println(file.toString());
        }


    }



}

