package yuzhendong.bwie.com.dianshangnetdemo.FourNetOpitons.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import yuzhendong.bwie.com.dianshangnetdemo.MainActivity;
import yuzhendong.bwie.com.dianshangnetdemo.R;


public class LoginActivity extends AppCompatActivity {


    private Button btn1;
    private Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

            initview();
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                Toast.makeText(LoginActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(LoginActivity.this,RegisterActivity.class);
                Toast.makeText(LoginActivity.this, "跳转到注册页面", Toast.LENGTH_SHORT).show();
                startActivity(intent1);
            }
        });

    }

        private void initview() {
            btn1 = (Button) findViewById(R.id.btn1);
            btn2 = (Button) findViewById(R.id.btn2);
        }















}
