package com.jing.demo01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private String url = HttpUtil.GET_SERIAL_ROTATE;

    private HashMap<String , Object> params = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getXutils();

        //测试提交数据
        findViewById(R.id.text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HttpHelper.getInstance().get(url, params, new HttpCallback<String>() {

                    @Override
                    public void onSuccess(String rotateBean) {
                        Log.d("HHHH","SSSSS");
                        toast("请求成功");
                    }

                    @Override
                    public void onFailed(String string) {
                        Log.d("HHHH","SSSSS1111");
                        toast("请求失败");
                    }
                });
            }
        });
        // 在测试
    }

    public void toast(String string){
        Toast.makeText(this, string , Toast.LENGTH_SHORT).show();
    }

    public void getXutils(){
        HttpHelper.getInstance().post(url, params, new ICallBack() {
            @Override
            public void onSuccess(String string) {
                Log.d("HHHH","SSSSS");
                toast("请求成功");
            }

            @Override
            public void onFailed(String string) {
                Log.d("HHHH","SSSSS1111");
                toast("请求失败");
            }
        });
    }

}
