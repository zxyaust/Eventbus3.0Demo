package com.z.Eventbus3Demo;

/**
 * Created by Miller Zhang  on 2016/11/1.
 * desc:
 * github:https://github.com/zxyaust  CSDN:http://blog.csdn.net/qq_31340657
 * Whatever happens tomorrow,we've had today.
 */
public class MyEvent {
    private int type;
    private Object obj;
    private String msg;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObj() {
        return obj;
    }

    public MyEvent(int type, String msg) {
        this.type = type;
        this.msg = msg;
    }

    public MyEvent(int type) {
        this.type = type;
    }

    public MyEvent(int type, Object obj, String msg) {
        this.type = type;
        this.obj = obj;
        this.msg = msg;
    }

    public MyEvent setObj(Object o) {
        this.obj = o;
        return this;
    }
}
