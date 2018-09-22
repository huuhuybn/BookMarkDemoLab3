package vn.edu.poly.myapplication;

import android.database.Cursor;
import android.provider.Browser;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showBookmark();


    }

    private void showBookmark() {

        String[] projection = new String[]{
                Browser.BookmarkColumns.TITLE,
                Browser.BookmarkColumns.URL
        };

        String result = "";

        Cursor cursor = getContentResolver().query(Browser.BOOKMARKS_URI, projection,
                null, null, null);
        
        cursor.moveToFirst();

        Log.e("SIZE", cursor.getCount() + "");
        while (cursor != null && !cursor.isAfterLast()) {

            String title = cursor.getString(cursor.getColumnIndex(Browser.BookmarkColumns.TITLE));

            String bookmark = cursor.getString(cursor.getColumnIndex(Browser.BookmarkColumns.URL));

            Log.e("BOOK", bookmark);

            result = result + title + " /n " + bookmark + " /n ";
            cursor.moveToNext();
        }

        cursor.close();
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();

    }


}
