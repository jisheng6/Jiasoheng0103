package com.bawei.jiasoheng0103;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MaActivity extends AppCompatActivity {
    private Button btn_shou;
    private TextView tv_b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ma);
        btn_shou=(Button)findViewById(R.id.btn_shou);
        btn_shou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!EventBus.getDefault().isRegistered(MaActivity.this)){
                    EventBus.getDefault().register(MaActivity.this);
                }else{
                    Toast.makeText(MaActivity.this, "请勿重复注册事件", Toast.LENGTH_SHORT).show();
                }
            }
        });
        tv_b=(TextView)findViewById(R.id.tv_b);
        tv_b.setText("账号多少呢！");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(MaActivity.this);
    }
    @Subscribe(threadMode = ThreadMode.POSTING,sticky = true)
    public void onMoonEvent(UserEvent userevent){
        tv_b.setText("账号："+userevent.getUsername()+"密码："+userevent.getPasswork());
    }
}
