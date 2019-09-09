
import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <p>Description: [比较工具]</p>
 * Created on 2019/7/10
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
public class CompareMain {

    public static void main(String[] args) throws IOException {
        int fileSize = 2;
        String oneFilePath = "D:/compare/One.txt";
        String twoFilePath = "D:/compare/Two.txt";
        if (null != args && args.length >= fileSize) {
            oneFilePath = args[0];
            twoFilePath = args[1];
        }
        System.out.println(String.format("第1个参数文件路径: %s , 第2个参数文件路径: %s", oneFilePath, twoFilePath));

        Set<String> oneSet = getStringSet(oneFilePath);

        Set<String> twoSet = getStringSet(twoFilePath);

        printNotExist(oneSet, twoSet);
    }

    private static void printNotExist(Set<String> one, Set<String> two) {
        Set<String> notExist = new HashSet<>();
        for (String each : one) {
            if (!two.contains(each)) {
                notExist.add(each);
            }
        }
        System.out.println(String.format("第1个参数文件不存在于第2个参数文件个数: %s", String.valueOf(notExist.size())));
        System.out.println(String.format("第1个参数文件不存在于第2个参数文件的值: %s", Arrays.toString(notExist.toArray())));
    }

    private static Set<String> getStringSet(String fileName) throws IOException {
        Set<String> set = new HashSet<>();
        FileInputStream oneFile = new FileInputStream(fileName);
        try (BufferedReader oneBufferedReader = new BufferedReader(new InputStreamReader(oneFile))) {
            String oneStr = "";
            while ((oneStr = oneBufferedReader.readLine()) != null) {
                set.add(oneStr);
            }
        }
        return set;
    }
}
