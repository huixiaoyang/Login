package mg.studio.myapplication;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

public class ButtonStartMainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_start_main);


        final EditText userInput =findViewById(R.id.et_input);
        findViewById(R.id.btn).setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                String information = userInput.getText().toString();
                //Todo: handle the case where information is empty
                Intent intent = new Intent(getApplicationContext(),
                        ButtonStartSecondActivity.class);
                intent.putExtra("shared_data", information);
                startActivity(intent);
            }
        });
    }

}
