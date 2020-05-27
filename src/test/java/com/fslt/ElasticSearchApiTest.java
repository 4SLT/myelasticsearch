package com.fslt;

import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.Requests;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

/**
 * @description: ElasticSearchApiTest
 * @date: 2020/5/27 15:12
 * @author: 林宗雄
 * @version: 1.0
 */
@SpringBootTest
public class ElasticSearchApiTest {

    @Autowired
    @Qualifier("restHighLevelClient")
    private RestHighLevelClient restHighLevelClient;

    /**
     * 创建索引
     *
     * @throws Exception
     */
    @Test
    void createIndex() throws Exception {
        //1、创建索引请求
        CreateIndexRequest request = new CreateIndexRequest("test_index2");
        //2、执行请求,获取响应
        CreateIndexResponse response = restHighLevelClient.indices().create(request, RequestOptions.DEFAULT);
    }

    /**
     * 查找索引
     *
     * @throws IOException
     */
    @Test
    void isExistIndex() throws IOException {
        GetIndexRequest request = new GetIndexRequest("test_index2");
        Boolean result = restHighLevelClient.indices().exists(request, RequestOptions.DEFAULT);
        System.out.println(result);
    }

    /**
     * 删除索引
     *
     * @throws IOException
     */
    @Test
    void deleteIndex() throws IOException {
        DeleteIndexRequest request = new DeleteIndexRequest("test_index2");
        AcknowledgedResponse response = restHighLevelClient.indices().delete(request, RequestOptions.DEFAULT);
    }

}
