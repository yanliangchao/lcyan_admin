package com.lcyan.admin.app.service.api.node.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lcyan.admin.app.boot.restTemplate.method.HttpClient;
import com.lcyan.admin.app.boot.restultUtils.ResponseDTO;
import com.lcyan.admin.app.service.api.node.service.NodeService;
import com.lcyan.admin.app.service.api.node.service.dto.NodeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Yan Liangchao
 * @version 1.0
 * @date 2020/4/30 9:00
 * @email liangchao.yan-ext@yanfeng.com
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class NodeServiceImpl implements NodeService {

    @Autowired
    private HttpClient httpClient;

    @Override
    public ResponseDTO getNode() {
        ResponseEntity<String> stringResponseEntity = httpClient.get("/api/v1/nodes", String.class);
        if(stringResponseEntity.getStatusCode() != HttpStatus.OK){
            return ResponseDTO.error().message("接口请求失败").code(stringResponseEntity.getStatusCodeValue());
        }
        List<NodeDTO> nodeList = new ArrayList<NodeDTO>();
        //System.out.println(stringResponseEntity.getStatusCode());
        //System.out.println(stringResponseEntity.getStatusCodeValue());
        //System.out.println(stringResponseEntity.getHeaders());
        //System.out.println(stringResponseEntity.getBody());
        JSONObject nodes = JSONObject.parseObject(stringResponseEntity.getBody());
        JSONArray items = nodes.getJSONArray("items");
        //System.out.println(items);
        long id = 1L;
        for(Object item : items){
            NodeDTO nodeDTO = new NodeDTO();
            nodeDTO.setId(id);
            id++;
            JSONObject itemJson = (JSONObject) item;
            String name = itemJson.getJSONObject("metadata").getString("name");
            nodeDTO.setName(name);
            String selfLink = itemJson.getJSONObject("metadata").getString("selfLink");
            nodeDTO.setSelfLink(selfLink);
            JSONArray conditions = itemJson.getJSONObject("status").getJSONArray("conditions");
            for(Object condition : conditions){
                JSONObject conditionJson = (JSONObject) condition;
                String type = conditionJson.getString("type");
                //获取节点状态
                if("Ready".equals(type)){
                    String status = conditionJson.getString("status");
                    if(Boolean.parseBoolean(status)){
                        status = "Ready";
                    } else {
                        status = "NotReady";
                    }
                    nodeDTO.setStatus(status);
                }
            }
            JSONObject labels = itemJson.getJSONObject("metadata").getJSONObject("labels");
            StringBuffer roles = new StringBuffer();
            for (String label: labels.keySet()) {
                if(label.contains("node-role")){
                    String role = label.split("/")[1];
                    roles.append(role).append(",");
                }
            }
            if (roles.length() > 0) {
                roles.deleteCharAt(roles.length()-1);
                //System.out.println(roles);
            }
            nodeDTO.setRoles(roles.toString());
            Date date = itemJson.getJSONObject("metadata").getDate("creationTimestamp");
            long dates = new Date().getTime() - date.getTime();
            long age = dates/(1000*60*60*24);
            nodeDTO.setAge(age);
            String podCIDR = itemJson.getJSONObject("spec").getString("podCIDR");
            nodeDTO.setPodCidr(podCIDR);
            String cpu = itemJson.getJSONObject("status").getJSONObject("capacity").getString("cpu");
            nodeDTO.setCpu(cpu);
            String memory = itemJson.getJSONObject("status").getJSONObject("capacity").getString("memory");
            nodeDTO.setMemory(memory);
            JSONArray addresses = itemJson.getJSONObject("status").getJSONArray("addresses");
            for (Object address: addresses) {
                JSONObject addressJson = (JSONObject) address;
                if("InternalIP".equals(addressJson.getString("type"))){
                    nodeDTO.setInternalIp(addressJson.getString("address"));
                } else if("Hostname".equals(addressJson.getString("type"))){
                    nodeDTO.setHostname(addressJson.getString("address"));
                }
            }
            JSONObject nodeInfo = itemJson.getJSONObject("status").getJSONObject("nodeInfo");
            for(Map.Entry entry : nodeInfo.entrySet()){
                if("osImage".equals(entry.getKey())){
                    nodeDTO.setOsImage(entry.getValue().toString());
                }else if("kernelVersion".equals(entry.getKey())){
                    nodeDTO.setKernelVersion(entry.getValue().toString());
                } else if("containerRuntimeVersion".equals(entry.getKey())){
                    nodeDTO.setContainerRuntimeVersion(entry.getValue().toString());
                } else if("kubeletVersion".equals(entry.getKey())) {
                    nodeDTO.setVersion(entry.getValue().toString());
                }
            }
            nodeList.add(nodeDTO);
        }
        //System.out.println(item);
        return ResponseDTO.ok().message("获取全部node").data("nodes",nodeList);
    }
}
