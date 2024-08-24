package com.example.data_writer;

import com.example.data_writer.models.SportCarDoc;
import com.example.data_writer.services.CsvService;
import com.example.data_writer.services.EsService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@SpringBootApplication
public class DataWriterApplication implements CommandLineRunner {

    private final ApplicationContext appContext;
    private final CsvService csvService;
    private final EsService esService;
    @Value("${csv.path}")
    private String csvFilePath;

    public static void main(String[] args) {
        SpringApplication.run(DataWriterApplication.class, args);
    }

    @Override
    public void run(String... args) {
        try {
            List<CSVRecord> records = csvService.loadCsvFile(csvFilePath);
            List<SportCarDoc> convertedDocs = esService.convertCsvRecordsToSportCarDoc(records);
            esService.insertData(convertedDocs);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            SpringApplication.exit(appContext);
        }
    }
}
