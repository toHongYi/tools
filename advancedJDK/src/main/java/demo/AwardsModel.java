package demo;


/**
* @Created : 2021-06-07T15:42:25+08:00
* @Author : cqw
* @Version : V1.0
*/
public class AwardsModel {

    // 获奖日期
    private String dateOfAward;

    // 奖项名称
    private String awardName;

    public AwardsModel() {
    }

    @Override
    public String toString() {
        return "AwardsVo{" +
                "dateOfAward='" + dateOfAward + '\'' +
                ", awardName='" + awardName + '\'' +
                '}';
    }

    public String getDateOfAward() {
        return dateOfAward;
    }

    public void setDateOfAward(String dateOfAward) {
        this.dateOfAward = dateOfAward;
    }

    public String getAwardName() {
        return awardName;
    }

    public void setAwardName(String awardName) {
        this.awardName = awardName;
    }

}