package com.winkey.winlib.event;

/**
 * @author winkey
 * @date 2020/1/7
 * @describe 总线管理器
 */
public class EventManage {

    public String event;
    public Object message;

    public static EventManage getInstance(String event) {
        return new EventManage(event);
    }

    private EventManage(String event) {
        this.event = event;
    }

    public static EventManage getInstance(String event, Object message) {
        return new EventManage(event, message);
    }

    private EventManage(String event, Object message) {
        this.message = message;
        this.event = event;
    }

}
