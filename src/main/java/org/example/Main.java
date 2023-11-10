package org.example;

public class Main {
    public static void main(String[] args) {
        EventManager manager=new EventManager();
        EventHandler handler1=new EventHandler("111",manager);
        EventHandler handler2=new EventHandler("222",manager);
        EventSource source1=new EventSource("frs",manager);
        handler1.subscribe(source1);
        handler2.subscribe(source1);
        source1.dosomething();
        return ;
    }
}
