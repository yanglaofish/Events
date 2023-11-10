package org.example;

public class Event {
  //事件信息
    private String name;//名称
    private String body;//事件信息
    private EventSource eventSource;//事件源
  public Event(String name, String body, EventSource eventSource) {
    this.name = name;
    this.body = body;
    this.eventSource = eventSource;
  }

  public String getName() {
    return name;
  }

  public String getBody() {
    return body;
  }

  public EventSource getEventSource() {
    return eventSource;
  }


}