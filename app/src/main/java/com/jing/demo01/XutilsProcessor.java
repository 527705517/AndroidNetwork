package com.jing.demo01;

import android.widget.Toast;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.Map;


/**
 * Created by zhangzhenqiang on 2017/10/24.
 */

public class XutilsProcessor implements IHttpProcessor {
    @Override
    public void get(String url, Map<String, Object> map, final ICallBack callBack) {
        RequestParams params=new RequestParams(url);
        params.setConnectTimeout(120*1000);
        if(null!=map){
            for(Map.Entry<String, Object> entry : map.entrySet()){
                params.addQueryStringParameter(entry.getKey(), entry.getValue().toString());
            }
        }

        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

                callBack.onSuccess(result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

                callBack.onFailed(ex.toString());
            }

            @Override
            public void onCancelled(CancelledException cex) {
                Toast.makeText(x.app(), "cancelled", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFinished() {

            }
        });
    }

    @Override
    public void post(String url, Map<String, Object> params, ICallBack callBack) {

    }
}
