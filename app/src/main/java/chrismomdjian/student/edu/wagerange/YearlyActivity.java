package chrismomdjian.student.edu.wagerange;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class YearlyActivity extends AppCompatActivity {

    EditText yearlySalaryField;
    EditText daysEachWeekForYearly;

    Button calculate;
    TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yearly);

        yearlySalaryField = (EditText)findViewById(R.id.yearlySalaryField);
        daysEachWeekForYearly = (EditText)findViewById(R.id.daysEachWeekForYearly);

        calculate = (Button)findViewById(R.id.calculate);
        resultText = (TextView)findViewById(R.id.resultText);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if( yearlySalaryField.getText().toString().matches("") ||
                        daysEachWeekForYearly.getText().toString().matches("")) {

                    Toast.makeText(getApplicationContext(), "Please fill in both fields", Toast.LENGTH_SHORT).show();

                } else {

                    int yearlySalary = Integer.parseInt(yearlySalaryField.getText().toString());
                    int daysEachWeek = Integer.parseInt(daysEachWeekForYearly.getText().toString());

                    // CALCULATE MONTHLY
                    int monthlyWage = (yearlySalary / 12);

                    // CALCULATE WEEKLY
                    int weeklyWage = (monthlyWage / 4);

                    // CALCULATE DAILY
                    int dailyWage = (weeklyWage / daysEachWeek);

                    // CALCULATE HOURLY
                    int hourlyWage = (dailyWage / 8);

                    resultText.setText(
                            "hourlyWage: " + hourlyWage + "\n" +
                            "Daily Wage: " + dailyWage + "\n" +
                            "Weekly Wage: " + weeklyWage + "\n" +
                            "MonthlyWage: " + monthlyWage
                    );
                }

            }
        });
    }
}

