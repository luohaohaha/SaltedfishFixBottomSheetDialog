package com.saltedfish.app;


import java.util.List;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by haoluo on 2018/1/20.
 */

public class SaltedFishPagerAdapter extends PagerAdapter {

	private SparseArray<String> mTabData;
	private SparseArray<String> mRecyclerData;

	private Context mContext;

	private SparseArray<RecyclerView> mArtListViewSparseArray = new SparseArray<>();

	public SaltedFishPagerAdapter(Context mContext,SparseArray<String> mTabData, SparseArray<String> mRecyclerData) {
		this.mTabData = mTabData;
		this.mRecyclerData = mRecyclerData;
		this.mContext = mContext;
	}

	@Override
	public int getCount() {
		return mTabData.size();
	}

	@Override
	public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
		return view == object;
	}

	@NonNull
	@Override
	public Object instantiateItem(@NonNull ViewGroup container, final int position) {
		RecyclerView recyclerView;
		if (mArtListViewSparseArray.size() <= position || null == mArtListViewSparseArray.get(position)) {
			recyclerView = new RecyclerView(mContext);
			recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
			recyclerView.setFitsSystemWindows(true);
			mArtListViewSparseArray.put(position, recyclerView);
			bindAdapter(recyclerView);
			container.addView(recyclerView, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
		} else {
			recyclerView = mArtListViewSparseArray.get(position);
		}
		return recyclerView;
	}


	private void bindAdapter(RecyclerView recyclerView) {
		RecyclerView.Adapter adapter = new SaltedFishRecyclerAdapter(mContext,mRecyclerData);
		recyclerView.setAdapter(adapter);
	}


	@Override
	public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
		// super.destroyItem(container, position, object);
	}

	@Override
	public void destroyItem(@NonNull View container, int position, @NonNull Object object) {
		// super.destroyItem(container, position, object);
	}

	@Nullable
	@Override
	public CharSequence getPageTitle(int position) {
		return mTabData.get(position);
	}
}
