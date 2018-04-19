package com.dodo.permission_web.service;

import com.dodo.permission_web.common.RequestHolder;
import com.dodo.permission_web.dao.SysDeptMapper;
import com.dodo.permission_web.dao.SysUserMapper;
import com.dodo.permission_web.exception.ParamException;
import com.dodo.permission_web.model.SysDept;
import com.dodo.permission_web.param.DeptParam;
import com.dodo.permission_web.utils.BeanValidator;
import com.dodo.permission_web.utils.IpUtil;
import com.dodo.permission_web.utils.LevelUtil;
import com.google.common.base.Preconditions;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class SysDeptService {

    @Resource
    private SysDeptMapper sysDeptMapper;
    @Resource
    private SysUserMapper sysUserMapper;



}
