package uz.itpu.tasktracker.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import uz.itpu.tasktracker.enums.Priority;
import uz.itpu.tasktracker.enums.Status;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tasks")
public class TaskEntity {
    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "status")
    @Enumerated(EnumType.ORDINAL)
    private Status status;

    @Column(name = "priority")
    @Enumerated(EnumType.ORDINAL)
    private Priority priority;

    @Column(name = "created_datetime")
    private LocalDateTime createDate;

    @Column(name = "due_datetime")
    private LocalDateTime dueDate;

    @Column(name = "deleted_datetime")
    private LocalDateTime deleteDate;

    @Column(name = "is_deleted")
    private boolean isDeleted;
}
