package com.lcyan.admin.app.service.api.deployments.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lcyan.admin.app.boot.restTemplate.method.HttpClient;
import com.lcyan.admin.app.boot.restultUtils.ResponseDTO;
import com.lcyan.admin.app.service.api.deployments.service.DeploymentsService;
import com.lcyan.admin.app.service.api.deployments.service.dto.DeploymentsDTO;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author Yan Liangchao
 * @version 1.0
 * @date 2020/5/9 9:20
 * @email liangchao.yan-ext@yanfeng.com
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class DeploymentsServiceImpl implements DeploymentsService {

    @Autowired
    private HttpClient httpClient;

    @Override
    public ResponseDTO getDeploymentsList(String namespaces) {
        String path = "";
        if("AllNameSpaces".equals(namespaces)){
            path= "/apis/apps/v1/deployments";
        } else {
            path= "/apis/apps/v1/namespaces/" + namespaces +"/deployments";
        }
        ResponseEntity<String> stringResponseEntity = httpClient.get(path, String.class);
        if(stringResponseEntity.getStatusCode() != HttpStatus.OK){
            return ResponseDTO.error().message("接口请求失败").code(stringResponseEntity.getStatusCodeValue());
        }
        List<DeploymentsDTO> dtoList = new ArrayList<>();
        JSONObject nodes = JSONObject.parseObject(stringResponseEntity.getBody());
        JSONArray items = nodes.getJSONArray("items");

        long id = 1L;
        for(Object item : items){
            DeploymentsDTO deploymentsDTO = new DeploymentsDTO();
            deploymentsDTO.setId(id);
            id++;
            JSONObject itemJson = (JSONObject) item;
            String name = itemJson.getJSONObject("metadata").getString("name");
            deploymentsDTO.setName(name);
            String selfLink = itemJson.getJSONObject("metadata").getString("selfLink");
            deploymentsDTO.setSelfLink(selfLink);
            String namespace = itemJson.getJSONObject("metadata").getString("namespace");
            deploymentsDTO.setNamespaces(namespace);
            Integer replicas = itemJson.getJSONObject("spec").getInteger("replicas");
            deploymentsDTO.setReplicas(replicas);
            if(replicas == 0){
                deploymentsDTO.setReadyReplicas(0);
                deploymentsDTO.setUpdatedReplicas(0);
                deploymentsDTO.setAvailableReplicas(0);
                deploymentsDTO.setUnavailableReplicas(0);
            } else {
                Integer readyReplicas = itemJson.getJSONObject("status").getInteger("readyReplicas");
                deploymentsDTO.setReadyReplicas(readyReplicas);
                Integer updatedReplicas = itemJson.getJSONObject("status").getInteger("updatedReplicas");
                deploymentsDTO.setUpdatedReplicas(updatedReplicas);
                Integer availableReplicas = itemJson.getJSONObject("status").getInteger("availableReplicas");
                deploymentsDTO.setAvailableReplicas(availableReplicas);
                if(readyReplicas != replicas){
                    Integer unavailableReplicas = itemJson.getJSONObject("status").getInteger("unavailableReplicas");
                    deploymentsDTO.setUnavailableReplicas(unavailableReplicas);
                } else {
                    deploymentsDTO.setUnavailableReplicas(0);
                }
            }
            JSONObject matchLabels = itemJson.getJSONObject("spec").getJSONObject("selector").getJSONObject("matchLabels");
            Set<String> selectorKey = matchLabels.keySet();
            String key = selectorKey.iterator().next();
            deploymentsDTO.setSelector(key + "=" + matchLabels.getString(key));
            JSONArray containers = itemJson.getJSONObject("spec").getJSONObject("template").getJSONObject("spec").getJSONArray("containers");
            if(ObjectUtils.isNotEmpty(containers)){
                JSONObject container = containers.getJSONObject(0);
                deploymentsDTO.setContainers(container.getString("name"));
                deploymentsDTO.setImages(container.getString("image"));
            }
            Date date = itemJson.getJSONObject("metadata").getDate("creationTimestamp");
            long dates = new Date().getTime() - date.getTime();
            long age = dates/(1000*60*60*24);
            deploymentsDTO.setAge(age);
            dtoList.add(deploymentsDTO);
        }
        return ResponseDTO.ok().message("获取全部的deployments").data("deployments",dtoList);
    }

    @Override
    public ResponseDTO createDeployments(String namespaces, String deployments) {

        if(StringUtils.isEmpty(namespaces)){
            namespaces = "default";
        }
        String path= "/apis/apps/v1/namespaces/" + namespaces + "/deployments";

        ResponseEntity<String> post = httpClient.post(path, deployments, String.class);
        if(post.getStatusCode() != HttpStatus.CREATED){
            return ResponseDTO.error().message("deployments创建失败").code(post.getStatusCodeValue());
        }
        return ResponseDTO.ok().message("deployments创建成功").code(post.getStatusCodeValue());
    }

    @Override
    public ResponseDTO deleteDeployments(String namespaces, String name) {
        String path = "/apis/apps/v1/namespaces/" + namespaces + "/deployments/" + name;

        ResponseEntity<String> delete = httpClient.delete(path, null, String.class);
        if(delete.getStatusCode() != HttpStatus.OK){
            return ResponseDTO.error().message("deployments删除失败").code(delete.getStatusCodeValue());
        }
        return ResponseDTO.ok().code(delete.getStatusCodeValue()).message("deployments删除成功");
    }
}
