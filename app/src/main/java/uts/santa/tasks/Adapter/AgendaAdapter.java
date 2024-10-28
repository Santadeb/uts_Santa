package uts.santa.tasks.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import java.util.ArrayList;
import uts.santa.tasks.R;
import uts.santa.tasks.model.Agenda;

public class AgendaAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Agenda> agendaList;
    private LayoutInflater inflater;

    public AgendaAdapter(Context context, ArrayList<Agenda> agendaList) {
        this.context = context;
        this.agendaList = agendaList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return agendaList.size();
    }

    @Override
    public Object getItem(int position) {
        return agendaList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.agenda, parent, false);
        }

        // Mengambil data agenda berdasarkan posisi
        Agenda agenda = agendaList.get(position);

        // Inisialisasi elemen-elemen UI dari CardView
        TextView tvAgenda = convertView.findViewById(R.id.tv_Agenda);
        TextView tvDeskripsi = convertView.findViewById(R.id.tv_deskripsi);
        TextView tvStatus = convertView.findViewById(R.id.tv_status);
        CardView cardView = convertView.findViewById(R.id.cv_agenda);


        tvAgenda.setText(agenda.getNama());
        tvDeskripsi.setText(agenda.getDeskripsi());
        tvStatus.setText(agenda.getStatus());


        if ("Selesai".equals(agenda.getStatus())) {
            tvStatus.setTextColor(Color.GREEN);
        } else {
            tvStatus.setTextColor(Color.RED);
        }

        return convertView;
    }
}
