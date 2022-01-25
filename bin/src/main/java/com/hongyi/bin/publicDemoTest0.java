package com.hongyi.bin;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @version : V1.0
 * @date : 2022/1/10 14:48
 * @Author : LLH
 * @Desc :
 */
public class publicDemoTest0 {
    public static void main(String[] args) {

        List<Map<String, Object>> resultList = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        map.put("id", 1);
        resultList.add(map);
        Map<String, Object> map2 = new HashMap<>();
        map2.put("id", 2);
        resultList.add(map2);
        Map<String, Object> map3 = new HashMap<>();
        map3.put("id", 3);
        resultList.add(map3);
        // 方法一
        System.out.println("方法一");
        Collections.sort(resultList, new Comparator<Map<String, Object>>() {
            @Override
            public int compare(Map<String, Object> o1, Map<String, Object> o2) {
                Integer id1 = (Integer) o1.get("id");
                Integer id2 = (Integer) o2.get("id");
                // 升序
                // return id1.compareTo(id2);
                // 降序
                return id2.compareTo(id1);
            }
        });
        resultList.forEach(e -> {
            System.out.print(e.get("id") + " ");
        });
        System.out.println("\n");


        // 方法二
        System.out.println("方法二");
        List<Map<String, Object>> list = resultList.stream().sorted((e1, e2) -> {
            // 升序
            // return Integer.compare((Integer) e1.get("id"), (Integer) e2.get("id"));
            // 降序
                    return -Integer.compare((Integer) e1.get("id"), (Integer) e2.get("id"));
                }).collect(Collectors.toList());

        list.forEach(e->{
            System.out.print(e.get("id") + " ");
        });
        System.out.println("\n");

        list.forEach(System.out::println);

//        list.stream().filter()
//
//        list.stream().forEach(t-> { list.add((prodCode .equals(t.getProdCode()) )?"1":"0"); });
//
//        list.stream().filter(t->{
//            if (fundKind.equals("0")){
//                return prodCode.equals(t.getProdCode()) && sellOrOpen.equals(t.getSellOrOpen());
//            }else{
//                return prodCode .equals(t.getProdCode());
//            }
//        }).findAny().isPresent() ? "1":"0";
//


        /**
         *         //TODO 用户登录状态;
         *         UserDetails userDetails = UserContext.get();
         *         String advisorId = userDetails.getAdvisorId();
         *         if (StringUtils.isEmpty(advisorId)){
         *             queryModel.setUserID("unAuthorized");
         *         }
         *         queryModel.setUserID(advisorId);
         *
         *
         *         return userFavoriteShowRecordModels.stream().filter(t->{
         *             if (fundKind.equals("0")){
         *                 return prodCode.equals(t.getProdCode()) && sellOrOpen.equals(t.getSellOrOpen());
         *             }else{
         *                 return prodCode .equals(t.getProdCode());
         *             }
         *         }).findAny().isPresent() ? "1":"0";
         *
         * //        此处需要注意,目前原数据库库中定义的sellOrOpen字段; 0是公募,1是私募;  收藏功能技术方案设置的"1"是公募,"2"是私募;需更改;
         * //        List<String> list = new ArrayList<>();
         * //        if (fundKind.equals("0")){
         * //
         * //            userFavoriteShowRecordModels.stream().forEach(t-> { list.add((prodCode .equals(t.getProdCode()) )?"1":"0"); });
         * //        }else {
         * //            userFavoriteShowRecordModels.stream().forEach(t-> { list.add((prodCode.equals(t.getProdCode()) && sellOrOpen.equals(t.getSellOrOpen()))?"1":"0"); });
         * //        }
         * //        return list.contains("1")?"1":"0";
         */

    }
}
