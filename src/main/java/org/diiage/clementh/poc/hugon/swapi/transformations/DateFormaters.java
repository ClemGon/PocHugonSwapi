package org.diiage.clementh.poc.hugon.swapi.transformations;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateFormaters {
    private static final String DATE_FORMATTER= "dd-MM-yyyy HH:mm:ss";

    public static  String DateFormater(String Date){
        String dateCreated = Date;
        String recup = dateCreated.substring(0, dateCreated.length()-2);

        LocalDateTime localDateTime = LocalDateTime.parse(recup); //get current date time
        System.out.println("Current Time " + localDateTime);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);
        String formatDateTime = localDateTime.format(formatter);

        return formatDateTime;
    }
}
