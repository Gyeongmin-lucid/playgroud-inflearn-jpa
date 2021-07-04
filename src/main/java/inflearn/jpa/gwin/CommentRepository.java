package inflearn.jpa.gwin;

import java.util.List;
import org.springframework.data.repository.RepositoryDefinition;

/* 내가 custom하게 Repository를 구성하고 싶다? */
/* 기존 CRUD 매서드나 기타 쓰고싶은 메서드를 복사해서 가지고 오면 된다 */


/* DAO vs Repository의 차이는 무엇인가?
-> 참고 블로그 : https://bbbicb.tistory.com/44
-> DAL ( Data Access Layer)를 구성하는 차이
-> DAO : data지향언어, Repository : Domain 지향적 용어
-> Repository에서는 DAO사용이 가능? 이건 무슨말인지 잘 모르겠음
 */
public interface CommentRepository extends  MyRepository<Comment, Long>{

}
