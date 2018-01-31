package com.ybw.demo.controller;

import com.ybw.demo.model.DemoModel;
import com.ybw.demo.service.DemoService;
import com.ybw.demo.utils.ResultUtil;
import com.ybw.demo.utils.model.PageModel;
import com.ybw.demo.utils.model.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by yao on 2018/1/17
 * controller demo
 */

@RestController
public class DemoController {


    private Logger logger = LoggerFactory.getLogger(DemoController.class);

    @Autowired
    private DemoService demoService;

    /**查询测试*/
    @GetMapping(value = "/test")
    public String Test(@RequestParam("str") String str){
        return demoService.test(str);
    }

    /**写入测试*/
    @PostMapping(value = "/demo")
    public Integer insert(@Valid DemoModel demoModel, BindingResult bindingResult){
        if(bindingResult.hasErrors()){//参数验证
            logger.info(bindingResult.getFieldError().getField());
            return 0;
        }
        DemoModel model = demoModel;
        return demoService.insert(model);
    }

    /**分页查询测试*/
    @GetMapping(value = "/select")
    public Result<DemoModel> select(@Valid DemoModel demoModel, @Valid PageModel pageModel,BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultUtil.error();
        }

        return ResultUtil.success(demoService.select(demoModel,pageModel));
    }

}
