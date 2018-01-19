package com.aos.oigo.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

/**
 * @Author : HuangHaoXin
 * @Description : 递归遍历某目录下所有文件，文件夹，子文件和子文件夹，重命名文件，并删除指定文件
 * @Date : Create in 2018-01-03
 */
public class IoWriteFile {
    private static final Logger logger = LoggerFactory.getLogger(IoWriteFile.class);
    public void traverseFolder(String path) {
        File file = new File(path);
        if (file.exists()) {
            File[] files = file.listFiles();
            if (files.length == 0) {
                System.out.println("文件夹是空的");
                return;
            } else {
                for (File f : files) {
                    if (f.isDirectory()) {
                        System.out.println("文件夹:" + f.getAbsolutePath());
                        if (f.getAbsolutePath().indexOf("[www.17zixueba.com]") != -1) {
                            f.renameTo(new File(f.getAbsolutePath().replace("[www.17zixueba.com]", "")));
                        }
                        traverseFolder(f.getAbsolutePath());
                    } else {
                        System.out.println("文件:" + f.getAbsolutePath());
                        if (f.getAbsolutePath().indexOf("[www.17zixueba.com]") != -1) {
                            f.renameTo(new File(f.getAbsolutePath().replace("[www.17zixueba.com]", "")));
                        }

                        if ("一起自学吧 - IT视频教程分享社区.url".equals(f.getName()) || "学习路线.png".equals(f.getName()) ||
                                "课前必读.txt".equals(f.getName()) || "关注微信获赠最新免费课程.jpg".equals(f.getName()) ||
                                "关注微信免费下载最新课程.jpg".equals(f.getName())) {
                            logger.info(f.getName());
                            f.delete();
                        }
                    }
                }
            }
        } else {
            System.out.println("文件不存在");
        }
    }



    @Test
    public void test() {
        traverseFolder("D:\\BaiduNetdiskDownload\\2017年最新大数据Spark从入门到精通全套视频教程附配套资料");
    }
}
