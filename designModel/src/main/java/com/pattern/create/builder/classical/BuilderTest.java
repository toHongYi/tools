package com.pattern.create.builder.classical;

/**
 * @ClassName Computer
 * @Created by theLin
 * @Date 2021/12/13 22:15
 * @Description #{description}
 */
public class BuilderTest {
    public static void main(String[] args) {
        Director director = new Director();
        director.setBuilder(new LowConfigBuilder());
        director.createComputer();
        Computer computer = director.getComputer();
        System.out.println("computer电脑配置 = " + computer);
    }
}

class Director{
    private ComputerConfigBuilder mBuilder;
    public void setBuilder(ComputerConfigBuilder builder){
        this.mBuilder = builder;
    }

    public void createComputer(){
        mBuilder.setCPU();
        mBuilder.setMemery();
        mBuilder.setHardDisk();
        mBuilder.setKeyboard();
        mBuilder.setMouse();
    }

    public Computer getComputer(){
        return mBuilder.getComputer();
    }

}

class Computer {

    /*CPU*/
    private String CPU;
    /*内存*/
    private String memory;
    /*硬盘*/
    private String hardDisk;
    /*键盘*/
    private String keyboard;
    /*鼠标*/
    private String mouse;

    public String getCPU() {
        return CPU;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getHardDisk() {
        return hardDisk;
    }

    public void setHardDisk(String hardDisk) {
        this.hardDisk = hardDisk;
    }

    public String getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(String keyboard) {
        this.keyboard = keyboard;
    }

    public String getMouse() {
        return mouse;
    }

    public void setMouse(String mouse) {
        this.mouse = mouse;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "CPU='" + CPU + '\'' +
                ", memory='" + memory + '\'' +
                ", hardDisk='" + hardDisk + '\'' +
                ", keyboard='" + keyboard + '\'' +
                ", mouse='" + mouse + '\'' +
                '}';
    }
}

/**
 * 把安装步骤给具体的抽象出来;
 */
interface ComputerConfigBuilder {
    void setCPU();
    void setMemery();
    void setHardDisk();
    void setKeyboard();
    void setMouse();
    Computer getComputer();
}

class LowConfigBuilder implements ComputerConfigBuilder{

    private Computer mComputer;

    //
    public LowConfigBuilder(){
        this.mComputer = new Computer();
    }


    @Override
    public void setCPU() {
        mComputer.setCPU("i5");
    }

    @Override
    public void setMemery() {
        mComputer.setMemory("8G");
    }

    @Override
    public void setHardDisk() {
        mComputer.setHardDisk("500G");
    }

    @Override
    public void setKeyboard() {
        mComputer.setKeyboard("薄膜键盘");
    }

    @Override
    public void setMouse() {
        mComputer.setMouse("有线鼠标");
    }

    @Override
    public Computer getComputer() {
        return mComputer;
    }
}


class HighConfigBuider implements ComputerConfigBuilder {

    private Computer mComputer;

    public HighConfigBuider(){
        this.mComputer = new Computer();
    }

    @Override
    public void setCPU() {
        mComputer.setCPU("i7");
    }

    @Override
    public void setMemery() {
        mComputer.setMemory("16G");
    }

    @Override
    public void setHardDisk() {
        mComputer.setHardDisk("1T");
    }

    @Override
    public void setKeyboard() {
        mComputer.setKeyboard("机械键盘");
    }

    @Override
    public void setMouse() {
        mComputer.setMouse("无线鼠标");
    }

    @Override
    public Computer getComputer() {
        return mComputer;
    }
}