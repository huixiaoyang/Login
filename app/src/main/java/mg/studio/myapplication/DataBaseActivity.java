package mg.studio.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class DataBaseActivity extends AppCompatActivity {

    private DatabaseHelper databaseHelper;

    private SessionManager session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        //Check wheather the user is logged. if not ,start the login activity
        session = new SessionManager(getApplicationContext());
        if (!session.isLoggedIn()) {
            startActivity(new Intent(getApplicationContext(), Login.class));
        }

        databaseHelper = new DatabaseHelper(this);
    }


    public void btnAdd(View view) {
        String firstName = ((TextView) findViewById(R.id.first_name)).getText().toString();
        String lastName = ((TextView) findViewById(R.id.last_name)).getText().toString();
        String marks = ((TextView) findViewById(R.id.marks)).getText().toString();

        boolean dataInserted = databaseHelper.insertData(firstName, lastName, marks);
        if (dataInserted == true) {
            //Do something
            Log.d(getPackageName(), "Data inserted");
        } else {
            //Show an error
            Log.e(getPackageName(), " Failed inserted data");
        }

    }

    public void btnReadDb(View view) {
        Cursor cursor = databaseHelper.readData();

        if (cursor .getCount() == 0){
            //The table is empty
            Log.e(getPackageName(), " Reader: empty");
            ((TextView)findViewById(R.id.tv_display)).setText("The database is empty");
        }else {

            Log.e(getPackageName(), " Reading the content");
            StringBuffer stringBuffer = new StringBuffer();
            while (cursor.moveToNext()){
                stringBuffer.append("Id: "+cursor.getString(0)+"\n");
                stringBuffer.append("First name: "+cursor.getString(1)+"\n");
                stringBuffer.append("Last name: "+cursor.getString(2)+"\n");
                stringBuffer.append("Marks: "+cursor.getString(3)+"\n  ---------- \n");
            }
            ((TextView)findViewById(R.id.tv_display)).setText(stringBuffer.toString());
        }
    }
}
