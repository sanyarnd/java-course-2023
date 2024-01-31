package tinkoff2.strings;

import javax.swing.text.html.Option;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CsvParser {
    private static String csvFile = """
            id,dttm,payer,payernumber,amount,currency,tx_code
             0001,25.10.2023 16:53,o.ivanov,+79123456789,100.0,RUR,9001
            0002,-,v.petrov,89003000500,100500.0,USD,0010
             0003 ,2023-10-25 17:55:55.867,r.sidorov,+8(999)1234567,-10,RUR,1001             
             0004 ,2023-10-28 18:55:12,r.sidorov,23456-89,-10,RUR,1001             
                        """;

    public static void main(String[] args) {
        var map = parseCsvString(csvFile);

        System.out.println(map);
    }

    private static List<Map<String, Object>> parseCsvString(String csvFile) {
        var lines = csvFile.lines();
        var headers = lines.limit(1).findFirst().get().split(",");


        return csvFile.lines()
                .skip(1)
                .map(line -> {
                            var lineItems = line.split(",");
                            var parsedLine = new HashMap<String, Object>();
                            for (int i = 0; i < headers.length; i++) {
                                String header = headers[i];
                                parsedLine.put(header, processColumnValue(header, lineItems[i]));
                            }
                            return parsedLine;
                        }
                ).collect(Collectors.toList());


    }

    private static final Pattern phoneNumber = Pattern.compile("[+]?(7|8)?[(]?(\\d{3})[)]?\\d{7}$");
    private static Object processColumnValue(String colName, String colValue) {
        switch (colName) {
            case "dttm" -> {
                try {
                    return new SimpleDateFormat("dd.MM.yyy hh:mm").parse(colValue);
                } catch (ParseException e) {
                    return null;
                }
            }
            case "payernumber" -> {
                var matcher = phoneNumber.matcher(colValue);
                if (matcher.find()) {
                    return matcher.group(2);
                }
                return colValue;
            }
            default -> {
                return colValue.strip();
            }
        }
    }
}
