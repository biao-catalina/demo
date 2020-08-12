package com.example.demo;

import com.example.dao.DemoDao;
import com.example.entity.Demo;
import com.example.entity.Pfnl;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.BucketOrder;
import org.elasticsearch.search.aggregations.bucket.terms.ParsedStringTerms;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.elasticsearch.index.query.QueryBuilders.matchAllQuery;

@SpringBootTest
public class DemoTest {

    @Autowired
    private DemoDao demoDao;

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Test
    public void agg() {
        TermsAggregationBuilder aggregationBuilder = AggregationBuilders.terms("normal").field("normal").order(
                BucketOrder.count(false)
        )
                .size(10);

        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        NativeSearchQuery searchQuery = nativeSearchQueryBuilder.addAggregation(aggregationBuilder)
                .withQuery(matchAllQuery())
                .withPageable(PageRequest.of(0, 1))
                .build();

        AggregatedPage<Pfnl> pfnls = elasticsearchRestTemplate.queryForPage(searchQuery,
                Pfnl.class);

        Aggregations aggregations = pfnls.getAggregations();

        ParsedStringTerms normal = aggregations.get("normal");

        System.out.println(1);
    }

    @Test
    public void test() {
        Demo demo = new Demo();
        demo.setDate(LocalDate.now());
        demo.setDateTime(LocalDateTime.now());
        demo.setUsername("hello");
        demo.setPassword("lsd");
/*        List<String> list = new ArrayList<>();
        list.add("app;le");
        list.add("app;ddf");
        demo.setLoveThings(list);*/
        long count = demoDao.count();
        System.out.println(count);
        demoDao.save(demo);
    }
}
