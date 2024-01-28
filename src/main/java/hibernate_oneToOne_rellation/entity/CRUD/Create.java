package hibernate_oneToOne_rellation.entity.CRUD;

import hibernate_oneToOne_rellation.entity.Detail;
import hibernate_oneToOne_rellation.entity.Employees;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Create {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("/hibernate.cfg.xml")
                .addAnnotatedClass(Employees.class)
                .addAnnotatedClass(Detail.class )
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();

            Employees emp = new Employees("Mammud", "Mahham", "Sales", 30);
            Detail detail = new Detail("Kyiv", "+380509876543", "ali@mail.com");
            emp.setEmpDetail(detail);

            session.beginTransaction();
            session.save(emp);
            session.getTransaction().commit();

            System.out.println("Done!");
            System.out.println(emp);
        } finally {
            factory.close();
        }
    }
}
