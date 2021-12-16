package com.xxzhi.test;

import com.xxzhi.dao.ViolationInfoDao;
import com.xxzhi.pojo.ViolationInfo;
import org.junit.Test;

import java.util.ArrayList;

public class test {
    @Test
    public void test1(){

        //System.out.println(ViolationInfoDao.insert(new ViolationInfo("xxxzhi",123,"0716")));
        ArrayList<ViolationInfo> violationInfoList= ViolationInfoDao.selectAll();
        if (violationInfoList==null) {
            System.out.println(0);
            return;
        }
        for(ViolationInfo v:violationInfoList) {
            System.out.println(v.toString());
        }

    }
}
