package chrismomdjian.student.edu.wagerange;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HourlyActivity extends AppCompatActivity {

    TextView hourlyWageField;
    TextView hoursPerDayField;
    TextView daysEachWeekField;

    Button submitButton;
    TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hourly);

        hourlyWageField = (TextView) findViewById(R.id.hourlyWageField);
        hoursPerDayField = (TextView) findViewById(R.id.hoursPerDayField);
        daysEachWeekField = (TextView) findViewById(R.id.daysEachWeekField);

        submitButton = (Button) findViewById(R.id.submitButton);
        resultTextView = (TextView) findViewById(R.id.resultTextView);



        // SHOW RESULTS
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                // If user leaves any fields empty, show Toast error message
                if(hourlyWageField.getText().toString().matches("") ||
                        hoursPerDayField.getText().toString().matches("") ||
                        daysEachWeekField.getText().toString().matches("")) {

                    Toast.makeText(HourlyActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();

                } else {

                    float hourlyWage = Float.parseFloat(hourlyWageField.getText().toString());
                    float hoursADay = Float.parseFloat(hoursPerDayField.getText().toString());
                    int daysEachWeek = Integer.parseInt(daysEachWeekField.getText().toString());

                    // CALCULATE DAILY WAGE
                    final float dailyWage = (hourlyWage * hoursADay);

                    // CALCULATE WEEKLY WAGE
                    final float weeklyWage = (dailyWage * daysEachWeek);

                    // CALCULATE MONTHLY WAGE
                    final float monthlyWage = (weeklyWage * 4);

                    // CALCULATE YEARLY SALARY
                    final float yearlySalary = (monthlyWage * 12);

                    resultTextView.setText(
                                    "Daily Wage: " + dailyWage + "\n" +
                                    "Weekly Wage: " + weeklyWage + "\n" +
                                    "Monthly Wage: " + monthlyWage + "\n" +
                                    "Yearly Salary: " + yearlySalary
                    );
                }
            }
        });


    }
}
