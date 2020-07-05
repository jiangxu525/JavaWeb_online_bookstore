package com.atguigu.utils;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @Author: jiang
 * @Date: 6/28/2020
 */
public class WebUtils {

    public static <T> T copyParamToBean(Map value, T bean){

        try {
            BeanUtils.populate(bean,value);
        } catch (IllegalAccessException|InvocationTargetException e) {
            e.printStackTrace();
        }
        return bean;
    }

    public static int parseInt(String strInt, int defaultValue){
        try {
            return Integer.parseInt(strInt);
        } catch (NumberFormatException e) {
//            e.printStackTrace();
        }
        return defaultValue;
    }
}
