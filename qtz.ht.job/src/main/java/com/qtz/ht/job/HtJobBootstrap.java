package com.qtz.ht.job;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * 海淘定时任务启动引擎
 *
 * @author Kevin Chang
 */
public class HtJobBootstrap
{

    private static Logger log = Logger.getLogger(HtJobBootstrap.class);
    private static volatile boolean running = true;
    static ClassPathXmlApplicationContext context;

    public static void main(String[] args) throws Exception
    {
        log.info("################HtJob准备启动服务！################");
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
        context.start();
        log.info("################HtJob服务启动成功！################");
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run()
            {
                if (context != null)
                {
                    context.stop();
                    context.close();
                    context = null;
                }
                log.info("################PphtSessionService服务已经停止!################");
                synchronized (HtJobBootstrap.class)
                {
                    running = false;
                    HtJobBootstrap.class.notify();
                }
            }
        });

        synchronized (HtJobBootstrap.class)
        {
            while (running)
            {
                try
                {
                    HtJobBootstrap.class.wait();
                }
                catch (Throwable e)
                {}
            }
        }
    }
}
