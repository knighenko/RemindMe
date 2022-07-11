package com.knyzhenko.remindme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toolbar;

import com.google.android.material.tabs.TabLayout;
import com.knyzhenko.remindme.adapters.PagerAdapter;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager2 viewPager;
    private PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        initToolbar();
        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);
        FragmentManager fragmentManager = getSupportFragmentManager();
        pagerAdapter = new PagerAdapter(fragmentManager, getLifecycle());
        viewPager.setAdapter(pagerAdapter);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });
    }

    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.toolbar_title);

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.sub_menu_de) {
                    ///to change language
                    String languageToLoad = "de";
                    Locale locale = new Locale(languageToLoad);
                    Locale.setDefault(locale);
                    Configuration config = new Configuration();
                    config.locale = locale;
                    getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
                    setContentView(R.layout.activity_main);
                    initToolbar();
                    tabLayout = findViewById(R.id.tab_layout);
                    viewPager = findViewById(R.id.view_pager);
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    pagerAdapter = new PagerAdapter(fragmentManager, getLifecycle());
                    viewPager.setAdapter(pagerAdapter);
                    tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                        @Override
                        public void onTabSelected(TabLayout.Tab tab) {
                            viewPager.setCurrentItem(tab.getPosition());
                        }

                        @Override
                        public void onTabUnselected(TabLayout.Tab tab) {

                        }

                        @Override
                        public void onTabReselected(TabLayout.Tab tab) {

                        }
                    });
                    viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
                        @Override
                        public void onPageSelected(int position) {
                            super.onPageSelected(position);
                            tabLayout.selectTab(tabLayout.getTabAt(position));
                        }
                    });
                    //
                    return true;
                }

                if (id == R.id.sub_menu_en) {
///to change language
                    String languageToLoad = "en";
                    Locale locale = new Locale(languageToLoad);
                    Locale.setDefault(locale);
                    Configuration config = new Configuration();
                    config.locale = locale;
                    getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
                    setContentView(R.layout.activity_main);
                    initToolbar();
                    tabLayout = findViewById(R.id.tab_layout);
                    viewPager = findViewById(R.id.view_pager);
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    pagerAdapter = new PagerAdapter(fragmentManager, getLifecycle());
                    viewPager.setAdapter(pagerAdapter);
                    tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                        @Override
                        public void onTabSelected(TabLayout.Tab tab) {
                            viewPager.setCurrentItem(tab.getPosition());
                        }

                        @Override
                        public void onTabUnselected(TabLayout.Tab tab) {

                        }

                        @Override
                        public void onTabReselected(TabLayout.Tab tab) {

                        }
                    });
                    viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
                        @Override
                        public void onPageSelected(int position) {
                            super.onPageSelected(position);
                            tabLayout.selectTab(tabLayout.getTabAt(position));
                        }
                    });
                    //

                    return true;
                }
                if (id == R.id.sub_menu_ru) {
///to change language
                    String languageToLoad = "ru";
                    Locale locale = new Locale(languageToLoad);
                    Locale.setDefault(locale);
                    Configuration config = new Configuration();
                    config.locale = locale;
                    getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
                   setContentView(R.layout.activity_main);
                    initToolbar();
                    tabLayout = findViewById(R.id.tab_layout);
                    viewPager = findViewById(R.id.view_pager);
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    pagerAdapter = new PagerAdapter(fragmentManager, getLifecycle());
                    viewPager.setAdapter(pagerAdapter);
                    tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                        @Override
                        public void onTabSelected(TabLayout.Tab tab) {
                            viewPager.setCurrentItem(tab.getPosition());
                        }

                        @Override
                        public void onTabUnselected(TabLayout.Tab tab) {

                        }

                        @Override
                        public void onTabReselected(TabLayout.Tab tab) {

                        }
                    });
                    viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
                        @Override
                        public void onPageSelected(int position) {
                            super.onPageSelected(position);
                            tabLayout.selectTab(tabLayout.getTabAt(position));
                        }
                    });
                    //

                    return true;
                }

                return onOptionsItemSelected(item);
            }
        });
        toolbar.inflateMenu(R.menu.menu);

    }
}