package com.lagou.sqlSession;

import com.lagou.pojo.Configuration;
import com.lagou.pojo.MappedStatement;

import java.util.List;

public interface Executor {

    //查询
    public <E> List<E> query(Configuration configuration, MappedStatement mappedStatement, Object... params) throws Exception;

    //增删改
    public int operation(Configuration configuration, MappedStatement mappedStatement, Object... params) throws Exception;

}
