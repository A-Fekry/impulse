package com.spring.system.task_managment_system.service.bundel;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Locale;

@Service
public class LocalBundleMessageService {

    private final MessageSource messageSource;

    public LocalBundleMessageService(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    /**
     * Get localized message based on current locale.
     *
     * @param key the message key
     * @return localized message
     */
    public String getMessage(String key) {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(key, null, locale);
    }

    /**
     * Get localized message based on provided locale and arguments.
     *
     * @param key the message key
     * @param args arguments to format inside the message
     * @return localized formatted message
     */
    public String getMessage(String key, Object[] args) {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(key, args, locale);
    }

    /**
     * Get Arabic localized message explicitly.
     *
     * @param key the message key
     * @return Arabic message
     */
    public String getArabicMessage(String key) {
        Locale arabicLocale = new Locale("ar");
        return messageSource.getMessage(key, null, arabicLocale);
    }

    /**
     * Get English localized message explicitly.
     *
     * @param key the message key
     * @return English message
     */
    public String getEnglishMessage(String key) {
        Locale englishLocale = new Locale("en");
        return messageSource.getMessage(key, null, englishLocale);
    }

    /**
     * Utility method to get current timestamp.
     *
     * @return current LocalDateTime
     */
    public LocalDateTime getCurrentTimestamp() {
        return LocalDateTime.now();
    }
}

