package com.qtz.ht.service;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * 海淘订单Dubbo服务启动类
 *
 * @author Kevin Chang
 */
public class PphtServiceBootstrap
{
    private static Logger log = Logger.getLogger(PphtServiceBootstrap.class);
    private static volatile boolean running = true;
    static ClassPathXmlApplicationContext context;

    public static void main(String[] args) throws Exception
    {
        log.info("################PphtService准备启动服务！################");
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
        context.start();
        log.info("################PphtService服务启动成功！################");
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run()
            {
                if (context != null)
                {
                    context.stop();
                    context.close();
                    context = null;
                }
                log.info("################PphtService服务已经停止!################");
                synchronized (PphtServiceBootstrap.class)
                {
                    running = false;
                    PphtServiceBootstrap.class.notify();
                }
            }
        });

        synchronized (PphtServiceBootstrap.class)
        {
            while (running)
            {
                try
                {
                    PphtServiceBootstrap.class.wait();
                }
                catch (Throwable e)
                {}
            }
        }
    }
}
