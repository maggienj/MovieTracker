package mycompany.movietracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ImageTextListViewActivity extends Activity implements AdapterView.OnItemClickListener {


    public static final Integer[] images = {R.drawable.proposal,
            R.drawable.bat, R.drawable.alvin, R.drawable.myb, R.drawable.kapoor};

    ListView listView;
    List<RowItem> rowItems;
    String[] movieName;
    String[] movieWhen;
    String[] movieWhere;


    // List<HashMap<String, String>> fillMaps = new ArrayList<HashMap<String, String>>();
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_list_activity);


        movieName = getResources().getStringArray(R.array.movieName);
        movieWhen = getResources().getStringArray(R.array.movieWhen);
        movieWhere = getResources().getStringArray(R.array.movieWhere);

        rowItems = new ArrayList<RowItem>();
        for (int i = 0; i < movieName.length; i++) {
            RowItem item = new RowItem(images[i], movieName[i], movieWhen[i], movieWhere[i]);
            rowItems.add(item);

        }

        listView = (ListView) findViewById(R.id.list);
        CustomListViewAdapter adapter = new CustomListViewAdapter(this,
                R.layout.list_item, rowItems);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(this);


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long rowId) {
//        String selection = (String) parent.getItemAtPosition(position);

        Long itemIdLng = parent.getItemIdAtPosition(position);
        int movieId = itemIdLng.intValue();
        int pos = -1;
        System.out.println("Position " + movieId); //check it now in Logcat
        // Create an intent
        Intent intent = new Intent(this, ItemDetail.class);
        intent.putExtra("movieId", movieId);
        intent.putExtra("movieType", "btn1");
        // Start sms details activity
        startActivity(intent);


        //      for (int i = 0; i < movieName.length; i++) {
        //         if (movieName[i].equals(selection)) {
        //            pos = i;
        //            break;
        //        }
        //   }
        // System.out.println("Position " + pos); //check it now in Logcat
    }


    public void onClickHome(View arg0) {
        Intent intent = new Intent(ImageTextListViewActivity.this, Category.class);
        startActivity(intent);
        finish();
    }

}