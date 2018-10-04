package com.why.project.navigationviewdemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

	private ImageView mImgMenu;
	/**导航栏左侧的侧边栏的父容器*/
	private DrawerLayout mDrawerLayout;
	//导航视图
	private NavigationView mNavigationView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initViews();
		initEvents();
	}

	private void initViews() {
		mImgMenu = findViewById(R.id.img_menu);

		mDrawerLayout = findViewById(R.id.id_drawerLayout);
		mNavigationView = findViewById(R.id.nav_view);
	}

	private void initEvents() {
		//用户图标的点击事件
		mImgMenu.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mDrawerLayout.openDrawer(Gravity.LEFT);
			}
		});

		mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
			@Override
			public boolean onNavigationItemSelected(@NonNull MenuItem item) {
				switch(item.getItemId()){
					case R.id.menu_info:
						Toast.makeText(MainActivity.this, "个人信息", Toast.LENGTH_SHORT).show();
						break;
					case R.id.menu_pwd:
						Toast.makeText(MainActivity.this, "修改密码", Toast.LENGTH_SHORT).show();
						break;
					case R.id.menu_setting:
						Toast.makeText(MainActivity.this, "设置", Toast.LENGTH_SHORT).show();
						break;
					case R.id.menu_about:
						Toast.makeText(MainActivity.this, "关于", Toast.LENGTH_SHORT).show();
						break;
					case R.id.menu_exit:
						Toast.makeText(MainActivity.this, "退出", Toast.LENGTH_SHORT).show();
						break;
				}
				//关闭侧滑菜单
				mDrawerLayout.closeDrawers();
				return true;
			}
		});
	}
}
