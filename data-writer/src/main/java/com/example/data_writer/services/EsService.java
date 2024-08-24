package com.example.data_writer.services;

import com.example.data_writer.models.SportCarDoc;
import com.example.data_writer.repositories.SportCarRepo;
import lombok.AllArgsConstructor;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@AllArgsConstructor
@Service
public class EsService {
    private final SportCarRepo sportCarRepo;

    public Iterable<SportCarDoc> convertCsvRecordsToSportCarDoc(Iterable<CSVRecord> csvRecords) {
        int i = 0;
        ArrayList<SportCarDoc> sportCarDocs = new ArrayList<>();
        for (CSVRecord csvRecord : csvRecords) {
            sportCarDocs.add(new SportCarDoc(
                    i++,
                    csvRecord.get("brand"),
                    csvRecord.get("model"),
                    csvRecord.get("year"),
                    csvRecord.get("price"),
                    csvRecord.get("power_type"),
                    csvRecord.get("acceleration"),
                    csvRecord.get("engine_size"),
                    csvRecord.get("power"),
                    csvRecord.get("torque")
            ));
        }
        return sportCarDocs;
    }


    public void insertData(final Iterable<SportCarDoc> records) {
        sportCarRepo.saveAll(records);
    }
}
