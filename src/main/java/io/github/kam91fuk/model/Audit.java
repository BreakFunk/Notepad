package io.github.kam91fuk.model;


import jakarta.persistence.Embeddable;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.time.LocalDateTime;

//TODO: This class does not working with "Class Task" @Embeddable should works with @Embedded in class Task.
//TODO: Field "private LocalDateTime deadline;" in class Task, does not show description in database, it shows "null".

@Embeddable
class Audit {
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;

    @PrePersist
    void prePersist() { createdOn = LocalDateTime.now(); }

    @PrePersist
    void preUpdate() { updatedOn = LocalDateTime.now(); }
}
