package com.example.alarmi1;



import java.util.TimerTask;

public class  locac    extends TimerTask implements LocationListener {

	public static Context Ctx;
	private final Handler nok;
	LocationManager norm;


	
	
	
	public static String moi="manag.GPS_PROVIDER";
	
	
   public locac (Handler h,Context k){
		
		
		nok=h;
		Ctx=k;
		
		
		
   }
	

	
	
  
	  
	  
	  
  
	 


	
   

	






















	@Override
	public void onLocationChanged( Location location) {
		// TODO Auto-generated method stub
		
		
		
		norm.requestLocationUpdates(norm.GPS_PROVIDER, 0, 0, this);
 
		int lato=(int)location.getLatitude();
		   int loto=(int)location.getLongitude();
		   long time=(long)location.getTime();
		   Log.d("TAG", "Lang is" +lato+"long is"+loto);
	
	
	}


















	@Override
	public void onProviderDisabled(String arg0) {
		// TODO Auto-generated method stub
		
	}


















	@Override
	public void onProviderEnabled(String arg0) {
		// TODO Auto-generated method stub
		
	}


















	@Override
	public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
		// TODO Auto-generated method stub
		
	}
		
		
		
		
	

	public void run ()


	{      
		
		
	







 
     



		 norm=(LocationManager)Ctx.getSystemService(Ctx.LOCATION_SERVICE);
		 norm.requestLocationUpdates(norm.GPS_PROVIDER, 0, 0, this,Looper.getMainLooper());
		  Location m=norm.getLastKnownLocation(norm.GPS_PROVIDER);
		  
		 if (m==null){return;}
		 
		 else {
		  float lato=(float)m.getLatitude();
		   float loto=(float)m.getLongitude();
		   long time=m.getTime();
		   
		  
		
		   String Langitute_1=String.valueOf(lato);
	       
	        
	        String Longtitude_1=String.valueOf(loto);
	      

	        String TimeTaken=String.valueOf(time);
	        
	        
	        dbadapter mkola=new dbadapter(Ctx);
			mkola.openToWrite();
			
			mkola.insert(Langitute_1,TimeTaken,Longtitude_1);
			Log.d("TAG", "Run here");
			Log.d("TAG", "Lang is" +lato+"long is"+loto);
		

		 }
		  
			
				 
	
	}
	
	
}
	
		
		
		
		
		 
		
		
		
		  
		