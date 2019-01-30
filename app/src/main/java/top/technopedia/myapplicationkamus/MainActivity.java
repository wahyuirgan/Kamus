package top.technopedia.myapplicationkamus;

import android.database.SQLException;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.Objects;

import top.technopedia.myapplicationkamus.Adapter.SearchAdapter;
import top.technopedia.myapplicationkamus.Helper.KamusHelper;
import top.technopedia.myapplicationkamus.Model.KamusModel;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, SearchView.OnQueryTextListener {

    private KamusHelper kamusHelper;
    private SearchAdapter searchAdapter;

    private ArrayList<KamusModel> list = new ArrayList<>();

    RecyclerView recyclerView;
    SearchView searchView;
    String lang_selection;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(0).setChecked(true);

        recyclerView = findViewById(R.id.recycler_view);

        searchView = findViewById(R.id.search_bar);
        searchView.onActionViewExpanded();
        searchView.setOnQueryTextListener(this);

        kamusHelper = new KamusHelper(this);
        searchAdapter = new SearchAdapter();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(searchAdapter);

        //get Default English - Indonesia
        lang_selection = "Eng";
        getData(lang_selection, "");
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void getData(String selection, String search) {
        try {
            kamusHelper.open();
            if (search.isEmpty()) {
                list = kamusHelper.getAllData(selection);
            } else {
                list = kamusHelper.getDataByName(search, selection);
            }

            String title = null;
            String hint = null;
            if (Objects.equals(selection, "Eng")) {
                title   = getResources().getString(R.string.eng_to_ina);
                hint    = getResources().getString(R.string.search);
            } else {
                title = getResources().getString(R.string.ina_to_eng);
                hint    = getResources().getString(R.string.cari);
            }

            if (getSupportActionBar() != null)

            getSupportActionBar().setSubtitle(title);
            searchView.setQueryHint(hint);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            kamusHelper.close();
        }
        searchAdapter.replaceAll(list);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.nav_english_to_indo) {
            lang_selection = "Eng";
            getData(lang_selection, "");
        } else if (id == R.id.nav_indo_to_english) {
            lang_selection = "Ind";
            getData(lang_selection, "");
        }

        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public boolean onQueryTextSubmit(String keyword) {
        getData(lang_selection, keyword);
        return false;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public boolean onQueryTextChange(String keyword) {
        getData(lang_selection, keyword);
        return false;
    }
}
