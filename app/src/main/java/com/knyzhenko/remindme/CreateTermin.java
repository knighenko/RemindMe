package com.knyzhenko.remindme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.knyzhenko.remindme.database.DBHelper;
import com.knyzhenko.remindme.tabs.Past;

public class CreateTermin extends AppCompatActivity {
    private int count;
    private Button buttonNext;
    private Button buttonPrevious;
    private TextView textViewTitle;
    private TextView textViewDescription;
    private TextView textViewCategory;
    private TextView textViewImportance;
    private TextView textViewDate;
    private TextView textViewTime;
    private EditText editTextTitle;
    private EditText editTextDescription;
    private Spinner spinnerCategory;
    private Spinner spinnerImportance;
    private DatePicker datePicker;
    private TimePicker timePicker;
    private TextView textViewAllInformation;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_termin);
        initForms();
        buttonNext.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (count < 5) count++;
                setView(count);
                if (count > 0) {
                    buttonPrevious.setEnabled(true);
                } else if (count == 0) {
                    buttonPrevious.setEnabled(false);
                }

                // Code here executes on main thread after user presses button
            }
        });

        buttonPrevious.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if (count > 0) {
                    --count;
                    setView(count);
                    if (count == 0) v.setEnabled(false);
                }


            }
        });
    }

    private void initForms() {
        buttonNext = findViewById(R.id.btnNextNewTermin);
        buttonPrevious = findViewById(R.id.btnPreviousNewTermin);
        textViewTitle = findViewById(R.id.textViewTitleTermin);
        textViewDescription = findViewById(R.id.textViewDescription);
        editTextTitle = findViewById(R.id.editTextTitle);
        editTextDescription = findViewById(R.id.editTextDescription);
        textViewCategory = findViewById(R.id.textViewCategory);
        textViewImportance = findViewById(R.id.textViewImportance);
        spinnerCategory = findViewById(R.id.spinnerCategory);
        spinnerImportance = findViewById(R.id.spinnerImportance);
        textViewDate = findViewById(R.id.textViewDate);
        datePicker = findViewById(R.id.dataPicker);
        textViewTime = findViewById(R.id.textViewTime);
        timePicker = findViewById(R.id.timePicker);
        timePicker.setIs24HourView(true);
        textViewAllInformation = findViewById(R.id.textViewAllInformation);
    }

    private void setView(int count) {
        switch (count) {
            case 0:
                textViewTitle.setVisibility(View.VISIBLE);
                editTextTitle.setVisibility(View.VISIBLE);
                textViewDescription.setVisibility(View.VISIBLE);
                editTextDescription.setVisibility(View.VISIBLE);
                textViewCategory.setVisibility(View.INVISIBLE);
                textViewImportance.setVisibility(View.INVISIBLE);
                spinnerCategory.setVisibility(View.INVISIBLE);
                spinnerImportance.setVisibility(View.INVISIBLE);
                break;
            case 1:
                textViewTitle.setVisibility(View.INVISIBLE);
                editTextTitle.setVisibility(View.INVISIBLE);
                textViewDescription.setVisibility(View.INVISIBLE);
                editTextDescription.setVisibility(View.INVISIBLE);
                textViewCategory.setVisibility(View.VISIBLE);
                textViewImportance.setVisibility(View.VISIBLE);
                spinnerCategory.setVisibility(View.VISIBLE);
                spinnerImportance.setVisibility(View.VISIBLE);
                textViewDate.setVisibility(View.INVISIBLE);
                datePicker.setVisibility(View.INVISIBLE);
                break;
            case 2:
                textViewCategory.setVisibility(View.INVISIBLE);
                textViewImportance.setVisibility(View.INVISIBLE);
                spinnerCategory.setVisibility(View.INVISIBLE);
                spinnerImportance.setVisibility(View.INVISIBLE);
                textViewDate.setVisibility(View.VISIBLE);
                datePicker.setVisibility(View.VISIBLE);
                textViewTime.setVisibility(View.INVISIBLE);
                timePicker.setVisibility(View.INVISIBLE);
                break;
            case 3:
                textViewDate.setVisibility(View.INVISIBLE);
                datePicker.setVisibility(View.INVISIBLE);
                textViewTime.setVisibility(View.VISIBLE);
                timePicker.setVisibility(View.VISIBLE);
                textViewAllInformation.setVisibility(View.INVISIBLE);
                buttonNext.setText(R.string.next);
                break;
            case 4:
                textViewTime.setVisibility(View.INVISIBLE);
                timePicker.setVisibility(View.INVISIBLE);
                textViewAllInformation.setVisibility(View.VISIBLE);
                textViewAllInformation.setText(new StringBuilder().append(editTextTitle.getText()).append(editTextDescription.getText()).append(spinnerCategory.getSelectedItem().toString()).toString());
                buttonNext.setText(R.string.save);
                break;
            case 5:
                Toast.makeText(this, "Termin saved", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                writeToDB();
                break;
        }
    }

    private void writeToDB() {
        dbHelper = new DBHelper(this);
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBHelper.KEY_TITLE, editTextTitle.getText().toString());
        contentValues.put(DBHelper.KEY_DESCRIPTION, editTextDescription.getText().toString());
        contentValues.put(DBHelper.KEY_CATEGORY, spinnerCategory.getSelectedItem().toString());
        contentValues.put(DBHelper.KEY_IMPORTANCE, spinnerImportance.getSelectedItem().toString());
        contentValues.put(DBHelper.KEY_DATE,datePicker.getDayOfMonth());
        database.insert(DBHelper.TABLE_TERMINS,null,contentValues);
        Cursor cursor=database.query(DBHelper.TABLE_TERMINS,null,null,null,null,null,null);
        TextView myAwesomeTextView = (TextView)findViewById(R.id.textViewPastdescription);
        myAwesomeTextView.setText("masdfd,f,dsfmsd");
       /**Need to change*/
        while(cursor.moveToNext()) {
            int index;
            index = cursor.getColumnIndexOrThrow("title");
            String firstName = cursor.getString(index);
            index = cursor.getColumnIndexOrThrow("description");
            String lastName = cursor.getString(index);
            index = cursor.getColumnIndexOrThrow("date");
            long id = cursor.getLong(index);



        }
        cursor.close();
    }

}