package com.aa183.safira;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    Spinner addGenre;
    EditText addJudul, addDurasi, addSutradara, addid;
    Button btnadd;
    Button btnview;
    Button btnupdate;
    Button btndelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DatabaseHelper(this);

        addJudul = (EditText)findViewById(R.id.setJudul);
        addDurasi = (EditText)findViewById(R.id.setDurasi);
        addSutradara = (EditText)findViewById(R.id.setSutradara);
        addid = (EditText)findViewById(R.id.setId);
        addGenre = (Spinner)findViewById(R.id.setGenre);
        btnadd = (Button) findViewById(R.id.buttonSimpan);
        btnupdate = (Button) findViewById(R.id.buttonEdit) ;
        btndelete = (Button) findViewById(R.id.buttonDelete) ;
        AddData();
        UpdateData();
        DeleteData();
    }

    public void DeleteData(){
        btndelete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Integer deletedRows = myDb.deleteData(addid.getText().toString());
                        if(deletedRows > 0)
                            Toast.makeText(MainActivity.this,"Data Deleted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MainActivity.this,"Data Not Deleted", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    public void UpdateData(){
        btnupdate.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isUpdated = myDb.updatedata(addid.getText().toString(),
                                addJudul.getText().toString(),
                                addGenre.getSelectedItem().toString(),
                                addDurasi.getText().toString(),
                                addSutradara.getText().toString());
                        if (isUpdated == true)
                            Toast.makeText(MainActivity.this,"Data Updated", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MainActivity.this,"Data Not Updated", Toast.LENGTH_LONG).show();

                    }
                }
        );
    }

    public void AddData(){
        btnadd.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insertData(addJudul.getText().toString(),
                                addGenre.getSelectedItem().toString(),
                                addDurasi.getText().toString(),
                                addSutradara.getText().toString());
                        if (isInserted == true)
                            Toast.makeText(MainActivity.this,"Data Inserted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MainActivity.this,"Data No tInserted", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }



    public void showMassage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

    public void Pindah(View view) {
        Intent intent = new Intent(MainActivity.this, TampilData.class);
        startActivity(intent);
    }
}

