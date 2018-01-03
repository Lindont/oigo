package com.aos.oigo.test;

import org.junit.Test;

import java.io.File;

/**
 * @Author : HuangHaoXin
 * @Description :
 * @Date : Create in 2018-01-03
 */
public class IoWriteFile {
    //遍历某目录下所有文件，文件夹，子文件和子文件夹
    public void traverseFolder(String path) {
        File file = new File(path);
        if (file.exists()) {
            File[] files = file.listFiles();
            if (files.length == 0) {
                System.out.println("------文件夹是空的------");
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
                    }
                }
            }
        } else {
            System.out.println("------文件不存在------");
        }
    }

    @Test
    public void test() {
        traverseFolder("G:\\学习资料");
    }
}
