package com.jing.demo01;

import java.util.Map;

/**
 * Function :
 *      代理类
 */

public class HttpHelper implements IHttpProcessor{

    private static IHttpProcessor mIHttpProcessor;

    private static HttpHelper instance;

    private HttpHelper(){

    }

    public static HttpHelper getInstance() {

        if (instance == null) {
            instance = new HttpHelper();
        }
        return instance;
    }

    /**
     * 初始化立即启动
     */
    public static void init(IHttpProcessor httpProcessor){
        mIHttpProcessor = httpProcessor;
    }


    @Override
    public void get(String url, Map<String, Object> params, ICallBack callBack) {
        mIHttpProcessor.get(url, params, callBack);
    }

    @Override
    public void post(String url, Map<String, Object> params, ICallBack callBack) {
        mIHttpProcessor.post(url, params, callBack);
    }
}
