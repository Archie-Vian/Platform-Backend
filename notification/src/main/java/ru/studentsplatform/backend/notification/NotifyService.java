package ru.studentsplatform.backend.notification;

import ru.studentsplatform.backend.entities.model.enums.NotificationType;
import ru.studentsplatform.backend.entities.model.user.User;
import ru.studentsplatform.backend.notification.enumerated.MessageType;

import java.util.List;

/**
 * Централизованный сервис для отправки уведомлений пользователям.
 *
 * @author Danila K (karnacevich5323537@gmail.com) (07.08.2020).
 */
public interface NotifyService {

    /**
     * Метод для для отправки уведомлений пользователям.
     *
     * @param user полользователь для отправки.
     * @param messageType устанавливается необходимый {@link MessageType}.
     * @param args необходимые для подстановки в шаблон значения.
     */
    void sendNotification(User user, MessageType messageType, String... args);

    /**
     * Метод c определённый типом отправки уведомлений.
     *
     * @param user полользователь для отправки.
     * @param messageType устанавливается необходимый {@link MessageType}.
     * @param args необходимые для подстановки в шаблон значения.
     */
    void sendNotification(User user, MessageType messageType,
                          NotificationType notificationType,
                          String... args);

    /**
     * Метод для для отправки уведомлений пользователям.
     *
     * @param users полользователи для отправки.
     * @param notificationTypes получаются необходимые способы
     * отправки уведомления.
     * @param messageType тип сообщения в виде {@link MessageType}.
     * @param args необходимые для подстановки в шаблон значения.
     */
    void sendNotification(List<User> users, List<NotificationType> notificationTypes,
                          MessageType messageType, String ...args);

    /**
     * Реализация оправки сообщения черерз Email-сервис.
     *
     * @param user полользователь для отправки.
     * @param message получает ноебходимое сообщение для отправки.
     * @param args необходимые для подстановки в шаблон значения.
     */
    void sendEmail(User user, String message, String... args);

    /**
     * Реализация оправки сообщения черерз VK-сервис.
     *
     * @param user полользователь для отправки.
     * @param message получает ноебходимое сообщение для отправки.
     * @param args необходимые для подстановки в шаблон значения.
     */
    void sendVK(User user, String message, String... args);

    /**
     * Реализация оправки сообщения черерз Telegram-сервис.
     *
     * @param user полользователь для отправки.
     * @param message получает ноебходимое сообщение для отправки.
     * @param args необходимые для подстановки в шаблон значения.
     */
    void sendTelegram(User user, String message, String... args);
}
