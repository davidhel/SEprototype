package no.gruppe3.seprototype;

import java.util.List;
import java.util.Random;

import no.gruppe3.seprototype.R;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;

public class TestDatabaseActivity extends ListActivity {
	private static final String TAG = "TAG";
	private CommentsDataSource datasource;
	EditText etNavn;
	Comment comment;
	String comments;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.database_test);

		etNavn = (EditText) findViewById(R.id.etNavn);

		datasource = new CommentsDataSource(this);
		datasource.open();

		List<Comment> values = datasource.getAllComments();

		// use the SimpleCursorAdapter to show the
		// elements in a ListView
		ArrayAdapter<Comment> adapter = new ArrayAdapter<Comment>(this,
				android.R.layout.simple_list_item_1, values);
		setListAdapter(adapter);
	}

	// Will be called via the onClick attribute
	// of the buttons in database_test.xml
	public void onClick(View view) {
		@SuppressWarnings("unchecked")
		ArrayAdapter<Comment> adapter = (ArrayAdapter<Comment>) getListAdapter();
		
		switch (view.getId()) {
		case R.id.add:
			String comments = etNavn.getText().toString();
			inputDatabase(comments);
	/*		int nextInt = new Random().nextInt(3);
			// save the new comment to the database
			comment = datasource.createComment(komments);
			adapter.add(comment);*/
			break;
		case R.id.delete:
			if (getListAdapter().getCount() > 0) {
				comment = (Comment) getListAdapter().getItem(0);
				datasource.deleteComment(comment);
				adapter.remove(comment);
			}
			break;
		}
		adapter.notifyDataSetChanged();
	}

	public void inputDatabase(String input) {
		Log.d(TAG, "inputDatabase");
		@SuppressWarnings("unchecked")
		ArrayAdapter<Comment> adapter = (ArrayAdapter<Comment>) getListAdapter();
		String komments = input;
	//	int nextInt = new Random().nextInt(3);
		// save the new comment to the database
		Log.d(TAG, "jallajalla");
		comment = datasource.createComment(komments);
		adapter.add(comment);
		//adapter.notifyDataSetChanged();

	}

	@Override
	protected void onResume() {
		datasource.open();
		super.onResume();
	}

	@Override
	protected void onPause() {
		datasource.close();
		super.onPause();
	}

}