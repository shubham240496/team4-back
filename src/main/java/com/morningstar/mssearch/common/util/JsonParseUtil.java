package com.morningstar.mssearch.common.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class JsonParseUtil {

    /**
     * json转对象
     *
     * @param object
     * @param T
     * @return
     */
    @SuppressWarnings("unchecked")
    public static Object JsonToBean(Object object, Class T) {
//		TimeZone.setDefault(TimeZone.getTimeZone("GMT+0"));
        return JSON.parseObject(object.toString(), T);
    }

    /**
     * json转list
     *
     * @param object
     * @param T
     * @return
     */
    @SuppressWarnings("unchecked")
    public static Object JsonToArrayList(Object object, Class T) {
//		TimeZone.setDefault(TimeZone.getTimeZone("GMT+0"));
        return JSON.parseArray(object.toString(), T);
    }

    /**
     * 对象转json字符串
     *
     * @param object
     * @return
     */
    public static String ObjectToJSONString(Object object) {
        //SerializerFeature 序列化属性，默认不输出null值，会过滤掉值为null的key,这里设置是为了不过滤
        /**
         * QuoteFieldNames———-输出key时是否使用双引号,默认为true
         * WriteMapNullValue——–是否输出值为null的字段,默认为false
         * WriteNullNumberAsZero—-数值字段如果为null,输出为0,而非null
         * WriteNullListAsEmpty—–List字段如果为null,输出为[],而非null
         * WriteNullStringAsEmpty—字符类型字段如果为null,输出为”“,而非null
         * WriteNullBooleanAsFalse–Boolean字段如果为null,输出为false,而非null
         */
//		TimeZone.setDefault(TimeZone.getTimeZone("GMT+0"));
        return JSON.toJSONString(object, SerializerFeature.WriteMapNullValue);
    }

    @SuppressWarnings("unchecked")
    public static Object JSONStringToBean(String jsonString, Class T) {
//		TimeZone.setDefault(TimeZone.getTimeZone("GMT+0"));
        return JSON.parseObject(jsonString, T);
    }

    public static JSONObject map2Json(HashMap<String, String> map) {
        JSONObject json = new JSONObject();
        Set<String> set = map.keySet();
        for (Iterator<String> it = set.iterator(); it.hasNext(); ) {
            String key = it.next();
            json.put(key, map.get(key));
        }
        return json;
    }

    /**
     * 微服务返回的结果集是map，要将data的list转成实体对象的list
     * list先转成json，再把json转成实体对象列表
     *
     * @param list
     * @param T
     * @return
     */
    public static <T> List<T> mapListToBeanList(List list, Class T) {
        if (list == null) {
            return null;
        }
        String jsonString = JsonParseUtil.ObjectToJSONString(list);
        return JSON.parseArray(jsonString, T);
    }
}
