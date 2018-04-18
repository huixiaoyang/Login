package mg.studio.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class LayoutActivity extends AppCompatActivity {

    private SessionManager session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);

        //Check wheather the user is logged. if not ,start the login activity
        session = new SessionManager(getApplicationContext());
        if (!session.isLoggedIn()) {
            startActivity(new Intent(getApplicationContext(), Login.class));
        }
    }
}
