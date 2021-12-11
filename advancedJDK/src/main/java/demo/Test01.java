//package demo;
//
//import com.jarTest.shunfeng.Jar.QueryWayRoutesByShunFeng;
//import com.jarTest.shunfeng.entity.ShunFengRequestRoutesModel;
//import com.jarTest.shunfeng.mapper.impl.ShunFengJsonExpressServiceImpl;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @version : V1.0
// * @date : 2021/12/9 14:16
// * @Author : LLH
// * @Desc :
// */
//public class Test01 {
//    public static void main(String[] args) {
//
//        //String wayRoutes = "SF1404892863092";
//        List<String> arrayList = new ArrayList();
////        arrayList.add("SF1404892863092");
////        arrayList.add("SF1319599952758");
//        arrayList.add("SF1412955438811");
//
//        int phone = 3361;
//        QueryWayRoutesByShunFeng shunFeng = new QueryWayRoutesByShunFeng();
//        ShunFengRequestRoutesModel requestModel = shunFeng.createRequestModel(arrayList, phone);
//        System.out.println(requestModel);
//        ShunFengJsonExpressServiceImpl shunFengService = new ShunFengJsonExpressServiceImpl();
//        shunFengService.searchRoute(requestModel);
//
//    }
//
//}
