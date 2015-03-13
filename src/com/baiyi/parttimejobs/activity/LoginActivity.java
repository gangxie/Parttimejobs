package com.baiyi.parttimejobs.activity;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;

import com.baiyi.parttimejobs.R;

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
			} else if (person.isChecked()) {
				Intent intent = new Intent(getApplicationContext(),
						MainTabActivity.class);
				startActivity(intent);
			}
		}

	}

}
