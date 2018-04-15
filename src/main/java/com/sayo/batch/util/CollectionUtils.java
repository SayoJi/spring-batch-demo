package com.sayo.batch.util;

import java.util.Collection;

/**
 * Created by Shuangyao
 * 19:18 2018/4/15
 */
public class CollectionUtils {

    public static boolean isNotEmpty(Collection collection) {
        if (collection != null && collection.size() > 0) {
            return true;
        }else {
            return false;
        }
    }
}
