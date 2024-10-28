package uts.santa.tasks.model;

public class Agenda {

    private String id;
    private String nama;
    private String deskripsi;
    private String status;

    public Agenda(String id, String nama, String deskripsi, String status) {
        this.id = id;
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public String getStatus() {
        return status;
    }
}
