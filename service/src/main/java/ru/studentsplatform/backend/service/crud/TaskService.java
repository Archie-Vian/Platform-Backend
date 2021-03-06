package ru.studentsplatform.backend.service.crud;

import org.springframework.web.multipart.MultipartFile;
import ru.studentsplatform.backend.domain.pojo.filters.TaskFilterPOJO;
import ru.studentsplatform.backend.entities.model.university.Task;

import java.util.List;

/**
 * CRUD сервис студенческого задания, прикрепляемого к определенному занятию.
 */
public interface TaskService extends AbstractService<Task> {

	/**
	 * Сохраняет запись о task в БД, если удается прикрепить task к ячейке расписания.
	 * В противном случае бросает бизнесс-исключение.
	 *
	 * @param newEntity Task для сохранения в БД
	 * @return Сохраненный task
	 */
	@Override
	Task create(Task newEntity);

	/**
	 * Поиск студенческой задачи по её Id.
	 *
	 * @param id Id задчи, которую необходимо найти
	 * @return Искомая задача
	 */
	@Override
	Task getById(Long id);

	/**
	 * Поиск всех студенческих задач, хранящихся в БД.
	 *
	 * @return лист всех имеющихся студенческих задач
	 */
	@Override
	List<Task> getAll();

	/**
	 * Обновление параметров студенческой задачи.
	 *
	 * @param updatedEntity Обновленные данные задачи
	 * @param id            Id задчи, которая будет обновлена
	 * @return Обновленная задача
	 */
	@Override
	Task update(Task updatedEntity, Long id);

	/**
	 * Удаление студенческой задачи.
	 *
	 * @param id Id задачи, которая должна быть удалена
	 * @return Успешно ли было произведено удаление
	 */
	@Override
	boolean delete(Long id);

	/**
	 * Добавление файлов к уже существующей Task.
	 *
	 * @param taskId ИД task
	 * @param files  Лист файлов
	 * @return Результат добавления
	 */
	boolean addFilesForTask(Long taskId, List<MultipartFile> files);

	/**
	 * Возвращает список задач, найденных с учетом фильтров.
	 *
	 * @param taskFilterPOJO Объект, содержащий в себе все поступающие фильтры
	 * @return список задач
	 */
	List<Task> getByFilters(TaskFilterPOJO taskFilterPOJO);

}
