
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {

        // 串行流
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9,10);
        Integer sum = stream.filter(num -> num > 5)
                .reduce((num1, num2) -> num1 + num2)
                .get();
        System.out.println(sum);

        // 并行流
        // parallel()，变为并行流
        Stream<Integer> stream1 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9,10);
        Integer sum1 = stream1.parallel()
                .peek(num -> System.out.println(num+" ，当前线程名称： "+Thread.currentThread().getName())) // 该方法是为了追踪线程的执行情况
                .filter(n -> n > 5)
                .reduce((n1, n2) -> n1 + n2)
                .get();
        System.out.println(sum1);

    }

}