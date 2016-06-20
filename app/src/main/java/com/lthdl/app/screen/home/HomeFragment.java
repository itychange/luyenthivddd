package com.lthdl.app.screen.home;

import android.app.Activity;
import android.app.SearchManager;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lthdl.app.BaseFragment;
import com.lthdl.app.R;
import com.lthdl.app.common.GetJsonApiUtils;
import com.lthdl.app.common.widget.taskbar.SupportBar;
import com.lthdl.app.common.widget.textview.CTextView;
import com.lthdl.app.global.Constant;
import com.lthdl.app.model.User;
import com.lthdl.app.network.ApiClient;
import com.lthdl.app.network.ApiInterface;
import com.lthdl.app.screen.home.adapter.HomeAdapter;
import com.lthdl.app.screen.home.event.OnEventInformation;
import com.lthdl.app.screen.home.fragment.HomeListFragment;
import com.lthdl.app.screen.home.fragment.HomeListHasGroupFragment;
import com.lthdl.app.screen.home.fragment.MyBoook;
import com.lthdl.app.screen.naptien.event.OnEventOpenNapTienActivity;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends BaseFragment {
    public static final String CLASS_NAME = " HomeFragment ";
    public static final int HOME = 0;
    public static final int NEW = 1;
    public static final int MY_BOOK = 2;
    public static final int BOOK_MARKET = 3;

    @IntDef({HOME, NEW, MY_BOOK, BOOK_MARKET})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Tabs {
    }

    @Tabs
    int currentTab = HOME;

    @Bind(R.id.collapseToolbar)
    CollapsingToolbarLayout collapseToolbar;

    @Bind(R.id.drawerLayout)
    DrawerLayout drawer;

    @Bind(R.id.imvHeader)
    ImageView imvHeader;

    @Bind(R.id.navDanhMucKyThi)
    View navDanhMucKyThi;

    @Bind(R.id.navFanpage)
    View navFanpage;

    @Bind(R.id.navHome)
    View navHome;

    @Bind(R.id.navMyBook)
    View navMyBook;

    @Bind(R.id.navSoDu)
    View navSoDu;

    @Bind(R.id.navTaiKhoan)
    View navTaiKhoan;

    @Bind(R.id.navTienThuong)
    View navTienThuong;

    @Bind(R.id.pagerContainer)
    ViewPager pagerContainer;
    MenuItem searchItem;
    SearchView searchView = null;

    @Bind(R.id.supportBar)
    SupportBar supportBar;
    MenuItem supportItem;

    @Bind(R.id.tabLayout)
    TabLayout tabLayout;

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Bind(R.id.tvDanhMucKyThi)
    CTextView tvDanhMucKyThi;

    @Bind(R.id.tvFanpage)
    CTextView tvFanpage;

    @Bind(R.id.tvHome)
    CTextView tvHome;

    @Bind(R.id.tvMyBook)
    CTextView tvMyBook;

    @Bind(R.id.tvSoDu)
    CTextView tvSoDu;

    @Bind(R.id.tvTaiKhoan)
    CTextView tvTaiKhoan;

    @Bind(R.id.tvTienThuong)
    CTextView tvTienThuong;

    @Bind(R.id.appBar)
    AppBarLayout appBar;

    private void changeTabsFont() {
        ViewGroup localViewGroup1 = (ViewGroup) tabLayout.getChildAt(0);
        int k = localViewGroup1.getChildCount();
        int i = 0;
        while (i < k) {
            ViewGroup localViewGroup2 = (ViewGroup) localViewGroup1.getChildAt(i);
            int m = localViewGroup2.getChildCount();
            int j = 0;
            while (j < m) {
                View localView = localViewGroup2.getChildAt(j);
                if ((localView instanceof TextView))
                    ((TextView) localView).setTypeface(Typeface.createFromAsset(getAssets(), "font/SourceSansPro-Regular.otf"));
                j += 1;
            }
            i += 1;
        }
    }

    private void resetUI() {
        tvHome.setNormal();
        tvMyBook.setNormal();
        tvDanhMucKyThi.setNormal();
        tvSoDu.setNormal();
        tvTienThuong.setNormal();
        tvTaiKhoan.setNormal();
        tvFanpage.setNormal();
        navHome.setSelected(false);
        navMyBook.setSelected(false);
        navDanhMucKyThi.setSelected(false);
        navSoDu.setSelected(false);
        navTienThuong.setSelected(false);
        navTaiKhoan.setSelected(false);
        navFanpage.setSelected(false);
        drawer.closeDrawer(GravityCompat.START);
        changeTabsFont();
    }

    private void setItemsVisibility(Menu paramMenu, MenuItem paramMenuItem, boolean paramBoolean) {
        int i = 0;
        while (i < paramMenu.size()) {
            MenuItem localMenuItem = paramMenu.getItem(i);
            if (localMenuItem != paramMenuItem)
                localMenuItem.setVisible(paramBoolean);
            i += 1;
        }
    }

    private void updateTabIfNeeded(boolean paramBoolean) {
        resetUI();
        Log.e(Constant.TAG, CLASS_NAME + "updateTabIfNeeded()-> currentTab == " + currentTab);
        switch (currentTab) {
            case HOME:
                navHome.setSelected(true);
                tvHome.setBold();
                break;
            case MY_BOOK:
                navMyBook.setSelected(true);
                tvMyBook.setBold();
                break;
            default:
        }
        if (!paramBoolean) {
            pagerContainer.setCurrentItem(currentTab, true);
        }
    }

    public boolean isConnected(){
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Activity.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected())
            return true;
        else
            return false;
    }

    protected void init() {
        final HomeAdapter localHomeAdapter = new HomeAdapter(getSupportFragmentManager());

/*        localHomeAdapter.addFrag(new HomeListHasGroupFragment(), "Trang chủ");
        localHomeAdapter.addFrag(new HomeListFragment(), "Mới nhất");
        localHomeAdapter.addFrag(new HomeListFragment(), "My Book");
        localHomeAdapter.addFrag(new HomeListHasGroupFragment(), "Siêu thị sách");*/

        pagerContainer.setAdapter(localHomeAdapter);
        pagerContainer.setOffscreenPageLimit(10);
        tabLayout.setupWithViewPager(pagerContainer);
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            public void onTabReselected(TabLayout.Tab paramTab) {
            }

            public void onTabSelected(TabLayout.Tab paramTab) {
                pagerContainer.setCurrentItem(paramTab.getPosition());
            }

            public void onTabUnselected(TabLayout.Tab paramTab) {
            }
        });
        pagerContainer.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageScrollStateChanged(int paramInt) {
                switch (paramInt) {
                    case 0:
                        updateTabIfNeeded(true);
                        break;
                    default:
                }
            }

            public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {
            }

            public void onPageSelected(int paramInt) {
                Log.e(Constant.TAG, CLASS_NAME + "updateTabIfNeeded()-> onPageSelected == " + (paramInt));
                switch (paramInt) {
                    case HOME:
                        setCurrentTab(HOME);
                        imvHeader.setImageResource(R.drawable.image_headerbackground1);
                        break;
                    case NEW:
                        setCurrentTab(NEW);
                        imvHeader.setImageResource(R.drawable.image_headerbackground2);
                        break;
                    case MY_BOOK:
                        setCurrentTab(MY_BOOK);
                        imvHeader.setImageResource(R.drawable.image_headerbackground2);
                        break;
                    case BOOK_MARKET:
                        setCurrentTab(BOOK_MARKET);
                        imvHeader.setImageResource(R.drawable.image_headerbackground3);
                        break;
                    default:
                }
            }
        });
        drawer.setScrimColor(getResources().getColor(R.color.home_nav_dimm));
        supportBar.hide();
        updateTabIfNeeded(false);

        if (isConnected()) {
            new GetJsonApiUtils() {
                @Override
                protected void onPostExecute(String result) {
                    //super.onPostExecute(result);
                    //HomeAdapter apiHomeAdapter = new HomeAdapter(getSupportFragmentManager());

                    try {
                        JSONObject obj = new JSONObject(result);
                        JSONArray items = obj.getJSONArray("items");
                        String item_name = "";
                        String item_menu_type = "";



                        for (int i = 0; i < items.length(); i++) {
                            JSONObject item = items.getJSONObject(i);
                            item_name = item.getString("name");
                            item_menu_type = item.getString("menu_type");

                            localHomeAdapter.addFrag(
                                    item_menu_type.equals("1") ? new HomeListHasGroupFragment() : new HomeListFragment(),
                                    item_name);
                        }
                        //pagerContainer.setAdapter(apiHomeAdapter);
                        localHomeAdapter.notifyDataSetChanged();

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }.execute("https://ebook-1310.appspot.com/api/menus");
        }
    }

    protected void init(View paramView) {
        setHasOptionsMenu(true);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setElevation(0.0F);
        ActionBarDrawerToggle LocalActionBarDrawerToggle = new ActionBarDrawerToggle(getActivity(), drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        this.drawer.setDrawerListener(LocalActionBarDrawerToggle);
        LocalActionBarDrawerToggle.syncState();
        init();
    }

    @OnClick({R.id.navHome, R.id.navMyBook, R.id.navDanhMucKyThi, R.id.navNapThem, R.id.navSoDu, R.id.navTienThuong})
    public void navItemClick(View paramView) {
        switch (paramView.getId()) {
            case R.id.navDanhMucKyThi:
            case R.id.navSoDu:
            default:
                break;
            case R.id.navHome:
                currentTab = HOME;
                updateTabIfNeeded(false);
                break;
            case R.id.navMyBook:
                /*currentTab = MY_BOOK;
                updateTabIfNeeded(false);*/
                MyBoook nextFrag= new MyBoook();
                this.getFragmentManager().beginTransaction()
                        .replace(R.id.content, nextFrag,"null")
                        .addToBackStack(null)
                        .commit();
                updateTabIfNeeded(false);

                break;
            case R.id.navNapThem:
                EventBus.getDefault().post(new OnEventOpenNapTienActivity());
        }
    }

    public boolean onBackPressed() {
        if (this.drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }
        return super.onBackPressed();
    }

    public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater) {
        super.onCreateOptionsMenu(paramMenu, paramMenuInflater);
        paramMenuInflater.inflate(R.menu.home, paramMenu);
        searchItem = paramMenu.findItem(R.id.menuSearch);
        supportItem = paramMenu.findItem(R.id.menuSupport);
        supportItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem paramMenuItem) {
                supportBar.toggle();
                return true;
            }
        });
        SearchManager searchManager = (SearchManager) getSystemService("search");

        if (searchItem != null)
            searchView = ((SearchView) searchItem.getActionView());
        if (searchView != null)
            searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        if (searchView != null) {
            final Menu paramMenu1 = paramMenu;
            searchView.setOnSearchClickListener(new View.OnClickListener() {
                public void onClick(View paramView) {
                    setItemsVisibility(paramMenu1, searchItem, false);
                    searchView.requestFocusFromTouch();
                }
            });
            searchView.setOnCloseListener(new SearchView.OnCloseListener() {
                public boolean onClose() {
                    setItemsVisibility(paramMenu1, searchItem, true);
                    return false;
                }
            });
        }
    }
    @Nullable
    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        setRetainInstance(true);
        View view=paramLayoutInflater.inflate(R.layout.home_activity, paramViewGroup, false);
        ButterKnife.bind(getActivity());
        CTextView tvName= (CTextView) view.findViewById(R.id.name);
        collapseToolbar= (CollapsingToolbarLayout) view.findViewById(R.id.collapseToolbar);
        appBar= (AppBarLayout) view.findViewById(R.id.appBar);
        CTextView tvEmail= (CTextView) view.findViewById(R.id.email);
        CTextView tvSoDuNumber= (CTextView) view.findViewById(R.id.sodu);
        CTextView tvTienThuongNumber= (CTextView) view.findViewById(R.id.tienthuong);
        CircleImageView profile_image= (CircleImageView) view.findViewById(R.id.profile);
        getInformation(tvName,tvEmail,tvSoDuNumber,tvTienThuongNumber,profile_image);
        initCollapsingToolbar();
        return view;
    }

    public void getInformation(final CTextView tvName, final CTextView tvEmail, final CTextView tvSoDu, final CTextView tvTienThuong, final CircleImageView profile){
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call call= apiService.getMenungang("5709255063633920");
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Log.i("null","---->"+response.body().getName());
                User user=new User();
                user.setName(response.body().getName());
                user.setEmail(response.body().getEmail());
                user.setSoDu(response.body().getSoDu());
                user.setTienThuong(response.body().getTienThuong());
                user.setThumbnail(response.body().getThumbnail());
                EventBus.getDefault().post(new OnEventInformation(user));

                tvName.setText(user.getName());
                tvEmail.setText(user.getEmail());
                tvSoDu.setText(user.getSoDu());
                tvTienThuong.setText(user.getTienThuong());
                Glide.with(HomeFragment.this)
                        .load(user.getThumbnail())
                        .centerCrop()
                        .crossFade()
                        .into(profile);

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }
    private void initCollapsingToolbar() {
        collapseToolbar.setTitle(" ");
        appBar.setExpanded(true);

        // hiding & showing the title when toolbar expanded & collapsed
        appBar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapseToolbar.setTitle(getString(R.string.app_name));
                    isShow = true;
                } else if (isShow) {
                    collapseToolbar.setTitle(" ");
                    isShow = false;
                }
            }
        });
    }
    public void onResume() {
        super.onResume();
        changeTabsFont();
    }

    public void setCurrentTab(@Tabs int iCurrentTab) {
        this.currentTab = iCurrentTab;
    }

    @Tabs
    public int getCurrentTab() {
        return currentTab;
    }
}