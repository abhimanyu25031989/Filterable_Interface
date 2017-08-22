package example.com.abhi.filterable_interface;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  implements
        SearchView.OnQueryTextListener {

    ListView lv;
    SearchView search_view;

    String[] country_names , iso_codes ;
    TypedArray country_flags ;

    ArrayList<Country> countrylist ;
    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) findViewById(R.id.list_view);
        search_view = (SearchView) findViewById(R.id.search_view);

        country_names = getResources().getStringArray(R.array.country_names);
        iso_codes = getResources().getStringArray(R.array.iso_Code);
        country_flags = getResources().obtainTypedArray(R.array.country_flags);

        countrylist = new ArrayList<Country>();
        for (int i = 0; i < country_names.length; i++) {
            Country country = new Country(country_names[i] , iso_codes[i] ,
                    country_flags.getResourceId(i, -1) );
            countrylist.add(country);
        }

        adapter = new CustomAdapter(getApplicationContext(), countrylist );
        lv.setAdapter(adapter);

        search_view.setOnQueryTextListener(this);
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        adapter.getFilter().filter(newText);
        return false;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }
}
