package com.cnsintegration.srcmarineinfo1.Database;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;


/**
 * Created by jprioleau on 9/29/2015.
 */
public class MyTask extends AsyncTask<SQLiteDatabase, Void, String> {
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

    public DataBaseWrapper dbHelper;

    @Override
    protected String doInBackground(SQLiteDatabase... params) {
        String title ="";
        ContentValues values = new ContentValues();
        ContentValues values1 = new ContentValues();
        SQLiteDatabase database = dbHelper.getReadableDatabase();
        try {

            Document doc = Jsoup.connect("http://usmilitary.about.com/od/enlistedjo2/a/marinejobs.htm").get();

            Elements pele = doc.select("#main > div > div.row.infinite-article-body > div.col.col-11.col-tablet-8.article-content > article > div.col-push-2.col-push-tablet-1.content-responsive > ul > li > p ");
            Elements peleone = doc.select("#main > div");
                /*Elements div = doc.select("#toc");  // select your div with yor class
                Elements ul = doc.select("#toc > ul");
                Elements li = ul.select("li.toclevel-1"); // select all li from ul
                */
            // Elements lia = li.select("li.toclevel-1 > a"); // select all li from ul
            //  Elements liasp = lia.select("span.toctext"); // select all li from ul



            for (Element link : pele) {
                String mostitle = link.text();
                Elements alink = link.select("b > a");
                String url2 = alink.attr("href");
                Document doc2 = Jsoup.connect(url2).get();
                Elements pele2 = doc2.select("#main > div > div.row.infinite-article-body > div.col.col-11.col-tablet-8.article-content > article > div.col-push-2.col-push-tablet-1.content-responsive > p > a[data-source=inlineLink]");
                Elements pele3 = doc2.select("#main > div > div.row.infinite-article-body > div.col.col-11.col-tablet-8.article-content > article > div.col-push-2.col-push-tablet-1.content-responsive > p > a[data-source=inlineLink]");




                values.put("mos_name", mostitle);
                values.put("mos_branch", dbHelper.Branch_USMC);


                long mostitleId =  database.insert(MOSTITLES, null, values);

                for (Element link2 : pele2) {
                    String mnum = link2.text();
                    values1.put(MOS_NUMBER, mnum);
                    values1.put(MOS_TITLE, mostitleId);
                    // String parp =  link2.parentNode().
                    //String parp2 =  link2.parentNode().text();

                }




/*
                    values1.put(MOS_NAME, "Basic Administrative Marine");
                    values1.put(MOS_TYPE, "Enlisted");
                    values1.put(MOS_RANK, "Pvt - GySgt");
                    values1.put(MOS_Link, "http://en.wikipedia.org/wiki/Military_administration");
                    dbs.insert(MOS, null, values1);*/

                values = new ContentValues();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return title;
    }



}