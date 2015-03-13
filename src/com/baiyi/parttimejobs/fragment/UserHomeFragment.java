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
	
	private ImageView jiaJiaoImageView;//家教
	
	private ImageView paiDanImageView;//派单
	
	private ImageView fuWuYuanImageView;//服务员
	
	private ImageView liYIImageView;//礼仪
	
	private ImageView daiLiImageView;//代理
	
	private ImageView xiaoNeiJainZhiImageView;//校内兼职
	
	private ImageView cuXiaoImageView;//促销
	
	private LinearLayout mLayout;// 图片兼职信息容器,最新兼职

	private LinearLayout mLayout2;// 猜你喜欢

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.activity_user_home, null);
		initView(view);
		addNewJobs();
		addYouFavour();
		OnImgClickListener mClickListener=new OnImgClickListener();
		jiaJiaoImageView.setOnClickListener(mClickListener);
		paiDanImageView.setOnClickListener(mClickListener);//派单
		fuWuYuanImageView.setOnClickListener(mClickListener);//服务员
		liYIImageView.setOnClickListener(mClickListener);//礼仪
		daiLiImageView.setOnClickListener(mClickListener);//代理
		xiaoNeiJainZhiImageView.setOnClickListener(mClickListener);;//校内兼职
		cuXiaoImageView.setOnClickListener(mClickListener);//促销
		
		return view;
	}
	
	class OnImgClickListener implements OnClickListener{

		@Override
		public void onClick(View view) {
			
			if(view==jiaJiaoImageView){
				//Toast.makeText(getActivity(), "家教", Toast.LENGTH_SHORT).show();
				Intent intent=new Intent(getActivity(),JiaJiaoActivity.class);
				startActivity(intent);
			}else if(view==paiDanImageView){
				//Toast.makeText(getActivity(), "派单", Toast.LENGTH_SHORT).show();
				Intent intent=new Intent(getActivity(),PaiDanActivity.class);
				startActivity(intent);
			}else if(view==fuWuYuanImageView){
				//Toast.makeText(getActivity(), "服务员", Toast.LENGTH_SHORT).show();
				Intent intent=new Intent(getActivity(),FuWuYuanActivity.class);
				startActivity(intent);
			}else if(view==liYIImageView){
				//Toast.makeText(getActivity(), "礼仪", Toast.LENGTH_SHORT).show();
				Intent intent=new Intent(getActivity(),LiYiActivity.class);
				startActivity(intent);
			}else if(view==daiLiImageView){
				//Toast.makeText(getActivity(), "代理", Toast.LENGTH_SHORT).show();
				Intent intent=new Intent(getActivity(),DaiLiActivity.class);
				startActivity(intent);
			}else if(view==xiaoNeiJainZhiImageView){
				//Toast.makeText(getActivity(), "校内代理", Toast.LENGTH_SHORT).show();
				Intent intent=new Intent(getActivity(),XiaoleijianzhiActivity.class);
				startActivity(intent);
			}else if(view==cuXiaoImageView){
				//Toast.makeText(getActivity(), "促销", Toast.LENGTH_SHORT).show();
				Intent intent=new Intent(getActivity(),CuXiaoActivity.class);
				startActivity(intent);
			}
		}
		
	}

	// 添加猜你喜欢
	private void addYouFavour() {

		FavouriteJobsView mFavouriteJobsView1 = new FavouriteJobsView(
				this.getActivity());// 集成空间
		// int mHeight = mFavouriteJobsView1.mLinearLayoutRight.getHeight();//
		// 左侧容器的高度
		// 获取图片，从服务器获取
		// 处理图片
		InputStream is = getResources().openRawResource(R.drawable.test);
		Bitmap src = BitmapFactory.decodeStream(is);

		Bitmap mBitmap = new DrawBitmap(this.getActivity()).drawCuXiao(src);

		mFavouriteJobsView1.title.setTextColor(getResources().getColor(
				R.color.calendar_color_orange));

		DisplayMetrics metric = new DisplayMetrics();
		this.getActivity().getWindowManager().getDefaultDisplay()
				.getMetrics(metric);
		int width = metric.widthPixels; // 屏幕宽度（像素）

		ImageView mImageView = new ImageView(this.getActivity());
		mImageView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
				width / 4));
		mImageView.setImageBitmap(mBitmap);
		/*
		 * mImageView
		 * .setImageDrawable(getResources().getDrawable(R.drawable.test));
		 */
		mFavouriteJobsView1.mLinearLayoutLeft.addView(mImageView);// 添加到容器
		mFavouriteJobsView1.date.setText("1天前");
		mFavouriteJobsView1.remark.setText("20条评论");
		mFavouriteJobsView1.salary.setText("30元/小时");
		mFavouriteJobsView1.title.setText("德克士");

		mFavouriteJobsView1.disance.setText("100m");
		mLayout2.addView(mFavouriteJobsView1);
	}

	// 添加最新兼职
	private void addNewJobs() {
		InputStream is = getResources().openRawResource(R.drawable.test);
		Bitmap src = BitmapFactory.decodeStream(is);

		DisplayMetrics metric = new DisplayMetrics();
		this.getActivity().getWindowManager().getDefaultDisplay()
				.getMetrics(metric);
		int width = metric.widthPixels; // 屏幕宽度（像素）
		// int height = metric.heightPixels; // 屏幕高度（像素）
		// 生成3个imageview对象
		LayoutParams params = new LayoutParams(width / 3, width / 3);

		ImageView mView1 = new ImageView(this.getActivity());
		mView1.setLayoutParams(params);
		// mView1.setImageDrawable(getResources().getDrawable(R.drawable.test));
		mView1.setImageBitmap(new DrawBitmap(this.getActivity())
				.drawPaiDan(src));
		mView1.setPadding(5, 5, 5, 5);

		ImageView mView2 = new ImageView(this.getActivity());
		mView2.setLayoutParams(params);
		// mView2.setImageDrawable(getResources().getDrawable(R.drawable.test));
		mView2.setImageBitmap(new DrawBitmap(this.getActivity())
				.drawFuWuYuan(src));

		mView2.setPadding(5, 5, 5, 5);

		ImageView mView3 = new ImageView(this.getActivity());
		mView3.setLayoutParams(params);
		// mView3.setImageDrawable(getResources().getDrawable(R.drawable.test));
		mView3.setImageBitmap(new DrawBitmap(this.getActivity()).drawLiYi(src));

		mView3.setPadding(5, 5, 5, 5);
		// 最新兼职
		mLayout.addView(mView1);
		mLayout.addView(mView2);
		mLayout.addView(mView3);
	}
	//初始化组件
	private void initView(View view) {
		
		mLayout = (LinearLayout) view.findViewById(
				R.id.user_home_partitmejobs_icon_container);
		mLayout2 = (LinearLayout)view.findViewById(
				R.id.user_home_favourite_container);
		
		jiaJiaoImageView=(ImageView) view.findViewById(R.id.user_home_jiajiao_img);
		
		paiDanImageView=(ImageView) view.findViewById(R.id.user_home_paidan_img);
		
		fuWuYuanImageView=(ImageView) view.findViewById(R.id.user_home_fuwuyuan_img);//服务员
		
		liYIImageView=(ImageView) view.findViewById(R.id.user_home_liyi_img);//礼仪
		
		daiLiImageView=(ImageView)view.findViewById(R.id.user_home_daili_img);//代理
		
		xiaoNeiJainZhiImageView=(ImageView) view.findViewById(R.id.user_home_xiaoleijianzhi_img);//校内兼职
		
		cuXiaoImageView=(ImageView) view.findViewById(R.id.user_home_cunxiao_img);//促销
		
	}

}
