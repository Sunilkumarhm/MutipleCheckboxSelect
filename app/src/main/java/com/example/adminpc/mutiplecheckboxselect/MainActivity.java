package com.example.adminpc.mutiplecheckboxselect;

import java.util.ArrayList;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends Activity {
    private ListView listview;
    ArrayList<String> items = new ArrayList<String>();
    private int count;
    private boolean[] thumbnailsselection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fillarray();
        count = items.size();
        thumbnailsselection = new boolean[count];
        listview = (ListView) findViewById(R.id.listView1);
        listview.setAdapter(new ImageAdapter(MainActivity.this));
    }
    private void fillarray() {
        // TODO Auto-generated method stub
        items.clear();
        items.add("Android alpha");
        items.add("Android beta");
        items.add("1.5 Cupcake (API level 3)");
        items.add("1.6 Donut (API level 4)");
        items.add("2.0 Eclair (API level 5)");
        items.add("2.0.1 Eclair (API level 6)");
        items.add("2.1 Eclair (API level 7)");
        items.add("2.2–2.2.3 Froyo (API level 8)");
        items.add("2.3–2.3.2 Gingerbread (API level 9)");
        items.add("2.3.3–2.3.7 Gingerbread (API level 10)");
        items.add("3.0 Honeycomb (API level 11)");
        items.add("3.1 Honeycomb (API level 12)");
        items.add("3.2 Honeycomb (API level 13)");
        items.add("4.0–4.0.2 Ice Cream Sandwich (API level 14)");
        items.add("4.0.3–4.0.4 Ice Cream Sandwich (API level 15)");
        items.add("4.1 Jelly Bean (API level 16)");
        items.add("4.2 Jelly Bean (API level 17)");
        items.add("5.0 Key Lime Pie (API level 18)");
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    public class ImageAdapter extends BaseAdapter {
        private LayoutInflater mInflater;
        private Context mContext;
        public ImageAdapter(Context context) {
            mContext = context;
        }
        public int getCount() {
            return count;
        }
        public Object getItem(int position) {
            return position;
        }
        public long getItemId(int position) {
            return position;
        }
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = LayoutInflater.from(mContext).inflate(
                        R.layout.row_photo, null);
                holder.textview = (TextView) convertView
                        .findViewById(R.id.thumbImage);
                holder.checkbox = (CheckBox) convertView
                        .findViewById(R.id.itemCheckBox);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.checkbox.setId(position);
            holder.textview.setId(position);
            holder.checkbox.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    CheckBox cb = (CheckBox) v;
                    int id = cb.getId();
                    if (thumbnailsselection[id]) {
                        cb.setChecked(false);
                        thumbnailsselection[id] = false;
                    } else {
                        cb.setChecked(true);
                        thumbnailsselection[id] = true;
                    }
                }
            });
            holder.textview.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    int id = v.getId();
                }
            });
            holder.textview.setText(items.get(position));
            holder.checkbox.setChecked(thumbnailsselection[position]);
            holder.id = position;
            return convertView;
        }
    }
    class ViewHolder {
        TextView textview;
        CheckBox checkbox;
        int id;
    }
    public void click(View v) {
        if (v.getId() == R.id.button1) {
            final ArrayList<Integer> posSel = new ArrayList<Integer>();
            posSel.clear();
            boolean noSelect = false;
            for (int i = 0; i < thumbnailsselection.length; i++) {
                if (thumbnailsselection[i] == true) {
                    noSelect = true;
                    Log.e("sel pos thu-->", "" + i);
                    posSel.add(i);
                    // break;
                }
            }
            if (!noSelect) {
                Toast.makeText(MainActivity.this, "Please Select Item!",
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this,
                        "Selected Items:" + posSel.toString(),
                        Toast.LENGTH_LONG).show();
            }
        }
    }
}