package com.slavyanin.example.checkpoint.checkpoint2;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.slavyanin.example.checkpoint.R;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends ArrayAdapter<AutoEntity> {

    private static final List<AutoEntity> autoArray = new ArrayList<AutoEntity>();

    static {
        autoArray.add(new AutoEntity(R.mipmap.ic_launcher, "Иванов Иван", "BH0132TC"));
        autoArray.add(new AutoEntity(R.mipmap.ic_launcher, "Петров Петр", "BH6835ЕХ"));
        autoArray.add(new AutoEntity(R.mipmap.ic_launcher, "Сидоров Сидр", "BH2893ВС"));
    }

    private final Context context;

    public Adapter(Context context) {
        super(context, R.layout.list_auto, autoArray);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;
        AutoEntity auto = getItem(position);

        if (convertView == null) {

            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.list_auto, null);

            holder = new ViewHolder();
            holder.txtNumber = (TextView) convertView.findViewById(R.id.text_number);
            holder.txtFio = (TextView) convertView.findViewById(R.id.fio);
            holder.imageView = (ImageView) convertView.findViewById(R.id.icon_auto);

            convertView.setTag(holder);

        } else
            holder = (ViewHolder) convertView.getTag();

        holder.txtFio.setText(auto.getName());
        holder.txtNumber.setText(auto.getNumber());
        holder.imageView.setImageResource(R.mipmap.ic_launcher);

        return convertView;
    }

    public void remove(int position) {
        autoArray.remove(position);
    }

    public String getName(int position) {
        AutoEntity auto = getItem(position);
        return auto.getName();
    }

    public String getNumber(int position) {
        AutoEntity auto = getItem(position);
        return auto.getNumber();
    }

    public void setName(int position, String name) {
        AutoEntity auto = getItem(position);
        auto.setName(name);
    }

    public void setNumber(int position, String name) {
        AutoEntity auto = getItem(position);
        auto.setNumber(name);
    }

    private class ViewHolder{
        TextView txtFio;
        TextView txtNumber;
        ImageView imageView;
    }
}
