package com.example.miwok;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter <Word> {
	private static final String LOG_TAG = WordAdapter.class.getSimpleName();
	private int mColorResourceId;
	
	public WordAdapter(Activity context, ArrayList <Word> word, int colorResourceId) {
		super(context, 0, word);
		mColorResourceId = colorResourceId;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View listItemView = convertView;
		if ( listItemView == null ) {
			listItemView = LayoutInflater.from(getContext()).inflate(
					R.layout.list_item, parent, false);
		}
		// Get the {@link Word} object located at this position in the list
		Word currentWord = getItem(position);
		
		// Find the TextView in the list_item.xml layout with the ID miwok_text_view
		TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
		// Get the miwok word from the current Word object and
		// set this text on the miwok TextView
		miwokTextView.setText(currentWord.getMiwokTranslation());
		
		// Find the TextView in the list_item.xml layout with the ID default_text_view
		TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
		// Get the default word from the current Word object and
		// set this text on the default TextView
		defaultTextView.setText(currentWord.getDefaultTranslation());
		
		// Find the ImageView in the list_item.xml layout with the ID image
		ImageView image = (ImageView) listItemView.findViewById(R.id.image);
		// Get the image resource ID from the current Word object and
		// set the image to iconView
		if ( currentWord.hasImage() ) {
			image.setImageResource(currentWord.getImageResourceId());
			image.setVisibility(View.VISIBLE);
		} else {
			image.setVisibility(View.GONE);
		}
		
		//Set the theme color fot the list item
		View textContainer = listItemView.findViewById(R.id.text_container);
		//Find the color that the resource ID maps to
		int color = ContextCompat.getColor(getContext(), mColorResourceId);
		//Set the background color for the text container view
		textContainer.setBackgroundColor(color);
		
		
		// Return the whole list item layout (containing 2 TextViews)
		// so that it can be shown in the ListView
		return listItemView;
	}
}
