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
    public static final String MOS_Link = "mos_link";







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
            + MOS_TYPE + " text not null, " + MOS_RANK + " text not null, " + MOS_Link + " text, " + MOS_TITLE + " references " + MOSTITLES + ");";

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
        values.put(Rank_TYPE, "Warrant Officer");
        values.put(Rank_DETAILS, "In the United States Armed Forces, the rank of warrant officer (grade W-1 to CW-5) (NATO: WO1-WO5) is rated as an officer above the senior-most enlisted ranks, as well as officer cadets, midshipmen and candidates, but below the officer grade of O-1 (NATO: OF-1). Warrant officers are highly skilled, single-track specialty officers.  For appointment to warrant officer one (W-1), a warrant is approved by the secretary of the respective service.");
        values.put(Rank_LINK, "http://www.google.com");
        values.put(Rank_Branch, Branch_USMC);

        db.insert(Ranks, null, values);

        values = new ContentValues();

        values.put(Rank_PAY, "W-2");
        values.put(Rank_SHORT, "CWO2");
        values.put(Rank_NAME, "Chief Warrant Officer 2");
        values.put(Rank_ICON, "chiefwarrantofficer2_usmc");
        values.put(Rank_TYPE, "Warrant Officer");
        values.put(Rank_DETAILS, "In the United States Armed Forces, the rank of warrant officer (grade W-1 to CW-5) (NATO: WO1-WO5) is rated as an officer above the senior-most enlisted ranks, as well as officer cadets, midshipmen and candidates, but below the officer grade of O-1 (NATO: OF-1). Warrant officers are highly skilled, single-track specialty officers. For chief warrant officer ranks (W-2 to W-5), warrant officers are commissioned by the President of the United States and take the same oath as regular commissioned officers (O-1 to O-10).");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Warrant_officer_(United_States)");
        values.put(Rank_Branch, Branch_USMC);

        db.insert(Ranks, null, values);

        values = new ContentValues();

        values.put(Rank_PAY, "W-3");
        values.put(Rank_SHORT, "CWO3");
        values.put(Rank_NAME, "Chief Warrant Officer 3");
        values.put(Rank_ICON, "chiefwarrantofficer3_usmc");
        values.put(Rank_TYPE, "Warrant Officer");
        values.put(Rank_DETAILS, "In the United States Armed Forces, the rank of warrant officer (grade W-1 to CW-5) (NATO: WO1-WO5) is rated as an officer above the senior-most enlisted ranks, as well as officer cadets, midshipmen and candidates, but below the officer grade of O-1 (NATO: OF-1). Warrant officers are highly skilled, single-track specialty officers.  For appointment to warrant officer one (W-1), a warrant is approved by the secretary of the respective service.");

        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Warrant_officer_(United_States)#Marine_Corps");
        values.put(Rank_Branch, Branch_USMC);

        db.insert(Ranks, null, values);

        values = new ContentValues();

        values.put(Rank_PAY, "W-4");
        values.put(Rank_SHORT, "CWO4");
        values.put(Rank_NAME, "Chief Warrant Officer 4");
        values.put(Rank_ICON, "chiefwarrantofficer4_usmc");
        values.put(Rank_TYPE, "Warrant Officer");
        values.put(Rank_DETAILS, "In the United States Armed Forces, the rank of warrant officer (grade W-1 to CW-5) (NATO: WO1-WO5) is rated as an officer above the senior-most enlisted ranks, as well as officer cadets, midshipmen and candidates, but below the officer grade of O-1 (NATO: OF-1). Warrant officers are highly skilled, single-track specialty officers.  For appointment to warrant officer one (W-1), a warrant is approved by the secretary of the respective service.");

        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Warrant_officer_(United_States)#Marine_Corps");
        values.put(Rank_Branch, Branch_USMC);

        db.insert(Ranks, null, values);

        values = new ContentValues();

        values.put(Rank_PAY, "W-5");
        values.put(Rank_SHORT, "CWO5");
        values.put(Rank_NAME, "Chief Warrant Officer 5");
        values.put(Rank_ICON, "chiefwarrantofficer5_usmc");
        values.put(Rank_TYPE, "Warrant Officer");
        values.put(Rank_DETAILS, "In the United States Armed Forces, the rank of warrant officer (grade W-1 to CW-5) (NATO: WO1-WO5) is rated as an officer above the senior-most enlisted ranks, as well as officer cadets, midshipmen and candidates, but below the officer grade of O-1 (NATO: OF-1). Warrant officers are highly skilled, single-track specialty officers.  For appointment to warrant officer one (W-1), a warrant is approved by the secretary of the respective service.");

        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Warrant_officer_(United_States)#Marine_Corps");
        values.put(Rank_Branch, Branch_USMC);

        db.insert(Ranks, null, values);

        values = new ContentValues();

        values.put(Rank_PAY, "E-1");
        values.put(Rank_SHORT, "pvt");
        values.put(Rank_NAME, "Private");
        values.put(Rank_ICON, "sunny");
        values.put(Rank_TYPE, "Enlisted");
        values.put(Rank_DETAILS, "In the United States Marine Corps, the rank of private first class is the second lowest, just under lance corporal and just above private, equivalent to NATO grade OR-2, being pay grade E-2. It was established on June 3, 1916 ] Enlistees that complete United States Marine Corps Recruit Training and had obtained the rank of Young Marine sergeant or above in the Young Marines, will graduate from USMC Recruit Training with the rank of PFC");
        values.put(Rank_LINK, "http://www.google.com");
        values.put(Rank_Branch, Branch_USMC);

        db.insert(Ranks, null, values);

        values = new ContentValues();

        values.put(Rank_PAY, "E-2");
        values.put(Rank_SHORT, "PFC ");
        values.put(Rank_NAME, "Private First Class");
        values.put(Rank_ICON, "pfc_usmc");
        values.put(Rank_TYPE, "Enlisted");
        values.put(Rank_DETAILS, "In the United States Marine Corps, the rank of private first class is the second lowest, just under lance corporal and just above private, equivalent to NATO grade OR-2, being pay grade E-2. It was established on June 3, 1916 ] Enlistees that complete United States Marine Corps Recruit Training and had obtained the rank of Young Marine sergeant or above in the Young Marines, will graduate from USMC Recruit Training with the rank of PFC");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Private_First_Class#United_States_Marine_Corps");
        values.put(Rank_Branch, Branch_USMC);

        db.insert(Ranks, null, values);

        values = new ContentValues();

        values.put(Rank_PAY, "E-3");
        values.put(Rank_SHORT, "LCpl");
        values.put(Rank_NAME, "Lance Corporal");
        values.put(Rank_ICON, "lcpl_usmc");
        values.put(Rank_TYPE, "Enlisted");
        values.put(Rank_DETAILS, "In the United States Marine Corps, the rank of private first class is the second lowest, just under lance corporal and just above private, equivalent to NATO grade OR-2, being pay grade E-2. It was established on June 3, 1916 ] Enlistees that complete United States Marine Corps Recruit Training and had obtained the rank of Young Marine sergeant or above in the Young Marines, will graduate from USMC Recruit Training with the rank of PFC");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Lance_Corporal#United_States");
        values.put(Rank_Branch, Branch_USMC);

        db.insert(Ranks, null, values);

        values = new ContentValues();

        values.put(Rank_PAY, "E-4");
        values.put(Rank_SHORT, "Cpl");
        values.put(Rank_NAME, "Corporal");
        values.put(Rank_ICON, "cpl_usmc");
        values.put(Rank_TYPE, "Enlisted");
        values.put(Rank_DETAILS, "In the United States Marine Corps, the rank of private first class is the second lowest, just under lance corporal and just above private, equivalent to NATO grade OR-2, being pay grade E-2. It was established on June 3, 1916 ] Enlistees that complete United States Marine Corps Recruit Training and had obtained the rank of Young Marine sergeant or above in the Young Marines, will graduate from USMC Recruit Training with the rank of PFC");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Corporal#United_States_Marine_Corps");
        values.put(Rank_Branch, Branch_USMC);

        db.insert(Ranks, null, values);

        values = new ContentValues();

        values.put(Rank_PAY, "E-5");
        values.put(Rank_SHORT, "Sgt");
        values.put(Rank_NAME, "Sergeant");
        values.put(Rank_ICON, "sgt_usmc");
        values.put(Rank_TYPE, "Enlisted");
        values.put(Rank_DETAILS, "In the United States Marine Corps, the rank of private first class is the second lowest, just under lance corporal and just above private, equivalent to NATO grade OR-2, being pay grade E-2. It was established on June 3, 1916 ] Enlistees that complete United States Marine Corps Recruit Training and had obtained the rank of Young Marine sergeant or above in the Young Marines, will graduate from USMC Recruit Training with the rank of PFC");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Sergeant#Marine_Corps");
        values.put(Rank_Branch, Branch_USMC);

        db.insert(Ranks, null, values);

        values = new ContentValues();

        values.put(Rank_PAY, "E-6");
        values.put(Rank_SHORT, "SSgt");
        values.put(Rank_NAME, "Staff Sergeant");
        values.put(Rank_ICON, "ssgt_usmc");
        values.put(Rank_TYPE, "Enlisted");
        values.put(Rank_DETAILS, "In the United States Marine Corps, the rank of private first class is the second lowest, just under lance corporal and just above private, equivalent to NATO grade OR-2, being pay grade E-2. It was established on June 3, 1916 ] Enlistees that complete United States Marine Corps Recruit Training and had obtained the rank of Young Marine sergeant or above in the Young Marines, will graduate from USMC Recruit Training with the rank of PFC");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Staff_Sergeant#United_States");
        values.put(Rank_Branch, Branch_USMC);

        db.insert(Ranks, null, values);

        values = new ContentValues();

        values.put(Rank_PAY, "E-7");
        values.put(Rank_SHORT, "GySgt");
        values.put(Rank_NAME, "Gunnery Sergeant");
        values.put(Rank_ICON, "gysgt_usmc");
        values.put(Rank_TYPE, "Enlisted");
        values.put(Rank_DETAILS, "In the United States Marine Corps, the rank of private first class is the second lowest, just under lance corporal and just above private, equivalent to NATO grade OR-2, being pay grade E-2. It was established on June 3, 1916 ] Enlistees that complete United States Marine Corps Recruit Training and had obtained the rank of Young Marine sergeant or above in the Young Marines, will graduate from USMC Recruit Training with the rank of PFC");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Gunnery_Sergeant");
        values.put(Rank_Branch, Branch_USMC);

        db.insert(Ranks, null, values);

        values = new ContentValues();

        values.put(Rank_PAY, "E-8");
        values.put(Rank_SHORT, "MSgt");
        values.put(Rank_NAME, "Master Sergeant");
        values.put(Rank_ICON, "msgt_usmc");
        values.put(Rank_TYPE, "Enlisted");
        values.put(Rank_DETAILS, "In the United States Marine Corps, the rank of private first class is the second lowest, just under lance corporal and just above private, equivalent to NATO grade OR-2, being pay grade E-2. It was established on June 3, 1916 ] Enlistees that complete United States Marine Corps Recruit Training and had obtained the rank of Young Marine sergeant or above in the Young Marines, will graduate from USMC Recruit Training with the rank of PFC");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Master_Sergeant#United_States");
        values.put(Rank_Branch, Branch_USMC);

        db.insert(Ranks, null, values);

        values = new ContentValues();

        values.put(Rank_PAY, "E-8");
        values.put(Rank_SHORT, "1st Sgt");
        values.put(Rank_NAME, "First Sergeant");
        values.put(Rank_ICON, "first_sgt_usmc");
        values.put(Rank_TYPE, "Enlisted");
        values.put(Rank_DETAILS, "In the United States Marine Corps, the rank of private first class is the second lowest, just under lance corporal and just above private, equivalent to NATO grade OR-2, being pay grade E-2. It was established on June 3, 1916 ] Enlistees that complete United States Marine Corps Recruit Training and had obtained the rank of Young Marine sergeant or above in the Young Marines, will graduate from USMC Recruit Training with the rank of PFC");

        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/First_Sergeant#United_States_Marine_Corps");
        values.put(Rank_Branch, Branch_USMC);

        db.insert(Ranks, null, values);

        values = new ContentValues();

        values.put(Rank_PAY, "E-9");
        values.put(Rank_SHORT, "MGySgt");
        values.put(Rank_NAME, "Master Gunnery Sergeant");
        values.put(Rank_ICON, "mgysgt_usmc");
        values.put(Rank_TYPE, "Enlisted");
        values.put(Rank_DETAILS, "In the United States Marine Corps, the rank of private first class is the second lowest, just under lance corporal and just above private, equivalent to NATO grade OR-2, being pay grade E-2. It was established on June 3, 1916 ] Enlistees that complete United States Marine Corps Recruit Training and had obtained the rank of Young Marine sergeant or above in the Young Marines, will graduate from USMC Recruit Training with the rank of PFC");

        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Master_Gunnery_Sergeant");
        values.put(Rank_Branch, Branch_USMC);

        db.insert(Ranks, null, values);

        values = new ContentValues();

        values.put(Rank_PAY, "E-9");
        values.put(Rank_SHORT, "SgtMaj");
        values.put(Rank_NAME, "Sergeant Major");
        values.put(Rank_ICON, "sgtmaj_usmc");
        values.put(Rank_TYPE, "Enlisted");
        values.put(Rank_DETAILS, "In the United States Marine Corps, the rank of private first class is the second lowest, just under lance corporal and just above private, equivalent to NATO grade OR-2, being pay grade E-2. It was established on June 3, 1916 ] Enlistees that complete United States Marine Corps Recruit Training and had obtained the rank of Young Marine sergeant or above in the Young Marines, will graduate from USMC Recruit Training with the rank of PFC");

        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Sergeant_Major#United_States_Marine_Corps");
        values.put(Rank_Branch, Branch_USMC);

        db.insert(Ranks, null, values);

        values = new ContentValues();

        values.put(Rank_PAY, "E-9");
        values.put(Rank_SHORT, "SMMC");
        values.put(Rank_NAME, "Sergeant Major of the Marine Corps");
        values.put(Rank_ICON, "smmc_usmc");
        values.put(Rank_TYPE, "Enlisted");
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



        values.put(Rank_PAY,"0-1");
        values.put(Rank_SHORT, "2ndLt");
        values.put(Rank_NAME, "Second Lieutenant");
        values.put(Rank_ICON, "second_lieutenant_usmc");
        values.put(Rank_TYPE, "Officer");
        values.put(Rank_DETAILS, "In the United States, second lieutenant is the normal entry-level rank for most commissioned officers in the Army, Air Force and Marine Corps and is equivalent to the rank of ensign in the Navy and Coast Guard. In the Army and Marine Corps, a second lieutenant typically leads a platoon-size element (16 to 44 soldiers or marines).");
        values.put(Rank_LINK, "http://http://en.wikipedia.org/wiki/Second_Lieutenant_(United_States)#United_States");
        values.put(Rank_Branch, Branch_USARMY);

        db.insert(Ranks, null, values);

        values = new ContentValues();

        values.put(Rank_PAY,"O-2");
        values.put(Rank_SHORT, "1stLt");
        values.put(Rank_NAME, "First Lieutenant");
        values.put(Rank_ICON, "first_lieutenant_usmc");
        values.put(Rank_TYPE, "Officer");
        values.put(Rank_DETAILS, "In the United States Army, U.S. Air Force, and U.S. Marine Corps, a first lieutenant is a junior commissioned officer. It is just above the rank of second lieutenant and just below the rank of captain. It is equivalent to the rank of lieutenant (junior grade) in the other uniformed services.  A second lieutenant (grade O-1) is usually promoted to first lieutenant (grade O-2) after 18 months in the Army or 24 months in the Air Force[2] and Marine Corps. ");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/First_Lieutenant_(United_States)#United_States");
        values.put(Rank_Branch, Branch_USARMY);
        db.insert(Ranks, null, values);
        values = new ContentValues();

        values.put(Rank_PAY,"O-3");
        values.put(Rank_SHORT, "Capt");
        values.put(Rank_NAME, "Captain");
        values.put(Rank_ICON, "captain_usmc");
        values.put(Rank_TYPE, "Officer");
        values.put(Rank_DETAILS, "In the United States Army, captain is a company grade officer rank, with the pay grade of O-3. It ranks above first lieutenant and below major. It is equivalent to the rank of lieutenant in the naval rank system.  DOPMA guidelines suggest 95% of first lieutenants should be promoted to captain after serving a minimum of two years at their present rank.");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Captain_(United_States_O-3)");
        values.put(Rank_Branch, Branch_USARMY);          db.insert(Ranks, null, values);
        values = new ContentValues();

        values.put(Rank_PAY,"O-4");
        values.put(Rank_SHORT, "Maj");
        values.put(Rank_NAME, "Major ");
        values.put(Rank_ICON, "major_usmc");
        values.put(Rank_TYPE, "Officer");
        values.put(Rank_DETAILS, "In the United States Army, Air Force, and Marine Corps, major is a field grade military officer rank above the rank of captain and below the rank of lieutenant colonel. It is equivalent to the naval rank of lieutenant commander in the other uniformed services.   DOPMA guidelines suggest 80% of captains should be promoted to major after serving a minimum of three years at their present rank and after attaining nine to eleven years of cumulative commissioned service. ");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Major_(United_States)");
        values.put(Rank_Branch, Branch_USARMY);          db.insert(Ranks, null, values);
        values = new ContentValues();

        values.put(Rank_PAY,"O-5");
        values.put(Rank_SHORT, "LtCol");
        values.put(Rank_NAME, "Lieutenant Colonel");
        values.put(Rank_ICON, "lieutenant_colonel_usmc");
        values.put(Rank_TYPE, "Officer");
        values.put(Rank_DETAILS, "In the United States Army, United States Air Force, and United States Marine Corps, a lieutenant colonel is a field grade military officer rank just above the rank of major and just below the rank of colonel. It is equivalent to the naval rank of commander in the other uniformed services.  DOPMA guidelines suggest 70% of majors should be promoted to lieutenant colonel after serving a minimum of three years at their present rank and after attaining 15-17 years of cumulative commissioned service.");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Lieutenant_colonel_(United_States)");
        values.put(Rank_Branch, Branch_USARMY);          db.insert(Ranks, null, values);
        values = new ContentValues();

        values.put(Rank_PAY,"O-6");
        values.put(Rank_SHORT, "COL");
        values.put(Rank_NAME, "Colonel");
        values.put(Rank_ICON, "colonel_usmc");
        values.put(Rank_TYPE, "Officer");
        values.put(Rank_DETAILS, "In the United States Army, Air Force, and Marine Corps, colonel is a senior field grade military officer rank immediately above the rank of lieutenant colonel and immediately below the rank of brigadier general. It is equivalent to the naval rank of captain in the other uniformed services, such as the United States Navy, United States Coast Guard.  DOPMA guidelines suggest 50% of lieutenant colonels should be promoted to colonel after serving a minimum of three years at their present rank and after attaining 21-23 years of cumulative commissioned service. ");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Colonel_(United_States)");
        values.put(Rank_Branch, Branch_USARMY);          db.insert(Ranks, null, values);
        values = new ContentValues();

        values.put(Rank_PAY,"O-7");
        values.put(Rank_SHORT, "BGen");
        values.put(Rank_NAME, "Brigadier General");
        values.put(Rank_ICON, "brigadier_general_usmc");
        values.put(Rank_TYPE, "Officer");
        values.put(Rank_DETAILS, "A brigadier general (BG, Brig Gen, or BGen) is a one-star general officer with the pay grade of O-7 in the United States Army, Air Force, and Marine Corps. Brigadier general ranks above a colonel and below major general. The rank of brigadier general is equivalent to the rank of rear admiral (lower half) in the other United States Navy");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Brigadier_general_(United_States)");
        values.put(Rank_Branch, Branch_USARMY);          db.insert(Ranks, null, values);
        values = new ContentValues();

        values.put(Rank_PAY,"O-8");
        values.put(Rank_SHORT, "MajGen");
        values.put(Rank_NAME, "Major General");
        values.put(Rank_ICON, "major_general");
        values.put(Rank_TYPE, "Officer");
        values.put(Rank_DETAILS, "In the United States Army, United States Marine Corps, and United States Air Force, major general is a two-star general-officer rank, with the pay grade of O-8. Major general ranks above brigadier general and below lieutenant general. Major general is equivalent to the two-star rank of rear admiral in the other United States Navy, and is the highest permanent rank during peacetime in the uniformed services.");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Major_general_(United_States)");
        values.put(Rank_Branch, Branch_USARMY);          db.insert(Ranks, null, values);
        values = new ContentValues();

        values.put(Rank_PAY,"O-9");
        values.put(Rank_SHORT, "LtGen");
        values.put(Rank_NAME, "Lieutenant General");
        values.put(Rank_ICON, "lieutenant_general");
        values.put(Rank_TYPE, "Officer");
        values.put(Rank_DETAILS, "In the United States Army, the United States Air Force and the United States Marine Corps, lieutenant general (abbreviated LTG in the Army, Lt Gen in the Air Force, and LtGen in the Marine Corps) is a three-star general officer rank, with the pay grade of O-9. Lieutenant general ranks above major general and below general. Lieutenant general is equivalent to the rank of vice admiral in the United States Navy and United States Coast Guard.");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Lieutenant_general_(United_States)");
        values.put(Rank_Branch, Branch_USARMY);          db.insert(Ranks, null, values);
        values = new ContentValues();

        values.put(Rank_PAY,"O-10");
        values.put(Rank_SHORT, "Gen");
        values.put(Rank_NAME, "General ");
        values.put(Rank_ICON, "general_usmc");
        values.put(Rank_TYPE, "Officer");
        values.put(Rank_DETAILS, "In the United States Army, U.S. Air Force, and U.S. Marine Corps, general is a four-star general officer rank, with the pay grade of O-10. General ranks above lieutenant general and below General of the Army or General of the Air Force; the Marine Corps does not have an established grade above general.  The Marine Corps has no five-star equivalent, the grade of general is currently considered to be the highest appointment an officer can achieve in these three services. ");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/General_(United_States)");
        values.put(Rank_Branch, Branch_USARMY);          db.insert(Ranks, null, values);
        values = new ContentValues();

        values.put(Rank_PAY,"special");
        values.put(Rank_SHORT, "GA");
        values.put(Rank_NAME, "General Of The Army ");
        values.put(Rank_ICON, "gaf_usaf");
        values.put(Rank_TYPE, "Officer");
        values.put(Rank_DETAILS, "General of the Army (GA)[1] is a five-star general officer and is the second highest possible rank in the United States Army. A special rank of General of the Armies, which ranks above General of the Army, does exist but has only been conferred twice in the history of the Army. A General of the Army ranks immediately above a general and is equivalent to a fleet admiral and a general of the Air Force.  Often referred to as a 'five-star general', the rank of General of the Army has historically been reserved for wartime use and is not currently active in the U.S. military.");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/General_of_the_Army_(United_States)");
        values.put(Rank_Branch, Branch_USARMY);          db.insert(Ranks, null, values);
        values = new ContentValues();

        values.put(Rank_PAY,"W-1");
        values.put(Rank_SHORT, "WO1");
        values.put(Rank_NAME, "Warrant Officer 1");
        values.put(Rank_ICON, "wo1_usarmy");
        values.put(Rank_TYPE, "Warrant Officer");
        values.put(Rank_DETAILS, "Appointed by warrant from the Secretary of the Army, WO1s are technically and tactically focused officers who perform the primary duties of technical leader, trainer, operator, manager, maintainer, sustainer, and advisor.");

        values.put(Rank_LINK, "http://www.google.com");     values.put(Rank_Branch, Branch_USARMY);          db.insert(Ranks, null, values);
        values = new ContentValues();

        values.put(Rank_PAY,"W-2");
        values.put(Rank_SHORT, "CWO2");
        values.put(Rank_NAME, "Chief Warrant Officer 2");
        values.put(Rank_ICON, "cw2_usarmy");
        values.put(Rank_TYPE, "Warrant Officer");
        values.put(Rank_DETAILS, "CW2s become commissioned officers by the President of the United States. They are intermediate-level technical and tactical experts who perform increased duties and responsibilities at the detachment through battalion levels.");

        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Warrant_Officer_(United_States)#Army");
        values.put(Rank_Branch, Branch_USARMY);          db.insert(Ranks, null, values);
        values = new ContentValues();

        values.put(Rank_PAY,"W-3");
        values.put(Rank_SHORT, "CWO3");
        values.put(Rank_NAME, "Chief Warrant Officer 3");
        values.put(Rank_ICON, "cw3_usarmy");
        values.put(Rank_TYPE, "Warrant Officer");
        values.put(Rank_DETAILS, "CW3s are advanced-level experts who perform the primary duties of a technical and tactical leader. They provide direction, guidance, resources, assistance, and supervision necessary for subordinates to perform their duties. They primarily support operations levels from team or detachment through brigade.");

        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Warrant_Officer_(United_States)#Army");
        values.put(Rank_Branch, Branch_USARMY);          db.insert(Ranks, null, values);
        values = new ContentValues();

        values.put(Rank_PAY,"W-2");
        values.put(Rank_SHORT, "CWO4");
        values.put(Rank_NAME, "Chief Warrant Officer 4");
        values.put(Rank_ICON, "cw4_usarmy");
        values.put(Rank_TYPE, "Warrant Officer");
        values.put(Rank_DETAILS, "CW4s are senior-level experts in their chosen field, primarily supporting battalion, brigade, division, corps, and echelons above corps operations. They typically have special mentorship responsibilities for other WOs and provide essential advice to commanders on WO issues.");

        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Warrant_Officer_(United_States)#Army");
        values.put(Rank_Branch, Branch_USARMY);          db.insert(Ranks, null, values);
        values = new ContentValues();

        values.put(Rank_PAY,"W-2");
        values.put(Rank_SHORT, "CWO5");
        values.put(Rank_NAME, "Chief Warrant Officer 5");
        values.put(Rank_ICON, "cw5_usarmy");
        values.put(Rank_TYPE, "Warrant Officer");
        values.put(Rank_DETAILS, "CW5s are master-level experts that support brigade, division, corps, echelons above corps, and major command operations. They provide leader development, mentorship, advice, and counsel to warrant officers and branch officers. CW5s have special warrant officer leadership and representation responsibilities within their respective commands.");

        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Warrant_Officer_(United_States)#Army");
        values.put(Rank_Branch, Branch_USARMY);
        db.insert(Ranks, null, values);

        values = new ContentValues();

        values.put(Rank_PAY,"E-1");
        values.put(Rank_SHORT, "PV1");
        values.put(Rank_NAME, "Private");
        values.put(Rank_ICON, "sunny");
        values.put(Rank_TYPE, "Enlisted");
        values.put(Rank_DETAILS, "In the U.S. Army, private is used for the two lowest enlisted ranks, just below private first class. The lowest rank is 'private E-1' (PVT) and sometimes referred to as recruit, but also held by some soldiers after punishment through the Uniform Code of Military Justice or prisoners after conviction until they are discharged. A PVT wears no uniform insignia; since the advent of the Army Combat Uniform, the term 'fuzzy' has come into vogue, referring to the blank velcro patch on the ACU where the rank would normally be placed.");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Private_(United_States)#United_States");
        values.put(Rank_Branch, Branch_USARMY);
        db.insert(Ranks, null, values);
        values = new ContentValues();

        values.put(Rank_PAY,"E-2");
        values.put(Rank_SHORT, "PV2 ");
        values.put(Rank_NAME, "Private");
        values.put(Rank_ICON, "pv2_usarmy");
        values.put(Rank_TYPE, "Enlisted");
        values.put(Rank_DETAILS, "The second rank, private E-2 (PV2), wears a single chevron, known colloquially as 'mosquito wings'. Advancement to the PV2 is automatic after six months time in service, but may get shortened to four months if given a waiver. A person who earned the Eagle Scout award, the Gold Award, or completed at least two years of JROTC may enlist at anytime at the rank of PV2.[5] The term of address, 'Private', may be properly applied to any Army soldier E-1 (PVT) to E-3 (PFC).");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Private_(United_States)#United_States");
        values.put(Rank_Branch, Branch_USARMY);
        db.insert(Ranks, null, values);
        values = new ContentValues();

        values.put(Rank_PAY,"E-3");
        values.put(Rank_SHORT, "PFC");
        values.put(Rank_NAME, "Private First Class");
        values.put(Rank_ICON, "pfc_usarmy");
        values.put(Rank_TYPE, "Enlisted");
        values.put(Rank_DETAILS, " Private first class (E-3), equivalent to NATO grade OR-3, is designated by a single chevron and a rocker stripe and is more common among soldiers who have served in the U.S. Army for one year or more. Soldiers who have achieved an associate degree or its equivalent are entitled to enter the Army at this pay grade.[3] Advancement from private first class is typically to specialist, although occasionally it may be to corporal.");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Private_First_Class#United_States_Army");
        values.put(Rank_Branch, Branch_USARMY);
        db.insert(Ranks, null, values);
        values = new ContentValues();

        values.put(Rank_PAY,"E-4");
        values.put(Rank_SHORT, "SPC");
        values.put(Rank_NAME, "Specialist");
        values.put(Rank_ICON, "spc_usarmy");
        values.put(Rank_TYPE, "Enlisted");
        values.put(Rank_DETAILS, "Specialist (abbreviated 'SPC') is one of the four junior enlisted ranks in the U.S. Army. Unlike corporals, specialists are not considered junior non-commissioned officers (NCOs).   The rank of specialist is the typical rank to which privates first class are promoted after two years of service, although PFCs may be waivered into the rank of specialist after 18 months time in service and 6 months time in grade. It is granted far more often than corporal (E-4), which is now reserved for personnel who have either passed the leadership development course or have been assigned low-level supervisory (with two or more soldiers under direct command).");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Specialist_(rank)");
        values.put(Rank_Branch, Branch_USARMY);
        db.insert(Ranks, null, values);
        values = new ContentValues();

        values.put(Rank_PAY,"E-4");
        values.put(Rank_SHORT, "Cpl");
        values.put(Rank_NAME, "Corporal");
        values.put(Rank_ICON, "cpl_usarmy");
        values.put(Rank_TYPE, "Enlisted");
        values.put(Rank_DETAILS, "In the U.S. Army corporal is preceded by the first three forms of private and the rank of specialist.[9] A corporal rank shares the same pay grade (E-4) as a specialist. Unlike a specialist, however, a corporal is a non-commissioned officer and may direct the activities of other soldiers.[10] A soldier may be promoted to corporal directly from the rank of private first class or laterally promoted from specialist. ");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Corporal#United_States_Army");
        values.put(Rank_Branch, Branch_USARMY);
        db.insert(Ranks, null, values);
        values = new ContentValues();

        values.put(Rank_PAY,"E-5");
        values.put(Rank_SHORT, "Sgt");
        values.put(Rank_NAME, "Sergeant");
        values.put(Rank_ICON, "sgt_usarmy");
        values.put(Rank_TYPE, "Enlisted");
        values.put(Rank_DETAILS, "Sergeant is the enlisted rank in the U.S. Army above specialist and corporal and below staff sergeant, and is the second-lowest grade of non-commissioned officer. The rank was often nicknamed 'buck sergeant' to distinguish it from other senior grades of sergeants.[6] Sergeants in the infantry, for example, lead fire teams of four men. There are two fire teams in a 9-man rifle squad, which is led by a staff sergeant.");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Sergeant#United_States");
        values.put(Rank_Branch, Branch_USARMY);
        db.insert(Ranks, null, values);
        values = new ContentValues();

        values.put(Rank_PAY,"E-6");
        values.put(Rank_SHORT, "SSgt");
        values.put(Rank_NAME, "Staff Sergeant");
        values.put(Rank_ICON, "ssgt_usarmy");
        values.put(Rank_TYPE, "Enlisted");
        values.put(Rank_DETAILS, "Staff sergeant (SSG) is E-6 rank in the U.S. Army, just above sergeant and below sergeant first class, and is a non-commissioned officer. Staff sergeants are generally placed in charge of squads, but can also act as platoon sergeants in the absence of a sergeant first class. In support units, staff sergeants ordinarily hold headquarters positions. Staff sergeants are referred to as 'Sergeant' except for in certain training environments and schools.");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Staff_Sergeant#United_States");
        values.put(Rank_Branch, Branch_USARMY);
        db.insert(Ranks, null, values);
        values = new ContentValues();

        values.put(Rank_PAY,"E-7");
        values.put(Rank_SHORT, "SFC");
        values.put(Rank_NAME, "Sergeant First Class");
        values.put(Rank_ICON, "sfc_usarmy");
        values.put(Rank_TYPE, "Enlisted");
        values.put(Rank_DETAILS, "Sergeant first class (SFC) is the seventh enlisted rank (E-7) in the U.S. Army, ranking above staff sergeant (E-6) and below master sergeant and first sergeant (E-8), and is the first non-commissioned officer rank designated as a senior non-commissioned officer (SNCO).  A sergeant first class is typically assigned as a platoon sergeant at the company level or battalion operations noncommissioned officer in charge at the battalion level, but may also hold other positions depending on the type of unit. In a combat arms role, a sergeant first class is typically in charge of from 18 soldiers and four tanks in an armor platoon to 40 soldiers in a rifle platoon. A sergeant first class' primary responsibility is training and mentoring lieutenants, tactical logistics, tactical casualty evacuations, and being senior tactical advisor to the platoon leader.");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Sergeant_First_Class");
        values.put(Rank_Branch, Branch_USARMY);
        db.insert(Ranks, null, values);
        values = new ContentValues();

        values.put(Rank_PAY,"E-8");
        values.put(Rank_SHORT, "MSgt");
        values.put(Rank_NAME, "Master Sergeant");
        values.put(Rank_ICON, "msg_usarmy");
        values.put(Rank_TYPE, "Enlisted");
        values.put(Rank_DETAILS, "The eighth enlisted rank in the U.S. Army, just above sergeant first class, below sergeant major, command sergeant major, Sergeant Major of the Army and equal in grade but not authority to first sergeant.   A master sergeant is typically assigned as a brigade-level section noncommissioned officer in charge and serves as the subject matter expert in his or her field, but may also hold other positions depending on the type of unit.");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Master_Sergeant#United_States");
        values.put(Rank_Branch, Branch_USARMY);
        db.insert(Ranks, null, values);
        values = new ContentValues();

        values.put(Rank_PAY,"E-8");
        values.put(Rank_SHORT, "1st Sgt");
        values.put(Rank_NAME, "First Sergeant");
        values.put(Rank_ICON, "first_sgt_usarmy");
        values.put(Rank_TYPE, "Enlisted");
        values.put(Rank_DETAILS, "In the United States Army, the rank of First Sergeant (abbreviated 1SG) is an OR8/E8 rank above the rank of Sergeant First Class (OR7), and below the rank of Sergeant Major. It is equal in grade to Master Sergeant, although the two ranks have different responsibilities, with a First Sergeant being senior to a Master Sergeant.  Master sergeants are laterally promoted to first sergeant upon selection by the senior leadership at Department of the Army, depending on available billets and opportunities. Commonly referred to as 'first shirt', 'top', 'top sergeant', 'top soldier', 'top kick', or 'top hat', due to their seniority and their position at the top of the company's enlisted ranks. ");

        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Top_sergeant#United_States_Army");
        values.put(Rank_Branch, Branch_USARMY);
        db.insert(Ranks, null, values);
        values = new ContentValues();

        values.put(Rank_PAY,"E-9");
        values.put(Rank_SHORT, "SGM");
        values.put(Rank_NAME, "Sergeant Major");
        values.put(Rank_ICON, "sgm_usarmy");
        values.put(Rank_TYPE, "Enlisted");
        values.put(Rank_DETAILS, "In the U.S. Army, sergeant major (SGM) refers to both a military rank and a specific leadership position. It is the highest enlisted rank, just above first sergeant and master sergeant, with a pay grade of E-9, NATO rank OR-9.Both the SGM and CSM are referred to, and addressed as, 'Sergeant Major'. The Sergeant Major of the Army is a separate and unique position, but is still addressed as 'Sergeant Major'.");

        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Command_Sergeant_Major#United_States_Army");
        values.put(Rank_Branch, Branch_USARMY);
        db.insert(Ranks, null, values);
        values = new ContentValues();

        values.put(Rank_PAY,"E-9");
        values.put(Rank_SHORT, "CSM");
        values.put(Rank_NAME, "Command Sergeant Major");
        values.put(Rank_ICON, "csm_usarmy");
        values.put(Rank_TYPE, "Enlisted");
        values.put(Rank_DETAILS, " command sergeant major (CSM) — is the senior enlisted advisor to the commanding officer. The leadership position carries with it certain ceremonial functions such as caring for the unit's colors (flag). Additionally, CSMs serve as monitors of, and advocates for, the enlisted soldiers in the command. This position mostly exists in units of battalion size and larger. Because the CSM represents all of the enlisted soldiers in the command, he or she does not wear the collar insignia of his or her career specialty (e.g., infantry, quartermaster, intelligence, inter alia), but instead wears the CSM (formerly 'branch immaterial') collar insignia. The insignia is a gold-color rendering of the coat of arms of the United States; like the branch of service insignia of all U.S. Army enlisted soldiers, it is placed upon a gold-colored metal disk, one inch in diameter. ");

        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Command_Sergeant_Major#United_States_Army");
        values.put(Rank_Branch, Branch_USARMY);
        db.insert(Ranks, null, values);
        values = new ContentValues();

        values.put(Rank_PAY,"E-9");
        values.put(Rank_SHORT, "SMA");
        values.put(Rank_NAME, "Sergeant Major of the Army");
        values.put(Rank_ICON, "sma_usarmy");
        values.put(Rank_TYPE, "Enlisted");
        values.put(Rank_DETAILS, "The Sergeant Major of the Army (SMA) is a unique non-commissioned rank in the United States Army. The holder of this rank and position is the most senior enlisted member of the Army, unless an army sergeant is serving as the senior enlisted advisor to the Chairman of the Joint Chiefs of Staff, in which case he would be the most senior enlisted man and the SMA will be the second-most senior enlisted member of the army. The SMA is appointed to serve as a spokesman to address the issues of enlisted soldiers to all officers. While the SMA is a non-commissioned officer, the billet is the protocol equivalent of a lieutenant general.");

        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Sergeant_Major_of_the_Armys");
        values.put(Rank_Branch, Branch_USARMY);
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








    }

    public void populateusnavyranks(SQLiteDatabase db){


        ContentValues values = new ContentValues();

        values.put(Rank_PAY,"0-1");
        values.put(Rank_SHORT, "ENS");
        values.put(Rank_NAME, "Ensign");
        values.put(Rank_ICON, "ens_usnavy");
        values.put(Rank_TYPE, "Officer");
        values.put(Rank_DETAILS, "In the United States Navy, the rank of 'ensign' superseded 'passed midshipman' in 1862. Ensign is the junior commissioned officer rank in the United States Navy, the United States Coast Guard, the National Oceanic and Atmospheric Administration Commissioned Officer Corps, and the PHS Commissioned Corps. This rank is also used in the U.S. Maritime Service and the U.S. Naval Sea Cadet Corps. Ensign ranks below lieutenant junior grade, and it is equivalent to a second lieutenant in the U.S. Army, the Marine Corps, and the Air Force.");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Ensign_(rank)#United_States");

        values.put(Rank_Branch, Branch_USNAVY);
        db.insert(Ranks, null, values);

        values = new ContentValues();

                values.put(Rank_PAY,"0-2");
        values.put(Rank_SHORT, "LTJG");
        values.put(Rank_NAME, "lieutenant(junior grade)");
        values.put(Rank_ICON, "ltjg_usnavy");
        values.put(Rank_TYPE, "Officer");
        values.put(Rank_DETAILS, "Lieutenant (junior grade) (LTJG) is a junior commissioned officer rank in the United States Navy.  Lieutenant, junior grade ranks above ensign and below lieutenant and is equivalent to a first lieutenant in the other uniformed services (the Army, Marine Corps and Air Force).  Lieutenant, junior grade is often referred to colloquially as JG ('Jay-Gee'). Prior to March 3, 1883, this rank was known in the Navy as master.  ");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Lieutenant_(junior_grade)");
        values.put(Rank_Branch, Branch_USNAVY);          db.insert(Ranks, null, values);
        values = new ContentValues();

                values.put(Rank_PAY,"0-3");
        values.put(Rank_SHORT, "LT");
        values.put(Rank_NAME, "lieutenant");
        values.put(Rank_ICON, "lt_usnavy");
        values.put(Rank_TYPE, "Officer");
        values.put(Rank_DETAILS, "Lieutenant[nb 1] (abbreviated Lt, LT, LT(N), Lieut and LEUT, depending on nation) is a commissioned officer rank in many nations' navies. It is typically the most senior of junior officer ranks. The rank's insignia usually consists of two medium gold braid stripes and often the uppermost stripe features a loop or executive curl.  ");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Lieutenant_(navy)");
        values.put(Rank_Branch, Branch_USNAVY);          db.insert(Ranks, null, values);
        values = new ContentValues();

                values.put(Rank_PAY,"0-4");
        values.put(Rank_SHORT, "LCDR");
        values.put(Rank_NAME, "lieutenant Commander");
        values.put(Rank_ICON, "lcdr_usnavy");
        values.put(Rank_TYPE, "Officer");
        values.put(Rank_DETAILS, "Lieutenant commander (LCDR) is a mid-ranking officer rank in the United States Navy, the United States Coast Guard, the United States Public Health Service Commissioned Corps, and the National Oceanic and Atmospheric Administration Commissioned Officer Corps, with the pay grade of O-4. Lieutenant commanders rank above lieutenants and below commanders. The rank is also used in the United States Maritime Service and the United States Naval Sea Cadet Corps, and is equivalent to a major in the other uniformed services.  DOPMA guidelines suggest 80% of lieutenants should be promoted to lieutenant commander after serving a minimum of three years at their present rank and after attaining nine to eleven years of cumulative commissioned service.  ");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Lieutenant_commander_(United_States))");
        values.put(Rank_Branch, Branch_USNAVY);          db.insert(Ranks, null, values);
        values = new ContentValues();

                values.put(Rank_PAY,"0-5");
        values.put(Rank_SHORT, "CDR");
        values.put(Rank_NAME, "Commander");
        values.put(Rank_ICON, "cdr_usnavy");
        values.put(Rank_TYPE, "Officer");
        values.put(Rank_DETAILS, "In the United States Navy, the United States Coast Guard, the United States Public Health Service Commissioned Corps, and the National Oceanic and Atmospheric Administration Commissioned Officer Corps, commander (abbreviated 'CDR') is a senior officer rank, with the pay grade of O-5. Commander ranks above lieutenant commander and below captain. Commander is equivalent to the rank of lieutenant colonel in the other uniformed services.  DOPMA guidelines suggest 70% of lieutenant commanders should be promoted to commander after serving a minimum of three years at their present rank and after attaining 15-17 years of cumulative commissioned service.");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Commander_(United_States)#Naval_rank");
        values.put(Rank_Branch, Branch_USNAVY);          db.insert(Ranks, null, values);
        values = new ContentValues();

                values.put(Rank_PAY,"0-6");
        values.put(Rank_SHORT, "CAPT");
        values.put(Rank_NAME, "Captain");
        values.put(Rank_ICON, "capt_usnavy");
        values.put(Rank_TYPE, "Officer");
        values.put(Rank_DETAILS, "In the United States Navy, captain (abbreviated CAPT) is a senior officer rank, with the pay grade of O-6. It ranks above commander and below rear admiral (lower half). It is equivalent to the rank of colonel in the other uniformed services.  DOPMA guidelines suggest that no more than 50% of eligible commanders should be promoted to captain after serving a minimum of three years at their present rank and after attaining 21–23 years of cumulative commissioned service. Navy captains with sea commands in the surface warfare officer community generally command ships of cruiser size or larger. ");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Captain_(United_States_O-6)");
        values.put(Rank_Branch, Branch_USNAVY);          db.insert(Ranks, null, values);
        values = new ContentValues();

                values.put(Rank_PAY,"0-7");
        values.put(Rank_SHORT, "RDML");
        values.put(Rank_NAME, "Rear Admiral(lower half)");
        values.put(Rank_ICON, "rdml_usnavy");
        values.put(Rank_TYPE, "Officer");
        values.put(Rank_DETAILS, "In the United States Navy, rear admiral (lower half) is a one-star flag officer, with the pay grade of O-7.  Rear admiral (lower half) ranks above captain and below rear admiral. Rear admiral (lower half) is equivalent to the rank of brigadier general in the other uniformed services.   ");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Rear_admiral_(United_States)#Rear_admiral_.28lower_half.29");
        values.put(Rank_Branch, Branch_USNAVY);          db.insert(Ranks, null, values);
        values = new ContentValues();

                values.put(Rank_PAY,"0-8");
        values.put(Rank_SHORT, "RADM");
        values.put(Rank_NAME, "Rear Admiral");
        values.put(Rank_ICON, "radm_usnavy");
        values.put(Rank_TYPE, "Officer");
        values.put(Rank_DETAILS, "In the United States Navy, the United States Coast Guard,rear admiral(RADM), also sometimes referred to as rear admiral (upper half), is a two-star flag officer, with the pay grade of O-8. Rear admiral ranks above rear admiral (lower half) and below vice admiral. Rear admiral is equivalent to the rank of major general in the other uniformed services. It is the highest permanent rank during peacetime in the uniformed services; all higher ranks are temporary ranks linked to specific commands or office.");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Rear_admiral_(United_States)#Rear_admiral");
        values.put(Rank_Branch, Branch_USNAVY);          db.insert(Ranks, null, values);
        values = new ContentValues();

                values.put(Rank_PAY,"0-9");
        values.put(Rank_SHORT, "VADM");
        values.put(Rank_NAME, "Rear Admiral");
        values.put(Rank_ICON, "vadm_usnavy");
        values.put(Rank_TYPE, "Officer");
        values.put(Rank_DETAILS, "In the United States Navy, vice admiral (VADM) is a three-star flag officer, with the pay grade of O-9. For the Navy, no more than 16.7% of the service's active-duty flag officers may have more than two stars. Vice admiral ranks above rear admiral and below admiral. Vice admiral is equivalent to the rank of lieutenant general in the other uniformed services.");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Vice_admiral_(United_States)");
        values.put(Rank_Branch, Branch_USNAVY);          db.insert(Ranks, null, values);
        values = new ContentValues();

                values.put(Rank_PAY,"0-9");
        values.put(Rank_SHORT, "ADM");
        values.put(Rank_NAME, "Admiral");
        values.put(Rank_ICON, "adm_usnavy");
        values.put(Rank_TYPE, "Officer");
        values.put(Rank_DETAILS, "In the United States Navy, admiral (ADM) is a four-star flag officer rank, with the pay grade of O-10. Admiral ranks above vice admiral and below fleet admiral in the navy. Admiral is equivalent to the rank of general in the other uniformed services.  Since the five-star grade of fleet admiral is reserved for wartime use only, the grade of admiral is considered to be the highest appointment an officer can achieve in the United States Navy.  ");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Admiral_(United_States)");
        values.put(Rank_Branch, Branch_USNAVY);          db.insert(Ranks, null, values);
        values = new ContentValues();

                values.put(Rank_PAY,"0-10");
        values.put(Rank_SHORT, "ADM");
        values.put(Rank_NAME, "Fleet Admiral");
        values.put(Rank_ICON, "fadm_usnavy");
        values.put(Rank_TYPE, "Officer");
        values.put(Rank_DETAILS, "Fleet admiral (FADM)[1] was a five-star flag officer rank in the United States Navy, and was in its time the highest rank attainable in the service. Fleet admiral ranked immediately above admiral and was equivalent to general of the Army and general of the Air Force. The United States rank of fleet admiral was created by an Act of Congress for four officers to hold on a temporary basis under Pub.L. 78-482 on December 14, 1944,.[2] The rank was made permanent for the four individual holders only by Pub.L. 79–333 on March 23, 1946, but that law made no provisions to establish the rank itself permanently. ");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Fleet_Admiral_(United_States)");
        values.put(Rank_Branch, Branch_USNAVY);          db.insert(Ranks, null, values);
        values = new ContentValues();

                values.put(Rank_PAY,"special grade");
        values.put(Rank_SHORT, "ADM");
        values.put(Rank_NAME, "Admiral Of The Navy");
        values.put(Rank_ICON, "adm_usnavy");
        values.put(Rank_TYPE, "Officer");
        values.put(Rank_DETAILS, "Admiral of the Navy is a rank in the United States Navy that has only been held once in history, by George Dewey. In recognition of his victory at Manila Bay in 1898.  The rank Admiral of the Navy was seen as a six-star rank during World War II,[2] with the establishment of the rank of five-star fleet admiral. It was during this time that the Department of the Navy specified that the new 1944 version of the rank of fleet admiral was to be junior to Dewey's rank of Admiral of the Navy.    ");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Admiral_of_the_Navy_(United_States)");
        values.put(Rank_Branch, Branch_USNAVY);          db.insert(Ranks, null, values);
        values = new ContentValues();

                values.put(Rank_PAY,"W-2");
        values.put(Rank_SHORT, "CWO-2");
        values.put(Rank_NAME, "Chief Warrant Officer Two");
        values.put(Rank_ICON, "cwo2_usnavy");
        values.put(Rank_TYPE, "Warrant Officer");
        values.put(Rank_DETAILS, "In the United States Navy, the chief warrant officer (CWO) rank is a technical specialist who directs specific activities essential to the proper operation of the ship, which also require commissioned officer authority.[1] Navy CWOs serve in 30 specialties covering five categories. CWO should not be confused with the limited duty officer in the Navy.");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Warrant_Officer_(United_States)");
        values.put(Rank_Branch, Branch_USNAVY);          db.insert(Ranks, null, values);
        values = new ContentValues();

                values.put(Rank_PAY,"W-3");
        values.put(Rank_SHORT, "CWO-3");
        values.put(Rank_NAME, "Chief Warrant Officer Three");
        values.put(Rank_ICON, "cwo3_usnavy");
        values.put(Rank_TYPE, "Warrant Officer");
        values.put(Rank_DETAILS, "In the United States Navy, the chief warrant officer (CWO) rank is a technical specialist who directs specific activities essential to the proper operation of the ship, which also require commissioned officer authority.[1] Navy CWOs serve in 30 specialties covering five categories. CWO should not be confused with the limited duty officer in the Navy.");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Warrant_Officer_(United_States)");
        values.put(Rank_Branch, Branch_USNAVY);          db.insert(Ranks, null, values);
        values = new ContentValues();

                values.put(Rank_PAY,"W-4");
        values.put(Rank_SHORT, "CWO-4");
        values.put(Rank_NAME, "Chief Warrant Officer Four");
        values.put(Rank_ICON, "cwo4_usnavy");
        values.put(Rank_TYPE, "Warrant Officer");
        values.put(Rank_DETAILS, "In the United States Navy, the chief warrant officer (CWO) rank is a technical specialist who directs specific activities essential to the proper operation of the ship, which also require commissioned officer authority.[1] Navy CWOs serve in 30 specialties covering five categories. CWO should not be confused with the limited duty officer in the Navy.");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Warrant_Officer_(United_States)");
        values.put(Rank_Branch, Branch_USNAVY);          db.insert(Ranks, null, values);
        values = new ContentValues();

                values.put(Rank_PAY,"W-5");
        values.put(Rank_SHORT, "CWO-5");
        values.put(Rank_NAME, "Chief Warrant Officer Five");
        values.put(Rank_ICON, "cwo5_usnavy");
        values.put(Rank_TYPE, "Warrant Officer");
        values.put(Rank_DETAILS, "In the United States Navy, the chief warrant officer (CWO) rank is a technical specialist who directs specific activities essential to the proper operation of the ship, which also require commissioned officer authority.[1] Navy CWOs serve in 30 specialties covering five categories. CWO should not be confused with the limited duty officer in the Navy.");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Warrant_Officer_(United_States)");
        values.put(Rank_Branch, Branch_USNAVY);          db.insert(Ranks, null, values);
        values = new ContentValues();

                values.put(Rank_PAY,"E-1");
        values.put(Rank_SHORT, "SR");
        values.put(Rank_NAME, "Seaman Recruit ");
        values.put(Rank_ICON, "sunny");
        values.put(Rank_TYPE, "Enlisted");
        values.put(Rank_DETAILS, "Seaman recruit (SR) is the lowest enlisted rank in the U.S. Navy, U.S. Coast Guard, and the U.S. Naval Sea Cadet Corps just below seaman apprentice; this rank was formerly known as seaman third class. / A Hospital Corpsman (HM) is an enlisted medical specialist of the United States Navy who serves with the U.S. Navy and the United States Marine Corps. / Fireman recruit (FR) are Navy E-1s in the engineering and hull community./ Navy E-1s in the aviation community are called airman recruits./Navy Seabees are called constructionman recruits.  A Seabee is a member of the United States Navy Construction Battalion (CB).   ");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/List_of_United_States_Navy_enlisted_rates#References");
        values.put(Rank_Branch, Branch_USNAVY);          db.insert(Ranks, null, values);
        values = new ContentValues();

                values.put(Rank_PAY,"E-1");
        values.put(Rank_SHORT, "HR");
        values.put(Rank_NAME, "Hospitalman Recruit ");
        values.put(Rank_ICON, "sunny");
        values.put(Rank_TYPE, "Enlisted");
        values.put(Rank_DETAILS, "Hospitalman recruit (HR) is the lowest enlisted rank in the U.S. Navy,just below seaman apprentice; this rank was formerly known as seaman third class.  A Hospital Corpsman (HM) is an enlisted medical specialist of the United States Navy who serves with the U.S. Navy and the United States Marine Corps. ");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/List_of_United_States_Navy_enlisted_rates#References");
        values.put(Rank_Branch, Branch_USNAVY);          db.insert(Ranks, null, values);
        values = new ContentValues();

                values.put(Rank_PAY,"E-1");
        values.put(Rank_SHORT, "FR");
        values.put(Rank_NAME, "Fireman Recruit ");
        values.put(Rank_ICON, "sunny");
        values.put(Rank_TYPE, "Enlisted");
        values.put(Rank_DETAILS, "Fireman recruit (FR) is the lowest enlisted rank in the U.S. Navy, just below seaman apprentice; this rank was formerly known as seaman third class. Fireman recruit (FR) are Navy E-1s in the engineering and hull community.");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/List_of_United_States_Navy_enlisted_rates#References");
        values.put(Rank_Branch, Branch_USNAVY);          db.insert(Ranks, null, values);
        values = new ContentValues();

                values.put(Rank_PAY,"E-1");
        values.put(Rank_SHORT, "AR");
        values.put(Rank_NAME, " Airman Recruit ");
        values.put(Rank_ICON, "sunny");
        values.put(Rank_TYPE, "Enlisted");
        values.put(Rank_DETAILS, "Airman recruit (AR) is the lowest enlisted rank in the U.S. Navy, just below seaman apprentice; this rank was formerly known as seaman third class. / A Hospital Corpsman (HM) is an enlisted medical specialist of the United States Navy who serves with the U.S. Navy and the United States Marine Corps. Navy E-1s in the aviation community are called airman recruits.   ");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/List_of_United_States_Navy_enlisted_rates#References");
        values.put(Rank_Branch, Branch_USNAVY);          db.insert(Ranks, null, values);
        values = new ContentValues();

                values.put(Rank_PAY,"E-1");
        values.put(Rank_SHORT, "CR");
        values.put(Rank_NAME, " Constructionman Recruit ");
        values.put(Rank_ICON, "sunny");
        values.put(Rank_TYPE, "Enlisted");
        values.put(Rank_DETAILS, "Constructionman recruit (CR) is the lowest enlisted rank in the U.S. Navy, just below seaman apprentice; this rank was formerly known as seaman third class. Navy Seabees are called constructionman recruits.  A Seabee is a member of the United States Navy Construction Battalion (CB).   ");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/List_of_United_States_Navy_enlisted_rates#References");
        values.put(Rank_Branch, Branch_USNAVY);          db.insert(Ranks, null, values);
        values = new ContentValues();

                values.put(Rank_PAY,"E-2");
        values.put(Rank_SHORT, "SA");
        values.put(Rank_NAME, "Seaman Apprentice ");
        values.put(Rank_ICON, "sa_usnavy");
        values.put(Rank_TYPE, "Enlisted");
        values.put(Rank_DETAILS, "Seaman apprentice is the second lowest enlisted rank in the U.S. Navy, just above seaman recruit and below seaman. This rank was formerly known as seaman second class.  The actual title for an E-2 in the U.S. Navy varies based on the community to which the sailor belongs. Likewise, the color of their group rate marks also depends on their community.  Those in the general deck and administrative community are seamen apprentice. They wear white stripes on navy blue uniforms, and navy blue (black) stripes on white uniforms. ");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Seaman_Apprentice");
        values.put(Rank_Branch, Branch_USNAVY);          db.insert(Ranks, null, values);
        values = new ContentValues();

                values.put(Rank_PAY,"E-2");
        values.put(Rank_SHORT, "HA");
        values.put(Rank_NAME, " Hospitalman Apprentice");
        values.put(Rank_ICON, "sa_usnavy");
        values.put(Rank_TYPE, "Enlisted");
        values.put(Rank_DETAILS, "Hospitalman apprentice is the second lowest enlisted rank in the U.S. Navy, just above seaman recruit and below seaman. This rank was formerly known as seaman second class.  The actual title for an E-2 in the U.S. Navy varies based on the community to which the sailor belongs. Likewise, the color of their group rate marks also depends on their community.  Hospital corpsmen are hospitalmen apprentice. They are the only rate in this community. They wear white stripes on navy blue uniforms, and navy blue stripes on white uniforms. ");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Seaman_Apprentice");
        values.put(Rank_Branch, Branch_USNAVY);          db.insert(Ranks, null, values);
        values = new ContentValues();

                values.put(Rank_PAY,"E-2");
        values.put(Rank_SHORT, "FA");
        values.put(Rank_NAME, "Fireman Apprentice");
        values.put(Rank_ICON, "fa_usnavy");
        values.put(Rank_TYPE, "Enlisted");
        values.put(Rank_DETAILS, "Fireman apprentice is the second lowest enlisted rank in the U.S. Navy, just above seaman recruit and below seaman. This rank was formerly known as seaman second class.  The actual title for an E-2 in the U.S. Navy varies based on the community to which the sailor belongs. Likewise, the color of their group rate marks also depends on their community. Those in the engineering and hull community are called firemen apprentice and wear red stripes on both navy blue and white uniforms. ");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Seaman_Apprentice");
        values.put(Rank_Branch, Branch_USNAVY);          db.insert(Ranks, null, values);
        values = new ContentValues();

                values.put(Rank_PAY,"E-2");
        values.put(Rank_SHORT, "AA");
        values.put(Rank_NAME, "Airman Apprentice");
        values.put(Rank_ICON, "aa_usnavy");
        values.put(Rank_TYPE, "Enlisted");
        values.put(Rank_DETAILS, "Airman apprentice is the second lowest enlisted rank in the U.S. Navy, just above seaman recruit and below seaman. This rank was formerly known as seaman second class.  The actual title for an E-2 in the U.S. Navy varies based on the community to which the sailor belongs. Likewise, the color of their group rate marks also depends on their community.  Those in the aviation community are called airmen apprentice and wear green stripes on both navy blue and white uniforms.");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Seaman_Apprentice");
        values.put(Rank_Branch, Branch_USNAVY);          db.insert(Ranks, null, values);
        values = new ContentValues();

                values.put(Rank_PAY,"E-2");
        values.put(Rank_SHORT, "CA");
        values.put(Rank_NAME, "Constructionman Apprentice ");
        values.put(Rank_ICON, "ca_usnavy");
        values.put(Rank_TYPE, "Enlisted");
        values.put(Rank_DETAILS, "Constructionman apprentice is the second lowest enlisted rank in the U.S. Navy, just above seaman recruit and below seaman. This rank was formerly known as seaman second class.  The actual title for an E-2 in the U.S. Navy varies based on the community to which the sailor belongs. Likewise, the color of their group rate marks also depends on their community.  Seabees are called constructionmen apprentice and wear light blue stripes on both navy blue and white uniforms.");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Seaman_Apprentice");
        values.put(Rank_Branch, Branch_USNAVY);          db.insert(Ranks, null, values);
        values = new ContentValues();

                values.put(Rank_PAY,"E-3");
        values.put(Rank_SHORT, "SN");
        values.put(Rank_NAME, "Seaman");
        values.put(Rank_ICON, "sn_usnavy");
        values.put(Rank_TYPE, "Enlisted");
        values.put(Rank_DETAILS, "Seaman is the third enlisted rank from the bottom in the U.S. Navy, U.S. Coast Guard, ranking above Seaman Apprentice and below Petty Officer Third Class. This naval rank was formerly called 'seaman first class'.  Those in the General Deck, Technical, Weapons and Administrative Group are called 'seamen' and they represent the largest group of Navy and Coast Guard personnel in pay grades E-3 and below. They wear white stripes on their blue uniforms (USN + USCG), and navy blue (black) stripes on their white uniforms (USN only).");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Seaman");
        values.put(Rank_Branch, Branch_USNAVY);          db.insert(Ranks, null, values);
        values = new ContentValues();

                values.put(Rank_PAY,"E-3");
        values.put(Rank_SHORT, "HN");
        values.put(Rank_NAME, "Hospitalman");
        values.put(Rank_ICON, "sn_usnavy");
        values.put(Rank_TYPE, "Enlisted");
        values.put(Rank_DETAILS, "Hospitalman is the third enlisted rank from the bottom in the U.S. Navy, U.S. Coast Guard, ranking above Seaman Apprentice and below Petty Officer Third Class. This naval rank was formerly called 'seaman first class'. Those in the Medical Group are now called 'hospitalmen'. In October 2005, the USN Dental Technician (DT) rating was merged into the Hospital Corpsman (HM) rating, eliminating the 'dentalman' title for E-3 and below. Those who once held the rank of 'dentalman' have instead become 'hospitalmen'. With this merger, these personnel possess the only rating in this area of duty. They wear white stripes on their blue uniforms, and navy blue stripes on their white uniforms. This rating was previously called Pharmacist's Mate (PHM) and HMs are still colloquially referred to as 'corpsman' in the naval service.[3] Hospitalmen exist only in the U.S. Navy; their equivalent in the U.S. Coast Guard is the Health Services Technician (HS), which is sourced from seamen in that service's Administrative and Scientific Group.");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Seaman");
        values.put(Rank_Branch, Branch_USNAVY);
        db.insert(Ranks, null, values);
        values = new ContentValues();

                values.put(Rank_PAY,"E-3");
        values.put(Rank_SHORT, "FN");
        values.put(Rank_NAME, "Fireman");
        values.put(Rank_ICON, "fn_usnavy");
        values.put(Rank_TYPE, "Enlisted");
        values.put(Rank_DETAILS, "Fireman is the third enlisted rank from the bottom in the U.S. Navy, U.S. Coast Guard, ranking above Seaman Apprentice and below Petty Officer Third Class. This naval rank was formerly called 'seaman first class'.  Those in the shipboard Engineering and Hull Group, comprising conventional (USN + USCG) and nuclear (USN only) powerplants and propulsion, as well as the hull maintenance area, are called 'firemen'. They wear red stripes on both their USN and USCG blue uniforms and, in the case of the Navy, white uniforms.");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Seaman");
        values.put(Rank_Branch, Branch_USNAVY);
        db.insert(Ranks, null, values);
        values = new ContentValues();

                values.put(Rank_PAY,"E-3");
        values.put(Rank_SHORT, "AN");
        values.put(Rank_NAME, "Airman  ");
        values.put(Rank_ICON, "an_usnavy");
        values.put(Rank_TYPE, "Enlisted");
        values.put(Rank_DETAILS, "Airman is the third enlisted rank from the bottom in the U.S. Navy, U.S. Coast Guard, ranking above Seaman Apprentice and below Petty Officer Third Class. This naval rank was formerly called 'seaman first class'.  Those in the Aviation Group of the Navy and Coast Guard are called 'airmen', and they wear green stripes on blue uniforms (USN + USCG) and white uniforms (USN only).");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Seaman");
        values.put(Rank_Branch, Branch_USNAVY);
        db.insert(Ranks, null, values);
        values = new ContentValues();

                values.put(Rank_PAY,"E-3");
        values.put(Rank_SHORT, "CN");
        values.put(Rank_NAME, " Constructionman  ");
        values.put(Rank_ICON, "cn_usnavy");
        values.put(Rank_TYPE, "Enlisted");
        values.put(Rank_DETAILS, "Constructionman is the third enlisted rank from the bottom in the U.S. Navy, U.S. Coast Guard, ranking above Seaman Apprentice and below Petty Officer Third Class. This naval rank was formerly called 'seaman first class'.  Enlisted personnel in the Construction Group, which primarily populates the U.S. Navy's civil engineering construction battalions (i.e., Seabees), are called 'constructionmen' and they wear light blue stripes on both their blue and white uniforms. Constructionmen are unique to the U.S. Navy; there is no U.S. Coast Guard equivalent.");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Seaman");
        values.put(Rank_Branch, Branch_USNAVY);          db.insert(Ranks, null, values);
        values = new ContentValues();

                values.put(Rank_PAY,"E-4");
        values.put(Rank_SHORT, "PO3");
        values.put(Rank_NAME, "Petty Officer Third Class");
        values.put(Rank_ICON, "po3_usnavy");
        values.put(Rank_TYPE, "Enlisted");
        values.put(Rank_DETAILS, "Petty officer third class is the fourth enlisted rank in the U.S. Navy, U.S. Coast Guard, and the United States Naval Sea Cadet Corps, just above seaman and below petty officer second class, and is the lowest rank of non-commissioned officer, equivalent to a corporal in the U.S. Army and Marines. Petty officer third class shares the same pay grade as senior airman in the Air Force, which no longer has an NCO rank corresponding with E-4.");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Petty_Officer_Third_Class");
        values.put(Rank_Branch, Branch_USNAVY);          db.insert(Ranks, null, values);
        values = new ContentValues();

                values.put(Rank_PAY,"E-5");
        values.put(Rank_SHORT, "PO2");
        values.put(Rank_NAME, "Petty Officer Second Class");
        values.put(Rank_ICON, "po2_usnavy");
        values.put(Rank_TYPE, "Enlisted");
        values.put(Rank_DETAILS, "Petty officer, second class is the fifth enlisted rate in the U.S. Navy,[1] U.S. Coast Guard, and the United States Naval Sea Cadet Corps, just above petty officer third class and below petty officer first class, and is a non-commissioned officer. It is equivalent to the rate of sergeant in the Army, Marine Corps and Staff Sergeant in the Air Force.  Similar to petty officer third class, advancement to petty officer second class is dependent on time in service, performance evaluations by superiors, and rate (technical specialty) examinations. The advancement cycle is currently every 6 months.");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Petty_Officer_Second_Class");
        values.put(Rank_Branch, Branch_USNAVY);          db.insert(Ranks, null, values);
        values = new ContentValues();

                values.put(Rank_PAY,"E-6");
        values.put(Rank_SHORT, "PO1");
        values.put(Rank_NAME, "Petty Officer First Class");
        values.put(Rank_ICON, "po1_usnavy");
        values.put(Rank_TYPE, "Enlisted");
        values.put(Rank_DETAILS, "Petty officer, first class is the sixth enlisted rate in the United States Navy and the United States Coast Guard, just above petty officer, second class and below that of chief petty officer. A non-commissioned officer rate, petty officer, first class is also the sixth enlisted rate in the United States Naval Sea Cadet Corps. . A first-class petty officer may be generically referred to as PO1 when the sailor's rating is not known, although some prefer to be called simply 'Petty Officer (last name)'. ");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Petty_Officer_First_Class");
        values.put(Rank_Branch, Branch_USNAVY);          db.insert(Ranks, null, values);
        values = new ContentValues();

        values.put(Rank_PAY,"E-7");
        values.put(Rank_SHORT, "CPO");
        values.put(Rank_NAME, "Chief Petty Officer");
        values.put(Rank_ICON, "cpo_usnavy");
        values.put(Rank_TYPE, "Enlisted");
        values.put(Rank_DETAILS, "Chief petty officer is the seventh enlisted rate in the U.S. Navy and U.S. Coast Guard, just above petty officer first class and below senior chief petty officer, and is a senior non-commissioned officer. The grade of chief petty officer was established on April 1, 1893 for the Navy. Unlike petty officer first class and lower rates, advancement to chief petty officer not only carries requirements of time in service, superior evaluation scores, and speciality examinations, but also carries an added requirement of peer review. A chief petty officer can only advance after review by a selection board of serving master chief petty officers, in effect 'choosing their own' and conversely not choosing others.");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Chief_Petty_Officer#United_States_of_America");
        values.put(Rank_Branch, Branch_USNAVY);

        db.insert(Ranks, null, values);

        values = new ContentValues();

        values.put(Rank_PAY,"E-8");
        values.put(Rank_SHORT, "SCPO");
        values.put(Rank_NAME, "Senior Chief Petty Officer");
        values.put(Rank_ICON, "scpo_usnavy");
        values.put(Rank_TYPE, "Enlisted");
        values.put(Rank_DETAILS, "Senior chief petty officer is the eighth of nine enlisted ranks in the U.S. Navy and U.S. Coast Guard, just above chief petty officer and below master chief petty officer, and is a noncommissioned officer. They are addressed as 'Senior Chief' in most circumstances, or sometimes, less formally, as 'Senior'.  Advancement to senior chief petty officer is similar to that of chief petty officer. It carries requirements of time in service, superior evaluation scores, and peer review. ");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Senior_Chief_Petty_Officer");
        values.put(Rank_Branch, Branch_USNAVY);

        db.insert(Ranks, null, values);

        values = new ContentValues();

        values.put(Rank_PAY,"E-9");
        values.put(Rank_SHORT, "MCPO");
        values.put(Rank_NAME, "Master Chief Petty Officer");
        values.put(Rank_ICON, "mcpo_usnavy");
        values.put(Rank_TYPE, "Enlisted");
        values.put(Rank_DETAILS, "Master Chief Petty Officer is the ninth, and highest, enlisted rate (paygrade E-9) in the U.S. Navy and U.S. Coast Guard, just above senior chief petty officer. Master chief petty officers are addressed as 'Master Chief (last name)'. They constitute the top 1.25% of the enlisted members of the maritime forces.  In the Navy, advancement to master chief petty officer is similar to that of chief petty officer and senior chief petty officer. It carries requirements of time in service, superior evaluation scores, and selection by a board of master chiefs.");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Master_Chief_Petty_Officer");
        values.put(Rank_Branch, Branch_USNAVY);

        db.insert(Ranks, null, values);

        values = new ContentValues();

         values.put(Rank_PAY,"E-9");
        values.put(Rank_SHORT, "CMDCM");
        values.put(Rank_NAME, "Command Master Chief Petty Officer");
        values.put(Rank_ICON, "cmdcm_usnavy");
        values.put(Rank_TYPE, "Enlisted");
        values.put(Rank_DETAILS, "A command master chief petty officer is the most senior enlisted sailor in a United States Navy unit. Being the primary liaison between commissioned officers and enlisted sailors, he or she is an important resource for the commanding officer as his or her senior enlisted advisor, and is often called upon to gauge morale and battle readiness. In smaller units, this position may be filled by a command senior chief petty officer, a command chief petty officer, or a master chief petty officer who is not yet a command master chief. The rates force master chief petty officer and fleet master chief petty officer are used for larger units such as U.S. Fleet Forces Command, Navy Expeditionary Combat Command, U.S. Pacific Fleet, and Submarine Force U.S. Atlantic Fleet.");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Command_Master_Chief_Petty_Officer");
        values.put(Rank_Branch, Branch_USNAVY);

        db.insert(Ranks, null, values);

        values = new ContentValues();

        values.put(Rank_PAY,"E-9");
        values.put(Rank_SHORT, "FLTCM/FORCM");
        values.put(Rank_NAME, ">Fleet/Force Master Chief Petty Officer");
        values.put(Rank_ICON, "fltcm_usnavy");
        values.put(Rank_TYPE, "Enlisted");
        values.put(Rank_DETAILS, "These two ranks are equivalent and their insignia is also the same—a master chief rating badge with two gold stars above the eagle and a gold star for the rating insignia. Force Master Chief Petty Officer are master chiefs who have virtually the same responsibility as command master Chiefs, but force master chief petty officers (FORCM) are responsible for larger force commands, such as Submarine Force U.S. Atlantic Fleet. There are 16 force master chief positions in the Navy./ Fleet Master Chief Petty Officer are master chiefs who have virtually the same responsibility as command master chiefs, but fleet master chief petty officers (FLTCM) are responsible for larger fleet commands, such as the U.S. Pacific Fleet. There are four fleet master chief positions in the Navy.");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Force_Master_Chief_Petty_Officer#Fleet_and_Force_Master_Chief_Petty_Officer");
        values.put(Rank_Branch, Branch_USNAVY);

        db.insert(Ranks, null, values);

        values = new ContentValues();

        values.put(Rank_PAY,"E-9");
        values.put(Rank_SHORT, "MCPON");
        values.put(Rank_NAME, ">Master Chief Petty Officer of the Navy");
        values.put(Rank_ICON, "mcpon_usnavy");
        values.put(Rank_TYPE, "Enlisted");
        values.put(Rank_DETAILS, "The Master Chief Petty Officer of the Navy (MCPON, pronounced 'MIK-pon') is a unique non-commissioned rate of the United States Navy, which has with it the paygrade of E-9. The holder of this rank and post is the most senior enlisted member of the U.S. Navy, equivalent to the Sergeant Major of the Army, Chief Master Sergeant of the Air Force, Sergeant Major of the Marine Corps, Master Chief Petty Officer of the Coast Guard, and Senior Enlisted Advisor to the Chairman of the Joint Chiefs of Staff. He is appointed by the Chief of Naval Operations to serve as a spokesman to address the issues of enlisted personnel to the highest positions in the Navy. As such, he is the senior enlisted advisor to the Chief of Naval Operations as well as the Chief of Naval Personnel. His exact duties vary, depending on the CNO, though he generally devotes much of his time to traveling throughout the Navy observing training and talking to sailors and their families.");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Master_Chief_Petty_Officer_of_the_Navy");
        values.put(Rank_Branch, Branch_USNAVY);

        db.insert(Ranks, null, values);



    }

    public void populateuscgranks(SQLiteDatabase db){


        ContentValues values = new ContentValues();

        values.put(Rank_PAY,"0-1");
        values.put(Rank_SHORT, "ENS");
        values.put(Rank_NAME, "Ensign");
        values.put(Rank_ICON, "ensign_uscg");
        values.put(Rank_TYPE, "Officer");
        values.put(Rank_DETAILS, "Ensign is the junior commissioned officer rank in the the United States Coast Guard. This rank is also used in the U.S. Maritime Service and the U.S. Naval Sea Cadet Corps. Ensign ranks below lieutenant junior grade, and it is equivalent to a second lieutenant in the U.S. Army, the Marine Corps, and the Air Force. Depending upon the warfare community, an ensign may go directly to a warship after being commissioned to serve as a division officer, or he or she may serve up one to two years of specialty training before reporting to a combat unit (e.g. flight school, weapons systems school, navigator school, submarine school, amphibious warfare school, radar school).");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Ensign_(rank)#United_States");
        values.put(Rank_Branch, Branch_USCG);         db.insert(Ranks, null, values);
        values = new ContentValues();

        values.put(Rank_PAY,"O-2");
        values.put(Rank_SHORT, "LTJG");
        values.put(Rank_NAME, "Lieutenant (Junior Grade)");
        values.put(Rank_ICON, "ltjg_uscg");
        values.put(Rank_TYPE, "Officer");
        values.put(Rank_DETAILS, "Lieutenant (junior grade) is a junior commissioned officer rank in the United States Coast Guard, with the pay grade of O-2. The rank is also used in the United States Maritime Service and the United States Naval Sea Cadet Corps. Lieutenant, junior grade ranks above ensign and below lieutenant and is equivalent to a first lieutenant in the other uniformed services (the Army, Marine Corps and Air Force). Promotion to LTJG is governed by Department of Defense policies derived from the Defense Officer Personnel Management Act of 1980. DOPMA guidelines suggest all 'fully qualified' ensigns should be promoted to LTJG. The time for promotion to LTJG is a minimum of 18 months after commissioning in the Coast Guard. Lieutenants, junior grade typically lead petty officers and non-rated personnel, unless assigned to small aircraft or on staff duty. A LTJG's usual shipboard billet is as a Division Officer.");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Lieutenant_(junior_grade)");
        values.put(Rank_Branch, Branch_USCG);
        db.insert(Ranks, null, values);
        values = new ContentValues();

                values.put(Rank_PAY,"O-3");
        values.put(Rank_SHORT, "LT");
        values.put(Rank_NAME, "Lieutenant");
        values.put(Rank_ICON, "lieutenant_uscg");
        values.put(Rank_TYPE, "Officer");
        values.put(Rank_DETAILS, "Lieutenant is the third commissioned officer rank in the United States Coast Guard and is comparable to the rank of Captain in the other branches of the Armed Service. Lieutenants serve as Division Officers aboard Coast Guard ships and command groups of sailors and petty officers in various divisions including the deck department, engineering, and others.");
        values.put(Rank_LINK, "http://www.military-ranks.org/coast-guard/lieutenant");
        values.put(Rank_Branch, Branch_USCG);
        db.insert(Ranks, null, values);
        values = new ContentValues();


        values.put(Rank_PAY,"O-4");
        values.put(Rank_SHORT, "LCDR");
        values.put(Rank_NAME, "Lieutenant Commander");
        values.put(Rank_ICON, "lcdr_uscg");
        values.put(Rank_TYPE, "Officer");
        values.put(Rank_DETAILS, "In the United States Army, Air Force, and Marine Corps, major is a field grade military officer rank above the rank of captain and below the rank of lieutenant colonel. It is equivalent to the naval rank of lieutenant commander in the other uniformed services.   DOPMA guidelines suggest 80% of captains should be promoted to major after serving a minimum of three years at their present rank and after attaining nine to eleven years of cumulative commissioned service. ");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Major_(United_States)");
        values.put(Rank_Branch, Branch_USCG);         db.insert(Ranks, null, values);
        values = new ContentValues();

                values.put(Rank_PAY,"O-5");
        values.put(Rank_SHORT, "CDR");
        values.put(Rank_NAME, "Commander");
        values.put(Rank_ICON, "commander_uscg");
        values.put(Rank_TYPE, "Officer");
        values.put(Rank_DETAILS, "In the United States Coast Guard, commander (abbreviated 'CDR') is a senior officer rank, with the pay grade of O-5. Commander ranks above lieutenant commander and below captain. Commander is equivalent to the rank of lieutenant colonel in the other uniformed services. Notably, it is the first rank at which the holder wears an embellished cap, whereas officers of the other services are entitled to embellishment at O-4 rank. Promotion to commander in the US Coast Guard is governed by Department of Defense policies derived from the Defense Officer Personnel Management Act of 1980. DOPMA guidelines suggest 70% of lieutenant commanders should be promoted to commander after serving a minimum of three years at their present rank and after attaining 15-17 years of cumulative commissioned service. Commanders often serve as the captain of a small Coast Guard vessel, such as a cutter, frigate, destroyer, or submarine. Commanders may also lead squadrons of aircraft, be placed in charge of a small shore mission, or serve on the staff of a senior officer aboard a larger Coast Guard vessel.");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Commander_(United_States)");
        values.put(Rank_Branch, Branch_USCG);         db.insert(Ranks, null, values);
        values = new ContentValues();

                values.put(Rank_PAY,"O-6");
        values.put(Rank_SHORT, "CAPT");
        values.put(Rank_NAME, "Captain");
        values.put(Rank_ICON, "captain_uscg");
        values.put(Rank_TYPE, "Officer");
        values.put(Rank_DETAILS, "In the United States Coast Guard,, captain is the senior-most commissioned officer rank below that of flag officer (i.e., admirals). Reflecting its nautical heritage, it also sometimes used as a military 'title' by more junior officers who are serving as the commanding officer (CO) of a commissioned vessel of the Navy or Coast Guard of patrol boat size or greater. Coast Guard captains follow career paths very similar to their Navy counterparts, with seagoing officers typically commanding large maritime security cutters or high endurance cutters and aviators commanding coast guard air stations. Coast Guard captains will also command all types of major Coast Guard shore installations and activities, as well as serve as chiefs of staff for Coast Guard flag officers.");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Captain_(United_States_O-6)");
        values.put(Rank_Branch, Branch_USCG);         db.insert(Ranks, null, values);
        values = new ContentValues();

                values.put(Rank_PAY,"O-7");
        values.put(Rank_SHORT, "RDML");
        values.put(Rank_NAME, "Rear Admiral (Lower Half)");
        values.put(Rank_ICON, "rdml_uscg");
        values.put(Rank_TYPE, "Officer");
        values.put(Rank_DETAILS, "In the United States Coast Guard, rear admiral (lower half) is a one-star flag officer, with the pay grade of O-7. The abbreviation for personnel from the USN, USCG, and NOAA is RDML. Rear admiral (lower half) ranks above captain and below rear admiral. Rear admiral (lower half) is equivalent to the rank of brigadier general in the other uniformed services, and equivalent to the rank of commodore in most other navies.[2] In the United States uniformed services, rear admiral (lower half) replaced the rank of commodore in 1985.");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Rear_admiral_(United_States)");
        values.put(Rank_Branch, Branch_USCG);         db.insert(Ranks, null, values);
        values = new ContentValues();

                values.put(Rank_PAY,"O-8");
        values.put(Rank_SHORT, "RADM");
        values.put(Rank_NAME, "Rear Admiral");
        values.put(Rank_ICON, "rear_admiral_uscg");
        values.put(Rank_TYPE, "Officer");
        values.put(Rank_DETAILS, "In the United States Coast Guard, rear admiral (RADM), also sometimes referred to as rear admiral (upper half), is a two-star flag officer, with the pay grade of O-8. Rear admiral ranks above rear admiral (lower half) and below vice admiral. Rear admiral is equivalent to the rank of major general in the other uniformed services. It is the highest permanent rank during peacetime in the uniformed services; all higher ranks are temporary ranks linked to specific commands or office. A Rear Admiral generally commands a fleet of Coast Guard ships and air wings. As a flag officer, a Real Admiral may fly the Rear Admiral's pennant over any ship or base on which he is serving - two white stars on a navy-blue background.");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Rear_admiral_(United_States)");
        values.put(Rank_Branch, Branch_USCG);         db.insert(Ranks, null, values);
        values = new ContentValues();

                values.put(Rank_PAY,"O-9");
        values.put(Rank_SHORT, "VADM");
        values.put(Rank_NAME, "Vice Admiral");
        values.put(Rank_ICON, "vice_admiral_uscg");
        values.put(Rank_TYPE, "Officer");
        values.put(Rank_DETAILS, "In the United States Coast Guard, vice admiral (VADM) is a three-star flag officer, with the pay grade of O-9. Vice admiral ranks above rear admiral and below admiral. Vice admiral is equivalent to the rank of lieutenant general in the other uniformed services. A Vice Admiral commands regional Coast Guard operations during an operation or war and answers directly to the Fleet Admiral and the President of the United States. As a three-star flag officer a Vice Admiral may fly the Vice Admiral's pennant over any ship or station on which he is serving, which is three white stars on a navy blue background.");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Vice_Admiral_(United_States)");
        values.put(Rank_Branch, Branch_USCG);         db.insert(Ranks, null, values);
        values = new ContentValues();

                values.put(Rank_PAY,"O-10");
        values.put(Rank_SHORT, "ADM");
        values.put(Rank_NAME, "Admiral");
        values.put(Rank_ICON, "admiral_uscg");
        values.put(Rank_TYPE, "Officer");
        values.put(Rank_DETAILS, "In the United States Coast Guard, admiral (ADM) is a four-star flag officer rank, with the pay grade of O-10. Admiral ranks above vice admiral. The Coast Guard does not have an established grade above admiral. Admiral is equivalent to the rank of general in the other uniformed services. An Admiral commands regional Coast Guard operations and answers directly President of the United States. As a four-star flag officer, an Admiral may fly the Admiral's pennant over any ship or station on which he is serving, which is four white stars on a navy blue background.");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Admiral_(United_States)");
        values.put(Rank_Branch, Branch_USCG);         db.insert(Ranks, null, values);
        values = new ContentValues();

                values.put(Rank_PAY,"W-2");
        values.put(Rank_SHORT, "CWO2");
        values.put(Rank_NAME, "Chief Warrant Officer 2");
        values.put(Rank_ICON, "wo2_uscg");
        values.put(Rank_TYPE, "Warrant Officer");
        values.put(Rank_DETAILS, "Chief Warrant Officer 2 is the United States Coast Guard's entry-level billeted warrant officer rank. Warrant officers serve as technical specialists with command authority within their field of expertise and hold a variety of positions essential to the smooth operation of the Coast Guard. Coast Guard Warrant Officers usually belong to one of 30 specialties including boatswain, master mate, surgeon, chaplain, and carpenter, which are specialized and skilled positions that often require specialists with command authority and leadership skills.");
        values.put(Rank_LINK, "http://www.military-ranks.org/coast-guard/chief-warrant-officer-2");
        values.put(Rank_Branch, Branch_USCG);         db.insert(Ranks, null, values);
        values = new ContentValues();

                values.put(Rank_PAY,"W-3");
        values.put(Rank_SHORT, "CWO3");
        values.put(Rank_NAME, "Chief Warrant Officer 3");
        values.put(Rank_ICON, "wo3_uscg");
        values.put(Rank_TYPE, "Warrant Officer");
        values.put(Rank_DETAILS, "Chief Warrant Officer 3 is the United States Coast Guard's second billeted warrant officer rank. Warrant officers serve as technical specialists with command authority within their field of expertise, and hold a variety of positions essential to the smooth operations of the Coast Guard. Coast Guard Warrant Officers usually belong to one of 30 specialties including boatswain, master mate, surgeon, chaplain, and carpenter, which are specialized and skilled positions that often require specialists with command authority and leadership skills. Sailors are generally promoted to Chief Warrant Officer 3 from Chief Warrant Officer 2; they are chosen for promotion when they show exceptional service and experience.");
        values.put(Rank_LINK, "http://www.military-ranks.org/coast-guard/chief-warrant-officer-3");
        values.put(Rank_Branch, Branch_USCG);         db.insert(Ranks, null, values);
        values = new ContentValues();

                values.put(Rank_PAY,"W-4");
        values.put(Rank_SHORT, "CWO4");
        values.put(Rank_NAME, "Chief Warrant Officer 4");
        values.put(Rank_ICON, "wo4_uscg");
        values.put(Rank_TYPE, "Warrant Officer");
        values.put(Rank_DETAILS, "Chief Warrant Officer 4 is the Unites States Coast Guard's fourth and highest billeted warrant officer rank. Warrant officers serve as technical specialists with command authority within their field of expertise, and hold a variety of positions essential to the smooth operations of the Coast Guard. Coast Guard Warrant Officers usually belong to one of 30 specialties including boatswain, master mate, surgeon, chaplain, and carpenter, which are specialized and skilled positions that often require specialists with command authority and leadership skills. Sailors are generally promoted to Chief Warrant Officer 4 from Chief Warrant Officer 3; they are chosen for promotion after showing exceptional service and and experience.");
        values.put(Rank_LINK, "http://www.military-ranks.org/coast-guard/chief-warrant-officer-4");
        values.put(Rank_Branch, Branch_USCG);         db.insert(Ranks, null, values);
        values = new ContentValues();

                values.put(Rank_PAY,"E-1");
        values.put(Rank_SHORT, "SR");
        values.put(Rank_NAME, "Seaman Recruit");
        values.put(Rank_ICON, "sr_uscg");
        values.put(Rank_TYPE, "Enlisted");
        values.put(Rank_DETAILS, "Seaman recruit (SR) is the lowest enlisted rank in the U.S. Coast Guard,  just below seaman apprentice; this rank was formerly known as seaman third class. Two separate pay grades exist within this rank (and the corresponding ranks in the other branches of the United States military structure) — one for those with service of less than four months, with a higher pay scale for those in service for more than four months, even if they have not yet advanced to seaman apprentice.");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Seaman_Recruit");
        values.put(Rank_Branch, Branch_USCG);         db.insert(Ranks, null, values);
        values = new ContentValues();

                values.put(Rank_PAY,"E-2");
        values.put(Rank_SHORT, "SA");
        values.put(Rank_NAME, "Seaman Apprentice");
        values.put(Rank_ICON, "sa_uscg");
        values.put(Rank_TYPE, "Enlisted");
        values.put(Rank_DETAILS, "Seaman apprentice is the second lowest enlisted rank in the U.S. Navy, U.S. Coast Guard, and the U.S. Naval Sea Cadet Corps just above seaman recruit and below seaman; this rank was formerly known as seaman second class. There are several titles and color-coded rank insignias assigned to sailors receiving this grade, determined by their operational specialty.");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Seaman_Apprentice");
        values.put(Rank_Branch, Branch_USCG);         db.insert(Ranks, null, values);

        values = new ContentValues();

                values.put(Rank_PAY,"E-3");
        values.put(Rank_SHORT, "SN");
        values.put(Rank_NAME, "Seaman");
        values.put(Rank_ICON, "sn_uscg");
        values.put(Rank_TYPE, "Enlisted");
        values.put(Rank_DETAILS, "Seaman is the third enlisted rank from the bottom in the U.S. Navy, U.S. Coast Guard, ranking above Seaman Apprentice and below Petty Officer Third Class.  Several title and rank variations exist for sailors working in different specialties, though all share the same pay and rank grade. Sailors at this grade do not wear their stripe insignia on their working uniforms, although they are permitted to wear a silver collar device signifying their rank.");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Seaman#United_States");
        values.put(Rank_Branch, Branch_USCG);         db.insert(Ranks, null, values);
        values = new ContentValues();

                values.put(Rank_PAY,"E-4");
        values.put(Rank_SHORT, "PO3");
        values.put(Rank_NAME, "Petty Officer Third Class");
        values.put(Rank_ICON, "potc_uscg");
        values.put(Rank_TYPE, "Enlisted");
        values.put(Rank_DETAILS, "Petty officer third class is the fourth enlisted rank in the U.S. Coast Guard, just above seaman and below petty officer second class, and is the lowest rank of non-commissioned officer, equivalent to a corporal in the U.S. Army and Marines. Petty officer third class shares the same pay grade as senior airman in the Air Force, which no longer has an NCO rank corresponding with E-4. A Petty Officer Third Class serves both as a leader and as a technical expert, and all Petty Officers have a specified rating, or job. The exact title with which a petty officer is addressed depends on their specialty - a Petty Officer Third Class serving as a Machinist's Mate, for example, would have the full title of Machinist's Mate Third Class.");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Petty_Officer_Third_Class");
        values.put(Rank_Branch, Branch_USCG);         db.insert(Ranks, null, values);
        values = new ContentValues();

                values.put(Rank_PAY,"E-5");
        values.put(Rank_SHORT, "PO2");
        values.put(Rank_NAME, "Petty Officer Second Class");
        values.put(Rank_ICON, "posc_uscg");
        values.put(Rank_TYPE, "Enlisted");
        values.put(Rank_DETAILS, " Petty officer, second class is the fifth enlisted rate in the U.S. Coast Guard, just above petty officer third class and below petty officer first class, and is a non-commissioned officer. It is equivalent to the rate of sergeant in the Army, Marine Corps and Staff Sergeant in the Air Force. Similar to petty officer third class, advancement to petty officer second class is dependent on time in service, performance evaluations by superiors, and rate (technical specialty) examinations. The advancement cycle is currently every 6 months. Only a certain number of billets (job openings for this rate) open up biannually and all petty officers third class compete. The top scorers are chosen for advancement, but only in sufficient quantities to fill the billets available.");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Petty_Officer_Second_Class");
        values.put(Rank_Branch, Branch_USCG);         db.insert(Ranks, null, values);
        values = new ContentValues();

                values.put(Rank_PAY,"E-6");
        values.put(Rank_SHORT, "PO1");
        values.put(Rank_NAME, "Petty Officer First Class");
        values.put(Rank_ICON, "pofc_uscg");
        values.put(Rank_TYPE, "Enlisted");
        values.put(Rank_DETAILS, "Petty officer, first class is the sixth enlisted rate in the United States Navy and the United States Coast Guard, just above petty officer, second class and below that of chief petty officer. A Petty Officer First Class serves both as a leader and as a technical expert, and all Petty Officers have a specified rating, or job. The exact title with which a petty officer is addressed depends on their specialty; a Petty Officer First Class serving as an Electronics Technician, for example, would have the full title of Electronics Technician First Class.");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Petty_Officer_First_Class");
        values.put(Rank_Branch, Branch_USCG);         db.insert(Ranks, null, values);
        values = new ContentValues();

                values.put(Rank_PAY,"E-7");
        values.put(Rank_SHORT, "CPO");
        values.put(Rank_NAME, "Chief Petty Officer");
        values.put(Rank_ICON, "cpo_uscg");
        values.put(Rank_TYPE, "Enlisted");
        values.put(Rank_DETAILS, "Chief Petty Officer is the seventh enlisted rate (E-7) in the United States Coast Guard, just above Petty Officer First Class and below Senior Chief Petty Officer. Chief Petty Officer is the first Coast Guard rank that comes with vastly expanded powers and responsibilities over those of that below it. In addition to their rating's duties, a Chief Petty Officer is responsible for training junior officers and leading his division of sailors and petty officers.");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Chief_Petty_Officer_(United_States)");
        values.put(Rank_Branch, Branch_USCG);         db.insert(Ranks, null, values);
        values = new ContentValues();

                values.put(Rank_PAY,"E-8");
        values.put(Rank_SHORT, "SCPO");
        values.put(Rank_NAME, "Senior Chief Petty Officer");
        values.put(Rank_ICON, "scpo_uscg");
        values.put(Rank_TYPE, "Enlisted");
        values.put(Rank_DETAILS, "Senior chief petty officer is the eighth of nine enlisted ranks in the U.S. Coast Guard, just above chief petty officer and below master chief petty officer, and is a noncommissioned officer. They are addressed as 'Senior Chief' in most circumstances, or sometimes, less formally, as 'Senior'. Like Chief Petty Officers, a Senior Chief Petty Officer is responsible for a variety of administrative and leadership responsibilities in his specialized area, also known as his rating. Also similar to other Coast Guard sailors, the full rank for a Senior Chief Petty Officer includes his rating; a SCPO specializing as a Quartermaster, for example, would be referred to by his full title of Senior Chief Quartermaster.");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Senior_Chief_Petty_Officer");
        values.put(Rank_Branch, Branch_USCG);         db.insert(Ranks, null, values);
        values = new ContentValues();

                values.put(Rank_PAY,"E-9");
        values.put(Rank_SHORT, "MCPO");
        values.put(Rank_NAME, "Master Chief Petty Officer");
        values.put(Rank_ICON, "mcpo_uscg");
        values.put(Rank_TYPE, "Enlisted");
        values.put(Rank_DETAILS, "Master Chief Petty Officer is the ninth, and highest, enlisted rate (paygrade E-9) in the U.S. Navy and U.S. Coast Guard, just above senior chief petty officer. Master chief petty officers are addressed as 'Master Chief (last name)'. Less then 1% of the Coast Guard's personnel make it to the rank of Master Chief, and those who do are considered to be among the best and the brightest in their respective specialties. Like the other Coast Guard ranks, all MCPOs have a rating, or job specialty, which is included in their full title. A Master Chief Petty Officer who specializes as a Gunner's Mate, for example, would have a full title of Master Chief Gunner's Mate. Most MCPOs, however, are simply referred to as Master Chief by their subordinates.");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Master_Chief_Petty_Officer");
        values.put(Rank_Branch, Branch_USCG);         db.insert(Ranks, null, values);
        values = new ContentValues();

                values.put(Rank_PAY,"E-9");
        values.put(Rank_SHORT, "CMC");
        values.put(Rank_NAME, "Command Master Chief Petty Officer");
        values.put(Rank_ICON, "cmc_uscg");
        values.put(Rank_TYPE, "Enlisted");
        values.put(Rank_DETAILS, "Command Master Chief Petty Officer is the most senior enlisted rank in the United States Coast Guard, and serves as a bridge between the enlisted sailors and petty officers and the commanding officers above them. Command Master Chiefs are chosen from the ranks of eligible Master Chief Petty Officers, or lower Chief Petty Officers if necessary, by the Command Master Chief Program, which was started in 1995. Candidates receive specialized leadership and communications training, which enables them to serve in a unique and independent role as both the chief enlisted officer of their force and as a direct liaison and adviser to the commanding officer.");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Command_Master_Chief_Petty_Officer");
        values.put(Rank_Branch, Branch_USCG);         db.insert(Ranks, null, values);
        values = new ContentValues();

                values.put(Rank_PAY,"E-9");
        values.put(Rank_SHORT, "MCPOCG");
        values.put(Rank_NAME, "Master Chief Petty Officer of the Coast Guard");
        values.put(Rank_ICON, "mcpocg_uscg");
        values.put(Rank_TYPE, "Enlisted");
        values.put(Rank_DETAILS, "Master Chief Petty Officer of the Coast Guard (MCPOCG) is a unique rank established to be held by only one sailor, who serves as the highest-ranking enlisted soldier in the Coast Guard. The MCPON is appointed personally by the Commandment of the Coast Guard and serves as the spokesman for the enlisted sailors as well as a Senior Enlisted Adviser to high-ranking officials including the Commandment of the Coast Guard.");
        values.put(Rank_LINK, "http://en.wikipedia.org/wiki/Master_Chief_Petty_Officer_of_the_Coast_Guard");
        values.put(Rank_Branch, Branch_USCG);         db.insert(Ranks, null, values);


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
        populateusarmyranks(db);
        populateusnavyranks(db);
        populateuscgranks(db);


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