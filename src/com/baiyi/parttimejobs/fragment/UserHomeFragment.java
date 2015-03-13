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
	
	private ImageView jiaJiaoImageView;//�ҽ�
	
	private ImageView paiDanImageView;//�ɵ�
	
	private ImageView fuWuYuanImageView;//����Ա
	
	private ImageView liYIImageView;//����
	
	private ImageView daiLiImageView;//����
	
	private ImageView xiaoNeiJainZhiImageView;//У�ڼ�ְ
	
	private ImageView cuXiaoImageView;//����
	
	private LinearLayout mLayout;// ͼƬ��ְ��Ϣ����,���¼�ְ

	private LinearLayout mLayout2;// ����ϲ��

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.activity_user_home, null);
		initView(view);
		addNewJobs();
		addYouFavour();
		OnImgClickListener mClickListener=new OnImgClickListener();
		jiaJiaoImageView.setOnClickListener(mClickListener);
		paiDanImageView.setOnClickListener(mClickListener);//�ɵ�
		fuWuYuanImageView.setOnClickListener(mClickListener);//����Ա
		liYIImageView.setOnClickListener(mClickListener);//����
		daiLiImageView.setOnClickListener(mClickListener);//����
		xiaoNeiJainZhiImageView.setOnClickListener(mClickListener);;//У�ڼ�ְ
		cuXiaoImageView.setOnClickListener(mClickListener);//����
		
		return view;
	}
	
	class OnImgClickListener implements OnClickListener{

		@Override
		public void onClick(View view) {
			
			if(view==jiaJiaoImageView){
				//Toast.makeText(getActivity(), "�ҽ�", Toast.LENGTH_SHORT).show();
				Intent intent=new Intent(getActivity(),JiaJiaoActivity.class);
				startActivity(intent);
			}else if(view==paiDanImageView){
				//Toast.makeText(getActivity(), "�ɵ�", Toast.LENGTH_SHORT).show();
				Intent intent=new Intent(getActivity(),PaiDanActivity.class);
				startActivity(intent);
			}else if(view==fuWuYuanImageView){
				//Toast.makeText(getActivity(), "����Ա", Toast.LENGTH_SHORT).show();
				Intent intent=new Intent(getActivity(),FuWuYuanActivity.class);
				startActivity(intent);
			}else if(view==liYIImageView){
				//Toast.makeText(getActivity(), "����", Toast.LENGTH_SHORT).show();
				Intent intent=new Intent(getActivity(),LiYiActivity.class);
				startActivity(intent);
			}else if(view==daiLiImageView){
				//Toast.makeText(getActivity(), "����", Toast.LENGTH_SHORT).show();
				Intent intent=new Intent(getActivity(),DaiLiActivity.class);
				startActivity(intent);
			}else if(view==xiaoNeiJainZhiImageView){
				//Toast.makeText(getActivity(), "У�ڴ���", Toast.LENGTH_SHORT).show();
				Intent intent=new Intent(getActivity(),XiaoleijianzhiActivity.class);
				startActivity(intent);
			}else if(view==cuXiaoImageView){
				//Toast.makeText(getActivity(), "����", Toast.LENGTH_SHORT).show();
				Intent intent=new Intent(getActivity(),CuXiaoActivity.class);
				startActivity(intent);
			}
		}
		
	}

	// ��Ӳ���ϲ��
	private void addYouFavour() {

		FavouriteJobsView mFavouriteJobsView1 = new FavouriteJobsView(
				this.getActivity());// ���ɿռ�
		// int mHeight = mFavouriteJobsView1.mLinearLayoutRight.getHeight();//
		// ��������ĸ߶�
		// ��ȡͼƬ���ӷ�������ȡ
		// ����ͼƬ
		InputStream is = getResources().openRawResource(R.drawable.test);
		Bitmap src = BitmapFactory.decodeStream(is);

		Bitmap mBitmap = new DrawBitmap(this.getActivity()).drawCuXiao(src);

		mFavouriteJobsView1.title.setTextColor(getResources().getColor(
				R.color.calendar_color_orange));

		DisplayMetrics metric = new DisplayMetrics();
		this.getActivity().getWindowManager().getDefaultDisplay()
				.getMetrics(metric);
		int width = metric.widthPixels; // ��Ļ��ȣ����أ�

		ImageView mImageView = new ImageView(this.getActivity());
		mImageView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
				width / 4));
		mImageView.setImageBitmap(mBitmap);
		/*
		 * mImageView
		 * .setImageDrawable(getResources().getDrawable(R.drawable.test));
		 */
		mFavouriteJobsView1.mLinearLayoutLeft.addView(mImageView);// ��ӵ�����
		mFavouriteJobsView1.date.setText("1��ǰ");
		mFavouriteJobsView1.remark.setText("20������");
		mFavouriteJobsView1.salary.setText("30Ԫ/Сʱ");
		mFavouriteJobsView1.title.setText("�¿�ʿ");

		mFavouriteJobsView1.disance.setText("100m");
		mLayout2.addView(mFavouriteJobsView1);
	}

	// ������¼�ְ
	private void addNewJobs() {
		InputStream is = getResources().openRawResource(R.drawable.test);
		Bitmap src = BitmapFactory.decodeStream(is);

		DisplayMetrics metric = new DisplayMetrics();
		this.getActivity().getWindowManager().getDefaultDisplay()
				.getMetrics(metric);
		int width = metric.widthPixels; // ��Ļ��ȣ����أ�
		// int height = metric.heightPixels; // ��Ļ�߶ȣ����أ�
		// ����3��imageview����
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
		// ���¼�ְ
		mLayout.addView(mView1);
		mLayout.addView(mView2);
		mLayout.addView(mView3);
	}
	//��ʼ�����
	private void initView(View view) {
		
		mLayout = (LinearLayout) view.findViewById(
				R.id.user_home_partitmejobs_icon_container);
		mLayout2 = (LinearLayout)view.findViewById(
				R.id.user_home_favourite_container);
		
		jiaJiaoImageView=(ImageView) view.findViewById(R.id.user_home_jiajiao_img);
		
		paiDanImageView=(ImageView) view.findViewById(R.id.user_home_paidan_img);
		
		fuWuYuanImageView=(ImageView) view.findViewById(R.id.user_home_fuwuyuan_img);//����Ա
		
		liYIImageView=(ImageView) view.findViewById(R.id.user_home_liyi_img);//����
		
		daiLiImageView=(ImageView)view.findViewById(R.id.user_home_daili_img);//����
		
		xiaoNeiJainZhiImageView=(ImageView) view.findViewById(R.id.user_home_xiaoleijianzhi_img);//У�ڼ�ְ
		
		cuXiaoImageView=(ImageView) view.findViewById(R.id.user_home_cunxiao_img);//����
		
	}

}
