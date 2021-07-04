package inflearn.jpa.gwin;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

/*
Runtime Assertion : Intellj에서 null을 쓰려할때 미리 알려쥼
Add runtime assertion for notnull-annotated methods and parameters
여기서 spring 관련 NonNullApi /  Nullable / NonNull을 추가
 */

@RunWith(SpringRunner.class)
@DataJpaTest
public class CommentRepositoryTest {

    @Autowired
    CommentRepository commentRepository;

    @Test
    public void test(){
//        Comment comment = new Comment();
//        comment.setComment("Hello Comment");
//        commentRepository.save(comment);
//
//        List<Comment> all = commentRepository.findAll();
//        assertThat(all.size()).isEqualTo(1);
//
//        long count = commentRepository.count();
//        assertThat(count).isEqualTo(1);

        List<Comment> comments = commentRepository.findAll();
        assertThat(comments).isEmpty();

        commentRepository.save(null);

//        Comment comment = commentRepository.findById(100l);
//        if(comment == null){
//            throw new IllegalArgumentException();
//        }

//        Optional<Comment> byId = commentRepository.findById(100l);
//        Comment comment = byId.orElseThrow(IllegalArgumentException::new);
    }
}