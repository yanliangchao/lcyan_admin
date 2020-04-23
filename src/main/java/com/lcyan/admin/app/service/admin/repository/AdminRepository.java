package com.lcyan.admin.app.service.admin.repository;

import com.lcyan.admin.app.service.admin.domain.AdminModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author Yan Liangchao
 * @version 1.0
 * @date 2020/4/20 16:36
 * @email liangchao.yan-ext@yanfeng.com
 */
public interface AdminRepository extends JpaRepository<AdminModel,Long>, JpaSpecificationExecutor<AdminModel> {
}
