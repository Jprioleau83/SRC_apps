package com.cnsintegration.srcmarineinfo1;

import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivitybak extends FragmentActivity
        implements  ActionFragment.OnServicesSelectedListener, ServiceFragment.OnServicesSelectedListener,RankFrag.OnServicesSelectedListener  {

    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;

    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    private String[] mActionTitles;
    String[] myActionArray = {"Ranks","Military Time","MOS","Alpha Numeric","Org structure","Acks"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Check whether the activity is using the layout version with
        // the fragment_container FrameLayout. If so, we must add the first fragment

      //one colum
        if (findViewById(R.id.fragment_container) != null) {

            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return;
            }

            // Create an instance of ExampleFragment
            ActionFragment firstFragment = new ActionFragment();

            // In case this activity was started with special instructions from an Intent,
            // pass the Intent's extras to the fragment as arguments
            firstFragment.setArguments(getIntent().getExtras());

            // Add the fragment to the 'fragment_container' FrameLayout
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, firstFragment).addToBackStack(null).commit();




        }




    }






















    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        //getActionBar().setTitle(mTitle);
    }

    @Override
    public void onServiceSelected(int position) {
        
    }

    /**
     * When using the ActionBarDrawerToggle, you must call it during
     * onPostCreate() and onConfigurationChanged()...
     */



    /* The click listner for ListView in the navigation drawer */
    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //selectItem(position);
        }
    }

    private void selectItem(int position) {

    }

    public void onActionSelected(int position){



            if (findViewById(R.id.fragment_container) != null) {

                // However, if we're being restored from a previous state,
                // then we don't need to do anything and should return or else
                // we could end up with overlapping fragments.


                // Create an instance of ExampleFragment
                RankFrag rankFragment = new RankFrag();
                Bundle args = new Bundle();
               // args.putInt(ArticleFragment.ARG_POSITION, position);
                rankFragment.setArguments(args);
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

                transaction.replace(R.id.fragment_container, rankFragment);
                transaction.addToBackStack(null);
                transaction.commit();

            }else{
                // Create new fragment and transaction

                setContentView(R.layout.oldactivity_main);
            System.out.print("test");

        }








    }
/**
    public void onArticleSelected(int position) {
        // The user selected the headline of an article from the HeadlinesFragment

        // Capture the article fragment from the activity layout
        ArticleFragment articleFrag = (ArticleFragment)
                getSupportFragmentManager().findFragmentById(R.id.rank_fragment);

        if (articleFrag != null) {
            // If article frag is available, we're in two-pane layout...

            // Call a method in the ArticleFragment to update its content
            articleFrag.updateArticleView(position);

        } else {
            // If the frag is not available, we're in the one-pane layout and must swap frags...

            // Create fragment and give it an argument for the selected article
            ArticleFragment newFragment = new ArticleFragment();
            Bundle args = new Bundle();
            args.putInt(ArticleFragment.ARG_POSITION, position);
            newFragment.setArguments(args);
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack so the user can navigate back
            transaction.replace(R.id.fragment_container, newFragment);
            transaction.addToBackStack(null);

            // Commit the transaction
            transaction.commit();
        }
    }
**/
   /** public void onRankSelected(int position) {
        RankFragment rankFrag = (RankFragment)
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
                RankFragment rankFragment = new RankFragment();
                Bundle args = new Bundle();
                args.putInt(ArticleFragment.ARG_POSITION, position);
                rankFragment.setArguments(args);
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

                transaction.replace(R.id.fragment_container, rankFragment);
                transaction.addToBackStack(null);
                transaction.commit();

            }

        }


        }
**/
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
                //args.putInt(ArticleFragment.ARG_POSITION, position);
                rankFragment.setArguments(args);
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

                transaction.replace(R.id.fragment_container, rankFragment);
                transaction.addToBackStack(null);
                transaction.commit();

            }

        }


    }
}

