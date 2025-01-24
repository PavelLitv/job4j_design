package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        String name = "Raul";
        byte age = 19;
        short height = 185;
        float weight = 75.5f;
        int iq = 142;
        long account = 10000L;
        double point = 100500.5;
        boolean isActive = true;
        char gender = 'M';

        LOG.debug(
                "User info name : {}, age : {}, height : {}, weight : {}, iq : {}, gender : {}, account : {}, has points : {}, is active : {}",
                name, age, height, weight, iq, gender, account, point, isActive);
    }
}
