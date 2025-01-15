package lk.javainstitute.managesalary;

import android.graphics.Color;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;
import java.util.Random;

public class AddEmployeeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_employee);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        BarChart barChart = findViewById(R.id.barchart1);

        ArrayList<BarEntry> barEntryArrayList = new ArrayList<>();
        barEntryArrayList.add(new BarEntry(0,25));
        barEntryArrayList.add(new BarEntry(10,65));
        barEntryArrayList.add(new BarEntry(20,40));
        barEntryArrayList.add(new BarEntry(30,85));

        BarDataSet barDataSet = new BarDataSet(barEntryArrayList , "Test");

        // customice bar data set

        ArrayList<Integer> colorArrayList = new ArrayList<>();

        for (int i = 0; i < barEntryArrayList.size(); i++) {
            Random random = new Random();
            int color = Color.rgb(random.nextInt(256) , random.nextInt(56) ,random.nextInt(56));
            colorArrayList.add(color);
        }

        barDataSet.setColors(colorArrayList);


        BarData barData = new BarData();
        barData.setBarWidth(6f);

        barData.addDataSet(barDataSet);

        //customise the chart
        barChart.setPinchZoom(false);
        barChart.setScaleEnabled(false);
        barChart.animateY(2000 , Easing.EaseInCubic);
        barChart.setDescription(null);
        barChart.setFitBars(true);



        barChart.setData(barData);
        barChart.invalidate();



    }
}