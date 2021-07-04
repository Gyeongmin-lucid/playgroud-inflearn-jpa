package inflearn.jpa.gwin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.QueryLookupStrategy.Key;

/*
@EnableJpaRepositories(queryLookupStrategy = Key.CREATE)
jpa query문 만들때 3가지의 strategy가 있는데
CREATE : method를 보고 만들기
USE_DECLARED_QUERY : 미리 정의한 쿼리 찾아 사용
CREATE_IF_NOT_FOUND : 쿼리먼저 보고 없으면 CREATE로 동작하게 하기

default : CREATE이며, 굳이 만지지 않아도 됨
*/

@SpringBootApplication
public class GwinApplication {

    public static void main(String[] args) {
        SpringApplication.run(GwinApplication.class, args);
    }

}
