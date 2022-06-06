package spring_introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConfigWintAnnotationAndXML {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("aplicationContext3.xml");

        Person person = context.getBean("personBean", Person.class);
        person.callYourPet();

        System.out.println(person.getSurname());
        System.out.println(person.getAge());

//        Cat cat = context.getBean("catBean", Cat.class);
//        cat.say();

        context.close();
    }
}