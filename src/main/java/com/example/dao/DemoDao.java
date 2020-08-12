package com.example.dao;

import com.example.entity.Demo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemoDao extends ElasticsearchRepository<Demo, String> {

}
