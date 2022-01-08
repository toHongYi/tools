package com.pattern.create.builder;

/**
 * @version : V1.0
 * @date : 2021/12/8 23:44
 * @Author : LLH
 * @Desc : builder模式将一个复杂对象的创建与它的表示进行分离,使得同样的构建过程可以创建不同的表示;
 */
public class TestBuilder {
    public static void main(String[] args) {
//        CompanyClient companyClient = new CompanyClient();
//        CompanyClient.Builder builder1 = new CompanyClient().newBuilder();
//


        CompanyClient.Builder client0 = new CompanyClient.Builder()
                    .setCompanyName("百度")
                    .setCompanyAddress("海定区百度大厦")
                    .setCompanyRegfunds(5)
                    .setmPerson("1000人以上")
                    ;
        //  build方法就是先构造一个对象,再借由这个对象进行赋值; 而不是考虑构造函数创建;
        //
        //  .build()方法实质上就是将已构造出来的对象转换成我们所需要的。
        System.out.println("构造出一个公司：" + client0.build().toString());
        System.out.println("---------------------分隔符");

        CompanyClient client2 = new CompanyClient.Builder()
                .setCompanyName("百度")
                .setCompanyAddress("海定区百度大厦")
                .setCompanyRegfunds(5)
                .setmPerson("1000人以上").build()
                ;
        System.out.println("构造出一个公司：" + client2.toString());
            System.out.println("---------------------分隔符");

            CompanyClient.Builder builder = new CompanyClient.Builder();
            builder.setCompanyName("华为");
            builder.setCompanyAddress("海定区百度大厦");
            builder.setCompanyRegfunds(20);
            //builder.setmType("通信科技行业");
            CompanyClient client1 = builder.build();
            System.out.println("构造出另一个公司：" + client1.toString());
    }
}

