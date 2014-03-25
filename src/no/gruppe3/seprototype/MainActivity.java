package no.gruppe3.seprototype;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import no.gruppe3.seprototype.R;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

	private String username;
	private String password;
	EditText txtPhone;
	EditText txtPassword;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();
	}

	private void init() {
		username = null;
		password = null;

	}

	public void btnSubmit(View view) {
		EditText txtPhone = (EditText) findViewById(R.id.etPhoneNumber);
		EditText txtPassword = (EditText) findViewById(R.id.etPassword);
		username = txtPhone.getText().toString();
		password = txtPassword.getText().toString();

		if (checkUsername(username)) {
			if (checkPassword(password)) {
				Intent intent = new Intent(this, OrderActivity.class);
				startActivity(intent);
			}
		}

	}

	public boolean checkUsername(String username) {
		if (username.equals("1")) {
			return true;
		} else {
			return false;
		}
	}

	private boolean checkPassword(String password) {
		if (password.equals("1")) {
			return true;
		} else {
			return false;
		}

	}

	public void btnRegister(View view) {
		Intent intent = new Intent(this, RegisterUserActivity.class);
		startActivity(intent);
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Intent intent = new Intent(this, ParkingRegisterActivity.class);
		startActivity(intent);
	}
}
