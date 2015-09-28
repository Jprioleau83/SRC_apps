package com.cnsintegration.srcmarineinfo1.Database;

/**
 * Created by jprioleau on 4/25/14.
 */
import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.cnsintegration.srcmarineinfo1.R;
import com.cnsintegration.srcmarineinfo1.model.Rank;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

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
    public static final String MOS_Link = "mos_link";



    public static final String Ackdb = "acronym";
    public static final String Ack = "ack";
    public static final String Ack_Name = "ackname";
    public static final String Ack_Details = "ackdetails";
    public static final String Ack_Link = "acklink";
    public static final String Ack_Icon = "ackicon";







    private static final String DATABASE_NAME = "srcmarineinfo.db";
    private static final int DATABASE_VERSION = 2;






    private final Context fContext;

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
            + MOS_TYPE + " text not null, " + MOS_RANK + " text not null, " + MOS_Link + " text, " + MOS_TITLE + " references " + MOSTITLES + ");";

    private static final String DATABASE_CREATE5 = "create table " + Ackdb + "( id integer primary key autoincrement, " + Ack + " text not null, " + Ack_Name + " text not null, "
            + Ack_Details + " text not null, " + Ack_Link + " text, " + Ack_Icon + " text not null); ";

    public DataBaseWrapper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        fContext = context;

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
        ContentValues _Values = new ContentValues();
        //Get xml resource file
        Resources res = fContext.getResources();

        //Open xml file
        XmlResourceParser _xml = res.getXml(R.xml.usmcranks);
        try
        {
            //Check for end of document
            int eventType = _xml.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                //Search for record tags
                if ((eventType == XmlPullParser.START_TAG) &&(_xml.getName().equals("ranksdata"))){
                    //Record tag found, now get values and insert record




                    String _id = _xml.getAttributeValue(null, "id");
                    String _payscale = _xml.getAttributeValue(null, "payscale");
                    String _short = _xml.getAttributeValue(null, "short");
                    String _name = _xml.getAttributeValue(null, "name");
                    String _icon = _xml.getAttributeValue(null, "icon");
                    String _type = _xml.getAttributeValue(null, "type");
                    String _details = _xml.getAttributeValue(null, "details");
                    String _link = _xml.getAttributeValue(null, "link");

                   // _Values.put(rank_ID, _id);
                    _Values.put(Rank_PAY, _payscale);
                    _Values.put(Rank_SHORT, _short);
                    _Values.put(Rank_NAME, _name);
                    _Values.put(Rank_ICON, _icon);
                    _Values.put(Rank_TYPE, _type);
                    _Values.put(Rank_DETAILS, _details);
                    _Values.put(Rank_LINK, _details);
                    _Values.put(Rank_Branch, Branch_USMC);

                    db.insert(Ranks, null, _Values);
                }
                eventType = _xml.next();
            }
        }
        //Catch errors
        catch (XmlPullParserException e)
        {
            //Log.e(TAG, e.getMessage(), e);
        }
        catch (IOException e)
        {
            //Log.e(TAG, e.getMessage(), e);

        }
        finally
        {
            //Close the xml file
            _xml.close();
        }












    }

    public void populateusafranks(SQLiteDatabase db){
        ContentValues values = new ContentValues();
        ContentValues _Values = new ContentValues();
        //Get xml resource file
        Resources res = fContext.getResources();

        //Open xml file
        XmlResourceParser _xml = res.getXml(R.xml.usafranks);
        try
        {
            //Check for end of document
            int eventType = _xml.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                //Search for record tags
                if ((eventType == XmlPullParser.START_TAG) &&(_xml.getName().equals("ranksdata"))){
                    //Record tag found, now get values and insert record




                    String _id = _xml.getAttributeValue(null, "id");
                    String _payscale = _xml.getAttributeValue(null, "payscale");
                    String _short = _xml.getAttributeValue(null, "short");
                    String _name = _xml.getAttributeValue(null, "name");
                    String _icon = _xml.getAttributeValue(null, "icon");
                    String _type = _xml.getAttributeValue(null, "type");
                    String _details = _xml.getAttributeValue(null, "details");
                    String _link = _xml.getAttributeValue(null, "link");

                   // _Values.put(rank_ID, _id);
                    _Values.put(Rank_PAY, _payscale);
                    _Values.put(Rank_SHORT, _short);
                    _Values.put(Rank_NAME, _name);
                    _Values.put(Rank_ICON, _icon);
                    _Values.put(Rank_TYPE, _type);
                    _Values.put(Rank_DETAILS, _details);
                    _Values.put(Rank_LINK, _details);
                    _Values.put(Rank_Branch, Branch_USAF);

                    db.insert(Ranks, null, _Values);
                }
                eventType = _xml.next();
            }
        }
        //Catch errors
        catch (XmlPullParserException e)
        {
            //Log.e(TAG, e.getMessage(), e);
        }
        catch (IOException e)
        {
            //Log.e(TAG, e.getMessage(), e);

        }
        finally
        {
            //Close the xml file
            _xml.close();
        }
















    }

    public void populateusarmyranks(SQLiteDatabase db){
        ContentValues values = new ContentValues();


        ContentValues _Values = new ContentValues();
        //Get xml resource file
        Resources res = fContext.getResources();

        //Open xml file
        XmlResourceParser _xml = res.getXml(R.xml.usarmyranks);
        try
        {
            //Check for end of document
            int eventType = _xml.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                //Search for record tags
                if ((eventType == XmlPullParser.START_TAG) &&(_xml.getName().equals("ranksdata"))){
                    //Record tag found, now get values and insert record




                    String _id = _xml.getAttributeValue(null, "id");
                    String _payscale = _xml.getAttributeValue(null, "payscale");
                    String _short = _xml.getAttributeValue(null, "short");
                    String _name = _xml.getAttributeValue(null, "name");
                    String _icon = _xml.getAttributeValue(null, "icon");
                    String _type = _xml.getAttributeValue(null, "type");
                    String _details = _xml.getAttributeValue(null, "details");
                    String _link = _xml.getAttributeValue(null, "link");

                   // _Values.put(rank_ID, _id);
                    _Values.put(Rank_PAY, _payscale);
                    _Values.put(Rank_SHORT, _short);
                    _Values.put(Rank_NAME, _name);
                    _Values.put(Rank_ICON, _icon);
                    _Values.put(Rank_TYPE, _type);
                    _Values.put(Rank_DETAILS, _details);
                    _Values.put(Rank_LINK, _details);
                    _Values.put(Rank_Branch, Branch_USARMY);

                    db.insert(Ranks, null, _Values);
                }
                eventType = _xml.next();
            }
        }
        //Catch errors
        catch (XmlPullParserException e)
        {
            //Log.e(TAG, e.getMessage(), e);
        }
        catch (IOException e)
        {
            //Log.e(TAG, e.getMessage(), e);

        }
        finally
        {
            //Close the xml file
            _xml.close();
        }










    }


    public void populateusnavyranks(SQLiteDatabase db){


        ContentValues values = new ContentValues();
        ContentValues _Values = new ContentValues();
        //Get xml resource file
        Resources res = fContext.getResources();

        //Open xml file
        XmlResourceParser _xml = res.getXml(R.xml.usnavyranks);
        try
        {
            //Check for end of document
            int eventType = _xml.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                //Search for record tags
                if ((eventType == XmlPullParser.START_TAG) &&(_xml.getName().equals("ranksdata"))){
                    //Record tag found, now get values and insert record




                    String _id = _xml.getAttributeValue(null, "id");
                    String _payscale = _xml.getAttributeValue(null, "payscale");
                    String _short = _xml.getAttributeValue(null, "short");
                    String _name = _xml.getAttributeValue(null, "name");
                    String _icon = _xml.getAttributeValue(null, "icon");
                    String _type = _xml.getAttributeValue(null, "type");
                    String _details = _xml.getAttributeValue(null, "details");
                    String _link = _xml.getAttributeValue(null, "link");

                   // _Values.put(rank_ID, _id);
                    _Values.put(Rank_PAY, _payscale);
                    _Values.put(Rank_SHORT, _short);
                    _Values.put(Rank_NAME, _name);
                    _Values.put(Rank_ICON, _icon);
                    _Values.put(Rank_TYPE, _type);
                    _Values.put(Rank_DETAILS, _details);
                    _Values.put(Rank_LINK, _details);
                    _Values.put(Rank_Branch, Branch_USNAVY);

                    db.insert(Ranks, null, _Values);
                }
                eventType = _xml.next();
            }
        }
        //Catch errors
        catch (XmlPullParserException e)
        {
            //Log.e(TAG, e.getMessage(), e);
        }
        catch (IOException e)
        {
            //Log.e(TAG, e.getMessage(), e);

        }
        finally
        {
            //Close the xml file
            _xml.close();
        }







    }

    public void populateuscgranks(SQLiteDatabase db){


        ContentValues values = new ContentValues();
        ContentValues _Values = new ContentValues();
        //Get xml resource file
        Resources res = fContext.getResources();

        //Open xml file
        XmlResourceParser _xml = res.getXml(R.xml.uscgranks);
        try
        {
            //Check for end of document
            int eventType = _xml.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                //Search for record tags
                if ((eventType == XmlPullParser.START_TAG) &&(_xml.getName().equals("ranksdata"))){
                    //Record tag found, now get values and insert record




                    String _id = _xml.getAttributeValue(null, "id");
                    String _payscale = _xml.getAttributeValue(null, "payscale");
                    String _short = _xml.getAttributeValue(null, "short");
                    String _name = _xml.getAttributeValue(null, "name");
                    String _icon = _xml.getAttributeValue(null, "icon");
                    String _type = _xml.getAttributeValue(null, "type");
                    String _details = _xml.getAttributeValue(null, "details");
                    String _link = _xml.getAttributeValue(null, "link");

                    //_Values.put(rank_ID, _id);
                    _Values.put(Rank_PAY, _payscale);
                    _Values.put(Rank_SHORT, _short);
                    _Values.put(Rank_NAME, _name);
                    _Values.put(Rank_ICON, _icon);
                    _Values.put(Rank_TYPE, _type);
                    _Values.put(Rank_DETAILS, _details);
                    _Values.put(Rank_LINK, _details);
                    _Values.put(Rank_Branch, Branch_USCG);

                    db.insert(Ranks, null, _Values);
                }
                eventType = _xml.next();
            }
        }
        //Catch errors
        catch (XmlPullParserException e)
        {
            //Log.e(TAG, e.getMessage(), e);
        }
        catch (IOException e)
        {
            //Log.e(TAG, e.getMessage(), e);

        }
        finally
        {
            //Close the xml file
            _xml.close();
        }






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
        values1.put(MOS_Link, "http://en.wikipedia.org/wiki/Military_administration");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "0111");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Administrative Specialist");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, " Pvt to MGySgt");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "0149");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Substance Abuse Control Specialist");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_Link, "http://en.wikipedia.org/wiki/Substance_abuse");
        values1.put(MOS_RANK, "SSgt - MGySgt");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "0161");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Postal Clerk");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt - MGySgt");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "0171");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Manpower Information Systems (MIS) Analyst");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Cpl - MGySgt");

        db.insert(MOS, null, values1);


        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "0149");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Substance Abuse Control Officer (SACO)");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "officers");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "0160");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Postal Officer");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "WO-CWO5");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "0170");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Personnel Officer");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "WO-CWO5");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "0180");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Adjutant");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_Link, "http://en.wikipedia.org/wiki/Adjutant");
        values1.put(MOS_RANK, "2ndLt-LtCol");

        db.insert(MOS, null, values1);






        values.put(MOSTITLES_TITLE, "02 Intelligence");
        values.put(MOSTITLES_BRANCH, Branch_USMC);


        mostitleId = db.insert(MOSTITLES, null, values);


        values1 = new ContentValues();




        values1.put(MOS_NUMBER, "0200");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Basic Intelligence Marine");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_Link, "http://en.wikipedia.org/wiki/Military_intelligence");
        values1.put(MOS_RANK, "Pvt - GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "0211");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Counterintelligence");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_Link, "http://en.wikipedia.org/wiki/Counter-intelligence");
        values1.put(MOS_RANK, "CPL - MSGT");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "0211");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "HUMINT Specialist");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_Link, "http://en.wikipedia.org/wiki/HUMINT");
        values1.put(MOS_RANK, "CPL - MSGT");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "0212");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Technical Surveillance Countermeasures Specialist");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_Link, "http://en.wikipedia.org/wiki/Countersurveillance");
        values1.put(MOS_RANK, "SGT - MSGT");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "0231");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Intelligence Specialist");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "PVT - MSGT");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "0241");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Imagery Analysis Specialist");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_Link, "http://en.wikipedia.org/wiki/Imagery_analysis");
        values1.put(MOS_RANK, "SGT - MSGT");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "0251");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Interrogator");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_Link, "http://en.wikipedia.org/wiki/Interrogation");
        values1.put(MOS_RANK, "CPL - MSGT (No Longer Officered)");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "0251");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Debriefer");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_Link, "http://en.wikipedia.org/wiki/Imagery_analysis");
        values1.put(MOS_RANK, "CPL - MSGT (No Longer Officered)");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "0261");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Geographic Intelligence Specialist");
        values1.put(MOS_Link, "http://en.wikipedia.org/wiki/MOS_0261");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "PVT - MSGT");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "0282");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " Tactical Debriefer (TD) (FMOS)");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "0283");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Advanced Foreign Counterintelligence Specialist (AFCS)");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "0287");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Military Source Operations Specialist (MSOS) (FMOS)");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "0289");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Strategic Debriefing Specialist (SDS) (FMOS)");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "0291");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Intelligence Chief (PMOS)");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "0293");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Advanced Military Source Operations Specialist (AMSOS)");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "SGT - MSGT");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "0202");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Marine Air-Ground Task Force (MAGTF) Intelligence Officer");
        values1.put(MOS_Link, "http://en.wikipedia.org/wiki/Marine_Air-Ground_Task_Force");
        values1.put(MOS_TYPE, "Officer");

        values1.put(MOS_RANK, "1stLt - LtCol");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "0203");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Ground Intelligence Officer");
        values1.put(MOS_Link, "http://en.wikipedia.org/wiki/Ground_Intelligence_Officer");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "2ndLt - Capt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "0204");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Counterintelligence (CI)/Human Source Intelligence (HUMINT) Officer");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "2ndLt - Capt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "0205");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Senior All-Source Intelligence Analysis Officer");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "WO - CWO5");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "0206");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Signals Intelligence/Ground Electronic Warfare Officer");
        values1.put(MOS_Link, "http://en.wikipedia.org/wiki/Signals_intelligence");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "2ndLt - Capt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "0206");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Ground Electronic Warfare Officer");
        values1.put(MOS_Link, "http://en.wikipedia.org/wiki/Electronic_warfare");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "2ndLt - Capt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "0207");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Air Intelligence Officer");
        values1.put(MOS_Link, "http://en.wikipedia.org/wiki/Air_Intelligence_Officer");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "2ndLt - Capt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "0210");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Counterintelligence/Human Source Intelligence (CI/HUMINT) Operations Officer");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "WO - CWO5");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "0215");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Technical Surveillance Countermeasures Trained Counterintelligence/Human Source Intelligence Officer");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "0220");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Surveillance Sensor Officer");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "0277");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Weapons and Tactics Instructor-Intelligence Officer");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "0281");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Tactical Debriefer (TD) Officer");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "2ndLt - Capt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "0284");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Advanced Foreign Counterintelligence Officer");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "0286");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Advanced Military Source Operations Officer");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "0288");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Military Source Operations Officer");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "0290");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Strategic Debriefing Officer");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values = new ContentValues();


        values.put(MOSTITLES_TITLE, "03 Infantry");
        values.put(MOSTITLES_BRANCH, Branch_USMC);


        mostitleId = db.insert(MOSTITLES, null, values);


        values1 = new ContentValues();


        values1.put(MOS_NUMBER, "0300");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Basic Infantryman");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt - Sgt");
        values1.put(MOS_Link, "http://en.wikipedia.org/wiki/Infantry");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();


        values1.put(MOS_NUMBER, "0311");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Rifleman");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt - Sgt");
        values1.put(MOS_Link, "http://en.wikipedia.org/wiki/Rifleman");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();


        values1.put(MOS_NUMBER, "0312");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Riverine Assault Craft Crewman");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();


        values1.put(MOS_NUMBER, "0313");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "LAV Crewman");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt - Mgysgt");
        values1.put(MOS_Link, "http://en.wikipedia.org/wiki/LAV-25");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "0314");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " Rigid Raiding Craft (RRC) Rigid Hull Inflatable Boat (RHIB) Coxswain (FMOS)");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/0314.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "0316");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Combat Rubber Reconnaissance Craft Coxswain (NMOS)");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/0316.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "0317");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Scout Sniper");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Lcpl - Gysgt");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/0317.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "0321");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Reconnaissance Man");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt - MGysgt");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/0321new.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "0323");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Reconnaissance Man, Parachute Qualified (NMOS) [formerly 8652]");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt - MGysgt");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/0323.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "0324");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Reconnaissance Man, Combatant Diver Qualified (NMOS) [formerly 8653]");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt - MGysgt");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/0324.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "0326");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Reconnaissance Man, Parachute and Combatant Diver Qualified (NMOS) [formerly 8654]");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt - MGysgt");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/0326.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "0331");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Reconnaissance Man, Parachute and Combatant Diver Qualified (NMOS) [formerly 8654]");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt - Sgt");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/0331new.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "0341");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " Mortarman");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt - Sgt");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/03.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "0351");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Assaultman");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt - Sgt");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/0351.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "0352");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Anti-Tank Missileman");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt - Sgt");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/0352.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "0352");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Force Reconnaissance man");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Sgt - MGYSgt");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "0369");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Infantry Unit Leader");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "SSgt - MGYSgt");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/0369.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "0372");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Critical Skills Operator");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "SSgt - MGYSgt");
        values1.put(MOS_Link, "http://en.wikipedia.org/wiki/MOS_0372");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "0302");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " Infantry Officer");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "2ndLt - LtCol");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/0302.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "0303");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Light-Armored Reconnaissance (LAR) Officer");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "All");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/0303.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "0306");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Infantry Weapons Officer");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "CWO2 - CWO5");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/0306.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "0307");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Expeditionary Ground Reconnaissance Officer");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "2ndLt - LtCol");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "0370");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Special Operations Officer");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "2ndLt - LtCol");

        db.insert(MOS, null, values1);

        values.put(MOSTITLES_TITLE, "04 Logistics");
        values.put(MOSTITLES_BRANCH, Branch_USMC);


        mostitleId = db.insert(MOSTITLES, null, values);
        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "0400 ");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " Basic Logistics Marine ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt - GYSgt");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "0411 ");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Maintenance Management Specialist ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_Link, "http://en.wikipedia.org/wiki/Maintenance,_repair_and_operations ");
        values1.put(MOS_RANK, "Pvt - MGYSgt");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "0431 ");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " Logistics/Embarkation and Combat Service Support (CSS) Specialist ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_Link, "http://en.wiktionary.org/wiki/embarkation");
        values1.put(MOS_RANK, "Pvt - SSgt");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "0451");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Parachute Rigger");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_Link, "http://en.wikipedia.org/wiki/Parachute_rigger ");
        values1.put(MOS_RANK, "Pvt - MGYSGT ");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "0471 ");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Personnel Retrieval and Processing Specialist");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_Link, "http://en.wikipedia.org/wiki/Mortuary_Affairs");
        values1.put(MOS_RANK, "Pvt - SSGT ");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "0472");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Personnel Retrieval and Processing Technician");
        values1.put(MOS_TYPE, "Enlisted");

        values1.put(MOS_RANK, "Pvt - SSGT ");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "0481 ");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Landing Support Specialist");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt - SSGT ");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "0491 ");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " Combat Service Support Chief");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, " GYSGT - MGYSGT ");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "0402 ");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Logistics Officer");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_Link, "http://en.wikipedia.org/wiki/Mortuary_Affairs");
        values1.put(MOS_RANK, "2ndLt - LtCol ");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "0405");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Aerial Delivery Officer ");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_Link, "http://en.wikipedia.org/wiki/Airdrop");
        values1.put(MOS_RANK, "2ndLt - Capt ");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "0407");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Personnel Retrieval and Processing Officer");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "2ndLt - Capt ");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "0430");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Mobility Officer");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);


        values.put(MOSTITLES_TITLE, "05 Marine Air Ground Task Force (MAGTF) Plans");
        values.put(MOSTITLES_BRANCH, Branch_USMC);


        mostitleId = db.insert(MOSTITLES, null, values);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "0500 ");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " Basic Marine Air-Ground Task Force (MAGTF) Marine ");
        values1.put(MOS_Link, " http://en.wikipedia.org/wiki/Marine_Air-Ground_Task_Force");

        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GYSgt ");

        db.insert(MOS, null, values1);


        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "0511");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Marine Air Ground Task Force (MAGTF) Planning Specialist ");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/0511.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-MGYSgt ");

        db.insert(MOS, null, values1);


        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "0521 ");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Psychological Operations NCO (FMOS) MISO NCO");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/0572.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Cpl-GYSgt ");

        db.insert(MOS, null, values1);


        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "0521 ");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Civil Affairs Noncommissioned Officer ");
        values1.put(MOS_Link, " http://en.wikipedia.org/wiki/Civil_Affairs#United_States_Marine_Corps");

        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Cpl-GYSgt ");

        db.insert(MOS, null, values1);


        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "0521 ");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Force Deployment Planning and Execution Officer");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/0502.htm");

        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "All ");

        db.insert(MOS, null, values1);


        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "0521 ");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Marine Air Ground Task Force (MAGTF) Planners");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/0505.htm");

        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, " LtCol – Maj");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "0510");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Information Operations Staff Officer");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/0510.htm");

        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "All");

        db.insert(MOS, null, values1);


        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "0520");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Psychological Operations Officer");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/0520.htm");

        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);


        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "0530");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Civil Affairs Officer");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/0530.htm");

        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);


        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "0540");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Space Operations Staff Officer");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/0540.htm");

        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);


        values.put(MOSTITLES_TITLE, "06 Communications ");
        values.put(MOSTITLES_BRANCH, Branch_USMC);
        mostitleId = db.insert(MOSTITLES, null, values);


        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "0600");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " Basic Communications Marine ");
        values1.put(MOS_Link, " http://en.wikipedia.org/wiki/Military_communications ");

        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);


        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "0612");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " Tactical Switch Operator/ Field Wireman ");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/0612.htm ");

        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-Sgt");

        db.insert(MOS, null, values1);


        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "0613");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Construction Wireman");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/0613.htm");

        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-Sgt");

        db.insert(MOS, null, values1);


        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "0614");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Unit Level Circuit Switch (ULCS) Operator/Maintainer");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/0614.htm");

        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-Sgt");

        db.insert(MOS, null, values1);


        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "0618");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Electronic Switching Operator/Maintainer (DTC)");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/0618.htm");

        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Cpl-Sgt");

        db.insert(MOS, null, values1);


        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "0619");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Wire Chief");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/0619.htm");

        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "SSgt-GySgt");

        db.insert(MOS, null, values1);


        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "0621");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Field Radio Operator");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/0621.htm");

        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-Sgt");

        db.insert(MOS, null, values1);


        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "0622");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Digital Multi-channel Wideband Transmission Equipment Operator");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/0622.htm");

        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-Sgt");

        db.insert(MOS, null, values1);


        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "0623");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Tropospheric Scatter Radio Multi-channel Equipment Operator ");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/0623.htm");

        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-Sgt");


        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "0627");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "SHF Satellite Communications Operator/Maintainer ");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/0627.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-Sgt");

        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "0628");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "EHF Satellite Communications/Maintainer ");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/0628.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-Sgt");

        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "0629");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Radio Chief ");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/0629.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "SSgt-GySgt");

        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "0648");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Strategic Spectrum Manager");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/0648.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "SSgt-MGySgt");

        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "0651");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Cyber Network Operator");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/0651.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-Sgt");

        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "0652");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " Certification Authority Workstation (CAW) Operator [Phased out]");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjo2/a/0652.htm ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Cpl-Sgt");

        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "0653");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Defense Message System (DMS) Specialist ");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/0653.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-Sgt");

        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "0656");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Tactical Network Specialist [Phased out]");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/0656.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-Sgt");

        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "0658");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Tactical Data Network Gateway Systems Administrator");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjo2/a/0658.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Sgt-GySgt");

        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "0659");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Cyber Systems Chief ");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/0659.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Sgt-GySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "0681");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Information Security Technician ");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/0681.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Sgt-MGySgt");

        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "0689");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Cyber Security Technician");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/0689.htm ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Sgt-MGySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "0699");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " Communications Chief ");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/0699.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "MSgt-MGySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "0602");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " Communications Officer ");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/0602.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "2ndLt - LtCol");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "0603");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "C4 Planner");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/0603.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, " Capt - Maj");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "0605");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Cyber Network Operations Officer");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, " Capt - LtCol ");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "0610");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Telecommunications Systems Engineering Officer ");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/officerj3/a/0610.htm ");
        values1.put(MOS_TYPE, "Warrant Officer");
        values1.put(MOS_RANK, " WO - CWO5");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "0620");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Tactical Communications Planning and Engineer Officer ");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/officerj3/a/0620.htm");
        values1.put(MOS_TYPE, "Warrant Officer");
        values1.put(MOS_RANK, " WO - CWO5");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "0640");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Strategic Spectrum Planner");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/0640.htm");
        values1.put(MOS_TYPE, "Warrant Officer");
        values1.put(MOS_RANK, " WO - CWO5");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "0699");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Cyber Network Operations Engineer ");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/0650.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "WO - CWO5, Capt- LtCol");
        db.insert(MOS, null, values1);


        values.put(MOSTITLES_TITLE, "08 Artillery");
        values.put(MOSTITLES_BRANCH, Branch_USMC);
        mostitleId = db.insert(MOSTITLES, null, values);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "0800");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Basic Field Artillery Man");
        values1.put(MOS_Link, "http://en.wikipedia.org/wiki/Field_artillery ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, " Pvt-Sgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "0811");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Field Artillery Cannoneer");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/0811.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, " Pvt-MGySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "0814");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "High Mobility Artillery Rocket System (HIMARS) Operator ");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/0814.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, " Pvt-MGySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "0842");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Field Artillery Radar Operator ");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/0842.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, " Pvt-Sgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "0844");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Field Artillery Fire Control Man");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/0844.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, " Pvt-Sgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "0842");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Artillery Meteorological Man");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/0847.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, " Pvt-Sgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "0842");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Field Artillery Operations Chief Man");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/0848.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, " SSgt-MGySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "0861");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Fire Support Man");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/0861.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, " Pvt- MGySgt ");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "0802");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " Field Artillery Officer ");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/0861.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, " Pvt- MGySgt ");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "0803");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Targeting Effects Officer");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/0803.htm");
        values1.put(MOS_TYPE, "Warrant Officer");
        values1.put(MOS_RANK, "WO - CWO5");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "0840");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Naval Surface Fire Support Planner ");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/officerj3/a/0840.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);


        values.put(MOSTITLES_TITLE, "09 Training");
        values.put(MOSTITLES_BRANCH, Branch_USMC);


        mostitleId = db.insert(MOSTITLES, null, values);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "0911");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " Drill Instructor ");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjo2/a/0911.htm ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Sgt –MGySgt /SgtMaj");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "0913");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Marine Combat Instructor (Formerly 8513)");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjo2/a/0913.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Sgt –MGySgt /SgtMaj");

        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "0916");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Martial Arts Instructor (formerly 8551)");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/0916.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Cpl –MGySgt ");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "0917");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Martial Arts Instructor-Trainers (MAIT) (formerly 8552)");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/0917.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Sgt –MGySgt ");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "0918");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Marine Combat Instructor of Water Survival (MCIWS) (formerly 8563)");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/0918.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt - Msgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "0931");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Combat Marksmanship Trainer (CMT) (Formerly 8531: Primary Marksmanship Instructor)");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjo2/a/0931.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Sgt - MGySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "0932");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Small Arms Weapons Instructor");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjo2/a/0932.htm ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Sgt-MGySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "0933");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Combat Marksmanship Coach (CMC) (Formerly 8530- Marksmanship Coach)");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/0933.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pfc-Sgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "0930");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Range Officer");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/0930.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, " WO - CWO5 ");
        db.insert(MOS, null, values1);


        values.put(MOSTITLES_TITLE, "11 Utilities");
        values.put(MOSTITLES_BRANCH, Branch_USMC);


        mostitleId = db.insert(MOSTITLES, null, values);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "1100");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Basic Utilities Marine");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/0933.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "1141");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Electrician");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjo2/a/0041.htm ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-SSgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "1142");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Electrical Equipment Repair Specialist");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/0042.htm ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-SSgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "1161");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Refrigeration and Air Conditioning Technician ");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/1161.htm ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-SSgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "1169");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Utilities Chief");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/0069.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "GySgt- MGySgt ");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "1171");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Water Support Technician");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/1171.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-SSgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "1120");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Utilities Officer");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/1120.htm");
        values1.put(MOS_TYPE, "Warrant Officer");
        values1.put(MOS_RANK, " WO - CWO5 ");
        db.insert(MOS, null, values1);


        values.put(MOSTITLES_TITLE, "13 Engineer, Construction, Facilities, & Equipment");
        values.put(MOSTITLES_BRANCH, Branch_USMC);


        mostitleId = db.insert(MOSTITLES, null, values);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "1300");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Basic Engineer, Construction, Facilities, & Equipment Marine");

        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt- GySgt ");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "1361");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Metal Worker");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjo2/a/1316.htm ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-SSgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "1341");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Engineer Equipment Mechanic");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjo2/a/1341.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-SSgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "1342");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Small Craft Mechanic");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjo2/a/1342.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "LCpl-SSgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "1343");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Assault Breacher Vehicle Mechanic");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjo2/a/1343.htm ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, " LCpl -SSgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "1345");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " Engineer Equipment Operator ");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/1345.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-SSgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "1349");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Engineer Equipment Chief");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/1349.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "GySgt- MGySgt ");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "1361");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Engineer Assistant ");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/1361.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "1371");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Combat Engineer");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjo2/a/1371new.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt- MGySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "1372");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Assault Breacher Vehicle Operator ");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/1372.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pfc-MGySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "1391");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Bulk Fuel Specialist ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-SSgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "1301");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Basic Combat Engineer Officer");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, " N/A ");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "1302");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Combat Engineer Officer ");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/1302.htm");
        values1.put(MOS_TYPE, "Warrant Officer");
        values1.put(MOS_RANK, " 2ndLt - LtCol");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "1310");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Engineer Equipment Officer");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/officerj3/a/1310.htm");
        values1.put(MOS_TYPE, "Warrant Officer");
        values1.put(MOS_RANK, " WO - CWO5 ");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "1330");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Facilities Management Officer");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/1330.htm");
        values1.put(MOS_TYPE, "Warrant Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "1390");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Bulk Fuel Officer");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/1390.htm");
        values1.put(MOS_TYPE, "Warrant Officer");
        values1.put(MOS_RANK, " WO - CWO5 ");
        db.insert(MOS, null, values1);


        values.put(MOSTITLES_TITLE, "18 Tank and Assault Amphibious Vehicle ");
        values.put(MOSTITLES_BRANCH, Branch_USMC);


        mostitleId = db.insert(MOSTITLES, null, values);

        values1.put(MOS_NUMBER, "1800");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Basic Tank and Assault Amphibious Vehicle (AAV) Crewman");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "1812");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "M1A1 Tank Crewman");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjo2/a/1812.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-MGySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "1833");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Basic Tank and Assault Amphibious Vehicle (AAV) Crewman");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/1833.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-MGySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "1834");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Expeditionary Fighting Vehicle (EFV) Crewman");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/1834.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-MGySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "1802");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Tank Officer");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/1802.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "2ndLt- LtCol");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "1803");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Assault Amphibious Vehicle (AAV) Officer");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/1803.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "2ndLt- LtCol");
        db.insert(MOS, null, values1);


        values.put(MOSTITLES_TITLE, "21 Ground Ordnance Maintenance ");
        values.put(MOSTITLES_BRANCH, Branch_USMC);


        mostitleId = db.insert(MOSTITLES, null, values);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2100");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " Basic Ground Ordnance Maintenance Marine ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2111");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Small Arms Repairer/Technician");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/2111.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2112");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Precision Weapons Repairer");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjo2/a/2112.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Cpl-GySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2131");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Towed Artillery Systems Technician");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjo2/a/2131.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2141");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Assault Amphibious Vehicle (AAV) Repairer/Technician");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjo2/a/2141.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2146");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Main battle tank (MBT) Repairer/Technician");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjo2/a/2146.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2147");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Light Armored Vehicle (LAV) Repairer/Technician ");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjo2/a/2147.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2141");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Expeditionary Fighting Vehicle (EFV) Repairer/Technician");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjo2/a/2148.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2149");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Ordnance Vehicle Maintenance Chief ");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjo2/a/2149.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "MSgt-MGySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2161");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Machinist");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjo2/a/2161.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2171");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Electro-Optical Ordnance Repairer/Technician ");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjo2/a/2171.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2181");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Senior Ground Ordnance Weapons Chief ");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjo2/a/2181.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "MSgt-MGySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2102");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Ordnance Officer ");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/officerj3/a/2102.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "Capt- LtCol");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2110");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Ordnance Vehicle Maintenance Officer");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/2110.htm");
        values1.put(MOS_TYPE, "Warrant Officer");
        values1.put(MOS_RANK, "WO- CW05 ");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2120");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Weapons Repair Officer ");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/2120.htm");
        values1.put(MOS_TYPE, "Warrant Officer");
        values1.put(MOS_RANK, "WO - CW05");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2125");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " Electro-Optic Instrument Repair Officer ");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/2125.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "WO- CW05");
        db.insert(MOS, null, values1);


        values.put(MOSTITLES_TITLE, "23 Ammunition and Explosive Ordnance Disposal ");
        values.put(MOSTITLES_BRANCH, Branch_USMC);


        mostitleId = db.insert(MOSTITLES, null, values);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2300");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Basic Ammunition and Explosive Ordnance Disposal (EOD) Marine");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2311");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Ammunition Technician");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjo2/a/2311.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-MGySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2336");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Explosive Ordnance Disposal (EOD) Technician");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/2336.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Cpl-MGySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2305");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Explosive Ordnance Disposal Officer");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/2336.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, " WO - CW05/ Capt- LtCol");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2340");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Explosive Ordnance Disposal (EOD) Technician");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/2340.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, " WO - CW05/ Capt- LtCol");
        db.insert(MOS, null, values1);


        values.put(MOSTITLES_TITLE, "26 Signals Intelligence/Ground Electronic Warfare");
        values.put(MOSTITLES_BRANCH, Branch_USMC);


        mostitleId = db.insert(MOSTITLES, null, values);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2600");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Basic Signals Intelligence/Ground Electronic Warfare Operator");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2611");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Cryptologic Digital Network Technician/Analyst");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/2611.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Cpl-MGySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2621");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Special Communications Signals Collection Operator/Analyst ");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/2621.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2629");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Signals Intelligence Analyst");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/2629.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-MGySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2631");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Electronic Intelligence (ELINT) Intercept Operator/Analyst");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/2631.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2649");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Cryptanalyst");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Cpl-MGySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2651");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Special Intelligence System Administrator/Communicator");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/2651.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-MGySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2671");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Middle East Cryptologic Linguist");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/2671.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2673");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Asia-Pacific Cryptologic Linguist");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/2629.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2629");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "European I (West) Cryptologic Linguist");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/2674new.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2676");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " European II (East) Cryptologic Linguist");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/2676new.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2691");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Signals Intelligence/Electronic Warfare (SIGINT/EW) Chief ");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/2691new.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Msgt-MGySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2602");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Signals Intelligence/Electronic Warfare (SIGINT/EW) Officer");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/2602.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "Msgt-MGySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2611");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Cryptologic Digital Network Technician/Analyst (Officer)");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/officerj3/a/2611.-uu6.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);


        values.put(MOSTITLES_TITLE, "27 Linguist ");
        values.put(MOSTITLES_BRANCH, Branch_USMC);


        mostitleId = db.insert(MOSTITLES, null, values);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2711");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Afghan Pashto Linguist");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/2711.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-MGySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2712");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Arabic (Modern Standard)Linguist");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/2712.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-MGySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2713");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Arabic (Egyptian) Linguist");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/2713.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-MGySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2714");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Arabic (Syrian) Linguist");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/2714.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-MGySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2716");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Amharic Linguist");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/2716.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-MGySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2717");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Bengali Linguist");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/2717.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-MGySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2718");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Hebrew Linguist");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/2718.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-MGySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2719");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Hindi Linguist");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/2719.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-MGySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2719");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Kurdish Linguist");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/2721.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-MGySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2722");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Persian-Farsi Linguist");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/2722.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-MGySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2723");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Somali Linguist");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/2723.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-MGySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2724");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Persian-Farsi Linguist");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/2724.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-MGySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2726");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Persian-Farsi Linguist");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/2726.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-MGySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2727");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Persian-Farsi Linguist");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/2727.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-MGySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2733");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Burmese Linguist");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/2733.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-MGySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2734");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Cambodian Linguist");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/2734.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-MGySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2736");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Cantonese Linguist");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/2736.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-MGySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2737");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Chinese (Mandarin) Linguist");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/2737.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-MGySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2738");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Indonesian Linguist");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/2738.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-MGySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2741");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Korean Linguist");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/2741.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-MGySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2746");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Thai Linguist");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/2746.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-MGySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2747");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Vietnamese Linguist");

        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-MGySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2754");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Dutch Linguist");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/2754.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-MGySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2756");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Finnish Linguist");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/2756.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-MGySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2757");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "French Linguist");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/2757.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-MGySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2758");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "German Linguist");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/2758.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-MGySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2759");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Greek Linguist");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/2759.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-MGySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2761");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Haitian-Creole Linguist");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/2761.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-MGySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2762");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Icelandic Linguist");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/2762.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-MGySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2763");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Italian Linguist");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/2763.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-MGySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2764");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Norwegian Linguist");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/2764.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-MGySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2766");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Portuguese (BR) Linguist");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/2766.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-MGySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2767");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Portuguese (EU) Linguist");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/2767.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-MGySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2768");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Spanish Linguist");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/2768.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-MGySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2769");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Swedish Linguist");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/2769.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-MGySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2776");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Albanian Linguist");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/2776.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-MGySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2777");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Armenian Linguist");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/2777.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-MGySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2778");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Bulgarian Linguist");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/2778.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-MGySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2779");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Czech Linguist");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/2779.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-MGySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2781");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Estonian Linguist");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/2781.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-MGySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2782");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Georgian Linguist");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/2782.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-MGySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2783");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Hungarian Linguist");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/2783.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-MGySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2784");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Latvian Linguist");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/2784.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-MGySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2786");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Lithuanian Linguist");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/2786.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-MGySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2787");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Macedonian Linguist");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/2787.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-MGySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2788");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Polish Linguist");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/2788.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-MGySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2789");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Romanian Linguist");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/2789.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-MGySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2791");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Russian Linguist");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/2791.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-MGySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2792");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Serb-Croat Linguist");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/2792.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-MGySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2793");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Slovenian Linguist");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/2793.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-MGySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2794");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Ukrainian Linguist");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/2794.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-MGySgt");
        db.insert(MOS, null, values1);


        values.put(MOSTITLES_TITLE, "28 Data/Communications Maintenance ");
        values.put(MOSTITLES_BRANCH, Branch_USMC);


        mostitleId = db.insert(MOSTITLES, null, values);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2800");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Basic Data/Communications Maintenance Marine");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2821");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Technical Controller Marine");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/2821.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvc-Sgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2822");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Electronic Switching Equipment Technician");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/2822.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2823");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Technical Control Chief");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/2826.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "SSgt-MGySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2826");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "AN/MSC-63A Maintenance Technician");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/2862.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Sgt-GySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2827");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Tactical Electronic Reconnaissance Process/Evaluation System (TERPES) Technician");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/2827.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Sgt-GySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2831");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " AN/TRC-170 Technician/Multichannel Equipment Repairer (Feeder MOS for 2834)");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/2831.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt - Sgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2833");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Fleet Satellite Terminal Technician");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Sgt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2834");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Satellite Communications (SATCOM) Technician");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/2834.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Sgt-GySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2841");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Ground Radio Repairman");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt - Sgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2844");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Ground Communications Organizational Repairer");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/2844.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt - Sgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2846");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Ground Radio Intermediate Repairer");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/2846.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt - Sgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2847");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Telephone Systems/Personal Computer Intermediate Repairer");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/2847.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt - Sgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2848");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Tactical Remote Sensor System (TRSS) Maintainer");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/2848.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Lcpl - GySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2862");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Electronics Maintenance Technician");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/2862.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Sgt - GySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2871");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Test Measurement and Diagnostic Equipment Technician");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/2871.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt - Sgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2874");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Metrology Technician");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/2874.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Sgt - MGySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2881");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "2M/ATE Technician(deprecated)");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/2881.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt - GySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2887");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Artillery Electronics Technician");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/2887.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt - GySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2891");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Electronics Maintenance Chief");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/2891.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Msgt - MGySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2802");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Electronics Maintenance Chief");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/2802.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "Capt - LtCol");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2805");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Data/Communications Maintenance Officer");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/2805.htm");
        values1.put(MOS_TYPE, "Warrant Officer");
        values1.put(MOS_RANK, " WO - CW05");
        db.insert(MOS, null, values1);


        values.put(MOSTITLES_TITLE, "30 Supply Administration and Operations");
        values.put(MOSTITLES_BRANCH, Branch_USMC);


        mostitleId = db.insert(MOSTITLES, null, values);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "3000");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Basic Supply Administration and Operations Marine");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "3043");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Supply Administration and Operations Clerk");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjo2/a/3043.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt- MGySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "3044");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Contract Specialist");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/3044.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Sgt - MGySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "3051");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Warehouse Clerk");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/3051.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt - MGySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "3052");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Packaging Specialist");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/3052.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt - MGySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "3072");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Aviation Supply Clerk");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt - MGySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "3002");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Ground Supply Officer");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/3002.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, " 2ndLt- LtCol");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "3010");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Contracting Officer");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/3006.htm");
        values1.put(MOS_TYPE, "Warrant Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "3010");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Ground Supply Operations Officer");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/3010.htm");
        values1.put(MOS_TYPE, "Warrant Officer");
        values1.put(MOS_RANK, "WO - CW05");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "3100");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Basic Distribution Management Marine");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-SSgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "3112");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Distribution Management Specialist");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjo2/a/3112.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt - MGySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "3102");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Distribution Management Officer");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/3102.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "WO – CWO5/ Capt- LtCol");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "3381");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Food Service Specialist");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjo2/a/3381.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt - MGySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "3372");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Marine Aide-enlisted aide to General and Flag officers");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjo2/a/3372.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt - MGySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "3302");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Food Service Officer");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjo2/a/3112.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "WO – CWO5/ Capt- LtCol");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "3400");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Basic Financial Management Marine");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt - GySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "3432");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Finance Technician");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/3432.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt - MGySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "3441");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Non-appropriated fund (NAF) Audit Technician");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/3441.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Sgt - MGySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "3451");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Financial Management Resource Analyst");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/3451.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt - MGySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "3402");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Finance Officer");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/officerj3/a/3402.htm");
        values1.put(MOS_TYPE, "Warrant Officer");
        values1.put(MOS_RANK, "WO - CW05");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "3404");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Financial Management Officer");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/3404.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, " 2ndLt - LtCol");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "3408");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Financial Management Resource Officer");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/3408.htm");
        values1.put(MOS_TYPE, "Warrant Officer");
        values1.put(MOS_RANK, "WO – CWO5");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "3410");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Non-appropriated fund (NAF) Auditing Officer");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/officerj3/a/3410.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "WO – CWO5/ Capt-LtCol");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "3450");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Planning, Programming, and Budgeting System (PPBS) Officer");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "3451");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Basic Motor Transport Marine");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt - GySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "3521");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Automotive Organizational Technician");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/3521.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt - Sgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "3522");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Automotive Intermediate Mechanic");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/3522.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "LCpl - Sgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "3524");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Fuel and Electrical Systems Mechanic");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "LCpl - Sgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "3522");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Crash/Fire/Rescue Vehicle Mechanic");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/3526.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "LCpl - GySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "3529");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Motor Transport Maintenance Chief");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/3529.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "SSgt - MGySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "3531");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Motor Vehicle Operator");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/3531.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt - Sgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "3533");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Logistics Vehicle System Operator");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/3533.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt - Sgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "3534");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Semitrailer Refueler Operator");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/3534.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "LCpl - Sgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "3536");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Vehicle Recovery Operator");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/3536.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt - Sgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "3537");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Motor Transport Operations Chief");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/3537.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "SSgt - MGySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "3538");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Licensing Examiner");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/3538.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Sgt - GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "3502");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Motor Transport Officer");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "3510");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Motor Transport Maintenance Officer");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "4100");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " Basic Exchange Marine");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Sgt-SSgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "3510");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Motor Transport Maintenance Officer");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjo2/a/4133.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Sgt-MGySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "4130");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " Marine Corps Exchange Officer");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjo2/a/4133.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "WO-CWO5");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "4300");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Motor Transport Maintenance Officer");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-LCpl");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "4313");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " Broadcast Journalist");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjo2/a/4313.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-MGySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "4341");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Combat Correspondent");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjo2/a/4341.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-MGySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "4302");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Public Affairs Officer");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/4302.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "2ndLt-LtCol");


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "4302");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Mass Communication Specialist");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/4305.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "4330");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Historical Officer");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);


        values.put(MOSTITLES_TITLE, "44 Legal Services");
        values.put(MOSTITLES_BRANCH, Branch_USMC);


        mostitleId = db.insert(MOSTITLES, null, values);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "4400");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Basic Legal Services Marine");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "4421");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Legal Services Specialist");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/4421.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-MGySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "4429");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Legal Services Reporter (Stenotype)");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/4429.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Sgt-MGySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "4401");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " Student Judge Advocate");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "4330");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Historical Officer");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "4405");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Master of International Law");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/4405.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "4406");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " Master of Environmental Law");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/4406.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "4406");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " Master of Labor Law");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/4407.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "4408");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " Master of Procurement Law");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/4408.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "4408");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " Master of Criminal Law");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/4409.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "4410");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " Master of Law (General)");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/4410.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "4330");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Legal Administrative Officer");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/4430.htm");
        values1.put(MOS_TYPE, "Warrant Officer");
        values1.put(MOS_RANK, "CWO1-CWO5");
        db.insert(MOS, null, values1);


        values.put(MOSTITLES_TITLE, "46 Combat Camera (COMCAM)");
        values.put(MOSTITLES_BRANCH, Branch_USMC);


        mostitleId = db.insert(MOSTITLES, null, values);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "4600");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Basic Combat Camera Marine");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-SSgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "4612");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Production Specialist");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/4612.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-SSgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "4616");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " Reproduction Equipment Repairman");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/4616.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Cpl-SSgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "4641");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Combat Photographer");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/4641.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-SSgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "4671");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Combat Videographer");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/4671.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-SSgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "4691");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Combat Camera Chief");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/4691.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "GySgt- MGySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "4602");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Combat Camera (COMCAM) Officer");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/4602.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, " WO – CWO5/Capt-LtCol");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "4606");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " Combat Artist (Officer)");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/4606.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);


        values.put(MOSTITLES_TITLE, "48 Recruiting and Retention Specialist ");
        values.put(MOSTITLES_BRANCH, Branch_USMC);


        mostitleId = db.insert(MOSTITLES, null, values);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "4821");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Career Retention Specialist (PMOS)");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Sgt- MGySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "4801");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Recruiting Officer-Marine Corps Total Force Expert FMOS");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "4802");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " Recruiting Officer-Operational Expert FMOS");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "4803");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " Recruiting Officer-Procurement Expert FMOS");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "4804");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " Recruiting Officer-Multiple Tour Expert FMOS");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "4810");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Recruiting Officer (Ill) PMOS");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);


        values.put(MOSTITLES_TITLE, "55 Music ");
        values.put(MOSTITLES_BRANCH, Branch_USMC);


        mostitleId = db.insert(MOSTITLES, null, values);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "5500");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Basic Musician");

        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "5511");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Member, The President's Own, United States Marine Band (PMOS)");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/5511.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "SSgt-MGySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "5512");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Member, The Commandant's Own, United States Marine Drum and Bugle Corps (PMOS)");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjo2/a/5511new.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-MGySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "5519");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Enlisted Conductor");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/5519.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "SSgt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "5521");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Drum Major");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/5521.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "SSgt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "5521");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Small Ensemble Leader");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/5522.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "SSgt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "5523");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Instrument Repair Technician");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/5523.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "SSgt-MGySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "5524");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Musician");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/5524.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-SSgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "5526");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Musician, Oboe");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/5526.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-SSgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "5528");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Musician, Bassoon");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/5528.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-SSgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "5534");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Musician, Clarinet");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/5534.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-SSgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "5536");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Musician, Flute/Piccolo");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/5536.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-SSgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "5537");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Musician, Saxophone");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/5537.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-SSgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "5541");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Musician, Trumpet");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/5541.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-SSgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "5543");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Musician, Euphonium ");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/5543.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-SSgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "5544");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Musician, Horn");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/5544.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-SSgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "5546");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Musician, Trombone ");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/5546.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-SSgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "5547");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Musician, Tuba/Sousaphone ");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/5547.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-SSgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "5548");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Musician, Electric Bass");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/5548.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-SSgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "5563");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Musician, Percussion (Drums, Tympani, and Mallets)");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/5563.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-SSgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "5565");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Musician, Piano ");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/5565.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-SSgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "5566");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Musician, Guitar ");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/5566.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-SSgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "5567");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Musician, Arranger, Band ");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/5567.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-SSgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "5571");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Musician, Drum and Bugle Corps Drum Major ");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/5571.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-SSgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "5574");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " Musician, Soprano or Mellophone Bugle ");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/5574.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-SSgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "5576");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Musician, French Horn Bugle ");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/5576.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-SSgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "5577");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Musician, Bass Baritone Bugle ");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/5577.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-SSgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "5579");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Musician, Contrabass Bugle ");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/5579.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-SSgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "5592");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Musician, Drum and Bugle Corps Arranger");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/5592.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-SSgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "5593");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Musician, Percussion");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/5593.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-SSgt");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "5501");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " Basic Band Officer ");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "5502");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Band Officer");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/officerj3/a/5502.htm ");
        values1.put(MOS_TYPE, "Warrant Officer");
        values1.put(MOS_RANK, "WO-CWO5");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "5505");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Director/Assistant Director, The President's Own, U.S. Marine Band (PMOS)");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/officerj3/a/5505.htm ");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "Capt-Col");
        db.insert(MOS, null, values1);

        values1.put(MOS_NUMBER, "5506");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " Staff Officer, The President's Own, U.S. Marine Band ");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/officerj3/a/5506.htm ");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "Major/CWO4");
        db.insert(MOS, null, values1);

        values1.put(MOS_NUMBER, "5507");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " U.S. Marine Drum and Bugle Corps Officer (PMOS)");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/officerj3/a/5507.htm ");
        values1.put(MOS_TYPE, "Warrant Officer");
        values1.put(MOS_RANK, "Major/CWO4");
        db.insert(MOS, null, values1);


        values.put(MOSTITLES_TITLE, "57 Chemical, Biological, Radiological, and Nuclear (CBRN) Defense ");
        values.put(MOSTITLES_BRANCH, Branch_USMC);
        mostitleId = db.insert(MOSTITLES, null, values);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "5700");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " Basic Chemical, Biological, Radiological, and Nuclear (CBRN) Defense Marine ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-SSgt");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "5711");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " Chemical, Biological, Radiological, and Nuclear (CBRN) Defense Specialist ");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjo2/a/5711.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-MGySgt");
        db.insert(MOS, null, values1);
        values1.put(MOS_NUMBER, "5731");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " Joint Chemical, Biological, Radiological, Nuclear Reconnaissance System Operator (JCBRNRS) LAV Operator");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjo2/a/5731.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-SSgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "5702");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Chemical, Biological, Radiological, and Nuclear (CBRN) Defense Officer ");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjo2/a/5702.htm");
        values1.put(MOS_TYPE, "Warrant Officer");
        values1.put(MOS_RANK, "WO-CWO5");
        db.insert(MOS, null, values1);




        values.put(MOSTITLES_TITLE, "58 Military Police and Corrections");
        values.put(MOSTITLES_BRANCH, Branch_USMC);
        mostitleId = db.insert(MOSTITLES, null, values);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "5800");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Basic Military Police and Corrections Marine");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "5811");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Military Police");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjo2/a/5811.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-MGySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "5812");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Working Dog Handler ");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjo2/a/5812.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-SSgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "5813");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Accident Investigator");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjo2/a/5813.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Cpl-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "5814");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Physical Security Specialist");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjo2/a/5814.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Cpl-GySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "5816");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Special Reaction Team (3RT) Member");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjo2/a/5816.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Cpl-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "5819");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Military Police Investigator");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjo2/a/5819.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Cpl-GySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "5821");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Criminal Investigator CID Agent ");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjo2/a/5821.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Sgt-MGySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "5822");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Forensic Psycho-physiologist (Polygraph Examiner)");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjo2/a/5822.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "SSgt-MGySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "5831");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Correctional Specialist");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjo2/a/5831.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-MGySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "5832");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Correctional Counselor");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjo2/a/5832.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Sgt-MGySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "5803");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Correctional Counselor");
        values1.put(MOS_Link, "Military Police Officer");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "2ndLt-LtCol");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "5804");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Corrections Officer");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/5804.htm");
        values1.put(MOS_TYPE, "Warrant Officer");
        values1.put(MOS_RANK, "WO-CWO5");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "5805");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Criminal Investigation Officer");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjo2/a/5805.htm");
        values1.put(MOS_TYPE, "Warrant Officer");
        values1.put(MOS_RANK, "WO-CWO5");
        db.insert(MOS, null, values1);



        values.put(MOSTITLES_TITLE, "59 Electronics Maintenance ");
        values.put(MOSTITLES_BRANCH, Branch_USMC);

        mostitleId = db.insert(MOSTITLES, null, values);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "5900");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Basic Electronics Maintenance Marine");

        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "5912");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Avenger System Maintainer");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjo2/a/5912.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-Msgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "5939");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Aviation Communication Systems Technician");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjo2/a/5939.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-Msgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "5942");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Aviation Radar Repairer");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjo2/a/5942.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-Sgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "5948");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Aviation Radar Technician ");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjo2/a/5948.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Sgt-Msgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "5952");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Air Traffic Control Navigational Aids Technician");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjo2/a/5952.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-Gysgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "5953");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Air Traffic Control Radar Technician ");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjo2/a/5953.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "5954");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Air Traffic Control Communications Technician");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjo2/a/5954.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-Gysgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "5959");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Air Traffic Control Systems Maintenance Chief ");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjo2/a/5959.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Msgt-MGySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "5962");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Tactical Data Systems Equipment (TDSE) Repairer ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-Sgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "5974");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Tactical Data Systems Administrator (TDSA)");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjo2/a/5974.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-Msgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "5979");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Tactical Air Operations Module/Air Defense Technician ");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjo2/a/5979.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-Msgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "5993");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Electronics Maintenance Chief ");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjo2/a/5993.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "MGysgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "5902");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Electronics Maintenance Officer (Aviation)");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/officerj3/a/5902.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "Capt-LtCol");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "5910");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Aviation Radar Maintenance Officer");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/officerj3/a/5910.htm");
        values1.put(MOS_TYPE, "Warrant Officer");
        values1.put(MOS_RANK, "WO-CWO5");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "5950");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Air Traffic Control Systems Maintenance Officer ");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/officerj3/a/5950.htm");
        values1.put(MOS_TYPE, "Warrant Officer");
        values1.put(MOS_RANK, "WO-CWO5");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "5970");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Data Systems Maintenance Officer");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjo2/a/5970.htm");
        values1.put(MOS_TYPE, "Warrant Officer");
        values1.put(MOS_RANK, "WO-CWO5");
        db.insert(MOS, null, values1);


        values.put(MOSTITLES_TITLE, "60/61/62 Aircraft Maintenance ");
        values.put(MOSTITLES_BRANCH, Branch_USMC);

        mostitleId = db.insert(MOSTITLES, null, values);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6000");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Basic Aircraft Maintenance Marine");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6012");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Aviation Maintenance Controller/Production Controller");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjo2/a/6012.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Sgt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6018");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " Aviation Quality Assurance Representative (QAR), Collateral Duty Quality Assurance Representative (CDQAR), and Collateral Duty Inspector (CDI)");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjo2/a/6018.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Cpl-MGySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6019");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Aircraft Maintenance Chief ");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjo2/a/6019.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "MSgt-MGySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6023");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Aircraft Power Plants Test Cell Operator");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjo2/a/6023.htm ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Cpl-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6033");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Aircraft Nondestructive Inspection Technician");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjo2/a/6033.htm ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Cpl-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6042");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Individual Material Readiness List (IMRL) Asset Manager");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjo2/a/6042.htm ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-MGySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6043");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " Aircraft Welder");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjo2/a/6043.htm ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "LCpl-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6046");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Aircraft Maintenance Administration Specialist ");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6046.htm ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-MGySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6048");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Flight Equipment Technician (Formerly MOS 6060)");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6048.htm ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6049");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "NALCOMIS Application Administrator/Analyst");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6049.htm ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Sgt-MGySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6061");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Aircraft Intermediate Level Hydraulic/Pneumatic Mechanic-Trainee");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6062");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Aircraft Intermediate Level Hydraulic/Pneumatic Mechanic");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6062.htm ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6071");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " Aircraft Maintenance Support Equipment (SE) Mechanic-Trainee ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6072");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " Aircraft Maintenance Support Equipment (SE) Hydraulic/Pneumatic/Structures Mechanic ");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6072.htm ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6073");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Aircraft Maintenance Support Equipment (SE) Electrician/Refrigeration Mechanic");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6073.htm ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6074");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Cryogenics Equipment Operator");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6074.htm ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6091");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Aircraft Intermediate Level Structures Mechanic-Trainee");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6092");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Aircraft Intermediate Level Structures Mechanic");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6092.htm ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6100");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Helicopter/Tiltrotor Mechanic-Trainee");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6111.htm ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6112");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Helicopter Mechanic, CH-46");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6112.htm ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6113");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Helicopter Mechanic, CH-53");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6113.htm ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6114");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Helicopter Mechanic, UH/AH-1");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6114.htm ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6116");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " Tiltrotor Mechanic, MV-22");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6116.htm ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6122");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Helicopter Power Plants Mechanic, T-58");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6122.htm ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6123");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Helicopter Power Plants Mechanic, T-64");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6123.htm ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6124");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Helicopter Power Plants Mechanic, T-400/T-700");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6124.htm ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6132");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Helicopter/Tiltrotor Dynamic Components Mechanic");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6132.htm ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6124");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Helicopter/Tiltrotor Airframe Mechanic-Trainee");

        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6152");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Helicopter Airframe Mechanic, CH-46");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6152.htm ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6153");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Helicopter Airframe Mechanic, CH-53");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6153.htm ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6154");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Helicopter Airframe Mechanic, UH/AH-1");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6154.htm ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6156");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Tiltrotor Airframe Mechanic, MV-22");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6156.htm ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6162");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Presidential Support Specialist");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6162.htm ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Lcpl-MGySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6172");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Helicopter Crew Chief, CH-46");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6172.htm ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6173");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Helicopter Crew Chief, CH-53");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6173.htm ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6174");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Helicopter Crew Chief, UH-1");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6174.htm ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6176");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Tiltrotor Crew Chief, MV-22");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6176.htm ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6177");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Weapons and Tactics Crew Chief Instructor");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6177.htm ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "LCpl-MGySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6178");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "VH-60N Presidential Helicopter Crew Chief");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6178.htm ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "LCpl-MGySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6179");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "VH-3D Presidential Helicopter Crew Chief");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6179.htm ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "LCpl-MGySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6199");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " Enlisted Aircrew/Aerial Observer/Gunner");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6199.htm ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-MGySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6211");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Fixed-wing Aircraft Mechanic-Trainee");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-MGySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6212");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Fixed-Wing Aircraft Mechanic, AV-8/TAV-8");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6212.htm ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6213");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Fixed-Wing Aircraft Mechanic, EA-6");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6213.htm ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6214");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Unmanned Aerial Vehicle (UAV) Mechanic");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6214.htm ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6216");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Fixed-Wing Aircraft Mechanic, KC-130");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6216.htm ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6217");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Fixed-Wing Aircraft Mechanic, F/A-18");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6217.htm ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6222");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Fixed-Wing Aircraft Power Plants Mechanic, F-402");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6222.htm ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6223");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Fixed-Wing Aircraft Power Plants Mechanic, J-52");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6223.htm ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6226");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " Fixed-Wing Aircraft Power Plants Mechanic, T-56");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6226.htm ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "LCpl-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6227");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Fixed-wing Aircraft Power Plants Mechanic, F-404");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6227.htm ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6242");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Fixed-Wing Aircraft Flight Engineer, KC-130");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6242.htm ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6243");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Fixed-Wing Transport Aircraft Specialist, C-9");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6243.htm ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6244");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Fixed-Wing Transport Aircraft Specialist, C-12");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6244.htm ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pfc-MGySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6246");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Fixed-Wing Transport Aircraft Specialist, C-20");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6246.htm ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "LCpl-MGySgt");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6247");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Fixed-Wing Transport Aircraft Specialist, UC-35");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6247.htm ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "LCpl-MGySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6251");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Fixed-Wing Aircraft Airframe Mechanic-Trainee");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6251.htm ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6252");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Fixed-Wing Aircraft Airframe Mechanic, AV-8/TAV-8");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6252.htm ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "LCpl-MGySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6253");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Fixed-Wing Aircraft Airframe Mechanic, EA-6");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6253.htm ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6256");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Fixed-Wing Aircraft Airframe Mechanic, KC-130");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6256.htm ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6257");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Fixed-Wing Aircraft Airframe Mechanic, F/A-18");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6257.htm ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6258");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Fixed-Wing Aircraft Airframe Mechanic, F-35B");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6276");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Fixed-Wing Aircraft Crew Chief, KC-130");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6276.htm ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-MGySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6281");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Fixed-Wing Aircraft Safety Equipment Mechanic- Trainee");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6281.htm ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6282");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Fixed-Wing Aircraft Safety Equipment Mechanic, AV-8/TAV-8");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6282.htm ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6283");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Fixed-Wing Aircraft Safety Equipment Mechanic, EA-6");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6283.htm ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6286");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Fixed-Wing Aircraft Safety Equipment Mechanic, KC-130");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6286.htm ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6287");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Fixed-Wing Aircraft Safety Equipment Mechanic, F/A-18");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6287.htm ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6002");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Aircraft Maintenance Officer");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/6002.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "2ndLt-Col");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6004");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Aircraft Maintenance Engineer Officer");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/6004.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "Capt-LtCol");
        db.insert(MOS, null, values1);

        values.put(MOSTITLES_TITLE, "63/64 Avionics");
        values.put(MOSTITLES_BRANCH, Branch_USMC);

        mostitleId = db.insert(MOSTITLES, null, values);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6311");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "6311 Aircraft Communications/Navigation/Electrical/Weapon Systems Technician-Trainee, OMA");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6311.htm ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6312");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Aircraft Communications/Navigation/Weapon Systems Technician, AV-8");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6312.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6313");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Aircraft Communications/Navigation/Weapon Systems Technician, EA-6");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6313.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6314");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Unmanned Aerial Vehicle (UAV) Avionics Technician");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6314.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6316");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Aircraft Communications/Navigation Systems Technician, KC-130");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6316.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6317");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Aircraft Communications/Navigation Systems Technician, F/A-18");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6317.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6322");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " Aircraft Communications/Navigation/Electrical Systems Technician, CH-46");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6322.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6323");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Aircraft Communications/Navigation/Electrical Systems Technician, CH-53");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6323.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6324");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Aircraft Communications/Navigation/Electrical/Weapon Systems Technician, U/AH-1");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6324.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6326");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " Aircraft Communications/Navigation/Electrical/Weapon Systems Technician, V-22");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6326.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6331");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Aircraft Electrical Systems Technician-Trainee");

        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6332");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Aircraft Electrical Systems Technician, AV-8");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6332.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6333");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Aircraft Electrical Systems Technician, EA-6");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6333.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6336");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Aircraft Electrical Systems Technician, KC-130");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6336.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6337");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Aircraft Electrical Systems Technician, F/A-18");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6337.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6338");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Aircraft Avionics Technician, F-35");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6386");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Aircraft Electronic Countermeasures Systems Technician, EA-6B");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6386.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6391");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Avionics Maintenance Chief");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6391.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6411");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Aircraft Communications/Navigation Systems Technician- Trainee, IMA ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6312");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Aircraft Communications Systems Technician, IMA");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6312.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6413");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Aircraft Navigation Systems Technician, IFF/RADAR/TACAN, IMA");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6413.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6414");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Advanced Aircraft Communications/Navigation Systems Technician, IMA");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6391.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6422");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Aircraft Cryptographic Systems Technician, IMA");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6422.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6423");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Aviation Electronic Microminiature/Instrument and Cable Repair Technician, IMA");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6423.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6431");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Aircraft Electrical Systems Technician-Trainee");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6432");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Aircraft Electrical/Instrument/Flight Control Systems Technician, Fixed Wing, IMA");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6432.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6433");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Aircraft Electrical/Instrument/flight Control Systems Technician, Helicopter, IMA");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6433.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6434");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Advanced Aircraft Electrical/Instrument/Flight Control Systems Technician, IMA");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6434.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6461");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Hybrid Test Set Technician, IMA");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6461.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6462");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Avionics Test Set (ATS) Technician, IMA");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6462.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6434");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Radar Test Station (RTS)/Radar Systems Test Station (RSTS) Technician, IMA");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6463.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6434");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Aircraft Inertial Navigation System Technician, IMA");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6464.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6466");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Aircraft Forward Looking Infrared/Electro-Optical Technician, IMA");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6463.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6467");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Consolidated Automatic Support System (CASS) Technician, IMA");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6467.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6468");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Aircraft Electrical Equipment Test Set (EETS)/Mobile Electronic Test Set (METS) Technician");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6469");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Advanced Automatic Test Equipment Technician, IMA");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6469.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6482");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Aircraft Electronic Countermeasures Systems Technician, Fixed Wing, IMA");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6482.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6483");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Aircraft Electronic Countermeasures Systems Technician, Helicopter, IMA");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6483.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6484");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Aircraft Electronic Countermeasures Systems/RADCOM/CAT IIID Technician, IMA");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6484.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6486");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Advanced Aircraft Electronic Countermeasures Technician, IMA");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6491");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Aviation Precision Measurement Equipment (PME) Chief ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6492");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Aviation Precision Measurement Equipment/Calibration and Repair Technician, IMA");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6492.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6493");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Aviation Meteorological Equipment Technician, OMA/IMA");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6493.htm");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6499");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Mobile Facilities Technician");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Cpl-GySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6302");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Avionics Officer");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/officerj3/a/6302.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "WO-CWO5/Capt-LtCol");
        db.insert(MOS, null, values1);






        values.put(MOSTITLES_TITLE, "65 Aviation Ordnance ");
        values.put(MOSTITLES_BRANCH, Branch_USMC);


        mostitleId = db.insert(MOSTITLES, null, values);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6511");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Aviation Ordnance Trainee");
        values1.put(MOS_TYPE, "Enlisted");

        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6531");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Aviation Ordnance Technician, (Organizational/Squadron Level)");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjo2/a/6531.htm");
        values1.put(MOS_RANK, "Pvt - SSgt");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6532");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Aviation Ordnance Technician A4/TA4/OA4");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6541");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Intermediate Aviation Ordnance Technician (Intermediate/Equipment Maintenance Level)");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6541.htm");
        values1.put(MOS_RANK, "Pvt - SSgt");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6591");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " Aviation Ordnance Chief (Organizational/Intermediate Level) ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6591.htm");
        values1.put(MOS_RANK, "GySgt- MGySgt");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6502");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Aviation Ordnance Officer");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/6502.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "WO-CWO5/Capt-LtCol");
        db.insert(MOS, null, values1);




        values.put(MOSTITLES_TITLE, "66 Aviation Logistics");
        values.put(MOSTITLES_BRANCH, Branch_USMC);


        mostitleId = db.insert(MOSTITLES, null, values);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6617");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Enlisted Aviation Logistician");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6617.htm ");
        values1.put(MOS_RANK, "Pvt - MGySgt");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6672");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Aviation Supply Specialist");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6672.htm");
        values1.put(MOS_RANK, "Pvt - MGySgt");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6694");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Aviation Logistics Information Management and Support Specialists");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6694.htm");
        values1.put(MOS_RANK, "Pvt - MGySgt");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6602");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Aviation Supply Officer");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/6602.htm");
        values1.put(MOS_RANK, "2ndLt - LtCol");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6604");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Aviation Supply Operations Officer");
        values1.put(MOS_TYPE, "Warrant Officer");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/66.-uvz.htm");
        values1.put(MOS_RANK, "WO-CWO5");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6607");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " Aviation Logistician");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/6607.htm");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6608");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "AIRSpeed Officer NMOS");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/6608.htm");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);



        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6677");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Weapons and Tactics Instructor-Aviation Logistician");
        values1.put(MOS_TYPE, "Enlisted");

        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);





        values.put(MOSTITLES_TITLE, "68 Meteorological and Oceanographic (METOC)");
        values.put(MOSTITLES_BRANCH, Branch_USMC);


        mostitleId = db.insert(MOSTITLES, null, values);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6800");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Meteorology & Oceanography Services");
        values1.put(MOS_TYPE, "Enlisted");

        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6821");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " METOC Observer (No longer in use)");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6821.htm");
        values1.put(MOS_RANK, "Pvt - Cpl");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6842");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "METOC Analyst Forecaster");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6842.htm");
        values1.put(MOS_RANK, "Pvt - MGySgt");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6852");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "METOC Analyst Forecaster");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/6852.htm");
        values1.put(MOS_RANK, "Cpl - MGySgt");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6802");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Meteorological and Oceanographic (METOC) Services Officer");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/6802.htm");
        values1.put(MOS_RANK, "WO – CWO5/Capt-LtCol");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6877");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Weapons and Tactics Instructor-METOC");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/6877.htm");

        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);







        values.put(MOSTITLES_TITLE, "70 Airfield Services");
        values.put(MOSTITLES_BRANCH, Branch_USMC);


        mostitleId = db.insert(MOSTITLES, null, values);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "7011");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Expeditionary Airfield Systems Technician");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/7011.htm");
        values1.put(MOS_TYPE, "Enlisted");

        values1.put(MOS_RANK, "Pvt-MGySgt ");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "7041");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Aviation Operations Specialist");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/7041.htm");
        values1.put(MOS_TYPE, "Enlisted");

        values1.put(MOS_RANK, "Pvt-MGySgt ");

        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "7051");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Aircraft Rescue and Firefighting Specialist");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/7051.htm");
        values1.put(MOS_TYPE, "Enlisted");

        values1.put(MOS_RANK, "Pvt-MGySgt ");

        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "7002");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Expeditionary Airfield and Emergency Services Officer");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/7002.htm ");
        values1.put(MOS_TYPE, "Warrant Officer");

        values1.put(MOS_RANK, "WO-CWO5");

        db.insert(MOS, null, values1);





        values.put(MOSTITLES_TITLE, "72 Air Control/Air Support/Anti-air Warfare/Air Traffic Control");
        values.put(MOSTITLES_BRANCH, Branch_USMC);


        mostitleId = db.insert(MOSTITLES, null, values);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "7212");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Low Altitude Air Defense Gunner");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/7212.htm");
        values1.put(MOS_TYPE, "Enlisted");

        values1.put(MOS_RANK, "Pvt-MGySgt ");

        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "7222");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " Hawk Missile Operator ");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/7222.htm");
        values1.put(MOS_TYPE, "Enlisted");

        values1.put(MOS_RANK, "Pvt-MGySgt ");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "7234");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Air Control Electronics Operator");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/7234.htm");
        values1.put(MOS_TYPE, "Enlisted");

        values1.put(MOS_RANK, "Pvt-Sgt ");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "7236");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Tactical Air Defense Controller ");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/7236.htm");
        values1.put(MOS_TYPE, "Enlisted");

        values1.put(MOS_RANK, "Sgt-MGySgt ");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "7242");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Air Support Operations Operator");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/7242.htm");
        values1.put(MOS_TYPE, "Enlisted");

        values1.put(MOS_RANK, "Pvt-MGySgt ");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "7251");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Air Traffic Controller – Trainee");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/7251.htm");
        values1.put(MOS_TYPE, "Enlisted");

        values1.put(MOS_RANK, "Pvt-Sgt ");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "7252");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Air Traffic Controller - Tower");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/7252.htm");
        values1.put(MOS_TYPE, "Enlisted");

        values1.put(MOS_RANK, "Pvt-GySgt ");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "7253");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Air Traffic Controller - Radar Arrival/Departure Controller");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/7253.htm");
        values1.put(MOS_TYPE, "Enlisted");

        values1.put(MOS_RANK, "Pvt-GySgt ");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "7254");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Air Traffic Controller - Radar Approach Controller");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/7254.htm");
        values1.put(MOS_TYPE, "Enlisted");

        values1.put(MOS_RANK, "Pvt-GySgt ");

        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "7257");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Air Traffic Controller");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/7257.htm");
        values1.put(MOS_TYPE, "Enlisted");

        values1.put(MOS_RANK, "Pvt-GySgt ");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "7277");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Weapon and Tactics Instructor-Air Control");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/7277.htm");
        values1.put(MOS_TYPE, "Enlisted");

        values1.put(MOS_RANK, "SSgt-MGySgt ");

        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "7291");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Senior Air Traffic Controller");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/7291.htm");
        values1.put(MOS_TYPE, "Enlisted");

        values1.put(MOS_RANK, "MSgt-MGySgt ");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "7202");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " Air Command and Control Officer ");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/7202.htm ");

        values1.put(MOS_TYPE, "Officer");

        values1.put(MOS_RANK, "Maj-LtCol ");

        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "7204");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Low Altitude Air Defense Officer ");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/7204.htm ");
        values1.put(MOS_TYPE, "Officer");

        values1.put(MOS_RANK, "2ndLt-Capt");

        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "7208");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Air Support Control Officer");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/7208.htm");
        values1.put(MOS_TYPE, "Officer");

        values1.put(MOS_RANK, "2ndLt-Capt ");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "7210");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Air Defense Control Officer");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/7210.htm");
        values1.put(MOS_TYPE, "Warrant Officer");

        values1.put(MOS_RANK, "WO-CWO5");

        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "7220");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Air Traffic Control Officer");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/7220.htm");
        values1.put(MOS_TYPE, "Officer");

        values1.put(MOS_RANK, "2ndLt-Capt ");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "7277");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " Weapons and Tactics Instructor-Air Control ");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/7220.htm");
        values1.put(MOS_TYPE, "Officer");

        values1.put(MOS_RANK, "N/A ");

        db.insert(MOS, null, values1);





        values.put(MOSTITLES_TITLE, "73 Navigation Officer/Enlisted Flight Crews");
        values.put(MOSTITLES_BRANCH, Branch_USMC);


        mostitleId = db.insert(MOSTITLES, null, values);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "7313");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Helicopter Specialist, AH-1Z/UH-1Y");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/7313.htm");
        values1.put(MOS_TYPE, "Enlisted");

        values1.put(MOS_RANK, "Pvt-MGySgt ");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "7314");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Unmanned Aerial Vehicle (UAV) Internal Operator ");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/7314.htm");
        values1.put(MOS_TYPE, "Enlisted");

        values1.put(MOS_RANK, "Pvt-MGySgt ");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "7371");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Tactical Systems Operator Trainee");

        values1.put(MOS_TYPE, "Enlisted");

        values1.put(MOS_RANK, "N/A ");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "7372");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Tactical Systems Operator/Mission Specialist");
        values1.put(MOS_TYPE, "Enlisted");

        values1.put(MOS_RANK, "N/A ");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "7382");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Airborne Radio Operator/In-flight Refueling Observer/Loadmaster");

        values1.put(MOS_TYPE, "Enlisted");

        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "7315");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Mission Commander");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/7315.htm ");
        values1.put(MOS_TYPE, "Warrant Officer");

        values1.put(MOS_RANK, "WO-CWO5");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "7380");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Tactical Systems Officer/Mission Specialist");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/7380.htm ");
        values1.put(MOS_TYPE, "Warrant Officer");

        values1.put(MOS_RANK, "WO-CWO5");

        db.insert(MOS, null, values1);



        values.put(MOSTITLES_TITLE, "75 Pilots/Naval Flight Officers");
        values.put(MOSTITLES_BRANCH, Branch_USMC);
        mostitleId = db.insert(MOSTITLES, null, values);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "7500");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " Pilot VMA, FRS Basic A-4M");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A ");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "7501");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Pilot VMA, A-4 Qualified");
        values1.put(MOS_TYPE, "Warrant Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "7502");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Forward Air Controller/Air Officer");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/7502.htm");
        values1.put(MOS_TYPE, "Officer");

        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "7380");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Tactical Systems Officer/Mission Specialist");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/7380.htm ");
        values1.put(MOS_TYPE, "Warrant Officer");

        values1.put(MOS_RANK, "WO-CWO5");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "7508");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Pilot VMA, AV-8A/C Qualified");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/7508.htm ");
        values1.put(MOS_TYPE, "Officer");

        values1.put(MOS_RANK, "2ndLt-LtCol");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "7509");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Pilot VMA, AV-8B Qualified");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/7509.htm ");
        values1.put(MOS_TYPE, "Officer");

        values1.put(MOS_RANK, "2ndLt-LtCol");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "7510");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Pilot VMA (AW), A-6E FRS Basic");
        values1.put(MOS_TYPE, "Officer");

        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "7511");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "7511 Pilot VMA (AW), A-6E Qualified");
        values1.put(MOS_TYPE, "Officer");

        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "7513");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Pilot HMH/M/L/A, Pilot Helicopter");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/7513.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "All");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "7518");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Pilot VMFA, F-35 Qualified");
        values1.put(MOS_TYPE, "Officer");

        values1.put(MOS_RANK, "All");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "7521");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Pilot VMFA, F/A-18 FRS Basic");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/7521.htm ");
        values1.put(MOS_TYPE, "Officer");

        values1.put(MOS_RANK, "2ndLt-LtCol");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "7522");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Pilot VMFA, F-4S Qualified");

        values1.put(MOS_TYPE, "Officer");

        values1.put(MOS_RANK, "2ndLt-LtCol");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "7523");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Pilot VMFA, F/A-18 Qualified");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/7523.htm ");
        values1.put(MOS_TYPE, "Officer");

        values1.put(MOS_RANK, "2ndLt-LtCol");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "7524");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Weapons Systems Officer (WSO), F/A-18D FRS Basic");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/7524.htm ");
        values1.put(MOS_TYPE, "Officer");

        values1.put(MOS_RANK, "2ndLt-LtCol");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "7525");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Weapons Systems Officer (WSO), F/A-18D Qualified");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/7525.htm ");
        values1.put(MOS_TYPE, "Officer");

        values1.put(MOS_RANK, "2ndLt-LtCol");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "7527");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Pilot VMFA, F/A-18D Qualified");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/7527.htm ");
        values1.put(MOS_TYPE, "Officer");

        values1.put(MOS_RANK, "2ndLt-LtCol");

        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "7527");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Pilot VMFA, F/A-18D Qualified");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/7527.htm ");
        values1.put(MOS_TYPE, "Officer");

        values1.put(MOS_RANK, "2ndLt-LtCol");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "7527");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Pilot VMM, V-22 Qualified");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/7532.htm ");
        values1.put(MOS_TYPE, "Officer");

        values1.put(MOS_RANK, "2ndLt-LtCol");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "7541");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " Pilot VMAQ/VMFP, EA-6B FRS Basic ");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/7541.htm ");
        values1.put(MOS_TYPE, "Officer");

        values1.put(MOS_RANK, "2ndLt-LtCol");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "7542");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Pilot VMAQ/VMFP, EA-6A Qualified");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/7542.htm ");
        values1.put(MOS_TYPE, "Officer");

        values1.put(MOS_RANK, "2ndLt-LtCol");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "7543");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Pilot VMAQ/VMFP, EA-6B Qualified");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/7543.htm ");
        values1.put(MOS_TYPE, "Officer");

        values1.put(MOS_RANK, "2ndLt-LtCol");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "7545");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Pilot VMAQ/VMFP, RF-4B Qualified");

        values1.put(MOS_TYPE, "Officer");

        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "7550");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Pilot VMGR, Maritime Advance (NATC)");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/7550.htm ");
        values1.put(MOS_TYPE, "Officer");

        values1.put(MOS_RANK, "2ndLt-LtCol");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "7551");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Pilot VMGR, C-9 Qualified");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/7551.htm ");
        values1.put(MOS_TYPE, "Officer");

        values1.put(MOS_RANK, "2ndLt-LtCol");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "7552");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Pilot VMGR, TC-4C Qualified");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/7552.htm ");
        values1.put(MOS_TYPE, "Officer");

        values1.put(MOS_RANK, "2ndLt-LtCol");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "7553");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Pilot, C-20 Qualified");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/7553.htm ");
        values1.put(MOS_TYPE, "Officer");

        values1.put(MOS_RANK, "2ndLt-LtCol");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "7554");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Pilot VMGR, UC-35 Qualified");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/7554.htm ");
        values1.put(MOS_TYPE, "Officer");

        values1.put(MOS_RANK, "2ndLt-LtCol");

        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "7555");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Pilot VMGR, UC-12B Qualified");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/7555.htm ");
        values1.put(MOS_TYPE, "Officer");

        values1.put(MOS_RANK, "2ndLt-LtCol");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "7556");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Pilot VMGR, KC-130 Co-Pilot (T2P/T3P)");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/7556.htm ");
        values1.put(MOS_TYPE, "Officer");

        values1.put(MOS_RANK, "2ndLt-LtCol");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "7557");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Pilot VMGR, KC-130 Aircraft Commander");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/7557.htm ");
        values1.put(MOS_TYPE, "Officer");

        values1.put(MOS_RANK, "2ndLt-LtCol");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "7558");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Pilot HMH/M/L/A, CH-53D FRS Basic");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/7558.htm ");
        values1.put(MOS_TYPE, "Officer");

        values1.put(MOS_RANK, "2ndLt-LtCol");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "7559");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Pilot VMGR, CT-39 Qualified");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/7559.htm ");
        values1.put(MOS_TYPE, "Officer");

        values1.put(MOS_RANK, "2ndLt-LtCol");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "7559");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Pilot HMH/M/L/A, CH-53E FRS Basic");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/7560.htm ");
        values1.put(MOS_TYPE, "Officer");

        values1.put(MOS_RANK, "2ndLt-LtCol");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "7561");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Pilot HMH/M/L/A, CH-46 FRS Basic");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/7561.htm ");
        values1.put(MOS_TYPE, "Officer");

        values1.put(MOS_RANK, "2ndLt-LtCol");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "7562");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Pilot HMH/M/L/A, CH-46 Qualified");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/7562.htm ");
        values1.put(MOS_TYPE, "Officer");

        values1.put(MOS_RANK, "2ndLt-LtCol");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "7563");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Pilot HMH/M/L/A, UH-1 Qualified");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/7563.htm ");
        values1.put(MOS_TYPE, "Officer");

        values1.put(MOS_RANK, "2ndLt-LtCol");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "7564");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Pilot HMH/M/L/A, CH-53 A/D Qualified");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/7564.htm ");
        values1.put(MOS_TYPE, "Officer");

        values1.put(MOS_RANK, "2ndLt-LtCol");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "7565");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Pilot HMH/M/L/A, AH-1 Qualified");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/7565.htm ");
        values1.put(MOS_TYPE, "Officer");

        values1.put(MOS_RANK, "2ndLt-LtCol");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "7566");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Pilot HMH/M/L/A, CH-53E Qualified");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/7566.htm ");
        values1.put(MOS_TYPE, "Officer");

        values1.put(MOS_RANK, "2ndLt-LtCol");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "7567");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Pilot HMH/M/L/A, UH-1N FRS Basic");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/7567.htm ");
        values1.put(MOS_TYPE, "Officer");

        values1.put(MOS_RANK, "2ndLt-LtCol");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "7568");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Pilot HMH/M/L/A, AH-1 FRS Basic");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/7568.htm ");
        values1.put(MOS_TYPE, "Officer");

        values1.put(MOS_RANK, "2ndLt-LtCol");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "7574");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Qualified Supporting Arms Coordinator (Airborne)");
        values1.put(MOS_TYPE, "Officer");

        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "7576");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Pilot VMO");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "7577");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Weapons and Tactics Instructor");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/7577.htm ");
        values1.put(MOS_TYPE, "Officer");

        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "7578");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Student, Naval Flight Officer (NFO)");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/7578.htm ");
        values1.put(MOS_TYPE, "Officer");

        values1.put(MOS_RANK, "2ndLt-LtCol");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "7580");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Student, Tactical Navigator Flight");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/7580.htm ");
        values1.put(MOS_TYPE, "Officer");

        values1.put(MOS_RANK, "2ndLt-LtCol");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "7582");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Electronic Warfare Officer (EWO), EA-6B FRS Basic)");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/7582.htm ");
        values1.put(MOS_TYPE, "Officer");

        values1.put(MOS_RANK, "2ndLt-LtCol");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "7583");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Bombardier/Navigator, A-6E Qualified");
        values1.put(MOS_TYPE, "Officer");

        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "7584");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Electronic Warfare Officer (EWO), EA-6A Qualified");
        values1.put(MOS_TYPE, "Officer");

        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "7585");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Airborne Reconnaissance Officer (ARO) Qualified RF-4B)");
        values1.put(MOS_TYPE, "Officer");

        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "7587");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Radar Intercept Officer (RIO), F-4S");
        values1.put(MOS_TYPE, "Officer");

        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "7588");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Electronic Warfare Officer (EWO), EA-6B Qualified");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/7588.htm ");
        values1.put(MOS_TYPE, "Officer");

        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "7589");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "V/STOL Landing Signal Officer (LSO)");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/7589.htm ");
        values1.put(MOS_TYPE, "Officer");

        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "7590");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Landing Signal Officer Trainee");

        values1.put(MOS_TYPE, "Officer");

        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "7591");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Naval Flight Officer (VMAW)");
        values1.put(MOS_TYPE, "Officer");

        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "7592");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Pilot VMAW");
        values1.put(MOS_TYPE, "Officer");

        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "7593");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Landing Signal Officer, Phase I/II Qualified");
        values1.put(MOS_TYPE, "Officer");

        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "7594");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Landing Signal Officer, Phase III Qualified");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/7594.htm ");
        values1.put(MOS_TYPE, "Officer");

        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "7595");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Test Pilot/Flight Test Project Officer");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/7595.htm ");
        values1.put(MOS_TYPE, "Officer");

        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "7596");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Aviation Safety Officer (ASO)");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/7596.htm ");
        values1.put(MOS_TYPE, "Officer");

        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "7597");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Pilot, Rotary Wing, Basic");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/7597.htm ");
        values1.put(MOS_TYPE, "Officer");

        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "7598");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Pilot, Fixed Wing, Basic");
        values1.put(MOS_TYPE, "Officer");

        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "7599");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Student Naval Aviator");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/7599.htm ");
        values1.put(MOS_TYPE, "Officer");

        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);






        values.put(MOSTITLES_TITLE, "80 Miscellaneous MOS's (Category II)");
        values.put(MOSTITLES_BRANCH, Branch_USMC);


        mostitleId = db.insert(MOSTITLES, null, values);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "8001");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Basic Officer");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/8001.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "8002");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Joint Terminal Attack Controller (EMOS)");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/8002.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "8003");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "General Officer (PMOS)");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "BGEN-GEN");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "8005");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Special Assignment Officer (FMOS)");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/8005.htm");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "8006");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " Billet Designator—Unrestricted Officer");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "8007");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Billet Designator—Unrestricted Ground Officer (FMOS)");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "8009");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " Billet Designator—Air Control/Antiair Warfare Officer (FMOS)");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/8005.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "8012");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Ground Safety Officer (FMOS)");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/8012.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "8016");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Special Technical Operations (Officer) (FMOS)");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/8016.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "8023");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Parachute Officer (NMOS)");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/8023.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "8024");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Combatant Diver Officer (NMOS)");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/8024.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "8026");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Parachute/Combatant Diver Officer (NMOS)");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "8040");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Colonel, Logistician (PMOS)");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "Col");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "8041");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Colonel, Ground (PMOS)");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "Col");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "8042");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " Colonel, Naval Aviator/Naval Flight Officer (PMOS)");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "Col");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "8051");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Operations Research Specialist (FMOS)");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/8051.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "8055");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Information Management Officer (FMOS)");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "8056");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " Hazardous Material/Hazardous Waste (Officer) (FMOS)");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/8056.htm");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "8057");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Acquisition Professional Candidate (FMOS)");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/8057.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "8058");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Acquisition Manager (Acquisition Core Member) (FMOS)");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/8058.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "8059");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Aviation Acquisition Management Professional (PMOS)");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "Maj-MajGen");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/8059.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "8060");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Acquisition Specialist (FMOS)");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/8060.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "8061");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Acquisition Management Professional (PMOS)");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "Maj-MajGen");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "8220");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Billet Designator—Political Military Officer (FMOS*)");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/8220.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "8221");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " Regional Affairs Officer, Latin America (FMOS)");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/8221.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "8222");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Regional Affairs Officer, Former Soviet Union (FMOS)");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/8222.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "8223");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Regional Affairs Officer, Northeast Asia (FMOS)");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/8223.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "8224");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Regional Affairs Officer, Middle East/North Africa (FMOS)");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/8224.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "8225");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Regional Affairs Officer, Sub-Saharan Africa (FMOS)");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/8225.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "8226");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " Regional Affairs Officer, Southwest Asia (FMOS)");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/8226.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "8227");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Regional Affairs Officer, Western Europe (FMOS)");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/8227.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "8228");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Regional Affairs Officer, Eastern Asia (Excluding Peoples' Republic of China) (FMOS)");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/8228.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "8229");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " Regional Affairs Officer, Eastern Europe (Excluding Former Soviet Union) (FMOS)");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/8229.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "8240");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Basic Foreign area officer (FAO) (FMOS)");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/8240.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "8241");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Foreign Area Officer, Latin America (FMOS)");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/8241.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "8242");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Foreign Area Officer, Latin America (FMOS)");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/8242.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "8243");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Foreign Area Officer, People's Republic of China (PRC) (FMOS)");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/8243.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "8244");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Foreign Area Officer, Middle East/North Africa (FMOS)");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/8244.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "8245");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Foreign Area Officer, Sub-Saharan Africa (FMOS)");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/8245.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "8246");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Foreign Area Officer, Southwest Asia (FMOS)");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/8246.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "8247");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " Foreign Area Officer, Western Europe (FMOS)");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/8247.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "8248");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Foreign Area Officer, East Asia (Excluding PRC) (FMOS)");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/8248.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "8249");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " Foreign Area Officer, Eastern Europe (Excluding Former Soviet Union) (FMOS)");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/8249.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "8802");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Education Officer (FMOS)");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/8802.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "8803");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Leadership Development Specialist (FMOS)");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/8802.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "8820");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Aeronautical Engineer (FMOS)");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/8820.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "8824");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Electronics Engineer (FMOS)");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/8824.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "8825");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Modeling and Simulation Officer (FMOS)");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/8825.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "8826");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Ordnance Systems Engineer (FMOS)");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/8826.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "8831");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Environmental Engineering Management Officer (FMOS)");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/8831.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "8832");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Nuclear Engineer (FMOS)");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/8832.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "8834");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Technical Information Operation Officer (FMOS)");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/8834.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "8840");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Manpower Management Officer (FMOS)");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/8840.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "8844");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Financial Management Specialist (FMOS)");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/8844.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);



        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "8846");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Data Systems Specialist (FMOS)");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/8846.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "8848");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Data Systems Specialist (FMOS)");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/8848.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "8850");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Operations Analyst (FMOS)");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/8850.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "8852");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Defense Systems Analyst (FMOS)");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/8852.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "8858");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Command, Control, Communications, Computers and Intelligence (C41) (FMOS)");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/8858.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "8862");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Material Management Officer (FMOS)");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/8862.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "8866");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Space Operations Officer (FMOS)");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/8866.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "8878");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Historian (FMOS)");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerj3/a/8878.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "8000");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Basic Officer");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-MGySgt");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/8000.htm");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "8002");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Joint Terminal Attack Controller (FMOS)");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "SSgt-MGySgt");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/8000.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "8011");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Basic Marine with Enlistment Guarantee (BASIC MOS)");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-MGySgt");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/8011.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "8012");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Ground Safety Specialist (Enlisted) (FMOS)");        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/8012.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "8013");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Special Assignment—Enlisted (FMOS)");        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/8013.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "8014");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Billet Designator—Enlisted (FMOS*)");        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-MGySgt");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/8014.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "8015");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "College Degree—Enlisted (EMOS)");        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-MGySgt");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/8015.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "8016");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Special Technical Operations (Enlisted) (FMOS)");        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-MGySgt");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/8016.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "8023");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Parachutist (Enlisted) (NMOS)");        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-MGySgt/SgtMaj");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/8023.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "8024");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Combatant Diver Marine (Enlisted) (NMOS)");        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-MGySgt/SgtMaj");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/8024.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "8026");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Parachutist/Combatant Diver Marine (NMOS)");        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-MGySgt/SgtMaj");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/8026.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "8028");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "MECEP Participant (FMOS)");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-MGySgt ");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/8028.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "8056");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Hazardous Material/Hazardous Waste Staff NCO/NCO (FMOS)");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Lcpl-MGySgt ");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/8056.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "8060");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Acquisition Specialist (Enlisted) (FMOS)");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "SSgt-MGySgt ");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/8060.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "8071");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Acquisition Specialist (Enlisted) (FMOS)");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A ");

        db.insert(MOS, null, values1);
        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "8151");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Guard (FMOS*)");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt ");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/8151.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "8152");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Marine Corps Security Force (MCSF) Guard (EMOS)");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt-GySgt ");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/8152.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "8153");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Marine Corps Security Force (MCSF) Cadre Trainer (EMOS)");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Cpl-GySgt ");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/8153.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "8154");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Marine Corps Security Force Close Quarters Battle Team Member (FMOS*) ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "LCpl-SSgt ");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/8154.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "8156");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Marine Security Guard (MSG) (FMOS)");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pfc-MGySgt ");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/8156.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "8411");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Recruiter (EMOS)");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Sgt-SSgt ");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/8411.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "8412");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Career Recruiter (PMOS)");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "GySgt- MGySgt ");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/8412.htm");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "8621");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Surveillance Sensor Operator (NMOS)");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt- MSgt ");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/8621.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "8641");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Microminiature Repairer (NMOS)");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "LCpl- GySgt ");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/8641.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "8711");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Ground Operations Specialist (EMOS)");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Cpl- MGySgt ");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/8711.htm");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "8911");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Barracks and Grounds Marine (FMO5*)");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt- GySgt ");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/8911.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "8972");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Aircrew Trainee (PMOS)");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "Pvt- GySgt ");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/8972.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "8991");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Sergeant Major of the Marine Corps (PMOS)");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "SgtMaj ");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/8991.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "8999");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Sergeant Major/First Sergeant (PMOS)");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "SgtMaj/1stSgt ");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjo2/a/8999.htm");
        db.insert(MOS, null, values1);


        values.put(MOSTITLES_TITLE, "90 Reporting MOS's (Category III)");
        values.put(MOSTITLES_BRANCH, Branch_USMC);


        mostitleId = db.insert(MOSTITLES, null, values);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "9701");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Joint Specialty Officer Nominee (FMOS)");

        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "9702");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Joint Specialty Officer (JSO) (FMOS)");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);










    }

    public void populateusafafsc(SQLiteDatabase db) {

        ContentValues values = new ContentValues();


        values.put(MOSTITLES_TITLE, "1A - Aircrew Operations");
        values.put(MOSTITLES_BRANCH, Branch_USAF);


        long mostitleId = db.insert(MOSTITLES, null, values);


        ContentValues values1 = new ContentValues();


        values1.put(MOS_NUMBER, "1A0X1");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "In-Flight Refueling");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/in-flight-refueling/");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "1A1X1");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Flight Engineer");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/airforceenlistedjobs/a/afjob1a1x1.htm");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "1A2X1");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Aircraft Loadmaster");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/aircraft-loadmaster/");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "1A3X1");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Airborne Mission Systems");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/airforceenlistedjobs/a/afjob1a3x1.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "1A4X1");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Airborne Battle Management Systems");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/airforceenlistedjobs/a/afjob1a4x1.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "1A6X1");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Flight Attendant");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/airforceenlistedjobs/a/afjob1a6x1.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "1A7X1");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Aerial Gunner");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/airforceenlistedjobs/a/afjob1a7x1.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "1A8X1");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Airborne Cryptologic Language Analyst");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/airborne-cryptologic/");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "1A8X2");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Airborne Intelligence, Surveillance, and Reconnaissance Operator");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/airborne-intelligence-surveillance-reconnaissance-operator/");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "1A9X1");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Special Missions Aviation");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/special-missions-aviation/");
        db.insert(MOS, null, values1);


        values.put(MOSTITLES_TITLE, "1B - Cyberspace Defense");
        values.put(MOSTITLES_BRANCH, Branch_USAF);


        mostitleId = db.insert(MOSTITLES, null, values);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "1B4X1");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Cyberspace Defense");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values.put(MOSTITLES_TITLE, "1C - Command and Control Systems Operations");
        values.put(MOSTITLES_BRANCH, Branch_USAF);


        mostitleId = db.insert(MOSTITLES, null, values);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "1C0X2");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Aviation Resource Management");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/aviation-resource-management/");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "1C1X1");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Air Traffic Control");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/air-traffic-control-operations/");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "1C2X1");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Combat Control(males only)");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/combat-control-males-only/");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "1C3X1");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Command Post");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/command-post/");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "1C4X1");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Tactical Air Control Party (TACP)(Males Only)");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/tactical-air-control-party-specialist-tacp-males-only/");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "1C5X1");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Command & Control Battle Management Ops (1C5X1D Weapons Director)");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/airforceenlistedjobs/a/afjob1c5x1.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "1C6X1");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Space Systems Operations");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/space-systems-operations/");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "1C7X1");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Airfield Management");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/airfield-management/");
        db.insert(MOS, null, values1);

        values.put(MOSTITLES_TITLE, "1N - Intelligence");
        values.put(MOSTITLES_BRANCH, Branch_USAF);


        mostitleId = db.insert(MOSTITLES, null, values);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "1N0X1");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Operations Intelligence");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/operations-intelligence-specialist/");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "1N1X1");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Geospatial Intelligence");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/geospatial-intelligence/");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "1N2X1");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Signals Intelligence Analysis");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/communication-signals-intelligence/");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "1N3X1");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Cryptologic Language Analyst");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/cryptologic-linguist/");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "1N4X1");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Network Intelligence Analysis");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/network-intelligence-analyst-specialist/");
        db.insert(MOS, null, values1);

        values.put(MOSTITLES_TITLE, "1P - Aircrew Flight Equipment");
        values.put(MOSTITLES_BRANCH, Branch_USAF);


        mostitleId = db.insert(MOSTITLES, null, values);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "1P0X1");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Aircrew Flight Equipment");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/aircrew-flight-equipment/");
        db.insert(MOS, null, values1);

        values.put(MOSTITLES_TITLE, "1S - Safety");
        values.put(MOSTITLES_BRANCH, Branch_USAF);


        mostitleId = db.insert(MOSTITLES, null, values);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "1S0X1");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Safety Specialist");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/safety-specialist/");
        db.insert(MOS, null, values1);

        values.put(MOSTITLES_TITLE, "1T - Aircrew Protection");
        values.put(MOSTITLES_BRANCH, Branch_USAF);


        mostitleId = db.insert(MOSTITLES, null, values);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "1T0X1");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Survival, Evasion, Resistance, and Escape (SERE)");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/survival-evasion-resistance-and-escape-sere/");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "1T2X1");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Pararescue (Males Only)");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/pararescue-males-only/");
        db.insert(MOS, null, values1);

        values.put(MOSTITLES_TITLE, "1U - Unmanned Aerospace System (UAS) Operations");
        values.put(MOSTITLES_BRANCH, Branch_USAF);


        mostitleId = db.insert(MOSTITLES, null, values);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "1U0X1");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Remotely Piloted Aircraft (RPA) Sensor Operator");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/sensor-operator/");
        db.insert(MOS, null, values1);

        values.put(MOSTITLES_TITLE, "1W - Weather");
        values.put(MOSTITLES_BRANCH, Branch_USAF);


        mostitleId = db.insert(MOSTITLES, null, values);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "1W0X1");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Weather");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/weather-specialist/");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "1W0X2");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Special Operations Weather (males only)");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/special-operations-weather-team-specialist-males-only/");
        db.insert(MOS, null, values1);

        values.put(MOSTITLES_TITLE, "2A - Aerospace Maintenance");
        values.put(MOSTITLES_BRANCH, Branch_USAF);


        mostitleId = db.insert(MOSTITLES, null, values);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2A0x1");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Avionics Test Station and Components");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/avionics-test-and-components/");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2A2x1");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Special Operations Forces/Personnel Recover (SOF/PR) Integrated Communication/Navigation/Mission Systems");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2A3x2");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Integrated Avionics Systems (Attack/Special)");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://usmilitary.about.com/u/ua/airforceenlistedjobs/2a3x2.htm");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2A3x3");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Tactical Aircraft Maintenance");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/tactical-aircraft-maintenance/");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2A3x3");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Aircraft Avionics (A-10, U2, F-15, F-16, and CV22)");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/avionics-systems/");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2A5x1");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Aerospace Maintenance");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/aerospace-maintenance/");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2A5x2");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Helicopter/Tiltrotor Maintenance");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/helicopter-maintenance/");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2A6X1");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Aerospace Propulsion");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/aerospace-propulsion/");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2A7X1");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Aircraft Metals Technology");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/aircraft-metals-technology/");
        db.insert(MOS, null, values1);


        values.put(MOSTITLES_TITLE, "2E - Comm-Elec/Wire Systems Maintenance");
        values.put(MOSTITLES_BRANCH, Branch_USAF);


        mostitleId = db.insert(MOSTITLES, null, values);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2E1X1");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Satellite, Wideband and Telemetry Systems");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2E2XX");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Network Infrastructure Systems");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2E6XX");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Communication Cable and Antenna Systems");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/cable-and-antenna-systems/");
        db.insert(MOS, null, values1);

        values.put(MOSTITLES_TITLE, "2F - Fuel");
        values.put(MOSTITLES_BRANCH, Branch_USAF);


        mostitleId = db.insert(MOSTITLES, null, values);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2F0XX");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Fuels Specialist");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/fuels-specialist/");
        db.insert(MOS, null, values1);

        values.put(MOSTITLES_TITLE, "2G - Logistics Plans");
        values.put(MOSTITLES_BRANCH, Branch_USAF);


        mostitleId = db.insert(MOSTITLES, null, values);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2G0X1");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Logistics Plans");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/logistics-plans/");
        db.insert(MOS, null, values1);

        values.put(MOSTITLES_TITLE, "2M - Missile Maintenance");
        values.put(MOSTITLES_BRANCH, Branch_USAF);


        mostitleId = db.insert(MOSTITLES, null, values);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2M0X1");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Missile and Space Systems Elect Maintenance");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/missile-and-space-systems-electronic-maintenance/");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2M0X2");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Missile and Space Systems Maintenance");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/missile-and-space-systems-maintenance/");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2M0X3");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Missile and Space Facilities");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/missile-and-space-facilities-maintenance/");
        db.insert(MOS, null, values1);

        values.put(MOSTITLES_TITLE, "2P - Precision Measurement");
        values.put(MOSTITLES_BRANCH, Branch_USAF);


        mostitleId = db.insert(MOSTITLES, null, values);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2P0X1");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Precision Measurement Equipment Laboratory");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/precision-measurement-equipment-laboratory/");
        db.insert(MOS, null, values1);

        values.put(MOSTITLES_TITLE, "2R - Maintenance Management");
        values.put(MOSTITLES_BRANCH, Branch_USAF);


        mostitleId = db.insert(MOSTITLES, null, values);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2R0X1");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Maintenance Management Analysis");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/maintenance-management-analysis/");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2R1X1");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Maintenance Management Production");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/maintenance-management-production/");
        db.insert(MOS, null, values1);

        values.put(MOSTITLES_TITLE, "2S - Materiel Management");
        values.put(MOSTITLES_BRANCH, Branch_USAF);


        mostitleId = db.insert(MOSTITLES, null, values);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2S0X1");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Materiel Management");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/material-management/");
        db.insert(MOS, null, values1);

        values.put(MOSTITLES_TITLE, "2T - Transportation & Vehicle Management");
        values.put(MOSTITLES_BRANCH, Branch_USAF);


        mostitleId = db.insert(MOSTITLES, null, values);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2T0X1");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Traffic Management");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/traffic-management/");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2T1X1");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " Vehicle Operations");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/vehicle-operations/");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2T2X1");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " Air Transportation");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/air-transportation/");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2T3X1");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Vehicle and Vehicular Equipment Maintenance");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/vehicle-and-vehicular-equipment-maintenance/");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2T3X2");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Special Vehicle Maintenance");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/special-vehicle-maintenance/");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2T3X3");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Vehicle Maintenance Control And Analysis");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/vehicle-maintenance-control-and-analysis/");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2T3X4");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "General Purpose Vehicle Maintenance");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/special-vehicle-maintenance/");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2T3X5");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Vehicle Body Maintenance");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/airforceenlistedjobs/a/afjob2t3x5.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2T3X7");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Vehicle Management and Analysis");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/vehicle-maintenance-control-and-analysis/");
        db.insert(MOS, null, values1);

        values.put(MOSTITLES_TITLE, "2W - Munitions & Weapons");
        values.put(MOSTITLES_BRANCH, Branch_USAF);


        mostitleId = db.insert(MOSTITLES, null, values);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2W0X1");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Munitions Systems");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/munitions-systems/");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2W1X1");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Aircraft Armament Systems");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/aircraft-armament-systems/");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "2W2X1");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Nuclear Weapons");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/nuclear-weapons/");
        db.insert(MOS, null, values1);

        values.put(MOSTITLES_TITLE, "3A - Information Management");
        values.put(MOSTITLES_BRANCH, Branch_USAF);


        mostitleId = db.insert(MOSTITLES, null, values);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "3A1X1");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Knowledge Operations Management");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/knowledge-operations-management/");
        db.insert(MOS, null, values1);


        values.put(MOSTITLES_TITLE, "3C - Communication-Computer Systems");
        values.put(MOSTITLES_BRANCH, Branch_USAF);


        mostitleId = db.insert(MOSTITLES, null, values);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "3C0X1");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Communication-Computer Systems");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/computer-systems-programming/");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "3C1X1");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Information Systems Technology");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "3C2X1");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Network Integration");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/network-intelligence-analyst-specialist/");
        db.insert(MOS, null, values1);


        values.put(MOSTITLES_TITLE, "3D - Cyberspace Support (activated on 1 November 2009, merging 2EXXX, 3AXXX, and 3CXXX)");
        values.put(MOSTITLES_BRANCH, Branch_USAF);


        mostitleId = db.insert(MOSTITLES, null, values);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "3D0X1");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Knowledge Operations Management");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/knowledge-operations-management/");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "3D0X2");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Cyber Systems Operations");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/cyber-systems-operations/");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "3D0X3");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Cyber Surety (IA which includes COMSEC, EMSEC, and COMPUSEC)");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/cyber-surety/");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "3D0X4");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Computer Systems Programming");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/computer-systems-programming/");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "3D1X1");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Client System");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/client-systems/");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "3D1X2");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Cyber Transport Systems");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/cyber-transport-systems/");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "3D1X3");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Cyber Transport Systems");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/cyber-transport-systems/");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "3D1X4");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Spectrum Operations");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/spectrum-operations/");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "3D1X5");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Ground Radar Systems (Switch to AFSC 1C8X1 in FY15)");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/ground-radar-systems/");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "3D1X6");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Airfield Systems (Switch to AFSC 1C8X2 in FY15)");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/airfield-systems/");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "3D1X7");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Cable and Antenna Systems (Cable Dawgs)");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/cable-and-antenna-systems/");
        db.insert(MOS, null, values1);

        values.put(MOSTITLES_TITLE, "3E - Civil Engineering");
        values.put(MOSTITLES_BRANCH, Branch_USAF);


        mostitleId = db.insert(MOSTITLES, null, values);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "3E0X1");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Electrical Systems");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/electrical-systems/");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "3E0X2");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Electrical Power Production");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/electrical-power-production/");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "3E1X1");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Heating, Ventilation, AC, and Refrigeration");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/heating-ventilation-air-conditioning-and-refrigeration/");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "3E2X1");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Pavements and Construction Equipment");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/pavements-and-construction-equipment/");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "3E3X1");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Structural");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/structural/");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "3E4X1");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Water and Fuel Systems Maintenance");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/utilities-system/");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "3E4X2");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Liquid Fuel Systems Maintenance");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/liquid-fuel-systems-maintenance/");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "3E4X3");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Pest Management");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/pest-management/");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "3E5X1");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Engineering");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/engineering-technician/");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "3E6X1");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Operations Management");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/operations-management/");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "3E7X1");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Fire Protection");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/fire-protection/");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "3E8X1");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Explosive Ordnance Disposal");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/explosive-ordnance-disposal-eod/");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "3E9X1");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Emergency Management similar to FEMA in the United States.");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/emergency-management/");
        db.insert(MOS, null, values1);

        values.put(MOSTITLES_TITLE, "3M - Services");
        values.put(MOSTITLES_BRANCH, Branch_USAF);


        mostitleId = db.insert(MOSTITLES, null, values);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "3M0X1");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Services");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/services-specialist/");
        db.insert(MOS, null, values1);

        values.put(MOSTITLES_TITLE, "3N - Public Affairs");
        values.put(MOSTITLES_BRANCH, Branch_USAF);


        mostitleId = db.insert(MOSTITLES, null, values);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "3N0X2");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Broadcast Journalist");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/broadcast-journalist/");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "3N0X5");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Photojournalist");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/photojournalist/");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "3N1X1");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Regional Band");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/regional-band/");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "3N2X1");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Premier Band");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/premier-band/");
        db.insert(MOS, null, values1);


        values.put(MOSTITLES_TITLE, "3P - Security Forces");
        values.put(MOSTITLES_BRANCH, Branch_USAF);


        mostitleId = db.insert(MOSTITLES, null, values);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "3P0X1");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Security Forces Specialist");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/security-forces-specialist/");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "3P0X1A");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Military Working Dog handler");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "3P0X1B");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Combat Arms Training and Maintenance");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values.put(MOSTITLES_TITLE, "3S - Mission Support");
        values.put(MOSTITLES_BRANCH, Branch_USAF);


        mostitleId = db.insert(MOSTITLES, null, values);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "3S0X1");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Personnel");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/personnel/");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "3S1X1");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Equal Opportunity");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/airforceenlistedjobs/a/afjob3s1x1.htm");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "3S2X1");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Education and Training");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/airforceenlistedjobs/a/afjob3s2x1.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "3S3X1");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Manpower");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/airforceenlistedjobs/a/afjob3u0x1.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "3V031");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Visual Information");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values.put(MOSTITLES_TITLE, "4 - Medical");
        values.put(MOSTITLES_BRANCH, Branch_USAF);


        mostitleId = db.insert(MOSTITLES, null, values);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "4A0X1");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Health Services Management");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/health-services-management/");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "4A1X1");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Medical Material");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/medical-material-specialist/");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "4A2X1");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Biomedical Equipment");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/biomedical-equipment/");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "4B0X1");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Bioenvironmental Engineering");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/bioenvironmental-engineer/");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "4C0X1");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Mental Health Service");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/mental-health-service-specialist/");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "4D0X1");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Diet Therapy");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/mental-health-service-specialist/");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "4E0X1");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Public Health");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/public-health-specialist/");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "4E0X1");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Public Health");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/public-health-specialist/");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "4H0X1");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Cardiopulmonary Laboratory");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/cardiopulmonary-laboratory/");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "4j0X1");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Physical Medicine");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/physical-medicine-specialist/");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "4j0X1A");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Orthotics");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/orthodontist/");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "4M0X1");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Aerospace and Operational Physiology");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/aerospace-physiology/");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "4N0X1");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Aerospace Medical Service ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/aerospace-medical-service/");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "4N0X1B");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Allergy and Immunizations Technician");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/allergist/");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "4N0X1C");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Independent Duty Medical Technician");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "4N0X1F");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Flight and Operational Medical Technian (New in 2014)");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "4N1X1");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Surgical Service");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/surgical-service-specialist/");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "4P0X1");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Pharmacy");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/pharmacy-specialist/");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "4R0X1");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Diagnostic Imaging");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/diagnostic-imaging/");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "4T0X1");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Medical Laboratory");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/medical-laboratory-specialist/");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "4V0X1");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Ophthalmic");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/ophthalmic-specialist/");
        db.insert(MOS, null, values1);


        values.put(MOSTITLES_TITLE, "5 - Professional");
        values.put(MOSTITLES_BRANCH, Branch_USAF);


        mostitleId = db.insert(MOSTITLES, null, values);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "5J0X1");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Paralegal");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/paralegal-specialist/");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "5R0X1");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Chaplain Assistant");

        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);


        values.put(MOSTITLES_TITLE, "6 - Acquisition");
        values.put(MOSTITLES_BRANCH, Branch_USAF);


        mostitleId = db.insert(MOSTITLES, null, values);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6C0X1");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Contracting");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/contracting/");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "6F0X1");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Financial Management & Comptroller");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/financial-management-comptroller/");
        db.insert(MOS, null, values1);

        values.put(MOSTITLES_TITLE, "7 - Special Investigation(OSI)");
        values.put(MOSTITLES_BRANCH, Branch_USAF);


        mostitleId = db.insert(MOSTITLES, null, values);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "7S0X1");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Special Investigations (OSI)");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/special-investigations-officer/");
        db.insert(MOS, null, values1);

        values.put(MOSTITLES_TITLE, "8 - Special Duty Identifiers");
        values.put(MOSTITLES_BRANCH, Branch_USAF);


        mostitleId = db.insert(MOSTITLES, null, values);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "8A100");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Career Assistance Advisor");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "8A200");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Enlisted Aide");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "8B000");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Military Training Instructor");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "8B100");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " Military Training Leader");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "8B200");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Academic Military Training NCO");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "8C000");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Airman & Family Readiness Center RNCO");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://www.airforce.com/careers/detail/special-investigations-officer/");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "8D000");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Linguist Debriefer");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "8F000");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "First Sergeant");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "8G000");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Honor Guard");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "8H000");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Airman Dorm Leader");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "8M000");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Postal service (will be absorbed by 3A1X1 in 2014)");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "8P000");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Defense Courier");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "8P100");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Defense Attaché");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "8R000");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " Enlisted Accessions Recruiter");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "8R200");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Second-Tier Recruiter");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "8R300");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Third-Tier Recruiter");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "8S000");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Missile Facility Manager");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "8T000");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Professional Military Education Instruction");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);


        values.put(MOSTITLES_TITLE, "9 - Reporting Identifiers");
        values.put(MOSTITLES_BRANCH, Branch_USAF);


        mostitleId = db.insert(MOSTITLES, null, values);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "9A000");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Awaiting Retraining-Reasons Beyond Control");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afjobs/bl9a000.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "9A100");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Airman Awaiting Retraining - Disqualification for Reasons Within Control");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afjobs/bla100.htm");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "9A200");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Awaiting Discharge, Separation, Retirement for Reasons Within Their Control");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afjobs/bl9a000.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "9A300");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Awaiting Discharge, Separation, Retirement for Reasons Beyond Their Control");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afjobs/bla100.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "9C000");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Chief Master Sergeant of the Air Force");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afjobs/bl9c000.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "9D000");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Dormitory Manager");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afjobs/bl9d000.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "9E000");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Command Chief Master Sergeant");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afjobs/bl9e000.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "9F000");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "First Term Airmen Center ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afjobs/bl9e000.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "9G100");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Group Superintendent");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "9J000");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Prisoner");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afjobs/bl9j000.htm");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "9L000");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Interpreter/Translator ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afjobs/bl9l000.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "9P000");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Patient");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afjobs/bl9p000.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "9R000");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Civil Air Patrol (CAP)-USAF Reserve Assistant NCOs");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afjobs/bl9R000.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "9S100");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Technical Applications Specialist");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/airforceenlistedjobs/a/afjob9s100.htm");
        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "9T000");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Basic Enlisted Airman");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afjobs/bl9t000.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "9T100");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Officer Trainee");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afjobs/bl9t100.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "9T200");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Precadet Assignee");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afjobs/bl9t200.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "9W000");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Wounded Warrior");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);


        values.put(MOSTITLES_TITLE, "10 -Operations");
        values.put(MOSTITLES_BRANCH, Branch_USAF);


        mostitleId = db.insert(MOSTITLES, null, values);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "10C0");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Operations Commander");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values.put(MOSTITLES_TITLE, "11 -Pilot Field");
        values.put(MOSTITLES_BRANCH, Branch_USAF);


        mostitleId = db.insert(MOSTITLES, null, values);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "11Ax");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Airlift pilot");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl11ax.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "11Bx");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Bomber pilot");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl11bx.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "11Ex");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Experimental Test Pilot");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl11ex.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "11Fx");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Fighter Pilot");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl11ex.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "11Gx");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Generalist Pilot");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl11ex.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "11Hx");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Helicopter Pilot");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl11hx.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "11Kx");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Trainer Pilot");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl11kx.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "11Mx");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Mobility Pilot");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "11Rx");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "RECONNAISSANCE/SURVEILLANCE/ELECTRONIC WARFARE PILOT");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl11rx.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "11Sx");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Special Operations Pilot");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl11sx.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "11Tx");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Tanker Pilot");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl11tx.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "11Ux");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Remotely Operated Aircraft Pilot");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values.put(MOSTITLES_TITLE, "12 -Navigator Field");
        values.put(MOSTITLES_BRANCH, Branch_USAF);


        mostitleId = db.insert(MOSTITLES, null, values);







        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "12Ax");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Airlift Navigator");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl12ax.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "12Bx");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Bomber Combat Systems Operator");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl12bx.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "12Ex");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Experimental Test Combat Systems Officer");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl12ex.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "12Fx");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Fighter Combat Systems Officer");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl12fx.htm");
        db.insert(MOS, null, values1);




        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "12Gx");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Generalist Combat Systems Officer");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl12gx.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "12Kx");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Trainer Combat Systems Officer");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl12kx.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "12Mx");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Mobility Combat Systems Officer");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "12Rx");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Reconnaissance/Surveillance/Electronic Warfare Combat Systems Officer");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl12rx.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "12Sx");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Special Operations Combat Systems Officer");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl12sx.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "12Ux");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Remotely Operated Aircraft Pilot");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values.put(MOSTITLES_TITLE, "13 - Space,Missle, and Command and Control Field");
        values.put(MOSTITLES_BRANCH, Branch_USAF);


        mostitleId = db.insert(MOSTITLES, null, values);







        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "13Ax");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Astronaut");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl13ax.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "13Bx");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Air Battle Manager");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl13bx.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "13Cx");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Special Tactics Officer");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://en.wikipedia.org/wiki/Special_Tactics_Officer");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "13Dx");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Control and Recovery");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl13dx.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "13Lx");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Air Liaison Officer");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "13Mx");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Airfield Operation");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl13mx.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "13Nx");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Nuclear and Missile Operations");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "13Sx");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Space and Missile");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl13sx.htm");
        db.insert(MOS, null, values1);

        values.put(MOSTITLES_TITLE, "14 - Intelligence Field");
        values.put(MOSTITLES_BRANCH, Branch_USAF);


        mostitleId = db.insert(MOSTITLES, null, values);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "14Nx");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Intelligence");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl14nx.htm");
        db.insert(MOS, null, values1);

        values.put(MOSTITLES_TITLE, "15 - Weather Field");
        values.put(MOSTITLES_BRANCH, Branch_USAF);


        mostitleId = db.insert(MOSTITLES, null, values);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "15Wx");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Weather");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl15wx.htm");
        db.insert(MOS, null, values1);

        values.put(MOSTITLES_TITLE, "16 - Operations Support Field");
        values.put(MOSTITLES_BRANCH, Branch_USAF);


        mostitleId = db.insert(MOSTITLES, null, values);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "16Fx");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Foreign Area");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl16fx.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "16Gx");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Air Force Operations Staff Officer");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl16gx.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "16Px");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "International Politico-military affairs");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl16px.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "16Rx");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Planning and Programming");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl16rx.htm");
        db.insert(MOS, null, values1);

        values.put(MOSTITLES_TITLE, "17 - Cyber Operations Field");
        values.put(MOSTITLES_BRANCH, Branch_USAF);


        mostitleId = db.insert(MOSTITLES, null, values);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "17C0");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Cyber Operations Commander");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "17Dx");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Cyberspace Operations");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values.put(MOSTITLES_TITLE, "18 - Remotely Piloted Operation Field");
        values.put(MOSTITLES_BRANCH, Branch_USAF);


        mostitleId = db.insert(MOSTITLES, null, values);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "18AX");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " Attack Remotely Piloted Aircraft Pilot (18X established in October 2009");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);




        values.put(MOSTITLES_TITLE, "21 - Logistics Field");
        values.put(MOSTITLES_BRANCH, Branch_USAF);


        mostitleId = db.insert(MOSTITLES, null, values);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "20CX");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Logistics Commander");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl21ax.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "21Ax");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Aircraft Maintenance");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl21ax.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "21Bx");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Maintenance");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl21bx.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "21Mx");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Muntitions and Missile Maintenance");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl21mx.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "21Rx");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Logistics Readiness");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl21rx.htm");
        db.insert(MOS, null, values1);


        values.put(MOSTITLES_TITLE, "30 - Support Field");
        values.put(MOSTITLES_BRANCH, Branch_USAF);


        mostitleId = db.insert(MOSTITLES, null, values);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "30Cx");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Support Commander");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values.put(MOSTITLES_TITLE, "31 - Security Forces Field");
        values.put(MOSTITLES_BRANCH, Branch_USAF);


        mostitleId = db.insert(MOSTITLES, null, values);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "31Px");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Security Forces");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl31px.htm");
        db.insert(MOS, null, values1);

        values.put(MOSTITLES_TITLE, "32 - Civil Engineer Field");
        values.put(MOSTITLES_BRANCH, Branch_USAF);


        mostitleId = db.insert(MOSTITLES, null, values);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "32Ex");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Civil Engineer");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl32ex.htm");
        db.insert(MOS, null, values1);


        values.put(MOSTITLES_TITLE, "33 - Communication and Information Field");
        values.put(MOSTITLES_BRANCH, Branch_USAF);


        mostitleId = db.insert(MOSTITLES, null, values);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "33Sx");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Communication and Information");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl33sx.htm");
        db.insert(MOS, null, values1);

        values.put(MOSTITLES_TITLE, "35 - Public Affairs Field");
        values.put(MOSTITLES_BRANCH, Branch_USAF);


        mostitleId = db.insert(MOSTITLES, null, values);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "35Bx");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Band 2");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl35bx.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "35Px");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Public Affairs");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl35px.htm");
        db.insert(MOS, null, values1);

        values.put(MOSTITLES_TITLE, "36 - Mission Support Field");
        values.put(MOSTITLES_BRANCH, Branch_USAF);


        mostitleId = db.insert(MOSTITLES, null, values);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "36Mx");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Mission Support");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl36mx.htm");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "36Px");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Personnel");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl36px.htm");
        db.insert(MOS, null, values1);

        values.put(MOSTITLES_TITLE, "38 - Manpower Field");
        values.put(MOSTITLES_BRANCH, Branch_USAF);


        mostitleId = db.insert(MOSTITLES, null, values);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "38Mx");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Manpower");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl38mx.htm");
        db.insert(MOS, null, values1);

        values.put(MOSTITLES_TITLE, "40 - Medical Commander Field");
        values.put(MOSTITLES_BRANCH, Branch_USAF);


        mostitleId = db.insert(MOSTITLES, null, values);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "40Cx");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Medical Commander");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values.put(MOSTITLES_TITLE, "41 - Health Services Field");
        values.put(MOSTITLES_BRANCH, Branch_USAF);


        mostitleId = db.insert(MOSTITLES, null, values);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "41Ax");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Health Services Administrator");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl41ax.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values.put(MOSTITLES_TITLE, "42 - BIOMEDICAL CLINICIAN FIELD");
        values.put(MOSTITLES_BRANCH, Branch_USAF);


        mostitleId = db.insert(MOSTITLES, null, values);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "42Bx");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Physical Therapist");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl42.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "42Ex");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Optometrist");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl42ex.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "42Fx");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Podiatrist");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl42fx.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "42Gx");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Physician Assistant");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl42gx.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "42Nx");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Audiology/Speech Pathologist");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl42nx.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "42Px");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Clinical Psychologist");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl42px.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "42Sx");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Clinical Social Worker");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl42sx.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "42Tx");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Occupational Therapist");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl42tx.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values.put(MOSTITLES_TITLE, "43 - BIOMEDICAL SPECIALISTS FIELD");
        values.put(MOSTITLES_BRANCH, Branch_USAF);


        mostitleId = db.insert(MOSTITLES, null, values);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "43Ax");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Aerospace and Operational Physiologist");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl43ax.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "43Bx");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Biomedical Scientist");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl43bx.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "43Dx");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Dietitian");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl43dx.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "43Ex");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Bioenvironmental Engineer");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl43ex.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "43Hx");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Public Health");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl43hx.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "43Mx");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Medical Entomologist");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl43mx.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "43Px");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Pharmacist");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl43px.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "43Tx");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Biomedical Laboratory");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl43tx.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "43Vx");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Veterinary Clinician");

        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "43Yx");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Health Physicist");

        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);



        values.put(MOSTITLES_TITLE, "44 - Physician Field");
        values.put(MOSTITLES_BRANCH, Branch_USAF);


        mostitleId = db.insert(MOSTITLES, null, values);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "44Ax");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Chief, Hospital/Clinic Services");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl44ax.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "44Bx");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Preventive Medicine");

        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "44Dx");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Pathologist");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl44dx.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "44Ex");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Emergency Services Physician");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl44ex.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "44Fx");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Family Physician");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl44fx.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "44Gx");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "General Practice Physician");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl44gx.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "44Hx");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Nuclear Medicine Physician");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl44hx.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "44Jx");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Clinical Geneticist");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl44jx.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "44Kx");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Pediatrician");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl44kx.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "44Mx");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Internist");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl44mx.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "44Nx");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Neurologist");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl44nx.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "44Px");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Psychiatrist");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl44px.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "44Rx");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Diagnostic Radiologist");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl44rx.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "44Sx");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Dermatologist");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl44sx.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "44Tx");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Radiotherapist");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl44tx.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "44Ux");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Occupational Medicine");

        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "44Yx");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Critical Care Medicine");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl44yx.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "44Zx");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Allergist");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl44zx.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values.put(MOSTITLES_TITLE, "45 - Surgery Field");
        values.put(MOSTITLES_BRANCH, Branch_USAF);


        mostitleId = db.insert(MOSTITLES, null, values);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "45Ax");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Anesthesiologist");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl45ax.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "45Bx");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Orthopedic Surgeon");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl45bx.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "45Ex");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Ophthalmologist");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl45ex.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "45Gx");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "OB/GYN");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl45gx.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "45Nx");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Otorhinolaryngologist");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl45nx.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "45Px");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Physical Medicine Physician");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl45px.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "45Sx");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Surgeon");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl45sx.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "45Ux");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Urologist");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl45ux.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);


        values.put(MOSTITLES_TITLE, "46 - Nurse Field");
        values.put(MOSTITLES_BRANCH, Branch_USAF);


        mostitleId = db.insert(MOSTITLES, null, values);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "46Ax");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Nurse Administrator");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl46ax.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "46Fx");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Flight Nurse");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl46fx.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "46Gx");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Nurse-Midwife");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl46gx.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "46Mx");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Nurse Anesthetist");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl46mx.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "46Nx");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Clinical Nurse");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl46nx.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "46Px");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Mental Health Nurse");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl46px.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "46Sx");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Operating Room Nurse");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl46sx.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "46Yx");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Privileged Advanced Practice Nurse");

        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values.put(MOSTITLES_TITLE, "47 - Dental Field");
        values.put(MOSTITLES_BRANCH, Branch_USAF);


        mostitleId = db.insert(MOSTITLES, null, values);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "47BX");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Orthodontist");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl47bx.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "47DX");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Oral and Maxillofacial Pathologist");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl47dx.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "47EX");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Endodontist");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl47ex.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "47GX");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Dentist");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl47gx.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "47HX");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Periodontist");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl47hx.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "47KX");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Pediatric Dentist");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl47kx.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "47PX");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Prosthodontist");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl47px.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "47SX");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Oral and Maxillofacial Surgeon");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl47sx.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values.put(MOSTITLES_TITLE, "48 - Aerospace Medicine Field");
        values.put(MOSTITLES_BRANCH, Branch_USAF);


        mostitleId = db.insert(MOSTITLES, null, values);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "48AX");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Aerospace Medicine Specialist ");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl48ax.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "48EX");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "OCCUPATIONAL MEDICINE SPECIALIST");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl48ex.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "48FX");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "FAMILY PRACTICE SPECIALIST");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl48fx.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "48GX");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "General Medical Officer Flight Surgeon");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl48gx.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "48RX");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Residency Trained Flight Surgeon");

        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "48VX");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Pilot-Physician");

        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);


        values.put(MOSTITLES_TITLE, "51 - Law Field");
        values.put(MOSTITLES_BRANCH, Branch_USAF);


        mostitleId = db.insert(MOSTITLES, null, values);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "51JX");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Judge Advocate");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl51jx.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);


        values.put(MOSTITLES_TITLE, "52 - Chaplain Field");
        values.put(MOSTITLES_BRANCH, Branch_USAF);


        mostitleId = db.insert(MOSTITLES, null, values);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "52RX");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Chaplain");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl52rx.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values.put(MOSTITLES_TITLE, "60 - Program Director Field");
        values.put(MOSTITLES_BRANCH, Branch_USAF);


        mostitleId = db.insert(MOSTITLES, null, values);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "60CX");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Program Director");

        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);


        values.put(MOSTITLES_TITLE, "61 - Scientific/Research Field");
        values.put(MOSTITLES_BRANCH, Branch_USAF);


        mostitleId = db.insert(MOSTITLES, null, values);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "61AX");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Operations Research Analyst");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "61BX");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Behaviorial Science/Human Scientist");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "61CX");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Chemist");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "61DX");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Physicist/Nuclear Engineer");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "61SX");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Scientist");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl61sx.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values.put(MOSTITLES_TITLE, "62 - Developmental Engineering Field");
        values.put(MOSTITLES_BRANCH, Branch_USAF);


        mostitleId = db.insert(MOSTITLES, null, values);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "62EX");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Developmental Engineer");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl62ex.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "62SX");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Materiel Leader");

        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);


        values.put(MOSTITLES_TITLE, "63 - Acquisition Field");
        values.put(MOSTITLES_BRANCH, Branch_USAF);


        mostitleId = db.insert(MOSTITLES, null, values);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "63AX");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Acquisition Manager");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl63ax.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "63GX");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Senior Materiel Leader");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "63SX");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Materiel Leader");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);


        values.put(MOSTITLES_TITLE, "64 - Contracting Field");
        values.put(MOSTITLES_BRANCH, Branch_USAF);


        mostitleId = db.insert(MOSTITLES, null, values);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "64PX");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Contracting");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl64px.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);


        values.put(MOSTITLES_TITLE, "65 - Finance Field");
        values.put(MOSTITLES_BRANCH, Branch_USAF);


        mostitleId = db.insert(MOSTITLES, null, values);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "65AX");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Audit");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl65ax.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "65FX");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Financial Management");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl65fx.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "65WX");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Cost Analysis");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl65wx.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);


        values.put(MOSTITLES_TITLE, "71 - Special Investigation Field");
        values.put(MOSTITLES_BRANCH, Branch_USAF);


        mostitleId = db.insert(MOSTITLES, null, values);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "71SX");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Special Investigations");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl71sx.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);


        values.put(MOSTITLES_TITLE, "8XX - Special Duty Assigments Field");
        values.put(MOSTITLES_BRANCH, Branch_USAF);


        mostitleId = db.insert(MOSTITLES, null, values);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "80CX");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Commander, Cadet Squadron, USAFA");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl80c0.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "81CX");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Training Commander, OTS");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl81c0.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "81TX");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Instructor");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl81t0.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "82AX");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Academic Program Manager");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl82a0.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "83RX");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Recruiting Service");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl83r0.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "85GX");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "U.S. Air Force Honor Guard");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl85g0.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "86MX");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Operations Management");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl86m0.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "86PX");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Command and Control");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl86p0.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "87GX");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Installation Inspector General");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl87g0.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "82AX");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Aide-de-camp");
        values1.put(MOS_Link, "http://usmilitary.about.com/library/milinfo/afoffjobs/bl88a0.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");

        db.insert(MOS, null, values1);

        values.put(MOSTITLES_TITLE, "9XX - Reporting Identifiers Field");
        values.put(MOSTITLES_BRANCH, Branch_USAF);


        mostitleId = db.insert(MOSTITLES, null, values);










    }

    public void populatearmymos(SQLiteDatabase db) {

        ContentValues values = new ContentValues();


        values.put(MOSTITLES_TITLE, "Native Language Speaker");
        values.put(MOSTITLES_BRANCH, Branch_USARMY);


        long mostitleId = db.insert(MOSTITLES, null, values);


        ContentValues values1 = new ContentValues();

        values1.put(MOS_NUMBER, "09L");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " INTERPRETER/TRANSLATER");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /09L ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);


        values.put(MOSTITLES_TITLE, "INFANTRY BRANCH");
        values.put(MOSTITLES_BRANCH, Branch_USARMY);
        mostitleId = db.insert(MOSTITLES, null, values);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "11B");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " INFANTRYMAN");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /11B ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "11C");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " INDIRECT FIRE INFANTRYMAN");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /11C ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "11X");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " INFANTRY ENLISTMENT OPTION");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /11X ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "11Z");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " INFANTRY SENIOR SERGEANT");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /11Z ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "12A");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " ENGINEER SENIOR SERGEANT");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a / ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "12B");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " COMBAT ENGINEER");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /12B ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "12C");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " BRIDGE CREWMEMBER");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /12C ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "12D");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " DIVER");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /12D ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "12G");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " QUARRYING SPECIALIST (RC)");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /12G ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "12H");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " CONSTRUCTION ENGINEERING SUPERVISOR");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /12H ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "12K");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " PLUMBER");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /12K ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "12M");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " FIREFIGHTER");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /12M ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "12N");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " HORIZONTAL CONSTRUCTION ENGINEER");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /12N ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "12P");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " PRIME POWER PRODUCTION SPECIALIST");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /12P ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "12Q");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " POWER LINE DISTRIBUTION SPECIALIST (RC)");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /12Q ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "12R");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " INTERIOR ELECTRICIAN");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /12R ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "12T");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " TECHNICAL ENGINEER");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /12T ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "12V");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " CONCRETE AND ASPHALT EQUIPMENT OPERATOR");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /12V ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "12W");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " CARPENTRY AND MASONRY SPECIALIST");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /12W ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "12X");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " GENERAL ENGINEERING SUPERVISOR");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /12X ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "12Y");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " GEOSPATIAL ENGINEER");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /12Y ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();

        values1.put(MOS_NUMBER, "12Z");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " COMBAT ENGINEERING SENIOR SERGEANT");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /12Z ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1.put(MOS_NUMBER, "12Z");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " COMBAT ENGINEERING SENIOR SERGEANT");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /12Z ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);




        values.put(MOSTITLES_TITLE, "FIELD ARTILLERY");
        values.put(MOSTITLES_BRANCH, Branch_USARMY);
        mostitleId = db.insert(MOSTITLES, null, values);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "13B");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " CANNON CREWMEMBER");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /13B ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "13D");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " FIELD ARTILLERY AUTOMATED TACTICAL DATA SYSTEM SPECIALIST");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /13D ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "13F");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " FIRE SUPPORT SPECIALIST");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /13F ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "13M");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " MULTIPLE LAUNCH ROCKET SYSTEM (MLRS)/HIGH MOBILITY ARTILLERY ROCKET SYST EM (HIMARS) CREWMEMBER");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /13M ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "13P");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " MULTIPLE LAUNCH ROCKET SYSTEM (MLRS) OPERATIONAL FIRE DIRECTION SPECIALIST");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /13P ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "13R");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " FIELD ARTILLERY FIREFINDER RADAR OPERATOR");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /13R ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "13T");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " FIELD ARTILLERY SURVEYOR/METEOROLOGICAL CREWMEMBER");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /13T ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "13Z");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " FIELD ARTILLERY SENIOR SERGEANT");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /13Z ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values.put(MOSTITLES_TITLE, "AIR DEFENSE ARTILLERY");
        values.put(MOSTITLES_BRANCH, Branch_USARMY);
        mostitleId = db.insert(MOSTITLES, null, values);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "14E");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " PATRIOT FIRE CONTROL ENHANCED OPERATOR/MAINTAINER");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /14E ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "14G");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " AIR DEFENSE BATTLE MANAGEMENT SYSTEM OPERATOR");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /14G ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "14H");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " AIR DEFENSE ENHANCED EARLY WARNING OPERATOR");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /14H ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "14J");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " AIR DEFENSE C41 TACTICAL OPERATIONS CENTER ENHANCED OPERATOR MAINTAINER");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /14J ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "14S");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " AIR AND MISSILE DEFENSE (AMD) CREWMEMBER");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /14S ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "14T");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " PATRIOT LAUNCHING STATION ENHANCED OPERATOR/MAINTAINER");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /14T ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "14Z");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " AIR DEFENSE ARTILLERY SENIOR SERGEANT");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /14Z ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values.put(MOSTITLES_TITLE, "AVIATION");
        values.put(MOSTITLES_BRANCH, Branch_USARMY);
        mostitleId = db.insert(MOSTITLES, null, values);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "15B");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " AIRCRAFT POWERPLANT REPAIRER");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /15B ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "15D");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " AIRCRAFT POWERTRAIN REPAIRER");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /15D ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "15E");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " UNMANNED AIRCRAFT SYSTEMS REPAIRER");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /15E ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "15F");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " AIRCRAFT ELECTRICIAN");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /15F ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "15G");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " AIRCRAFT STRUCTURAL REPAIRER");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /15G ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "15H");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " AIRCRAFT PNEUDRAULICS REPAIRER");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /15H ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "15J");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " OH-58D ARMAMENT/ELECTRICAL/AVIONICS SYSTEMS REPAIRER");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /15J ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "15K");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " AIRCRAFT COMPONENTS REPAIR SUPERVISOR");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /15K ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "15M");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " UH-1 HELICOPTER REPAIRER (RC) (del 1310 / 1210 - 30)");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /15M ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "15N");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " AVIONIC MECHANIC");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /15N ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "15P");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " AVIATION OPERATIONS SPECIALIST");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /15P ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "15Q");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " AIR TRAFFIC CONTROL OPERATOR");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /15Q ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "15R");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " AH-64 ATTACK HELICOPTER REPAIRER");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /15R ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "15S");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " OH-58D HELICOPTER REPAIRER");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /15S ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "15T");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " UH-60 HELICOPTER REPAIRER");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /15T ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "15U");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " CH-47 HELICOPTER REPAIRER");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a / ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "15V");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " OBSERVATION/SCOUT HELICOPTER REPAIRER (RC)");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /15V ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "15W");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " UNMANNED AERIAL VEHICLE OPERATOR");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /15W ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "15X");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " AH-64A ARMAMENT/ELECTRICAL/AVIONICS SYSTEMS REPAIRER");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /15X ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "15Y");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " AH-64D ARMAMENT/ELECTRICAL/AVIONIC SYSTEMS REPAIRER");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /15Y ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "15Z");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " AIRCRAFT MAINTENANCE SENIOR SERGEANT");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /15Z ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values.put(MOSTITLES_TITLE, "SPECIAL FORCES");
        values.put(MOSTITLES_BRANCH, Branch_USARMY);
        mostitleId = db.insert(MOSTITLES, null, values);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "18B");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " SPECIAL FORCES WEAPONS SERGEANT");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /18B ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "18C");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " SPECIAL FORCES ENGINEER SERGEANT");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /18C ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "18D");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " SPECIAL FORCES MEDICAL SERGEANT");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /18D ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "18E");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " SPECIAL FORCES COMMUNICATIONS SERGEANT");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /18E ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "18F");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " SPECIAL FORCES ASSISTANT OPERATIONS AND INTELLIGENCE SERGEANT");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /18F ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "18X");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " SPECIAL FORCES ENLISTMENT OPTION");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /18X ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "18Z");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " SPECIAL FORCES SENIOR SERGEANT");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /18Z ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values.put(MOSTITLES_TITLE, "ARMOR");
        values.put(MOSTITLES_BRANCH, Branch_USARMY);
        mostitleId = db.insert(MOSTITLES, null, values);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "19D");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " CAVALRY SCOUT");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /19D ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "19K");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " M1 ARMOR CREWMAN");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /19K ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "19Z");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " ARMOR SENIOR SERGEANT");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /19Z ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values.put(MOSTITLES_TITLE, "SIGNAL CORPS");
        values.put(MOSTITLES_BRANCH, Branch_USARMY);
        mostitleId = db.insert(MOSTITLES, null, values);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "25B");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " INFORMATION TECHNOLOGY SPECIALIST");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /25B ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "25C");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " RADIO OPERATOR-MAINTAINER");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /25C ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "25E");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " ELECTROMAGNETIC SPECTRUM MANAGER");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /25E ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "25F");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " NETWORK SWITCHING SYSTEMS OPERATOR-MAINTAINER (del 1310 / 1110 - 21)");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /25F ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "25L");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " CABLE SYSTEMS INSTALLER-MAINTAINER");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /25L ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "25M");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " MULTIMEDIA ILLUSTRATOR");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /25M ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "25N");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " NODAL NETWORK SYSTEMS OPERATOR-MAINTAINER");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /25N ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "25P");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " MICROWAVE SYSTEMS OPERATOR-MAINTAINER");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /25P ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "25Q");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " MULTICHANNEL TRANSMISSION SYSTEMS OPERATOR-MAINTAINER");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /25Q ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "25R");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " VISUAL INFORMATION EQUIPMENT OPERATOR-MAINTAINER");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /25R ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "25S");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " SATELLITE COMMUNICATION SYSTEMS OPERATOR-MAINTAINER");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /25S ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "25T");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " SATELLITE/MICROWAVE SYSTEMS CHIEF");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /25T ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "25U");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " SIGNAL SUPPORT SYSTEMS SPECIALIST");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /25U ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "25V");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " COMBAT DOCUMENTATION/PRODUCTION SPECIALIST");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /25V ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "25W");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " TELECOMMUNICATIONS OPERATIONS CHIEF");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /25W ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "25X");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " CHIEF SIGNAL NCO");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /25X ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "25Z");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " VISUAL INFORMATION OPERATIONS CHIEF");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /25Z ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values.put(MOSTITLES_TITLE, "JUDGE ADVOCATE GENERAL'S CORPS");
        values.put(MOSTITLES_BRANCH, Branch_USARMY);
        mostitleId = db.insert(MOSTITLES, null, values);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "27D");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " PARALEGAL SPECIALIST");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /27D ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values.put(MOSTITLES_TITLE, "ELECTRONIC WARFARE");
        values.put(MOSTITLES_BRANCH, Branch_USARMY);
        mostitleId = db.insert(MOSTITLES, null, values);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "29E");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " ELECTRONIC WARFARE SPECIALIST");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /29E ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values.put(MOSTITLES_TITLE, "MILITARY POLICE");
        values.put(MOSTITLES_BRANCH, Branch_USARMY);
        mostitleId = db.insert(MOSTITLES, null, values);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "31B");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " MILITARY POLICE");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /31B ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "31D");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " CID SPECIAL AGENT");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /31D ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "31E");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " INTERNMENT/RESETTLEMENT SPECIALIST");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /31E ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "31K");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " WORKING DOG HANDLER");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a / ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values.put(MOSTITLES_TITLE, "MILITARY INTELLIGENCE");
        values.put(MOSTITLES_BRANCH, Branch_USARMY);
        mostitleId = db.insert(MOSTITLES, null, values);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "35F");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " INTELLIGENCE ANALYST");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /35F ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "35G");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " GEOSPATIAL INTELLIGENCE IMAGERY ANALYST");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /35G ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "35L");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " COUNTER INTELLIGENCE AGENT");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /35L ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "35M");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " HUMAN INTELLIGENCE COLLECTOR");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /35M ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "35N");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " SIGNALS INTELLIGENCE ANALYST");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /35N ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "35P");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " CRYPTOLOGIC LINGUIST");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /35P ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "35Q");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " CRYPTOLOGIC NETWORK WARFARE SPECIALIST");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /35Q ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "35S");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " SIGNALS COLLECTOR/ANALYST");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /35S ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "35T");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " MILITARY INTELLIGENCE SYSTEMS MAINTAINER/INTEGRATOR");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /35T ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "35V");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " SIGNALS INTELLIGENCE (SIGINT) SENIOR SERGEANT/SIGINT CHIEF (add 1404 / 1210 - 05)");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a / ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "35X");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " INTELLIGENCE SENIOR SERGEANT/CHIEF INTELLIGENCE SERGEANT");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /35X ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "35Y");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " CHIEF COUNTER INTELLIGENCE/HUMAN INTELLIGENCE SERGEANT");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /35Y ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "35Z");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " SIGNALS INTELLIGENCE (SIGINT) SENIOR SERGEANT/SIGINT CHIEF (del 1410 / 1210 - 05)");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /35Z ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values.put(MOSTITLES_TITLE, "FINANCIAL MANAGEMENT");
        values.put(MOSTITLES_BRANCH, Branch_USARMY);
        mostitleId = db.insert(MOSTITLES, null, values);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "36B");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " FINANCIAL MANAGEMENT TECHNICIAN");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /36B ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values.put(MOSTITLES_TITLE, "PSYCHOLOGICAL OPERATIONS");
        values.put(MOSTITLES_BRANCH, Branch_USARMY);
        mostitleId = db.insert(MOSTITLES, null, values);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "37F");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " PSYCHOLOGICAL OPERATIONS SPECIALIST");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /37F ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values.put(MOSTITLES_TITLE, "CIVIL AFFAIRS");
        values.put(MOSTITLES_BRANCH, Branch_USARMY);
        mostitleId = db.insert(MOSTITLES, null, values);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "38B");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " CIVIL AFFAIRS SPECIALIST");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /38B ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values.put(MOSTITLES_TITLE, "ADJUTANT GENERAL'S CORPS");
        values.put(MOSTITLES_BRANCH, Branch_USARMY);
        mostitleId = db.insert(MOSTITLES, null, values);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "42A");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " HUMAN RESOURCES SPECIALIST");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /42A ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "42R");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " MUSICIAN");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /42R ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "42S");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " SPECIAL BAND MUSICIAN");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /42S ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values.put(MOSTITLES_TITLE, "PUBLIC AFFAIRS");
        values.put(MOSTITLES_BRANCH, Branch_USARMY);
        mostitleId = db.insert(MOSTITLES, null, values);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "46Q");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " PUBLIC AFFAIRS SPECIALIST");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /46Q ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "46R");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " PUBLIC AFFAIRS BROADCAST SPECIALIST");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /46R ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "46Z");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " CHIEF PUBLIC AFFAIRS NCO");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /46Z ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values.put(MOSTITLES_TITLE, "ARMY ACQUISITION CORPS");
        values.put(MOSTITLES_BRANCH, Branch_USARMY);
        mostitleId = db.insert(MOSTITLES, null, values);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "51C");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " ACQUISITION, LOGISTICS & TECHNOLOGY (AL&T) CONTRACTING NCO");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a / ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values.put(MOSTITLES_TITLE, "CHAPLAIN");
        values.put(MOSTITLES_BRANCH, Branch_USARMY);
        mostitleId = db.insert(MOSTITLES, null, values);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "56M");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " CHAPLAIN ASSISTANT");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /56M ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values.put(MOSTITLES_TITLE, "MEDICAL CMF");
        values.put(MOSTITLES_BRANCH, Branch_USARMY);
        mostitleId = db.insert(MOSTITLES, null, values);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "68A");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " BIOMEDICAL EQUIPMENT SPECIALIST");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /68A ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "68B");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " ORTHOPEDIC SPECIALIST (add 1304 / 1110 - 04)");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a / ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "68C");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " PRACTICAL NURSING SPECIALIST (add 1304 / 1110 - 04)");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a / ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "68D");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " OPERATING ROOM SPECIALIST");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /68D ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "68E");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " DENTAL SPECIALIST");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /68E ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "68F");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " PHYSICAL THERAPY SPECIALIST (add 1304 / 1110 - 04)");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a / ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "68G");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " PATIENT ADMINISTRATION SPECIALIST");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /68G ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "68H");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " OPTICAL LABORATORY SPECIALIST");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /68H ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "68J");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " MEDICAL LOGISTICS SPECIALIST");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /68J ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "68K");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " MEDICAL LABORATORY SPECIALIST");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /68K ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "68L");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " OCCUPATIONAL THERAPY SPECIALIST (add 1304 / 1110 - 04)");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a / ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "68M");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " NUTRITION CARE SPECIALIST");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /68M ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "68N");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " CARDIOVASCULAR SPECIALIST (add 1304 / 1110 - 04)");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a / ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "68P");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " RADIOLOGY SPECIALIST");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /68P ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "68Q");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " PHARMACY SPECIALIST");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /68Q ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "68R");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " VETERINARY FOOD INSPECTION SPECIALIST");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /68R ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "68S");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " PREVENTIVE MEDICINE SPECIALIST");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /68S ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "68T");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " ANIMAL CARE SPECIALIST");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /68T ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "68U");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " EAR, NOSE AND THROAT (ENT) SPECIALIST (add 1304 / 1110 - 04)");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a / ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "68V");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " RESPIRATORY SPECIALIST");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /68V ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "68W");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " HEALTH CARE SPECIALIST");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /68W ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "68X");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " BEHAVIORAL HEALTH SPECIALIST");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /68X ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "68Y");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " EYE SPECIALIST (add 1304 / 1110 - 04)");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a / ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "68Z");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " CHIEF MEDICAL NCO");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /68Z ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values.put(MOSTITLES_TITLE, "CHEMICAL");
        values.put(MOSTITLES_BRANCH, Branch_USARMY);
        mostitleId = db.insert(MOSTITLES, null, values);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "74D");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " CHEMICAL, BIOLOGICAL, RADIOLOGICAL AND NUCLEAR (CBRN) SPECIALIST");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /74D ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values.put(MOSTITLES_TITLE, "RECRUITING AND RETENTION");
        values.put(MOSTITLES_BRANCH, Branch_USARMY);
        mostitleId = db.insert(MOSTITLES, null, values);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "79R");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " RECRUITER");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /79R ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "79S");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " CAREER COUNSELOR");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /79S ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "79T");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " RECRUITING AND RETENTION NCO (ARMY NATIONAL GUARD OF THE UNITED STATES)");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /79T ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "79V");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " RETENTION AND TRANSITION NCO, USAR");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /79V ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values.put(MOSTITLES_TITLE, "TRANSPORTATION");
        values.put(MOSTITLES_BRANCH, Branch_USARMY);
        mostitleId = db.insert(MOSTITLES, null, values);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "88H");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " CARGO SPECIALIST");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /88H ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "88K");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " WATERCRAFT OPERATOR");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /88K ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "88L");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " WATERCRAFT ENGINEER");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /88L ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "88M");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " MOTOR TRANSPORT OPERATOR");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /88M ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "88N");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " TRANSPORTATION MANAGEMENT COORDINATOR");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /88N ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "88P");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " RAILWAY EQUIPMENT REPAIRER (RC)");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /88P ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "88T");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " RAILWAY SECTION REPAIRER (RC)");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /88T ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "88U");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " RAILWAY OPERATIONS CREWMEMBER (RC)");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /88U ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "88Z");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " TRANSPORTATION SENIOR SERGEANT");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /88Z ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);


        values.put(MOSTITLES_TITLE, "AMMUNITION,MECHANICAL MAINTAINANCE and ORDNANCE");
        values.put(MOSTITLES_BRANCH, Branch_USARMY);
        mostitleId = db.insert(MOSTITLES, null, values);


        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "89A");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " AMMUNITION STOCK CONTROL AND ACCOUNTING SPECIALIST");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /89A ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "89B");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " AMMUNITION SPECIALIST");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /89B ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "89D");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " EXPLOSIVE ORDNANCE DISPOSAL SPECIALIST");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /89D ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " ");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a / ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "91A");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " M1 ABRAMS TANK SYSTEM MAINTAINER");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /91A ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "91B");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " WHEELED VEHICLE MECHANIC");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /91B ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "91C");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " UTILITIES EQUIPMENT REPAIRER");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /91C ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "91D");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " POWER-GENERATION EQUIPMENT REPAIRER");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /91D ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "91E");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " ALLIED TRADES SPECIALIST");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /91E ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "91F");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " SMALL ARMS/ARTILLERY REPAIRER");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /91F ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "91G");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " FIRE CONTROL REPAIRER");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /91G ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "91H");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " TRACK VEHICLE REPAIRER");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /91H ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "91J");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " QUARTERMASTER AND CHEMICAL EQUIPMENT REPAIRER");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /91J ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "91K");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " ARMAMENT REPAIRER (del 1310 / 1110 - 28)");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /91K ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "91L");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " CONSTRUCTION EQUIPMENT REPAIRER");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /91L ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "91M");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " BRADLEY FIGHTING VEHICLE SYSTEM MAINTAINER");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /91M ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "91P");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " ARTILLERY MECHANIC");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /91P ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "91S");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " STRYKER SYSTEMS MAINTAINER");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /91S ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "91X");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " MAINTENANCE SUPERVISOR");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /91X ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "91Z");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " MECHANICAL MAINTENANCE SUPERVISOR");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /91Z ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " ");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a / ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "94A");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " LAND COMBAT ELECTRONIC MISSILE SYSTEM REPAIRER");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /94A ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "94D");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " AIR TRAFFIC CONTROL EQUIPMENT REPAIRER");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /94D ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "94E");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " RADIO AND COMMUNICATIONS SECURITY (COMSEC) REPAIRER");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /94E ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "94F");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " COMPUTER DETECTION SYSTEMS REPAIRER");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /94F ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "94H");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " TEST, MEASUREMENT, AND DIAGNOSTIC EQUIPMENT (TMDE) MAINTENANCE SUPPORT SPECIALIST");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /94H ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "94L");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " AVIONIC COMMUNICATIONS EQUIPMENT REPAIRER");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /94L ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "94M");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " RADAR REPAIRER");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /94M ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "94P");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " MULTIPLE LAUNCH ROCKET SYSTEM REPAIRER");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /94P ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "94R");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " AVIONIC AND SURVIVABILITY EQUIPMENT REPAIRER");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /94R ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "94S");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " PATRIOT SYSTEM REPAIRER");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /94S ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "94T");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " AVENGER SYSTEM REPAIRER");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /94T ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "94W");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " ELECTRONIC MAINTENANCE CHIEF");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /94W ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "94X");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " SENIOR MISSILE SYSTEMS MAINTAINER");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /94X ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "94Y");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " INTEGRATED FAMILY OF TEST EQUIPMENT (IFTE) OPERATOR AND MAINTAINER");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /94Y ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "94Z");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " SENIOR ELECTRONIC MAINTENANCE CHIEF");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /94Z ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values.put(MOSTITLES_TITLE, "QUARTERMASTER CORPS");
        values.put(MOSTITLES_BRANCH, Branch_USARMY);
        mostitleId = db.insert(MOSTITLES, null, values);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "92A");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " AUTOMATED LOGISTICAL SPECIALIST");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /92A ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "92F");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " PETROLEUM SUPPLY SPECIALIST");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /92F ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "92G");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " FOOD SERVICE SPECIALIST");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /92G ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "92L");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " PETROLEUM LABORATORY SPECIALIST");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /92L ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "92M");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " MORTUARY AFFAIRS SPECIALIST");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /92M ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "92R");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " PARACHUTE RIGGER");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /92R ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "92S");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " SHOWER/LAUNDRY AND CLOTHING REPAIR SPECIALIST");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /92S ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "92W");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " WATER TREATMENT SPECIALIST");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /92W ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "92Y");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " UNIT SUPPLY SPECIALIST");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /92Y ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "92Z");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, " SENIOR NONCOMMISSIONED LOGISTICIAN");
        values1.put(MOS_Link, " http://usmilitary.about.com/od/enlistedjobs/a /92Z ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values.put(MOSTITLES_TITLE, "Infantry");	 values.put(MOSTITLES_BRANCH, Branch_USARMY);	 mostitleId = db.insert(MOSTITLES, null, values);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "11A");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Infantry Officer");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/11.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);




        values.put(MOSTITLES_TITLE, "CORPS OF ENGINEERS");	 values.put(MOSTITLES_BRANCH, Branch_USARMY);	 mostitleId = db.insert(MOSTITLES, null, values);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "12A");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Engineer");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/12.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "12B");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Combat Engineer (del 1310 / 1110 - 14)");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/12.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "12D");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Facilities/Contact Construction Managewment Engineer (FCCME) (del 1310 / 1110 - 14)");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/12.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);



        values.put(MOSTITLES_TITLE, "FIELD ARTILLERY");	 values.put(MOSTITLES_BRANCH, Branch_USARMY);	 mostitleId = db.insert(MOSTITLES, null, values);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "13A");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Field Artillery Officer");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/13.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values.put(MOSTITLES_TITLE, "AIR DEFENSE ARTILLERY");	 values.put(MOSTITLES_BRANCH, Branch_USARMY);	 mostitleId = db.insert(MOSTITLES, null, values);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "14A");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Air Defense Artillery Officer");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/14.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);
        values.put(MOSTITLES_TITLE, "AVIATION");	 values.put(MOSTITLES_BRANCH, Branch_USARMY);	 mostitleId = db.insert(MOSTITLES, null, values);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "15A");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Aviation, General");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/15.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "15B");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Aviation Combined Arms Operations");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/15.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "15C");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Aviation All-source Intelligence");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/15.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values.put(MOSTITLES_TITLE, "SPECIAL FORCES");	 values.put(MOSTITLES_BRANCH, Branch_USARMY);	 mostitleId = db.insert(MOSTITLES, null, values);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "18A");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Special Forces Officer");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/18.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);


        values.put(MOSTITLES_TITLE, "ARMOR");	 values.put(MOSTITLES_BRANCH, Branch_USARMY);	 mostitleId = db.insert(MOSTITLES, null, values);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "19A");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Armor , General");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/19.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "19B");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Armor");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/19.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "19C");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Cavalry");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/19.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values.put(MOSTITLES_TITLE, "SIGNAL CORPS");	 values.put(MOSTITLES_BRANCH, Branch_USARMY);	 mostitleId = db.insert(MOSTITLES, null, values);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "25A");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Signal, General");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/25.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values.put(MOSTITLES_TITLE, "JUDGE ADVOCATE GENERAL'S CORPS");	 values.put(MOSTITLES_BRANCH, Branch_USARMY);	 mostitleId = db.insert(MOSTITLES, null, values);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "27A");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Judge Advocate General");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/27.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "27B");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Military Judge");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/27.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values.put(MOSTITLES_TITLE, "MILITARY POLICE");	 values.put(MOSTITLES_BRANCH, Branch_USARMY);	 mostitleId = db.insert(MOSTITLES, null, values);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "31A");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Military Police Officer");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/31.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values.put(MOSTITLES_TITLE, "MILITARY INTELLIGENCE");	 values.put(MOSTITLES_BRANCH, Branch_USARMY);	 mostitleId = db.insert(MOSTITLES, null, values);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "35D");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "All Source Intelligence");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/35.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "35E");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Counter Intelligence (CI)");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/35.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "35D");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Signals Intelligence/Electronic Warfare (SIGINT/EW)");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/35.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values.put(MOSTITLES_TITLE, "FINANCIAL MANAGEMENT");	 values.put(MOSTITLES_BRANCH, Branch_USARMY);	 mostitleId = db.insert(MOSTITLES, null, values);
        values1.put(MOS_NUMBER, "36A");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Financial Manager");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/36.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);


        values.put(MOSTITLES_TITLE, "PSYCHOLOGICAL OPERATIONS");	 values.put(MOSTITLES_BRANCH, Branch_USARMY);	 mostitleId = db.insert(MOSTITLES, null, values);
        values1.put(MOS_NUMBER, "37A");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Psychological Operations");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/usmilitary.about.com/od/officerjob1/a/37.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1.put(MOS_NUMBER, "37X");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Psychological Operations, Designated");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/usmilitary.about.com/od/officerjob1/a/37.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values.put(MOSTITLES_TITLE, "CIVIL AFFAIRS (AA AND USAR)");	 values.put(MOSTITLES_BRANCH, Branch_USARMY);	 mostitleId = db.insert(MOSTITLES, null, values);

        values1.put(MOS_NUMBER, "38A");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Civil Affairs (AA and USAR)");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/38.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1.put(MOS_NUMBER, "38X");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Civil Affairs, Designated");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/38.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);


        values.put(MOSTITLES_TITLE, "ADJUTANT GENERAL CORPS");	 values.put(MOSTITLES_BRANCH, Branch_USARMY);	 mostitleId = db.insert(MOSTITLES, null, values);
        values1.put(MOS_NUMBER, "42B");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Human Resources Officer");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/42.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1.put(MOS_NUMBER, "42C");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Army Bands");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/42.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);


        values1.put(MOS_NUMBER, "42H");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Senior Human Resources Officer");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/42.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);



        values.put(MOSTITLES_TITLE, "CHAPLAIN");	 values.put(MOSTITLES_BRANCH, Branch_USARMY);	 mostitleId = db.insert(MOSTITLES, null, values);
        values1.put(MOS_NUMBER, "56A");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Chaplain");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/56.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1.put(MOS_NUMBER, "56D");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Clinical Pastoral Educator");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/56.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1.put(MOS_NUMBER, "56X");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Chaplain Candidate");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/56.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values.put(MOSTITLES_TITLE, "MEDICAL CORPS");	 values.put(MOSTITLES_BRANCH, Branch_USARMY);	 mostitleId = db.insert(MOSTITLES, null, values);
        values1.put(MOS_NUMBER, "60A");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Operational Medicine");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/62.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1.put(MOS_NUMBER, "60B");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Nuclear Medicine Officer");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/62.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1.put(MOS_NUMBER, "60C");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Preventive Medicine Officer");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/62.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1.put(MOS_NUMBER, "60D");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Operational Medicine");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/62.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1.put(MOS_NUMBER, "60F");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Pulmonary Disease/Critical Care Officer");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/62.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1.put(MOS_NUMBER, "60G");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Gastroenterologist");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/62.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1.put(MOS_NUMBER, "60J");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Obstetrician and Gynecologist");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/62.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1.put(MOS_NUMBER, "60K");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Urologist");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/62.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1.put(MOS_NUMBER, "60L");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Dermatologist ");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/62.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1.put(MOS_NUMBER, "60M");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Allergist, Clinical Immunologist");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/62.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1.put(MOS_NUMBER, "60N");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Anesthesiologist ");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/62.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1.put(MOS_NUMBER, "60P");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Pediatrician");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/62.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1.put(MOS_NUMBER, "60Q");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Pediatric Sub-Specialist");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/62.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1.put(MOS_NUMBER, "60R");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Child Neurologist ");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/62.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1.put(MOS_NUMBER, "60R");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Diagnostic Radiologist ");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/62.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1.put(MOS_NUMBER, "60U");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Pathologist ");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/62.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1.put(MOS_NUMBER, "60W");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Peripheral Vascular Surgeon");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/62.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1.put(MOS_NUMBER, "60Z");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Neurosurgeon");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/62.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1.put(MOS_NUMBER, "62A");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Emergency Physician");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/62.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1.put(MOS_NUMBER, "62B");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Field Surgeon");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/62.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values.put(MOSTITLES_TITLE, "DENTAL CORPS");	 values.put(MOSTITLES_BRANCH, Branch_USARMY);	 mostitleId = db.insert(MOSTITLES, null, values);
        values1.put(MOS_NUMBER, "63A");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "General Dentist");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/63.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);


        values1.put(MOS_NUMBER, "63B");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "General Dentist");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/63.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1.put(MOS_NUMBER, "63D");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Periodontist");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/63.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1.put(MOS_NUMBER, "63E");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Endodontist");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/63.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1.put(MOS_NUMBER, "63F");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Prosthodonist");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/63.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1.put(MOS_NUMBER, "63H");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Public Health Dentist");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/63.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1.put(MOS_NUMBER, "63K");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Pediatric Dentist");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/63.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1.put(MOS_NUMBER, "63M");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Orthodontist");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/63.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1.put(MOS_NUMBER, "63N");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Oral and Maxillofacial Surgeon ");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/63.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1.put(MOS_NUMBER, "63P");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Oral Pathologist ");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/63.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1.put(MOS_NUMBER, "63R");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Executive Dentist");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/63.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);






        values.put(MOSTITLES_TITLE, "VETERINARY CORPS");	 values.put(MOSTITLES_BRANCH, Branch_USARMY);	 mostitleId = db.insert(MOSTITLES, null, values);
        values1.put(MOS_NUMBER, "64A");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Field Veterinary Service");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/64.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1.put(MOS_NUMBER, "64B");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Veterinary Preventive Medicine");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/64.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1.put(MOS_NUMBER, "64C");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Veterinary Laboratory Animal Medicine");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/64.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1.put(MOS_NUMBER, "64D");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Veterinary Pathology");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/64.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1.put(MOS_NUMBER, "64E");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Veterinary Comparative Medicine ");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/64.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1.put(MOS_NUMBER, "64F");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Veterinary Clinical Medicine");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/64.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1.put(MOS_NUMBER, "64Z");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Senior Veterinarian (IMMATERIAL)");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/64.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);






        values.put(MOSTITLES_TITLE, "ARMY MEDICAL SPECIALIST CORPS");	 values.put(MOSTITLES_BRANCH, Branch_USARMY);	 mostitleId = db.insert(MOSTITLES, null, values);
        values1.put(MOS_NUMBER, "65A");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Occupational Therapy");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/65.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1.put(MOS_NUMBER, "65B");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Physical Therapy ");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/65.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1.put(MOS_NUMBER, "65C");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Dietitian");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/65.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1.put(MOS_NUMBER, "65D");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Physician Assistant");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/65.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1.put(MOS_NUMBER, "65X");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Specialist Allied Operations");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/65.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);





        values.put(MOSTITLES_TITLE, "ARMY NURSE CORPS");	 values.put(MOSTITLES_BRANCH, Branch_USARMY);	 mostitleId = db.insert(MOSTITLES, null, values);
        values1.put(MOS_NUMBER, "66B");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Army Public Health Nurse");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/66.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1.put(MOS_NUMBER, "66C");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Psychiatric/Behavioral Health Nurse");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/66.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1.put(MOS_NUMBER, "66E");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Perioperative Nurse");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/66.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1.put(MOS_NUMBER, "66F");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Nurse Anesthetist");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/66.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1.put(MOS_NUMBER, "66G");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Obstetrics and Gyneco");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/66.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1.put(MOS_NUMBER, "66H");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Medical-Surgical Nurse");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/66.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1.put(MOS_NUMBER, "66N");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Generalist Nurse");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/66.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1.put(MOS_NUMBER, "66P");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Family Nurse Practitioner");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/66.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1.put(MOS_NUMBER, "66R");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Psychiatric/Behavioral Health Nurse Practitioner (add 1304 / 1110 - 13)");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/66.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);


        values1.put(MOS_NUMBER, "66W");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Certified Nurse Midwife (add 1304 / 1110 - 12)");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/66.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values.put(MOSTITLES_TITLE, "MEDICAL SERVICE CORPS");	 values.put(MOSTITLES_BRANCH, Branch_USARMY);	 mostitleId = db.insert(MOSTITLES, null, values);
        values1.put(MOS_NUMBER, "67A");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Health Services");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/67.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1.put(MOS_NUMBER, "67B");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Laboratory Sciences");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/67.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1.put(MOS_NUMBER, "67C");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Preventive Medicine Sciences ");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/67.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1.put(MOS_NUMBER, "67D");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Behavioral Sciences");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/67.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1.put(MOS_NUMBER, "67E");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Pharmacy");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/67.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1.put(MOS_NUMBER, "67F");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Optometry ");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/67.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1.put(MOS_NUMBER, "67G");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Podiatry");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/67.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values1.put(MOS_NUMBER, "67J");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Aeromedical Evacuation");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/67.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values.put(MOSTITLES_TITLE, "CHEMICAL, BIOLOGICAL, RADIOLOGICAL AND NUCLEAR (CBRN)");	 values.put(MOSTITLES_BRANCH, Branch_USARMY);	 mostitleId = db.insert(MOSTITLES, null, values);
        values1.put(MOS_NUMBER, "74A");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Chemical, Biological, Radiological and Nuclear (CBRN) Officer");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/74.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);


        values.put(MOSTITLES_TITLE, "TRANSPORTATION CORPS");	 values.put(MOSTITLES_BRANCH, Branch_USARMY);	 mostitleId = db.insert(MOSTITLES, null, values);
        values1.put(MOS_NUMBER, "88A");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Transportation, General");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/88.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values.put(MOSTITLES_TITLE, "LOGISTICS");	 values.put(MOSTITLES_BRANCH, Branch_USARMY);	 mostitleId = db.insert(MOSTITLES, null, values);
        values1.put(MOS_NUMBER, "90A");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Logistics");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/90.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);


        values.put(MOSTITLES_TITLE, "ORDNANCE");	 values.put(MOSTITLES_BRANCH, Branch_USARMY);	 mostitleId = db.insert(MOSTITLES, null, values);
        values1.put(MOS_NUMBER, "91A");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Maintenance & Munitions Materiel Officer");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/91.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);

        values.put(MOSTITLES_TITLE, "QUARTERMASTER CORPS");	 values.put(MOSTITLES_BRANCH, Branch_USARMY);	 mostitleId = db.insert(MOSTITLES, null, values);
        values1.put(MOS_NUMBER, "92A");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "Quartermaster, General");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjob1/a/92.htm");
        values1.put(MOS_TYPE, "Officer");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);













    }

    public void populatenavycommunities(SQLiteDatabase db) {

        ContentValues values = new ContentValues();


        values.put(MOSTITLES_TITLE, "Administration Community");

        values.put(MOSTITLES_BRANCH, Branch_USNAVY);



        long mostitleId = db.insert(MOSTITLES, null, values);



        ContentValues values1 = new ContentValues();
        values1.put(MOS_NUMBER, "LN");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, " LN - Legalman (Paralegal)");	values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjob1/a/ln.htm ");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "MC");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, " MC - Mass Communications Specialist");	values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjob1/a/mc.htm ");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "NC");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, " NC - Navy Counselor");	values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjob1/a/nc.htm ");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "MU");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, " MU - Musician");	values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjob1/a/mu.htm ");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "PS");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, " PS - Personnel Specialist");	values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjob1/a/pn.htm ");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);
        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "YN");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, " YN - Yeoman (Administration)");	values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjob1/a/yn.htm ");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);




        values.put(MOSTITLES_TITLE, "Aviation Community");
        values.put(MOSTITLES_BRANCH, Branch_USNAVY);
        mostitleId = db.insert(MOSTITLES, null, values);




        values1 = new ContentValues();
        values1.put(MOS_NUMBER, "ABE");
        values1.put(MOS_TITLE, mostitleId);
        values1.put(MOS_NAME, "ABE - Aviation Boatswain's Mate - Launch/Recovery");
        values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjob1/a/abe.htm ");
        values1.put(MOS_TYPE, "Enlisted");
        values1.put(MOS_RANK, "N/A");
        db.insert(MOS, null, values1);


        
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "ABF");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "ABF - Aviation Boatswain's Mate - Fuels");	values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjob1/a/abf.htm ");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "ABH");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "ABH - Aviation Boatswain's Mate - Aircraft Handler");	values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjob1/a/abh.htm ");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "AC");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "AC - Air Traffic Controller");	values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjob1/a/ac.htm ");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "AD");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "AD - Aviation Machinist's Mate");	values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjob1/a/ad.htm ");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "AE");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "AE - Aviation Electrician's Mate");	values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjob1/a/ae.htm ");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "AG");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "AG - Aerographer's Mate (Weather and Oceanography)");	values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjob1/a/ag.htm ");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "AM");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "AM - Aviation Structural Mechanic");	values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjob1/a/am.htm ");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "AME");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "AME - Aviation Structural Mechanic - Safety Equipment");	values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjob1/a/ame.htm ");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "AO");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "AO - Aviation Ordnanceman");	values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjob1/a/ao.htm ");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "AS");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "AS - Aviation Support Equipment Technician");	values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjob1/a/as.htm ");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "AT");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "AT - Aviation Electronics Technician");	values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjob1/a/at.htm ");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "AW");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "AW - Aviation Warfare Systems Operator");	values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjob1/a/aw.htm ");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "AZ");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "AZ - Aviation Maintenance Administrationman");	values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjob1/a/az.htm ");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "PR");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "PR - Aircrew Survival Equipmentman");	values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjob1/a/pr.htm ");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);



















        values = new ContentValues();
        values.put(MOSTITLES_TITLE, " Cryptologic Community ");	 values.put(MOSTITLES_BRANCH, Branch_USNAVY);	 mostitleId = db.insert(MOSTITLES, null, values);

        values1 = new ContentValues();	values1.put(MOS_NUMBER, "CTI");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "CTI - Cryptologic Technician - Interpretive");	values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjob1/a/cti.htm ");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "CTM");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "CTM - Cryptologic Technician - Maintenance");	values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjob1/a/ctm.htm ");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "CTN");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "CTN - Cryptologic Technician - Networks");	values1.put(MOS_Link, "http://usmilitary.about.com/cs/navy/a/navyctn.htm ");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "CTR");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "CTR - Cryptologic Technician - Collection");	values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjob1/a/ctr.htm ");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "CTT");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "CTT - Cryptologic Technician - Technical");	values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjob1/a/ctt.htm ");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "IT");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "IT - Information System Technician");	values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjob1/a/it.htm ");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);

        values = new ContentValues();
        values.put(MOSTITLES_TITLE, " Intelligence Community ");	 values.put(MOSTITLES_BRANCH, Branch_USNAVY);	 mostitleId = db.insert(MOSTITLES, null, values);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "IS");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "IS - Intelligence Specialist");	values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjob1/a/is.htm ");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);

        values = new ContentValues();
        values.put(MOSTITLES_TITLE, " Medical/Dental Community ");	 values.put(MOSTITLES_BRANCH, Branch_USNAVY);	 mostitleId = db.insert(MOSTITLES, null, values);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "HM");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "HM - Hospital Corpsman");	values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjob1/a/hm.htm ");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);

        values = new ContentValues();
        values.put(MOSTITLES_TITLE, " Nuclear Community ");	 values.put(MOSTITLES_BRANCH, Branch_USNAVY);	 mostitleId = db.insert(MOSTITLES, null, values);

        values1 = new ContentValues();	values1.put(MOS_NUMBER, "NF");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "NF - Nuclear Field Enlistment Program");	values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjob1/a/nf.htm ");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "EM(N)");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "EM(N) -Nuclear Trained Electricians Mate");	values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjob1/a/emn.htm ");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "ET(N)");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "ET(N) -Nuclear Trained Electronics Technician");	values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjob1/a/etn.htm ");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "MM(N)");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "MM(N) -Nuclear Trained Machinist's Mate");	values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjob1/a/mmn.htm ");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);


        values = new ContentValues();
        values.put(MOSTITLES_TITLE, " SEABEE Community ");	 values.put(MOSTITLES_BRANCH, Branch_USNAVY);	 mostitleId = db.insert(MOSTITLES, null, values);

        values1 = new ContentValues();	values1.put(MOS_NUMBER, "BU");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "BU - Builder");	values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjob1/a/bu.htm ");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "CE");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "CE - Construction Electrician"); values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjob1/a/ce.htm ");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "CM");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "CM - Construction Mechanic");	values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjob1/a/cm.htm ");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "EA");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "EA - Engineering Aid");	values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjob1/a/ea.htm ");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "EO");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "EO - Equipment Operator");	values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjob1/a/eo.htm ");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "SW");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "SW - Steelworker ");	values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjob1/a/sw.htm ");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "UT");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "UT - Utilitiesman");	values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjob1/a/ut.htm ");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);


        values = new ContentValues();
        values.put(MOSTITLES_TITLE, " Security Community ");	 values.put(MOSTITLES_BRANCH, Branch_USNAVY);	 mostitleId = db.insert(MOSTITLES, null, values);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "MA");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "MA - Master at Arms");	values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjob1/a/ma.htm ");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);

        values = new ContentValues();
        values.put(MOSTITLES_TITLE, " Special Warfare/Special Operations Community ");	 values.put(MOSTITLES_BRANCH, Branch_USNAVY);	 mostitleId = db.insert(MOSTITLES, null, values);

        values1 = new ContentValues();	values1.put(MOS_NUMBER, "EOD");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "EOD - Explosive Ordnance Disposal");	values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjob1/a/eod.htm ");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "ND");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "ND -Navy Diver ");	values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjob1/a/diver.htm ");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "SO");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "SO - Special Operations (Navy SEAL)");	values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjob1/a/seal.htm ");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "SB");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "SB - Special Warfare Boat Operator");	values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjob1/a/swcc.htm ");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);


        values = new ContentValues();
        values.put(MOSTITLES_TITLE, " Submarine Community ");	 values.put(MOSTITLES_BRANCH, Branch_USNAVY);	 mostitleId = db.insert(MOSTITLES, null, values);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "CS(SS)");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "CS(SS) - Culinary Specialist (Submarine)");	values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjob1/a/csss.htm ");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "ET COM");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "ET COM - Electronics Technician (Communications)");	values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjob1/a/etcom.htm ");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "ET NAV");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "ET NAV - Electronics Technician (Navigation)");	values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjob1/a/etnav.htm ");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "FT");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "FT - Fire Control Technician");	values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjob1/a/ft.htm ");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "MM AUX");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "MM AUX - Machinist Mate (Auxilary Equipment");	values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjob1/a/mmaux.htm ");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "MM WEP");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "MM WEP - Machinist Mate (Weapons)");	values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjob1/a/mmwep.htm ");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "MT");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "MT - Missile Technican");	values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjob1/a/mt.htm ");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "SK(SS)");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "SK(SS) - Storekeeper (Submarine)");	values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjob1/a/skss.htm ");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "STS");	 values1.put(MOS_TITLE, mostitleId);  values1.put(MOS_NAME, "STS - Sonar Technician (Submarine)");	values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjob1/a/sts.htm ");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "YN(SS)");	 values1.put(MOS_TITLE, mostitleId);	 values1.put(MOS_NAME, "YN(SS) - Yeoman (Submarine)");	values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjob1/a/ynss.htm ");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);


        values = new ContentValues();
        values.put(MOSTITLES_TITLE, " Supply Community ");	 values.put(MOSTITLES_BRANCH, Branch_USNAVY);	 mostitleId = db.insert(MOSTITLES, null, values);

        values1 = new ContentValues();	values1.put(MOS_NUMBER, "CS");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "CS - Culinary Specialist");	values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjob1/a/cs.htm ");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "LS");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "LS - Logistic Support (effective Oct 2009)");	values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjob1/a/ls.htm ");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "PC");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "PC - Postal Clerk (will be disestablished in Oct 2009)");	values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjob1/a/pc.htm ");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "SH");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "SH - Ship's Serviceman");	values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjob1/a/sh.htm ");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "SK");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "SK - Storekeeper (will be disestablished in Oct 2009)");	values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjob1/a/sk.htm ");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);

        values = new ContentValues();
        values.put(MOSTITLES_TITLE, " Surface Combat Systems/Operations Community ");	 values.put(MOSTITLES_BRANCH, Branch_USNAVY);	 mostitleId = db.insert(MOSTITLES, null, values);

        values1 = new ContentValues();	values1.put(MOS_NUMBER, "BM");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "BM - Boatswain's Mate");	values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjob1/a/bm.htm ");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "ET");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "ET - Electronic Technician");	values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjob1/a/et.htm ");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "FC");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "FC - Fire Controlman");	values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjob1/a/fc.htm ");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "GM");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "GM - Gunner's Mate");	values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjob1/a/gm.htm ");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "MN");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "MN - Mineman");	values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjob1/a/mn.htm ");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "OS");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "OS - Operations Specialist");	values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjob1/a/os.htm ");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "QM");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "QM - Quartermaster");	values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjob1/a/qm.htm ");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "STG");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "STG - Sonar Technician-Surface");	values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjob1/a/stg.htm ");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);

        values = new ContentValues();
        values.put(MOSTITLES_TITLE, " Surface Engineering Community ");	 values.put(MOSTITLES_BRANCH, Branch_USNAVY);	 mostitleId = db.insert(MOSTITLES, null, values);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "DC");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "DC - Damage Controlman");	values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjob1/a/dc.htm ");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "EM");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "EM - Electricians Mate");	values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjob1/a/em.htm ");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "EN");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "EN - Engineman");	values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjob1/a/en.htm ");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "GSE");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "GSE - Gas Turbine Systems Technician- Electrical");	values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjob1/a/gse.htm ");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "GSM");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "GSM - Gas Turbine Systems Technician- Mechanical");	values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjob1/a/gsm.htm ");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "HT");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "HT - Hull Maintenance Technician");	values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjob1/a/ht.htm ");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "IC");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "IC - Interior Communications Electrician");	values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjob1/a/ic.htm ");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "MM");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "MM - Machinist's Mate");	values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjob1/a/mm.htm ");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "MR");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "MR - Machinery Repairman");	values1.put(MOS_Link, "http://usmilitary.about.com/od/enlistedjob1/a/mr.htm ");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);

        //officers

        values = new ContentValues();
        values.put(MOSTITLES_TITLE, "Baccalaureate Degree Completion Program (BDCP)--Officers");	 values.put(MOSTITLES_BRANCH, Branch_USNAVY);	 mostitleId = db.insert(MOSTITLES, null, values);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "None");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "Baccalaureate Degree Completion Program (BDCP)--Officers");	values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjo2/a/bdcp.htm");	  values1.put(MOS_TYPE, "Officer");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);

        values = new ContentValues();
        values.put(MOSTITLES_TITLE, " Navy Reserve Officer Training Corps (NROTC)--Officers");	 values.put(MOSTITLES_BRANCH, Branch_USNAVY);	 mostitleId = db.insert(MOSTITLES, null, values);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "None");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "Navy Reserve Officer Training Corps (NROTC)--Officers");	values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjo2/a/rotc.htm");	  values1.put(MOS_TYPE, "Officer");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);

        values = new ContentValues();
        values.put(MOSTITLES_TITLE, "Aerospace Maintenance --Officers");	 values.put(MOSTITLES_BRANCH, Branch_USNAVY);	 mostitleId = db.insert(MOSTITLES, null, values);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "None");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "Aerospace Maintenance --Officers");	values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjo2/a/maintoff.htm");	  values1.put(MOS_TYPE, "Officer");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);


        values = new ContentValues();
        values.put(MOSTITLES_TITLE, "Naval Aviator (Pilot) --Officers");	 values.put(MOSTITLES_BRANCH, Branch_USNAVY);	 mostitleId = db.insert(MOSTITLES, null, values);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "None");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "Naval Aviator (Pilot) --Officers");	values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjo2/a/pilot.htm");	  values1.put(MOS_TYPE, "Officer");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);


        values = new ContentValues();
        values.put(MOSTITLES_TITLE, "Naval Aviator (NFO) --Officers");	 values.put(MOSTITLES_BRANCH, Branch_USNAVY);	 mostitleId = db.insert(MOSTITLES, null, values);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "None");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "Naval Aviator (NFO) --Officers");	values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjo2/a/nfo.htm");	  values1.put(MOS_TYPE, "Officer");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);

        values = new ContentValues();
        values.put(MOSTITLES_TITLE, "Chaplain (Direct Appointment) --Officers");	 values.put(MOSTITLES_BRANCH, Branch_USNAVY);	 mostitleId = db.insert(MOSTITLES, null, values);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "None");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "Chaplain (Direct Appointment) --Officers");	values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjo2/a/chapda.htm");	  values1.put(MOS_TYPE, "Officer");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);


        values = new ContentValues();
        values.put(MOSTITLES_TITLE, "Chaplain (Student Selection Program) --Officers");	 values.put(MOSTITLES_BRANCH, Branch_USNAVY);	 mostitleId = db.insert(MOSTITLES, null, values);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "None");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "Chaplain (Student Selection Program) --Officers");	values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjo2/a/chaplaincan.htm");	  values1.put(MOS_TYPE, "Officer");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);


        values = new ContentValues();
        values.put(MOSTITLES_TITLE, "Civil Engineer --Officers");	 values.put(MOSTITLES_BRANCH, Branch_USNAVY);	 mostitleId = db.insert(MOSTITLES, null, values);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "None");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "Civil Engineer --Officers");	values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjo2/a/ce.htm");	  values1.put(MOS_TYPE, "Officer");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);


        values = new ContentValues();
        values.put(MOSTITLES_TITLE, "Civil Engineer (Collegiate Acceptance Program) --Officers");	 values.put(MOSTITLES_BRANCH, Branch_USNAVY);	 mostitleId = db.insert(MOSTITLES, null, values);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "None");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "Civil Engineer (Collegiate Acceptance Program) --Officers");	values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjo2/a/cestudent.htm");	  values1.put(MOS_TYPE, "Officer");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);


        values = new ContentValues();
        values.put(MOSTITLES_TITLE, "Cryptology --Officers");	 values.put(MOSTITLES_BRANCH, Branch_USNAVY);	 mostitleId = db.insert(MOSTITLES, null, values);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "None");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "Cryptology --Officers");	values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjo2/a/cryp.htm");	  values1.put(MOS_TYPE, "Officer");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);


        values = new ContentValues();
        values.put(MOSTITLES_TITLE, "Engineering Duty Officer --Officers");	 values.put(MOSTITLES_BRANCH, Branch_USNAVY);	 mostitleId = db.insert(MOSTITLES, null, values);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "None");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "Engineering Duty Officer --Officers");	values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjo2/a/edoswo.htm");	  values1.put(MOS_TYPE, "Officer");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);


        values = new ContentValues();
        values.put(MOSTITLES_TITLE, "Intelligence (Intel) --Officers");	 values.put(MOSTITLES_BRANCH, Branch_USNAVY);	 mostitleId = db.insert(MOSTITLES, null, values);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "None");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "Intelligence (Intel) --Officers");	values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjo2/a/intel.htm");	  values1.put(MOS_TYPE, "Officer");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);

        values = new ContentValues();
        values.put(MOSTITLES_TITLE, "JAG (Lawyer) -- Direct Appointment --Officers");	 values.put(MOSTITLES_BRANCH, Branch_USNAVY);	 mostitleId = db.insert(MOSTITLES, null, values);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "None");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "JAG (Lawyer) -- Direct Appointment");	values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjo2/a/jagda.htm");	  values1.put(MOS_TYPE, "Officer");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);

        values = new ContentValues();
        values.put(MOSTITLES_TITLE, "JAG (Law School) -- Student Selection Program --Officers");	 values.put(MOSTITLES_BRANCH, Branch_USNAVY);	 mostitleId = db.insert(MOSTITLES, null, values);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "None");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "JAG (Law School) -- Student Selection Program");	values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjo2/a/jagstudent.htm");	  values1.put(MOS_TYPE, "Officer");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);

        values = new ContentValues();
        values.put(MOSTITLES_TITLE, "Medical Services Corps --Officers");	 values.put(MOSTITLES_BRANCH, Branch_USNAVY);	 mostitleId = db.insert(MOSTITLES, null, values);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "None");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "Medical Services Corps");	values1.put(MOS_Link, "http://usmilitary.about.com/gi/o.htm?zi=1/XJ&zTi=1&sdn=usmilitary&cdn=careers&tm=6794&f=22&su=p284.13.342.ip_&tt=2&bt=1&bts=28&zu=http%3A//www.navy.com/careers/officer/healthcare/medicalservices/");	  values1.put(MOS_TYPE, "Officer");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);

        values = new ContentValues();
        values.put(MOSTITLES_TITLE, "Naval Reactors Engineer --Officers");	 values.put(MOSTITLES_BRANCH, Branch_USNAVY);	 mostitleId = db.insert(MOSTITLES, null, values);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "None");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "Naval Reactors Engineer");	values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjo2/a/reactors.htm");	  values1.put(MOS_TYPE, "Officer");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);

        values = new ContentValues();
        values.put(MOSTITLES_TITLE, "Nuclear Officer (Surface) --Officers");	 values.put(MOSTITLES_BRANCH, Branch_USNAVY);	 mostitleId = db.insert(MOSTITLES, null, values);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "None");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "Nuclear Officer (Surface)");	values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjo2/a/nukesurf.htm");	  values1.put(MOS_TYPE, "Officer");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);
        values = new ContentValues();
        values.put(MOSTITLES_TITLE, "Nuclear Officer (Submarines) --Officers");	 values.put(MOSTITLES_BRANCH, Branch_USNAVY);	 mostitleId = db.insert(MOSTITLES, null, values);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "None");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "Nuclear Officer (Submarines)");	values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjo2/a/nukesub.htm");	  values1.put(MOS_TYPE, "Officer");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);
        values = new ContentValues();
        values.put(MOSTITLES_TITLE, "Nuclear Power School Instructor --Officers");	 values.put(MOSTITLES_BRANCH, Branch_USNAVY);	 mostitleId = db.insert(MOSTITLES, null, values);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "None");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "Nuclear Power School Instructor");	values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjo2/a/nukeps.htm");	  values1.put(MOS_TYPE, "Officer");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);

        values = new ContentValues();
        values.put(MOSTITLES_TITLE, "Nurse Corps --Officers");	 values.put(MOSTITLES_BRANCH, Branch_USNAVY);	 mostitleId = db.insert(MOSTITLES, null, values);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "None");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "Nurse Corps");	values1.put(MOS_Link, "http://www.navy.com/healthcare/nursing");	  values1.put(MOS_TYPE, "Officer");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);

        values = new ContentValues();
        values.put(MOSTITLES_TITLE, "Oceanography --Officers");	 values.put(MOSTITLES_BRANCH, Branch_USNAVY);	 mostitleId = db.insert(MOSTITLES, null, values);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "None");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "Oceanography");	values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjo2/a/ocean.htm");	  values1.put(MOS_TYPE, "Officer");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);

        values = new ContentValues();
        values.put(MOSTITLES_TITLE, "Public Affairs --Officers");	 values.put(MOSTITLES_BRANCH, Branch_USNAVY);	 mostitleId = db.insert(MOSTITLES, null, values);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "None");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "Public Affairs");	values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjo2/a/pa.htm");	  values1.put(MOS_TYPE, "Officer");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);

        values = new ContentValues();
        values.put(MOSTITLES_TITLE, "SEAL (Special Warfare) --Officers");	 values.put(MOSTITLES_BRANCH, Branch_USNAVY);	 mostitleId = db.insert(MOSTITLES, null, values);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "None");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "SEAL (Special Warfare");	values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjo2/a/seal.htm");	  values1.put(MOS_TYPE, "Officer");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);

        values = new ContentValues();
        values.put(MOSTITLES_TITLE, "Special Operations (EOD, Diver) --Officers");	 values.put(MOSTITLES_BRANCH, Branch_USNAVY);	 mostitleId = db.insert(MOSTITLES, null, values);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "None");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "Special Operations (EOD, Diver)");	values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjo2/a/specops.htm");	  values1.put(MOS_TYPE, "Officer");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);
        values = new ContentValues();
        values.put(MOSTITLES_TITLE, "Supply --Officers");	 values.put(MOSTITLES_BRANCH, Branch_USNAVY);	 mostitleId = db.insert(MOSTITLES, null, values);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "None");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "Supply");	values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjo2/a/supply.htm");	  values1.put(MOS_TYPE, "Officer");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);

        values = new ContentValues();
        values.put(MOSTITLES_TITLE, "Surface Warfare Officer --Officers");	 values.put(MOSTITLES_BRANCH, Branch_USNAVY);	 mostitleId = db.insert(MOSTITLES, null, values);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "None");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "Surface Warfare Officer");	values1.put(MOS_Link, "http://usmilitary.about.com/od/officerjo2/a/swo.htm");	  values1.put(MOS_TYPE, "Officer");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);




    }

    public void populateCGcommunities(SQLiteDatabase db) {

        ContentValues values = new ContentValues();


        values.put(MOSTITLES_TITLE, "Aviation group");

        values.put(MOSTITLES_BRANCH, Branch_USCG);


        long mostitleId = db.insert(MOSTITLES, null, values);


        ContentValues values1 = new ContentValues();
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "AMT");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "Aviation Maintenance Technician (AMT)");	values1.put(MOS_Link, "http://www.gocoastguard.com/active-duty-careers/enlisted-opportunities/view-job-descriptions/amt");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "AST");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "Aviation Survival Technician");	values1.put(MOS_Link, "http://www.gocoastguard.com/active-duty-careers/enlisted-opportunities/view-job-descriptions/ast");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "AV");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "Avionics Electrical Technician");	values1.put(MOS_Link, "http://www.gocoastguard.com/active-duty-careers/enlisted-opportunities/view-job-descriptions/aet");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);

        values = new ContentValues();

        values.put(MOSTITLES_TITLE, "Administrative and scientific group");	 values.put(MOSTITLES_BRANCH, Branch_USCG);	 mostitleId = db.insert(MOSTITLES, null, values);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "HS");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "Health Services Technician");	values1.put(MOS_Link, "http://www.gocoastguard.com/active-duty-careers/enlisted-opportunities/view-job-descriptions/hs");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);

        values1 = new ContentValues();	values1.put(MOS_NUMBER, "MST");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "Marine Science Technician");	values1.put(MOS_Link, "http://www.gocoastguard.com/active-duty-careers/enlisted-opportunities/view-job-descriptions/mst");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "PA");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "Public Affairs Specialist");	values1.put(MOS_Link, "http://www.gocoastguard.com/active-duty-careers/enlisted-opportunities/view-job-descriptions/pa");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "SK");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "Storekeeper");	values1.put(MOS_Link, "http://www.gocoastguard.com/active-duty-careers/enlisted-opportunities/view-job-descriptions/sk");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "FS");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "Food Service Specialist");	values1.put(MOS_Link, "http://www.gocoastguard.com/active-duty-careers/enlisted-opportunities/view-job-descriptions/fs");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "YN");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "Yeoman");	values1.put(MOS_Link, "http://www.gocoastguard.com/active-duty-careers/enlisted-opportunities/view-job-descriptions/yn");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);




        values = new ContentValues();

        values.put(MOSTITLES_TITLE, "Deck & weapons group");	 values.put(MOSTITLES_BRANCH, Branch_USCG);	 mostitleId = db.insert(MOSTITLES, null, values);

        values1 = new ContentValues();	values1.put(MOS_NUMBER, "BM");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "Boatswain's Mate");	values1.put(MOS_Link, "http://www.gocoastguard.com/active-duty-careers/enlisted-opportunities/view-job-descriptions/bm");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "MU");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "Maritime Enforcement Specialist");	values1.put(MOS_Link, "http://www.gocoastguard.com/active-duty-careers/enlisted-opportunities/view-job-descriptions/me");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "GM");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "Gunner's Mate");	values1.put(MOS_Link, "http://www.gocoastguard.com/active-duty-careers/enlisted-opportunities/view-job-descriptions/gm");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "OS");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "Operations Specialist (OS)");	values1.put(MOS_Link, "http://www.gocoastguard.com/active-duty-careers/enlisted-opportunities/view-job-descriptions/os");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "IV");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "Intelligence Specialist");	values1.put(MOS_Link, "http://www.gocoastguard.com/active-duty-careers/enlisted-opportunities/view-job-descriptions/is");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);



        values = new ContentValues();

        values.put(MOSTITLES_TITLE, "Engineering & hull group");	 values.put(MOSTITLES_BRANCH, Branch_USCG);	 mostitleId = db.insert(MOSTITLES, null, values);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "DC");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "Damage Controlman");	values1.put(MOS_Link, "http://www.gocoastguard.com/active-duty-careers/enlisted-opportunities/view-job-descriptions/dc-0");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "EM");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "Electrician's Mate");	values1.put(MOS_Link, "http://www.gocoastguard.com/active-duty-careers/enlisted-opportunities/view-job-descriptions/em");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "ET");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "Electronics Technician");	values1.put(MOS_Link, "http://www.gocoastguard.com/active-duty-careers/enlisted-opportunities/view-job-descriptions/et");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "MK");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "Machinery Technician");	values1.put(MOS_Link, "http://www.gocoastguard.com/active-duty-careers/enlisted-opportunities/view-job-descriptions/mk");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);
        values1 = new ContentValues();	values1.put(MOS_NUMBER, "IT");	 values1.put(MOS_TITLE, mostitleId);	values1.put(MOS_NAME, "Information Systems Technician");	values1.put(MOS_Link, "http://www.gocoastguard.com/active-duty-careers/enlisted-opportunities/view-job-descriptions/it");	  values1.put(MOS_TYPE, "Enlisted");	 values1.put(MOS_RANK, "N/A");	 db.insert(MOS, null, values1);










































    }

