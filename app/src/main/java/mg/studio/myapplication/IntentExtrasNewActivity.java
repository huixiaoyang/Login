package mg.studio.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


public class IntentExtrasNewActivity extends AppCompatActivity {
    private String value;

    private SessionManager session;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_second);

        //Check wheather the user is logged. if not ,start the login activity
        session = new SessionManager(getApplicationContext());
        if (!session.isLoggedIn()) {
            startActivity(new Intent(getApplicationContext(), Login.class));
        }

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            value = bundle.getString("keyword");
        }

        ((TextView) findViewById(R.id.display)).setText(value);
    }
}
