package com.jing.demo01;

import java.util.Map;

/**

 * Function :
 *      共同实现的接口            代理和真正干活的类  的 共同实现的接口

 */

public interface IHttpProcessor {
    // Get

    void get(String url, Map<String, Object> params, ICallBack callBack);
    //Post
    void post(String url, Map<String, Object> params, ICallBack callBack);
    //Update
    //Delete
    //...
}
