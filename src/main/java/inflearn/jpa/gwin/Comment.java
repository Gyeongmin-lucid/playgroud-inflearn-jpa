package inflearn.jpa.gwin;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GeneratorType;

@Setter
@Getter
@Entity
public class Comment {
    @Id
    @GeneratedValue
    private Long id;
    private String comment;

    @ManyToOne
    private Post post;

    private Date created;
    private Integer likeCount = 1;

}
