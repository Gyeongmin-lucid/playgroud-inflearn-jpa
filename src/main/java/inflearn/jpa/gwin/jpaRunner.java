package inflearn.jpa.gwin;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@Transactional
public class jpaRunner implements ApplicationRunner {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Account account = new Account();
        account.setUsername("gwin-hiberate-2");
        account.setPassword("jpa");

        //hibernate
        Session session = entityManager.unwrap(Session.class);
        session.save(account);

        //jpa
        //entityManager.persist(account);
    }
}
