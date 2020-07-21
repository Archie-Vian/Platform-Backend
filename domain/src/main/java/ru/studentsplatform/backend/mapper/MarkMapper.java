package ru.studentsplatform.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.studentsplatform.backend.dto.MarkDTO;
import ru.studentsplatform.backend.entities.model.Mark;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MarkMapper {

    @Mappings({
            @Mapping(target = "id", source = "entity.id"),
            @Mapping(target = "createdBy", source = "entity.createdBy"),
            @Mapping(target = "modifiedBy", source = "entity.modifiedBy"),
            @Mapping(target = "markValue", source = "entity.markValue"),
            @Mapping(target = "student", source = "entity.student"),
            @Mapping(target = "lesson", source = "entity.lesson")
    })
    MarkDTO markToMarkDTO(Mark entity);

    @Mappings({
            @Mapping(target = "id", source = "dto.id"),
            @Mapping(target = "createdBy", source = "dto.createdBy"),
            @Mapping(target = "modifiedBy", source = "dto.modifiedBy"),
            @Mapping(target = "markValue", source = "dto.markValue"),
            @Mapping(target = "student", source = "dto.student"),
            @Mapping(target = "lesson", source = "dto.lesson")
    })
    Mark markDTOtoMark(MarkDTO dto);

    List<MarkDTO> listMarkToMarkDTO(List<Mark> entity);
    List<Mark> listMarkDTOtoMark(List<MarkDTO> dto);

}