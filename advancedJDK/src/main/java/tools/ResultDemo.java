package tools;

import demo.AwardsModel;

import java.util.ArrayList;
import java.util.List;

/**
 * @version : V1.0
 * @date : 2022/1/30 17:45
 * @Author : LLH
 * @Desc :
 */
public class ResultDemo {

    public Result<List<AwardsModel>> getAll(){

        List<AwardsModel> list = new ArrayList<>();
        return Result.buildResult(Result.Status.OK,list);

    }
}
