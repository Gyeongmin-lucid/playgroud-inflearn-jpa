package inflearn.jpa.gwin;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
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

//        List<Comment> comments = commentRepository.findAll();
//        assertThat(comments).isEmpty();


//        Comment comment = commentRepository.findById(100l);
//        if(comment == null){
//            throw new IllegalArgumentException();
//        }

//        Optional<Comment> byId = commentRepository.findById(100l);
//        Comment comment = byId.orElseThrow(IllegalArgumentException::new);
    }

    @Test
    public void Common4(){

        Pageable pageable = PageRequest.of(0, 10, Sort.by(Direction.DESC, "LikeCount"));
//        this.createComment(1);
        this.createComment(100, "spring data jpa");
        this.createComment(55, "HIBERNATE SPRING");

//        List<Comment> comments = commentRepository.findByCommentContainsIgnoreCase("spring");
//        assertThat(comments.size()).isEqualTo(1);

//        List<Comment> comments_2 = commentRepository.findByCommentContainsIgnoreCaseAndLikeCountGreaterThan("spring", 10);
//        assertThat(comments_2.size()).isEqualTo(1);

//        List<Comment> comments_3 = commentRepository.findByCommentContainsIgnoreCaseOrderByLikeCountDesc("spring");
//        assertThat(comments_3.size()).isEqualTo(2);
//        assertThat(comments_3).first().hasFieldOrPropertyWithValue("likeCount", 100);
//
//        List<Comment> comments_4 = commentRepository.findByCommentContainsIgnoreCaseOrderByLikeCountAsc("spring");
//        assertThat(comments_4.size()).isEqualTo(2);
//        assertThat(comments_4).first().hasFieldOrPropertyWithValue("likeCount", 55);
//
        Page<Comment> comments_5 = commentRepository.findByCommentContainsIgnoreCase("Spring", pageable);
        assertThat(comments_5.getNumberOfElements()).isEqualTo(2);
        assertThat(comments_5).first().hasFieldOrPropertyWithValue("likeCount", 100);
    }

    private void createComment(int count, String comment) {
        Comment newComment = new Comment();
        newComment.setComment(comment);
        newComment.setLikeCount(count);
        commentRepository.save(newComment);
    }
}