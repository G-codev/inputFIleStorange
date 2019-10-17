package com.gustiramadhan.latihanstorage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class InternalActivity extends AppCompatActivity implements View.OnClickListener{

    public  static  final String FILENAME = "namafile.txt";
    Button buatFile,bacaFile,ubahFile,deleteFile;
    TextView textBaca;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal);
        buatFile = findViewById(R.id.buttonBuatFile);
        ubahFile = findViewById(R.id.buttonUbahFile);
        bacaFile = findViewById(R.id.buttonBacaFile);
        deleteFile = findViewById(R.id.buttonHapusFIle);
        textBaca = findViewById(R.id.textBaca);

        buatFile.setOnClickListener(this);
        ubahFile.setOnClickListener(this);
        bacaFile.setOnClickListener(this);
        deleteFile.setOnClickListener(this);


    }
    void buatFile(){
            String isiFile = "Coba isi Data File Text";
            File file = new File(getFilesDir(), FILENAME);

        FileOutputStream outputStream = null;
        try{
            file.createNewFile();
            outputStream = new FileOutputStream(file, true);
            outputStream.write(isiFile.getBytes());
            outputStream.flush();
            outputStream.close();
        }
        catch (Exception e){
            e.printStackTrace();

        }
    }

    void ubahFile(){
        String ubah = "Update isi Data File Text";
        File file =new File(getFilesDir(), FILENAME);
        FileOutputStream outputStream = null;

        try {
            file.createNewFile();
            outputStream = new FileOutputStream(file, false);
            outputStream.write(ubah.getBytes());
            outputStream.flush();
            outputStream.close();
        }
        catch (Exception e){
            e.printStackTrace();

        }
    }
    void bacaFile(){
        File sdcard = getFilesDir();
        File file = new File(sdcard, FILENAME);

        if(file.exists()){
            StringBuilder text = new StringBuilder();
            try{
                BufferedReader br =  new BufferedReader(new FileReader(file));
                String line = br.readLine();
                while (line !=null){
                    text.append(line);
                    line=br.readLine();
                }
                br.close();
            }
            catch (IOException ex){
                System.out.println("Error" + ex.getMessage());
            }
            textBaca.setText(text.toString());
        }
    }
    void hapusFile(){
        File file =new File(getFilesDir(), FILENAME);
        if (file.exists()){
            file.delete();
        }
    }
    public void jalankanPerintah(int id){
        switch(id){
            case R.id.buttonBuatFile:
                buatFile();
            break;
            case R.id.buttonUbahFile:
                ubahFile();
            break;
            case R.id.buttonBacaFile:
                bacaFile();
            break;
            case R.id.buttonHapusFIle:
                hapusFile();
            break;
        }
    }
    @Override
    public void onClick(View view) {
    jalankanPerintah(view.getId());
    }
}
