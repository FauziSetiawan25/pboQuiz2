package quiz2.soal1;

public class Pasien extends orang{
    private String pekerjaan, domisili;

    public Pasien(String nama, String tanggal_lahir, orang.JENIS_KELAMIN jk, String pekerjaan, String domisili){
        super(nama, tanggal_lahir, jk);
        this.pekerjaan = pekerjaan;
        this.domisili = domisili;
    }

    public void daftar(RumahSakit rumahSakit, String penyakit, String namaDokter, orang.tipePasien tipe){
        if(super.cekdaftar(rumahSakit, namaDokter)&&!super.cekPas(rumahSakit, getName())){
            System.out.println("SUKSES");
            rumahSakit.tambah(namaDokter, getName());
        }else System.out.println("not");
    }
}
