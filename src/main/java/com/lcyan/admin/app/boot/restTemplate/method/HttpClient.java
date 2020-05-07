package com.lcyan.admin.app.boot.restTemplate.method;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;


/**
 * @author Yan Liangchao
 * @version 1.0
 * @date 2020/4/27 16:52
 * @email lian.yan-ext@yanfeng.com
 */
@Slf4j
@Component
public class HttpClient {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${kubernetes.address}")
    private String address;

    @Value("${kubernetes.token}")
    private String token;

    public <T> ResponseEntity<T> get(String path, Class<T> responseType){
        // 3-exchange()
        String uri = address + path;
        log.info("请求地址: {}", uri);
        RequestEntity requestEntity = null;
        try {
            requestEntity = RequestEntity.get(new URI(uri))
                    //.header("Authorization", "Basic " + token)
                    .build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return this.restTemplate.exchange(requestEntity, responseType);
    }

    public <T> ResponseEntity<T> post(String path, String requestBody, Class<T> responseType){
        // 3-exchange()
        RequestEntity requestEntity = null;
        String uri = address + path;
        log.info("请求地址: {}", uri);
        try {
            requestEntity = RequestEntity.post(new URI(uri))
                    //.header("Authorization", "Basic " + token)
                    .header("Content-Type", "application/yaml")
                    .body(requestBody);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return this.restTemplate.exchange(requestEntity, responseType);
    }

    public <T> ResponseEntity<T> put(String path, String requestBody, Class<T> responseType){
        // 3-exchange()
        RequestEntity requestEntity = null;
        String uri = address + path;
        log.info("请求地址: {}", uri);
        try {
            requestEntity = RequestEntity.put(new URI(uri))
                    //.header("Authorization", "Basic " + token)
                    .header("Content-Type", "application/yaml")
                    .body(requestBody);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return this.restTemplate.exchange(requestEntity, responseType);
    }

    public <T> ResponseEntity<T> patch(String path, String requestBody, Class<T> responseType){
        // 3-exchange()
        RequestEntity requestEntity = null;
        String uri = address + path;
        log.info("请求地址: {}", uri);
        try {
            requestEntity = RequestEntity.patch(new URI(uri))
                    //.header("Authorization", "Basic " + token)
                    .header("Content-Type", "application/yaml")
                    .body(requestBody);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return this.restTemplate.exchange(requestEntity, responseType);
    }

    public <T> ResponseEntity<T> delete(String path, String requestBody, Class<T> responseType){
        // 3-exchange()
        RequestEntity requestEntity = null;
        String uri = address + path;
        log.info("请求地址: {}", uri);
        try {
            requestEntity = RequestEntity.delete(new URI(uri))
                    //.header("Authorization", "Basic " + token)
                    .header("Content-Type", "application/yaml")
                    .build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return this.restTemplate.exchange(requestEntity, responseType);
    }
}
