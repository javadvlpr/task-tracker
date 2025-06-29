package uz.itpu.tasktracker.dto;

import lombok.*;
import uz.itpu.tasktracker.enums.Priority;
import uz.itpu.tasktracker.enums.Status;

import javax.validation.constraints.NotNull;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {
    private Integer id;
    @NotNull(message = "title shouldn't be null")
    private String title;
    @NotNull(message = "content shouldn't be null")
    private String content;
    private Status status;
    private Priority priority;
    @NotNull(message = "due date shouldn't be null")
    private Long dueDate;
    private Long createdDate;
}
