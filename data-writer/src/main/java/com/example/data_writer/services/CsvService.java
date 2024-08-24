package com.example.data_writer.services;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

@Service
public class CsvService {
    public List<CSVRecord> loadCsvFile(final String fileName) throws IOException {
        Reader in = new FileReader(fileName);
        CSVFormat csvFormat = CSVFormat.DEFAULT.builder()
                .setHeader()
                .build();
        return csvFormat.parse(in).getRecords();
    }
}
