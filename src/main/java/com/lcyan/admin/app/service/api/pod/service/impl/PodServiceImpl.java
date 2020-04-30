package com.lcyan.admin.app.service.api.pod.service.impl;

import com.lcyan.admin.app.boot.restTemplate.method.HttpClient;
import com.lcyan.admin.app.boot.restultUtils.ResponseDTO;
import com.lcyan.admin.app.service.api.pod.service.PodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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


        return null;
    }
}
