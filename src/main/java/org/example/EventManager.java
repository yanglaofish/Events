package org.example;

import java.util.*;

public class EventManager {
    //事件中间件
    private List<Event> eventList;
    private List<EventSource> eventSourceList;
    private List<EventHandler> eventHandlers;
    private HashMap<EventSource, HashSet<EventHandler>>  managers;
    private int mode;

    public EventManager() {
        eventList =new ArrayList<>();
        eventSourceList = new ArrayList<>();
        eventHandlers = new ArrayList<>();
        managers = new HashMap<>();
    }

    public void sendMessage(Event event)
    {
        eventList.add(event);
        receiveMessage(this.mode,event);
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public void subscribe(EventSource Source, EventHandler Handler){
        if(managers.containsKey(Source)){
            managers.get(Source).add(Handler);
        }
        else{
            HashSet<EventHandler> set=new HashSet<>();
            set.add(Handler);
            managers.put(Source,set);
        }
    }
    public void receiveMessage(int mode,Event event)
    {
        switch (mode){

            case 1://全广播
                //Event event=eventList.get(eventList.size()-1);
                for(EventHandler handler:eventHandlers) {
                    handler.receiveMessage(event);
                }
            case 2://订阅
                EventSource source=event.getEventSource();
                HashSet<EventHandler> sets=managers.get(source);
                if(sets==null){
                    break;
                }
                for(EventHandler handler:sets) {
                    handler.receiveMessage(event);
                }
            case 3://点对点
                EventSource sourc=event.getEventSource();
                HashSet<EventHandler> set=managers.get(sourc);
                if(set==null){
                    break;
                }
                ArrayList<EventHandler> arrayList=new ArrayList<>(set);
                int size=set.size();
                Random random=new Random();
                int rad= random.nextInt(size);
                arrayList.get(rad).receiveMessage(event);

            default:
                break;

        }
    }
    public void addsource(EventSource eventSource){
        eventSourceList.add(eventSource);
    }
    public void addhandler(EventHandler handler){
        eventHandlers.add(handler);
    }
}