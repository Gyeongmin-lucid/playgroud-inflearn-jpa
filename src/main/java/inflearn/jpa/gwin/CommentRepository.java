package inflearn.jpa.gwin;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;

/* 내가 custom하게 Repository를 구성하고 싶다? */
/* 기존 CRUD 매서드나 기타 쓰고싶은 메서드를 복사해서 가지고 오면 된다 */


/* DAO vs Repository의 차이는 무엇인가?
-> 참고 블로그 : https://bbbicb.tistory.com/44
-> DAL ( Data Access Layer)를 구성하는 차이
-> DAO : data지향언어, Repository : Domain 지향적 용어
-> Repository에서는 DAO사용이 가능? 이건 무슨말인지 잘 모르겠음
 */

/*
strategy 1 : method 이름을 분석하여 바로 찾아줌 (추천. + 쿼리 테스트)
strategy 2 : @Query 를 통해서 직접 가지고 옴
  -> nativeQuery true : SQL로 사용하여야 함
  -> nativeQuery false : JPQL로 사용하여야 함
 */

/*
쿼리 만드는 방법
return {접두어}{도입부}By{Property}{조건식}[(And|Or){Property}]{정렬조건} (parameter)

Return : E , Optional<E>, List<E>, Page<E>, Slice<E>, Stream<E>
접두어 : find / get / query / count ...
도입부 : Distinct, First1, First10, Top1, Top10
 -> 10개 이런건 page로 처리하는것이 좋음
By
Property : Person.Address.zipCode => find(Person)ByAddress_ZipCode(...)
조건식 : IgnoreCase, Between, LessThan, GreaterThan, Like, Contains, ...
정렬 : OrderBy{Property}Asc|Desc
parameter : Pageable, Sort
 */

/*
page를 사용할떄 주의할 점 : PageRequest를 사용하더라도 Pageable로 파라미터를 넣어 줘야 한다
 */

public interface CommentRepository extends  MyRepository<Comment, Long>{

    @Query(value = "SELECT c FROM Comment AS c", nativeQuery = true)
    List<Comment> findByTitleContains(String keyword);

    List<Comment> findByCommentContains(String keyword);
    Page<Comment> findByLikeCountGreaterThanAndPost(int likeCount, Post post, Pageable pageable);

    Page<Comment> findByCommentContainsIgnoreCase(String spring, Pageable pageable);

    List<Comment> findByCommentContainsIgnoreCaseAndLikeCountGreaterThan(String spring, int i);

    List<Comment> findByCommentContainsIgnoreCaseOrderByLikeCountDesc(String spring);

    List<Comment> findByCommentContainsIgnoreCaseOrderByLikeCountAsc(String spring);
}
