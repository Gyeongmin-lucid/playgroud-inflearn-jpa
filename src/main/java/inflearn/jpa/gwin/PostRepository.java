package inflearn.jpa.gwin;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

/***
 *
 \@EnableJpaRepositories
 ●	매직의 시작은 여기서 부터

 매직은 어떻게 이뤄지나?
 ●	시작은 @Import(JpaRepositoriesRegistrar.class)
 ●	핵심은 ImportBeanDefinitionRegistrar 인터페이스

 매직 구현하기
public class customRegister implements ImportBeanDefinitionRegistrar {
    \@Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(Keesun.class);
        beanDefinition.getPropertyValues().add("name", "keesun");
        registry.registerBeanDefinition("keesun", beanDefinition);
    }
}

 ***/

public interface PostRepository extends JpaRepository<Post, Long> {

    Page<Post> findByTitleContains(String title, Pageable pagealbe);
}

//@Repository
//public class PostRepository {
//    @PersistenceContext
//    EntityManager entityManager;
//
//    public Post add(Post post){
//        entityManager.persist(Post post);
//        return post;
//    }
//
//    public void delete(Post post){
//        entityManager.remove(post);
//    }
//
//    public List<Post> findAll(){
//        return entityManager.createQuery("SELECT p FROM Post As p", Post.class)
//            .getResultList();
//    }
//}
