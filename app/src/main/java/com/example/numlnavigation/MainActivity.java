package com.example.numlnavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.numlnavigation.Fragment.FragmentHome;
import com.example.numlnavigation.Fragment.MapFragment;
import com.example.numlnavigation.Fragment.RouteFragment;
import com.example.numlnavigation.Fragment.SeacrhFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();


        bottomNavigationView=findViewById(R.id.bottomnavigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.container,new FragmentHome()).commit();
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment=null;



                switch (item.getItemId()){
                    case R.id.Home:
                        fragment=new FragmentHome();
                       // fragmentTransaction.replace(R.id.container,new FragmentHome());
                        break;
                    case R.id.Map:
                        fragment=new MapFragment();
                       // Toast.makeText(MainActivity.this, "Map", Toast.LENGTH_SHORT).show();
                        //fragmentTransaction.replace(R.id.container,new MapFragment());
                        break;
                    case R.id.Search:
                        fragment=new SeacrhFragment();
                       // fragmentTransaction.replace(R.id.container,new SeacrhFragment());
                        break;
                    case R.id.Route:
                        fragment=new RouteFragment();
                       // fragmentTransaction.replace(R.id.container,new RouteFragment());
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + item.getItemId());
                }
               // fragmentTransaction.commit();
                getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();
                return true;
            }
        });
    }
}