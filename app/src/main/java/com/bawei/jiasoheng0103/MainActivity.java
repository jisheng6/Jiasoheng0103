package com.bawei.jiasoheng0103;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText username,password;
    private Button btn_go;
    private List<UserEvent> mdata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mdata=new ArrayList<UserEvent>();
        username=(EditText)findViewById(R.id.username);
        password=(EditText)findViewById(R.id.passwork);
        btn_go=(Button)findViewById(R.id.btn_go);
        btn_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = username.getText().toString().trim();
                String pass = password.getText().toString().trim();
                EventBus.getDefault().postSticky(new UserEvent(name,pass));
                startActivity(new Intent(MainActivity.this,MaActivity.class));
            }
        });
    }
}
