package org.example;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@ToString
@Accessors(chain = true)
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    private UUID id;
    private String summary;
    private Integer priority;
    private TaskStatus status;
    private String user;
    @ToString.Exclude
    private LocalDateTime dateCreated;
}
