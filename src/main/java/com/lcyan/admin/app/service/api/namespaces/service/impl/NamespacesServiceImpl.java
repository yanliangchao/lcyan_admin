package com.lcyan.admin.app.service.api.namespaces.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lcyan.admin.app.boot.restTemplate.method.HttpClient;
import com.lcyan.admin.app.boot.restultUtils.ResponseDTO;
import com.lcyan.admin.app.service.api.namespaces.service.NamespacesService;
import com.lcyan.admin.app.service.api.namespaces.service.dto.NamespacesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yan Liangchao
 * @version 1.0
 * @date 2020/5/7 14:08
 * @email liangchao.yan-ext@yanfeng.com
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class NamespacesServiceImpl implements NamespacesService {

    @Autowired
    private HttpClient httpClient;

    private String path = "/api/v1/namespaces";
    @Override
    public ResponseDTO getNamespacesList() {

        ResponseEntity<String> stringResponseEntity = httpClient.get(path, String.class);

        if(stringResponseEntity.getStatusCode() != HttpStatus.OK){
            return ResponseDTO.error().message("接口请求失败").code(stringResponseEntity.getStatusCodeValue());
        }
        List<NamespacesDTO> namespacesDTOList = new ArrayList<>();
        JSONObject nodes = JSONObject.parseObject(stringResponseEntity.getBody());
        JSONArray items = nodes.getJSONArray("items");

        long id = 1L;
        for(Object item : items) {
            NamespacesDTO namespacesDTO = new NamespacesDTO();
            namespacesDTO.setId(id);
            id++;
            JSONObject itemJson = (JSONObject) item;
            String name = itemJson.getJSONObject("metadata").getString("name");
            namespacesDTO.setName(name);
            String status = itemJson.getJSONObject("status").getString("phase");
            namespacesDTO.setStatus(status);
            namespacesDTOList.add(namespacesDTO);
        }
        return ResponseDTO.ok().message("获取全部的namespaces").data("namespaces",namespacesDTOList);
    }

    @Override
    public ResponseDTO createNamespaces(String namespaces) {
        String yaml = "apiVersion: v1\n" +
                "kind: Namespace\n" +
                "metadata:\n" +
                "    name: " + namespaces + "\n" +
                "    labels: \n" +
                "        name: " + namespaces;
        //System.out.println(yaml);
        ResponseEntity<String> post = httpClient.post(path, yaml, String.class);
        if(post.getStatusCode() != HttpStatus.CREATED){
            return ResponseDTO.error().message("namespaces创建失败").code(post.getStatusCodeValue());
        }
        String body = post.getBody();

        return ResponseDTO.ok().code(post.getStatusCodeValue()).message("namespaces创建成功");
    }

    @Override
    public ResponseDTO deleteNamespaces(String namespaces) {
        ResponseEntity<String> delete = httpClient.delete(path + "/" + namespaces, null, String.class);
        if(delete.getStatusCode() != HttpStatus.OK){
            return ResponseDTO.error().message("namespaces删除失败").code(delete.getStatusCodeValue());
        }
        return ResponseDTO.ok().code(delete.getStatusCodeValue()).message("namespaces删除成功");
    }
}
