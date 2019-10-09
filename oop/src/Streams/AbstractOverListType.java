package Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AbstractOverListType {
    public interface Predicate<T> {
        boolean test(T t);
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T e : list) {
            if (p.test(e)) {
                result.add(e);
            }
        }
        return result;
    }

    public static void main(String[] args) {

        List<String> lst = Arrays.asList("A","B","C");

        System.out.println(filter(lst,(String s)->s.equals("A")));


    }
}
