package ge.quickscope.news.whataboutnews;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.github.florent37.materialviewpager.MaterialViewPager;
import com.github.florent37.materialviewpager.header.HeaderDesign;

import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;
import ge.quickscope.news.whataboutnews.fragments.RecyclerViewFragment;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.materialViewPager)
    MaterialViewPager mViewPager;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        setTitle("");

        toolbar = mViewPager.getToolbar();

        if(toolbar != null){
            setSupportActionBar(toolbar);

            ActionBar actionBar = getSupportActionBar();
            if(actionBar != null){
                actionBar.setDisplayHomeAsUpEnabled(true);
                actionBar.setDisplayShowHomeEnabled(true);
                actionBar.setDisplayShowTitleEnabled(true);
                actionBar.setDisplayUseLogoEnabled(false);
                actionBar.setHomeButtonEnabled(true);
            }
        }


        mViewPager.getViewPager().setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch (position % 4){
                    default:
                        return RecyclerViewFragment.newInstance();
                }
            }

            @Override
            public int getCount() {
                return 4;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                switch (position % 4){
                    case 0:
                        return "ახალი ამბები";
                    case 1:
                        return "ბიზნესი";
                    case 2:
                        return "სპორტი";
                    case 3:
                        return "ტექნოლოგიები";
                }
                return "";
            }
        });

        mViewPager.setMaterialViewPagerListener(new MaterialViewPager.Listener() {
            @Override
            public HeaderDesign getHeaderDesign(int page) {
                switch (page) {
                    case 0:
                        String k = "https://fs01.androidpit.info/a/63/0e/android-l-wallpapers-630ea6-h900.jpg";
                        String k2 = "http://www.sportall.ge/pictures/image31/edc0a417054c69f7d5c544ab14467db0.jpg";

                        Random random = new Random();
                        int rand = random.nextInt(2);

                        String result = "";

                        if(rand == 0) result = k;
                        else result = k2;

//                        return HeaderDesign.fromColorResAndUrl(
//                                R.color.green,
//                                "https://fs01.androidpit.info/a/63/0e/android-l-wallpapers-630ea6-h900.jpg");
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.green,
                                result);
                    case 1:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.blue,
                                "http://cdn1.tnwcdn.com/wp-content/blogs.dir/1/files/2014/06/wallpaper_51.jpg");
                    case 2:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.cyan,
                                "http://www.droid-life.com/wp-content/uploads/2014/10/lollipop-wallpapers10.jpg");
                    case 3:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.red,
                                "http://www.tothemobile.com/wp-content/uploads/2014/07/original.jpg");
                }

                //execute others actions if needed (ex : modify your header logo)

                return null;
            }
        });

        mViewPager.getViewPager().setOffscreenPageLimit(mViewPager.getViewPager().getAdapter().getCount());
        mViewPager.getPagerTitleStrip().setViewPager(mViewPager.getViewPager());

        View logo = findViewById(R.id.logo_white);
        if(logo != null)
            logo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    mViewPager.notifyHeaderChanged();
                    Toast.makeText(getApplicationContext(), "Yes, the title is clickable", Toast.LENGTH_SHORT).show();
                }
            });
    }
}
