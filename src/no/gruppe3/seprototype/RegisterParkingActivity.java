package no.gruppe3.seprototype;

import java.util.Calendar;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterParkingActivity extends FragmentActivity {

	Button btnPickFromDate;
	boolean isTimeManuallySet;
	DynamicRegisterFragment dynamicFragment;
	Spinner car,city,zone;
	TextView zoneInfo;
	
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
		if (findViewById(R.id.flContainer) != null) {
			dynamicFragment = new DynamicRegisterFragment();
			addDynamicButtonThing();
			isTimeManuallySet = true;
			Calendar c = Calendar.getInstance();
			int year = c.get(Calendar.YEAR);
			int month = c.get(Calendar.MONTH);
			int day = c.get(Calendar.DAY_OF_MONTH);
			
			btnPickFromDate = (Button)findViewById(R.id.btnPickFromDate);
			btnPickFromDate.setAlpha(0);
			btnPickFromDate.setEnabled(true);
			btnPickFromDate.setText(year + "/" + month + "/" + day);
			
			CheckBox checkBox = (CheckBox) findViewById(R.id.cbToggleTimeSettings);
			checkBox.setSelected(isTimeManuallySet);
			checkBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {

				@Override
				public void onCheckedChanged(CompoundButton buttonView,
						boolean isChecked) {
					isTimeManuallySet = isChecked;
					if(isChecked){
						//toast("checked");
						btnPickFromDate.setAlpha(1);
						btnPickFromDate.setEnabled(true);
						getSupportFragmentManager().beginTransaction().remove(dynamicFragment).commit();
						
					}else{
						//toast("unchecked");
						btnPickFromDate.setAlpha(0);
						btnPickFromDate.setEnabled(false);
						addDynamicButtonThing();
						
					}
				}
			});
		}

	}

	private void addDynamicButtonThing() {
		

		dynamicFragment.setArguments(getIntent().getExtras());

		getSupportFragmentManager().beginTransaction().add(
				R.id.flContainer, dynamicFragment).commit();
		
	}

	protected void toast(String string) {
		Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
		
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
			
			
			
			
			
			//Fyller dropdown listene
			addItemsCarSpinner();
			addItemsZoneSpinner();
			addItemsCitySpinner();
			//addListenerOnItemSelection();
			
		}
	}

	private void addItemsCitySpinner() {
		city = (Spinner)findViewById(R.id.sCity);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
				R.array.spinner_city, android.R.layout.simple_spinner_dropdown_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
		city.setAdapter(adapter);
	}

	private void addItemsZoneSpinner() {
		zone = (Spinner)findViewById(R.id.sZoneSpinner);
		
		zoneInfo = (TextView)findViewById(R.id.tvZoneInfoTitle);
		zoneInfo.setText("hei");
		
		
		
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
				R.array.spinner_zone, android.R.layout.simple_spinner_dropdown_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
		zone.setAdapter(adapter);
		zone.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parentView, View selectedItemView,
					int position, long ID) {
				switch(position){
				case 0:
					zoneInfo.setText("20 kr");
					break;
				case 1:
					zoneInfo.setText("22 kr");
					break;
				case 2:
					zoneInfo.setText("25 kr");
					break;
				}
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	private void addItemsCarSpinner() {
		car = (Spinner)findViewById(R.id.sCarSpinner);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
				R.array.spinner_car, android.R.layout.simple_spinner_dropdown_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
		car.setAdapter(adapter);
	}

	public void btnPickFromDate(View view) {
		DialogFragment newFragment = new DatePickerFragment();
		newFragment.show(getFragmentManager(), "datePicker");
	}

	public void setDate(int year, int month, int day) {
		btnPickFromDate = (Button) findViewById(R.id.btnPickFromDate);
		btnPickFromDate.setText(year + "/" + month + "/" + day);
		
		//GET DAY!!!!
	}
}