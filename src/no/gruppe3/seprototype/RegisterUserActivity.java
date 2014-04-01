package no.gruppe3.seprototype;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;

public class RegisterUserActivity extends Activity {
	private CommentsDataSource datasource;
	EditText phone;
	String phoneNumber;
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activitiy_register_user);
		phone = (EditText) findViewById(R.id.etRegPhone);
		
		//Start Database connection
	   // datasource = new CommentsDataSource(this);
	   // datasource.open();
	}

	public void btnSubmitUser(View view) {
		/*ArrayAdapter<Comment> adapter = null;
		Comment comment = null;
		comment = datasource.createComment(phoneNumber);
		adapter.add(comment);*/

		phoneNumber = phone.getText().toString();
		CommentsDataSource cds = new CommentsDataSource(this);
		cds.open();
		cds.createComment(phoneNumber);
		
		
		
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
	}
	
/*	  @Override
	  protected void onResume() {
	    datasource.open();
	    super.onResume();
	  }

	  @Override
	  protected void onPause() {
	    datasource.close();
	    super.onPause();
	  }
*/
}
