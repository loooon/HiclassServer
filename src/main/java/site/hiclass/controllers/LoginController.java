package site.hiclass.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import site.hiclass.utils.WxMappingJackson2HttpMessageConverter;

@RestController
public class LoginController {

    // 根据 appid，appecret，以及客户端生成的 code，调微信的登录凭证校验接口用到的微信接口 URl
    private static final String code2SessionServerUrl = "https://api.weixin.qq.com/sns/jscode2session";
    private static RestTemplate restTemplate;

    @Value("${appId}")
    private String appId;

    @Value("${appSecret}")
    private String appSecret;

    static {
        restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new WxMappingJackson2HttpMessageConverter());
    }

    @GetMapping("/validate")
    public Object validateUserCode(@RequestParam("js_code") String code) {

        String url = code2SessionServerUrl + "?appid=" + appId + "&secret=" + appSecret
                + "&js_code=" + code + "&grant_type=authorization_code";

        Object result = restTemplate.getForObject(url, Object.class);

        return result;
    }
}
