package com.baiyi.parttimejobs.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.baiyi.parttimejobs.R;

public class MineFragment extends Fragment/*implements View.OnClickListener*/{
/*	private View view1;
	private View view2;
	private View view3;
	private View view4;
	private View view5;
	private View view6;
	private View view7;
    private View[] views={view1,view2,view3,view4,view5,view6,view7};
	private View view;*/
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		    View view = inflater.inflate(R.layout.activity_mine, null);
	       
		return view;
	}
 /*  public void initView(){
	view1=view.findViewById(R.id.button1);
   	view2=view.findViewById(R.id.button2);
   	view3=view.findViewById(R.id.button3);
   	view4=view.findViewById(R.id.button4);
   	view5=view.findViewById(R.id.button5);
   	view6=view.findViewById(R.id.button6);
   	view7=view.findViewById(R.id.button7);
   	
   	for(int i=0;i<7;i++){
   		views[i].setTag(i);
   	}
   	
   	
   }
@Override
public void onClick(View arg0) {
	// TODO Auto-generated method stub
	switch(Integer.parseInt((String) arg0.getTag())){
	
	}
	
	
}
   */
  
}
