package no.gruppe3.seprototype;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class ParkingRegisterActivity extends FragmentActivity{

	
	@Override
	protected void onCreate(Bundle savedInstanceBundle) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceBundle);
		setContentView(R.layout.fragment_container_parking);
		if(savedInstanceBundle != null){
			return;
		}
		initBasicFragment();
		initDynamicFragment();

	}

	private void initDynamicFragment() {
		if(findViewById(R.id.dynamic_register_fragment) != null){
			DynamicRegisterFragment dynamicFragment = new DynamicRegisterFragment();
			
			dynamicFragment.setArguments(getIntent().getExtras());
			
			getSupportFragmentManager().beginTransaction().add(R.id.dynamic_register_fragment, dynamicFragment);
		}
		
	}

	private void initBasicFragment() {
		if(findViewById(R.id.basic_register_fragment) != null){
			
			
			BasicRegisterInfoFragment basicFragment = new BasicRegisterInfoFragment();
			
			basicFragment.setArguments(getIntent().getExtras());
			
			getSupportFragmentManager().beginTransaction().add(R.id.basic_register_fragment, basicFragment);
			
		}
		
	}
	
	
	

}