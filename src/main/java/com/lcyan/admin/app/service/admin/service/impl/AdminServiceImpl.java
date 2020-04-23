package com.lcyan.admin.app.service.admin.service.impl;

import com.lcyan.admin.app.service.admin.domain.AdminModel;
import com.lcyan.admin.app.service.admin.repository.AdminRepository;
import com.lcyan.admin.app.service.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author Yan Liangchao
 * @version 1.0
 * @date 2020/4/20 16:35
 * @email liangchao.yan-ext@yanfeng.com
 */
@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public void saveAdmin(AdminModel adminModel) {
        adminRepository.save(adminModel);
    }
}
