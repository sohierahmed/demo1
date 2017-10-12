package com.example.sohier_ahmed.httprequest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by Sohier_ahmed on 20/08/2017.
 */

public class DBOperations {


    public static void get_Variety_Price(SQLiteDatabase db ,Context con ,String variety_code ,String outlet_code,String sheet_code)
    {
        String whereCondition=Contract.priceEntry.COL_OUTLET_CODE+"='"+outlet_code+"' and "
                +Contract.priceEntry.COL_VARIETY_CODE+"='"+variety_code+"' and "+
                Contract.priceEntry.COL_SHEET_CODE+"='"+sheet_code+"'";
        Cursor curs=  db.query(Contract.priceEntry.TABLE_NAME,null,whereCondition,null,null,null,null);
        curs.moveToFirst();
  }
    private static String get_Current_DateTime()
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);
    }

    public static Cursor GetSheetNames(SQLiteDatabase db , Context con)
    {
        Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH)+1;
        int mDay = c.get(Calendar.DAY_OF_MONTH);
        int wDay=c.get(Calendar.DAY_OF_WEEK);
        // display the current date
       // String CurrentDate = mYear + "/" + mMonth + "/" + mDay;
        String sql ="SELECT * FROM "+Contract.sheetEntry.TABLE_NAME+","+Contract.formEntry.TABLE_NAME+
                " WHERE "+Contract.sheetEntry.TABLE_NAME+"."+ Contract.sheetEntry.COL_FORM_CODE +
                "="+
                Contract.formEntry.TABLE_NAME+"."+Contract.formEntry.COL_FORM_CODE +
                " AND (("+Contract.sheetEntry.TABLE_NAME+"."+ Contract.sheetEntry.COL_NUMBER_OF_COLLECTING
                +" = 1 AND "+mDay +" >=CAST("+ Contract.sheetEntry.TABLE_NAME+"."+ Contract.sheetEntry.COL_TIME_FROM+" AS INTEGER)"
                +" AND "+mDay+" <=CAST("+Contract.sheetEntry.TABLE_NAME+"."+ Contract.sheetEntry.COL_TIME_TO+" AS INTEGER)) OR ("+
                Contract.sheetEntry.TABLE_NAME+"."+ Contract.sheetEntry.COL_NUMBER_OF_COLLECTING
                +" = 0 AND "+mMonth +" =10 AND "+mDay +" >=CAST("+ Contract.sheetEntry.TABLE_NAME+"."+ Contract.sheetEntry.COL_TIME_FROM+" AS INTEGER)"
                +" AND "+mDay+" <=CAST("+Contract.sheetEntry.TABLE_NAME+"."+ Contract.sheetEntry.COL_TIME_TO+" AS INTEGER)) OR ("+
                Contract.sheetEntry.TABLE_NAME+"."+ Contract.sheetEntry.COL_NUMBER_OF_COLLECTING
                +" = 4 AND ("+wDay+"="+Calendar.SATURDAY+" OR "+wDay+"="+Calendar.SUNDAY+" OR "+wDay+"="+Calendar.MONDAY+" OR "+wDay+"="+Calendar.TUESDAY+
                " OR "+wDay+"="+Calendar.WEDNESDAY+" OR "+wDay+"="+Calendar.THURSDAY+"))"+
                "OR ("+
                Contract.sheetEntry.TABLE_NAME+"."+ Contract.sheetEntry.COL_NUMBER_OF_COLLECTING
                        +" = 3 AND ("+mMonth%3+"=1)))";

        Cursor cur = db.rawQuery(sql, null);

        return   cur;
    }
    public static List<String> GetOutlet(SQLiteDatabase db , String sheet_code , Context con)
    {
        List<String> result = new ArrayList<String>();
        //  String[] outlet_values;
        String sql ="SELECT DISTINCT "+ Contract.outletEntry.TABLE_NAME+"."+Contract.outletEntry.COL_OUTLET_NAME+
                " ,  "+Contract.outletEntry.TABLE_NAME+"."+Contract.outletEntry.COL_OUTLET_CODE+
                " FROM "+Contract.priceEntry.TABLE_NAME+","+ Contract.outletEntry.TABLE_NAME+
                " WHERE "+Contract.priceEntry.TABLE_NAME+"."+ Contract.priceEntry.COL_OUTLET_CODE+
                "="+
                Contract.outletEntry.TABLE_NAME+"."+Contract.outletEntry.COL_OUTLET_CODE
                +" AND "+Contract.priceEntry.TABLE_NAME+"."+ Contract.priceEntry.COL_SHEET_CODE+
                "='"+sheet_code+"'";
        // String sql ="SELECT * FROM "+Contract.priceEntry.TABLE_NAME;
        Cursor cur = db.rawQuery(sql, null);

        int count = cur.getCount();

        for (int i =0 ; i< count; i++)
        {

            cur.moveToNext();
            result.add(cur.getString(cur.getColumnIndex(Contract.outletEntry.COL_OUTLET_NAME)));
            result.add(cur.getString(cur.getColumnIndex(Contract.outletEntry.COL_OUTLET_CODE)));

        }
        return   result;
    }
    public static  List<String> GetVarieties(SQLiteDatabase db , String sheet_code ,String outlet_code, Context con)
    {
        List<String> result = new ArrayList<String>();
       // String[] outlet_values;
        String sql;
        if (outlet_code=="0")
        {
            sql ="SELECT "+ Contract.priceEntry.TABLE_NAME+"."+Contract.priceEntry.COL_VARIETY_CODE+
                    " , "+Contract.varietyEntry.TABLE_NAME+"."+Contract.varietyEntry.COL_VARIETY_NAME+
                    " FROM "+Contract.priceEntry.TABLE_NAME+","+ Contract.varietyEntry.TABLE_NAME+
                    " WHERE "+Contract.priceEntry.TABLE_NAME+"."+ Contract.priceEntry.COL_VARIETY_CODE+
                    "="+
                    Contract.varietyEntry.TABLE_NAME+"."+Contract.varietyEntry.COL_VARIETY_CODE
                    +" AND "+Contract.priceEntry.TABLE_NAME+"."+ Contract.priceEntry.COL_SHEET_CODE+
                    "='"+sheet_code+"'";
        }
        else if (outlet_code=="00")
        {
            sql ="SELECT "+ Contract.priceEntry.TABLE_NAME+"."+Contract.priceEntry.COL_VARIETY_CODE+
                    " , "+Contract.varietyEntry.TABLE_NAME+"."+Contract.varietyEntry.COL_VARIETY_NAME+
                    " FROM "+Contract.priceEntry.TABLE_NAME+","+ Contract.varietyEntry.TABLE_NAME+
                    " WHERE "+Contract.priceEntry.TABLE_NAME+"."+ Contract.priceEntry.COL_VARIETY_CODE+
                    "="+
                    Contract.varietyEntry.TABLE_NAME+"."+Contract.varietyEntry.COL_VARIETY_CODE
                    +" AND "+Contract.priceEntry.TABLE_NAME+"."+ Contract.priceEntry.COL_SHEET_CODE+
                    "='"+sheet_code+"'AND "+Contract.priceEntry.TABLE_NAME+"."+Contract.priceEntry.COL_SAVE_EDIT+"=0";
        }
        else
        {
            sql ="SELECT "+ Contract.priceEntry.TABLE_NAME+"."+Contract.priceEntry.COL_VARIETY_CODE+
                    " , "+Contract.varietyEntry.TABLE_NAME+"."+Contract.varietyEntry.COL_VARIETY_NAME+
                    " FROM "+Contract.priceEntry.TABLE_NAME+","+ Contract.varietyEntry.TABLE_NAME+
                    " WHERE "+Contract.priceEntry.TABLE_NAME+"."+ Contract.priceEntry.COL_VARIETY_CODE+
                    "="+
                    Contract.varietyEntry.TABLE_NAME+"."+Contract.varietyEntry.COL_VARIETY_CODE
                    +" AND "+Contract.priceEntry.TABLE_NAME+"."+ Contract.priceEntry.COL_SHEET_CODE+
                    "='"+sheet_code+"' AND "+Contract.priceEntry.TABLE_NAME+"."+Contract.priceEntry.COL_OUTLET_CODE+
                    "='"+outlet_code+"' AND "+Contract.priceEntry.TABLE_NAME+"."+Contract.priceEntry.COL_SAVE_EDIT+"=0";
        }

      //    Toast.makeText(con,"sql   "+sql,Toast.LENGTH_LONG).show();
        try
        {
            Cursor cur = db.rawQuery(sql, null);
            int count = cur.getCount();

            for (int i =0 ; i< count; i++)
            {
                cur.moveToNext();
                result.add(cur.getString(cur.getColumnIndex(Contract.priceEntry.COL_VARIETY_CODE)));
                result.add(cur.getString(cur.getColumnIndex(Contract.varietyEntry.COL_VARIETY_NAME)));

            }

        }
        catch (Exception exp)
        {
            Toast.makeText(con,"exp   "+exp.getMessage(),Toast.LENGTH_LONG).show();
        }
        return   result;
    }
    public static  List<String> GetVarieties_inserted(SQLiteDatabase db , String sheet_code ,String outlet_code, Context con)
    {
        List<String> result = new ArrayList<String>();
        String sql ;
       if (outlet_code=="0")
       {
           sql ="SELECT "+ Contract.priceEntry.TABLE_NAME+"."+Contract.priceEntry.COL_VARIETY_CODE+
                   " , "+Contract.varietyEntry.TABLE_NAME+"."+Contract.varietyEntry.COL_VARIETY_NAME+
                   " FROM "+Contract.priceEntry.TABLE_NAME+","+ Contract.varietyEntry.TABLE_NAME+
                   " WHERE "+Contract.priceEntry.TABLE_NAME+"."+ Contract.priceEntry.COL_VARIETY_CODE+
                   "="+
                   Contract.varietyEntry.TABLE_NAME+"."+Contract.varietyEntry.COL_VARIETY_CODE
                   +" AND "+Contract.priceEntry.TABLE_NAME+"."+ Contract.priceEntry.COL_SHEET_CODE+
                   "='"+sheet_code+"' AND ("+Contract.priceEntry.TABLE_NAME+"."+Contract.priceEntry.COL_SAVE_EDIT+"=1 OR "+
                   Contract.priceEntry.TABLE_NAME+"."+Contract.priceEntry.COL_SAVE_EDIT+"=2)";
       }
       else
       {
           sql ="SELECT "+ Contract.priceEntry.TABLE_NAME+"."+Contract.priceEntry.COL_VARIETY_CODE+
                   " , "+Contract.varietyEntry.TABLE_NAME+"."+Contract.varietyEntry.COL_VARIETY_NAME+
                   " FROM "+Contract.priceEntry.TABLE_NAME+","+ Contract.varietyEntry.TABLE_NAME+
                   " WHERE "+Contract.priceEntry.TABLE_NAME+"."+ Contract.priceEntry.COL_VARIETY_CODE+
                   "="+
                   Contract.varietyEntry.TABLE_NAME+"."+Contract.varietyEntry.COL_VARIETY_CODE
                   +" AND "+Contract.priceEntry.TABLE_NAME+"."+ Contract.priceEntry.COL_SHEET_CODE+
                   "='"+sheet_code+"' AND "+Contract.priceEntry.TABLE_NAME+"."+Contract.priceEntry.COL_OUTLET_CODE+
                   "='"+outlet_code+"' AND ("+Contract.priceEntry.TABLE_NAME+"."+Contract.priceEntry.COL_SAVE_EDIT+"=1 OR "+
                   Contract.priceEntry.TABLE_NAME+"."+Contract.priceEntry.COL_SAVE_EDIT+"=2)";
       }


        Cursor cur = db.rawQuery(sql, null);
        Toast.makeText(con,"cur   "+cur.getCount(),Toast.LENGTH_LONG).show();
        int count = cur.getCount();

        for (int i =0 ; i< count; i++)
        {
            cur.moveToNext();
            result.add(cur.getString(cur.getColumnIndex(Contract.priceEntry.COL_VARIETY_CODE)));
            result.add(cur.getString(cur.getColumnIndex(Contract.varietyEntry.COL_VARIETY_NAME)));

        }
        return   result;
    }

    public static List<String> GetVarietyDetails(SQLiteDatabase db ,String variety_code, Context con)
    {
        List<String>result=new ArrayList<String>();

        String sql ="SELECT * FROM "+Contract.varietyEntry.TABLE_NAME+","+Contract.unitEntry.TABLE_NAME+
                " WHERE "+Contract.varietyEntry.TABLE_NAME+"."+Contract.varietyEntry.COL_VARIETY_Unit
                +"="+Contract.unitEntry.TABLE_NAME+"."+Contract.unitEntry.COL_UNIT_CODE+" AND "+
                Contract.varietyEntry.COL_VARIETY_CODE+"='"+variety_code+"'";
    Cursor cur = db.rawQuery(sql, null);

        int count = cur.getCount();

        for (int i =0 ; i< count; i++)
        {

            cur.moveToNext();
            result.add(cur.getString(cur.getColumnIndex(Contract.varietyEntry.COL_VARIETY_NAME)));
            result.add(cur.getString(cur.getColumnIndex(Contract.unitEntry.COL_UNIT_NAME)));

        }
        return   result;
    }

    public  static int insert_Variety_Price(SQLiteDatabase db ,Context con ,String variety_code ,String outlet_code,String sheet_code, double price,Integer SAVE_EDIT)
    {
        int update_result=0;
        try
        {
            ContentValues cv=new ContentValues();
            cv.put(Contract.priceEntry.COL_PRICE , price );
            cv.put(Contract.priceEntry.COL_TIME, get_Current_DateTime());
            cv.put(Contract.priceEntry.COL_SAVE_EDIT, SAVE_EDIT);
          String whereCondition=Contract.priceEntry.COL_OUTLET_CODE+"='"+outlet_code+"' and "
                    +Contract.priceEntry.COL_VARIETY_CODE+"='"+variety_code+"' and "+
                    Contract.priceEntry.COL_SHEET_CODE+"='"+sheet_code+"'";
        update_result=  db.update(Contract.priceEntry.TABLE_NAME,cv,whereCondition,null);


        }
        catch (Exception exp)
        {
            Toast.makeText(con,"Exception = "+exp.getMessage(),Toast.LENGTH_LONG).show();
        }

        return  update_result;
    }

    public  static long add_outlet(SQLiteDatabase db ,Context con ,String outlet_name ,String outlet_address,String outlet_mobile, String outlet_tel)
    {
        long update_result=0;
        try
        {

            ContentValues cv=new ContentValues();
            cv.put(Contract.add_outletEntry.COL_OUTLET_NAME , outlet_name );
            cv.put(Contract.add_outletEntry.COL_OUTLET_ADD, outlet_address);
            cv.put(Contract.add_outletEntry.COL_OUTLET_MOBILE, outlet_mobile);
            cv.put(Contract.add_outletEntry.COL_OUTLET_TEL, outlet_tel);
            cv.put(Contract.add_outletEntry.COL_Time, get_Current_DateTime());
            update_result=  db.insert(Contract.add_outletEntry.TABLE_NAME,null,cv);


        }
        catch (Exception exp)
        {
            Toast.makeText(con,"Exception = "+exp.getMessage(),Toast.LENGTH_LONG).show();
        }

        return  update_result;
    }
     public static void DeleteData(SQLiteDatabase db , String table_name)
    {
        db.delete(table_name,null,null);


    }
    public static Cursor GetMessages(SQLiteDatabase db , Context con , String researcher_code)
    {

        String sql ="SELECT * FROM "+Contract.messagesEntry.TABLE_NAME+
                " WHERE "+Contract.messagesEntry.COL_Researcher_code +
                "='"+researcher_code+"'";

        Cursor cur = db.rawQuery(sql, null);
     return   cur;
    }

    public static Integer GetSheetDetails(SQLiteDatabase db, String sheet_code ) {
        String sql ="SELECT * FROM "+Contract.sheetEntry.TABLE_NAME +
                " WHERE "+Contract.sheetEntry.COL_SHEET_CODE+
                "='"+sheet_code+"'";
        Cursor cursor = db.rawQuery(sql, null);
        cursor.moveToNext();
        String sheet_to =cursor.getString(cursor.getColumnIndex(Contract.sheetEntry.COL_TIME_TO));
        Integer no_of_collecting = cursor.getInt(cursor.getColumnIndex(Contract.sheetEntry.COL_NUMBER_OF_COLLECTING));
        Calendar c = Calendar.getInstance();

            int mDay = c.get(Calendar.DAY_OF_MONTH);
        int wDay=c.get(Calendar.DAY_OF_WEEK);
        Integer deadline=-1;
            if (no_of_collecting==1)
            {
                  deadline=Integer.valueOf(sheet_to)-mDay+1;

            }
            else if (no_of_collecting==4)
            {

                if (wDay==Calendar.SATURDAY)
                    deadline=6;
                else
                    deadline=   Calendar.FRIDAY - wDay;

            }
                 return deadline;
    }
    public static Double GetInsertedPrice(SQLiteDatabase db , Context con , String variety_code ,String outlet_code)
    {

        String sql ="SELECT "+Contract.priceEntry.COL_PRICE+" FROM "+Contract.priceEntry.TABLE_NAME+
                " WHERE "+Contract.priceEntry.COL_VARIETY_CODE +"='"+variety_code+"' AND "+
                Contract.priceEntry.COL_OUTLET_CODE+"='"+outlet_code+"'";
        Cursor cur = db.rawQuery(sql, null);
        Double price=0.0;
        if (cur.getCount()>0)
        {
            cur.moveToNext();
            price=cur.getDouble(cur.getColumnIndex(Contract.priceEntry.COL_PRICE));

        }
        return   price;
    }


 }
