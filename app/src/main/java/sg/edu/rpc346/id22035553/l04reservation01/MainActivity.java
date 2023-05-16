package sg.edu.rpc346.id22035553.l04reservation01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etNumber;
    EditText etSize;
    DatePicker dpDate;
    TimePicker tpTime;
    RadioGroup rgSmoking;
    RadioButton rbYes;
    RadioButton rbNo;
    EditText etRequest;
    Button bConfirm;
    Button bReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.editTextName);
        etNumber = findViewById(R.id.editTextNumber);
        etSize = findViewById(R.id.editTextSize);
        dpDate = findViewById(R.id.datePicker);
        tpTime = findViewById(R.id.timePicker);
        rgSmoking = findViewById(R.id.smokingRadioGroup);
        rbYes = findViewById(R.id.smokingYes);
        rbNo = findViewById(R.id.smokingNo);
        etRequest = findViewById(R.id.editTextRequest);
        bConfirm = findViewById(R.id.bookButton);
        bReset = findViewById(R.id.resetButton);

        bConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bookTable();
            }
        });

        bReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetForm();
            }
        });
    }

    private void bookTable() {
        String name = etName.getText().toString();
        String number = etNumber.getText().toString();
        int size = Integer.parseInt(etSize.getText().toString());
        int day = dpDate.getDayOfMonth();
        int month = dpDate.getMonth() + 1;
        int year = dpDate.getYear();
        int hour = tpTime.getCurrentHour();
        int minute = tpTime.getCurrentMinute();
        boolean smoking = rgSmoking.getCheckedRadioButtonId() == R.id.smokingYes;
        String additionalRequests = etRequest.getText().toString();

        String message = "Name: " + name +
                "\nPhone Number: " + number +
                "\nGroup size: " + size +
                "\nDate: " + day + "/" + month + "/" + year +
                "\nTime: " + hour + ":" + minute +
                "\nSmoking area: " + (smoking ? "Yes" : "No") +
                "\nAdditional requests: " + additionalRequests;
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    private void resetForm() {
        etName.setText("");
        etNumber.setText("");
        etSize.setText("");
        Calendar calendar = Calendar.getInstance();
        dpDate.updateDate(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH));
        tpTime.setCurrentHour(calendar.get(Calendar.HOUR_OF_DAY));
        tpTime.setCurrentMinute(calendar.get(Calendar.MINUTE));
        rgSmoking.check(R.id.smokingNo);
        etRequest.setText("");
    }
}