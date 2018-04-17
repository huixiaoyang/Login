package mg.studio.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class IntentExtras extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_extras);

    }

    public void btnClick(View view) {
        String value = "Hello World! - This message was from the first activity.";
        Intent intent = new Intent(getApplicationContext(), IntentExtrasNewActivity.class);
        intent.putExtra("keyword", value);
        startActivity(intent);
    }
}

