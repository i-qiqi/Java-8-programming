package stream;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *versatile reduction operation(规约操作) of Stream
 * @Author bqzhu
 */
public class StreamTestTwo {


    /**
     * to generate one result from a group of elements.
     * such as sum() , max() , min() , count()
     * parameters
     * Optional<T> reduce(BinaryOperator<T> accumulator)
     */
    @Test
    public void testReduceWithOneParameter(){
        Stream<String> stream = Stream.of("You" , "are" , "an" , "excellent" , "boy!");
        Optional<String> longest = stream.reduce((s1 , s2) -> s1.length() >= s2.length() ? s1 : s2 );
//        Optional<String> longest = stream.max((s1 , s2) -> -( s1.length()-s2.length()));
        System.out.println(longest.get());

    }

    /**
     * <U> U reduce(U identity , BinaryOperator<U , ? super T , U> accumulator, BinaryOperator<U> combiner)
     * identity : initial value
     * combiner : Specify the way to merge the multiple partial sums when executing in parallel
     */
    @Test
    public void testReduceMultiParameters(){
        Stream<String> stream = Stream.of("You" , "are" , "an" , "excellent" , "boy!");
        Integer lengthSum = stream.reduce(0,
                (sum ,str)->sum+str.length(),
                (a , b) -> a + b);
        System.out.println(lengthSum);
    }

    /**
     * if we want to generate a complex object , such as a map or list , so ,,,
     * Ultimate weapon of Stream : collect()
     */
    @Test
    public void testCollect(){
        Stream<String> stream = Stream.of("You" , "are" , "an" , "excellent" , "boy!");
        List<String> list = stream.collect(Collectors.toList());
        System.out.println(list); // ordered sequence

        Stream<String> stream1 = Stream.of("You" , "are" , "an" , "excellent" , "boy!");
        Set<String> set = stream1.collect(Collectors.toSet());
        System.out.println(set); // out-of-order sequence

        Stream<String> stream2 = Stream.of("You" , "are" , "an" , "excellent" , "boy!");
        Map<String , Integer> map = stream2.collect(Collectors.toMap(Function.identity() , String::length));
        System.out.println(map); // out-of-order sequence


    }
    /**
     *Peek()
     *generate a new stream wrapping the old stream by provisioning a consumer function for each element in new stream.
     * the consumer function will be given priority to execute ，when the elements are consumed
     */
    @Test
    public void testPeek(){
        Stream<Integer> stream = Stream.of(1, 2, 3 ,4);
        stream.filter(c -> c >=3 ).peek(x -> System.out.println("peek : "+x))
                .forEach(y->System.out.println("executiing-"+y));
    }

    /**
     * skip()
     * Filter out the preceding N elements of the original stream,
     * return the remaining elements as new stream;
     */
    @Test
    public void testSkip(){
        Stream.of("My" , "name" , "is" , "Maruko Simith")
                .skip(2).forEach(System.out::println);
    }

    /**
     * limit()
     * take out the preceding N elements in the original stream as new stream
     */

    @Test
    public void testForEachOrdered() {
        Stream.of("My", "name", "is", "Maruko Simith")
                .sorted((s1, s2) -> s1.length() - s2.length())
                .forEachOrdered(System.out::println);
    }

    /**
     * findAny , findFirst
     */
    @Test
    public void testFindAny(){
        Optional<Integer> any = Stream.of(1, 2, 3, 4)
                .findAny();
        System.out.println(any.get());
    }


    /**
     * Collectors.partitioningBy
     */
    @Test
    public void testPartitionBy(){
        Map<Boolean , List<Integer>> collectParti = Stream.of(1, 2, 3, 4)
                .collect(Collectors.partitioningBy(it -> (it % 2 == 0)));

        System.out.println("collectParti : " + collectParti);

    }

    @Test
    public void testMaxBy(){
        Optional<Integer> collectMaxBy = Stream.of(2 ,4, 3, 13)
                .collect(Collectors.maxBy(Comparator.comparing(it -> it)));
        System.out.println("collectMaxBy : "+collectMaxBy.get());
    }
    @Test
    public void testAveragingInt(){
        Double collectAveragingInt= Stream.of(2 ,4, 3, 13,10)
                .collect(Collectors.averagingInt(x -> x));
        System.out.println("collectMaxBy : "+collectAveragingInt);
    }

}
