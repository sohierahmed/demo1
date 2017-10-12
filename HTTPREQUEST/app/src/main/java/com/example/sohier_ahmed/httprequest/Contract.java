package com.example.sohier_ahmed.httprequest;

import android.provider.BaseColumns;

/**
 * Created by Sohier_ahmed on 20/08/2017.
 */

public class Contract {
    //جدول الاستمارات
    public static  final class formEntry implements BaseColumns
    {
        public static  final String TABLE_NAME="Forms";
        public static  final String  COL_FORM_CODE="form_code";
        public static  final String  COL_FORM_NAME="form_name";
    }

    //جدول النماذج
    public static  final class sheetEntry implements BaseColumns
    {
        public static  final String TABLE_NAME="Sheets";
        public static  final String  COL_SHEET_CODE="sheet_code";
        public static  final String  COL_FORM_CODE="form_code";
        public static  final String  COL_TIME_FROM="time_from";
        public static  final String  COL_TIME_TO="time_to";
        public static  final String  COL_NUMBER_OF_COLLECTING="number_of_collecting";

    }
    //جدول المجموعة السلعية
    public static  final class variety_groupEntry implements BaseColumns
    {
        public static  final String TABLE_NAME="Variety_group";
        public static  final String  COL_VARIETY_GROUP_CODE="variety_group_code";
        public static  final String  COL_VARIETY_GROUP_NAME="variety_group_name";
        public static  final String  COL_SHEET_CODE="sheet_code";
    }
    //جدول السلع
    public static  final class varietyEntry implements BaseColumns
    {
        public static  final String TABLE_NAME="Variety";
        public static  final String  COL_VARIETY_CODE="variety_code";
        public static  final String  COL_VARIETY_NAME="variety_name";
        public static  final String  COL_VARIETY_GROUP_CODE="variety_group_code";
        public static  final String  COL_VARIETY_Unit="unit_code";
    }
    //جدول المصادر
    public static  final class outletEntry implements BaseColumns
    {
        public static  final String TABLE_NAME="Outlet";
        public static  final String  COL_OUTLET_CODE="outlet_code";
        public static  final String  COL_OUTLET_NAME="outlet_name";
        public static  final String  COL_OUTLET_ADD="address";
        public static  final String  COL_OUTLET_TEL="telephone";
        public static  final String  COL_OUTLET_MOBILE="mobile";
        public static  final String  COL_REGION_CODE="region_code";
    }
//      جدول المصادر المضافة
    public static  final class add_outletEntry implements BaseColumns
    {
        public static  final String TABLE_NAME="Outlet_added";

        public static  final String  COL_OUTLET_NAME="outlet_name";
        public static  final String  COL_OUTLET_ADD="address";
        public static  final String  COL_OUTLET_TEL="telephone";
        public static  final String  COL_OUTLET_MOBILE="mobile";
        public static  final String  COL_REGION_CODE="region_code";
        public static  final String  COL_Time="time";
    }
    //جدول الاسعار
    public static  final class priceEntry implements BaseColumns
    {
        public static  final String TABLE_NAME="Price";
        public static  final String  COL_OUTLET_CODE="outlet_code";
        public static  final String  COL_SHEET_CODE="sheet_code";
        public static  final String  COL_REGION_CODE="region_code";
        public static  final String  COL_VARIETY_CODE="variety_code";
        public static  final String  COL_PRICE="price";
        public static  final String  COL_TIME="time";
        public static  final String  COL_SAVE_EDIT="save_edit_def";

    }
    //جدول الوحدات
    public static  final class unitEntry implements BaseColumns
    {
        public static  final String TABLE_NAME="Unit";
        public static  final String  COL_UNIT_CODE="unit_code";
        public static  final String  COL_UNIT_NAME="unit_name";


    }

    //جدول الرسائل
    public static  final class messagesEntry implements BaseColumns
    {
        public static  final String TABLE_NAME="Messages";
        public static  final String  COL_Researcher_code="Researcher_code";
        public static  final String  COL_messge_text="messge_text";
        public static  final String  COL_sender="sender";
        public static  final String  COL_time="time";
    }
}
