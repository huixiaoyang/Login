package mg.studio.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private TextView tvName;

    private SessionManager session;

    private ListView listView;
    private SimpleAdapter sim_aAdapter; // 1. 新建一个数据适配器
    private List<Map<String, Object>> dataList; // 数据源
    private String[] data = { "00_LifeCircle",  "01_UserName_Final", "02_Layout_Final", "03_Button_Design", "03_Button_Toast",
            "04_Button_Intent",  "05_Button_StartActivity_extra", "06_ImageButton", "07_EditText", "08_RadioButtons_listener",
            "08_RadioButtons_onclick", "09_listView", "10_GetColor", "11_GradientBackground", "12_ImplicitIntent",
            "13_Weather_App_Design", "15_ListView", "16_ListViewCustomAdapter", "17_AudioRecorder", "19_DataBase",
            "20_FragmentOne", "21_Webview", "22_ServiceDemo", "23_Service", "24_Fingerprint",
            "25_AppPrivateDirectory", "26_AssetsFolder", "27_IntentExtras"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.listView_main);
        // 2. 适配器加载数据源
        dataList = new ArrayList<Map<String, Object>>();
        sim_aAdapter = new SimpleAdapter(this, getData(), R.layout.activity_main_item,
                new String[]{"text_appname"}, new int[]{R.id.text_appname});
        // 3. 视图(ListView)加载适配器
        listView.setAdapter(sim_aAdapter);
        listView.setOnItemClickListener(this);


        tvName = findViewById(R.id.user_name);


        /**
         * Only logged in users should access this activity
         */
        session = new SessionManager(getApplicationContext());
        if (!session.isLoggedIn()) {
            logout();
        }

        /**
         * If the user just registered an account from Register.class,
         * the parcelable should be retrieved
         */
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            // Retrieve the parcelable
            Feedback feedback = bundle.getParcelable("feedback");
            // Get the from the object
            String userName = feedback.getName();
            tvName.setText(userName);
        }


    }

    /**
     * Logging out the user:
     * - Will set isLoggedIn flag to false in SharedPreferences
     * - Clears the user data from SqLite users table
     */

    public void btnLogout(View view) {
        logout();
    }

    public void logout() {
        // Updating the session
        session.setLogin(false);
        // Redirect the user to the login activity
        startActivity(new Intent(this, Login.class));
        finish();
    }

    private List<Map<String, Object>> getData(){
        for (int i = 0; i < 28; i++){
            Map<String, Object>map = new HashMap<String, Object>();
            map.put("text_appname", data[i]);
            dataList.add(map);
        }
        return dataList;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //通过view获取其内部的组件，进而进行操作
        String text = (String) ((TextView)view.findViewById(R.id.text_appname)).getText();
        //大多数情况下，position和id相同，并且都从0开始
        if(position==0)
            startActivity(new Intent(this, LifeCircleMainActivity.class));
        if(position==1)
            startActivity(new Intent(this, UserNameActivity.class));
        if(position==2)
            startActivity(new Intent(this, LayoutActivity.class));
        if(position==3)
            startActivity(new Intent(this, ButtonDesignActivity.class));
        if(position==4)
            startActivity(new Intent(this, ButtonToastActivity.class));
        if(position==5)
            startActivity(new Intent(this, ButtonIntentActivity.class));
        if(position==6)
            startActivity(new Intent(this, ButtonStartMainActivity.class));
        if(position==7)
            startActivity(new Intent(this, ImageButtonActivity.class));
        if(position==8)
            startActivity(new Intent(this,EditTextActivity.class));
        if(position==9)
            startActivity(new Intent(this,RadioButtonsListenerActivity.class));
        if(position==10)
            startActivity(new Intent(this,RadioButtonsClick.class));
        if(position==11)
            startActivity(new Intent(this,ListViewActivity.class));
        if(position==12)
            startActivity(new Intent(this,GetColorActivity.class));
        if(position==13)
            startActivity(new Intent(this,GradientBackgroundActivity.class));
        if(position==14)
            startActivity(new Intent(this,ImplicitIntent.class));
        if(position==15)
            startActivity(new Intent(this,WeatherAppDesignActivity.class));
        if(position==16)
            startActivity(new Intent(this,List_View_Second.class));
        if(position==17)
            startActivity(new Intent(this,ListViewCustomAdapter.class));
        if(position==18)
            startActivity(new Intent(this,AudioRecord.class));
        if(position==19)
            startActivity(new Intent(this,DataBaseActivity.class));
        if(position==20)
            startActivity(new Intent(this,FragmentOneMainActivity.class));
        if(position==21)
            startActivity(new Intent(this,WebViewActivity.class));
        if(position==22)
            startActivity(new Intent(this,ServiceDemo.class));
        if(position==23)
            startActivity(new Intent(this,Service.class));
        if(position==24)
            startActivity(new Intent(this,FingerprintActivity.class));
        if(position==25)
            startActivity(new Intent(this,AppPrivateDirectory.class));
        if(position==26)
            startActivity(new Intent(this,AssetsFolder.class));
        if(position==27)
            startActivity(new Intent(this,IntentExtras.class));
    }
}