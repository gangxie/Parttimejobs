package com.baiyi.parttimejobs.activity;

import com.baiyi.parttimejobs.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

public class Jianzhixiangqing extends Activity{
	private TextView adsentence;
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.jianzhixiangqing_all);
		initView();
	}
	private void initView() {
		
     adsentence=(TextView)this.findViewById(R.id.ad_sentence);
		
	}
	
	

}
