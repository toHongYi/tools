原型模式:
https://blog.csdn.net/qq_45034708/article/details/113665397?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522164049482516780366561561%2522%252C%2522scm%2522%253A%252220140713.130102334..%2522%257D&request_id=164049482516780366561561&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~top_positive~default-1-113665397.pc_search_all_es&utm_term=%E5%8E%9F%E5%9E%8B%E6%A8%A1%E5%BC%8F&spm=1018.2226.3001.4187

主要是调用Object.clone方法进行处理。

- 使用原型模式前:
Sheep sheep1 = new Sheep(sheepDolly.getName(), sheepDolly.getAge());
Sheep sheep2 = new Sheep(sheepDolly.getName(), sheepDolly.getAge());
Sheep sheep3 = new Sheep(sheepDolly.getName(), sheepDolly.getAge());

- 使用原型模式后:
Sheep sheep1 = (Sheep)sheepDolly.deepClone();
Sheep sheep2 = (Sheep)sheepDolly.deepClone();
Sheep sheep3 = (Sheep)sheepDolly.deepClone();


还涉及到深拷贝、浅拷贝等知识。
当对象中存在引用对象时,如果默认克隆,便是浅拷贝。
    涉及到序列化等相关问题。

--|  implements Serializable 
--|  implements Cloneable
--|  