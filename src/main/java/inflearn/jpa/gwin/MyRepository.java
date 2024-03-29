package inflearn.jpa.gwin;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

@NoRepositoryBean
public interface MyRepository<T, Id extends Serializable> extends Repository<T, Id> {
    <E extends T> E save(@NonNull E comment);
    List<T> findAll();
    long count();

    @Nullable
    <E extends T> E findById(Id id);
//    <E extends T> Optional<E> findById(Id id);
}
