package com.xxzhi.service;

import com.alibaba.fastjson.JSONObject;
import com.xxzhi.dao.ReaderDao;
import com.xxzhi.pojo.Reader;

/**
 * @author temuulen
 */
public class ReaderService {
    /**
     *
     * @param readerId 用户输入的ID
     * @param password 用户输入的密码
     * @return 成功->返回该用户信息，失败->返回空
     */
    public Reader signIn(String readerId, String password){
        Reader reader= ReaderDao.selectOne(readerId);
        if (reader==null){
            return null;
        }
        if (reader.getPassword().equals(password)){
            reader.setPassword(null);
            return reader;
        }else {
            return null;
        }
    }

    /**
     *
     * @param reader
     * @return
     */
    public String signUp(Reader reader){
        if (ReaderDao.selectOne(reader.getReaderId())!=null){
            return "This username is already registered";
        }else {
            if (ReaderDao.insert(reader)){
                return "success";
            }
            return "error";
        }
    }
}