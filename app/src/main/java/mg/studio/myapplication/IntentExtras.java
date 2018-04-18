package mg.studio.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class IntentExtras extends AppCompatActivity {

    private SessionManager session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_extras);

        //Check wheather the user is logged. if not ,start the login activity
        session = new SessionManager(getApplicationContext());
        if (!session.isLoggedIn()) {
            startActivity(new Intent(getApplicationContext(), Login.class));
        }
    }

    public void btnClick(View view) {
        String value = "Hello World! - This message was from the first activity.";
        Intent intent = new Intent(getApplicationContext(), IntentExtrasNewActivity.class);
        intent.putExtra("keyword", value);
        startActivity(intent);
    }
}

