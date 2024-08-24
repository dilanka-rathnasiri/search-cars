package com.example.data_writer.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Getter
@Setter
@AllArgsConstructor
@Document(indexName = "sport-cars")
public class SportCarDoc {
    @Id
    private int id;
    private String brand;
    private String model;
    private String year;
    private String price;
    private String powerType;
    private String acceleration;
    private String engineSize;
    private String power;
    private String torque;
}
