package inflearn.jpa.gwin;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
public class Account {

    // id : primary key를 의미 (generatedValue는 자동 생성)
    // generatedValue : id의 자동 생성 4가지
    // AUTO / IDENTITY / SEQUENCE / TABLE
    @Id @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;
    private String password;

    @Temporal(TemporalType.TIME)
    private Date created = new Date();

    private String yes;

    @Transient
    private String no;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
