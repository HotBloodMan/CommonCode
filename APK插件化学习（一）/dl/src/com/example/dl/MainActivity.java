package com.example.dl;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.example.dl_lib.AbsPlugin;

public class MainActivity extends AbsPlugin{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button= (Button) findViewById(R.id.button1);
        if(button==null){
        	throw new RuntimeException("Cannot find button R.id.button1");
        }
        
        button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(), "click plugin view", Toast.LENGTH_LONG).show();
			}
		});
        
        
        findViewById(R.id.button2).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(getContext(),SecActivity.class));
			}
		});
        
        
        findViewById(R.id.button3).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivityForResult(new Intent(getContext(),SecActivity.class),0);
			}
		});
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
    	if(resultCode == RESULT_OK){
    		String str = data.getExtras().getString("data");
			Toast.makeText(getApplicationContext(),str, Toast.LENGTH_LONG).show();
    	}
    }
   
}
