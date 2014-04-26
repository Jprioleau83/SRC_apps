package com.cnsintegration.srcmarineinfo1;


import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.cnsintegration.srcmarineinfo1.adapter.NavDrawerListAdapter;
import com.cnsintegration.srcmarineinfo1.model.NavDrawerItem;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


public class MainActivitybak extends FragmentActivity
        implements ActionFragment.OnServicesSelectedListener, ServiceFragment.OnServicesSelectedListener,  ServiceFragment.OnServicesSelectedListener2, RankFrag.OnServicesSelectedListener, RankFrag.OnServicesSelectedListener1,HomeFragment.OnHomeCreatedListener, MilitaryTimeFragment.OnMilitaryTimeListener, MOSFragment.OnServicesSelectedListener,  MOSFragment.OnServicesSelectedListener2, MOSFrag.OnMosSelectedListener{


    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;
    private Timer timer;
    // nav drawer title
    private CharSequence mDrawerTitle;

    // used to store app title
    private CharSequence mTitle;

    // slide menu items
    private String[] navMenuTitles;
    private TypedArray navMenuIcons;

    private ArrayList<NavDrawerItem> navDrawerItems;
    private NavDrawerListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTitle = mDrawerTitle = getTitle();

        // load slide menu items
        navMenuTitles = getResources().getStringArray(R.array.nav_drawer_items);

        // nav drawer icons from resources
        navMenuIcons = getResources()
                .obtainTypedArray(R.array.nav_drawer_icons);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.list_slidermenu);

        navDrawerItems = new ArrayList<NavDrawerItem>();

        // adding nav drawer items to array
        // HomeFragment
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[0], navMenuIcons.getResourceId(0, -1)));
        // Find People
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[1], navMenuIcons.getResourceId(1, -1)));
        // Photos
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[2], navMenuIcons.getResourceId(2, -1)));
        // Communities, Will add a counter here
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[3], navMenuIcons.getResourceId(3, -1), true, "22"));
        // Pages
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[4], navMenuIcons.getResourceId(4, -1)));
        // What's hot, We  will add a counter here
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[5], navMenuIcons.getResourceId(5, -1), true, "50+"));


        // Recycle the typed array
        navMenuIcons.recycle();
        mDrawerList.setOnItemClickListener(new SlideMenuClickListener());

        // setting the nav drawer list adapter
        adapter = new NavDrawerListAdapter(getApplicationContext(),
                navDrawerItems);
        mDrawerList.setAdapter(adapter);

        // enabling action bar app icon and behaving it as toggle button
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                R.drawable.ic_drawer, //nav menu toggle icon
                R.string.app_name, // nav drawer open - description for accessibility
                R.string.app_name // nav drawer close - description for accessibility
        ) {
            public void onDrawerClosed(View view) {
                getActionBar().setTitle(mTitle);
                // calling onPrepareOptionsMenu() to show action bar icons
                invalidateOptionsMenu();
            }

            public void onDrawerOpened(View drawerView) {
                getActionBar().setTitle(mDrawerTitle);
                // calling onPrepareOptionsMenu() to hide action bar icons
                invalidateOptionsMenu();
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        if (savedInstanceState == null) {
            // on first time display view for first nav item
            displayView(0);
        }
    }






    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // toggle nav drawer on selecting action bar app icon/title
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        // Handle action bar actions click
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**
     * Called when invalidateOptionsMenu() is triggered
     */
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // if nav drawer is opened, hide the action items
        boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
        menu.findItem(R.id.action_settings).setVisible(!drawerOpen);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getActionBar().setTitle(mTitle);
    }

    /**
     * When using the ActionBarDrawerToggle, you must call it during
     * onPostCreate() and onConfigurationChanged()...
     */

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggls
        mDrawerToggle.onConfigurationChanged(newConfig);
    }


    /**
     * Diplaying fragment view for selected nav drawer list item
     * */
    private void displayView(int position) {
        // update the main content by replacing fragments
        Fragment fragment = null;
        HomeFragment hfragment = null;

        int casenum = 0;
        switch (position) {
            case 0:
                fragment = new ActionFragment();

                hfragment = new HomeFragment();
                break;
            case 1:
                fragment = new ServiceFragment(0);
                casenum = 1;
                break;
            case 2:
                fragment = new ActionFragment();

                casenum = 2;
                break;
            case 3:
                fragment = new ServiceFragment(1);

                casenum = 3;
                break;

            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();

            if(casenum == 0){


                if (findViewById(R.id.fragment_container) != null) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, hfragment).commit();
                }else {


                    getSupportFragmentManager().beginTransaction().replace(R.id.service_fragment, fragment).addToBackStack(null)
                            .replace(R.id.rank_fragment, hfragment).commit();






                }
            }

            if (casenum == 1) {
                RankFrag rankFrag = new RankFrag();

                //if two columns
                if (findViewById(R.id.fragment_container) != null) {


                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).addToBackStack(null).commit();


                }else {
                    getSupportFragmentManager().beginTransaction().replace(R.id.service_fragment, fragment).addToBackStack(null)
                            .replace(R.id.rank_fragment, rankFrag).addToBackStack(null).commit();


                }



            }
            if (casenum == 2) {


                MilitaryTimeFragment Mfragment = null;
                 Mfragment = new MilitaryTimeFragment();

                //if two columns
                if (findViewById(R.id.fragment_container) != null) {


                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, Mfragment).addToBackStack(null).commit();


                }else {
                    getSupportFragmentManager().beginTransaction().replace(R.id.service_fragment, fragment).addToBackStack(null)
                            .replace(R.id.rank_fragment, Mfragment).addToBackStack(null).commit();


                }



            }

            if(casenum == 3){


                if (findViewById(R.id.fragment_container) != null) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
                }else {


                    MOSFrag mosFragview = new MOSFrag();
                    getSupportFragmentManager().beginTransaction().replace(R.id.service_fragment, fragment).addToBackStack(null)
                            .replace(R.id.rank_fragment, mosFragview).commit();






                }
            }



            // update selected item and title, then close the drawer
            mDrawerList.setItemChecked(position, true);
            mDrawerList.setSelection(position);
            setTitle(navMenuTitles[position]);
            mDrawerLayout.closeDrawer(mDrawerList);
        } else {
            // error in creating fragment
            Log.e("MainActivity", "Error in creating fragment");
        }
    }


    public void onActionSelected(int position){


        displayView(position);








    }


    public void onServiceSelected(int position) {
        RankFrag rankFrag = (RankFrag)
                getSupportFragmentManager().findFragmentById(R.id.rank_fragment);

        if (rankFrag != null) {
            // If article frag is available, we're in two-pane layout...

            // Call a method in the ArticleFragment to update its content
            rankFrag.updateRankView(position);

        } else {


            if (findViewById(R.id.fragment_container) != null) {

                // However, if we're being restored from a previous state,
                // then we don't need to do anything and should return or else
                // we could end up with overlapping fragments.


                // Create an instance of ExampleFragment
                RankFrag rankFragment = new RankFrag();
                Bundle args = new Bundle();
                args.putInt(ServiceFragment.ARG_POSITION, position);
                rankFragment.setArguments(args);
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

                transaction.replace(R.id.fragment_container, rankFragment);
                transaction.addToBackStack(null);
                transaction.commit();

            }

        }


    }

    public void onServiceSelected2(int position) {

        if (findViewById(R.id.fragment_container) != null) {


            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.


            // Create an instance of ExampleFragment
            MOSFragment mosFragment = new MOSFragment(position);
            Bundle args = new Bundle();
            args.putInt(ServiceFragment.ARG_POSITION, position);
            mosFragment.setArguments(args);
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            transaction.replace(R.id.fragment_container, mosFragment);
            transaction.addToBackStack(null);
            transaction.commit();


        }else {
            MOSFragment mosFrag =  new MOSFragment(position);
            MOSFrag mosFragview = new MOSFrag();
            getSupportFragmentManager().beginTransaction().replace(R.id.service_fragment, mosFrag).addToBackStack(null)
                    .replace(R.id.rank_fragment, mosFragview).commit();



        }








    }


    public void onMOSSelected(int grpposition) {
        MOSFrag mosFrag = (MOSFrag)
                getSupportFragmentManager().findFragmentById(R.id.rank_fragment);

        if (mosFrag != null) {
            // If article frag is available, we're in two-pane layout...

            // Call a method in the ArticleFragment to update its content
            mosFrag.updateMOSView(grpposition);

        } else {


            if (findViewById(R.id.fragment_container) != null) {

                // However, if we're being restored from a previous state,
                // then we don't need to do anything and should return or else
                // we could end up with overlapping fragments.


                // Create an instance of ExampleFragment
                MOSFrag mosFragment = new MOSFrag();
                Bundle args = new Bundle();
                args.putInt(MOSFrag.ARG_POSITION, grpposition);
                mosFragment.setArguments(args);
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

                transaction.replace(R.id.fragment_container, mosFragment);
                transaction.addToBackStack(null);
                transaction.commit();

            }

        }


    }





    public void onRankSelected(int position) {
        RankFrag rankFrag = (RankFrag)
                getSupportFragmentManager().findFragmentById(R.id.rank_fragment);

        if (rankFrag != null) {
            // If article frag is available, we're in two-pane layout...

            // Call a method in the ArticleFragment to update its content
            rankFrag.updateRankView(position);

        } else {


            if (findViewById(R.id.fragment_container) != null) {

                // However, if we're being restored from a previous state,
                // then we don't need to do anything and should return or else
                // we could end up with overlapping fragments.


                // Create an instance of ExampleFragment
                RankFrag rankFragment = new RankFrag();
                Bundle args = new Bundle();
                args.putInt(ServiceFragment.ARG_POSITION, position);
                rankFragment.setArguments(args);
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

                transaction.replace(R.id.fragment_container, rankFragment);
                transaction.addToBackStack(null);
                transaction.commit();

            }

        }


    }




    /**
     * Slide menu item click listener
     * */
    private class SlideMenuClickListener implements
            ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long id) {
            // display view for selected nav drawer item
            displayView(position);
        }
    }

    public void onRankCreated(){
        if (findViewById(R.id.fragment_container) == null) {
            View cv = findViewById(R.id.service_fragment);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT);
            params.weight = 50;
            cv.setLayoutParams(params);

            View cv1 = findViewById(R.id.rank_fragment);
            LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT);
            params1.weight = 50;
            cv1.setLayoutParams(params1);

            int sdk = android.os.Build.VERSION.SDK_INT;
            if (sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
                cv.setBackgroundDrawable(this.getResources().getDrawable(R.drawable.white));
            } else {
                cv.setBackground(this.getResources().getDrawable(R.drawable.white));
            }
        }

    }

    public void onHomeCreated(){
        //if two columns
        if (findViewById(R.id.fragment_container) == null) {


            View cv = findViewById(R.id.service_fragment);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT);
            params.weight = 20;
            cv.setLayoutParams(params);

            int sdk = android.os.Build.VERSION.SDK_INT;
            if(sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
                cv.setBackgroundDrawable(this.getResources().getDrawable(R.drawable.list_background));
            } else {
                cv.setBackground(this.getResources().getDrawable(R.drawable.list_background));
            }



            View cv1 = findViewById(R.id.rank_fragment);
            LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT);
            params1.weight = 80;
            cv1.setLayoutParams(params1);
        }


    }





    public void onTimeCreated() {
        String currentDateTimeString = "";
        currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date( ));


        //TextView t = (TextView) findViewById(R.id.textView);


    // textView is the TextView view that should display it
        //t.setText(currentDateTimeString);



        final TextView txtHour = (TextView)findViewById(R.id.hour);
        final TextView txtMin = (TextView)findViewById(R.id.min);
        final TextView txtSec = (TextView)findViewById(R.id.sec);

        final TextView curtxtHour = (TextView)findViewById(R.id.curhour);
        final TextView curtxtMin = (TextView)findViewById(R.id.curmin);
        final TextView curtxtSec = (TextView)findViewById(R.id.cursec);
        final TextView curtxtampm = (TextView)findViewById(R.id.curampm);
        Typeface custom_font = Typeface.createFromAsset(getAssets(),
                "fonts/digital.ttf");
        txtHour.setTypeface(custom_font);
        txtMin.setTypeface(custom_font);
        txtSec.setTypeface(custom_font);

        curtxtHour.setTypeface(custom_font);
        curtxtMin.setTypeface(custom_font);
        curtxtSec.setTypeface(custom_font);
        curtxtampm.setTypeface(custom_font);


        timer = new Timer("DigitalClock");

        // Get the Current Time
        final Runnable updateTask = new Runnable() {
            public void run() {
                Calendar calendar = Calendar.getInstance();

                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.HOUR); // get the current year
                int month = cal.get(Calendar.MINUTE); // month...
                int day = cal.get(Calendar.SECOND); // current day in the month

               final Integer test = new Integer(calendar.get(Calendar.HOUR_OF_DAY));

                final Integer hora = new Integer(Calendar.getInstance().get(Calendar.HOUR_OF_DAY));
                final Integer minutes = new Integer(Calendar.getInstance().get(Calendar.MINUTE));
                final Integer seconds = new Integer(Calendar.getInstance().get(Calendar.SECOND));

                Integer curhour = new Integer(Calendar.getInstance().get(Calendar.HOUR));
                final Integer curminutes = new Integer(Calendar.getInstance().get(Calendar.MINUTE));
                final Integer curseconds = new Integer(Calendar.getInstance().get(Calendar.SECOND));
                final Integer curampm = new Integer(Calendar.getInstance().get(Calendar.AM_PM));


                String amorpm = " AM";

                if(curampm == 1){


                    amorpm = " PM";

                }



                if(curhour == 0){
                    curhour = 12;
                }

                txtHour.setText(hora.toString());
                txtMin.setText(minutes.toString());
                txtSec.setText(seconds.toString());

                curtxtHour.setText(curhour.toString());
                curtxtMin.setText(curminutes.toString());
                curtxtSec.setText(curseconds.toString());
                curtxtampm.setText(amorpm);


            }
        };

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(updateTask);
            }
        }, 1, 1000);

        if (findViewById(R.id.fragment_container) == null) {


            View cv = findViewById(R.id.service_fragment);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT);
            params.weight = 20;
            cv.setLayoutParams(params);

            int sdk = android.os.Build.VERSION.SDK_INT;
            if(sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
                cv.setBackgroundDrawable(this.getResources().getDrawable(R.drawable.list_background));
            } else {
                cv.setBackground(this.getResources().getDrawable(R.drawable.list_background));
            }



            View cv1 = findViewById(R.id.rank_fragment);
            LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT);
            params1.weight = 80;
            cv1.setLayoutParams(params1);
        }







}


}