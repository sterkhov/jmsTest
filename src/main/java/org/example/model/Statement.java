package org.example.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * Заявка ведомства
 */
@Data
@NoArgsConstructor
public class Statement {
    /**
     * Имя клиента
     */
    private String clientName;
    /**
     * Статус заявления
     */
    private StatusStatement status;
    /**
     * Наименование услуги
     */
    private StatementName statementName;
    /**
     * Серия паспорта
     */
    private String serial;

    /**
     * Номер паспорта
     */
    private String number;

    /**
     * Кем выдан паспорт
     */
    private String getter;

    /**
     * Дата выдачи паспорта
     */
    private Date dateGet;

    /**
     * Код подразделения паспорта
     */
    private String code;

    /**
     * Пути к файлам
     */
    private List<String> attachedFileNames;

}