package model;

import java.util.List;
import org.apache.ibatis.annotations.*;

public interface KurirMapper {

    // CREATE: Menambahkan data baru ke tabel kurir
    @Insert("INSERT INTO kurir (idKurir, namaKurir, jenisKelamin, tanggalLahir, noHP, alamat, image) VALUES (#{idKurir}, #{namaKurir}, #{jenisKelamin}, #{tanggalLahir}, #{noHP}, #{alamat}, #{image})")
    void insertKurir(Kurir kurir);

    // READ: Mengambil semua data dari tabel kurir
    @Select("SELECT * FROM kurir")
    List<Kurir> getAllKurir();

    // READ: Mengambil data kurir berdasarkan ID
    @Select("SELECT * FROM kurir WHERE idKurir = #{idKurir}")
    Kurir getKurirById(@Param("idKurir") int idKurir);

    // UPDATE: Memperbarui data kurir berdasarkan ID
    @Update("UPDATE kurir SET namaKurir = #{namaKurir}, jenisKelamin = #{jenisKelamin}, tanggalLahir = #{tanggalLahir}, noHP = #{noHP}, alamat = #{alamat}, image = #{image} WHERE idKurir = #{idKurir}")
    void updateKurir(Kurir kurir);

    // DELETE: Menghapus data kurir berdasarkan ID
    @Delete("DELETE FROM kurir WHERE idKurir = #{idKurir}")
    void deleteKurir(@Param("idKurir") int idKurir);
}