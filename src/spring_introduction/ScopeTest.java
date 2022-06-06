package spring_introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScopeTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("aplicationContext3.xml");
        Dog myDog = context.getBean("dog", Dog.class);
        myDog.say();
//        Dog yourDog = context.getBean("dog", Dog.class);
//        System.out.println("Ссылки равны? " + (myDog == yourDog));
        context.close();
    }
}
