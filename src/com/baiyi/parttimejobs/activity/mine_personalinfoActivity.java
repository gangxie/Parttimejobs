package com.baiyi.parttimejobs.activity;

import com.baiyi.parttimejobs.R;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

public class mine_personalinfoActivity extends Activity{
	
	  private  ImageView user_photo;
	  private  TextView timeTable;
	  private  TextView  workType;
	  
	  private EditText username;
	  private EditText height;
	  private RadioButton workMan;
	  private RadioButton workWoman;
	  private ImageView back;
	  private TextView birthDate;
	  private Button  chooseDate;
	  
	  private DatePickerDialog.OnDateSetListener datePickListener;
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_mine_personalinfo);
		initView();
		setListener();
		
	}
  public void initView(){
	  back=(ImageView)this.findViewById(R.id.personal_back);
	  chooseDate=(Button)this.findViewById(R.id.personal_chooseDate);
	  birthDate=(TextView)this.findViewById(R.id.personal_birthDate);
	  timeTable=(TextView)this.findViewById(R.id.mine_timetable);
	 workType=(TextView)this.findViewById(R.id.mine_personalinfo_worktype);
  }
  public void setListener(){
	  
	  datePickListener=new OnDateSetListener(){

		@Override
		public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
			// TODO Auto-generated method stub
			birthDate.setText(arg1+"Äê"+(arg2+1)+"ÔÂ"+arg3+"ÈÕ");
		}
		  
	  };
	  chooseDate.setOnClickListener(new OnClickListener(){

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			new DatePickerDialog(mine_personalinfoActivity.this, datePickListener, 1995, 0, 1).show();;
		}
		  
	  });
	  back.setOnClickListener(new OnClickListener(){
		    
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(mine_personalinfoActivity.this,MaintabActivity.class);
				mine_personalinfoActivity.this.startActivity(intent);
			}
			  
		  });
	  timeTable.setOnClickListener(new OnClickListener(){
		    
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(mine_personalinfoActivity.this,mine_personal_timeActivity.class);
				mine_personalinfoActivity.this.startActivity(intent);
			}
			  
		  });
	  workType.setOnClickListener(new OnClickListener(){

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent intent=new Intent(mine_personalinfoActivity.this,QiuzhiyixiangActivity.class);
			startActivity(intent);
		}
		  
	  });
		  
	  }
  

}

