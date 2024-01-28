package hibernate_test.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestReadExample {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("/hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            int employeeId = 1;

            Session session = factory.getCurrentSession();
            session.beginTransaction();

            Employee emp = session.get(Employee.class, employeeId);

            session.getTransaction().commit();

            System.out.println(emp);
            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}
