package com.lcyan.admin.app.service.system.service.mapper;


import com.lcyan.admin.app.boot.common.base.BaseMapper;
import com.lcyan.admin.app.service.system.domain.Job;
import com.lcyan.admin.app.service.system.service.dto.JobDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

/**
* @author Zheng Jie
* @date 2019-03-29
*/
@Mapper(componentModel = "spring",uses = {DeptMapper.class},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface JobMapper extends BaseMapper<JobDto, Job> {

    /**
     * 转Dto
     * @param job 原始数据
     * @param deptSuperiorName /
     * @return /
     */
    @Mapping(source = "deptSuperiorName", target = "deptSuperiorName")
    JobDto toDto(Job job, String deptSuperiorName);
}
