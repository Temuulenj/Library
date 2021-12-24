package com.xxzhi.service;

import com.xxzhi.dao.SignInfoDao;
import com.xxzhi.pojo.SignInfo;

/**
 * @author temuulen
 */
public class SignService {
    /**
     * 签到
     * @param signInfo 签到数据
     * @return 是否成功
     */
    public boolean sign(SignInfo signInfo){
        return SignInfoDao.insert(signInfo);
    }

//    /**
//     * 签退
//     */
//    public boolean signOut(SignInfo signInfo){
//        return SignInfoDao.insert(signInfo);
//    }
}
