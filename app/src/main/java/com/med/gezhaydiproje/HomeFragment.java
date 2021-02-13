package com.med.gezhaydiproje;


import android.graphics.Color;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }

    private RecyclerView categoryRecyclerView;
    private CategoryAdapter categoryAdapter;


    /////////////// Banner Slider
    private ViewPager bannerSliderViewPager;
    private List<SliderModel> sliderModelList;
    private int currentPage = 2;
    private Timer timer;
    final private long DELAY_TIME = 3000;
    final private long PERIOD_TIME = 3000;
    /////////////// Banner Slider

    /////////////// Strip Ad
    private ImageView stripAdImage;
    private ConstraintLayout stripAdContainer;
    /////////////// Strip Ad


    /////////////// Horizontal Product Layout

    private TextView horizontalLayoutTitle;
    private Button horizontalLayoutViewAllBtn;
    private RecyclerView horizontalRecyclerView;


    /////////////// Horizontal Product Layout

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);

        categoryRecyclerView = view.findViewById(R.id.category_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        categoryRecyclerView.setLayoutManager(layoutManager);

        final List<CategoryModel> categoryModelList = new ArrayList<CategoryModel>();
        categoryModelList.add(new CategoryModel("link","home"));
        categoryModelList.add(new CategoryModel("link","Yurt Disi"));
        categoryModelList.add(new CategoryModel("link","Otelli"));
        categoryModelList.add(new CategoryModel("link","Gunubir"));
        categoryModelList.add(new CategoryModel("link","Sehirler"));
        categoryModelList.add(new CategoryModel("link","Ulkeler"));
        categoryModelList.add(new CategoryModel("link","Tatil"));
        categoryModelList.add(new CategoryModel("link","Ucak"));
        categoryModelList.add(new CategoryModel("link","Tren"));
        categoryModelList.add(new CategoryModel("link","Otobus"));

        categoryAdapter = new CategoryAdapter(categoryModelList);
        categoryRecyclerView.setAdapter(categoryAdapter);
        categoryAdapter.notifyDataSetChanged();

        /////////////// Banner Slider

        bannerSliderViewPager = view.findViewById(R.id.banner_slider_view_pager);

        sliderModelList = new ArrayList<SliderModel>();

        sliderModelList.add(new SliderModel(R.drawable.tur7,"#077AE4"));
        sliderModelList.add(new SliderModel(R.drawable.tur8,"#077AE4"));
        sliderModelList.add(new SliderModel(R.drawable.tur1,"#077AE4"));

        sliderModelList.add(new SliderModel(R.drawable.tur2,"#077AE4"));
        sliderModelList.add(new SliderModel(R.drawable.tur3,"#077AE4"));
        sliderModelList.add(new SliderModel(R.drawable.tur4,"#077AE4"));
        sliderModelList.add(new SliderModel(R.drawable.tur5,"#077AE4"));
        sliderModelList.add(new SliderModel(R.drawable.tur6,"#077AE4"));
        sliderModelList.add(new SliderModel(R.drawable.tur7,"#077AE4"));

        sliderModelList.add(new SliderModel(R.drawable.tur8,"#077AE4"));
        sliderModelList.add(new SliderModel(R.drawable.tur1,"#077AE4"));
        sliderModelList.add(new SliderModel(R.drawable.tur2,"#077AE4"));


        SliderAdapter sliderAdapter = new SliderAdapter(sliderModelList);
        bannerSliderViewPager.setAdapter(sliderAdapter);
        bannerSliderViewPager.setClipToPadding(false);
        bannerSliderViewPager.setPageMargin(20);

        bannerSliderViewPager.setCurrentItem(currentPage);

        ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
            }

            @Override
            public void onPageSelected(int i) {
                currentPage = i;
            }

            @Override
            public void onPageScrollStateChanged(int i) {
                if (i == ViewPager.SCROLL_STATE_IDLE){
                    pageLooper();
                }
            }
        };
        bannerSliderViewPager.addOnPageChangeListener(onPageChangeListener);

        startBannerSlideShow();

        bannerSliderViewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                pageLooper();
                stopBannerSlideShow();
                if(event.getAction() == MotionEvent.ACTION_UP){
                    startBannerSlideShow();
                }
                return false;
            }
        });



        /////////////// Banner Slider

        /////////////// Strip Ad

        stripAdImage = view.findViewById(R.id.strip_ad_image);
        stripAdContainer = view.findViewById(R.id.strip_ad_container);

        stripAdImage.setImageResource(R.drawable.tur_alisveris);
        stripAdContainer.setBackgroundColor(Color.parseColor("#077AE4"));

        /////////////// Strip Ad

        /////////////// Horizontal Product Layout

        horizontalLayoutTitle = view.findViewById(R.id.horizontal_scroll_layout_title);
        horizontalLayoutViewAllBtn = view.findViewById(R.id.horizontal_scrool_view_all_btn);
        horizontalRecyclerView = view.findViewById(R.id.horizontal_scroll_layout_recyclerview);

        List<HorizontalProductScrollModel> horizontalProductScrollModelList = new ArrayList<>();
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.tur5,"ITALYA","1 HAFTA TATIL","2000$"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.tur1,"ITALYA","1 HAFTA TATIL","2000$"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.tur2,"ITALYA","1 HAFTA TATIL","2000$"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.tur3,"ITALYA","1 HAFTA TATIL","2000$"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.tur4,"ITALYA","1 HAFTA TATIL","2000$"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.tur6,"ITALYA","1 HAFTA TATIL","2000$"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.tur7,"ITALYA","1 HAFTA TATIL","2000$"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.tur8,"ITALYA","1 HAFTA TATIL","2000$"));

        HorizontalProductScrollAdapter horizontalProductScrollAdapter = new HorizontalProductScrollAdapter(horizontalProductScrollModelList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        horizontalRecyclerView.setLayoutManager(linearLayoutManager);

        horizontalRecyclerView.setAdapter(horizontalProductScrollAdapter);
        horizontalProductScrollAdapter.notifyDataSetChanged();

        /////////////// Horizontal Product Layout

        /////////////// Grid Product Layout

        TextView gridLayoutTitle = view.findViewById(R.id.grid_product_layout_title);
        Button gridLayoutViewAllBtn = view.findViewById(R.id.grid_product__layout_viewall_btn);
        GridView gridView = view.findViewById(R.id.grid_product_layout_gridview);

        gridView.setAdapter(new GridProductLayoutAdapter(horizontalProductScrollModelList));

        /////////////// Grid Product Layout

        return view;
    }

    /////////////// Banner Slider

    private void pageLooper(){
        if(currentPage == sliderModelList.size() -2 ){
            currentPage = 2;
            bannerSliderViewPager.setCurrentItem(currentPage,false);
        }
        if(currentPage == 1){
            currentPage = sliderModelList.size() - 3;
            bannerSliderViewPager.setCurrentItem(currentPage,false);
        }
    }

    private void startBannerSlideShow(){
        final Handler handler = new Handler();
        final Runnable update = new Runnable() {
            @Override
            public void run() {
                if(currentPage >= sliderModelList.size()){
                    currentPage = 1;
                }
                bannerSliderViewPager.setCurrentItem(currentPage++,true);
            }
        };
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(update);
            }
        },DELAY_TIME,PERIOD_TIME);
    }

    private void stopBannerSlideShow(){
        timer.cancel();
    }
    /////////////// Banner Slider

}
