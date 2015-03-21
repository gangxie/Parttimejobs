package com.baiyi.parttimejobs.fragment;

import java.io.InputStream;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.baiyi.parttimejobs.R;
import com.baiyi.parttimejobs.activity.CuXiaoActivity;
import com.baiyi.parttimejobs.activity.DaiLiActivity;
import com.baiyi.parttimejobs.activity.FuWuYuanActivity;
import com.baiyi.parttimejobs.activity.JiaJiaoActivity;
import com.baiyi.parttimejobs.activity.LiYiActivity;
import com.baiyi.parttimejobs.activity.PaiDanActivity;
import com.baiyi.parttimejobs.activity.XiaoleijianzhiActivity;
import com.baiyi.parttimejobs.myviews.FavouriteJobsView;
import com.baiyi.parttimejobs.util.DrawBitmap;

public class UserHomeFragment extends Fragment {
	
	private TextView jiaJiao;//�ҽ�
	
	private  TextView paiDan;//�ɵ�
	
	private  TextView fuWuYuan;//����Ա
	
	private TextView liYI;//����
	
	private  TextView daiLi;//����
	
	private  TextView xiaoNei;//У�ڼ�ְ
	
	private  TextView cuXiao;//����
	

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.activity_user_home, null);
		initView(view);
	
		return view;
	}
	



	

	private void initView(View view) {
		
	
		
		jiaJiao=(TextView) view.findViewById(R.id.userhome_jiajiao);
		
		paiDan=(TextView) view.findViewById(R.id.userhome_paidan);
		
		fuWuYuan=(TextView) view.findViewById(R.id.userhome_fuwuyuan);//����Ա
		
		liYI=(TextView) view.findViewById(R.id.userhome_liyi);//����
		
		daiLi=(TextView)view.findViewById(R.id.userhome_daili);//����
		
		xiaoNei=(TextView) view.findViewById(R.id.userhome_xiaoneijianzhi);//У�ڼ�ְ
		
		cuXiao=(TextView) view.findViewById(R.id.userhome_cuxiao);//����
		
	}

}
