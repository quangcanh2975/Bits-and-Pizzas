package com.hfad.bitsandpizzas;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;
import androidx.appcompat.widget.ShareActionProvider;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity {

    private ShareActionProvider mShareActionProvider;
    private String[] titles;
    private ListView drawList;

    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Log.d("Pizzas", "clicked");
        }
        private void selectItem(int position){
            Fragment fragment;
            switch (position){
                case 1:
                   fragment = new PizzaFragment();
                   break;

                case 2:
                    fragment = new TopFragment();
                    break;
                case 3:
                    fragment = new StoresFragment();
                    break;
                default:
                    fragment =
                            break;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        titles = getResources().getStringArray(R.array.titles);
        drawList = (ListView) findViewById(R.id.drawer);
        drawList.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_activated_1, titles));
        drawList.setOnItemClickListener(new DrawerItemClickListener());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem menuItem = menu.findItem(R.id.action_share);
        mShareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);
        setIntent("This is the intent");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_create_order:
                Intent intent = new Intent(this, OrderActivity.class);
                startActivity(intent);
                return true;
            case R.id.action_setting:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void setIntent(String text) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, text);
        mShareActionProvider.setShareIntent(intent);
    }
}