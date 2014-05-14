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
        populateusafafsc(db);
        populatearmymos(db);











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