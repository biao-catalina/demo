package com.example.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Document(indexName = "demo_test_hunan")
@Data
public class Demo {
    @Id
    private String id;

//    @Field(type = FieldType.Keyword)
    private String username;
    private String password;
    private List<String> loveThings;

    private LocalDate date;

    private LocalDateTime dateTime;
}
