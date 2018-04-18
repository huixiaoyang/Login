package mg.studio.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditTextActivity extends Activity {

    private SessionManager session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);

        //Check wheather the user is logged. if not ,start the login activity
        session = new SessionManager(getApplicationContext());
        if (!session.isLoggedIn()) {
            startActivity(new Intent(getApplicationContext(), Login.class));
        }

        // Connect the buttons and the edit text with this java file
        Button btnClear = (Button) findViewById(R.id.btnClear);
        Button btnToast = (Button) findViewById(R.id.btnGet);
        final EditText myEdittext = (EditText) findViewById(R.id.eTdemo);

        // Set the on click listeners

        btnClear.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // Clear the content of the EditText
                myEdittext.setText(null);

            }
        });

        btnToast.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // Retrieve the string from the edit text
                String userInput = myEdittext.getText().toString();

                // display the string as a toast
                Toast.makeText(getBaseContext(), userInput, Toast.LENGTH_LONG).show();

            }
        });
    }
}

