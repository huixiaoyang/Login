package mg.studio.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ButtonStartSecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_start_second);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String retrievedInformation = extras.getString("shared_data");
            TextView display = findViewById(R.id.txtLayout);
            display.setText(retrievedInformation);
        }

    }

}
