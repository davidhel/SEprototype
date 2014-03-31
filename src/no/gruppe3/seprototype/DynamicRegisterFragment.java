package no.gruppe3.seprototype;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager.LayoutParams;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.ToggleButton;

public class DynamicRegisterFragment extends Fragment{ 

	public final static String FRAGMENT_SET_TIME_MANUALLY = "FRAGMENT_SET_TIME_MANUALLY";
	public final static String FRAGMENT_START_TIME_AUTOMATIC = "FRAGMENT_START_TIME_AUTOMATIC";
	public final static String FRAGMENT_NULL = "FRAGMENT_NULL";
	private static final int NOTIFICATION_ID = 86546512;
	
	
	RelativeLayout myView;
	boolean isSetTimeManuallyChecked = false;
	boolean parkingButton = false;
	Context parentContext;
	String currentView = FRAGMENT_NULL;
	ToggleButton toggleButton;
	Notification.Builder noti;
	NotificationManager notimanager;
	Spinner fromDate, toDate, fromTime, toTime;
	
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
		initSimpleStartParkingButton();
		
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
				if(isChecked){
					createNotification();
				}	
				if(!isChecked){
					cancelNotification();
				}
			}
		});
		
	}
	
	protected void cancelNotification() {
		notimanager.cancel(NOTIFICATION_ID);
	}

	public void createNotification() {
		Intent intent = new Intent(getActivity(), MainActivity.class);
		PendingIntent pIntent = PendingIntent.getActivity(getActivity(), 0, intent, 0);

		noti = new Notification.Builder(getActivity())
				.setContentTitle("Parkering")
				.setContentText("Subject").setSmallIcon(R.drawable.ic_launcher)
				.setContentIntent(pIntent)
				.setOngoing(true)
				.addAction(R.drawable.ic_launcher, "Pris", pIntent)
				.addAction(R.drawable.ic_launcher, "Sone", pIntent)
				.addAction(R.drawable.ic_launcher, "Tid", pIntent);
		notimanager = (NotificationManager) getActivity().getSystemService(Context.NOTIFICATION_SERVICE);
		
	    notimanager.notify(NOTIFICATION_ID, noti.build());

	}
	
}
