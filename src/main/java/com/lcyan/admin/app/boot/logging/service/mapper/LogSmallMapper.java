package com.lcyan.admin.app.boot.logging.service.mapper;


import com.lcyan.admin.app.boot.common.base.BaseMapper;
import com.lcyan.admin.app.boot.logging.domain.Log;
import com.lcyan.admin.app.boot.logging.service.dto.LogSmallDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author Zheng Jie
 * @date 2019-5-22
 */
@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LogSmallMapper extends BaseMapper<LogSmallDTO, Log> {

}
