package com.tt.tools.untils;

import groovy.util.logging.Slf4j;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Method;


/**
 * @author admin
 */
@Slf4j
@Component
public class BeanUntil {

    public void getBeanUntil(String className) throws ClassNotFoundException {
        Field[] fields = className.getClass().getDeclaredFields();
        String[] name=new String[fields.length];
        Object[] value=new Object[fields.length];

        Field.setAccessible(fields, true);
        for (int i = 0; i < name.length; i++) {
            name[i] = fields[i].getName();
            System.out.println(name[i] + "-> ");
//            value[i] = fields[i].get(cHis);//cHis 是实体类名称
//            System.out.println(value[i]);
        }

    }
}
