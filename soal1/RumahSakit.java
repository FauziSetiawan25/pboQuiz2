package quiz2.soal1;
import quiz2.soal1.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class RumahSakit {
    private String name;
    private String address;
    private String noTelp;
    private ArrayList<Dokter> listDokter = new ArrayList<>();
    private HashMap<String, String> listPasien = new HashMap<>();


    public RumahSakit(String nama, String alamat, String noTelepon) {
        this.name = nama;
        this.address = alamat;
        this.noTelp = noTelepon;
    }

    public void cekListDokter() {
        if (listDokter.size() == 0) {
            System.out.println("BELUM ADA DOKTER YANG TERSEDIA SAAT INI");
        } else {
            System.out.println("BERIKUT LIST DOKTER YANG TERSEDIA SAAT INI");
            System.out.println("==========================================");
            for (int i = 0; i < listDokter.size(); i++) {
                System.out.println((i + 1) + ". Nama Dokter : " + getListDokter().get(i).getName() + ", Dokter spesialis : "
                        + getListDokter().get(i).getSpesialis());
            }
        }
    }
    public void cekAntrianPasien(){
        if(listPasien.size() == 0){
            System.out.println("ANTRIAN PASIEN SAAT INI");
            System.out.println("==========================================");
            for (int i = 0; i < listDokter.size(); i++){
                System.out.println("DR. " + listDokter.get(i).getName());
                System.out.println("ANTRIAN KOSONG");
                System.out.println("===============");
            }
        }
    }

    public ArrayList<Dokter> getListDokter() {
        return listDokter;
    }

    public HashMap<String, String> getListPasien() {
        return listPasien;
    }

    public void tambah(Dokter dokter){
        listDokter.add(dokter);
    }
    public void tambah(String Dokter, String Pasien){
        listPasien.put(Dokter,Pasien);
    }
}
