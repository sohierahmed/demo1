package com.example.sohier_ahmed.httprequest;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by sohier_ahmed on 09/08/2017.
 */

public class DBAdapter extends CursorAdapter {
    Context myCon;
    int mFlag;
 //  static String[] lst_sheets_codes ;

    public DBAdapter(Context con, Cursor curs, int flag)

    {
        super(con, curs, flag);
        myCon = con;
        mFlag=flag;
       // lst_sheets_codes = new String[curs.getCount()];
    }

  /*  @Override
   public View getView(int position, View convertView, ViewGroup parent) {
       *//* if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(myCon);
            convertView = inflater.inflate(R.layout.sheet_layout,
                    null);
        }
        convertView.setTag(position);
        return super.getView(position, convertView, parent);*//*
        View view = super.getView(position, convertView, parent);
        if (position % 2 == 1) {
            view.setBackgroundColor(Color.BLUE);
        } else {
            view.setBackgroundColor(Color.CYAN);
        }

        return view;
    }*/

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        LayoutInflater inflater;
        View view;
        if (mFlag == 1)
        {
            inflater = LayoutInflater.from(parent.getContext());
            view = inflater.inflate(R.layout.sheet_layout, parent, false);
        }
        else
        {
            inflater = LayoutInflater.from(parent.getContext());
            view = inflater.inflate(R.layout.lst_messages, parent, false);
        }


        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {


        if (mFlag==1 )
        {
            String Form_name=cursor.getString(cursor.getColumnIndex(Contract.formEntry.COL_FORM_NAME));
            TextView Sheet_name = (TextView) view.findViewById(R.id.txt_sheet_name);
           // TextView Sheet_Code = (TextView) view.findViewById(R.id.txt_sheet_Disc);
            Sheet_name.setText("نموذج "+cursor.getString(cursor.getColumnIndex(Contract.sheetEntry.COL_SHEET_CODE))+Form_name);
           // String sheet_from =cursor.getString(cursor.getColumnIndex(Contract.sheetEntry.COL_TIME_FROM));
           /* String sheet_to =cursor.getString(cursor.getColumnIndex(Contract.sheetEntry.COL_TIME_TO));
            Integer no_of_collecting = cursor.getInt(cursor.getColumnIndex(Contract.sheetEntry.COL_NUMBER_OF_COLLECTING));
            Calendar c = Calendar.getInstance();

            int mDay = c.get(Calendar.DAY_OF_MONTH);

            if (no_of_collecting==1)
            {
                 Integer deadline=Integer.valueOf(sheet_to)-mDay+1;
                TextView txt_sheet_details =(TextView)view.findViewById(R.id.txt_sheet_details);
                txt_sheet_details.setText("باقى من الوقت " );
                GetSheetDetails();


            }*/

        }
        else
        if (mFlag==0 )
        {
            TextView message_text = (TextView) view.findViewById(R.id.txt_message_text);
            TextView sender = (TextView) view.findViewById(R.id.txt_message_sender);
            TextView send_time = (TextView) view.findViewById(R.id.txt_send_time);
            message_text.setText(cursor.getString(cursor.getColumnIndex(Contract.messagesEntry.COL_messge_text)));
            sender.setText(cursor.getString(cursor.getColumnIndex(Contract.messagesEntry.COL_sender)));
            send_time.setText(cursor.getString(cursor.getColumnIndex(Contract.messagesEntry.COL_time)));
        }


    }

   /* private void GetSheetDetails() {
        TextView txt_sheet_details =(TextView)fi(R.id.txt_sheet_details);
        txt_sheet_details.setText("باقى من الوقت " );
    }*/
   /* public void bindView(View view, Context context, Cursor cursor) {
        Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);
        int wDay=c.get(Calendar.DAY_OF_WEEK);
        // display the current date
        String CurrentDate = mYear + "/" + mMonth + "/" + mDay;
        String Form_name=cursor.getString(cursor.getColumnIndex(Contract.formEntry.COL_FORM_NAME));
        TextView Sheet_name = (TextView) view.findViewById(R.id.txt_sheet_name);
        TextView Sheet_Code = (TextView) view.findViewById(R.id.txt_sheet_Disc);
       if (mFlag==1 )
        {
           if( cursor.getInt(cursor.getColumnIndex(Contract.sheetEntry.COL_NUMBER_OF_COLLECTING))==1)
           {
               int sheet_from_date=Integer.valueOf(cursor.getString(cursor.getColumnIndex(Contract.sheetEntry.COL_TIME_FROM)));
               int sheet_to_date=Integer.valueOf(cursor.getString(cursor.getColumnIndex(Contract.sheetEntry.COL_TIME_TO)));

               if(mDay>=sheet_from_date && mDay <=sheet_to_date)
               {
                   Sheet_name.setText(cursor.getString(cursor.getColumnIndex(Contract.sheetEntry.COL_SHEET_NAME))+Form_name);
                  // lst_sheets_codes.(String.valueOf(cursor.getColumnIndex(Contract.sheetEntry.COL_SHEET_CODE)));
                  // Sheet_Code.setText(String.valueOf(cursor.getInt(cursor.getColumnIndex(Contract.sheetEntry.COL_NUMBER_OF_COLLECTING))));
               }

           }
           else  if( cursor.getInt(cursor.getColumnIndex(Contract.sheetEntry.COL_NUMBER_OF_COLLECTING))==0)
           {
                *//*if(mMonth==8)
                {*//*
                    Sheet_name.setText(cursor.getString(cursor.getColumnIndex(Contract.sheetEntry.COL_SHEET_NAME))+Form_name);
             //  lst_sheets_codes.add(String.valueOf(cursor.getColumnIndex(Contract.sheetEntry.COL_SHEET_CODE)));
                   // Sheet_Code.setText(String.valueOf(cursor.getInt(cursor.getColumnIndex(Contract.sheetEntry.COL_NUMBER_OF_COLLECTING))));
               *//* }*//*

           }
           else  if( cursor.getInt(cursor.getColumnIndex(Contract.sheetEntry.COL_NUMBER_OF_COLLECTING))==4)
           {
               switch (wDay) {
                   case Calendar.SATURDAY: case Calendar.SUNDAY:
                   case Calendar.MONDAY: case Calendar.TUESDAY:
                   case Calendar.WEDNESDAY:  case Calendar.THURSDAY:
                       Sheet_name.setText(cursor.getString(cursor.getColumnIndex(Contract.sheetEntry.COL_SHEET_NAME))+Form_name);
                    //   lst_sheets_codes.add(String.valueOf(cursor.getColumnIndex(Contract.sheetEntry.COL_SHEET_CODE)));
                    //   Sheet_Code.setText(String.valueOf(cursor.getInt(cursor.getColumnIndex(Contract.sheetEntry.COL_NUMBER_OF_COLLECTING))));
                       break;
               }




           }
          //  this.notifyDataSetChanged();
              *//* lst_sheets.add(cursor.getString(cursor.getColumnIndex(Contract.sheetEntry.COL_SHEET_NAME)));*//*

        }
     *//*   TextView Sheet_name = (TextView) view.findViewById(R.id.txt_sheet_name);
        Sheet_name.setText(cursor.getString(cursor.getColumnIndex(Contract.formEntry.COL_FORM_NAME)));

        TextView Sheet_Code = (TextView) view.findViewById(R.id.txt_sheet_Disc);
        Sheet_Code.setText(cursor.getString(cursor.getColumnIndex(Contract.formEntry.COL_FORM_CODE)));*//*
    }*/
}
