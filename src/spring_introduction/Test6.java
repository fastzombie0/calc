package spring_introduction;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Test6 {
    static AtomicInteger a = new AtomicInteger(2);
    volatile int b = 55;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);
        a.incrementAndGet();
        System.out.println(a.get());

        Person person = context.getBean("personBean", Person.class);
        person.callYourPet();

    }
}
