package org.example;

public class EventSource {
    //发布事件者
    private String name;
    private EventManager manager;

    public EventSource(String name, EventManager manager) {
        this.name = name;
        this.manager = manager;
        manager.addsource(this);
    }

    public void dosomething()
    {
        System.out.println("Hello");
        sendMessage(new Event("Hello","message",this));
    }
    private void sendMessage(Event event){
        manager.sendMessage(event);
    }

}
