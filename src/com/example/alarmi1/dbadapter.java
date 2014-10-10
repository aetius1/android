package com.example.alarmi1;





import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
















public class dbadapter {

	public static String DBNAME="Items.db";

	public static String DBNAME15="Items15.db";
	public static final String TableN="kooor";
	public static final String TableM="nova";
	
	
	public static final String id="_id";
	public static final int VERSION=1;
	public static final int factory=0;
	public static final  String langti="shirina" ;
	public static final  String longti="duljina" ;
	public static  final String Timse="vreme" ;
	public static float Shirina;
	public static float Dulzina;
	public static String Vreme;

	 //create table MY_DATABASE (ID integer primary key, Content text not null);
	 
	 
	 private SQLiteAdapter sqLiteHelper;
	 private SQLiteDatabase sqLiteDatabase;

	 private Context context;
	 
	 public dbadapter (Context c){
	  context = c;
	 }
	 
	 public dbadapter  openToRead() throws android.database.SQLException {
	  sqLiteHelper = new SQLiteAdapter (context, DBNAME15, null, VERSION);
	  sqLiteDatabase = sqLiteHelper.getReadableDatabase();
	  return this; 
	 }
	 
	 public dbadapter  openToWrite() throws android.database.SQLException {
	  sqLiteHelper = new SQLiteAdapter(context, DBNAME15, null, VERSION);
	  sqLiteDatabase = sqLiteHelper.getWritableDatabase();
	  return this; 
	 }
	 
	 public void close(){
	  sqLiteHelper.close();
	 }
	 
	 public long insert(String  content ,String content2,String content3){
	  
	  ContentValues contentValues = new ContentValues();
	
		
	  contentValues.put(langti,content);
	  contentValues.put(longti,content3);
	  contentValues.put(Timse,content2);
	 
	 
	  
		 
	  
	  
	  
	  
	  return sqLiteDatabase.insert(TableM, null, contentValues);
	 }
	 
	 public int deleteAll(){
	  return sqLiteDatabase.delete(TableM, null,null);
	 }
	 
	 public Cursor getData()
	 
	 
	 {
		 
		 String quer="SELECT * from nova ORDER by _id DESC LIMIT 5";
		 
		 return sqLiteDatabase.rawQuery(quer, null);
		 
	 }
	 public Cursor queueAll(){
	  String[] columns = new String[]{id,langti, longti,Timse};
	  Cursor cursor = sqLiteDatabase.query(TableM, columns, 
	    null, null, null, null, null);
	  String result = "";
	  
	  int index_CONTENT = cursor.getColumnIndex(langti);
	  int index_CONTENT1 = cursor.getColumnIndex(longti);
	  int index_CONTENT2 = cursor.getColumnIndex(Timse);
	  
	  for(cursor.moveToFirst(); !(cursor.isAfterLast()); cursor.moveToNext()){
	   result = result + cursor.getString(index_CONTENT) + "\n" + cursor.getString(index_CONTENT1) + "\n" 
			  +cursor.getString(index_CONTENT2) + "\n" ;
	  }
	 
	  return cursor;
	 }


























public class SQLiteAdapter extends SQLiteOpenHelper {

	
	

	
	private String CreateDB=
			
			 
			  "create table " + TableM + " ("
			  + id + " integer primary key autoincrement, "
			  + langti + " text, " 
			  + longti + " text, " 
			  + Timse + " DATETIME " + ")";
              
			
	
	
	
	
	
	
	
	
	public SQLiteAdapter (Context context, String name, CursorFactory factory,
			int version) {
		super(context, DBNAME15, factory, VERSION);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */


	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		
		db.execSQL(CreateDB);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

}

}
