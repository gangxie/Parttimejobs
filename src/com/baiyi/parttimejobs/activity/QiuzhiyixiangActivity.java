package com.baiyi.parttimejobs.activity;

import com.baiyi.parttimejobs.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class QiuzhiyixiangActivity extends Activity{
	private CheckBox cuxiao;
	private CheckBox campus;
	private CheckBox waiter;
	private CheckBox hometeach;
	private CheckBox leaflet;
	private CheckBox liyi;
	private CheckBox daili;
	private Button submit;
	private ImageView back;
   
	public void onCreate(Bundle savedInstanceState){
	   super.onCreate(savedInstanceState);
	   this.requestWindowFeature(Window.FEATURE_NO_TITLE);
	   setContentView(R.layout.personal_qiuzhiyixiang);
	   initView();
	   setListener();
	}
	public void initView(){
		cuxiao=(CheckBox)this.findViewById(R.id.personal_qiuzhi_cuxiao);
		campus=(CheckBox)this.findViewById(R.id.personal_qiuzhi_campus);
		waiter=(CheckBox)this.findViewById(R.id.personal_qiuzhi_waiter);
		hometeach=(CheckBox)this.findViewById(R.id.personal_qiuzhi_hometeach);
		leaflet=(CheckBox)this.findViewById(R.id.personal_qiuzhi_leaflet);
	    liyi=(CheckBox)this.findViewById(R.id.personal_qiuzhi_liyi);
		daili=(CheckBox)this.findViewById(R.id.personal_qiuzhi_daili);
		submit=(Button)this.findViewById(R.id.qiuzhiyixiang_submit);
		back=(ImageView)this.findViewById(R.id.qiuzhiyixiang_back_button);
		
	}
   public void setListener(){
	   submit.setOnClickListener(new OnClickListener(){

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Toast.makeText(QiuzhiyixiangActivity.this,"已经提交", Toast.LENGTH_SHORT).show();
		}
		   
	   });
	   back.setOnClickListener(new OnClickListener(){

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent intent=new Intent(QiuzhiyixiangActivity.this,mine_personalinfoActivity.class);
			QiuzhiyixiangActivity.this.startActivity(intent);
		}
		   
	   });
   }
}
