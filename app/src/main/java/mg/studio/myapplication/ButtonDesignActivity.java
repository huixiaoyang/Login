package mg.studio.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ButtonDesignActivity extends AppCompatActivity {

    private SessionManager session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_design);

        //Check wheather the user is logged. if not ,start the login activity
        session = new SessionManager(getApplicationContext());
        if (!session.isLoggedIn()) {
            startActivity(new Intent(getApplicationContext(), Login.class));
        }

        //Button Five
        findViewById(R.id.btn_five).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(), ((Button)findViewById(R.id.btn_five)).getText(),Toast.LENGTH_LONG).show();
            }
        });

        //Button Six
        onClick((Button) findViewById(R.id.btn_six));

    }

    //Button Four
    public void bntXml(View view) {
        Toast.makeText(this, ((Button)findViewById(R.id.btn_four)).getText(),Toast.LENGTH_LONG).show();
    }


    //Handling the clicks, given a Button
    private void onClick(final Button mBtn){
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(), mBtn.getText(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
