package quiz2.soal1;

import Pertemuan7.Toko;

import java.util.HashMap;
import java.util.Objects;

public abstract class orang {
    private String name;
    private String dateofBirth;
    enum JENIS_KELAMIN{
        LAKI_LAKI,
        PEREMPUAN
    }
    JENIS_KELAMIN jenisKelamin;
    enum tipePasien{
        MANDIRI
    }
    tipePasien Tipepasien;
    public orang(String nama, String tanggal_lahir, orang.JENIS_KELAMIN jk){
        this.name = nama;
        this.dateofBirth = tanggal_lahir;
        this.jenisKelamin = jk;
    }
    public boolean cekdaftar(RumahSakit rumahSakit) {
        Boolean ada = false;
        for (int i = 0; i < rumahSakit.getListDokter().size(); i++){
            if (Objects.equals(rumahSakit.getListDokter().get(i).getName(), getName())) {
                ada = true;
            }
        }
        return ada;
    }
    public boolean cekdaftar(RumahSakit rumahSakit, String namadokter) {
        Boolean ada = false;
        for (int i = 0; i < rumahSakit.getListDokter().size(); i++){
            if (Objects.equals(rumahSakit.getListDokter().get(i).getName(), namadokter)) {
                ada = true;
            }
        }
        return ada;
    }
    public boolean cekPas(RumahSakit rumahSakit, String namaPas){
        Boolean ada = false;
        for (HashMap.Entry<String, String > entry: rumahSakit.getListPasien().entrySet()){
            if (Objects.equals(entry.getValue(), namaPas)) {
                ada = true;
            }
        }
        return ada;
    }

    public String getName() {
        return name;
    }

    public String getDateofBirth() {
        return dateofBirth;
    }

    public JENIS_KELAMIN getJenisKelamin() {
        return jenisKelamin;
    }
}
