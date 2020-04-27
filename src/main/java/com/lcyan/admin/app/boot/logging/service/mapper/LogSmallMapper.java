package com.lcyan.admin.app.boot.logging.service.mapper;


import com.lcyan.admin.app.boot.common.base.BaseMapper;
import com.lcyan.admin.app.boot.logging.domain.Log;
import com.lcyan.admin.app.boot.logging.service.dto.LogSmallDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author Yan Liangchao
 * @version 1.0
 * @date 2020/4/20 10:53
 * @email liangchao.yan-ext@yanfeng.com
 */
@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LogSmallMapper extends BaseMapper<LogSmallDTO, Log> {

}
