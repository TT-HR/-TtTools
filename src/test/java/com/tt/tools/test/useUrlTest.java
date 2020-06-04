package com.tt.tools.test;

import com.tt.tools.entity.UseUrlEntity;
import com.tt.tools.service.UseUrlService;
import com.tt.tools.untils.BeanUntil;
import groovy.util.logging.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Slf4j
@SpringBootTest
public class useUrlTest {
    @Autowired
    private UseUrlService useUrlService;
    @Autowired
    private BeanUntil beanUntil;
    @Test
    public void getUrlTest(){
//        UseUrlEntity useUrlEntity = new UseUrlEntity();
//        List<UseUrlEntity> useUrls = useUrlService.getUseUrl();
//        Map<String,String> map=new HashMap<>();
//        useUrls.forEach(useUrl->{
//            map.put(useUrlEntity.getImg(),useUrl.getUseName());
//        });
    }

    @Test
    public void untilTest() throws ClassNotFoundException {
        beanUntil.getBeanUntil("UseUrlEntity");

    }
}
