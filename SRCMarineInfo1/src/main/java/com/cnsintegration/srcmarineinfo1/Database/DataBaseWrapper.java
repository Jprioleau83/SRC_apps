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
        values.put(Rank_DETAILS, "In the United States, second lieutenant is the normal entry-level rank for most commissioned officers in the Army, Air Force and Marine Corps and is equivalent to the rank of ensign in the Navy and Coast Guard. In the Army and Marine Corps, a second lieutenant typically leads a platoon-size element (16 to 44 soldiers or marines).");
        values.put(Rank_LINK, "http://http://en.wikipedia.org/wiki/Second_Lieutenant_(United_States)#United_States");
        values.put(Rank_Branch, Branch_USMC);

        db.insert(Ranks, null, values);

        values = new ContentValues();

        values.put(Rank_PAY, "O-2");
        values.put(Rank_SHORT, "1stLt");
        values.put(Rank_NAME, "First Lieutenant");
        values.put(Rank_ICON, "first_lieutenant_usmc");
        values.put(Rank_TYPE, "Officer");
        values.put(Rank_DETAILS, "In the United States Army, U.S. Air Force, and U.S. Marine Corps, a first lieutenant is a junior commissioned officer. It is just above the rank of second lieutenant and just below the rank of captain. It is equivalent to the rank of lieutenant (junior grade) in the other uniformed services.  A second lieutenant (grade O-1) is usually promoted to first lieutenant (grade O-2) after 18 months in the Army or 24 months in the Air Force[2] and Marine Corps. ");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/First_Lieutenant_(United_States)#United_States");
        values.put(Rank_Branch, Branch_USMC);

        db.insert(Ranks, null, values);

        values = new ContentValues();

        values.put(Rank_PAY, "O-3");
        values.put(Rank_SHORT, "Capt");
        values.put(Rank_NAME, "Captain");
        values.put(Rank_ICON, "captain_usmc");
        values.put(Rank_TYPE, "Officer");
        values.put(Rank_DETAILS, "In the United States Army, captain is a company grade officer rank, with the pay grade of O-3. It ranks above first lieutenant and below major. It is equivalent to the rank of lieutenant in the naval rank system.  DOPMA guidelines suggest 95% of first lieutenants should be promoted to captain after serving a minimum of two years at their present rank.");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Captain_(United_States_O-3)");
        values.put(Rank_Branch, Branch_USMC);

        db.insert(Ranks, null, values);

        values = new ContentValues();

        values.put(Rank_PAY, "O-4");
        values.put(Rank_SHORT, "Maj");
        values.put(Rank_NAME, "Major ");
        values.put(Rank_ICON, "major_usmc");
        values.put(Rank_TYPE, "Officer");
        values.put(Rank_DETAILS, "In the United States Army, Air Force, and Marine Corps, major is a field grade military officer rank above the rank of captain and below the rank of lieutenant colonel. It is equivalent to the naval rank of lieutenant commander in the other uniformed services.   DOPMA guidelines suggest 80% of captains should be promoted to major after serving a minimum of three years at their present rank and after attaining nine to eleven years of cumulative commissioned service. ");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Major_(United_States)");
        values.put(Rank_Branch, Branch_USMC);

        db.insert(Ranks, null, values);


        values = new ContentValues();

        values.put(Rank_PAY, "O-5");
        values.put(Rank_SHORT, "LtCol");
        values.put(Rank_NAME, "Lieutenant Colonel");
        values.put(Rank_ICON, "lieutenant_colonel_usmc");
        values.put(Rank_TYPE, "Officer");
        values.put(Rank_DETAILS, "In the United States Army, United States Air Force, and United States Marine Corps, a lieutenant colonel is a field grade military officer rank just above the rank of major and just below the rank of colonel. It is equivalent to the naval rank of commander in the other uniformed services.  DOPMA guidelines suggest 70% of majors should be promoted to lieutenant colonel after serving a minimum of three years at their present rank and after attaining 15-17 years of cumulative commissioned service.");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Lieutenant_colonel_(United_States)");
        values.put(Rank_Branch, Branch_USMC);
        db.insert(Ranks, null, values);

        values = new ContentValues();

        values.put(Rank_PAY, "O-6");
        values.put(Rank_SHORT, "COL");
        values.put(Rank_NAME, "Colonel");
        values.put(Rank_ICON, "colonel_usmc");
        values.put(Rank_TYPE, "Officer");
        values.put(Rank_DETAILS, "In the United States Army, Air Force, and Marine Corps, colonel is a senior field grade military officer rank immediately above the rank of lieutenant colonel and immediately below the rank of brigadier general. It is equivalent to the naval rank of captain in the other uniformed services, such as the United States Navy, United States Coast Guard.  DOPMA guidelines suggest 50% of lieutenant colonels should be promoted to colonel after serving a minimum of three years at their present rank and after attaining 21-23 years of cumulative commissioned service. ");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Colonel_(United_States)");
        values.put(Rank_Branch, Branch_USMC);

        db.insert(Ranks, null, values);

        values = new ContentValues();

        values.put(Rank_PAY, "O-7");
        values.put(Rank_SHORT, "BGen");
        values.put(Rank_NAME, "Brigadier General");
        values.put(Rank_ICON, "brigadier_general_usmc");
        values.put(Rank_TYPE, "Officer");
        values.put(Rank_DETAILS, "A brigadier general (BG, Brig Gen, or BGen) is a one-star general officer with the pay grade of O-7 in the United States Army, Air Force, and Marine Corps. Brigadier general ranks above a colonel and below major general. The rank of brigadier general is equivalent to the rank of rear admiral (lower half) in the other United States Navy");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Brigadier_general_(United_States)");
        values.put(Rank_Branch, Branch_USMC);

        db.insert(Ranks, null, values);

        values = new ContentValues();

        values.put(Rank_PAY, "O-8");
        values.put(Rank_SHORT, "MajGen");
        values.put(Rank_NAME, "Major General");
        values.put(Rank_ICON, "major_general");
        values.put(Rank_TYPE, "Officer");
        values.put(Rank_DETAILS, "In the United States Army, United States Marine Corps, and United States Air Force, major general is a two-star general-officer rank, with the pay grade of O-8. Major general ranks above brigadier general and below lieutenant general. Major general is equivalent to the two-star rank of rear admiral in the other United States Navy, and is the highest permanent rank during peacetime in the uniformed services.");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Major_general_(United_States)");
        values.put(Rank_Branch, Branch_USMC);

        db.insert(Ranks, null, values);

        values = new ContentValues();

        values.put(Rank_PAY, "O-9");
        values.put(Rank_SHORT, "LtGen");
        values.put(Rank_NAME, "Lieutenant Genera");
        values.put(Rank_ICON, "lieutenant_general");
        values.put(Rank_TYPE, "Officer");
        values.put(Rank_DETAILS, "In the United States Army, the United States Air Force and the United States Marine Corps, lieutenant general (abbreviated LTG in the Army, Lt Gen in the Air Force, and LtGen in the Marine Corps) is a three-star general officer rank, with the pay grade of O-9. Lieutenant general ranks above major general and below general. Lieutenant general is equivalent to the rank of vice admiral in the United States Navy and United States Coast Guard.");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Lieutenant_general_(United_States)");
        values.put(Rank_Branch, Branch_USMC);

        db.insert(Ranks, null, values);

        values = new ContentValues();

        values.put(Rank_PAY, "O-10");
        values.put(Rank_SHORT, "Gen");
        values.put(Rank_NAME, "General ");
        values.put(Rank_ICON, "general_usmc");
        values.put(Rank_TYPE, "Officer");
        values.put(Rank_DETAILS, "In the United States Army, U.S. Air Force, and U.S. Marine Corps, general is a four-star general officer rank, with the pay grade of O-10. General ranks above lieutenant general and below General of the Army or General of the Air Force; the Marine Corps does not have an established grade above general.  The Marine Corps has no five-star equivalent, the grade of general is currently considered to be the highest appointment an officer can achieve in these three services. ");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/General_(United_States)");
        values.put(Rank_Branch, Branch_USMC);

        db.insert(Ranks, null, values);

        values = new ContentValues();

        values.put(Rank_PAY, "W-1");
        values.put(Rank_SHORT, "WO");
        values.put(Rank_NAME, "Warrant Officer ");
        values.put(Rank_ICON, "warrantofficer1_usmc");
        values.put(Rank_ICON, "Warrant Officer");
        values.put(Rank_DETAILS, "In the United States Armed Forces, the rank of warrant officer (grade W-1 to CW-5) (NATO: WO1-WO5) is rated as an officer above the senior-most enlisted ranks, as well as officer cadets, midshipmen and candidates, but below the officer grade of O-1 (NATO: OF-1). Warrant officers are highly skilled, single-track specialty officers.  For appointment to warrant officer one (W-1), a warrant is approved by the secretary of the respective service.");
        values.put(Rank_LINK, "http://www.google.com");
        values.put(Rank_Branch, Branch_USMC);

        db.insert(Ranks, null, values);

        values = new ContentValues();

        values.put(Rank_PAY, "W-2");
        values.put(Rank_SHORT, "CWO2");
        values.put(Rank_NAME, "Chief Warrant Officer 2");
        values.put(Rank_ICON, "warrantofficer2_usmc");
        values.put(Rank_ICON, "Warrant Officer");
        values.put(Rank_DETAILS, "In the United States Armed Forces, the rank of warrant officer (grade W-1 to CW-5) (NATO: WO1-WO5) is rated as an officer above the senior-most enlisted ranks, as well as officer cadets, midshipmen and candidates, but below the officer grade of O-1 (NATO: OF-1). Warrant officers are highly skilled, single-track specialty officers. For chief warrant officer ranks (W-2 to W-5), warrant officers are commissioned by the President of the United States and take the same oath as regular commissioned officers (O-1 to O-10).");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Warrant_officer_(United_States)");
        values.put(Rank_Branch, Branch_USMC);

        db.insert(Ranks, null, values);

        values = new ContentValues();

        values.put(Rank_PAY, "W-3");
        values.put(Rank_SHORT, "CWO3");
        values.put(Rank_NAME, "Chief Warrant Officer 3");
        values.put(Rank_ICON, "cheifwarrantoffice3_usmc");
        values.put(Rank_ICON, "Warrant Officer");
        values.put(Rank_DETAILS, "In the United States Armed Forces, the rank of warrant officer (grade W-1 to CW-5) (NATO: WO1-WO5) is rated as an officer above the senior-most enlisted ranks, as well as officer cadets, midshipmen and candidates, but below the officer grade of O-1 (NATO: OF-1). Warrant officers are highly skilled, single-track specialty officers.  For appointment to warrant officer one (W-1), a warrant is approved by the secretary of the respective service.");

        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Warrant_officer_(United_States)#Marine_Corps");
        values.put(Rank_Branch, Branch_USMC);

        db.insert(Ranks, null, values);

        values = new ContentValues();

        values.put(Rank_PAY, "W-2");
        values.put(Rank_SHORT, "CWO4");
        values.put(Rank_NAME, "Chief Warrant Officer 4");
        values.put(Rank_ICON, "cheifwarrantoffice4_usmc");
        values.put(Rank_ICON, "Warrant Officer");
        values.put(Rank_DETAILS, "In the United States Armed Forces, the rank of warrant officer (grade W-1 to CW-5) (NATO: WO1-WO5) is rated as an officer above the senior-most enlisted ranks, as well as officer cadets, midshipmen and candidates, but below the officer grade of O-1 (NATO: OF-1). Warrant officers are highly skilled, single-track specialty officers.  For appointment to warrant officer one (W-1), a warrant is approved by the secretary of the respective service.");

        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Warrant_officer_(United_States)#Marine_Corps");
        values.put(Rank_Branch, Branch_USMC);

        db.insert(Ranks, null, values);

        values = new ContentValues();

        values.put(Rank_PAY, "W-2");
        values.put(Rank_SHORT, "CWO5");
        values.put(Rank_NAME, "Chief Warrant Officer 5");
        values.put(Rank_ICON, "cheifwarrantoffice5_usmc");
        values.put(Rank_ICON, "Warrant Officer");
        values.put(Rank_DETAILS, "In the United States Armed Forces, the rank of warrant officer (grade W-1 to CW-5) (NATO: WO1-WO5) is rated as an officer above the senior-most enlisted ranks, as well as officer cadets, midshipmen and candidates, but below the officer grade of O-1 (NATO: OF-1). Warrant officers are highly skilled, single-track specialty officers.  For appointment to warrant officer one (W-1), a warrant is approved by the secretary of the respective service.");

        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Warrant_officer_(United_States)#Marine_Corps");
        values.put(Rank_Branch, Branch_USMC);

        db.insert(Ranks, null, values);

        values = new ContentValues();

        values.put(Rank_PAY, "E-1");
        values.put(Rank_SHORT, "pvt");
        values.put(Rank_NAME, "Private");
        values.put(Rank_ICON, "sunny");
        values.put(Rank_TYPE, "Officer");
        values.put(Rank_DETAILS, "In the United States Marine Corps, the rank of private first class is the second lowest, just under lance corporal and just above private, equivalent to NATO grade OR-2, being pay grade E-2. It was established on June 3, 1916 ] Enlistees that complete United States Marine Corps Recruit Training and had obtained the rank of Young Marine sergeant or above in the Young Marines, will graduate from USMC Recruit Training with the rank of PFC");
        values.put(Rank_LINK, "http://www.google.com");
        values.put(Rank_Branch, Branch_USMC);

        db.insert(Ranks, null, values);

        values = new ContentValues();

        values.put(Rank_PAY, "E-2");
        values.put(Rank_SHORT, "PFC ");
        values.put(Rank_NAME, "Private First Class");
        values.put(Rank_ICON, "pfc_usmc");
        values.put(Rank_TYPE, "Officer");
        values.put(Rank_DETAILS, "In the United States Marine Corps, the rank of private first class is the second lowest, just under lance corporal and just above private, equivalent to NATO grade OR-2, being pay grade E-2. It was established on June 3, 1916 ] Enlistees that complete United States Marine Corps Recruit Training and had obtained the rank of Young Marine sergeant or above in the Young Marines, will graduate from USMC Recruit Training with the rank of PFC");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Private_First_Class#United_States_Marine_Corps");
        values.put(Rank_Branch, Branch_USMC);

        db.insert(Ranks, null, values);

        values = new ContentValues();

        values.put(Rank_PAY, "E-3");
        values.put(Rank_SHORT, "LCpl");
        values.put(Rank_NAME, "Lance Corporal");
        values.put(Rank_ICON, "lcpl_usmc");
        values.put(Rank_TYPE, "Officer");values.put(Rank_DETAILS, "In the United States Marine Corps, the rank of private first class is the second lowest, just under lance corporal and just above private, equivalent to NATO grade OR-2, being pay grade E-2. It was established on June 3, 1916 ] Enlistees that complete United States Marine Corps Recruit Training and had obtained the rank of Young Marine sergeant or above in the Young Marines, will graduate from USMC Recruit Training with the rank of PFC");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Lance_Corporal#United_States");
        values.put(Rank_Branch, Branch_USMC);

        db.insert(Ranks, null, values);

        values = new ContentValues();

        values.put(Rank_PAY, "E-4");
        values.put(Rank_SHORT, "Cpl");
        values.put(Rank_NAME, "Corporal");
        values.put(Rank_ICON, "cpl_usmc");
        values.put(Rank_TYPE, "Officer");
        values.put(Rank_DETAILS, "In the United States Marine Corps, the rank of private first class is the second lowest, just under lance corporal and just above private, equivalent to NATO grade OR-2, being pay grade E-2. It was established on June 3, 1916 ] Enlistees that complete United States Marine Corps Recruit Training and had obtained the rank of Young Marine sergeant or above in the Young Marines, will graduate from USMC Recruit Training with the rank of PFC");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Corporal#United_States_Marine_Corps");
        values.put(Rank_Branch, Branch_USMC);

        db.insert(Ranks, null, values);

        values = new ContentValues();

        values.put(Rank_PAY, "E-5");
        values.put(Rank_SHORT, "Sgt");
        values.put(Rank_NAME, "Sergeant");
        values.put(Rank_ICON, "sgt_usmc");
        values.put(Rank_TYPE, "Officer");
        values.put(Rank_DETAILS, "In the United States Marine Corps, the rank of private first class is the second lowest, just under lance corporal and just above private, equivalent to NATO grade OR-2, being pay grade E-2. It was established on June 3, 1916 ] Enlistees that complete United States Marine Corps Recruit Training and had obtained the rank of Young Marine sergeant or above in the Young Marines, will graduate from USMC Recruit Training with the rank of PFC");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Sergeant#Marine_Corps");
        values.put(Rank_Branch, Branch_USMC);

        db.insert(Ranks, null, values);

        values = new ContentValues();

        values.put(Rank_PAY, "E-6");
        values.put(Rank_SHORT, "SSgt");
        values.put(Rank_NAME, "Staff Sergeant");
        values.put(Rank_ICON, "ssgt_usmc");
        values.put(Rank_TYPE, "Officer");
        values.put(Rank_DETAILS, "In the United States Marine Corps, the rank of private first class is the second lowest, just under lance corporal and just above private, equivalent to NATO grade OR-2, being pay grade E-2. It was established on June 3, 1916 ] Enlistees that complete United States Marine Corps Recruit Training and had obtained the rank of Young Marine sergeant or above in the Young Marines, will graduate from USMC Recruit Training with the rank of PFC");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Staff_Sergeant#United_States");
        values.put(Rank_Branch, Branch_USMC);

        db.insert(Ranks, null, values);

        values = new ContentValues();

        values.put(Rank_PAY, "E-7");
        values.put(Rank_SHORT, "GySgt");
        values.put(Rank_NAME, "Gunnery Sergeant");
        values.put(Rank_ICON, "gysgt_usmc");
        values.put(Rank_TYPE, "Officer");
        values.put(Rank_DETAILS, "In the United States Marine Corps, the rank of private first class is the second lowest, just under lance corporal and just above private, equivalent to NATO grade OR-2, being pay grade E-2. It was established on June 3, 1916 ] Enlistees that complete United States Marine Corps Recruit Training and had obtained the rank of Young Marine sergeant or above in the Young Marines, will graduate from USMC Recruit Training with the rank of PFC");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Gunnery_Sergeant");
        values.put(Rank_Branch, Branch_USMC);

        db.insert(Ranks, null, values);

        values = new ContentValues();

        values.put(Rank_PAY, "E-8");
        values.put(Rank_SHORT, "MSgt");
        values.put(Rank_NAME, "Master Sergeant");
        values.put(Rank_ICON, "msgt_usmc");
        values.put(Rank_TYPE, "Officer");
        values.put(Rank_DETAILS, "In the United States Marine Corps, the rank of private first class is the second lowest, just under lance corporal and just above private, equivalent to NATO grade OR-2, being pay grade E-2. It was established on June 3, 1916 ] Enlistees that complete United States Marine Corps Recruit Training and had obtained the rank of Young Marine sergeant or above in the Young Marines, will graduate from USMC Recruit Training with the rank of PFC");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Master_Sergeant#United_States");
        values.put(Rank_Branch, Branch_USMC);

        db.insert(Ranks, null, values);

        values = new ContentValues();

        values.put(Rank_PAY, "E-8");
        values.put(Rank_SHORT, "1st Sgt");
        values.put(Rank_NAME, "First Sergeant");
        values.put(Rank_ICON, "first_sgt_usmc");
        values.put(Rank_TYPE, "Officer");
        values.put(Rank_DETAILS, "In the United States Marine Corps, the rank of private first class is the second lowest, just under lance corporal and just above private, equivalent to NATO grade OR-2, being pay grade E-2. It was established on June 3, 1916 ] Enlistees that complete United States Marine Corps Recruit Training and had obtained the rank of Young Marine sergeant or above in the Young Marines, will graduate from USMC Recruit Training with the rank of PFC");

        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/First_Sergeant#United_States_Marine_Corps");
        values.put(Rank_Branch, Branch_USMC);

        db.insert(Ranks, null, values);

        values = new ContentValues();

        values.put(Rank_PAY, "E-9");
        values.put(Rank_SHORT, "MGySgt");
        values.put(Rank_NAME, "Master Gunnery Sergeant");
        values.put(Rank_ICON, "mgysgt_usmc");
        values.put(Rank_TYPE, "Officer");
        values.put(Rank_DETAILS, "In the United States Marine Corps, the rank of private first class is the second lowest, just under lance corporal and just above private, equivalent to NATO grade OR-2, being pay grade E-2. It was established on June 3, 1916 ] Enlistees that complete United States Marine Corps Recruit Training and had obtained the rank of Young Marine sergeant or above in the Young Marines, will graduate from USMC Recruit Training with the rank of PFC");

        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Master_Gunnery_Sergeant");
        values.put(Rank_Branch, Branch_USMC);

        db.insert(Ranks, null, values);

        values = new ContentValues();

        values.put(Rank_PAY, "E-9");
        values.put(Rank_SHORT, "SgtMaj");
        values.put(Rank_NAME, "Sergeant Major");
        values.put(Rank_ICON, "sgtmaj_usmc");
        values.put(Rank_TYPE, "Officer");
        values.put(Rank_DETAILS, "In the United States Marine Corps, the rank of private first class is the second lowest, just under lance corporal and just above private, equivalent to NATO grade OR-2, being pay grade E-2. It was established on June 3, 1916 ] Enlistees that complete United States Marine Corps Recruit Training and had obtained the rank of Young Marine sergeant or above in the Young Marines, will graduate from USMC Recruit Training with the rank of PFC");

        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Sergeant_Major#United_States_Marine_Corps");
        values.put(Rank_Branch, Branch_USMC);

        db.insert(Ranks, null, values);

        values = new ContentValues();

        values.put(Rank_PAY, "E-9");
        values.put(Rank_SHORT, "SMMC");
        values.put(Rank_NAME, "Sergeant Major of the Marine Corps");
        values.put(Rank_ICON, "smmc_usmc");
        values.put(Rank_TYPE, "Officer");
        values.put(Rank_DETAILS, "In the United States Marine Corps, the rank of private first class is the second lowest, just under lance corporal and just above private, equivalent to NATO grade OR-2, being pay grade E-2. It was established on June 3, 1916 ] Enlistees that complete United States Marine Corps Recruit Training and had obtained the rank of Young Marine sergeant or above in the Young Marines, will graduate from USMC Recruit Training with the rank of PFC");

        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Sergeant_Major_of_the_Marine_Corps");
        values.put(Rank_Branch, Branch_USMC);

        db.insert(Ranks, null, values);










    }

    public void populateusafranks(SQLiteDatabase db){
        ContentValues values = new ContentValues();



        values.put(Rank_PAY, "0-1");
        values.put(Rank_SHORT, "2ndLt");
        values.put(Rank_NAME, "Second Lieutenant");
        values.put(Rank_ICON, "second_lieutenant_usmc");
        values.put(Rank_TYPE, "Officer");
        values.put(Rank_DETAILS, "In the United States, second lieutenant is the normal entry-level rank for most commissioned officers in the Army, Air Force and Marine Corps and is equivalent to the rank of ensign in the Navy and Coast Guard. In the Air Force, depending upon the career field, a second lieutenant (2d Lt) may supervise flights (of varying sizes) as a flight leader or deputy flight leader, or may work in a variety of administrative positions at the squadron, group, or wing level.");
        values.put(Rank_LINK, "http://http://en.wikipedia.org/wiki/Second_Lieutenant_(United_States)#United_States");
        values.put(Rank_Branch, Branch_USAF);          db.insert(Ranks, null, values);

        values = new ContentValues();

        values.put(Rank_PAY, "O-2");
        values.put(Rank_SHORT, "1stLt");
        values.put(Rank_NAME, "First Lieutenant");
        values.put(Rank_ICON, "first_lieutenant_usmc");
        values.put(Rank_TYPE, "Officer");
        values.put(Rank_DETAILS, "In the United States Army, U.S. Air Force, and U.S. Marine Corps, a first lieutenant is a junior commissioned officer. It is just above the rank of second lieutenant and just below the rank of captain. It is equivalent to the rank of lieutenant (junior grade) in the other uniformed services.  A second lieutenant (grade O-1) is usually promoted to first lieutenant (grade O-2) after 18 months in the Army or 24 months in the Air Force[2] and Marine Corps. ");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/First_Lieutenant_(United_States)#United_States");
        values.put(Rank_Branch, Branch_USAF);          db.insert(Ranks, null, values);
        values = new ContentValues();

        values.put(Rank_PAY, "O-3");
        values.put(Rank_SHORT, "Capt");
        values.put(Rank_NAME, "Captain");
        values.put(Rank_ICON, "captain_usmc");
        values.put(Rank_TYPE, "Officer");
        values.put(Rank_DETAILS, "In the United States Army, captain is a company grade officer rank, with the pay grade of O-3. It ranks above first lieutenant and below major. It is equivalent to the rank of lieutenant in the naval rank system.  DOPMA guidelines suggest 95% of first lieutenants should be promoted to captain after serving a minimum of two years at their present rank.");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Captain_(United_States_O-3)");
        values.put(Rank_Branch, Branch_USAF);          db.insert(Ranks, null, values);
        values = new ContentValues();

        values.put(Rank_PAY, "O-4");
        values.put(Rank_SHORT, "Maj");
        values.put(Rank_NAME, "Major ");
        values.put(Rank_ICON, "major_usmc");
        values.put(Rank_TYPE, "Officer");
        values.put(Rank_DETAILS, "In the United States Army, Air Force, and Marine Corps, major is a field grade military officer rank above the rank of captain and below the rank of lieutenant colonel. It is equivalent to the naval rank of lieutenant commander in the other uniformed services.   DOPMA guidelines suggest 80% of captains should be promoted to major after serving a minimum of three years at their present rank and after attaining nine to eleven years of cumulative commissioned service. ");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Major_(United_States)");
        values.put(Rank_Branch, Branch_USAF);          db.insert(Ranks, null, values);
        values = new ContentValues();

        values.put(Rank_PAY, "O-5");
        values.put(Rank_SHORT, "LtCol");
        values.put(Rank_NAME, "Lieutenant Colonel");
        values.put(Rank_ICON, "lieutenant_colonel_usmc");
        values.put(Rank_TYPE, "Officer");
        values.put(Rank_DETAILS, "In the United States Army, United States Air Force, and United States Marine Corps, a lieutenant colonel is a field grade military officer rank just above the rank of major and just below the rank of colonel. It is equivalent to the naval rank of commander in the other uniformed services.  DOPMA guidelines suggest 70% of majors should be promoted to lieutenant colonel after serving a minimum of three years at their present rank and after attaining 15-17 years of cumulative commissioned service.");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Lieutenant_colonel_(United_States)");
        values.put(Rank_Branch, Branch_USAF);          db.insert(Ranks, null, values);
        values = new ContentValues();

        values.put(Rank_PAY, "O-6");
        values.put(Rank_SHORT, "COL");
        values.put(Rank_NAME, "Colonel");
        values.put(Rank_ICON, "colonel_usmc");
        values.put(Rank_TYPE, "Officer");
        values.put(Rank_DETAILS, "In the United States Army, Air Force, and Marine Corps, colonel is a senior field grade military officer rank immediately above the rank of lieutenant colonel and immediately below the rank of brigadier general. It is equivalent to the naval rank of captain in the other uniformed services, such as the United States Navy, United States Coast Guard.  DOPMA guidelines suggest 50% of lieutenant colonels should be promoted to colonel after serving a minimum of three years at their present rank and after attaining 21-23 years of cumulative commissioned service. ");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Colonel_(United_States)");
        values.put(Rank_Branch, Branch_USAF);          db.insert(Ranks, null, values);
        values = new ContentValues();

        values.put(Rank_PAY, "O-7");
        values.put(Rank_SHORT, "BGen");
        values.put(Rank_NAME, "Brigadier General");
        values.put(Rank_ICON, "brigadier_general_usmc");
        values.put(Rank_TYPE, "Officer");
        values.put(Rank_DETAILS, "A brigadier general (BG, Brig Gen, or BGen) is a one-star general officer with the pay grade of O-7 in the United States Army, Air Force, and Marine Corps. Brigadier general ranks above a colonel and below major general. The rank of brigadier general is equivalent to the rank of rear admiral (lower half) in the other United States Navy");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Brigadier_general_(United_States)");
        values.put(Rank_Branch, Branch_USAF);          db.insert(Ranks, null, values);
        values = new ContentValues();

        values.put(Rank_PAY, "O-8");
        values.put(Rank_SHORT, "MajGen");
        values.put(Rank_NAME, "Major General");
        values.put(Rank_ICON, "major_general");
        values.put(Rank_TYPE, "Officer");
        values.put(Rank_DETAILS, "In the United States Army, United States Marine Corps, and United States Air Force, major general is a two-star general-officer rank, with the pay grade of O-8. Major general ranks above brigadier general and below lieutenant general. Major general is equivalent to the two-star rank of rear admiral in the other United States Navy, and is the highest permanent rank during peacetime in the uniformed services.");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Major_general_(United_States)");
        values.put(Rank_Branch, Branch_USAF);          db.insert(Ranks, null, values);
        values = new ContentValues();

        values.put(Rank_PAY, "O-9");
        values.put(Rank_SHORT, "LtGen");
        values.put(Rank_NAME, "Lieutenant General");
        values.put(Rank_ICON, "lieutenant_general");
        values.put(Rank_TYPE, "Officer");
        values.put(Rank_DETAILS, "In the United States Army, the United States Air Force and the United States Marine Corps, lieutenant general (abbreviated LTG in the Army, Lt Gen in the Air Force, and LtGen in the Marine Corps) is a three-star general officer rank, with the pay grade of O-9. Lieutenant general ranks above major general and below general. Lieutenant general is equivalent to the rank of vice admiral in the United States Navy and United States Coast Guard.");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Lieutenant_general_(United_States)");
        values.put(Rank_Branch, Branch_USAF);          db.insert(Ranks, null, values);
        values = new ContentValues();

        values.put(Rank_PAY, "O-10");
        values.put(Rank_SHORT, "Gen");
        values.put(Rank_NAME, "General ");
        values.put(Rank_ICON, "general_usmc");
        values.put(Rank_TYPE, "Officer");
        values.put(Rank_DETAILS, "In the United States Army, U.S. Air Force, and U.S. Marine Corps, general is a four-star general officer rank, with the pay grade of O-10. General ranks above lieutenant general and below General of the Army or General of the Air Force; the Marine Corps does not have an established grade above general.  The Marine Corps has no five-star equivalent, the grade of general is currently considered to be the highest appointment an officer can achieve in these three services. ");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/General_(United_States)");
        values.put(Rank_Branch, Branch_USAF);          db.insert(Ranks, null, values);
        values = new ContentValues();

        values.put(Rank_PAY, "special");
        values.put(Rank_SHORT, "GAF");
        values.put(Rank_NAME, "General Of The AirForce ");
        values.put(Rank_ICON, "gaf_usaf");
        values.put(Rank_TYPE, "Officer");
        values.put(Rank_DETAILS, "General of the Air Force (GAF) is a five-star general officer rank and is the highest possible rank in the United States Air Force. General of the Air Force ranks immediately above a general and is equivalent to General of the Army in the United States Army and Fleet Admiral in the United States Navy; there is no established equivalent five-star rank in the other four uniformed services (Marine Corps, Coast Guard, PHSCC, and NOAA Corps).");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/General_of_the_Air_Force_(United_States)");
        values.put(Rank_Branch, Branch_USAF);          db.insert(Ranks, null, values);
        values = new ContentValues();

        values.put(Rank_PAY, "E-1");
        values.put(Rank_SHORT, "AB");
        values.put(Rank_NAME, "Airman Basic");
        values.put(Rank_ICON, "sunny");
        values.put(Rank_TYPE, "Enlisted");
        values.put(Rank_DETAILS, "Airman basic (AB) is the lowest enlisted rank in the United States Air Force (USAF), immediately below airman. The pay grade for airman basic is E-1. As opposed to all other USAF enlisted and officer ranks, airman basic has no rank insignia affiliated.[1][2] The lack of uniform insignia for airmen basic is the reason for the nickname 'slick-sleeve'; all other enlisted Air Force ranks wear stripes and chevrons on their uniform sleeves.");

        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Airman_Basic");
        values.put(Rank_Branch, Branch_USAF);          db.insert(Ranks, null, values);
        values = new ContentValues();

        values.put(Rank_PAY, "E-2");
        values.put(Rank_SHORT, "Amn");
        values.put(Rank_NAME, "Airman");
        values.put(Rank_ICON, "airman_usaf");
        values.put(Rank_TYPE, "Enlisted");
        values.put(Rank_DETAILS, "An airman is a member of the United States Air Force. The rank of airman (abbreviated 'AMN') is the second enlisted rank from the bottom, just above the rank of airman basic, and just below that of airman first class. A person with the rank of airman basic is typically promoted to the rank of airman after six months of active duty service in the Air Force, if that member had signed up for an enlistment period of at least four years of active duty.  ");

        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Airman");
        values.put(Rank_Branch, Branch_USAF);          db.insert(Ranks, null, values);
        values = new ContentValues();

        values.put(Rank_PAY, "E-3");
        values.put(Rank_SHORT, "A1c");
        values.put(Rank_NAME, "Airman First Class");
        values.put(Rank_ICON, "airman_first_class");
        values.put(Rank_TYPE, "Enlisted");
        values.put(Rank_DETAILS, "Airman first class (A1C) is the third enlisted rank (E-3) in the United States Air Force, just above airman and below senior airman. The rank of airman first class is considered a junior enlisted rank, with the non-commissioned officers and senior non-commissioned officers above it. Airman first class is a rank that has also been used by the U.S. Navy and the U.S. Coast Guard, although it is not currently in use. In documents about the history of U.S. armed forces, you will frequently see this rank abbreviated as 'ARM1c'.");

        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Airman_First_Class");
        values.put(Rank_Branch, Branch_USAF);          db.insert(Ranks, null, values);
        values = new ContentValues();

        values.put(Rank_PAY, "E-4");
        values.put(Rank_SHORT, "SrA");
        values.put(Rank_NAME, "Senior Airman");
        values.put(Rank_ICON, "sra_usaf");
        values.put(Rank_TYPE, "Enlisted");
        values.put(Rank_DETAILS, "Senior airman (SrA) is the fourth enlisted rank in the United States Air Force, just above airman first class and below staff sergeant. It has a pay grade of E-4. The Air Force promotes an airman first class (A1C) to senior airman after 36 months time in service (TIS) and 20 months time in grade (TIG), or 28 months TIG, whichever occurs first. ");

        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Senior_Airman");
        values.put(Rank_Branch, Branch_USAF);          db.insert(Ranks, null, values);
        values = new ContentValues();

        values.put(Rank_PAY, "E-5");
        values.put(Rank_SHORT, "SSgt");
        values.put(Rank_NAME, "Staff Sergeant");
        values.put(Rank_ICON, "staff_sergeant_usaf");
        values.put(Rank_TYPE, "Enlisted");
        values.put(Rank_DETAILS, "Staff sergeant (SSgt) is E-5 in the U.S. Air Force. It ranks just above senior airman and below technical sergeant. It is the Air Force's first non-commissioned officer rank, as well as the first Air Force rank to which promotion is attained on a competitive basis. Sergeants, also known in Air Force jargon as 'buck sergeant', no longer exist, having been eliminated in the 1990s after sharing the same pay grade with that of the rank of senior airman (E-4). Staff sergeants are expected to be technically proficient and function as first-line supervisors within a 'work center'.");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Staff_Sergeant#U.S._Air_Force");
        values.put(Rank_Branch, Branch_USAF);          db.insert(Ranks, null, values);
        values = new ContentValues();

        values.put(Rank_PAY, "E-6");
        values.put(Rank_SHORT, "TSgt");
        values.put(Rank_NAME, "Technical Sergeant");
        values.put(Rank_ICON, "technical_sergeant_usaf");
        values.put(Rank_TYPE, "Enlisted");
        values.put(Rank_DETAILS, "Technical Sergeant, commonly shortened to 'Tech Sergeant' in a somewhat informal parlance, is the sixth enlisted rank (pay grade E-6) in the U.S. Air Force, just above staff sergeant and below master sergeant. A technical sergeant is a noncommissioned officer and abbreviated as TSgt (with no period in official USAF and other military correspondence). Official terms of address are 'Technical Sergeant' or 'Sergeant', although many use 'Tech Sergeant'.   It normally takes 10–12 total years of service to attain this pay grade  ");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Technical_Sergeant");
        values.put(Rank_Branch, Branch_USAF);          db.insert(Ranks, null, values);
        values = new ContentValues();

        values.put(Rank_PAY, "E-7");
        values.put(Rank_SHORT, "MSgt");
        values.put(Rank_NAME, "Master Sergeant");
        values.put(Rank_ICON, "master_sergeant_usaf");
        values.put(Rank_TYPE, "Enlisted");
        values.put(Rank_DETAILS, "The seventh enlisted rank in the U.S. Air Force, just above technical sergeant and below senior master sergeant. It is abbreviated as MSgt. Advancement to master sergeant is one of the most significant promotions within the enlisted Air Force. At the rank of master sergeant, the airman enters the senior non-commissioned tier and his or her duties begin to focus on leadership and management rather than technical performance.");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Master_Sergeant#United_States");
        values.put(Rank_Branch, Branch_USAF);          db.insert(Ranks, null, values);
        values = new ContentValues();

        values.put(Rank_PAY, "E-7 through E-9");
        values.put(Rank_SHORT, "First Sergeant");
        values.put(Rank_NAME, "Master Sergeant, Senior Master Sergeant and Chief Master Sergeant");
        values.put(Rank_ICON, "first_sergeant_usaf");
        values.put(Rank_TYPE, "Enlisted");
        values.put(Rank_DETAILS, "In the United States Air Force, First Sergeant is not a rank, but a special duty held by a senior enlisted member of a military unit who reports directly to the unit commander. This billet is held by individuals of pay grades E-7 through E-9 (Master Sergeant, Senior Master Sergeant and Chief Master Sergeant), and is denoted on the rank insignia by a lozenge (known colloquially as a 'diamond'). Often referred to as the 'first shirt', or 'shirt', the first sergeant is responsible for the morale, welfare, and conduct of all the enlisted members in a squadron and is the chief adviser to the squadron commander concerning the enlisted force.");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/First_sergeant#United_States_Air_Force");
        values.put(Rank_Branch, Branch_USAF);          db.insert(Ranks, null, values);
        values = new ContentValues();

        values.put(Rank_PAY, "E-8");
        values.put(Rank_SHORT, "SMSgt");
        values.put(Rank_NAME, "Senior Master Sergeant");
        values.put(Rank_ICON, "senior_master_sergeant_usaf");
        values.put(Rank_TYPE, "Enlisted");
        values.put(Rank_DETAILS, "Senior master sergeant (SMSgt) is the eighth enlisted rank (pay grade E-8) in the U.S. Air Force, just above master sergeant and below chief master sergeant and is a senior noncommissioned officer (SNCO).  Promotion to senior master sergeant is the most difficult enlisted promotion to attain in the Air Force. It is the first enlisted grade to which results of a central promotion board are the primary factor in selection for promotion. Usually, less than ten percent of eligible master sergeants are selected for promotion to senior master sergeant in most years.  ");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Senior_Master_Sergeant");
        values.put(Rank_Branch, Branch_USAF);          db.insert(Ranks, null, values);
        values = new ContentValues();

        values.put(Rank_PAY, "E-9");
        values.put(Rank_SHORT, "CMSgt");
        values.put(Rank_NAME, "Chief Master Sergeant");
        values.put(Rank_ICON, "chief_master_sergeant_usaf");
        values.put(Rank_TYPE, "Enlisted");
        values.put(Rank_DETAILS, "Chief Master Sergeant (CMSgt) is the ninth, and highest, enlisted rank in the U.S. Air Force, just above Senior Master Sergeant, and is a senior non-commissioned officer rank. The official term is 'Chief Master Sergeant' or 'Chief'.  Attaining the rank of Chief Master Sergeant is the pinnacle of an Air Force enlisted person's career. Some Chief Master Sergeants manage the efforts of all enlisted personnel within their unit or major subsection while others run major staff functions at higher headquarters levels. By federal law, roughly one percent of the Air Force enlisted force may hold the rank of chief master sergeant. ");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Chief_Master_Sergeant");
        values.put(Rank_Branch, Branch_USAF);          db.insert(Ranks, null, values);

        values = new ContentValues();

        values.put(Rank_PAY, "E-9");
        values.put(Rank_SHORT, "CCMSgt");
        values.put(Rank_NAME, "Command Chief Master Sergeant");
        values.put(Rank_ICON, "command_chief_master_sergeant_usaf");
        values.put(Rank_TYPE, "Enlisted");
        values.put(Rank_DETAILS, "The position of Command Chief Master Sergeant (CCMSgt) was renamed in November 1998. Formerly titled senior enlisted advisor, Command Chief Master Sergeants serve as senior advisors to commanders at key levels of command; these include Wings, Numbered Air Forces, Field Operating Agencies, and Major Commands.");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Command_Chief_Master_Sergeant#Command_Chief_Master_Sergeant");
        values.put(Rank_Branch, Branch_USAF);          db.insert(Ranks, null, values);
        values = new ContentValues();

        values.put(Rank_PAY, "E-9");
        values.put(Rank_SHORT, "CMSAF");
        values.put(Rank_NAME, "Chief Master Sergeant of the Air Force");
        values.put(Rank_ICON, "chief_master_sergeant_of_the_air_force");
        values.put(Rank_TYPE, "Enlisted");
        values.put(Rank_DETAILS, "The Chief Master Sergeant of the Air Force (CMSAF) is a unique non-commissioned rank in the United States Air Force. The holder of this rank and post represents the highest enlisted level of leadership in the Air Force, and as such, provides direction for the enlisted corps and represents their interests, as appropriate, to the American public, and to those in all levels of government. The CMSAF is appointed by the Air Force Chief of Staff (AF/CC) and serves as the senior enlisted advisor to the Air Force Chief of Staff and the Secretary of the Air Force on all issues regarding the welfare, readiness, morale, and proper utilization and progress of the enlisted force. While the CMSAF is a non-commissioned officer, the billet is protocol equivalent to a lieutenant general.");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Chief_Master_Sergeant_of_the_Air_Force");
        values.put(Rank_Branch, Branch_USAF);          db.insert(Ranks, null, values);













    }

    public void populateusarmyranks(SQLiteDatabase db){
        ContentValues values = new ContentValues();



        values.put(Rank_PAY, "0-1");
        values.put(Rank_SHORT, "2ndLt");
        values.put(Rank_NAME, "Second Lieutenant");
        values.put(Rank_ICON, "second_lieutenant_usmc");
        values.put(Rank_TYPE, "Officer");
        values.put(Rank_DETAILS, "In the United States, second lieutenant is the normal entry-level rank for most commissioned officers in the Army, Air Force and Marine Corps and is equivalent to the rank of ensign in the Navy and Coast Guard. In the Air Force, depending upon the career field, a second lieutenant (2d Lt) may supervise flights (of varying sizes) as a flight leader or deputy flight leader, or may work in a variety of administrative positions at the squadron, group, or wing level.");
        values.put(Rank_LINK, "http://http://en.wikipedia.org/wiki/Second_Lieutenant_(United_States)#United_States");
        values.put(Rank_Branch, Branch_USAF);

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
        values1.put(MOS_RANK, "2ndLt-LtCol");

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
        populateusafranks(db);
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
