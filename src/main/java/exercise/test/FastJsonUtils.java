package exercise.test;

import com.alibaba.fastjson.JSON;

import java.util.List;

/**
 * @Author tianchengming
 * @Date 2020年9月1日 22:57
 * @Version 1.0
 */
public class FastJsonUtils {


    /**
     * 对象转换成json字符串
     * @param obj
     * @return
     */
    public static String parseToString(Object obj){
        return JSON.toJSONString(obj);
    }

    /**
     * json字符串转换成List集合
     *
     * @param jsonString
     * @return
     */
    public static <T> List<T> stringToList(String jsonString, Class clazz) throws Exception{
        List<T> list = null;
        try {
            list = JSON.parseArray(jsonString, clazz);
        } catch (Exception e) {
            throw e;
        }
        return list;
    }
}
