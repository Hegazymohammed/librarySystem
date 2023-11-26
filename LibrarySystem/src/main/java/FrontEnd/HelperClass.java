package FrontEnd;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class HelperClass {
    static Scanner input=new Scanner(System.in);
    public static int displayChoice(List<String> list){
        if((list.size())==1)
            return -1;
        int choice=-1;
        while (true){
            list.stream().forEach(System.out::println);
            choice=input.nextInt();
            if(choice>0&&choice<list.size())
                return choice;
        }

    }

    public static List<String> readingOptionFromFile(String pathOfTheFile){

        Path path=Path.of(pathOfTheFile);
        List<String>lines;
        try {
            lines= Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return lines;
    }

    public static void print(String text){
        System.out.println(text);
    }
}
