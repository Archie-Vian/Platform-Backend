package ru.studentsplatform.backend.notification;

/**
 * Утилитный класс для отправки сообщения через Telegram.
 *
 * @author Danila K (karnacevich5323537@gmail.com) (08.08.2020).
 */
public interface TelegramSender {
    /**
     * @param userId адрес отправки сообщения.
     * @param message сообщение для отправки.
     *
     */
    void sendMessage(String userId, String message);

}