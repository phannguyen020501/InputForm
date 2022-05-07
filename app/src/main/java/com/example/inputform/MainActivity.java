package com.example.inputform;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    EditText mDateFormat;
    EditText editTextMSSV,editTextName, editTextID, editTextPhone, editTextEmail, editTextHometown,
            editTextAddress;
    RadioButton radioButtonKHMT,radioButtonKTMT;
    CheckBox checkbox_c, checkbox_java, checkbox_python, checkbox_c_plus, checkbox_agree;
    Button buttonOk;


    DatePickerDialog.OnDateSetListener onDateSetListener;
    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);


        mDateFormat = findViewById(R.id.dateFormat);

        mDateFormat.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        MainActivity.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        onDateSetListener,  year, month, day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });
        onDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month+ 1;
                String date = day + "/"+ month + "/" + year;
                mDateFormat.setText(date);
            }
        };


        editTextMSSV = findViewById(R.id.editTextMSSV);
        editTextName = findViewById(R.id.editTextName);
        editTextAddress = findViewById(R.id.editTextAddress);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextHometown = findViewById(R.id.editTextHometown);
        editTextPhone = findViewById(R.id.editTextPhone);
        editTextID = findViewById(R.id.editTextID);

        radioButtonKHMT = findViewById(R.id.radioButtonKHMT);
        radioButtonKTMT = findViewById(R.id.radioButtonKTMT);

        checkbox_c = findViewById(R.id.checkbox_c);
        checkbox_c_plus = findViewById(R.id.checkbox_c_plus);
        checkbox_python = findViewById(R.id.checkbox_python);
        checkbox_java = findViewById(R.id.checkbox_java);
        checkbox_agree = findViewById(R.id.checkbox_agree);


        buttonOk = findViewById(R.id.buttonOk);

        checkbox_agree.setOnCheckedChangeListener((compoundButton, b) -> {
            if (checkbox_agree.isChecked()) {
                buttonOk.setClickable(true);
            }
            else {
                buttonOk.setClickable(false);
            }
        });

        buttonOk.setOnClickListener(v -> {
            String mssv = editTextMSSV.getText().toString();
            String name = editTextName.getText().toString();
            String studentID = editTextMSSV.getText().toString();
            String DOB = mDateFormat.getText().toString();
            String phone = editTextPhone.getText().toString();
            String email = editTextEmail.getText().toString();

            if (email.length() == 0 ||
                    mssv.length() == 0 ||name.length() == 0 || studentID.length() == 0
                    || DOB.length() == 0 || phone.length() == 0
                    || (!radioButtonKTMT.isChecked() && !radioButtonKHMT.isChecked() )) {
                Toast.makeText(this, "Please fill out all required fields", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "Success!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}