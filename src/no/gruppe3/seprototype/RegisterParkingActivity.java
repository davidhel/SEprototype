package no.gruppe3.seprototype;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class RegisterParkingActivity extends FragmentActivity {

	Button btnPickFromDate;
	boolean isTimeManuallySet = false;

	
	@Override
	protected void onCreate(Bundle savedInstanceBundle) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceBundle);
		setContentView(R.layout.fragment_container_parking);
		if (savedInstanceBundle != null) {
			return;
		}
		setGUI();

	}

	private void initDynamicFragment() {
		if (findViewById(R.id.dynamic_register_fragment) != null) {
			final DynamicRegisterFragment dynamicFragment = new DynamicRegisterFragment();

			dynamicFragment.setArguments(getIntent().getExtras());

			getSupportFragmentManager().beginTransaction().add(
					R.id.dynamic_register_fragment, dynamicFragment);

			CheckBox checkBox = (CheckBox) findViewById(R.id.cbToggleTimeSettings);
			checkBox.setSelected(isTimeManuallySet);
			checkBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {

				@Override
				public void onCheckedChanged(CompoundButton buttonView,
						boolean isChecked) {
					isTimeManuallySet = isChecked;
					if(isChecked){
						getSupportFragmentManager().beginTransaction().replace(R.id.dynamic_register_manually, dynamicFragment);
					}else{
						getSupportFragmentManager().beginTransaction().replace(R.id.dynamic_register_fragment, dynamicFragment);
					}
				}
			});
		}

	}

	protected void setGUI() {

		initBasicFragment();
		initDynamicFragment();

	}

	private void initBasicFragment() {
		if (findViewById(R.id.basic_register_fragment) != null) {

			BasicRegisterInfoFragment basicFragment = new BasicRegisterInfoFragment();

			basicFragment.setArguments(getIntent().getExtras());

			getSupportFragmentManager().beginTransaction().add(
					R.id.basic_register_fragment, basicFragment);

		}

	}

	public void btnPickFromDate(View view) {
		DialogFragment newFragment = new DatePickerFragment();
		newFragment.show(getFragmentManager(), "datePicker");
	}

	public void setDate(int year, int month, int day) {
		btnPickFromDate = (Button) findViewById(R.id.btnPickFromDate);
		btnPickFromDate.setText(year + "/" + month + "/" + day);
	}
}