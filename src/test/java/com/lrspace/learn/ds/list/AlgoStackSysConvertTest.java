package com.lrspace.learn.ds.list;

import org.junit.Test;

import static org.junit.Assert.*;

public class AlgoStackSysConvertTest {

    @Test
    public void convertByStack() {
        String srcNum = "121001";
        int srcSys = 3;
        int tgtSys = 2;

        System.out.println("将数字" + srcNum + "从" + srcSys + "进制转为" + tgtSys + "进制：" + AlgoStackSysConvert.convertByStack(srcNum, srcSys, tgtSys));
    }
}