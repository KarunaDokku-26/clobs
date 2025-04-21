package com.creditEvaluation.config;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Date;

@Component
public class DateFormatter implements Formatter<Date> {

    private static final String DATE_PATTERN = "yyyy-MM-dd";
    private final SimpleDateFormat dateFormat;

    public DateFormatter() {
        this.dateFormat = new SimpleDateFormat(DATE_PATTERN);
        this.dateFormat.setLenient(false);
    }

    @Override
    public Date parse(String text, Locale locale) throws ParseException {
        return dateFormat.parse(text);
    }

    @Override
    public String print(Date object, Locale locale) {

        return dateFormat.format(object);
    }
}