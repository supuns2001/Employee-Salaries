package lk.javainstitute.managesalary;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class AddProductActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_product);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Spinner spinner1 = findViewById(R.id.spinner);

        List<String> products = new ArrayList<>();
        products.add("Select Products");
        products.add("Plain Pant");
        products.add("Waist Band Pant");
        products.add("Morden Pant");


        ArrayAdapter<String> productArrayAdapter = new ArrayAdapter<>(
                AddProductActivity.this
                , R.layout.products_layout
                , products
        );

        spinner1.setAdapter(productArrayAdapter);


    }
}