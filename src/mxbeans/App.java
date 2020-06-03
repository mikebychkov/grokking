package mxbeans;

import java.lang.management.ManagementFactory;

import javax.management.MBeanServer;
import javax.management.ObjectName;


/**
 * <a href="https://urvanov.ru">https://urvanov.ru</a>
 *
 */
public class App {

    public static void main( String[] args ) throws Exception
    {
        MBeanServer mbs =
                ManagementFactory.getPlatformMBeanServer();

        ObjectName mxbeanName = new ObjectName("ru.urvanov.javaexamples.mxbeans:type=Lair");

        Lair mxbean = new Lair(new Monster("Goblin", 13));

        mbs.registerMBean(mxbean, mxbeanName);

        System.out.println("Waiting...");
        Thread.sleep(Long.MAX_VALUE);
    }
}
