package no.gruppe3.seprototype;

import java.util.ArrayList;
import java.util.List;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class CommentsDataSource {

	// Database fields
	private SQLiteDatabase database;
	private MYSQLiteHelper dbHelper;
	private String[] allColumns = { MYSQLiteHelper.COLUMN_ID,
			MYSQLiteHelper.COLUMN_COMMENT };

	public CommentsDataSource(Context context) {
		dbHelper = new MYSQLiteHelper(context);
	}

	public void open() throws SQLException {
		database = dbHelper.getWritableDatabase();
	}

	public void close() {
		dbHelper.close();
	}

	public Comment createComment(String comment) {
		ContentValues values = new ContentValues();
		values.put(MYSQLiteHelper.COLUMN_COMMENT, comment);
		long insertId = database.insert(MYSQLiteHelper.TABLE_COMMENTS, null,
				values);
		Cursor cursor = database.query(MYSQLiteHelper.TABLE_COMMENTS,
				allColumns, MYSQLiteHelper.COLUMN_ID + " = " + insertId, null,
				null, null, null);
		cursor.moveToFirst();
		Comment newComment = cursorToComment(cursor);
		cursor.close();
		return newComment;
	}

	public void deleteComment(Comment comment) {
		long id = comment.getId();
		System.out.println("Comment deleted with id: " + id);
		database.delete(MYSQLiteHelper.TABLE_COMMENTS, MYSQLiteHelper.COLUMN_ID
				+ " = " + id, null);
	}

	public List<Comment> getAllComments() {
		List<Comment> comments = new ArrayList<Comment>();

		Cursor cursor = database.query(MYSQLiteHelper.TABLE_COMMENTS,
				allColumns, null, null, null, null, null);

		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			Comment comment = cursorToComment(cursor);
			comments.add(comment);
			cursor.moveToNext();
		}
		// make sure to close the cursor
		cursor.close();
		return comments;
	}

	private Comment cursorToComment(Cursor cursor) {
		Comment comment = new Comment();
		comment.setId(cursor.getLong(0));
		comment.setComment(cursor.getString(1));
		return comment;
	}
}