package com.z.Eventbus3Demo;

/**
 * Created by Miller Zhang  on 2016/11/1.
 * desc:其实这是比较好的一个解决方案,每个事件代码都统一保存,方便查找,不会显得很乱,同时所发送的事件也是同样的事件,这是非常方便的
 * github:https://github.com/zxyaust  CSDN:http://blog.csdn.net/qq_31340657
 * Whatever happens tomorrow,we've had today.
 */
public interface EventBusType {
    int TYPE = 110;
    int TYPE1 = 111;
    int TYPE2 = 112;
}
