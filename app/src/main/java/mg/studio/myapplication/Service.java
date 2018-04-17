package mg.studio.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class Service extends AppCompatActivity implements Runnable {
    Handler handler = new Handler();
    private int counterActivity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

    }

    public void btnStart(View view) {
        Intent intent = new Intent(this, MyService.class);
        startService(intent);
        Log.d(ServiceMyService.LOG_TAG, "Button start Service pressed");
        handler.post(this);


    }

    public void btnEnd(View view) {
        Intent intent = new Intent(this, MyService.class);
        stopService(intent);
    }

    @Override
    public void run() {
        counterActivity++;
        Log.d(ServiceMyService.LOG_TAG, "Counter Activity "+counterActivity);
        handler.postDelayed(this, 1000);
    }
}
