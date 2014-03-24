package no.gruppe3.seprototype;


import no.gruppe3.seprototype.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity{
	
	private String username = null;
	private String password = null;
	EditText txtPhone = (EditText)findViewById(R.id.etPhoneNumber);
	EditText txtPassword = (EditText)findViewById(R.id.etPassword);
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	public void btnSubmit(View view){
		username = txtPhone.toString();
		password = txtPassword.toString();
		checkUsername(username);
		checkPassword(password);
		Intent intent = new Intent(this, OrderActivity.class);
		startActivity(intent);
	}
	
	private void checkUsername(String username) {
		// TODO Auto-generated method stub
		
	}
	
	private void checkPassword(String password) {
		// TODO Auto-generated method stub
		
	}
	
}
