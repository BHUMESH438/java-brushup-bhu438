package Probs;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Streams1DupRmeoval {


    //Solution 1: filter with a Set (the standard trick)
    static List<Integer> removeDuplicate1 (List<Integer> num){
        HashSet<Integer> seen = new HashSet<>();  //what exactly the hasset does?why we use hashSet in set?
        //alos explain the filter and collect methods and what os this ::
        return num.stream().filter(seen::add).collect(Collectors.toList());
    }


    static List<Integer> removeDuplicate2 (List<Integer> num){
        return num.stream()
                .collect(Collectors.toCollection(LinkedHashSet::new))
                .stream(). //here why we need to use stream again as its already used before the collect right?
                        //here whats the differnevce btoween the set and hashs set we used as stram will fitler in order right?
                                //Or more directly, if you're happy returning a Set:
                //
                //java
                //Set<Integer> unique = new LinkedHashSet<>(nums); --> what here are you tring to say i dont understand
                collect(Collectors.toList());
    }


    static List<Integer> removeDuplicate3 (List<Integer> num){
        return num.stream().distinct().collect(Collectors.toList());
    }

    static Set<Integer> removeDuplicate4 (List<Integer> num){
        Set<Integer> unique = new HashSet<>(num);
        return unique;
    }

    static List<Integer> sortInDscOrderm1(List<Integer> num){
        return num.stream().distinct().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

    static List<String> orderOfLength (List<String> str){
        return str.stream().sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList());
    }

    static Integer findMaxNumber (List<Integer> num){
        return num.stream().max(Comparator.naturalOrder()).orElse(0);
    }

    static Double fincMaxNumberDouble (List<Double> num){
        return num.stream().max(Comparator.naturalOrder()).get(); //returns the big double;
    }
    static Integer fincMaxNumber (List<Integer> num){
        return num.stream().max(Comparator.naturalOrder()).get(); //returns the big double;
    }

    static List<Double> sortNumDesc (List<Double> num){
        return num.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

    static String longestString (List<String> str){
        return str.stream().max(Comparator.comparingInt(String::length)).orElse(null);
    }

    static boolean allNumEven (List<Integer> num){
      return  num.stream().allMatch(i->i%2==0);
    }

    static boolean anyMatchFirstLetter ( List<String> str, String prefix){
        return str.stream().anyMatch(s->s.startsWith(prefix));
    }

    static List<Integer> anyMatchFirstLetterPrint(List<Integer> num, String prefix){
        return num.stream().filter(i->String.valueOf(i).startsWith(prefix)).toList();
    }

    static void main() {
       List<Integer> duplicateNumber = Arrays.asList(1, 2, 3, 2, 4, 3, 5, 1);
       List <String> sortAccToLength = Arrays.asList("Java", "Python", "C#", "HTML", "Kotlin", "C++", "COBOL",
               "C");
        List<Integer> numbers = Arrays.asList(1, 2, 4, 41, 4);
       List<Integer> evenums = Arrays.asList();
        List<Integer> numbers2 = Arrays.asList(10, 12, 20, null, 19, 30);
        System.out.println(removeDuplicate1(duplicateNumber));  // [1, 2, 3, 4, 5]
        System.out.println(removeDuplicate2(duplicateNumber));  // [1, 2, 3, 4, 5]
        System.out.println(removeDuplicate3(duplicateNumber)); // [1, 2, 3, 4, 5]
        System.out.println(removeDuplicate4(duplicateNumber));  // [1, 2, 3, 4, 5]
        System.out.println(orderOfLength(sortAccToLength));
        System.out.println(fincMaxNumber(numbers));
        System.out.println(allNumEven(evenums));
        System.out.println(anyMatchFirstLetter(sortAccToLength, "C"));
        System.out.println(anyMatchFirstLetterPrint(numbers2, "1"));
        // [C, C#, C++, Java, HTML, COBOL, Python, Kotlin]
    }

}
