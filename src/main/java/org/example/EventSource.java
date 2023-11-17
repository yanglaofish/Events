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
    {   main.logtime(this.name+" Do something");
        sendMessage(new Event(this.name,"message",this));
    }
    private void sendMessage(Event event)
    {
        manager.sendMessage(event);
    }

    public String getName() {
        return name;
    }
}