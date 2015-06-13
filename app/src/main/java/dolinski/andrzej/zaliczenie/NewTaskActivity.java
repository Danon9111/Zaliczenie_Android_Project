package dolinski.andrzej.zaliczenie;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by andrz_000 on 2015-05-26.
 */
public class NewTaskActivity extends ActionBarActivity implements OnClickListener {

    private int day;
    private int month;
    private int year;
    private EditText calendarField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);

        ImageButton calendarImageButton = (ImageButton) findViewById(R.id.datePickerButton);
        Calendar calendar = Calendar.getInstance();
        day = calendar.get(Calendar.DAY_OF_MONTH);
        month = calendar.get(Calendar.MONTH);
        year = calendar.get(Calendar.YEAR);
        calendarField = (EditText) findViewById(R.id.datePickerField);
        calendarImageButton.setOnClickListener(this);

        final EditText summary = (EditText) findViewById(R.id.summaryField);

        final EditText description = (EditText) findViewById(R.id.descriptionField);

        final EditText datePicker = (EditText) findViewById(R.id.datePickerField);

        Button addNewTaskButton = (Button) findViewById(R.id.addButton);
        addNewTaskButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                RaisedTaskDB db = new RaisedTaskDB(NewTaskActivity.this);
                db.saveData(summary.getText().toString(), description.getText().toString(), datePicker.getText().toString());
                Toast.makeText(getApplicationContext(), "Zadanie dodane do listy", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(NewTaskActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View v) {
        showDialog(0);
    }

    @Override
    @Deprecated
    protected Dialog onCreateDialog(int id) {
        return new DatePickerDialog(this, datePickerListener, year, month, day);
    }

    private DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int selectedYear,
                              int selectedMonth, int selectedDay) {
            calendarField.setText(selectedDay + "/" + (selectedMonth + 1) + "/"
                    + selectedYear);
        }
    };
}
