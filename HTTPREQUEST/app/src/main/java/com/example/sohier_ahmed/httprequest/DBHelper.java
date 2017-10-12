package com.example.sohier_ahmed.httprequest;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

/**
 * Created by Sohier_ahmed on 16/08/2017.
 */

public class DBHelper extends SQLiteOpenHelper {

   private static  String db_name= "Price_connection_DB";
    private  String  db_path=null;
    private static final int db_version=1;
    Context con;
    // Member variables
    private String title;
    private String overview;
    private String release_date;
    private String original_language;
    private int id;
private SQLiteDatabase db;
    public DBHelper(Context context) {
       super(context, db_name, null,db_version);
    /*super(context,  Environment.getExternalStorageDirectory()
                + File.separator + FILE_DIR
                + File.separator + DATABASE_NAME,null,db_version);*/
        db_path="/data/data/"+ context.getPackageName()+"/databases/"+db_name;

        con=context;
    }

    public   void CreateDB()
    {
        boolean ifDBExists = CheckIfDBExists();
  //Toast.makeText(con,"CheckIfDBExists "+ifDBExists,Toast.LENGTH_LONG).show();
        if (!ifDBExists)
        {
            //Toast.makeText(con,"inside ifDBExists ",Toast.LENGTH_LONG).show();
            this.getReadableDatabase();
         /*   Toast.makeText(con,"version"+   this.getReadableDatabase().getVersion(),Toast.LENGTH_LONG).show();*/

            CopyDB();
        }
      /*  else
            Toast.makeText(con,"version"+   this.getReadableDatabase().getVersion(),Toast.LENGTH_LONG).show();*/
    }

    private boolean CheckIfDBExists()
    {
        try {
          //  Toast.makeText(con,"db_path "+db_path,Toast.LENGTH_LONG).show();
            SQLiteDatabase db2=  SQLiteDatabase.openDatabase(db_path,null,SQLiteDatabase.OPEN_READONLY);

            if (db2 !=null)
            {
               // Toast.makeText(con,"CheckIfDBExists version"+   db.getVersion(),Toast.LENGTH_LONG).show();
                db2.close();
                return true;
            }
            else
                return  false;
        }
        catch (Exception exp)
        {
            Toast.makeText(con,"EXception "+exp.getMessage(),Toast.LENGTH_LONG).show();
        }
return false;
    }
    private void CopyDB()
    {
        try {
            InputStream inputStream = con.getAssets().open(db_name);
           // Toast.makeText(con,"copy db "+db_name,Toast.LENGTH_LONG).show();
            OutputStream outputStream =new FileOutputStream(db_path);
          //  Toast.makeText(con,"copy db "+db_path,Toast.LENGTH_LONG).show();
            byte[]buffer=new byte[10];
           // int length=inputStream.read(buffer);
            int length;
            while ((length = inputStream.read(buffer))>0){
                outputStream.write(buffer, 0, length);
            }
            outputStream.flush();
            outputStream.close();
            inputStream.close();
        } catch (IOException e) {
            Toast.makeText(con,"EXception  in copy "+e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }

    public   void OpenDB()
    {try {
      db=  SQLiteDatabase.openDatabase(db_path,null,SQLiteDatabase.OPEN_READWRITE);
    }
    catch (Exception e) {
        Toast.makeText(con,"EXception in openDB "+e.getMessage(),Toast.LENGTH_LONG).show();
    }
    }

    @Override
    public synchronized void close() {
        if (db !=null)
            db.close();
        super.close();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int old_version, int new_version) {
      /*  Toast.makeText(con,"old_version "+old_version,Toast.LENGTH_LONG).show();
        Toast.makeText(con,"new_version "+new_version,Toast.LENGTH_LONG).show();*/
        if (new_version>old_version)
            CopyDB();
    }

   /* public Cursor CreateQuery(String tbl_name , String[] colms,String sel,String[] selArgs,String groupby , String having,String orderby)
    {

        Toast.makeText(con,"here in CreateQuery  ",Toast.LENGTH_LONG).show();
       return   db.rawQuery("select * from Forms",null);


    }*/
   public  Cursor GetSheetNames()
   {
       return DBOperations.GetSheetNames(db,con);
   }
   public List<String> GetOutlet(String sheet_code )
   {
        return DBOperations.GetOutlet(db,sheet_code,con);
   }

   public  List<String> GetVarieties(String sheet_code ,String outlet_code)
   {
     return   DBOperations.GetVarieties(db,sheet_code,outlet_code,con);
   }
    public  List<String> GetVarieties_inserted(String sheet_code ,String outlet_code)
    {
        return   DBOperations.GetVarieties_inserted(db,sheet_code,outlet_code,con);
    }
    public  List<String> GetVarietyDetails(String variety_code)
    {
        return DBOperations.GetVarietyDetails(db,variety_code,con);
    }
    public void get_Variety_Price(String variety_code ,String outlet_code,String sheet_code)
    {
        DBOperations.get_Variety_Price(db,con,variety_code,outlet_code,sheet_code);
    }
    public int insert_Variety_Price(String variety_code ,String outlet_code,String sheet_code, Double price)
    {
      return   DBOperations.insert_Variety_Price(db,con,variety_code,outlet_code,sheet_code,price,1);
    }

    public double add_outlet(String outlet_name ,String outlet_address,String outlet_mobile, String outlet_tel)
    {
        return   DBOperations.add_outlet(db,con,outlet_name,outlet_address,outlet_mobile,outlet_tel);
    }

     public  void DeleteData( String table_name)
    {
      DBOperations.DeleteData(db,table_name);

    }

    public  Cursor GetMessages(String Researcher_code)
    {
        return DBOperations.GetMessages(db,con,Researcher_code);
    }


    public Integer GetSheetDetails(String sheet_code) {
       return DBOperations.GetSheetDetails(db,sheet_code);
    }
    public Double GetInsertedPrice(String variety_code ,String outlet_code )
    {
        return DBOperations.GetInsertedPrice(db,con,variety_code,outlet_code);
    }

    public double UpdatePrice(String variety_code, String outlet_code,String sheet_code, Double newPrice) {
        return DBOperations.insert_Variety_Price(db,con,variety_code,outlet_code,sheet_code,newPrice,2);
    }
}
