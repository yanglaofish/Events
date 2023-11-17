package org.example;

public class EventHandler {
    //事件处理方
    private String name;
    private EventManager manager;
    private Event event;

    public String getName() {
        return name;
    }

    public EventHandler(String name, EventManager manager) {
        this.name = name;
        this.manager = manager;
        manager.addhandler(this);

    }

    public  void subscribe(EventSource source){
        main.logtime(this.name+" sub "+source.getName());
        manager.subscribe(source,this);
    }
    public void receiveMessage(Event msg){
        event=msg;
        main.logtime(this.name+" recv");
    }

}