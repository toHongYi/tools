package com.hongYi.filter;

import com.sun.org.apache.xerces.internal.xs.datatypes.ObjectList;
import org.assertj.core.util.Lists;
import org.assertj.core.util.Sets;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @version : V1.0
 * @date : 2022/6/28 13:45
 * @Author : LLH
 * @Desc :
 */
public class Demo1 {
    public static void main(String[] args) {




        List<Integer> integers = Lists.list(30, 40, 10, 20);
        List<Integer> collect1 = integers.stream().filter(t -> {
            return t > 20;
        }).collect(Collectors.toList());        // TODO 注意这个方括号,决定了是否return

        System.out.println("collect1 = " + collect1);

        Set<Integer> collect = integers.stream().filter(i -> i > 30).collect(Collectors.toSet());

        Optional<Integer> collect3 = integers.stream().filter(i -> i > 30).findAny();

        List<Integer> collect4 = integers.stream().filter(i -> i > 30).collect(Collectors.toList());

        String collect5 = integers.stream().filter(i -> i > 30).findAny().isPresent() ? "1":"0";

        System.out.println("collect = " + collect);
    }
}
