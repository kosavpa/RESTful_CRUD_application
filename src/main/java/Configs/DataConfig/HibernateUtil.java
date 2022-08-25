package Configs.DataConfig;

import Model.Person;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class HibernateUtil {
    private SessionFactory sessionFactory;

    public HibernateUtil() {
    }

    @PostConstruct
    public void init(){
        try {
            StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                    .configure()
                    .build();


            sessionFactory = new MetadataSources(registry).addAnnotatedClass(Person.class).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            System.out.println("Исключение фабрики сессий:" + e);
        }
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
