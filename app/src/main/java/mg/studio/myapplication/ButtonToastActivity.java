package mg.studio.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class ButtonToastActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_toast);
    }

    public void mBtn(View view) {
        Toast.makeText(this, " You clicked the button", Toast.LENGTH_LONG).show();
    }
}
