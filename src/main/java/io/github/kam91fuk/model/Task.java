package io.github.kam91fuk.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Task implements Audit , Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Task's description must not be empty")
    private String description;

    private boolean done;

    private LocalDateTime deadLine;

    @Getter(AccessLevel.NONE)
    @Column(name = "created_on")
    @CreatedDate
    private LocalDateTime createdOn;

    @Getter(AccessLevel.NONE)
    @Column(name = "updated_on")
    @LastModifiedDate
    private LocalDateTime updatedOn;

    @Transient
    @Setter(AccessLevel.NONE)
    private String targetDate;

    public void setTargetDate(String targetDate) {
        this.targetDate = targetDate;
        if (targetDate != null && !targetDate.isEmpty()) {
            LocalDate localDate = LocalDate.parse(targetDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            deadLine = localDate.atStartOfDay();
        }
    }


    public void updateFrom(final Task source) {
        description = source.description;
        done = source.done;
        deadLine = source.deadLine;
    }

    @Override
    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    @Override
    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

}