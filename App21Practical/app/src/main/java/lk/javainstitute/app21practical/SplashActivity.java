package lk.javainstitute.app21practical;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageView loadImageView = findViewById(R.id.imageView);


        SpringAnimation springAnimation = new SpringAnimation(loadImageView , DynamicAnimation.TRANSLATION_Y);

        SpringForce springForce = new SpringForce();
        springForce.setFinalPosition(springForce.STIFFNESS_VERY_LOW);
        springForce.setDampingRatio(springForce.DAMPING_RATIO_HIGH_BOUNCY);
        springForce.setFinalPosition(600f);

        springAnimation.setSpring(springForce);
        springAnimation.start();
    }
}