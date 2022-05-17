package optional;

import java.util.Optional;

/**
 * @version : V1.0
 * @date : 2022/3/10 11:19
 * @Author : LLH
 * @Desc :
 */
public class Demo01 {
    public static void main(String[] args) {
        Report request = new Report();
        request.setReportFiles("大人");

        Optional.ofNullable(request.getReportFiles()).filter(t -> {
            if (t.equals("o")) {
                return true;
            }
            return false;
        }).ifPresent(t->System.out.println(t));

        /**
         * filter(t->{
         * //            if (fundKind.equals("0")){
         * //                return prodCode.equals(t.getProdCode()) && sellOrOpen1.equals(t.getSellOrOpen());
         * //            }else{
         * //                return prodCode .equals(t.getProdCode());
         * //            }
         * //        })
         */

        Optional.ofNullable(request.getReportFiles()).filter(t -> {
            if (t.equals("大人")) {
                return true;
            }
            return false;
        }).ifPresent(t->System.out.println(t));

        Optional.of(request.getReportFiles()).ifPresent(t->System.out.println(t+"3"));

        Boolean true1 =true;

        Optional.ofNullable(true1).filter(t-> {
            if (t == null) {
                return true;
            }else {
                return false;
            }
        }).ifPresent(t->System.out.println(t+"3"));

    }


}
