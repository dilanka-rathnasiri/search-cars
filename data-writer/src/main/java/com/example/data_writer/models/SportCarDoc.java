package com.example.data_writer.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "sport-cars")
public record SportCarDoc(
        @Id int id, String brand, String model, String year, String price, String powerType,
        String acceleration, String engineSize, String power, String torque
) {
}
