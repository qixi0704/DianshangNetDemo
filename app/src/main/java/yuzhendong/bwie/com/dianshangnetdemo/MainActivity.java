package yuzhendong.bwie.com.dianshangnetdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hjm.bottomtabbar.BottomTabBar;

import yuzhendong.bwie.com.dianshangnetdemo.FirstNetOpitons.view.Fragment1;
import yuzhendong.bwie.com.dianshangnetdemo.SecondNetOpitons.view.Fragment2;
import yuzhendong.bwie.com.dianshangnetdemo.ThirdNetOpitons.view.Fragment3;
import yuzhendong.bwie.com.dianshangnetdemo.FourNetOpitons.view.Fragment4;

public class MainActivity extends AppCompatActivity {

    private BottomTabBar bottomTabBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomTabBar = (BottomTabBar) findViewById(R.id.bottom_tab_bar);

        bottomTabBar.init(getSupportFragmentManager())
                .addTabItem("微淘",R.drawable.b_film_stars,R.drawable.b_film_star_edge,Fragment1.class)
                .addTabItem("分类",R.drawable.b_newhome_tabbar_press,R.drawable.b_newhome_tabbar,Fragment2.class)
                .addTabItem("购物车",R.drawable.b_newcare_tabbar_press,R.drawable.b_newcare_tabbar,Fragment3.class)
                .addTabItem("我的",R.drawable.b_newmine_tabbar_press,R.drawable.b_newmine_tabbar,Fragment4.class);

    }
}
