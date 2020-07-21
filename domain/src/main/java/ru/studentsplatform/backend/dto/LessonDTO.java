package ru.studentsplatform.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import ru.studentsplatform.backend.entities.model.Attendance;
import ru.studentsplatform.backend.entities.model.Homework;
import ru.studentsplatform.backend.entities.model.Mark;
import ru.studentsplatform.backend.entities.model.Team;
import ru.studentsplatform.backend.entities.model.LessonUnit;


import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.List;

@Data
@SuperBuilder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class LessonDTO extends BaseDTO implements Serializable {

    private OffsetDateTime date;
    private Team team;
    private LessonUnit lessonUnit;
}
