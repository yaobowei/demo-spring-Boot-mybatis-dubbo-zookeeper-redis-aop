package com.ybw.demo.service;

import com.github.pagehelper.PageInfo;
import com.ybw.demo.model.DemoModel;
import com.ybw.demo.utils.model.PageModel;

/**
 * Created by yao on 2018/1/17
 *
 * 服务接口
 */
public interface DemoService {

    String test(String str);

    Integer insert(DemoModel demoModel);

    PageInfo<DemoModel> select(DemoModel demoModel, PageModel pageModel);
}
