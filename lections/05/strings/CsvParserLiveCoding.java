package tinkoff2.strings;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CsvParserLiveCoding {
    private static String csvFile = """
            id,dttm,payer,payernumber,amount,currency,tx_code
             0001,25.10.2023 16:53,o.ivanov,+79123456789,100.0,RUR,9001
            0002,-,v.petrov,89003000500,100500.0,USD,0010
             0003 ,2023-10-25 17:55:55.867,r.sidorov,+8(999)1234567,-10,RUR,1001             
             0004 ,2023-10-28 18:55:12,r.sidorov,23456-89,-10,RUR,1001             
                        """;

    public static void main(String[] args) {
        var file = new File("data.csv");
        if (!file.exists()) {
            System.out.println("No file");
        }
        try (var fileContent = new BufferedReader(new FileReader(file))) {
            var fileLines = fileContent.lines().collect(Collectors.toList());
            System.out.println(fileLines);

        } catch (IOException io) {

        }

        //todo parse strings from file
        var map = parseCsvString(csvFile);

        System.out.println(map);
    }

    private static Pattern phoneNumberPattern = Pattern.compile("[+]?[7|8]?[(]?(\\d{3})[)]?\\d{7}");
    private static List<Map<String, Object>> parseCsvString(String csvFile) {

        //1.get column names from first line
        var columnNames = csvFile.lines().findFirst().get().split(",");
        //2.skip first line and for each line split by , and process each value (trimmed)
        return csvFile.lines().skip(1).map(line -> {
            var columnValues = line.split(",");
            var lineMap = new HashMap<String, Object>();
            for (int i = 0; i < columnNames.length; i++) {
                String columnName = columnNames[i];
                extractValue(lineMap, columnName, columnValues[i]);
            }
            return lineMap;
        }).collect(Collectors.toList());
        //3.validate phone number and get operator-code from it, return as op_code field
        //4.parse date
        //5. return List of Maps


    }

    private static void extractValue(HashMap<String, Object> lineMap, String columnName, String columnValue) {
        if ("payernumber".equals(columnName)) {
            var matcher = phoneNumberPattern.matcher(columnValue);
            if (matcher.find()) {
                var opCode = matcher.group(1);
                lineMap.put("op_code", opCode);
            }
        }
        if ("dttm".equals(columnName)) {
            //25.10.2023 16:53
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy hh:mm");
            try {
                Date date = sdf.parse(columnValue);
                lineMap.put(columnName, date);

            } catch (ParseException e) {
//                new SimpleDateFormat("yyyy-MM-dd")
            }
        } else {
            lineMap.put(columnName, columnValue);
        }
    }
}
