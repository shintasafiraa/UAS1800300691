package com.aa183.safira;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class RecordListAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<Model> recordList;

    public RecordListAdapter(Context context, int layout, ArrayList<Model> recordList) {
        this.context = context;
        this.layout = layout;
        this.recordList = recordList;
    }

    @Override
    public int getCount() {
        return recordList.size();
    }

    @Override
    public Object getItem(int position) {
        return recordList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder{
        TextView txtId, txtName, txtGenre, txtDurasi, txtSutradara;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;
        ViewHolder holder = new ViewHolder();

        if (row==null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layout, null);
            holder.txtId = row.findViewById(R.id.txtId);
            holder.txtName = row.findViewById(R.id.txtName);
            holder.txtGenre = row.findViewById(R.id.txtGenre);
            holder.txtDurasi = row.findViewById(R.id.txtDurasi);
            holder.txtSutradara = row.findViewById(R.id.txtSutradara);
            row.setTag(holder);
        }
        else {
            holder = (ViewHolder)row.getTag();
        }

        Model model = recordList.get(position);
        holder.txtId.setText(model.getId());
        holder.txtName.setText(model.getName());
        holder.txtGenre.setText(model.getGenre());
        holder.txtDurasi.setText(model.getDurasi());
        holder.txtSutradara.setText(model.getSutradara());
        return row;

    }

}
