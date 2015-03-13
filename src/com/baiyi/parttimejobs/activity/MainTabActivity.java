package com.baiyi.parttimejobs.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.baiyi.parttimejobs.R;
import com.baiyi.parttimejobs.fragment.FragmentFactory;
/*
 * �û���ҳ�л�
 */
public class MainTabActivity extends FragmentActivity {
	private long exitTime = 0;//���һ�ε�����ؼ���ʱ��
	private FragmentManager fragmentManager;
	private RadioGroup radioGroup;
	private ImageView[] mImageViews = new ImageView[3];
	// ͼƬid
	private int[] img = { R.id.user_home_jianzhi_img, R.id.user_home_near_img,
			R.id.user_home_mine_img };
	// ѡ���ǵ�״̬
	private int[] imgOn = { R.drawable.user_home_tab_jianzhi_on0,
			R.drawable.user_home_tab_near_on0, R.drawable.user_home_tab_mine_on0 };
	// δѡ��ʱ��״̬
	private int[] imgOff = { R.drawable.user_home_tab_jianzhi_normal0,
			R.drawable.user_home_tab_near_normal0,
			R.drawable.user_home_tab_mine_normal0 };

	// @TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_user_home_bottom_tab);
		initView();

		fragmentManager = getSupportFragmentManager();
		// ѡ�е�һ��
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		Fragment fragment = FragmentFactory.getInstanceByIndex(1);
		transaction.replace(R.id.user_home_content, fragment);
		transaction.commit();

		OnTabClickListener mClickListener = new OnTabClickListener();

		for (int i = 0; i < mImageViews.length; i++) {
			mImageViews[i].setOnClickListener(mClickListener);
		}

		/*
		 * radioGroup = (RadioGroup) findViewById(R.id.user_home_main_radio);
		 * radioGroup .setOnCheckedChangeListener(new
		 * RadioGroup.OnCheckedChangeListener() {
		 * 
		 * @Override public void onCheckedChanged(RadioGroup group, int
		 * checkedId) { FragmentTransaction transaction = fragmentManager
		 * .beginTransaction(); Fragment fragment = FragmentFactory
		 * .getInstanceByIndex(checkedId);
		 * Toast.makeText(getApplicationContext(), checkedId+"",
		 * Toast.LENGTH_SHORT).show();
		 * transaction.replace(R.id.user_home_content, fragment);
		 * transaction.commit(); }
		 * 
		 * });
		 */
	}

	private void initView() {
		for (int i = 0; i < mImageViews.length; i++) {
			mImageViews[i] = (ImageView) findViewById(img[i]);
		}
	}

	class OnTabClickListener implements OnClickListener {

		@Override
		public void onClick(View view) {
			// ���ñ���
			for (int i = 0; i < mImageViews.length; i++) {

				mImageViews[i].setImageDrawable(getResources().getDrawable(
						imgOff[i]));

			}

			for (int i = 0; i < mImageViews.length; i++) {
				if (view == mImageViews[i]) {
					mImageViews[i].setImageDrawable(getResources().getDrawable(
							imgOn[i]));
					FragmentTransaction transaction = fragmentManager
							.beginTransaction();
					Fragment fragment = FragmentFactory
							.getInstanceByIndex(i + 1);
					transaction.replace(R.id.user_home_content, fragment);
					transaction.commit();
				}
			}
		}
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK
				&& event.getAction() == KeyEvent.ACTION_DOWN) { // ���/����/���η��ؼ�
			if ((System.currentTimeMillis() - exitTime) > 2000) {
				Toast.makeText(getApplicationContext(), "�ٰ�һ���˳�����",
						Toast.LENGTH_SHORT).show();
				exitTime = System.currentTimeMillis();
			} else {
				AppManager.getAppManager().AppExit(this);
			}
			return true;
		} else if (keyCode == KeyEvent.KEYCODE_MENU) {
			// ���/���ز˵���
		} else if (keyCode == KeyEvent.KEYCODE_HOME) {
			// ����Home��Ϊϵͳ�����˴����ܲ�����Ҫ��дonAttachedToWindow()
		}
		return super.onKeyDown(keyCode, event);
	}

	@Override
	public void onBackPressed() {

		if ((System.currentTimeMillis() - exitTime) > 2000) {
			Toast.makeText(this, "�ٰ�һ���˳�", Toast.LENGTH_SHORT).show();
			exitTime = System.currentTimeMillis();
		} else {
			/*finish();
			System.exit(0);*/
			AppManager.getAppManager().AppExit(this);
		}
	}

}
