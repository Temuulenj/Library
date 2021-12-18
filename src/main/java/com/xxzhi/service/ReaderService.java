package com.xxzhi.service;

import com.alibaba.fastjson.JSONObject;
import com.xxzhi.dao.ReaderDao;
import com.xxzhi.pojo.Reader;

/**
 * @author temuulen
 */
public class ReaderService {
    public String signIn(String readerId, String password){
        Reader reader= ReaderDao.selectOne(readerId);
        if (reader.getPassword()==password){
            reader.setPassword(null);
            return JSONObject.toJSONString(reader);
        }else {
            return null;
        }
    }
    public String signUp(Reader reader){
        if (ReaderDao.selectOne(reader.getReaderId())!=null){
            return "msg: '用户名已存在'";
        }else {
            if (ReaderDao.insert(reader)){
                return "msg: 'success'";
            }
            return "msg: 'error'";
        }
    }
}
