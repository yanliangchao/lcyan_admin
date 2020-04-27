package com.lcyan.admin.app.boot.security.service;


import com.lcyan.admin.app.boot.common.exception.BadRequestException;
import com.lcyan.admin.app.boot.security.service.dto.JwtUserDto;
import com.lcyan.admin.app.service.system.service.RoleService;
import com.lcyan.admin.app.service.system.service.UserService;
import com.lcyan.admin.app.service.system.service.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Yan Liangchao
 * @version 1.0
 * @date 2020/4/20 16:35
 * @email liangchao.yan-ext@yanfeng.com
 */
@Service("userDetailsService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @Override
    public JwtUserDto loadUserByUsername(String username){
        UserDto user = userService.findByName(username);
        if (user == null) {
            throw new BadRequestException("账号不存在");
        } else {
            if (!user.getEnabled()) {
                throw new BadRequestException("账号未激活");
            }
            return new JwtUserDto(
                    user,
                    roleService.mapToGrantedAuthorities(user)
            );
        }
    }
}
