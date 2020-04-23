package com.lcyan.admin.app.service.tools.repository;

import com.lcyan.admin.app.service.tools.domain.EmailConfig;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Zheng Jie
 * @date 2018-12-26
 */
public interface EmailRepository extends JpaRepository<EmailConfig,Long> {
}
