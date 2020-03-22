package com.example.appesieav2.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.appesieav2.Fragment.CalendrierFragment;
import com.example.appesieav2.Fragment.EDTFragment;
import com.example.appesieav2.Fragment.EmailFragment;
import com.example.appesieav2.Fragment.OrganigrammeFragment;
import com.example.appesieav2.Fragment.ProgrammeFragment;
import com.example.appesieav2.R;
import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);   // Set the toolbar to act like an action bar in this activity.
        getSupportActionBar().setDisplayShowTitleEnabled(false);    // Supprime le texte de la toolbar.

        drawer = findViewById(R.id.drawer_layout);


        NavigationView navigationView = findViewById(R.id.navigation);
        navigationView.setNavigationItemSelectedListener(this);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState==null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new EDTFragment()).commit();
            navigationView.setCheckedItem(R.id.edt);
        }
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.calendrier:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new CalendrierFragment()).commit();
                break;
            case R.id.edt:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new EDTFragment()).commit();
                break;
            case R.id.organigramme:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new OrganigrammeFragment()).commit();
                break;
            case R.id.pedagogie:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ProgrammeFragment()).commit();
                break;
            case R.id.email:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new EmailFragment()).commit();
                break;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
