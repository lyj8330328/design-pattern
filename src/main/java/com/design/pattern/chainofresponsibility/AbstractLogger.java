package com.design.pattern.chainofresponsibility;

/**
 * @Author: 98050
 * @Time: 2019-01-11 19:19
 * @Feature:
 */
public abstract class AbstractLogger {

    public static int INFO = 1;
    public static int DEBUG = 2;
    public static int ERROR = 3;
    protected int level;

    protected AbstractLogger next;

    public void setNext(AbstractLogger next) {
        this.next = next;
    }

    public void logMessage(int level,String message){
        if (this.level == level){
            write(message);
        }else {
            String string = "";
            switch (this.level){
                case 1:string="INFO";break;
                case 2:string="DEBUG";break;
                case 3:string="ERROR";break;
                default:
            }
            System.out.println(string + "无法处理消息：" + message);
            if (next != null){
                next.logMessage(level, message);
            }
        }
    }

    /**
     * 输出
     * @param message
     */
    abstract protected void write(String message);

}
