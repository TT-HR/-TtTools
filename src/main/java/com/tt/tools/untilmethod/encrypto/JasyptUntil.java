package com.tt.tools.untilmethod.encrypto;

import groovy.util.logging.Slf4j;
import org.jasypt.util.text.BasicTextEncryptor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author admin
 */
@Slf4j
@Component
public class JasyptUntil {

    /**
     * Jasypt加密
     * */
    public List encrypto(String salt, List<String> list) {
        List<String> encryptorText = new ArrayList<>();
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        //加密所需的salt(盐)
        textEncryptor.setPassword(salt);
        //要加密的数据
        list.forEach(data->encryptorText.add(textEncryptor.encrypt(data)));
        return encryptorText;
    }

    /**
     * Jasypt解密
     * */
    public List decrypt(String salt, List<String> list){
        List<String> encryptorText = new ArrayList<>();
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        //解密所需的salt(盐)
        textEncryptor.setPassword(salt);
        //要加密的数据
        list.forEach(data->encryptorText.add(textEncryptor.decrypt(data)));
        return encryptorText;
    }
}
