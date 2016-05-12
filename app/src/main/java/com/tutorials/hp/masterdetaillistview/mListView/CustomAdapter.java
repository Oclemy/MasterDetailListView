package com.tutorials.hp.masterdetaillistview.mListView;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.tutorials.hp.masterdetaillistview.R;
import com.tutorials.hp.masterdetaillistview.mData.SpaceCraft;
import com.tutorials.hp.masterdetaillistview.mDetail.DeatilActivity;

import java.util.ArrayList;

/**
 * Created by Oclemy on 5/11/2016 for ProgrammingWizards Channel and http://www.camposha.com.
 */
public class CustomAdapter extends BaseAdapter {

    Context c;
    ArrayList<SpaceCraft> spaceCrafts;
    LayoutInflater inflater;

    public CustomAdapter(Context c, ArrayList<SpaceCraft> spaceCrafts) {
        this.c = c;
        this.spaceCrafts = spaceCrafts;

        inflater= (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return spaceCrafts.size();
    }

    @Override
    public Object getItem(int position) {
        return spaceCrafts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null)
        {
            convertView=inflater.inflate(R.layout.model,parent,false);
        }

        TextView nameTxt= (TextView) convertView.findViewById(R.id.nameTxt);
        ImageView img= (ImageView) convertView.findViewById(R.id.spacecraftImage);

        final String name=spaceCrafts.get(position).getName();
        final int image=spaceCrafts.get(position).getImage();

        //BIND DATA
        nameTxt.setText(name);
        img.setImageResource(image);

        //ITEMCLICK
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDetailActivity(name,image);
            }
        });

        return convertView;
    }

    //OPEN DETAIL ACTIVITY AND PASS DATA
    private void openDetailActivity(String name,int image)
    {
        Intent i=new Intent(c, DeatilActivity.class);
        //PACK  DATA
        i.putExtra("NAME_KEY",name);
        i.putExtra("IMAGE_KEY",image);

        //open activity
        c.startActivity(i);
    }
}
