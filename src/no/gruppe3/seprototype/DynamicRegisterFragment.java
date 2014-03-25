package no.gruppe3.seprototype;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager.LayoutParams;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.ToggleButton;

public class DynamicRegisterFragment extends Fragment{

	public final static String FRAGMENT_SET_TIME_MANUALLY = "FRAGMENT_SET_TIME_MANUALLY";
	public final static String FRAGMENT_START_TIME_AUTOMATIC = "FRAGMENT_START_TIME_AUTOMATIC";
	public final static String FRAGMENT_NULL = "FRAGMENT_NULL";
	
	
	RelativeLayout myView;
	boolean isSetTimeManuallyChecked = false;
	boolean parkingButton = false;
	Context parentContext;
	String currentView = FRAGMENT_NULL;
	ToggleButton toggleButton;
	
	public DynamicRegisterFragment() {
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		parentContext = getActivity();
		myView = new RelativeLayout(parentContext);
		
		setGUI();
		
		
		return myView;
	}
	
	private void setGUI() {
		if(isSetTimeManuallyChecked){
			initSetTimeManuallyFragment();
		}else{
			initSimpleStartParkingButton();
		}
	}

	private void initSetTimeManuallyFragment() {
		
		
	}

	private void initSimpleStartParkingButton() {
		
		toggleButton = new ToggleButton(parentContext);
		LayoutParams lp = new LayoutParams();
		if(toggleButton.isSelected()){
			toggleButton.setText(getString(R.string.stop_parking_string));
		}else{
			toggleButton.setText(getString(R.string.start_parking_string));
		}
		toggleButton.setTextOn(getString(R.string.stop_parking_string));
		toggleButton.setTextOff(getString(R.string.start_parking_string));
		myView.addView(toggleButton, lp);

		toggleButton.setBackground(getResources().getDrawable(R.drawable.start_parking_selector));
		
		
		toggleButton.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				
			}
		});
		
	}


	
	
	

	
	
}
