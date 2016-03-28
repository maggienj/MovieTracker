package mycompany.movietracker;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;


public class MovieList_v1 extends AppCompatActivity {

    ListView list;
    String[] web;
//--    Integer[] imageId;
//--    private TypedArray images;

/*     String[] web = {
            "Google Plus",a
            "Twitter",
            "Windows",
            "Bing",
            "Itunes"


    } ;

*/

    Integer[] imageId = {
            R.drawable.logobulletbig,
            R.drawable.logobulletbig,
            R.drawable.logobulletbig,
            R.drawable.logobulletbig,
            R.drawable.logobulletbig

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movielist_v1);

        web = getResources().getStringArray(R.array.dataelements);
        /* This block was commented and uncommented to try out accepting drawables from arrayitems.xml file
          different patterns were used to try out different methods*/

        // ArrayAdapter<String> adapter;
        // images = getResources().obtainTypedArray(R.array.listbullet).getResourceId(0, 0);
        //--        images = getResources().obtainTypedArray(R.array.listbullet);
        // imageId=getResources().getStringArray(R.array.listbullet)
        //--                for (int i=0; i< images.length(); i++){
        //--                    imageId[i] = images.getResourceId(i,0);
        //--                };
        //imageId = Array[] images;
        //int imageId=images.getResourceId(id,-1);

        CustomList adapter = new CustomList(MovieList_v1.this, web, imageId);
        list = (ListView) findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(MovieList_v1.this, "You Clicked at " + web[+position], Toast.LENGTH_SHORT).show();

            }
        });

    }
}