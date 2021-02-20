package com.es.config;

import org.apache.http.HttpHost;
import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.Strings;
import org.elasticsearch.index.VersionType;
import org.elasticsearch.search.fetch.subphase.FetchSourceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author guozhenhua
 * @date 2021/02/19
 */
@Component
public class RestHighClient {

    @Autowired
    RestHighLevelClient client;

   public void getIndex(String index,String id ) throws Exception{
       GetRequest getRequest = new GetRequest( index,id);
       ActionListener<GetResponse> listener = new ActionListener<GetResponse>() {
           @Override
           public void onResponse(GetResponse getResponse) {
               String index = getResponse.getIndex();
               String id = getResponse.getId();
               if (getResponse.isExists()) {
                   long version = getResponse.getVersion();
                   String sourceAsString = getResponse.getSourceAsString();
                   Map<String, Object> sourceAsMap = getResponse.getSourceAsMap();
                   byte[] sourceAsBytes = getResponse.getSourceAsBytes();
               } else {

               }
           }
           @Override
           public void onFailure(Exception e) {
               System.out.println(e.getMessage());
           }
       };
       client.getAsync(getRequest, RequestOptions.DEFAULT, listener);
   }
}
