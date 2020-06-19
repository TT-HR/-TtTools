package com.tt.tools.untils;

import groovy.util.logging.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;


/**
 * @author TT
 */
@Slf4j
@Component
public class BeanUntil<T> {
    private static final Logger log = LoggerFactory.getLogger(BeanUntil.class);

    /**
     *获取bean私有属性
     *
     * */
    public List getBeanUntil(T t){
        //获取bean所有属性
        Field[] fields = t.getClass().getDeclaredFields();
        String[] name = new String[fields.length];
        List listName=new ArrayList<T>();
        try {
            Field.setAccessible(fields, true);
            for (int i=0; i < name.length; i++) {
                listName.add(fields[i].getName());
            }
            return listName;
        } catch (Exception e) {
            log.info("getBeanUntil error:" + e);
        }
        return null;
    }

}
