package com.qtz.ht.session.service;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * 
 * 海淘会话Dubbo服务启动类
 *
 * @author Kevin Chang
 */
public class PphtSessionServiceBootstrap
{

    private static Logger log = Logger.getLogger(PphtSessionServiceBootstrap.class);
    private static volatile boolean running = true;
    static ClassPathXmlApplicationContext context;

    public static void main(String[] args) throws Exception
    {
        log.info("################PphtSession准备启动服务！################");
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
        context.start();
        log.info("################PphtSession服务启动成功！################");
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run()
            {
                if (context != null)
                {
                    context.stop();
                    context.close();
                    context = null;
                }
                log.info("################PphtSession服务已经停止!################");
                synchronized (PphtSessionServiceBootstrap.class)
                {
                    running = false;
                    PphtSessionServiceBootstrap.class.notify();
                }
            }
        });

        synchronized (PphtSessionServiceBootstrap.class)
        {
            while (running)
            {
                try
                {
                    PphtSessionServiceBootstrap.class.wait();
                }
                catch (Throwable e)
                {}
            }
        }
    }
}