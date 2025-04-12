package ru.job4j.ood.srp.report;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarSerializerXml extends XmlAdapter<String, Calendar> {
    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("dd:MM:yyyy HH:mm");

    @Override
    public Calendar unmarshal(String date) throws Exception {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(SIMPLE_DATE_FORMAT.parse(date));
        return calendar;
    }

    @Override
    public String marshal(Calendar calendar) {
        return SIMPLE_DATE_FORMAT.format(calendar.getTime());
    }
}
