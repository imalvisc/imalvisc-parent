package com.imalvisc.common.utils;

import cn.hutool.core.io.FileUtil;

import java.io.*;

public class FileUtils {

    public static void main(String[] args) throws IOException {

        File in = new File("E:\\学习视频\\【每特教育】\\【蚂蚁课堂】第四期-Java\\0094-(每特教育&每特学院&蚂蚁课堂)-4期-微服务技术-基于消息总线实现实时刷新分布式Config\\01.第一节-SpringCloud bus消息总线.ev4");
        File out = new File("E:\\aa.mp4");
        FileUtil.copy(in, out, true);

    }

}
