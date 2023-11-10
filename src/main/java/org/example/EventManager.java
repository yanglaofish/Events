package org.example;

import java.util.HashMap;
import java.util.List;

public class EventManager {
    //事件中间件
    private List<Event> eventList;
    private List<EventSource> eventSourceList;
    private List<EventHandler> eventHandlers;
    private HashMap<EventSource,List<EventHandler>>  managers;

    public void sendMessage(Event event){

    }
    public void link(EventHandler handler){

    }
    public void subscribe(){

    }
    public void receiveMessage(EventHandler eventHandler){

    }
}
