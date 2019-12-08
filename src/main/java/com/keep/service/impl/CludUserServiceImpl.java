package com.keep.service.impl;

import com.keep.domain.ClubUser;
import com.keep.mapper.CuldUserMapper;
import com.keep.service.CludUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p> 用户服务 </p>
 *
 * @author zhangnan
 * @date 2019-12-08 15:35
 */
@Service
public class CludUserServiceImpl implements CludUserService {

    @Autowired
    private CuldUserMapper mapper;


    @Override
    public Long createUser(ClubUser user) {
        Long userId = mapper.getUserCountByDingId(user.getDingId());
        if (userId != null){
            return userId;
        }

        mapper.saveUser(user);
        return user.getUserId();
    }
}
