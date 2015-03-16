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
 * ��¼ҳ
 */
public class LoginActivity extends BaseActivity {
	
	private TextView registerAccount;
	private TextView loginFrogetPwd;
	private CheckBox loginRemberPwd;
	private Button login;
	private RadioButton person, company;
	private ActionBar actionBar;

	private EditText account;// �˺�
	private EditText password;// ����

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
		// ����Ҫ���˰�ť
		// actionBar.setDisplayHomeAsUpEnabled(true);
		// �û������л�
		actionBar.setTitle("�û���¼");
		// ���ü���
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

	// TextView������
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
				Toast.makeText(getApplicationContext(), "��ס���룡",
						Toast.LENGTH_SHORT).show();
			} else {
				Toast.makeText(getApplicationContext(), "δ��ס���룡",
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
				// �����û���¼
				String mAccount = account.getText().toString();// ȡ���˺�
				String mPwd = password.getText().toString();// ȡ������
				//���ʷ�������url
				String url = "http://192.168.1.107:8080/PandaServer/login/login";
				//Ҫ���͵��������Ĳ���
				Map<String, String> nameValueMap = new HashMap<String, String>();
				nameValueMap.put("account", mAccount);
				nameValueMap.put("pwd", mPwd);
				// HttpPost��ʽ����
				HttpPostThread mPostThread = new HttpPostThread(mHandler, url,
						nameValueMap);// ����һ���̷߳�������
				// �ж������Ƿ�����
				if (NetWork.isNetworkConnected(getApplicationContext())) {
					// wifi�����ƶ���������֮һ����
					if (NetWork.isMobileConnected(getApplicationContext())
							|| NetWork.isWifiConnected(getApplicationContext())) {
						ThreadPoolUtils.execute(mPostThread);// �����߳�
					}else{
						Toast.makeText(getApplicationContext(), "�����������WIFI�Ƿ�򿪣�", Toast.LENGTH_SHORT).show();
					}
				}else{
					Toast.makeText(getApplicationContext(), "�����쳣����", Toast.LENGTH_SHORT).show();
				}

			*/
				Intent intent = new Intent(getApplicationContext(),
						MainTabActivity.class);
				startActivity(intent);	
			}
		}

	}

}
