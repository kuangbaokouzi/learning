package com.entor.springmvcdemo.controller.formatter;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 日期格式化
 */
public class DateFomatter implements Formatter<Date> {

    private static final SimpleDateFormat YYYY_MM_DD_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * 将字符串解析为日期
     *
     * @param text
     * @param locale
     * @return
     * @throws ParseException
     */
    @Override
    public Date parse(String text, Locale locale) throws ParseException {
        Date date = null;
        try {
            date = YYYY_MM_DD_FORMAT.parse(text);
        } catch (ParseException pe) {
            pe.printStackTrace();
            ;
        }
        return date;
    }

    /**
     * 将日期格式化为字符串
     *
     * @param object
     * @param locale
     * @return
     */
    @Override
    public String print(Date object, Locale locale) {
        return YYYY_MM_DD_FORMAT.format(object);
    }
}