public void populateack(SQLiteDatabase db){

    ContentValues values1 = new ContentValues();
   // values1 = new ContentValues();
    values1.put(Ack, "EPLRS");
    values1.put(Ack_Name, "Enhanced Position Location Relay System");
    values1.put(Ack_Details, "The Enhanced Position Location Reporting System (EPLRS) is a secure, jam resistant, computer controlled communications network that distributes near real-time tactical information, generally integrated into radio sets, and coordinated by a Network Control Station.[1] It is primarily used for data distribution, and position location and reporting. It enhances command and control of tactical units by providing commanders with the location of friendly units.[2] It was first fielded by the US Army in 1987.");
    values1.put(Ack_Link, "http://en.wikipedia.org/wiki/Enhanced_Position_Location_Reporting_System");
    values1.put(Ack_Icon, "eplrs");

    db.insert(Ackdb, null, values1);



}
        @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
        db.execSQL(DATABASE_CREATE2);
        db.execSQL(DATABASE_CREATE3);
        db.execSQL(DATABASE_CREATE4);
        db.execSQL(DATABASE_CREATE5);

        populateservice(db);
        populateusmcranks(db);
        populateusafranks(db);
        populateusarmyranks(db);
        populateusnavyranks(db);
        populateuscgranks(db);


        populateusmcmos(db);
        populateusafafsc(db);
        populatearmymos(db);
        populatenavycommunities(db);
        populateCGcommunities(db);
        populateack(db);









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