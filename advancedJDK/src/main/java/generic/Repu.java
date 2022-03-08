package generic;

/**
 * @version : V1.0
 * @date : 2022/3/8 9:14
 * @Author : LLH
 * @Desc :
 */
public class Repu<T> {

    String name;

    String age;

    ResponseData data1;

    T data;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public ResponseData getData1() {
        return data1;
    }

    public void setData1(ResponseData data1) {
        this.data1 = data1;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseDemo{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", data1=" + data1 +
                ", data=" + data +
                '}';
    }

}
