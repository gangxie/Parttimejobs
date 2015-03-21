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
	
	private TextView jiaJiao;//家教
	
	private  TextView paiDan;//派单
	
	private  TextView fuWuYuan;//服务员
	
	private TextView liYI;//礼仪
	
	private  TextView daiLi;//代理
	
	private  TextView xiaoNei;//校内兼职
	
	private  TextView cuXiao;//促销
	

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
		
		fuWuYuan=(TextView) view.findViewById(R.id.userhome_fuwuyuan);//服务员
		
		liYI=(TextView) view.findViewById(R.id.userhome_liyi);//礼仪
		
		daiLi=(TextView)view.findViewById(R.id.userhome_daili);//代理
		
		xiaoNei=(TextView) view.findViewById(R.id.userhome_xiaoneijianzhi);//校内兼职
		
		cuXiao=(TextView) view.findViewById(R.id.userhome_cuxiao);//促销
		
	}

}
