package com.entor.springmvcdemo.controller.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 字符串（yyyy-MM-dd）转日期
 */
public class StringToDateConverter implements Converter<String, Date> {


    private static final SimpleDateFormat YYYY_MM_DD_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public Date convert(String source) {
        Date date = null;
        try {
            date = YYYY_MM_DD_FORMAT.parse(source);
        } catch (ParseException pe) {
            pe.printStackTrace();
        }
        return date;
    }
}
