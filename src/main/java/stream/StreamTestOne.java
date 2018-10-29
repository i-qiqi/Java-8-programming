package stream;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Common method interfaces of Stream
 * @Author bqzhu
 */
public class StreamTestOne {

    /**
     * Intermediate Operations : filter() , map(), distinct() , sorted()
     * Terminal Operations: foreach()
     */
    @Test
    public void test1(){
        // Google Core Libraries For Java
        List<String> list = Lists.newArrayList("bcd" ,  "21de" , "def344" , "abc56", "def344");
        List<String> result = list.stream()
                .sorted((s2, s1)-> s1.length() - s2.length())
                .filter(e-> e.length() >= 4)
                .map(e->e.charAt(2))
                .map(e->String.valueOf(e).toUpperCase())
                .distinct()
                .collect(Collectors.toList());
        System.out.println("-------------------");
        System.out.println(result);
    }
    /**
     * flatMap()
     */
    @Test
    public void testFlatMap(){
        Stream<List<String>> stream = Stream.of(Arrays.asList("Hello" , "ketty" ) , Arrays.asList("How" , "are" , "you"));
        stream.flatMap(list-> list.stream())
                .forEach(str->System.out.println(str));
    }


}
