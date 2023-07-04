package com.epam.mjc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
         return x -> {
            for(String a: x){
            if(!Character.isLetter(a.charAt(0)) || Character.isLowerCase(a.charAt(0)))
                return false;
            }
            return true;
         };


    }


    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return x -> {
            List<Integer> integers = new ArrayList<>();
            for(Integer numbers :x){
                if(numbers % 2 == 0)
                   integers.add(numbers);
            }
            x.addAll(integers);
        };

    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
            values.removeIf(
            s -> Character.isLowerCase(s.charAt(0))
            || s.charAt(s.length()-1) != '.'
            || s.split(" ").length <4 );
            return values;
        };

    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return x -> {
          Map<String, Integer> map = new HashMap<>();
            for(String str : x)
                map.put(str, str.length());
        return map;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {

        return (list1, list2) -> {
            ArrayList<Integer> myList = new ArrayList<>(list1);
            myList.addAll(list2);
            return  myList;
        };
    }
}
