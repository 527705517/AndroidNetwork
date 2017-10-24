package com.jing.demo01;

/**
 * Function :
 *
 *    网络层走的是byte 网络给我们的最终的String
 *
 */

public interface ICallBack {

    void onSuccess(String string);

    void onFailed(String string);


}
