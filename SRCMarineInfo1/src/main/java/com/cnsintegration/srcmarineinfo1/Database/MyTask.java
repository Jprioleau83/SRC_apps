package com.cnsintegration.srcmarineinfo1.Database;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import com.cnsintegration.srcmarineinfo1.Database.DataBaseWrapper;


/**
 * Created by jprioleau on 9/29/2015.
 */
public class MyTask extends AsyncTask<DataBaseWrapper, Void, String> {
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

    public SQLiteDatabase database;





    @Override
    protected String doInBackground(DataBaseWrapper... params) {
        String title ="";
        ContentValues values = new ContentValues();
        ContentValues values1 = new ContentValues();
        SQLiteDatabase database = params[0].getReadableDatabase();
        try {

            Document doc = Jsoup.connect("http://usmilitary.about.com/od/enlistedjo2/a/marinejobs.htm").get();
            Document docoff = Jsoup.connect("http://usmilitary.about.com/od/officerj3/a/officerjobsmenu.htm").get();

            Elements pele = doc.select("#main > div > div.row.infinite-article-body > div.col.col-11.col-tablet-8.article-content > article > div.col-push-2.col-push-tablet-1.content-responsive > ul > li > p ");
            Elements peleoff = docoff.select("#main > div > div.row.infinite-article-body > div.col.col-11.col-tablet-8.article-content > article > div.col-push-2.col-push-tablet-1.content-responsive > p");



            for (Element link : pele) {
                String mostitle = link.text();
                Elements alink = link.select("b > a");
                String url2 = alink.first().attr("href");
                Document doc2 = Jsoup.connect(url2).get();
                Elements pele2 = doc2.select("#main > div > div.row.infinite-article-body > div.col.col-11.col-tablet-8.article-content > article > div.col-push-2.col-push-tablet-1.content-responsive > p > a[data-source=inlineLink]:matches(^.\\d+) ");




                values.put("mos_name", mostitle);
                values.put("mos_branch",  params[0].Branch_USMC);


                long mostitleId =  database.insert(MOSTITLES, null, values);

                for (Element link2 : pele2) {
                    String mnum = link2.html();
                    values1.put(MOS_NUMBER, mnum);
                    values1.put(MOS_TITLE, mostitleId);

                    String parp2 = link2.parent().ownText();
                    values1.put(MOS_NAME, parp2);
                    values1.put(MOS_TYPE, "Enlisted");
                    Document doc3 = Jsoup.connect(link2.attr("abs:href")).get();

                    Elements pele3 = doc3.select("#main > div > div.row.infinite-article-body > div.col.col-11.col-tablet-8.article-content > article > div.col-push-2.col-push-tablet-1.content-responsive > p:contains(Rank Range)");
                    String parp3 = "N/A";
                    if( !pele3.isEmpty() ){
                        parp3 = pele3.first().text();
                    }

                    values1.put(MOS_RANK, parp3);

                    values1.put(MOS_Link, link2.attr("abs:href"));
                    database.insert(MOS, null, values1);
                    values1 = new ContentValues();
                }




/*


                    dbs.insert(MOS, null, values1);*/

                values = new ContentValues();
            }
/*
                for (Element link : peleoff) {
                    String mostitle = link.text();
                    Elements alink = link.select("b > a");
                    String url2 = alink.attr("href");
                    Document doc2 = Jsoup.connect(url2).get();
                    Elements pele2off = doc2.select("#main > div > div.row.infinite-article-body > div.col.col-11.col-tablet-8.article-content > article > div.col-push-2.col-push-tablet-1.content-responsive > p > a[data-source=inlineLink]:matches(\\d+)");


                    Cursor cursor = database.query(params[0].MOSTITLES, null, "mos_name=" + mostitle, null, null, null, null);
                    cursor.moveToFirst();

                    long mostitleId = 0;

                    if(cursor == null ||  cursor.getCount() == 0){
                        values.put("mos_name", mostitle);
                        values.put("mos_branch",  params[0].Branch_USMC);


                         mostitleId =  database.insert(MOSTITLES, null, values);
                    }else{
                         mostitleId = Long.valueOf(cursor.getString(1)).longValue();
                    }

                    for (Element link2 : pele2off) {
                        String mnum = link2.parent().text();
                        values1.put(MOS_NUMBER, mnum);
                        values1.put(MOS_TITLE, mostitleId);

                        String parp2 = link2.parent().text();
                        values1.put(MOS_NAME, parp2);
                        Document doc3 = Jsoup.connect(link2.attr("href")).get();

                        Elements rtype = doc3.select("#main > div > div.row.infinite-article-body > div.col.col-11.col-tablet-8.article-content > article > div.col-push-2.col-push-tablet-1.content-responsive > p:contains(Type of Officer)");
                        String rtypestrg = rtype.first().text();
                        if(rtypestrg.contains("Warrant")){
                            values1.put(MOS_TYPE, "Warrant Officer");
                        }else{
                            values1.put(MOS_TYPE, "Officer");
                        }




                        Elements pele3 = doc3.select("#main > div > div.row.infinite-article-body > div.col.col-11.col-tablet-8.article-content > article > div.col-push-2.col-push-tablet-1.content-responsive > p:contains(Rank Range)");
                        String parp3 = pele3.first().text();
                        values1.put(MOS_RANK, parp3);
                        values1.put(MOS_Link, link2.attr("href"));
                        database.insert(MOS, null, values1);
                        values1 = new ContentValues();
                    }



                }


*/











        } catch (IOException e) {
            e.printStackTrace();
        }
        return title;
    }



}
