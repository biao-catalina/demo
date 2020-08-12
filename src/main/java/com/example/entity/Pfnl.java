package com.example.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;
import java.util.List;

@Document(indexName = "pfnl3", replicas = 0)
@Data
@EqualsAndHashCode(callSuper = false, of = {"gid"})
@NoArgsConstructor
public class Pfnl{


    @Id
    private String gid;

    @Field(type = FieldType.Keyword)
    //@JsonProperty("CaseFlag")
    private String caseFlag;

    @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
    //@JsonProperty("Title")
    private String title;
    /**
     * 标准化后的数据
     */
    @Field(type = FieldType.Keyword, name = "normal")
    private String normal;

    //@JsonProperty("CheckFullText")
    @JSONField(deserialize = false)
    private String checkFullText;

    private String html;


    @JsonFormat(pattern = "yyyy.MM.dd")
    @JSONField(format = "yyyy.MM.dd")
    //@JsonProperty("LastInstanceDate")
    private Date lastInstanceDate;

    /**
     * 最后修改时间
     */
    @Field(type = FieldType.Date, pattern = "yyyy.MM.dd HH:mm:ss")
    @JSONField(format = "yyyy.MM.dd HH:mm:ss")
    private Date updateTime;


    /**
     * 终审法院代号
     */
    private List<String> lastInstanceCourt;


    /**
     * 文书类型
     */
    private List<String> documentAttr;

    /**
     * 案由
     */
    private List<String> category;


    /**
     * 参照级别
     */
    private List<String> caseGrade;

    public Pfnl(String caseFlag) {
        this.caseFlag = caseFlag;
    }


}
