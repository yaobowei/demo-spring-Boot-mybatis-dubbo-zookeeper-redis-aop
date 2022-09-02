package com.ybw.demo.mapper;

import com.ybw.demo.model.DemoModel;
import com.ybw.demo.model.DemoModelExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface DemoModelMapper {
    int countByExample(DemoModelExample example);

    int deleteByExample(DemoModelExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DemoModel record);

    int insertSelective(DemoModel record);

    List<DemoModel> selectByExample(DemoModelExample example);

    DemoModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DemoModel record, @Param("example") DemoModelExample example);

    int updateByExample(@Param("record") DemoModel record, @Param("example") DemoModelExample example);

    int updateByPrimaryKeySelective(DemoModel record);

    int updateByPrimaryKey(DemoModel record);
}