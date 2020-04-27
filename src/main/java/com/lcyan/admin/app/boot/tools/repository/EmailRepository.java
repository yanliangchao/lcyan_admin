package com.lcyan.admin.app.boot.tools.repository;

import com.lcyan.admin.app.boot.tools.domain.EmailConfig;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Yan Liangchao
 * @version 1.0
 * @date 2020/4/20 16:35
 * @email liangchao.yan-ext@yanfeng.com
 */
public interface EmailRepository extends JpaRepository<EmailConfig,Long> {
}
