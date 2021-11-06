package com.example.logbookrentalz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText property, datetime, price, note, reporter;
    Spinner spinnerBedroom, spinnerFurniture;
    Button submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        property = findViewById(R.id.property);
        datetime = findViewById(R.id.datetime);
        price = findViewById(R.id.price);
        note = findViewById(R.id.note);
        reporter = findViewById(R.id.reporter);
        submit = findViewById(R.id.submit);

        spinnerBedroom = (Spinner)findViewById(R.id.spinnerBedroom);
    //Tạo danh sách phòng
        ArrayList<String> arrayBedroom = new ArrayList<String>();
        arrayBedroom.add("Single Room");
        arrayBedroom.add("Double Room");
        arrayBedroom.add("Triple Room");
        arrayBedroom.add("King Room");
        arrayBedroom.add("President Room");
        arrayBedroom.add("Apartment");
    //Hiển thị Dropdown List
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,arrayBedroom);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // Tạo khoảng trống giữa các đối items Spinner
        spinnerBedroom.setAdapter(arrayAdapter);
    //Xử lý khi click vào các items trong spinner
        spinnerBedroom.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, arrayBedroom.get(i), Toast.LENGTH_SHORT).show();
            }
        });


        spinnerFurniture = (Spinner)findViewById(R.id.spinnerFurniture);

        ArrayList<String> arrayFurniture = new ArrayList<String>();
        arrayFurniture.add("Classic");
        arrayFurniture.add("NeoClassic");
        arrayFurniture.add("Modern");
        arrayFurniture.add("Indochina Style");


        ArrayAdapter arrayAdapterFur = new ArrayAdapter(this, android.R.layout.simple_spinner_item,arrayFurniture);
        arrayAdapterFur.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFurniture.setAdapter(arrayAdapterFur);

        spinnerFurniture.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, arrayFurniture.get(i), Toast.LENGTH_SHORT).show();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String propertyText = property.getText().toString();
                String bedroomText = spinnerBedroom.toString();
                String datetimeText = datetime.getText().toString();
                String priceText = price.getText().toString();
                String furnitureText = spinnerFurniture.toString();
                String noteText = note.getText().toString();
                String reporterText = reporter.getText().toString();


                if (!propertyText.isEmpty() & !bedroomText.isEmpty() & !datetimeText.isEmpty() &
                    !priceText.isEmpty() & !furnitureText.isEmpty() & !reporterText.isEmpty()){
                    Toast.makeText(MainActivity.this, "Inserted Successfully !!!", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Please Insert Inputs !!!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}