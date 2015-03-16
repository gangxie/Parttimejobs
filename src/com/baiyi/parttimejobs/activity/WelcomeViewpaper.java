package com.baiyi.parttimejobs.activity;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.baiyi.parttimejobs.R;

public class WelcomeViewpaper extends BaseActivity implements View.OnClickListener,
		OnPageChangeListener {
	// 定义ViewPager对象
	private ViewPager mViewPager;
	// 定义ViewPagerAdapter
	private ViewPagerAdapter vpAdapter;
	// 存放view
	private ArrayList<View> views;
	// 引导图片资源
	private static final int[] pics = { R.drawable.user_home_guide1,
			R.drawable.user_home_guide2, R.drawable.user_home_guide3 };
	//最后一张图片资源的id
	private static final int picId=R.drawable.user_home_guide4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 不需要标题栏
		setContentView(R.layout.activity_welcome_viewpaper);
		mViewPager = (ViewPager) findViewById(R.id.ViewPager);
		initView();
		initData();
		
	}

	/*
	 * 初始化view
	 */
	private void initView() {
		views = new ArrayList<View>();
		mViewPager = (ViewPager) findViewById(R.id.ViewPager);
		vpAdapter = new ViewPagerAdapter(views);

	}

	/*
	 * 初始化数据
	 */
	private void initData() {
		LinearLayout.LayoutParams mParams = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.MATCH_PARENT,
				LinearLayout.LayoutParams.MATCH_PARENT);
		LinearLayout.LayoutParams imgParams = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.MATCH_PARENT,
				LinearLayout.LayoutParams.MATCH_PARENT,1.0f);
		LinearLayout.LayoutParams btnParams = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.MATCH_PARENT,
				LinearLayout.LayoutParams.MATCH_PARENT,7.0f);
		btnParams.setMargins(10, 10, 10, 10);
		// 初始化引导图片列表.
		for (int i = 0; i < pics.length; i++) {
			ImageView iv = new ImageView(getApplicationContext());
			iv.setLayoutParams(mParams);
			iv.setImageResource(pics[i]);
			views.add(iv);
		}
		/*
		 * 最后一页欢迎页面，多出一个ImageView,点击之后进入主界面
		 */
		LinearLayout layout=new LinearLayout(getApplicationContext());
		layout.setLayoutParams(mParams);
		layout.setOrientation(LinearLayout.VERTICAL);
		//图片资源
		ImageView lastImageView=new ImageView(getApplicationContext());
		lastImageView.setLayoutParams(imgParams);
		lastImageView.setImageResource(picId);
		//按钮
		ImageView mImgView=new ImageView(getApplicationContext());
		mImgView.setLayoutParams(btnParams);
		mImgView.setImageResource(R.drawable.user_home_lijitiyan);
		//mButton.setBackgroundColor(getResources().getColor(android.R.color.holo_green_dark));
		//点击按钮后进入登录页面，只有第一次进入时才会出现引导页面，否则直接进入登录页面
		mImgView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(getApplicationContext(),LoginActivity.class);
				startActivity(intent);
				
			}
		});
		//把图片和图片按钮添加到layout
		layout.addView(lastImageView);
		layout.addView(mImgView);
		//把layout添加到views
		views.add(layout);
		
		mViewPager.setAdapter(vpAdapter);
		mViewPager.setOnPageChangeListener(this);

	}

	/*
	 * 设置当前要显示的view
	 */
	private void setCurView(int position) {
		if (position < 0 && position >pics.length) {
			return;
		}
		mViewPager.setCurrentItem(position);
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPageSelected(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onClick(View v) {
		int position = (Integer) v.getTag();
		setCurView(position);

	}

	class ViewPagerAdapter extends PagerAdapter {
		// 界面列表
		private ArrayList<View> views;

		public ViewPagerAdapter(ArrayList<View> views) {
			this.views = views;
		}

		// 获得当前界面数
		@Override
		public int getCount() {
			if (views != null) {
				return views.size();
			}
			return 0;
		}

		// 判断是否由对象生成界面
		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			// TODO Auto-generated method stub
			return arg0 == arg1;
		}

		// 初始化position位置界面
		@Override
		public Object instantiateItem(View container, int position) {
			// TODO Auto-generated method stub
			((ViewPager) container).addView(views.get(position));
			return views.get(position);
		}

		// 销毁position位置的界面
		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			((ViewPager) container).removeView(views.get(position));

		}

	}

}
