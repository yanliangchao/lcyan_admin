package com.lcyan.admin.app.service.system.service.mapper;


import com.lcyan.admin.app.boot.common.base.BaseMapper;
import com.lcyan.admin.app.service.system.domain.Menu;
import com.lcyan.admin.app.service.system.service.dto.MenuDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author Zheng Jie
 * @date 2018-12-17
 */
@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MenuMapper extends BaseMapper<MenuDto, Menu> {

}
