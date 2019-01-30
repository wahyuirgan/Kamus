package top.technopedia.myapplicationkamus;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.Objects;

public class DetailActivity extends AppCompatActivity {

    public static final String ITEM_KOSAKATA    = "kosakata";
    public static final String ITEM_ARTI        = "arti";
    public static final String ITEM_CATEGORY    = "category";

    TextView kosakata, detailarti, kategori;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        if (getSupportActionBar() != null)

        getSupportActionBar().setTitle(getIntent().getStringExtra(ITEM_KOSAKATA));
        Objects.requireNonNull(getSupportActionBar()).setSubtitle(getIntent().getStringExtra(ITEM_CATEGORY));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        kosakata  = findViewById(R.id.tvDetailKosakata);
        detailarti      = findViewById(R.id.tvDetailArti);
        kategori  = findViewById(R.id.tvCategory);

        kosakata.setText(getIntent().getStringExtra(ITEM_KOSAKATA));
        detailarti.setText(getIntent().getStringExtra(ITEM_ARTI));
        kategori.setText(getIntent().getStringExtra(ITEM_CATEGORY));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
