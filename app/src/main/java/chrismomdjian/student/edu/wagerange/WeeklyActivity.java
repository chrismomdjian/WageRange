package chrismomdjian.student.edu.wagerange;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class WeeklyActivity extends AppCompatActivity {

    EditText weeklyWageField;
    EditText daysEachWeekField;
    EditText hoursEachDayField;

    Button calculate;
    TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weekly);

        weeklyWageField = (EditText)findViewById(R.id.weeklyWageField);
        daysEachWeekField = (EditText)findViewById(R.id.daysEachWeekField);
        hoursEachDayField = (EditText)findViewById(R.id.hoursEachDayField);

        calculate = (Button)findViewById(R.id.calculate);
        resultText = (TextView)findViewById(R.id.resultText);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if( weeklyWageField.getText().toString().matches("") ||
                        daysEachWeekField.getText().toString().matches("") ||
                        hoursEachDayField.getText().toString().matches("")) {

                    Toast.makeText(getApplicationContext(), "Please fill in all fields.", Toast.LENGTH_SHORT).show();

                } else {

                    float weeklyWage = Float.parseFloat(weeklyWageField.getText().toString());
                    int daysEachWeek = Integer.parseInt(daysEachWeekField.getText().toString());
                    float hoursEachDay = Float.parseFloat(hoursEachDayField.getText().toString());


                    float dailyWage = (weeklyWage / daysEachWeek);
                    float hourlyWage = (dailyWage / hoursEachDay);
                    float monthlyWage = (weeklyWage * 4);
                    float yearlySalary = (monthlyWage * 12);


                    resultText.setText(
                                    "Hourly Wage: " + hourlyWage + "\n" +
                                    "Daily Wage: " + dailyWage + "\n" +
                                    "Monthly Wage: " + monthlyWage + "\n" +
                                    "Yearly Salary: " + yearlySalary
                    );

                }

            }
        });
    }
}
