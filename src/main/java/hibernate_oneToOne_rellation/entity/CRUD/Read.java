package hibernate_oneToOne_rellation.entity.CRUD;

import hibernate_oneToOne_rellation.entity.Detail;
import hibernate_oneToOne_rellation.entity.Employees;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Read {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("/hibernate.cfg.xml")
                .addAnnotatedClass(Employees.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

        Session session = null;

        try {
            session = factory.getCurrentSession();
            session.beginTransaction();

            Employees emp = session.get(Employees.class, 1);
            System.out.println(emp.getEmpDetail());


            System.out.println("Done!");
        } finally {
            assert session != null;
            session.close();
            factory.close();
        }
    }
}
