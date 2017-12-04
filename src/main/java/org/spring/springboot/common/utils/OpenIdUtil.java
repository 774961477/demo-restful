package org.spring.springboot.common.utils;

import com.alibaba.fastjson.JSONObject;

/**
 * @author xsx
 */
public class OpenIdUtil {
    public static String oauth2GetOpenid(String code) {
        String appid="wx238963ff40124c72";
        String appsecret="837adf84a8158f20ffa0f94cd7f3e81f";

        //授权（必填）
        String grant_type = "authorization_code";
        //URL
        String requestUrl = "https://api.weixin.qq.com/sns/jscode2session";
        //请求参数
        String params = "appid=" + appid + "&secret=" + appsecret + "&js_code=" + code + "&grant_type=" + grant_type;
        //发送请求
        String data = HttpUtil.get(requestUrl, params);
        //解析相应内容（转换成json对象）
        JSONObject  json = JSONObject.parseObject(data);
        //用户的唯一标识（openid）
        String Openid =String.valueOf(json.get("openid"));
        //System.out.println(Openid);
        return Openid;
    }
}
