package io.github.kam91fuk.model;


import jakarta.persistence.Embeddable;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.time.LocalDateTime;

//TODO: This class does not working with "Class Task".
//TODO: Field "private LocalDateTime deadline;" in class Task, does not show description in database, it shows "null".

interface Audit {
    LocalDateTime getCreatedOn();
    LocalDateTime getUpdatedOn();
}
