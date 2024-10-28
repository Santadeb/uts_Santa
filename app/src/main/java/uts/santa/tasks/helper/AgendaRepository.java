package uts.santa.tasks.helper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import uts.santa.tasks.model.Agenda;

public class AgendaRepository {

    private DatabaseHelper databaseHelper;

    public AgendaRepository(Context context) {
        databaseHelper = new DatabaseHelper(context);
    }

    public ArrayList<Agenda> tampilAgenda() {
        ArrayList<Agenda> agendaList = new ArrayList<>();
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        Cursor cursor = null;

        try {
            cursor = db.rawQuery("SELECT * FROM agenda", null);
            while (cursor.moveToNext()) {
                agendaList.add(
                        new Agenda(
                                cursor.getString(0),  // ID
                                cursor.getString(1),  // Nama Agenda
                                cursor.getString(2),  // Deskripsi
                                cursor.getString(3)   // Status
                        )
                );
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }

        return agendaList;
    }

    public void tambahAgenda(Agenda agenda) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        String sql = "INSERT INTO agenda (nama_agenda, deskripsi, status) VALUES (?, ?, ?)";
        db.execSQL(sql, new Object[]{agenda.getNama(), agenda.getDeskripsi(), agenda.getStatus()});
    }
}
