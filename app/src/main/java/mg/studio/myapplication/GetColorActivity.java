package mg.studio.myapplication;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class GetColorActivity extends AppCompatActivity {
    TextView display_color;

    private SessionManager session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_color);

        //Check wheather the user is logged. if not ,start the login activity
        session = new SessionManager(getApplicationContext());
        if (!session.isLoggedIn()) {
            startActivity(new Intent(getApplicationContext(), Login.class));
        }

        display_color = (TextView) findViewById(R.id.tv);

        final ImageView imageView = (ImageView) findViewById(R.id.image);
        final Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();


        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {


                int x = (int) event.getX();
                int y = (int) event.getY();
                int pixel = bitmap.getPixel(x, y);

                //then do what you want with the pixel data, e.g
                int redValue = Color.red(pixel);
                int blueValue = Color.blue(pixel);
                int greenValue = Color.green(pixel);

                Log.e("TAG", "R: " + redValue + " G: " + greenValue + " B: " + blueValue);
                display_color.setText("R: " + redValue + " G: " + greenValue + " B: " + blueValue);
                return false;
            }
        });

    }


}
