package com.baiyi.parttimejobs.activity;

import com.baiyi.parttimejobs.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class Mine_MyApplicationActivity extends Activity {
	
	private ImageView back;
     public void onCreate(Bundle savedInstanceState){
    	 super.onCreate(savedInstanceState);
    	 this.requestWindowFeature(Window.FEATURE_NO_TITLE);
    	 setContentView(R.layout.mine_myapplication);
    	 initView();
    	 setListener();
     }
	private void initView() {
		// TODO Auto-generated method stub
		back=(ImageView)this.findViewById(R.id.myapplication_back_button);
	}
	private void setListener(){
		back.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Mine_MyApplicationActivity.this,MaintabActivity.class);
			     startActivity(intent);
			}
			
		});
		
	}
}
