package com.qtz.ht.order.service;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Dubbo服务启动类
 * 
 * @author Kevin Chang
 *
 */
public class HtOrderServiceBootstrap
{
    private static final Logger log = Logger.getLogger(HtOrderServiceBootstrap.class);
    private static volatile boolean running = true;
    static ClassPathXmlApplicationContext context;

    public static void main(String[] args) throws Exception
    {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
        context.start();
        log.info("################HtOrderService服务启动成功！################");
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run()
            {
                if (context != null)
                {
                    context.stop();
                    context.close();
                    context = null;
                }
                log.info("################HtOrderService服务已经停止!################");
                synchronized (HtOrderServiceBootstrap.class)
                {
                    running = false;
                    HtOrderServiceBootstrap.class.notify();
                }
            }
        });

        synchronized (HtOrderServiceBootstrap.class)
        {
            while (running)
            {
                try
                {
                    HtOrderServiceBootstrap.class.wait();
                }
                catch (Throwable e)
                {}
            }
        }
    }

}
