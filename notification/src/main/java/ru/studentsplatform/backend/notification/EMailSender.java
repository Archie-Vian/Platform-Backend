package ru.studentsplatform.backend.notification;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.io.IOException;
import java.util.List;

/**
 * Вспомогательный класс для отправки сообщения через email.
 *
 * @author Danila K (karnacevich5323537@gmail.com) (10.07.2020).
 */
public interface EMailSender {
	/**
	 * Метод для отправки сообщений без вложенных файлов.
	 *
	 * @param to      адрес отправки.
	 * @param subject Заголовок сообщения.
	 * @param body    основной текст сообщения, может быть в формате html.
	 */
	void send(@NonNull String to, String subject, String body);

	/**
	 * Метод для отправки сообщений с контентом(файлом).
	 *
	 * @param to          адрес отправки
	 * @param subject     Заголовок сообщения.
	 * @param body        основной текст сообщения.
	 * @param contentPath Адрес контента(файла) сообщения.
	 * @throws IOException в случае неправильного пути файла.
	 */
	void send(@NonNull String to, String subject,
			  String body, String contentPath) throws IOException;

	/**
	 * Метод для отправки сообщений с множественным контентом(файлами).
	 *
	 * @param to           адрес отправки.
	 * @param subject      Заголовок сообщения.
	 * @param body         основной текст сообщения.
	 * @param contentPaths Адреса контента(файлов) сообщения.
	 * @throws IOException в случае неправильного пути файла.
	 */
	void send(@NonNull String to, String subject,
			  String body, List<String> contentPaths)
			throws IOException;

	/**
	 * Метод для отправки сообщений с множественным контентом(файлами).
	 *
	 * @param to           адрес отправки.
	 * @param subject      Заголовок сообщения.
	 * @param htmlPath     основной текст сообщения, может быть в формате html.
	 * @param contentPaths Адреса контента(файлов) сообщения.
	 * @throws IOException в случае неправильного пути файла.
	 */
	void sendHtml(@NonNull String to, String subject,
				  String htmlPath, @Nullable List<String> contentPaths)
			throws IOException;
}
