package org.moy.spring.common;


import java.util.*;

/**
 * <p>Description: [List array转化 帮助类]</p>
 * Created on 2019/5/8
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
public class ListArrayHelper {
    private ListArrayHelper() {
    }

    public static String[] collectionToArray(Collection<String> stringList) {
        if (null == stringList) {
            return null;
        }
        String[] strings = new String[stringList.size()];

        return stringList.toArray(strings);
    }

    public static List<String> arrayToList(String[] array) {
        if (null == array) {
            return null;
        }
        List<String> arrayList = new ArrayList<>(array.length);
        Collections.addAll(arrayList, array);
        return arrayList;
    }

    public static Set<String> arrayToSet(String[] array) {
        if (null == array) {
            return null;
        }
        Set<String> arrayList = new HashSet<>(array.length);
        Collections.addAll(arrayList, array);
        return arrayList;
    }
}
