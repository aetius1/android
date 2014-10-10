package com.example.alarmi1;



import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Timer;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import android.support.v4.widget.CursorAdapter;

import android.view.View.OnClickListener;
import android.support.v4.widget.SimpleCursorAdapter;

public class MainActivity extends Activity {
	
	
	
	

	
	public static final Integer kom=2;
	 Context t;
	 Looper lupy;
	 Handler ok;
	 private Handler nok;
	 Location loc;
	 private dbadapter mydb;
	 
	 Button uton;
	 
	 String TAG="TAG";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	 final	ListView listContent = (ListView)findViewById(R.id.contentlist);
	 uton=(Button)findViewById(R.id.but);
	 listContent.setVisibility(View.GONE);
        
        
		
  Timer timi=new Timer();
  timi.scheduleAtFixedRate(new locac(nok,this),10, 300000);
  
  //
  mydb=new dbadapter(this);
  mydb.openToRead();
   Cursor m=mydb.getData();
  
   
  
   String[] from = new String[]{dbadapter.langti,dbadapter.longti,dbadapter.Timse};
  
   int[] to = new int[]{R.id.text,R.id.text1,R.id.text2};

   final SimpleCursorAdapter cursorAdapter =new SimpleCursorAdapter(this, R.layout.toyota, m, from, to);

   listContent.setAdapter(cursorAdapter);
   
   
   
   

   

   
 uton.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		listContent.setVisibility(View.VISIBLE);
		
		Cursor ok=mydb.getData();
		
		cursorAdapter.swapCursor(ok);
		
		 
		cursorAdapter.notifyDataSetChanged();
		
	}
});
  
  
  //
  
  
        
	
	
		 	
	
	
	
	

		
		
		
		
	
	
	
	
	
	}

	
		
		
		
		
		
	
	
			
			
		
		}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

		

	    


	






		
	

	
	