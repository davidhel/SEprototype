package no.gruppe3.seprototype;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class RegisterUserActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activitiy_register_user);
	}
	
	public void btnSubmitUser(View view){
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
	}

}
