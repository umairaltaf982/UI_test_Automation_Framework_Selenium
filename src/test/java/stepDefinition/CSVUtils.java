package stepDefinition;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVUtils {

    public static List<String[]> readCSV(String filePath) throws IOException, CsvValidationException {
        List<String[]> csvData = new ArrayList<>();
        try (CSVReader csvReader = new CSVReader(new FileReader(filePath))) {
            String[] row;
            while ((row = csvReader.readNext()) != null) {
                csvData.add(row);  // Add each row to the list
            }
        }
        return csvData;
    }
}
