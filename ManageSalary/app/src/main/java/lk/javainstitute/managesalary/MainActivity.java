package lk.javainstitute.managesalary;

import android.content.ContentProvider;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        PieChart pieChart1 = findViewById(R.id.pieChart1);

        ArrayList<PieEntry> pieArrayList = new ArrayList<>();
        pieArrayList.add(new PieEntry(25,"Suranji"));
        pieArrayList.add(new PieEntry(35,"Nayana"));
        pieArrayList.add(new PieEntry(30,"Wasundara"));
        pieArrayList.add(new PieEntry(20,"deepika"));
        pieArrayList.add(new PieEntry(15,"Chanara"));

        PieDataSet pieDataSet  = new PieDataSet(pieArrayList , "Tst");

        ArrayList<Integer> colors = new ArrayList<>();

        for (int i = 0; i < pieArrayList.size(); i++) {
            Random random = new Random();
            int color = Color.rgb(random.nextInt(256) , random.nextInt(56) ,random.nextInt(56));
            colors.add(color);
        }

        pieDataSet.setColors(colors);


        PieData pieData = new PieData();
        pieData.setDataSet(pieDataSet);

        pieChart1.setData(pieData);
        pieChart1.animateY(2000, Easing.EaseInCirc);

        pieChart1.invalidate();




        Button addEmployeeButton = findViewById(R.id.button);
        addEmployeeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , AddEmployeeActivity.class);
                startActivity(intent);
            }
        });


        Button addProductButton = findViewById(R.id.button2);
        addProductButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , AddProductActivity.class);
                startActivity(intent);
            }
        });

        Button addProductPartButton = findViewById(R.id.button3);
        addProductPartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , AddBuildPartActivity.class);
                startActivity(intent);
            }
        });


    }
}