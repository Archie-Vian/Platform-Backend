package ru.studentsplatform.backend.entities.model.user;

import lombok.Data;
import ru.studentsplatform.backend.entities.model.BaseEntity;
import ru.studentsplatform.backend.entities.model.enums.NotificationType;
import ru.studentsplatform.backend.entities.model.enums.UniversityRoleEnum;
import ru.studentsplatform.backend.entities.model.university.Discipline;
import ru.studentsplatform.backend.entities.model.university.PlaceStudy;
import ru.studentsplatform.backend.entities.model.university.Team;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.FetchType;

import java.util.List;

/**
 * Класс всех пользователей.
 */
@Data
@Entity
@Table(name = "usr")
public class User extends BaseEntity {
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private UserInfo userInfo;

	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "telegram_id")
	private String telegramId;

	@Column(name = "vk_id")
	private String vkId;

	@Column(name = "notification_type",
			columnDefinition = "varchar(255) default 'Email'"
	)
	@Enumerated(EnumType.STRING)
	private NotificationType notificationType;

	@Column(name = "university_role")
	@Enumerated(EnumType.STRING)
	private UniversityRoleEnum universityRole;

	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private PlaceStudy placeStudy;

	@ManyToOne
	@JoinColumn(name = "team_id")
	private Team team;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private List<Discipline> disciplines;
}
