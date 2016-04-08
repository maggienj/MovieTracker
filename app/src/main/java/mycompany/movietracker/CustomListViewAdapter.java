package mycompany.movietracker;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomListViewAdapter extends ArrayAdapter<RowItem> {

    Context context;


    Point size;
    int width, height;
    float txtsize;

    public CustomListViewAdapter(Context context, int resourceId,
                                 List<RowItem> items) {
        super(context, resourceId, items);
        this.context = context;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        RowItem rowItem = getItem(position);

        LayoutInflater mInflater = (LayoutInflater) context
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.list_item, null);
            holder = new ViewHolder();
            holder.txtMovieName = (TextView) convertView.findViewById(R.id.movieName);
            holder.txtMovieWhen = (TextView) convertView.findViewById(R.id.movieWhen);
            holder.txtMovieWhere = (TextView) convertView.findViewById(R.id.movieWhere);

            holder.imageView = (ImageView) convertView.findViewById(R.id.icon);
            convertView.setTag(holder);
        } else
            holder = (ViewHolder) convertView.getTag();

        holder.txtMovieName.setText(rowItem.getMovieName());
        holder.txtMovieWhen.setText("watched on " + rowItem.getMovieWhen());
        holder.txtMovieWhere.setText("watched in " + rowItem.getMovieWhere());
        holder.imageView.setImageResource(rowItem.getImageId());

        Bitmap bitmapImage_movie = BitmapFactory.decodeResource(context.getResources(), rowItem.getImageId());
        int nh_movie = (int) (bitmapImage_movie.getHeight() * (1000.0 / bitmapImage_movie.getWidth()));
        Bitmap scaled_movie = Bitmap.createScaledBitmap(bitmapImage_movie, 1000, nh_movie, true);
        // ImageView ImgView1 = (ImageView) findViewById(R.id.icon);
        holder.imageView.setImageBitmap(scaled_movie);
        // ImgView1.setImageBitmap(scaled_title1);

        //Display metrics = Context.DISPLAY_SERVICE .getSystem().getDisplayMetrics();
        // Display display = context.getWindowManager().getDefaultDisplay();
        // size = new Point();
        // display.getSize(size);
        // width = size.x;
        // height = size.y;
        txtsize = height * 0.024f;

        // context = context.getBaseContext();
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        width = displayMetrics.widthPixels;
        height = displayMetrics.heightPixels;
        txtsize = height * 0.024f;

        // TextView txtMovieNameSz = (TextView) findViewById(R.id.movieName);
        // TextView txtMovieWhenSz = (TextView) findViewById(R.id.movieWhen);
        holder.txtMovieName.setTextSize(txtsize);
        holder.txtMovieWhen.setTextSize(txtsize);
        holder.txtMovieWhere.setTextSize(txtsize);

        return convertView;
    }

    @Override
    public boolean isEnabled(int position) {
        return true;
    }

    /*private view holder class*/
    private class ViewHolder {
        ImageView imageView;
        TextView txtMovieName;
        TextView txtMovieWhen;
        TextView txtMovieWhere;
    }

}