package chrismomdjian.student.edu.wagerange;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MonthlyActivity extends AppCompatActivity {

    EditText monthlyWageField;
    EditText daysEachWeekField;
    EditText hoursEachDayField;

    Button calculate;
    TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monthly);

        monthlyWageField = (EditText)findViewById(R.id.monthlyWageField);
        daysEachWeekField = (EditText)findViewById(R.id.daysEachWeekField);
        hoursEachDayField = (EditText)findViewById(R.id.hoursEachDayField);

        calculate = (Button)findViewById(R.id.calculate);
        resultText = (TextView)findViewById(R.id.resultText);


        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if( monthlyWageField.getText().toString().matches("") ||
                        daysEachWeekField.getText().toString().matches("") ||
                        hoursEachDayField.getText().toString().matches("")) {

                    Toast.makeText(getApplicationContext(), "Please fill in all fields.", Toast.LENGTH_SHORT).show();

                } else {

                    float monthlyWage = Float.parseFloat(monthlyWageField.getText().toString());
                    int daysEachWeek = Integer.parseInt(daysEachWeekField.getText().toString());
                    float hoursEachDay = Float.parseFloat(hoursEachDayField.getText().toString());

                    float weeklyWage = (monthlyWage / 4);
                    float dailyWage = (weeklyWage / daysEachWeek);
                    float hourlyWage = (dailyWage / hoursEachDay);
                    float yearlySalary = (monthlyWage * 12);


                    resultText.setText(
                                    "Hourly Wage: " + hourlyWage + "\n" +
                                    "Daily Wage: " + dailyWage + "\n" +
                                    "Weekly Wage: " + weeklyWage + "\n" +
                                    "Yearly Salary: " + yearlySalary
                    );

                }

            }
        });
    }
}
