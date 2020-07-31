package ru.studentsplatform.backend.domain.dto.university;

import lombok.Data;
import ru.studentsplatform.backend.domain.dto.BaseDTO;
import ru.studentsplatform.backend.domain.dto.user.UserDTO;

import java.util.List;

@Data
public class DepartmentDTO extends BaseDTO {

    private String department;
    private Long facultyId;
    private List<UserDTO> users;

}
