package com.lcyan.admin.app.boot.tools.repository;

import com.lcyan.admin.app.boot.tools.domain.VerificationCode;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Yan Liangchao
 * @version 1.0
 * @date 2020/4/20 16:35
 * @email liangchao.yan-ext@yanfeng.com
 */
public interface VerificationCodeRepository extends JpaRepository<VerificationCode, Long> {

    /**
     * 获取有效的验证码
     * @param scenes 业务场景，如重置密码，重置邮箱等等
     * @param type 类型
     * @param value 值
     * @return VerificationCode
     */
    VerificationCode findByScenesAndTypeAndValueAndStatusIsTrue(String scenes, String type, String value);
}
