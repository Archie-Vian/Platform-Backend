package ru.studentsplatform.backend.domain.repository;

import com.querydsl.core.types.dsl.DateExpression;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.studentsplatform.backend.entities.model.university.QTask;
import ru.studentsplatform.backend.entities.model.university.Task;

import java.time.OffsetDateTime;
import java.util.List;


@Repository
public interface TaskRepository extends JpaRepository<Task, Long>,
		QuerydslPredicateExecutor<Task>, QuerydslBinderCustomizer<QTask> {
	@Override
	default void customize(QuerydslBindings querydslBindings, QTask qTask) {
		querydslBindings.bind(qTask.scheduleUserCell.scheduleCell.startClass).first((path, value) -> path.goe(value));
		querydslBindings.bind(qTask.scheduleUserCell.scheduleCell.endClass).first((path, value) -> path.loe(value));
	}

	@Query("select att from Task att join fetch  att.attachments " +
			"where att.scheduleUserCell.id = :userCellId")
	List<Task> findByScheduleUserCellId(@Param("userCellId") Long userCellId);

	@Query("select att from Task att join fetch  att.attachments " +
			"where att.scheduleUserCell.user.id = :userId")
	List<Task> findByUserId(@Param("userId") Long userId);

	@Query("select att from Task att join fetch  att.attachments " +
			"where att.scheduleUserCell.user.id = :userId and att.isDone = :isDone")
	List<Task> findByIsDoneByUserId(@Param("userId") Long userId,
									@Param("isDone") Boolean isDone);

	@Query("select att from Task att left  join fetch  att.attachments " +
			"where att.scheduleUserCell.user.id = :userId " +
			"and att.scheduleUserCell.discipline.semester = :semester")
	List<Task> findBySemesterByUserId(@Param("userId") Long userId,
									  @Param("semester") Integer semester);

	@Query("select att from Task att left  join fetch  att.attachments " +
			"where att.scheduleUserCell.user.id = :userId " +
			"and att.scheduleUserCell.discipline.subject.id = :subjectId")
	List<Task> findBySubjectIdByUserId(@Param("userId") Long userId,
									   @Param("subjectId") Long subjectId);

	@Query("select att from Task att left  join fetch  att.attachments " +
			"where att.scheduleUserCell.user.team.id = :teamId " +
			"and att.scheduleUserCell.discipline.subject.id = :subjectId")
	List<Task> findBySubjectIdForTeam(@Param("subjectId") Long subjectId,
									  @Param("teamId") Long teamId);

	@Query("select att from Task att left join fetch  att.attachments " +
			"where att.scheduleUserCell.user.id = :userId " +
			"and att.scheduleUserCell.scheduleCell.startClass >= :startTime " +
			"and att.scheduleUserCell.scheduleCell.endClass <= :endTime")
	List<Task> findByStartEndTimeForUser(@Param("userId") Long userId,
										 @Param("startTime") OffsetDateTime startTime,
										 @Param("endTime") OffsetDateTime endTime);

	@Query("select att from Task att left join fetch  att.attachments " +
			"where (:userId is null or att.scheduleUserCell.user.id = :userId) " +
			"and (:subjectId is null or att.scheduleUserCell.discipline.subject.id = :subjectId) " +
			"and (:groupId is null or att.scheduleUserCell.user.team.id = :userId) " +
			"and (:usrCellId is null or att.scheduleUserCell.id = :usrCellId) " +
			"and (:semester is null or att.scheduleUserCell.discipline.semester = :semester) " +
			"and (coalesce(:startTime, null) is null or att.scheduleUserCell.scheduleCell.startClass >= :startTime) " +
			"and (coalesce(:endTime, null) is null or att.scheduleUserCell.scheduleCell.endClass <= :endTime)")
	List<Task> findFiltered(@Param("userId") Long userId,
							@Param("usrCellId") Long usrCellId,
							@Param("subjectId") Long subjectId,
							@Param("groupId") Long groupId,
							@Param("semester") Integer semester,
							@Param("startTime") OffsetDateTime startTime,
							@Param("endTime") OffsetDateTime endTime);

}
