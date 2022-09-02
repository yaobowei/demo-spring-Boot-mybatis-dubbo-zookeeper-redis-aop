package com.ybw.demo.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ybw.demo.mapper.DemoModelMapper;
import com.ybw.demo.model.DemoModel;
import com.ybw.demo.model.DemoModelExample;
import com.ybw.demo.service.DemoService;
import com.ybw.demo.utils.model.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.awt.print.Pageable;
import java.util.List;

/**
 * Created by yao on 2018/1/17
 *
 * 服务接口测试
 *
 */

@Service(value = "DemoService")
public class DemoServiceImpl implements DemoService {

    //实例化mapper
    @Autowired
    private DemoModelMapper demoModelMapper;

    //测试
    @Override
    public String test(String str) {
        return str;
    }

    //写入
    @Override
    public Integer insert(DemoModel demoModel) {
        DemoModel model = demoModel;
        try {
            return demoModelMapper.insertSelective(model);
        }catch (Exception e){
            System.out.print(e.getMessage());
            return null;
        }
    }

    //分页查询
    @Override
    public PageInfo<DemoModel> select(DemoModel demoModel, PageModel pageModel) {
        //写入查询条件
        DemoModelExample example = new DemoModelExample();
        //example.createCriteria().andIdIsNotNull();
        if(!StringUtils.isEmpty(demoModel.getId())){
            example.createCriteria().andIdEqualTo(demoModel.getId());
        }
        if(!StringUtils.isEmpty(demoModel.getAge())){
            example.createCriteria().andAgeEqualTo(demoModel.getAge());
        }
        if(!StringUtils.isEmpty(demoModel.getName())){
            example.createCriteria().andNameEqualTo(demoModel.getName());
        }
        if(!StringUtils.isEmpty(demoModel.getSize())){
            example.createCriteria().andSizeEqualTo(demoModel.getSize());
        }
        //分页工具
        Page page = PageHelper.startPage(pageModel.getPageNum(),pageModel.getPageSize());
        List<DemoModel> demoModels = demoModelMapper.selectByExample(example);
        PageInfo<DemoModel> modelPageInfo = page.toPageInfo();
        modelPageInfo.setList(demoModels);
        return modelPageInfo;
    }
}
