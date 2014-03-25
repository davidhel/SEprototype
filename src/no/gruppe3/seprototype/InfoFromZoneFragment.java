package no.gruppe3.seprototype;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class InfoFromZoneFragment extends Fragment{

	Spinner zoneSpinner;
	TextView zonePricePerHour, zoneInfoTitle;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_zone_information, container, false);
	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		
		zoneSpinner = (Spinner)getActivity().findViewById(R.id.sZoneSpinner);
		zonePricePerHour = (TextView)getActivity().findViewById(R.id.tvZoneInformation);		
		zoneInfoTitle = (TextView)getActivity().findViewById(R.id.tvZoneInfoTitle);
		zonePricePerHour.setAlpha(0);
		zonePricePerHour.setAlpha(0);
		
	}
	
	


	
	
}
