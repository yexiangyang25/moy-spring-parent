package org.moy.spring.common;

import java.util.Collection;
import java.util.Map;

/**
 * <p>Description: [校验空数据 工具类]</p>
 * Created on 2018/7/5
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
public class NullUtil {

    private NullUtil(){}
    
    /**
     * 对象是空，返回<tt>true<tt/>
     *
     * @param obj
     * @return 对象是空，返回<tt>true<tt/>
     */
    public static boolean objectIsNull(Object obj) {
        return null == obj;
    }

    /**
     * 对象不是空，返回<tt>true<tt/>
     *
     * @param obj
     * @return 对象不是空，返回<tt>true<tt/>
     */
    public static boolean objectIsNotNull(Object obj) {
        return !objectIsNull(obj);
    }


    /**
     * 集合是空或者个数小于零，返回<tt>true<tt/>
     *
     * @param collection
     * @return 集合是空或者个数小于零，返回<tt>true<tt/>
     */
    public static boolean collectionIsEmpty(Collection collection) {
        return null == collection || collection.isEmpty();
    }


    /**
     * 集合不是空并且个数大于零，返回<tt>true<tt/>
     *
     * @param collection
     * @return 集合不是空并且个数大于零，返回<tt>true<tt/>
     */
    public static boolean collectionIsNotEmpty(Collection collection) {
        return !collectionIsEmpty(collection);
    }

    /**
     * Map是空或者个数小于零，返回<tt>true<tt/>
     *
     * @param map
     * @return 集合不是空并且个数大于零，返回<tt>true<tt/>
     */
    public static boolean mapIsEmpty(Map map) {
        return null == map || map.isEmpty();
    }

    /**
     * map不是空并且个数大于零，返回<tt>true<tt/>
     *
     * @param map
     * @return map不是空并且个数大于零，返回<tt>true<tt/>
     */
    public static boolean mapIsNotEmpty(Map map) {
        return !mapIsEmpty(map);
    }


    /**
     * CharSequence是空或者长度小于零，返回<tt>true<tt/>
     *
     * @param charSequence
     * @return CharSequence是空或者长度小于零，返回<tt>true<tt/>
     */
    public static boolean charSequenceIsEmpty(CharSequence charSequence) {
        return null == charSequence || (charSequence.length() <= 0);
    }


    /**
     * CharSequence不是空并且长度大于零，返回<tt>true<tt/>
     *
     * @param charSequence
     * @return CharSequence不是空并且长度大于零，返回<tt>true<tt/>
     */
    public static boolean charSequenceIsNotEmpty(CharSequence charSequence) {
        return !charSequenceIsEmpty(charSequence);
    }
}
