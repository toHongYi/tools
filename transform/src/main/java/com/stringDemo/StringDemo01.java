package com.stringDemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * @version : V1.0
 * @date : 2022/6/6 15:34
 * @Author : LLH
 * @Desc :
 */
public class StringDemo01 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        SnowBallProdReturn snowBallProdReturn1 = new SnowBallProdReturn("描述1", "回报1");
        SnowBallProdReturn snowBallProdReturn2 = new SnowBallProdReturn("描述2", "回报2");
        SnowBallProdReturn snowBallProdReturn3 = new SnowBallProdReturn(null, null);
        List<SnowBallProdReturn> returnModel = new ArrayList<>();

        returnModel.add(snowBallProdReturn1);
        returnModel.add(snowBallProdReturn2);
        returnModel.add(snowBallProdReturn3);

        List<String> returnModelString = new ArrayList<String>();
        returnModel.forEach(t->{
            Optional.ofNullable(t.getDescription()).ifPresent(f->{
                Optional.ofNullable(t.getProdReturn()).ifPresent(g->{
                    String s = t.toConcat();
                    returnModelString.add(s);
                });
            });
        });
        Optional.ofNullable(returnModelString).ifPresent(t->{System.out.println("获取到的returnModelString = " + returnModelString);});

        //主要用于取值
        returnModel.forEach(t->{
            Optional.ofNullable(t).map(j->t.getProdReturn()).map(j->t.getDescription()).ifPresent(System.out::println);
        });

    }
}
