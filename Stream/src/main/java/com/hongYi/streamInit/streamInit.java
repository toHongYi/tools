package com.hongYi.streamInit;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @version : V1.0
 * @date : 2021/12/20 23:44
 * @Author : LLH
 * @Desc :
 */
public class streamInit {
    public static void main(String[] args) {

        int[] array={1,3,5,6,8};
        IntStream stream1 = Arrays.stream(array);

        Stream<Integer> stream2 = Stream.of(1, 2, 3, 4, 5, 6);

        Stream<Integer> stream3 = Stream.iterate(0, (x) -> x + 3).limit(4);
        stream2.forEach(System.out::println);

        Stream<Double> stream4 = Stream.generate(Math::random).limit(3);
        stream3.forEach(System.out::println);


    }
}
