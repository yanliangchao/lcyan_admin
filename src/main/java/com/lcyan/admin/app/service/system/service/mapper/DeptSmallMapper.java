package com.lcyan.admin.app.service.system.service.mapper;


import com.lcyan.admin.app.boot.common.base.BaseMapper;
import com.lcyan.admin.app.service.system.domain.Dept;
import com.lcyan.admin.app.service.system.service.dto.DeptSmallDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author Zheng Jie
* @date 2019-03-25
*/
@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DeptSmallMapper extends BaseMapper<DeptSmallDto, Dept> {

}
