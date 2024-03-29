package io.github.kam91fuk.repository;

import io.github.kam91fuk.model.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TaskRepository {
    List<Task> findAll();
    Page<Task> findAll(Pageable page);
    boolean existsById(Integer id);
    Optional<Task> findById(Integer id);
    List<Task> findByDone(@Param("state") boolean done);
    Task save(Task entity);
}
