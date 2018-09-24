/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asis3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import asis3.student;
import asis3.demo;

/**
 *
 * @author biobii
 */
public class object {
    
    public static void main(String[] args) {
        String fileName = "mahasiswa.ser";
        String nim, nama, asal, kelas, isExit;
        String choice;
        
        boolean exit = false;
        
        List<student> mahasiswa = new ArrayList<student>();
        demo demo = new demo();
        
        while (!exit) {
            System.out.println("\n==== PILIH AKSI ===");
            System.out.println("1 masukkan");
            System.out.println("2 perbaharui");
            System.out.println("3 hapus");
            System.out.println("4 cetak");
            System.out.println("5 simpan");
            System.out.println("6 keluar");
            
            Scanner scan = new Scanner(System.in);
            System.out.print("\nPilih (angka) --> ");
            choice = scan.nextLine();
            System.out.println("");
            
            switch (choice) {
                case "1":
                    System.out.println("==== MASUKKAN DATA ===");
                    System.out.print("NIM\t: ");
                    nim = scan.nextLine();

                    System.out.print("Nama\t: ");
                    nama = scan.nextLine();

                    System.out.print("Asal\t: ");
                    asal = scan.nextLine();

                    System.out.print("Kelas\t: ");
                    kelas = scan.nextLine();
                    
                    mahasiswa.add(new student(nim, nama, asal, kelas));
                    break;
                    
                case "2":
                    System.out.print("NIM yg mau diupdate:\t");
                    String updateTarget = scan.nextLine();
                    
                    for (int i = 0; i < mahasiswa.size(); i++) {
                        if (mahasiswa.get(i).getNim().equalsIgnoreCase(updateTarget)) {
                            System.out.println("==== MASUKKAN DATA BARU ===");
                            System.out.print("NIM\t: ");
                            nim = scan.nextLine();

                            System.out.print("Nama\t: ");
                            nama = scan.nextLine();

                            System.out.print("Asal\t: ");
                            asal = scan.nextLine();

                            System.out.print("Kelas\t: ");
                            kelas = scan.nextLine();
                            
                            mahasiswa.set(i, new student(nim, nama, asal, kelas));
                            System.out.println("Data sudah disimpan.");
                            break;
                        }
                    }
                    break;
                    
                case "3":
                    System.out.print("NIM yang akan dihapus:\t");
                    String deleteTarget = scan.nextLine();
                    
                    for (int i = 0; i < mahasiswa.size(); i++) {
                        if (mahasiswa.get(i).getNim().equalsIgnoreCase(deleteTarget)) {
                            mahasiswa.remove(i);
                            System.out.println("data sudah dihapus.");
                            break;
                        }
                    }
                    break;
                    
                case "4":
                    List<student> newList = demo.deserialize(fileName);
                    System.out.println("Mahasiswa: " + newList);
                    break;
                    
                case "5":
                    demo.serialize(mahasiswa, fileName);
                    System.out.println("Serialization selesai!");
                    break;
                    
                case "6":
                    System.out.print("\nExit program (Y/N) ? ");
                    isExit = scan.nextLine();
                    System.out.println("");

                    if (isExit.equalsIgnoreCase("Y")) {
                        exit = true;
                    }
                    break;
                default:
                    System.out.println("Pilihan tidak benar!");
            }
        }
    }
    
}
