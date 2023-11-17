package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main
{

    public static void main(String[] args)
    {
        //唯一的中间件
        EventManager eventManager = new EventManager();

        List<EventHandler> eventHandlerList = new ArrayList<>();
        System.out.println("请选择调度策略：");
        System.out.println("1.全广播式    2.选择广播式：点对点    3.选择广播式：发布订阅");
        Scanner input = new Scanner(System.in);
        int strategy = input.nextInt();
        switch (strategy)
        {
            case 1:
                eventManager.setMode(1);
                EventSource eventSource1 = new EventSource("Source",eventManager);

                System.out.println("请输入接收方的个数：");
                int handler1 = input.nextInt();
                String nameHandler1 = "eventHandler";
                for(int i=0;i<handler1;i++)
                {
                    String eachHandler = nameHandler1.concat(String.valueOf(i));
                    eventHandlerList.add(new EventHandler(eachHandler,eventManager));
                }

                for(int i=0;i<eventHandlerList.size();i++)
                {
                    eventHandlerList.get(i).subscribe(eventSource1);
                }
                eventSource1.dosomething();
                break;

            case 2:
                eventManager.setMode(2);
                EventSource eventSource2 = new EventSource("Source",eventManager);

                System.out.println("请输入接收方的个数：");
                int handler2 = input.nextInt();
                String nameHandler2 = "eventHandler";
                for(int i=0;i<handler2;i++)
                {
                    String eachHandler = nameHandler2.concat(String.valueOf(i));
                    eventHandlerList.add(new EventHandler(eachHandler,eventManager));
                    System.out.println("第"+(i+1)+"个接收方是否订阅该事件？（y/n）");
                    char answer = input.next().charAt(0);
                    if(answer == 'y')
                    {
                        eventHandlerList.get(i).subscribe(eventSource2);
                    }
                    else
                    {
                        continue;
                    }
                }
                eventSource2.dosomething();
                break;

            case 3:
                eventManager.setMode(3);
                EventSource eventSource3 = new EventSource("Source",eventManager);
                System.out.println("请输入接收方的个数：");
                int handler3 = input.nextInt();
                String nameHandler3 = "eventHandler";
                for(int i=0;i<handler3;i++)
                {
                    String eachHandler = nameHandler3.concat(String.valueOf(i));
                    eventHandlerList.add(new EventHandler(eachHandler,eventManager));
                    System.out.println("第"+(i+1)+"个接收方是否订阅该事件？（y/n）");
                    char answer = input.next().charAt(0);
                    if(answer == 'y')
                    {
                        eventHandlerList.get(i).subscribe(eventSource3);
                    }
                    else
                    {
                        continue;
                    }
                }
                eventSource3.dosomething();
                break;

            default:
                System.out.println("输入有误，程序退出！");
                break;

        }
        return;
    }
}
