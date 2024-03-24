package io.github.kam91fuk.repository;

import io.github.kam91fuk.model.Task;
import io.github.kam91fuk.repository.TaskRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SqlTaskRepository extends CrudRepository<Task, Integer> {
    //CrudRepository provides the basic methods live save,findAll,findById out of the boc and creates implementation class on runtime

    @Query(nativeQuery = true, value = "select count(*) > 0 from tasks where id =:id")
    boolean existsById(@Param("id") Integer id);

    Page<Task> findAll(Pageable page);
    List<Task> findByDone(@Param("state") boolean done);
    List<Task> findAll();

}
