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
	// ����ViewPager����
	private ViewPager mViewPager;
	// ����ViewPagerAdapter
	private ViewPagerAdapter vpAdapter;
	// ���view
	private ArrayList<View> views;
	// ����ͼƬ��Դ
	private static final int[] pics = { R.drawable.user_home_guide1,
			R.drawable.user_home_guide2, R.drawable.user_home_guide3 };
	//���һ��ͼƬ��Դ��id
	private static final int picId=R.drawable.user_home_guide4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// ����Ҫ������
		setContentView(R.layout.activity_welcome_viewpaper);
		mViewPager = (ViewPager) findViewById(R.id.ViewPager);
		initView();
		initData();
		
	}

	/*
	 * ��ʼ��view
	 */
	private void initView() {
		views = new ArrayList<View>();
		mViewPager = (ViewPager) findViewById(R.id.ViewPager);
		vpAdapter = new ViewPagerAdapter(views);

	}

	/*
	 * ��ʼ������
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
		// ��ʼ������ͼƬ�б�.
		for (int i = 0; i < pics.length; i++) {
			ImageView iv = new ImageView(getApplicationContext());
			iv.setLayoutParams(mParams);
			iv.setImageResource(pics[i]);
			views.add(iv);
		}
		/*
		 * ���һҳ��ӭҳ�棬���һ��ImageView,���֮�����������
		 */
		LinearLayout layout=new LinearLayout(getApplicationContext());
		layout.setLayoutParams(mParams);
		layout.setOrientation(LinearLayout.VERTICAL);
		//ͼƬ��Դ
		ImageView lastImageView=new ImageView(getApplicationContext());
		lastImageView.setLayoutParams(imgParams);
		lastImageView.setImageResource(picId);
		//��ť
		ImageView mImgView=new ImageView(getApplicationContext());
		mImgView.setLayoutParams(btnParams);
		mImgView.setImageResource(R.drawable.user_home_lijitiyan);
		//mButton.setBackgroundColor(getResources().getColor(android.R.color.holo_green_dark));
		//�����ť������¼ҳ�棬ֻ�е�һ�ν���ʱ�Ż��������ҳ�棬����ֱ�ӽ����¼ҳ��
		mImgView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(getApplicationContext(),LoginActivity.class);
				startActivity(intent);
				
			}
		});
		//��ͼƬ��ͼƬ��ť��ӵ�layout
		layout.addView(lastImageView);
		layout.addView(mImgView);
		//��layout��ӵ�views
		views.add(layout);
		
		mViewPager.setAdapter(vpAdapter);
		mViewPager.setOnPageChangeListener(this);

	}

	/*
	 * ���õ�ǰҪ��ʾ��view
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
		// �����б�
		private ArrayList<View> views;

		public ViewPagerAdapter(ArrayList<View> views) {
			this.views = views;
		}

		// ��õ�ǰ������
		@Override
		public int getCount() {
			if (views != null) {
				return views.size();
			}
			return 0;
		}

		// �ж��Ƿ��ɶ������ɽ���
		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			// TODO Auto-generated method stub
			return arg0 == arg1;
		}

		// ��ʼ��positionλ�ý���
		@Override
		public Object instantiateItem(View container, int position) {
			// TODO Auto-generated method stub
			((ViewPager) container).addView(views.get(position));
			return views.get(position);
		}

		// ����positionλ�õĽ���
		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			((ViewPager) container).removeView(views.get(position));

		}

	}

}
