package com.lcyan.admin.app.service.system.service.mapper;

import com.lcyan.admin.app.boot.common.base.BaseMapper;
import com.lcyan.admin.app.service.system.domain.Role;
import com.lcyan.admin.app.service.system.service.dto.RoleSmallDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author Zheng Jie
 * @date 2019-5-23
 */
@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoleSmallMapper extends BaseMapper<RoleSmallDto, Role> {

}
