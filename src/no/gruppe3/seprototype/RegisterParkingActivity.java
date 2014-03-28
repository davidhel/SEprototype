package no.gruppe3.seprototype;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;

public class RegisterParkingActivity extends FragmentActivity{
	
	Button btnPickFromDate;
	
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
	public void btnPickFromDate(View view){
		DialogFragment newFragment = new DatePickerFragment();
		newFragment.show(getFragmentManager(), "datePicker");
	}
	
	public void setDate(int year, int month, int day){
		btnPickFromDate = (Button)findViewById(R.id.btnPickFromDate);
		btnPickFromDate.setText(year + "/" + month + "/" + day);
	}
}