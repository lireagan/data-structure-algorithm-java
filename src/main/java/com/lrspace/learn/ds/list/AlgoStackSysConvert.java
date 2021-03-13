package com.lrspace.learn.ds.list;

/**
 * Author: llx
 * Description: 通过栈结构实现进制转换器
 * Date: 2021/03/14
 */
public class AlgoStackSysConvert {
    /**
     * @param srcNum 来源进制数字
     * @param srcSys 来源进制
     * @param tgtSys 目标进制
     * @return 目标进制数字
     */
    public static String convertByStack(String srcNum, int srcSys, int tgtSys) {
        MLinkStack<String> srcStack = new MLinkStack<>();
        for (int i = 0; i < srcNum.length(); i++) {
            srcStack.push(String.valueOf(srcNum.charAt(i)));
        }
        /* 转十进制 */
        int tenSysValue = 0;
        int size = srcStack.size();
        for (int i = 0; i < size; i++) {
            tenSysValue += Integer.parseInt(srcStack.pop()) * Math.pow(srcSys, i);
        }
        /* 转目标进制 */
        MLinkStack<String> tgtStack = new MLinkStack<>();
        if (tgtSys == 10 || tenSysValue == 0) {
            return String.valueOf(tenSysValue);
        }
        while (tenSysValue != 0) {
            tgtStack.push(String.valueOf(tenSysValue % tgtSys));
            tenSysValue /= tgtSys;
        }
        StringBuilder out = new StringBuilder();
        while (tgtStack.size() != 0) {
            out.append(tgtStack.pop());
        }
        return out.toString();
    }
}
