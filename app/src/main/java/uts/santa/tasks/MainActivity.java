package uts.santa.tasks;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import uts.santa.tasks.Adapter.AgendaAdapter;
import uts.santa.tasks.helper.AgendaRepository;
import uts.santa.tasks.model.Agenda;

public class MainActivity extends AppCompatActivity {

    ListView listViewAgenda;
    static ArrayList<Agenda> agendaList = new ArrayList<>();
    static AgendaAdapter adapter;
    FloatingActionButton floatingActionButton;
    static AgendaRepository agendaRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewAgenda = findViewById(R.id.lv_agenda);
        floatingActionButton = findViewById(R.id.fab_tambah);

        agendaRepository = new AgendaRepository(this);


        agendaList = agendaRepository.tampilAgenda();
        adapter = new AgendaAdapter(this, agendaList);
        listViewAgenda.setAdapter(adapter);

        floatingActionButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, TambahActivity.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Perbarui agendaList dan adapter saat kembali ke activity
        agendaList.clear();
        agendaList.addAll(agendaRepository.tampilAgenda()); // Perbaiki kurung tutup
        adapter.notifyDataSetChanged();
    }
}
