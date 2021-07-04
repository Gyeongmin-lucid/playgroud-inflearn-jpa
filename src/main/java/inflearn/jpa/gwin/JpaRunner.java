package inflearn.jpa.gwin;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/* Transcation는 어떻게 동작할까?
https://d2.naver.com/helloworld/407507
 */

@Component
@Transactional
public class JpaRunner implements ApplicationRunner {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    PostRepository postRepository;

    void accountStudy(){
        Account account = new Account();
        account.setUsername("gwin-hiberate-2");
        account.setPassword("jpa");

        Study study = new Study();
        study.setName("Spring Data JPA");

        account.addStudy(study);

        //hibernate
        Session session = entityManager.unwrap(Session.class);
        session.save(account);
        session.save(study);

        Account gwin = session.load(Account.class, account.getId());
        gwin.setUsername("gwin-reset-username");
        System.out.println("==============================");
        System.out.println(gwin.getUsername());

        //jpa
        //entityManager.persist(account);
    }

    void postComment(){
        Post post = new Post();
        post.setTitle("Spring Data JPA...");

        Comment comment = new Comment();
        comment.setComment("this is comment");
        post.addComment(comment);

        Comment comment1 = new Comment();
        comment1.setComment("comming soon");
        post.addComment(comment1);

        Session session = entityManager.unwrap(Session.class);
        session.save(post);

    }

    void deletePostSession(){
        Session session = entityManager.unwrap(Session.class);
        Post post = session.get(Post.class, 1l);
        session.delete(post);
    }

    void queryPost(){
        TypedQuery<Post> query = entityManager.createQuery("SELECT p FROM Post AS p", Post.class);
        List<Post> posts = query.getResultList();
        posts.forEach(System.out::println);
    }

    void queryPost2(){
        CriteriaBuilder builder =entityManager.getCriteriaBuilder();
        CriteriaQuery<Post> query = builder.createQuery(Post.class);
        Root<Post> root = query.from(Post.class);
        query.select(root);

        List<Post> posts = entityManager.createQuery(query).getResultList();
        posts.forEach(System.out::println);
    }

    void crudTestRepository(){
        postRepository.findAll().forEach(System.out::println);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        accountStudy();

//        postComment();
//        queryPost();
//        queryPost2();

//        deletePostSession();
        crudTestRepository();
    }
}
