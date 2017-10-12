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
  /*  public  static void insertData(SQLiteDatabase db)
    {
        DeleteData(db,Contract.formEntry.TABLE_NAME);
        ContentValues cv=new ContentValues();
        cv.put(Contract.formEntry.COL_FORM_CODE ,"714/1");
        cv.put(Contract.formEntry.COL_FORM_NAME ,"غذائى");
        db.insert(Contract.formEntry.TABLE_NAME,null,cv);
        cv=new ContentValues();
        cv.put(Contract.formEntry.COL_FORM_CODE ,"714/2");
        cv.put(Contract.formEntry.COL_FORM_NAME ,"صناعى");
        db.insert(Contract.formEntry.TABLE_NAME,null,cv);
        cv=new ContentValues();
        cv.put(Contract.formEntry.COL_FORM_CODE ,"715/1");
        cv.put(Contract.formEntry.COL_FORM_NAME ,"خدمات");
        db.insert(Contract.formEntry.TABLE_NAME,null,cv);

    }
    public  static void insertData_sheet(SQLiteDatabase db)
    {
        DeleteData(db,Contract.sheetEntry.TABLE_NAME);
        ContentValues cv=new ContentValues();
        cv.put(Contract.sheetEntry.COL_SHEET_CODE ,"1");
        cv.put(Contract.sheetEntry.COL_SHEET_NAME,"نموذج 1");
        cv.put(Contract.sheetEntry.COL_FORM_CODE ,"714/1");
        cv.put(Contract.sheetEntry.COL_NUMBER_OF_COLLECTING ,1);
        cv.put(Contract.sheetEntry.COL_TIME_FROM ,"15");
        cv.put(Contract.sheetEntry.COL_TIME_TO ,"21");
        db.insert(Contract.sheetEntry.TABLE_NAME,null,cv);
        //row 2
        cv=new ContentValues();
        cv.put(Contract.sheetEntry.COL_SHEET_CODE ,"2");
        cv.put(Contract.sheetEntry.COL_SHEET_NAME,"نموذج 2");
        cv.put(Contract.sheetEntry.COL_FORM_CODE ,"714/1");
        cv.put(Contract.sheetEntry.COL_NUMBER_OF_COLLECTING ,4);
        db.insert(Contract.sheetEntry.TABLE_NAME,null,cv);
        //row3
        cv=new ContentValues();
        cv.put(Contract.sheetEntry.COL_SHEET_CODE ,"3");
        cv.put(Contract.sheetEntry.COL_SHEET_NAME,"نموذج 3");
        cv.put(Contract.sheetEntry.COL_FORM_CODE ,"714/1");
        cv.put(Contract.sheetEntry.COL_NUMBER_OF_COLLECTING ,4);
        db.insert(Contract.sheetEntry.TABLE_NAME,null,cv);

        //row 4
        cv=new ContentValues();
        cv.put(Contract.sheetEntry.COL_SHEET_CODE ,"4");
        cv.put(Contract.sheetEntry.COL_SHEET_NAME,"نموذج 4");
        cv.put(Contract.sheetEntry.COL_FORM_CODE ,"714/1");
        cv.put(Contract.sheetEntry.COL_NUMBER_OF_COLLECTING ,1);
        cv.put(Contract.sheetEntry.COL_TIME_FROM ,"15");
        cv.put(Contract.sheetEntry.COL_TIME_TO ,"21");
        db.insert(Contract.sheetEntry.TABLE_NAME,null,cv);
        //row 5
        cv=new ContentValues();
        cv.put(Contract.sheetEntry.COL_SHEET_CODE ,"5");
        cv.put(Contract.sheetEntry.COL_SHEET_NAME,"نموذج 5");
        cv.put(Contract.sheetEntry.COL_FORM_CODE ,"714/1");
        cv.put(Contract.sheetEntry.COL_NUMBER_OF_COLLECTING ,1);
        cv.put(Contract.sheetEntry.COL_TIME_FROM ,"15");
        cv.put(Contract.sheetEntry.COL_TIME_TO ,"21");
        db.insert(Contract.sheetEntry.TABLE_NAME,null,cv);

        //row 6
        cv=new ContentValues();
        cv.put(Contract.sheetEntry.COL_SHEET_CODE ,"6");
        cv.put(Contract.sheetEntry.COL_SHEET_NAME,"نموذج 6");
        cv.put(Contract.sheetEntry.COL_FORM_CODE ,"714/2");
        cv.put(Contract.sheetEntry.COL_NUMBER_OF_COLLECTING ,1);
        cv.put(Contract.sheetEntry.COL_TIME_FROM ,"1");
        cv.put(Contract.sheetEntry.COL_TIME_TO ,"12");
        db.insert(Contract.sheetEntry.TABLE_NAME,null,cv);

        //row 7
        cv=new ContentValues();
        cv.put(Contract.sheetEntry.COL_SHEET_CODE ,"7");
        cv.put(Contract.sheetEntry.COL_SHEET_NAME,"نموذج 7");
        cv.put(Contract.sheetEntry.COL_FORM_CODE ,"714/2");
        cv.put(Contract.sheetEntry.COL_NUMBER_OF_COLLECTING ,1);
        cv.put(Contract.sheetEntry.COL_TIME_FROM ,"1");
        cv.put(Contract.sheetEntry.COL_TIME_TO ,"12");
        db.insert(Contract.sheetEntry.TABLE_NAME,null,cv);

        //row 8
        cv=new ContentValues();
        cv.put(Contract.sheetEntry.COL_SHEET_CODE ,"8");
        cv.put(Contract.sheetEntry.COL_SHEET_NAME,"نموذج 8");
        cv.put(Contract.sheetEntry.COL_FORM_CODE ,"714/2");
        cv.put(Contract.sheetEntry.COL_NUMBER_OF_COLLECTING ,1);
        cv.put(Contract.sheetEntry.COL_TIME_FROM ,"1");
        cv.put(Contract.sheetEntry.COL_TIME_TO ,"12");
        db.insert(Contract.sheetEntry.TABLE_NAME,null,cv);
        //row 9
        cv=new ContentValues();
        cv.put(Contract.sheetEntry.COL_SHEET_CODE ,"A");
        cv.put(Contract.sheetEntry.COL_SHEET_NAME,"نموذج A");
        cv.put(Contract.sheetEntry.COL_FORM_CODE ,"715/1");
        cv.put(Contract.sheetEntry.COL_NUMBER_OF_COLLECTING ,1);
        cv.put(Contract.sheetEntry.COL_TIME_FROM ,"8");
        cv.put(Contract.sheetEntry.COL_TIME_TO ,"14");
        db.insert(Contract.sheetEntry.TABLE_NAME,null,cv);


        //row 10
        cv=new ContentValues();
        cv.put(Contract.sheetEntry.COL_SHEET_CODE ,"B");
        cv.put(Contract.sheetEntry.COL_SHEET_NAME,"نموذج B");
        cv.put(Contract.sheetEntry.COL_FORM_CODE ,"715/1");
        cv.put(Contract.sheetEntry.COL_NUMBER_OF_COLLECTING ,0);
        cv.put(Contract.sheetEntry.COL_TIME_FROM ,"8");
        cv.put(Contract.sheetEntry.COL_TIME_TO ,"14");
        db.insert(Contract.sheetEntry.TABLE_NAME,null,cv);
        //row 11
        cv=new ContentValues();
        cv.put(Contract.sheetEntry.COL_SHEET_CODE ,"C");
        cv.put(Contract.sheetEntry.COL_SHEET_NAME,"نموذج C");
        cv.put(Contract.sheetEntry.COL_FORM_CODE ,"715/1");
        cv.put(Contract.sheetEntry.COL_NUMBER_OF_COLLECTING ,3);

        db.insert(Contract.sheetEntry.TABLE_NAME,null,cv);

    }

    public  static void insertData_Outlet(SQLiteDatabase db , Context con)
    {
        try
        {
            // Toast.makeText(con,"insertData_Outlet  ",Toast.LENGTH_LONG).show();
            DeleteData(db,Contract.outletEntry.TABLE_NAME);
            ContentValues cv=new ContentValues();
            cv.put(Contract.outletEntry.COL_OUTLET_CODE ,"1");
            cv.put(Contract.outletEntry.COL_OUTLET_NAME,"مصدر 1");
            cv.put(Contract.outletEntry.COL_OUTLET_ADD ,"عنوان 1");
            cv.put(Contract.outletEntry.COL_OUTLET_MOBILE ,"010");
            cv.put(Contract.outletEntry.COL_OUTLET_TEL,"02");
            cv.put(Contract.outletEntry.COL_REGION_CODE ,"0101");
            db.insert(Contract.outletEntry.TABLE_NAME,null,cv);
            //row 2
            cv=new ContentValues();
            cv.put(Contract.outletEntry.COL_OUTLET_CODE ,"2");
            cv.put(Contract.outletEntry.COL_OUTLET_NAME,"مصدر 2");
            cv.put(Contract.outletEntry.COL_OUTLET_ADD ,"عنوان 2");
            cv.put(Contract.outletEntry.COL_OUTLET_MOBILE ,"010");
            cv.put(Contract.outletEntry.COL_OUTLET_TEL,"0201010");
            cv.put(Contract.outletEntry.COL_REGION_CODE ,"0101");
            db.insert(Contract.outletEntry.TABLE_NAME,null,cv);
            //row3
            cv=new ContentValues();
            cv.put(Contract.outletEntry.COL_OUTLET_CODE ,"3");
            cv.put(Contract.outletEntry.COL_OUTLET_NAME,"مصدر 3");
            cv.put(Contract.outletEntry.COL_OUTLET_ADD ,"عنوان 3");
            cv.put(Contract.outletEntry.COL_OUTLET_MOBILE ,"01003");
            cv.put(Contract.outletEntry.COL_OUTLET_TEL,"03");
            cv.put(Contract.outletEntry.COL_REGION_CODE ,"0102");
            db.insert(Contract.outletEntry.TABLE_NAME,null,cv);
            //row 4
            cv=new ContentValues();
            cv.put(Contract.outletEntry.COL_OUTLET_CODE ,"4");
            cv.put(Contract.outletEntry.COL_OUTLET_NAME,"مصدر 4");
            cv.put(Contract.outletEntry.COL_OUTLET_ADD ,"عنوان 4");
            cv.put(Contract.outletEntry.COL_OUTLET_MOBILE ,"01204");
            cv.put(Contract.outletEntry.COL_OUTLET_TEL,"04");
            cv.put(Contract.outletEntry.COL_REGION_CODE ,"0101");
            db.insert(Contract.outletEntry.TABLE_NAME,null,cv);
            //row 5
            cv=new ContentValues();
            cv.put(Contract.outletEntry.COL_OUTLET_CODE ,"5");
            cv.put(Contract.outletEntry.COL_OUTLET_NAME,"مصدر 5");
            cv.put(Contract.outletEntry.COL_OUTLET_ADD ,"عنوان 5");
            cv.put(Contract.outletEntry.COL_OUTLET_MOBILE ,"01205");
            cv.put(Contract.outletEntry.COL_OUTLET_TEL,"05");
            cv.put(Contract.outletEntry.COL_REGION_CODE ,"0101");
            db.insert(Contract.outletEntry.TABLE_NAME,null,cv);

            Cursor cur = db.query(Contract.outletEntry.TABLE_NAME,null,null,null,null,null,null);
            //Toast.makeText(con,"query after insert "+cur.getCount(),Toast.LENGTH_LONG).show();
        }

        catch (Exception exp)
        {
            Toast.makeText(con,exp.getMessage(),Toast.LENGTH_LONG).show();
        }


    }

    public  static void insertData_Price(SQLiteDatabase db ,Context con )
    {
        // Toast.makeText(con,"insertData_Price  ",Toast.LENGTH_LONG).show();
        try
        {

            DeleteData(db,Contract.priceEntry.TABLE_NAME);

            ContentValues cv=new ContentValues();
            cv.put(Contract.priceEntry.COL_OUTLET_CODE ,"1");
            cv.put(Contract.priceEntry.COL_REGION_CODE,"0101");
            cv.put(Contract.priceEntry.COL_SHEET_CODE ,"2");
            cv.put(Contract.priceEntry.COL_VARIETY_CODE ,"09");
            db.insert(Contract.priceEntry.TABLE_NAME,null,cv);
            //row 2
            cv=new ContentValues();
            cv.put(Contract.priceEntry.COL_OUTLET_CODE ,"2");
            cv.put(Contract.priceEntry.COL_REGION_CODE,"0101");
            cv.put(Contract.priceEntry.COL_SHEET_CODE ,"2");
            cv.put(Contract.priceEntry.COL_VARIETY_CODE ,"08");
            db.insert(Contract.priceEntry.TABLE_NAME,null,cv);
            //row3
            cv=new ContentValues();
            cv.put(Contract.priceEntry.COL_OUTLET_CODE ,"3");
            cv.put(Contract.priceEntry.COL_REGION_CODE,"0101");
            cv.put(Contract.priceEntry.COL_SHEET_CODE ,"2");
            cv.put(Contract.priceEntry.COL_VARIETY_CODE ,"07");
            db.insert(Contract.priceEntry.TABLE_NAME,null,cv);
            //row 4

            cv=new ContentValues();
            cv.put(Contract.priceEntry.COL_OUTLET_CODE ,"4");
            cv.put(Contract.priceEntry.COL_REGION_CODE,"0101");
            cv.put(Contract.priceEntry.COL_SHEET_CODE ,"1");
            cv.put(Contract.priceEntry.COL_VARIETY_CODE ,"05");
            db.insert(Contract.priceEntry.TABLE_NAME,null,cv);


            //row 5

            cv=new ContentValues();
            cv.put(Contract.priceEntry.COL_OUTLET_CODE ,"5");
            cv.put(Contract.priceEntry.COL_REGION_CODE,"0101");
            cv.put(Contract.priceEntry.COL_SHEET_CODE ,"7");
            cv.put(Contract.priceEntry.COL_VARIETY_CODE ,"09");
            db.insert(Contract.priceEntry.TABLE_NAME,null,cv);

            //row 6
            cv=new ContentValues();
            cv.put(Contract.priceEntry.COL_OUTLET_CODE ,"1");
            cv.put(Contract.priceEntry.COL_REGION_CODE,"0101");
            cv.put(Contract.priceEntry.COL_SHEET_CODE ,"B");
            cv.put(Contract.priceEntry.COL_VARIETY_CODE ,"12");
            db.insert(Contract.priceEntry.TABLE_NAME,null,cv);
            //row 7
            cv=new ContentValues();
            cv.put(Contract.priceEntry.COL_OUTLET_CODE ,"2");
            cv.put(Contract.priceEntry.COL_REGION_CODE,"0101");
            cv.put(Contract.priceEntry.COL_SHEET_CODE ,"2");
            cv.put(Contract.priceEntry.COL_VARIETY_CODE ,"01");
            db.insert(Contract.priceEntry.TABLE_NAME,null,cv);
            //row 8
            cv=new ContentValues();
            cv.put(Contract.priceEntry.COL_OUTLET_CODE ,"2");
            cv.put(Contract.priceEntry.COL_REGION_CODE,"0101");
            cv.put(Contract.priceEntry.COL_SHEET_CODE ,"2");
            cv.put(Contract.priceEntry.COL_VARIETY_CODE ,"02");
            db.insert(Contract.priceEntry.TABLE_NAME,null,cv);
            //row 8
            cv=new ContentValues();
            cv.put(Contract.priceEntry.COL_OUTLET_CODE ,"2");
            cv.put(Contract.priceEntry.COL_REGION_CODE,"0101");
            cv.put(Contract.priceEntry.COL_SHEET_CODE ,"2");
            cv.put(Contract.priceEntry.COL_VARIETY_CODE ,"03");
            db.insert(Contract.priceEntry.TABLE_NAME,null,cv);
            Cursor cur = db.query(Contract.priceEntry.TABLE_NAME,null,null,null,null,null,null);
            //  Toast.makeText(con,"query after insert "+cur.getCount(),Toast.LENGTH_LONG).show();
        }
        catch (Exception exp)
        {
            Toast.makeText(con,exp.getMessage(),Toast.LENGTH_LONG).show();
        }



    }


    public  static int insert_Variety_Price(SQLiteDatabase db ,Context con ,String variety_code ,String outlet_code,String sheet_code, Double price)
    {

        ContentValues cv=new ContentValues();
        cv.put(Contract.priceEntry.COL_PRICE ,price);
        cv.put(Contract.priceEntry.COL_TIME, get_Current_DateTime());

        String whereCondition=Contract.priceEntry.COL_OUTLET_CODE+"='"+outlet_code+"' and "
                +Contract.priceEntry.COL_VARIETY_CODE+"='"+variety_code+"' and "+
                Contract.priceEntry.COL_SHEET_CODE+"='"+sheet_code+"'";
        Toast.makeText(con,"where Condition = "+whereCondition,Toast.LENGTH_LONG).show();
        int update_result=  db.update(Contract.priceEntry.TABLE_NAME,cv,whereCondition,null);
        Toast.makeText(con,"update_result = "+update_result,Toast.LENGTH_LONG).show();
        return  update_result;
    }*/

    public static void get_Variety_Price(SQLiteDatabase db ,Context con ,String variety_code ,String outlet_code,String sheet_code)
    {
        String whereCondition=Contract.priceEntry.COL_OUTLET_CODE+"='"+outlet_code+"' and "
                +Contract.priceEntry.COL_VARIETY_CODE+"='"+variety_code+"' and "+
                Contract.priceEntry.COL_SHEET_CODE+"='"+sheet_code+"'";
        Cursor curs=  db.query(Contract.priceEntry.TABLE_NAME,null,whereCondition,null,null,null,null);
      //  Toast.makeText(con,"get_Variety_Price result = "+curs.getCount(),Toast.LENGTH_LONG).show();
        curs.moveToFirst();
    /*    Toast.makeText(con,"get_Variety_Price>>>>>> variety code = "+curs.getString(curs.getColumnIndex(Contract.priceEntry.COL_VARIETY_CODE)),Toast.LENGTH_LONG).show();
        Toast.makeText(con,"get_Variety_Price>>>>>> outlet code = "+curs.getString(curs.getColumnIndex(Contract.priceEntry.COL_OUTLET_CODE)),Toast.LENGTH_LONG).show();
        Toast.makeText(con,"get_Variety_Price>>>>>> sheet code = "+curs.getString(curs.getColumnIndex(Contract.priceEntry.COL_SHEET_CODE)),Toast.LENGTH_LONG).show();
        Toast.makeText(con,"get_Variety_Price>>>>>> price= "+curs.getString(curs.getColumnIndex(Contract.priceEntry.COL_PRICE)),Toast.LENGTH_LONG).show();
        Toast.makeText(con,"get_Variety_Price>>>>>> Time = "+curs.getString(curs.getColumnIndex(Contract.priceEntry.COL_TIME)),Toast.LENGTH_LONG).show();*/
    }
    private static String get_Current_DateTime()
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);
    }
    /* public String get_Current_DateTime() {
         SimpleDateFormat dateFormat = new SimpleDateFormat(
                 "yyyy-MM-dd HH:mm:ss", Locale.getDefault());
         Date date = new Date();
         return dateFormat.format(date);
     }*/
  /*  public static Cursor GetData(SQLiteDatabase db)
    {
        String sql ="SELECT * FROM "+Contract.sheetEntry.TABLE_NAME+","+Contract.formEntry.TABLE_NAME+
                " WHERE "+Contract.sheetEntry.TABLE_NAME+"."+ Contract.sheetEntry.COL_FORM_CODE +
                "="+
                Contract.formEntry.TABLE_NAME+"."+Contract.formEntry.COL_FORM_CODE ;
        Cursor cur = db.rawQuery(sql, null);
       // Cursor cur = db.query(Contract.sheetEntry.TABLE_NAME,null,null,null,null,null,Contract.sheetEntry.COL_SHEET_CODE);

        return   cur;
    }*/
    public static Cursor GetSheetNames(SQLiteDatabase db , Context con)
    {
        Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH)+1;
        int mDay = c.get(Calendar.DAY_OF_MONTH);
        int wDay=c.get(Calendar.DAY_OF_WEEK);
        // display the current date
        String CurrentDate = mYear + "/" + mMonth + "/" + mDay;
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
      /*  Toast.makeText(con ," mMonth "+mMonth,Toast.LENGTH_LONG).show();
        Toast.makeText(con ," new query "+sql,Toast.LENGTH_LONG).show();*/
        Cursor cur = db.rawQuery(sql, null);
        //Toast.makeText(con ," new query  result = "+cur.getCount(),Toast.LENGTH_LONG).show();
        // Cursor cur = db.query(Contract.sheetEntry.TABLE_NAME,null,null,null,null,null,Contract.sheetEntry.COL_SHEET_CODE);

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
            // int index=cur.getColumnIndex(Contract.outletEntry.COL_OUTLET_NAME);
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
      /*  Toast.makeText(con ," mMonth "+mMonth,Toast.LENGTH_LONG).show();*/
        //   Toast.makeText(con ," new query "+sql,Toast.LENGTH_LONG).show();
        Cursor cur = db.rawQuery(sql, null);
        //  Toast.makeText(con ," new query  result = "+cur.getCount(),Toast.LENGTH_LONG).show();
        // Cursor cur = db.query(Contract.sheetEntry.TABLE_NAME,null,null,null,null,null,Contract.sheetEntry.COL_SHEET_CODE);
        int count = cur.getCount();
       /* int column_count=cur.getColumnCount();
        for (int i =0 ; i< column_count; i++)
        {
            Toast.makeText(con,"column name  "+cur.getColumnName(i),Toast.LENGTH_LONG).show();
        }*/
        // Toast.makeText(con,"count=  "+count,Toast.LENGTH_LONG).show();

        //   values = new Object[count];
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
          /*  Toast.makeText(con,"price  = "+price,Toast.LENGTH_LONG).show();
            Toast.makeText(con,"COL_SAVE_EDIT  = "+cv.getAsString(Contract.priceEntry.COL_SAVE_EDIT),Toast.LENGTH_LONG).show();*/
            String whereCondition=Contract.priceEntry.COL_OUTLET_CODE+"='"+outlet_code+"' and "
                    +Contract.priceEntry.COL_VARIETY_CODE+"='"+variety_code+"' and "+
                    Contract.priceEntry.COL_SHEET_CODE+"='"+sheet_code+"'";
           // Toast.makeText(con,"where Condition = "+whereCondition,Toast.LENGTH_LONG).show();
            update_result=  db.update(Contract.priceEntry.TABLE_NAME,cv,whereCondition,null);
         //   Toast.makeText(con,"update_result = "+update_result,Toast.LENGTH_LONG).show();

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
           // cv.put(Contract.add_outletEntry.COL_REGION_CODE, "1");
            update_result=  db.insert(Contract.add_outletEntry.TABLE_NAME,null,cv);
            //   Toast.makeText(con,"update_result = "+update_result,Toast.LENGTH_LONG).show();
          /*  String ROW1 = "INSERT INTO " + Contract.add_outletEntry.TABLE_NAME + " ("
                    + Contract.add_outletEntry.COL_OUTLET_NAME + ", " + Contract.add_outletEntry.COL_OUTLET_ADD + ", "
                    + Contract.add_outletEntry.COL_OUTLET_MOBILE + ", " + Contract.add_outletEntry.COL_OUTLET_TEL + ", "
                    + Contract.add_outletEntry.COL_Time + ") Values ('"+outlet_name
                    +"','"+outlet_address+"','"+outlet_mobile+"','"+outlet_tel+"','"+get_Current_DateTime() +"')";
            db.execSQL(ROW1);*/

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
       /* Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH)+1;
        int mDay = c.get(Calendar.DAY_OF_MONTH);
        int wDay=c.get(Calendar.DAY_OF_WEEK);
        // display the current date
        String CurrentDate = mYear + "/" + mMonth + "/" + mDay;*/
        String sql ="SELECT * FROM "+Contract.messagesEntry.TABLE_NAME+
                " WHERE "+Contract.messagesEntry.COL_Researcher_code +
                "='"+researcher_code+"'";
      /*  Toast.makeText(con ," mMonth "+mMonth,Toast.LENGTH_LONG).show();*/
       // Toast.makeText(con ," new query "+sql,Toast.LENGTH_LONG).show();
        Cursor cur = db.rawQuery(sql, null);
        // Toast.makeText(con ," new query  result = "+cur.getCount(),Toast.LENGTH_LONG).show();
        // Cursor cur = db.query(Contract.sheetEntry.TABLE_NAME,null,null,null,null,null,Contract.sheetEntry.COL_SHEET_CODE);

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


  /*  public static Integer getNoOfOutlets()
    {
        String sql ="SELECT COUNT("+Contract.priceEntry.COL_OUTLET_CODE+") FROM "+Contract.messagesEntry.TABLE_NAME+
                " WHERE "+Contract.messagesEntry.COL_Researcher_code +
                "='"+researcher_code+"'";
      *//*  Toast.makeText(con ," mMonth "+mMonth,Toast.LENGTH_LONG).show();*//*
        // Toast.makeText(con ," new query "+sql,Toast.LENGTH_LONG).show();
        Cursor cur = db.rawQuery(sql, null);
    }*/
  /*  public  static void insertData_variety(SQLiteDatabase db , Context con)
    {
        try
        {
            //Toast.makeText(con,"insertData_variety  ",Toast.LENGTH_LONG).show();
            //row1
            DeleteData(db,Contract.varietyEntry.TABLE_NAME);
            ContentValues cv=new ContentValues();
            cv.put(Contract.varietyEntry.COL_VARIETY_CODE ,"09");
            cv.put(Contract.varietyEntry.COL_VARIETY_GROUP_CODE,"08");
            cv.put(Contract.varietyEntry.COL_VARIETY_NAME,"سلعة 9");
            db.insert(Contract.varietyEntry.TABLE_NAME,null,cv);
            //row2
            cv=new ContentValues();
            cv.put(Contract.varietyEntry.COL_VARIETY_CODE ,"08");
            cv.put(Contract.varietyEntry.COL_VARIETY_GROUP_CODE,"08");
            cv.put(Contract.varietyEntry.COL_VARIETY_NAME,"سلعة8");
            db.insert(Contract.varietyEntry.TABLE_NAME,null,cv);

            //row3
            cv=new ContentValues();
            cv.put(Contract.varietyEntry.COL_VARIETY_CODE ,"07");
            cv.put(Contract.varietyEntry.COL_VARIETY_GROUP_CODE,"08");
            cv.put(Contract.varietyEntry.COL_VARIETY_NAME,"سلعة 7");
            db.insert(Contract.varietyEntry.TABLE_NAME,null,cv);

            //row4
            cv=new ContentValues();
            cv.put(Contract.varietyEntry.COL_VARIETY_CODE ,"05");
            cv.put(Contract.varietyEntry.COL_VARIETY_GROUP_CODE,"08");
            cv.put(Contract.varietyEntry.COL_VARIETY_NAME,"سلعة 5");
            db.insert(Contract.varietyEntry.TABLE_NAME,null,cv);
            //row4
            cv=new ContentValues();
            cv.put(Contract.varietyEntry.COL_VARIETY_CODE ,"12");
            cv.put(Contract.varietyEntry.COL_VARIETY_GROUP_CODE,"08");
            cv.put(Contract.varietyEntry.COL_VARIETY_NAME,"سلعة 12");
            db.insert(Contract.varietyEntry.TABLE_NAME,null,cv);
            //row5
            cv=new ContentValues();
            cv.put(Contract.varietyEntry.COL_VARIETY_CODE ,"01");
            cv.put(Contract.varietyEntry.COL_VARIETY_GROUP_CODE,"08");
            cv.put(Contract.varietyEntry.COL_VARIETY_NAME,"سلعة 1");
            db.insert(Contract.varietyEntry.TABLE_NAME,null,cv);
            //row6
            cv=new ContentValues();
            cv.put(Contract.varietyEntry.COL_VARIETY_CODE ,"02");
            cv.put(Contract.varietyEntry.COL_VARIETY_GROUP_CODE,"08");
            cv.put(Contract.varietyEntry.COL_VARIETY_NAME,"سلعة2");
            db.insert(Contract.varietyEntry.TABLE_NAME,null,cv);
            //row7
            cv=new ContentValues();
            cv.put(Contract.varietyEntry.COL_VARIETY_CODE ,"03");
            cv.put(Contract.varietyEntry.COL_VARIETY_GROUP_CODE,"08");
            cv.put(Contract.varietyEntry.COL_VARIETY_NAME,"سلعة3");
            db.insert(Contract.varietyEntry.TABLE_NAME,null,cv);
            Cursor cur = db.query(Contract.varietyEntry.TABLE_NAME,null,null,null,null,null,null);
            //  Toast.makeText(con,"query after insert varieties "+cur.getCount(),Toast.LENGTH_LONG).show();
        }

        catch (Exception exp)
        {
            Toast.makeText(con,exp.getMessage(),Toast.LENGTH_LONG).show();
        }


    }
    public  static void insertData_variety_Group(SQLiteDatabase db , Context con)
    {
        try
        {
            //  Toast.makeText(con,"insertData_variety_group  ",Toast.LENGTH_LONG).show();

            ContentValues cv=new ContentValues();
            cv.put(Contract.variety_groupEntry.COL_VARIETY_GROUP_CODE ,"08");
            cv.put(Contract.variety_groupEntry.COL_VARIETY_GROUP_NAME,"مجموعة1");
            cv.put(Contract.variety_groupEntry.COL_SHEET_CODE,"1");

            db.insert(Contract.variety_groupEntry.TABLE_NAME,null,cv);
            Cursor cur = db.query(Contract.variety_groupEntry.TABLE_NAME,null,null,null,null,null,null);
            //    Toast.makeText(con,"query after insert "+cur.getCount(),Toast.LENGTH_LONG).show();
        }

        catch (Exception exp)
        {
            Toast.makeText(con,exp.getMessage(),Toast.LENGTH_LONG).show();
        }


    }*/

   /* public static void DeleteData(SQLiteDatabase db , String table_name)
    {
        db.delete(table_name,null,null);


    }*/

  /*  private static Cursor ConvertToNewCursor(Cursor curs)
    {

        int count = curs.getColumnCount();
        String[] col_names ;
      //  Object [] values;
        col_names = new String[count];
     //   values = new Object[count];
        for (int i =0 ; i< count; i++)
        {
            String data = curs.getString(i);
            String column_name = curs.getColumnName(i);
            col_names[i]=column_name;
           // values[i]=data;
        }
        startManagingCursor

        // Create a MatrixCursor filled with the rows you want to add.
        MatrixCursor matrixCursor = new MatrixCursor(col_names);


// Merge your existing cursor with the matrixCursor you created.
        MergeCursor mergeCursor = new MergeCursor(new Cursor[] { matrixCursor, curs });
        return  mergeCursor;
    }*/
}
