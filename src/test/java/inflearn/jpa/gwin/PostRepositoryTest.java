package inflearn.jpa.gwin;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
/*
왜 save했는데 create안함?
-> @DataJpaTest안에 transection 이 붙어있어서
   데이터를 db에 저장하지 않은채 id만 들고와서 true 리턴
-> 보고싶다면 @Rollback(false) 필요
*/

/*
assertJ를 통해서 test를 구성하자
junit 4 : @RunWith(SpringRunner.class)
junit 5 : @ExtendWith(SpringExtension.class)

@DataJpaTest : Jpa 관련 테스트만 가능하게 하면서 Test에 속도측면에 이점이 있을 수 있음
*/

/*
쿼리 후 리턴 타입 : Page / Slice / List

 */

@RunWith(SpringRunner.class)
@DataJpaTest
public class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @Test
    @Rollback(false)
    public void crudRepository(){
        //given
        Post post = new Post();
        post.setTitle("hello spring boot common");
        assertThat(post.getId()).isNull();

        /* 1 */
        //when
        Post newPost = postRepository.save(post);

        //then
        assertThat(newPost.getId()).isNotNull();

        /* 2 */
        //when
        List<Post> posts = postRepository.findAll(); // JpaRepository 에서 옴

        //then
        assertThat(posts.size()).isEqualTo(1);
        assertThat(posts).contains(newPost);

        /* 3 */
        //when
        Page<Post> page = postRepository.findAll(PageRequest.of(0, 10));

        //then
        assertThat(page.getTotalElements()).isEqualTo(1);
        assertThat(page.getNumber()).isEqualTo(0);
        assertThat(page.getSize()).isEqualTo(10);
        assertThat(page.getNumberOfElements()).isEqualTo(1);

        /* 4 */
        //When
        postRepository.findByTitleContains("spring", PageRequest.of(0,10));

        //then
        assertThat(page.getTotalElements()).isEqualTo(1);
        assertThat(page.getNumber()).isEqualTo(0);
        assertThat(page.getSize()).isEqualTo(10);
        assertThat(page.getNumberOfElements()).isEqualTo(1);
    }
}