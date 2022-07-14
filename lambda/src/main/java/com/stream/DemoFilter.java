package com.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @version : V1.0
 * @date : 2022/6/16 12:26
 * @Author : LLH
 * @Desc :
 */
public class DemoFilter {
    public static void main(String[] args) {
        List<StockAccount> stockAccounts = new ArrayList<>();
        List<StockAccountDTO> stockAccountDTOList = new ArrayList<>();
        List<String> appropriateMarketingList = new ArrayList<>();

        // TODO 取出
        // Map转换
        List<String> oldAccounts =  stockAccounts.stream().filter(stock ->
                appropriateMarketingList.contains(stock.getAccountType())).map(StockAccount::getAccountNo)
                .distinct().collect(Collectors.toList());
        List<String> newAcounts = stockAccountDTOList.stream().filter(stock ->
                appropriateMarketingList.contains(stock.getAccountType())).map(StockAccountDTO::getAccountNo).distinct().collect(Collectors.toList());

    }
}
