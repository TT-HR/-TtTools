package com.tt.tools.api;

import com.tt.tools.entity.UseUrlEntity;
import com.tt.tools.service.UseUrlService;
import groovy.util.logging.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author admin
 */
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("api/useUrl")
public class UseUrlApi {
    @Autowired
    private UseUrlService useUrlService;

    @PostMapping("get/getUseUrl")
    public Map<String,String> getUserUrl(){
        List<UseUrlEntity> useUrls = useUrlService.getUseUrl();
        Map<String,String> map=new HashMap<>(5);
        useUrls.forEach(useUrl->{
            map.put("",useUrl.getUseName());
        });

        return null;
    }

}
