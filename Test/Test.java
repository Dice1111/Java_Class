import java.util.stream.*;
import java.util.*;


class Test{
    public static ArrayList<String> animals  = new ArrayList<String>();
    public static int[] values = {1,3,5,7,9,11};
    public static void main(String[] args) {
        // animals.add("cat");
        // animals.add("lion");
        // animals.add("horse");
        // animals.add("dog");
        // Stream<String> filtered_data = animals.stream().filter(s-> s.length()>3);

        // filtered_data.forEach(
        //     s-> System.out.println(s)
        // );

        int reduce  = IntStream.of(values).reduce(0, (x,y)->x+2*y);
        System.out.println("reduce:"+reduce);

    }
}