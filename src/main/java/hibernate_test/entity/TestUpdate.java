package hibernate_test.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestUpdate {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("/hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
//            Employee emp = session.get(Employee.class, 3);
//            emp.setSalary(50_000);

            session.createQuery("update Employee set salary=60000 where name='Oleg'")
                            .executeUpdate();

            session.getTransaction().commit();

            System.out.println("Done!");
            //System.out.println(emp);
        } finally {
            factory.close();
        }
    }
}
