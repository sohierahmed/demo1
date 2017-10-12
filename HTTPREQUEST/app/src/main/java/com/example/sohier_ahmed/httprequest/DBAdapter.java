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


    public DBAdapter(Context con, Cursor curs, int flag)

    {
        //this is change ...just to test
        super(con, curs, flag);
        myCon = con;
        mFlag=flag;

    }


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

            Sheet_name.setText("نموذج "+cursor.getString(cursor.getColumnIndex(Contract.sheetEntry.COL_SHEET_CODE))+Form_name);

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

  }
