package com.stream.groupBy;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author HongYi
 * @version 1.0
 * @date 2022/10/16 23:04
 * @description:
 */
public class Demo01 {

    @Test
    public void collectingAndThenExample() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        Double result = list.stream().collect(Collectors.collectingAndThen(Collectors.averagingLong(v -> {
                    System.out.println("v--" + v + "--> " + v * 2);
                    return v * 2;
                }),
                s -> {
                    System.out.println("s--" + s + "--> " + s * s);
                    return s * s;
                }));
        System.out.println(result);
    }


    public static void main(String[] args) {

        List<Product> prodList = new ArrayList<>();

        Product prod1 = new Product(1L, 1, new BigDecimal("15.5"), "面包", "零食");
        Product prod2 = new Product(2L, 2, new BigDecimal("20"), "饼干", "零食");
        Product prod3 = new Product(3L, 3, new BigDecimal("30"), "月饼", "零食");
        Product prod4 = new Product(4L, 3, new BigDecimal("10"), "青岛啤酒", "啤酒");
        Product prod5 = new Product(5L, 10, new BigDecimal("15"), "百威啤酒", "啤酒");
        Product prod6 = new Product(5L, 10, new BigDecimal("15"), "百威啤酒", "啤酒");
        prodList.add(prod1);
        prodList.add(prod2);
        prodList.add(prod3);
        prodList.add(prod4);
        prodList.add(prod5);
        prodList.add(prod6);


        Map<String, List<Product>> prodMap = prodList.stream().collect(Collectors.groupingBy(Product::getCategory));
        System.out.println("prodMap = " + prodMap);
        // 根据内部条件拼接后进行分组
        Map<String, List<Product>> prodMap2 = prodList.stream().collect(Collectors.groupingBy(item -> item.getCategory() + "_" + item.getName()));
        System.out.println("prodMap2 = " + prodMap2);

        // return的内容为 Map中的Key值;
        Map<String, List<Product>> prodMap3 = prodList.stream().collect(Collectors.groupingBy(item -> {
            if (item.getNum() < 3) {
                return "3";
            } else {
                return "other";
            }
        }));


        // 多级分组  先对内部进行一级;再将此进行二级分组;
        // 先获取二级分类内容,再将该二级分类内容继续一级分类;
        Map<String, Map<String, List<Product>>> prodMap4 = prodList.stream().collect(Collectors.groupingBy(Product::getCategory, Collectors.groupingBy(item -> {
            if (item.getNum() < 3) {
                return "3";
            } else {
                return "other";
            }
        })));
        System.out.println("prodMap4 = " + prodMap4);


        // 按子组进行收集
        // 求总数
        Map<String, Long> prodMap5 = prodList.stream().collect(Collectors.groupingBy(Product::getCategory, Collectors.counting()));
        System.out.println("prodMap5 = " + prodMap5);

        // 求和
        Map<String, Integer> prodMap6 = prodList.stream().collect(Collectors.groupingBy(Product::getCategory, Collectors.summingInt(Product::getNum)));

        // 把收集器的结果转化为另一种类型
        Map<String, Product> prodMap7 = prodList.stream().collect(Collectors.groupingBy(Product::getCategory, Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(Product::getNum)), Optional::get)));
        System.out.println("prodMap7 = " + prodMap7);

        // 联合其他收集器
        Map<String, Set<String>> prodMap8 = prodList.stream().collect(Collectors.groupingBy(Product::getCategory, Collectors.mapping(Product::getName, Collectors.toSet())));
        System.out.println("prodMap8 = " + prodMap8);
    }


//{"啤酒":{"other":[{"category":"啤酒","id":4,"name":"青岛啤酒","num":3,"price":10},{"category":"啤酒","id":5,"name":"百威啤酒","num":10,"price":15}]},"零食":{"other":[{"category":"零食","id":3,"name":"月饼","num":3,"price":30}],"3":[{"category":"零食","id":1,"name":"面包","num":1,"price":15.5},{"category":"零食","id":2,"name":"饼干","num":2,"price":20}]}}


}


class Product {

    Long id;

    Integer num;

    BigDecimal price;

    String name;

    String category;

    public Product(Long id, Integer num, BigDecimal price, String name, String category) {
        this.id = id;
        this.num = num;
        this.price = price;
        this.name = name;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
