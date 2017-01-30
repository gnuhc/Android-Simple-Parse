package com.androidbegin.jsonparsetutorial;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class ListViewAdapter extends BaseAdapter {

	// Declare Variables
	Context context;
	LayoutInflater inflater;
	ArrayList<HashMap<String, String>> data;
	ImageLoader imageLoader;
	HashMap<String, String> resultp = new HashMap<String, String>();

	public ListViewAdapter(Context context,
			ArrayList<HashMap<String, String>> arraylist) {
		this.context = context;
		data = arraylist;
		imageLoader = new ImageLoader(context);
	}

	@Override
	public int getCount() {
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	public View getView(final int position, View convertView, ViewGroup parent) {
		// Declare Variables
		TextView artistId;
		TextView artistName;
		TextView collectionPrice;
		TextView isStreamable;
		ImageView artworkUrl60;

		inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		View itemView = inflater.inflate(R.layout.listview_item, parent, false);
		// Get the position
		resultp = data.get(position);

		// Locate the TextViews in listview_item.xml
		artistId = (TextView) itemView.findViewById(R.id.artistId);
		artistName = (TextView) itemView.findViewById(R.id.artistName);
		collectionPrice = (TextView) itemView.findViewById(R.id.collectionPrice);
		isStreamable = (TextView) itemView.findViewById(R.id.isStreamable);


		// Locate the ImageView in listview_item.xml
		artworkUrl60 = (ImageView) itemView.findViewById(R.id.artworkUrl60);
		// Capture position and set results to the TextViews
		artistId.setText(resultp.get(MainActivity.ARTISTID));
		artistName.setText(resultp.get(MainActivity.ARTISTNAME));
		collectionPrice.setText(resultp.get(MainActivity.COLLECTIONPRICE));
		isStreamable.setText(resultp.get(MainActivity.ISSTREAMABLE));

		// Passes flag images URL into ImageLoader.class
		imageLoader.DisplayImage(resultp.get(MainActivity.ARTWORK), artworkUrl60);
		// Capture ListView item click
		return itemView;
	}
}
