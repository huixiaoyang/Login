package mg.studio.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class ButtonIntentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_intent);
    }

    public void btn(View view) {

        Intent mIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://cqu.edu.cn"));
        startActivity(mIntent);
    }
}
