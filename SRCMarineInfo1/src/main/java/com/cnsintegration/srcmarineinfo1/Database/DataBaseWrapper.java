package com.cnsintegration.srcmarineinfo1.Database;

/**
 * Created by jprioleau on 4/25/14.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.cnsintegration.srcmarineinfo1.model.Rank;

public class DataBaseWrapper extends SQLiteOpenHelper {

    public static final String Ranks = "Ranks";
    public static final String rank_ID = "_id";
    public static final String Rank_PAY = "_pay";
    public static final String Rank_SHORT = "_short";
    public static final String Rank_NAME = "_name";
    public static final String Rank_ICON = "_icon";
    public static final String Rank_TYPE = "_type";
    public static final String Rank_DETAILS = "_details";
    public static final String Rank_LINK = "_link";
    public static final String Rank_Branch = "_branch";

    public int Branch_USMC = 0;
    public int Branch_USAF = 0;
    public int Branch_USARMY = 0;
    public int Branch_USNAVY = 0;
    public int Branch_USCG = 0;


    public static final String Branch = "Branches";
    public static final String Branch_ID = "branch_id";
    public static final String Branch_NAME = "branch_name";
    public static final String Branch_ICON = "branch_icon";

    public static final String MOSTITLES = "MOSTitles";
    public static final String MOSTITLES_BRANCH = "mos_branch";
    public static final String MOSTITLES_ID = "mos_id";
    public static final String MOSTITLES_TITLE = "mos_name";




    public static final String MOS= "MOSES";
    public static final String MOS_ID = "mos_id";
    public static final String MOS_NUMBER = "mos_number";
    public static final String MOS_TITLE= "most_id";

    public static final String MOS_NAME = "mos_name";
    public static final String MOS_TYPE = "mos_type";
    public static final String MOS_RANK = "mos_rank";







    private static final String DATABASE_NAME = "srcmarineinfo.db";
    private static final int DATABASE_VERSION = 1;


    // creation SQLite statement
    private static final String DATABASE_CREATE = "create table "+  Branch
            + "(" + Branch_ID + " integer primary key autoincrement, "
             + Branch_NAME + " text not null," + Branch_ICON + " text not null);";

    // creation SQLite statement
    private static final String DATABASE_CREATE2 = "create table " + Ranks
            + "(" + rank_ID + " integer primary key autoincrement, "
            + Rank_PAY + " text not null," + Rank_SHORT + " text not null,"  + Rank_NAME + " text not null,"  + Rank_ICON + " text not null,"
            + Rank_TYPE + " text not null," + Rank_DETAILS + " text not null," + Rank_LINK + " text not null,"
            + Rank_Branch + " references " + Branch + ");";

    // creation SQLite statement
    private static final String DATABASE_CREATE3 = "create table "+  MOSTITLES
            + "(" + MOSTITLES_ID + " integer primary key autoincrement, " + MOSTITLES_TITLE + " text not null,"
            + MOSTITLES_BRANCH + " references " + Branch + ");";

    private static final String DATABASE_CREATE4 = "create table "+  MOS
            + "(" + MOS_ID + " integer primary key autoincrement, " + MOS_NUMBER + " text not null, " + MOS_NAME + " text not null, "
            + MOS_TYPE + " text not null, " + MOS_RANK + " text not null, " + MOS_TITLE + " references " + MOSTITLES + ");";

    public DataBaseWrapper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }



    public void populateservice(SQLiteDatabase db){
        ContentValues values1 = new ContentValues();




        values1.put(Branch_NAME, "USMC");
        values1.put(Branch_ICON, "usmc");

        Branch_USMC = (int) db.insert(Branch, null, values1);

        values1.put(Branch_NAME, "USAF");
        values1.put(Branch_ICON, "usaf");

        Branch_USAF = (int) db.insert(Branch, null, values1);

        values1.put(Branch_NAME, "USARMY");
        values1.put(Branch_ICON, "usarmy");

        Branch_USARMY = (int) db.insert(Branch, null, values1);

        values1.put(Branch_NAME, "USNAVY");
        values1.put(Branch_ICON, "usnavy");

        Branch_USNAVY = (int) db.insert(Branch, null, values1);

        values1.put(Branch_NAME, "USCOASTGUARD");
        values1.put(Branch_ICON, "uscglogo");

        Branch_USCG =  (int) db.insert(Branch, null, values1);


    }


    public void populateusmcranks(SQLiteDatabase db){
        ContentValues values = new ContentValues();


        values.put(Rank_PAY, "O-1");
        values.put(Rank_SHORT, "2ndLt");
        values.put(Rank_NAME, "Second Lieutenant");
        values.put(Rank_ICON, "second_lieutenant_usmc");
        values.put(Rank_TYPE, "Officer");
        values.put(Rank_DETAILS, "In the United States, second lieutenant is the normal entry-level rank for most commissioned officers in the Army, Air Force and Marine Corps and is equivalent to the rank of ensign in the Navy and Coast Guard. In the Army and Marine Corps, a second lieutenant typically leads a platoon-size element (16 to 44 soldiers or marines)");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Second_Lieutenant_(United_States)#United_States");
        values.put(Rank_Branch, Branch_USMC);

        db.insert(Ranks, null, values);


        values = new ContentValues();

        values.put(Rank_PAY, "O-2");
        values.put(Rank_SHORT, "1stLt");
        values.put(Rank_NAME, "First Lieutenant");
        values.put(Rank_ICON, "first_lieutenant_usmc");
        values.put(Rank_TYPE, "Officer");
        values.put(Rank_DETAILS, "In the United States Army, U.S. Air Force, and U.S. Marine Corps, a first lieutenant is a junior commissioned officer. It is just above the rank of second lieutenant and just below the rank of captain. It is equivalent to the rank of lieutenant (junior grade) in the other uniformed services.  A second lieutenant (grade O-1) is usually promoted to first lieutenant (grade O-2) after 18 months in the Army or 24 months in the Air Force[2] and Marine Corps.");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/First_Lieutenant_(United_States)#United_States");
        values.put(Rank_Branch, Branch_USMC);

        db.insert(Ranks, null, values);
    }



    public void populateusmcmos(SQLiteDatabase db){
        ContentValues values = new ContentValues();



        values.put(MOSTITLES_TITLE, "01 Personnel and Administration");
        values.put(MOSTITLES_BRANCH, Branch_USMC);


        long mostitleId = db.insert(MOSTITLES, null, values);


        ContentValues values1 = new ContentValues();




                values1.put(MOS_NUMBER, "0100");
                values1.put(MOS_TITLE, mostitleId);
                values1.put(MOS_NAME, "Basic Administrative Marine");
                values1.put(MOS_TYPE, "Enlisted");
                values1.put(MOS_RANK, "Pvt - GySgt");
                db.insert(MOS, null, values1);



    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
        db.execSQL(DATABASE_CREATE2);
        db.execSQL(DATABASE_CREATE3);
        db.execSQL(DATABASE_CREATE4);

        populateservice(db);
        populateusmcranks(db);
        populateusmcmos(db);











    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // you should do some logging in here
        // ..

        db.execSQL("DROP TABLE IF EXISTS " + Ranks);
        db.execSQL("DROP TABLE IF EXISTS " + Branch);
        onCreate(db);
    }

}
