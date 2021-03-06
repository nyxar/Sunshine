package com.example.ryan.weatherapp;

/**
 * Created by Ryan on 3/11/2015.
 */

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
public class CustomAdapter extends BaseAdapter{
    WeatherOnDate [] result;
    Context context;
    int [] imageId;
    private static LayoutInflater inflater=null;
    public CustomAdapter(MainActivity mainActivity, WeatherOnDate[] prgmNameList, int[] prgmImages) {
        // TODO Auto-generated constructor stub
        result=prgmNameList;
        context=mainActivity;
        imageId=prgmImages;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return result.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public class Holder
    {
        TextView tv;
        ImageView img;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder=new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.layout, null);
        holder.tv=(TextView) rowView.findViewById(R.id.WeatherInfo);
        holder.img=(ImageView) rowView.findViewById(R.id.icon);
        holder.tv.setText(result[position].toString());
        holder.img.setImageResource(imageId[position]);
        Button moreDeets = (Button) rowView.findViewById(R.id.BtnToClick);
        moreDeets.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(context, MoreDetails.class);
                intent.putExtra("info", getMoreDetails(result[position]));
                context.startActivity(intent);
            }
        });
        return rowView;
    }

    private String getMoreDetails(WeatherOnDate obj)
    {
        return obj.toString() + "\nMin:  " + obj.getMinTemp() +
                "\nMax:  " + obj.getMaxTemp() + "\nEvening:  " +
                obj.getEveTemp() + "\nMorning:  " + obj.getMornTemp() +
                "\nPressure:  " + obj.getPressure();
    }
}
