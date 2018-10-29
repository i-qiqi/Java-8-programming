package stream;

import org.junit.Test;

import java.time.DayOfWeek;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamCollect {


    /**
     * Test functionalInterfaces
     */
    @Test
    public void test(){
        String str1 = getLength1("hello", value -> "hello的长度："+value, value -> value.length()); //输出:hello的长度：5
        System.out.println(str1);
    }
    public  static String getLength1(String str1, Function<Integer, String> function1, Function<String,Integer> function2){
        /**
         * 这里一定要注意，function1和function2的参数类型。
         * function2的输出类型与function1的输入类型一定要一致，
         * 否则编译不会通过
         */
        return function1.compose(function2).apply(str1);
    }

    @Test
    public void testGroupBy(){
        Map<Integer, List<Integer>> map = Stream.of(1, 3, 3, 4).collect(Collectors.groupingBy(x -> x));
        System.out.println(map);
        Map<Integer, Long> map1 = Stream.of(1, 3, 3, 4).collect(Collectors.groupingBy(x -> x, Collectors.counting()));
        System.out.println(map1);
        HashMap<Integer, Long> map2 = Stream.of(1, 3, 3, 4).collect(Collectors.groupingBy(x -> x, HashMap::new, Collectors.counting()));
        System.out.println(map2);
        String str= Stream.of("a", "b", "c").collect(Collectors.collectingAndThen(Collectors.joining(","), x -> x + "d"));
        System.out.println(str);
        System.out.println(Stream.of("a", "b", "c").collect(Collectors.joining(",")));


    }

}
