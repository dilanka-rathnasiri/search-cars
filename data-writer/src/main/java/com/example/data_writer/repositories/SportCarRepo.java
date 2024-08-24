package com.example.data_writer.repositories;

import com.example.data_writer.models.SportCarDoc;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SportCarRepo extends ElasticsearchRepository<SportCarDoc, Integer> {
}
