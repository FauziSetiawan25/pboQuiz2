package quiz2.soal1;

import java.util.ArrayList;
import java.util.Objects;

public class Dokter extends orang{
    private String noSTR;
    private String spesialis;
    public Dokter(String nama, String tanggal_lahir, orang.JENIS_KELAMIN jk, String noSTR, String spesialis){
        super(nama, tanggal_lahir, jk);
        this.noSTR = noSTR;
        this.spesialis = spesialis;
    }

    public void daftar(RumahSakit rumahSakit) {
        if(rumahSakit.getListDokter().size() == 0){
            rumahSakit.tambah(this);
            System.out.println("SUKSES");
        }else{
                if(!super.cekdaftar(rumahSakit)){
                    rumahSakit.tambah(this);
                    System.out.println("SUKSES");
                }else {
                    System.out.println("DOKTER SUDAH TERDAFTAR");
                }
        }
    }
    public String getNoSTR() {
        return noSTR;
    }

    public String getSpesialis() {
        return spesialis;
    }
}

