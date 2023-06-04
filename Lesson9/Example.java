package Lesson9;

import java.util.ArrayList;
import java.util.stream.Stream;

public class Example {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();

        list.add("apple");
        list.add("banana");
        list.add("mango");

        Stream<String> data = list.stream();

        data.forEach(
            p -> System.out.println(p);
        );
    }
}
