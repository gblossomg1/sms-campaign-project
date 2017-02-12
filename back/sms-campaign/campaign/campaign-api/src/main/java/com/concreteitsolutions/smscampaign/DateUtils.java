package com.concreteitsolutions.smscampaign;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    private final static SimpleDateFormat formatter = new SimpleDateFormat();

    public final static String DEFAULT_FRENCH_PATTERN = "dd.MM.yyyy 'à' HH:mm:ss";

    public static String parseDate(Date date, final String pattern) {

        formatter.applyPattern(pattern);

        return formatter.format(date);
    }
}
