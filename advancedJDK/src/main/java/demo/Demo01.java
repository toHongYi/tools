package demo;

import java.util.Optional;

/**
 * @version : V1.0
 * @date : 2022/1/28 14:56
 * @Author : LLH
 * @Desc :
 */
public class Demo01 {
    public static void main(String[] args) {

        AwardsModel awardsModel = new AwardsModel();

            String person = new String();

        boolean equals = awardsModel.equals("11");
        System.out.println("equals = " + equals);

        //person ="LinLvHua";

            Optional.ofNullable(person).ifPresent(System.out::println);




    }


}
