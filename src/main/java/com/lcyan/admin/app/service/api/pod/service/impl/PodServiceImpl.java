package com.lcyan.admin.app.service.api.pod.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lcyan.admin.app.boot.restTemplate.method.HttpClient;
import com.lcyan.admin.app.boot.restultUtils.ResponseDTO;
import com.lcyan.admin.app.service.api.pod.service.PodService;
import com.lcyan.admin.app.service.api.pod.service.dto.PodDTO;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Yan Liangchao
 * @version 1.0
 * @date 2020/4/30 16:12
 * @email liangchao.yan-ext@yanfeng.com
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class PodServiceImpl implements PodService {

    @Autowired
    private HttpClient httpClient;

    @Override
    public ResponseDTO getPodList(String namespaces) {

        String path = "";
        if("AllNameSpaces".equals(namespaces)){
            path= "/api/v1/pods";
        } else {
            path= "/api/v1/namespaces/" + namespaces +"/pods";
        }

        ResponseEntity<String> stringResponseEntity = httpClient.get(path, String.class);
        if(stringResponseEntity.getStatusCode() != HttpStatus.OK){
            return ResponseDTO.error().message("接口请求失败").code(stringResponseEntity.getStatusCodeValue());
        }
        List<PodDTO> podList = new ArrayList<PodDTO>();
        //System.out.println(stringResponseEntity.getStatusCode());
        //System.out.println(stringResponseEntity.getStatusCodeValue());
        //System.out.println(stringResponseEntity.getHeaders());
        //System.out.println(stringResponseEntity.getBody());
        JSONObject nodes = JSONObject.parseObject(stringResponseEntity.getBody());
        JSONArray items = nodes.getJSONArray("items");
        // System.out.println(items);
        long id = 1L;
        for(Object item : items){
            PodDTO podDTO = new PodDTO();
            podDTO.setId(id);
            id++;
            JSONObject itemJson = (JSONObject) item;
            String name = itemJson.getJSONObject("metadata").getString("name");
            podDTO.setName(name);
            String selfLink = itemJson.getJSONObject("metadata").getString("selfLink");
            podDTO.setSelfLink(selfLink);
            String namespace = itemJson.getJSONObject("metadata").getString("namespace");
            podDTO.setNamespaces(namespace);
            String node = itemJson.getJSONObject("spec").getString("nodeName");
            podDTO.setNode(node);
            String status = itemJson.getJSONObject("status").getString("phase");
            podDTO.setStatus(status);
            JSONArray containerStatuses = itemJson.getJSONObject("status").getJSONArray("containerStatuses");
            if(ObjectUtils.isNotEmpty(containerStatuses)){
                String restarts = containerStatuses.getJSONObject(0).getString("restartCount");
                podDTO.setRestarts(restarts);
                String image = containerStatuses.getJSONObject(0).getString("image");
                podDTO.setImages(image);
            }
            Date date = itemJson.getJSONObject("metadata").getDate("creationTimestamp");
            long dates = new Date().getTime() - date.getTime();
            long age = dates/(1000*60*60*24);
            podDTO.setAge(age);
            podList.add(podDTO);
        }
        return ResponseDTO.ok().message("获取指定命名空间里的pod").data("pods",podList);
    }

    @Override
    public ResponseDTO deletePod(String namespaces, String pod) {
        String path = "/api/v1/namespaces/" + namespaces + "/pods/" + pod;

        ResponseEntity<String> delete = httpClient.delete(path, null, String.class);
        if(delete.getStatusCode() != HttpStatus.OK){
            return ResponseDTO.error().message("pod删除失败").code(delete.getStatusCodeValue());
        }
        return ResponseDTO.ok().code(delete.getStatusCodeValue()).message("pod删除成功");
    }
}
