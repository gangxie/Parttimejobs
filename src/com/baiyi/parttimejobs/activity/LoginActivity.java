package com.baiyi.parttimejobs.activity;

import java.util.HashMap;
import java.util.Map;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources.Theme;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;

import com.baiyi.parttimejobs.R;
import com.baiyi.parttimejobs.util.HttpPostThread;
import com.baiyi.parttimejobs.util.MyPost;
import com.baiyi.parttimejobs.util.NetWork;
import com.baiyi.parttimejobs.util.ThreadPoolUtils;

/*
 * 登录页
 */
public class LoginActivity extends BaseActivity {
	
	private TextView registerAccount;
	private TextView loginFrogetPwd;
	private CheckBox loginRemberPwd;
	private Button login;
	private RadioButton person, company;
	private ActionBar actionBar;

	private EditText account;// 账号
	private EditText password;// 密码

	private Handler mHandler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			
			if (msg.what == 200) {
				String result = msg.obj.toString();
				Log.i("----------------result----------------", result);
			}
		}

	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		initView();
		actionBar = this.getActionBar();
		// 不需要后退按钮
		// actionBar.setDisplayHomeAsUpEnabled(true);
		// 用户类型切换
		actionBar.setTitle("用户登录");
		// 设置监听
		TextViewOnclickListener mListener = new TextViewOnclickListener();
		registerAccount.setOnClickListener(mListener);
		loginFrogetPwd.setOnClickListener(mListener);
		loginRemberPwd.setOnClickListener(new CheckBoxListener());
		login.setOnClickListener(new LoginListener());

	}

	private void initView() {
		registerAccount = (TextView) findViewById(R.id.login_register_account);
		loginFrogetPwd = (TextView) findViewById(R.id.login_froget_pwd);
		loginRemberPwd = (CheckBox) findViewById(R.id.login_rember_pwd);
		login = (Button) findViewById(R.id.login_login);
		person = (RadioButton) findViewById(R.id.login_person);
		company = (RadioButton) findViewById(R.id.login_company);
		account = (EditText) findViewById(R.id.login_account);
		password = (EditText) findViewById(R.id.login_password);
	}

	// TextView监听器
	private class TextViewOnclickListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			if (v == registerAccount) {
				Toast.makeText(getApplicationContext(), "Register!",
						Toast.LENGTH_LONG).show();
			} else if (v == loginFrogetPwd) {
				Toast.makeText(getApplicationContext(), "ForgetPwd!",
						Toast.LENGTH_LONG).show();
			}

		}

	}

	private class CheckBoxListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			if (loginRemberPwd.isChecked()) {
				Toast.makeText(getApplicationContext(), "记住密码！",
						Toast.LENGTH_SHORT).show();
			} else {
				Toast.makeText(getApplicationContext(), "未记住密码！",
						Toast.LENGTH_SHORT).show();
			}

		}
	}

	private class LoginListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			if (company.isChecked()) {
				Intent intent = new Intent(getApplicationContext(),
						HomeActivity.class);
				startActivity(intent);
			} else if (person.isChecked()) {/*
				// 个人用户登录
				String mAccount = account.getText().toString();// 取得账号
				String mPwd = password.getText().toString();// 取得密码
				//访问服务器的url
				String url = "http://192.168.1.107:8080/PandaServer/login/login";
				//要发送到服务器的参数
				Map<String, String> nameValueMap = new HashMap<String, String>();
				nameValueMap.put("account", mAccount);
				nameValueMap.put("pwd", mPwd);
				// HttpPost方式发送
				HttpPostThread mPostThread = new HttpPostThread(mHandler, url,
						nameValueMap);// 启动一个线程发送请求
				// 判断网络是否正常
				if (NetWork.isNetworkConnected(getApplicationContext())) {
					// wifi或者移动网络其中之一可用
					if (NetWork.isMobileConnected(getApplicationContext())
							|| NetWork.isWifiConnected(getApplicationContext())) {
						ThreadPoolUtils.execute(mPostThread);// 启动线程
					}else{
						Toast.makeText(getApplicationContext(), "请检查网络或者WIFI是否打开！", Toast.LENGTH_SHORT).show();
					}
				}else{
					Toast.makeText(getApplicationContext(), "网络异常！。", Toast.LENGTH_SHORT).show();
				}

			*/
				Intent intent = new Intent(getApplicationContext(),
						MainTabActivity.class);
				startActivity(intent);	
			}
		}

	}

}
