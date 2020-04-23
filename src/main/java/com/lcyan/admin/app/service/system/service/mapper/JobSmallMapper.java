package com.lcyan.admin.app.service.system.service.mapper;

import com.lcyan.admin.app.boot.common.base.BaseMapper;
import com.lcyan.admin.app.service.system.domain.Job;
import com.lcyan.admin.app.service.system.service.dto.JobSmallDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author Zheng Jie
* @date 2019-03-29
*/
@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface JobSmallMapper extends BaseMapper<JobSmallDto, Job> {

}
