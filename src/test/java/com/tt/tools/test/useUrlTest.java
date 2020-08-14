package com.tt.tools.test;

import com.tt.tools.service.UseUrlService;
import com.tt.tools.untilmethod.encrypto.JasyptUntil;
import groovy.util.logging.Slf4j;
import org.jasypt.util.text.BasicTextEncryptor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Slf4j
@SpringBootTest
public class useUrlTest {
    @Autowired
    private UseUrlService useUrlService;
    @Autowired
    private JasyptUntil jasyptUntil;
    @Test
    public void getUrlTest(){
        Map<String,List<String>> map=new HashMap<>();
        List<String> list=new ArrayList<>();
        list.add("yhr");
        list.add("yhr199792tool");
        map.put("tt",list);
        System.out.println(new JSONObject(map));
    }

}
