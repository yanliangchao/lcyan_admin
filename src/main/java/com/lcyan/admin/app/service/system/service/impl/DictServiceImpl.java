package com.lcyan.admin.app.service.system.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.lcyan.admin.app.boot.common.utils.FileUtil;
import com.lcyan.admin.app.boot.common.utils.PageUtil;
import com.lcyan.admin.app.boot.common.utils.QueryHelp;
import com.lcyan.admin.app.boot.common.utils.ValidationUtil;
import com.lcyan.admin.app.service.system.domain.Dict;
import com.lcyan.admin.app.service.system.repository.DictRepository;
import com.lcyan.admin.app.service.system.service.DictService;
import com.lcyan.admin.app.service.system.service.dto.DictDetailDto;
import com.lcyan.admin.app.service.system.service.dto.DictDto;
import com.lcyan.admin.app.service.system.service.dto.DictQueryCriteria;
import com.lcyan.admin.app.service.system.service.mapper.DictMapper;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
* @author Zheng Jie
* @date 2019-04-10
*/
@Service
@CacheConfig(cacheNames = "dict")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class DictServiceImpl implements DictService {

    private final DictRepository dictRepository;

    private final DictMapper dictMapper;

    public DictServiceImpl(DictRepository dictRepository, DictMapper dictMapper) {
        this.dictRepository = dictRepository;
        this.dictMapper = dictMapper;
    }

    @Override
    @Cacheable
    public Map<String, Object> queryAll(DictQueryCriteria dict, Pageable pageable){
        Page<Dict> page = dictRepository.findAll((root, query, cb) -> QueryHelp.getPredicate(root, dict, cb), pageable);
        return PageUtil.toPage(page.map(dictMapper::toDto));
    }

    @Override
    public List<DictDto> queryAll(DictQueryCriteria dict) {
        List<Dict> list = dictRepository.findAll((root, query, cb) -> QueryHelp.getPredicate(root, dict, cb));
        return dictMapper.toDto(list);
    }

    @Override
    @Cacheable(key = "#p0")
    public DictDto findById(Long id) {
        Dict dict = dictRepository.findById(id).orElseGet(Dict::new);
        ValidationUtil.isNull(dict.getId(),"Dict","id",id);
        return dictMapper.toDto(dict);
    }

    @Override
    @CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public DictDto create(Dict resources) {
        return dictMapper.toDto(dictRepository.save(resources));
    }

    @Override
    @CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public void update(Dict resources) {
        Dict dict = dictRepository.findById(resources.getId()).orElseGet(Dict::new);
        ValidationUtil.isNull( dict.getId(),"Dict","id",resources.getId());
        resources.setId(dict.getId());
        dictRepository.save(resources);
    }

    @Override
    @CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public void delete(Set<Long> ids) {
        for (Long id : ids) {
            dictRepository.deleteById(id);
        }
    }

    @Override
    public void download(List<DictDto> dictDtos, HttpServletResponse response) throws IOException {
        List<Map<String, Object>> list = new ArrayList<>();
        for (DictDto dictDTO : dictDtos) {
            if(CollectionUtil.isNotEmpty(dictDTO.getDictDetails())){
                for (DictDetailDto dictDetail : dictDTO.getDictDetails()) {
                    Map<String,Object> map = new LinkedHashMap<>();
                    map.put("字典名称", dictDTO.getName());
                    map.put("字典描述", dictDTO.getRemark());
                    map.put("字典标签", dictDetail.getLabel());
                    map.put("字典值", dictDetail.getValue());
                    map.put("创建日期", dictDetail.getCreateTime());
                    list.add(map);
                }
            } else {
                Map<String,Object> map = new LinkedHashMap<>();
                map.put("字典名称", dictDTO.getName());
                map.put("字典描述", dictDTO.getRemark());
                map.put("字典标签", null);
                map.put("字典值", null);
                map.put("创建日期", dictDTO.getCreateTime());
                list.add(map);
            }
        }
        FileUtil.downloadExcel(list, response);
    }
}
