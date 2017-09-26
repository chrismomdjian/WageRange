package chrismomdjian.student.edu.wagerange;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button hourlySelection;
    Button weeklySelection;
    Button monthlySelection;
    Button yearlySelection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hourlySelection = (Button)findViewById(R.id.hourlySelection);
        weeklySelection = (Button)findViewById(R.id.weeklySelection);
        monthlySelection = (Button)findViewById(R.id.monthlySelection);
        yearlySelection = (Button)findViewById(R.id.yearlySelection);


        // ONCLICKLISTENER FOR HOURLY
        hourlySelection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent hourlyPage = new Intent(getApplicationContext(), HourlyActivity.class);
                startActivity(hourlyPage);
            }
        });

        // ONCLICKLISTENER FOR WEEKLY
        weeklySelection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent weeklyPage = new Intent(getApplicationContext(), WeeklyActivity.class);
                startActivity(weeklyPage);
            }
        });

        // ONCLICKLISTENER FOR MONTHLY
        monthlySelection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent monthlyPage = new Intent(getApplicationContext(), MonthlyActivity.class);
                startActivity(monthlyPage);
            }
        });

        // ONCLICKLISTENER FOR YEARLY
        yearlySelection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent yearlyPage = new Intent(getApplicationContext(), YearlyActivity.class);
                startActivity(yearlyPage);
            }
        });
    }
}
