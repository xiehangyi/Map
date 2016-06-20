package com.xhy.map;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.xhy.map.fragment.MapFragment;
import com.xhy.map.fragment.MineFragment;
import com.xhy.map.fragment.NearFragment;
import com.xhy.map.fragment.PathFragment;


public class MainActivity extends AppCompatActivity {




    private BottomNavigationBar bottomNavigationBar;
    private MapFragment mapFragment;
    private NearFragment nearFragment;
    private PathFragment pathFragment;
    private MineFragment mineFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initFragment();

    }

    private void initFragment() {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        hideFragment(fragmentTransaction);
        mapFragment = new MapFragment();
        fragmentTransaction.add(R.id.ll_root,mapFragment);
        fragmentTransaction.commit();


    }

    private void initView() {

        bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_id);
        bottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.ic_star_24dp,"地图"));
        bottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.ic_location_on_24dp,"附近"));
        bottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.ic_trending_up_24dp,"路线"));
        bottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.ic_person_24dp,"我的"));
        bottomNavigationBar.initialise();
        initFragment();
        bottomNavigationBar.setTabSelectedListener(new TABListener());
    }


    private void hideFragment(FragmentTransaction fragmentTransaction) {
        if(mapFragment != null){
            fragmentTransaction.hide(mapFragment);
        }
        if(nearFragment != null){
            fragmentTransaction.hide(nearFragment);
        }
        if(pathFragment != null){
            fragmentTransaction.hide(pathFragment);
        }
        if(mineFragment != null){
            fragmentTransaction.hide(mineFragment);
        }

    }

    private class TABListener implements BottomNavigationBar.OnTabSelectedListener {


        @Override
        public void onTabSelected(int position) {

            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            hideFragment(fragmentTransaction);
            switch(position){
                case 0:
                    if(mapFragment == null){
                        mapFragment = new MapFragment();
                        fragmentTransaction.add(R.id.ll_root,mapFragment);
                    } else {
                        fragmentTransaction.show(mapFragment);
                    }
                    break;
                case 1:
                    if(nearFragment == null){
                        nearFragment = new NearFragment();
                        fragmentTransaction.add(R.id.ll_root,nearFragment);
                    } else {
                        fragmentTransaction.show(nearFragment);
                    }
                    break;
                case 2:
                    if(pathFragment == null){
                        pathFragment = new PathFragment();
                        fragmentTransaction.add(R.id.ll_root,pathFragment);
                    } else {
                        fragmentTransaction.show(pathFragment);
                    }
                    break;
                case 3:
                    if(mineFragment == null){
                        mineFragment = new MineFragment();
                        fragmentTransaction.add(R.id.ll_root,mineFragment);
                    } else {
                        fragmentTransaction.show(mineFragment);
                    }
                    break;


            }
            fragmentTransaction.commit();


        }



        @Override
        public void onTabUnselected(int position) {

        }

        @Override
        public void onTabReselected(int position) {

        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

       // getMenuInflater().inflate(R.menu.main, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        if(item.getItemId() == R.id.item_loc){
//
//
//        } else if (item.getItemId() == R.id.item_loc2) {
//
//
//        }
        return super.onOptionsItemSelected(item);
    }





}
