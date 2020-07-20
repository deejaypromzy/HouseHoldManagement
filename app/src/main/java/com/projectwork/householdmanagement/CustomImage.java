package com.projectwork.householdmanagement;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;


public class CustomImage extends BaseAdapter 
{
	private Context context;
	private Integer img[] = {R.drawable.pic48,R.drawable.pic48,R.drawable.pic48,R.drawable.pic48,R.drawable.pic48,R.drawable.pic48,R.drawable.pic48,R.drawable.pic48,R.drawable.pic48,R.drawable.pic48,R.drawable.pic48,R.drawable.pic48,R.drawable.pic48,R.drawable.pic48,R.drawable.pic48,R.drawable.pic48,R.drawable.pic48,R.drawable.pic48,R.drawable.pic48,R.drawable.pic48};
	
	CustomImage(Context context)
	{
		this.context = context;
	}

	
	@Override
	public int getCount() 
	{
		// TODO Auto-generated method stub
		return img.length;
	}


	@Override
	public Object getItem(int position)	
	{
		// TODO Auto-generated method stub
		return img[position];
	}


	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}


@Override
	public View getView(int position, View convertView, ViewGroup parent) 
	{
		ImageView imageView = new ImageView(context);
		imageView.setImageResource(img[position]);
		imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
		imageView.setLayoutParams(new GridView.LayoutParams(70,70));
		return imageView;
	}
}