package com.example.karthik.class28googleformconnectivity;


import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.BufferedSink;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;


public class MainActivity extends AppCompatActivity {
    Button submit;
    EditText name,roll;
    String url = "https://docs.google.com/forms/d/e/1FAIpQLScesySTxjdHCRz9JitCuHvl_UvFKx-3W3FxJc9VtANQsLUpRg/formResponse";
    String name_key = "entry_1748938151";
    String roll_key = "entry_1975214320";
    MediaType form_data_type = MediaType.parse("application/x-www-form-urlencoded; charset = utf-8");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submit = (Button)findViewById(R.id.btSend);
        name = (EditText)findViewById(R.id.etName);
        roll  = (EditText)findViewById(R.id.etRoll);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                postdata postdata = new postdata();
                postdata.execute(url,name.getText().toString(),roll.getText().toString());
            }
        });
    }

    public class postdata extends AsyncTask<String,Void ,Boolean>{

        @Override
        protected Boolean doInBackground(String... strings) {
            Boolean result= true;
            String url_1 = strings[0];
            String name  = strings[1];
            String  roll = strings[2];
            String postbody="";
            try {
                postbody = name_key+"="+URLEncoder.encode(name,"UTF-8") + "&" + roll_key+"="+URLEncoder.encode(roll,"UTF-8");
            }catch (UnsupportedEncodingException ex){
                result =  false;
            }
            try{
                OkHttpClient client = new OkHttpClient();
                RequestBody body = RequestBody.create(form_data_type,postbody);
                Request requestBody = new Request.Builder().url(url).post(body).build();
                Response response = client.newCall(requestBody).execute();
            }catch (Exception ex){
                result = false;
            }
            return result;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_SHORT).show();
            super.onPostExecute(aBoolean);
        }
    }
}