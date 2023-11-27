package com.example.revisionmobileexam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GestureDetectorCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.gesture.GestureOverlayView;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.revisionmobileexam.Data.ParcelData;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener , GestureOverlayView.OnGestureListener, GestureDetector.OnDoubleTapListener {

    private DrawerLayout dLayout;
    private List<ParcelData> parcelDataList;

    private ParcelData data;

    private Fragment1 fragment1;

    private Fragment1 fragment2;

    private GestureDetectorCompat gDetector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar); //récupère la référence de la barre d'outils
        toolbar.setTitle("ToolBar"); // définir le titre de la barre d'outils
      //  toolbar.setLogo(R.drawable.menu_icon); // définir le logo de la barre d'outils

        dLayout = findViewById(R.id.drawerlayout);
        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,dLayout,toolbar,R.string.open_nav,R.string.close_nav);

        dLayout.addDrawerListener(toggle);
        toggle.syncState();


        if (savedInstanceState==null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Fragment1()).commit();
            navigationView.setCheckedItem(R.id.nav_chalet);
        }

        parcelDataList = new ArrayList<>();
        parcelDataList.add(new ParcelData("Item 1", 1));
        parcelDataList.add(new ParcelData("Item 2", 2));

        data = new ParcelData("Item 3", 3);


        DrawerLayout myLayout = findViewById(R.id.drawerlayout);
        //Associer au Widget (View) un écouteur
        myLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                handleTouch(event);
                return true;
            }
        });


        //this.gDetector = new GestureDetectorCompat((Context) this, (GestureDetector.OnGestureListener) this);
        //gDetector.setOnDoubleTapListener(this);

    }

    void handleTouch(MotionEvent m)
    {
        Log.i("Testmotionevent","screen touched");

        TextView textView1 = findViewById(R.id.text3);
        TextView textView2 = findViewById(R.id.text1);
        int pointerCount = m.getPointerCount();
        for (int i = 0; i < pointerCount; i++)
        {
            int x = (int) m.getX(i);
            int y = (int) m.getY(i);
            int id = m.getPointerId(i);
            int action = m.getActionMasked();
            int actionIndex = m.getActionIndex();
            String actionString;
            switch (action)
            { case MotionEvent.ACTION_DOWN:
                actionString = "DOWN";
                break;
                case MotionEvent.ACTION_UP:
                    actionString = "UP";
                    break;
                case MotionEvent.ACTION_POINTER_DOWN:
                    actionString = "PNTR DOWN";
                    break;
                case MotionEvent.ACTION_POINTER_UP:
                    actionString = "PNTR UP";
                    break;
                case MotionEvent.ACTION_MOVE:
                    actionString = "MOVE";
                    break;
                default:
                    actionString = "";
            }
            String touchStatus = "Action: " + actionString + " Index: " + actionIndex + " ID: " + id + " X: " + x + " Y: " + y;
            if (id == 0)
                textView1.setText(touchStatus);
            else
                textView2.setText(touchStatus);
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.dick) {
            Toast.makeText(getApplicationContext(), "Test", Toast.LENGTH_LONG+1).show();

        } else if (id == R.id.nav_gay) {
            Toast.makeText(getApplicationContext(), "Android gay", Toast.LENGTH_LONG+1).show();
        }
        return true;
    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {


        //data simple
        if (item.getItemId()==R.id.nav_gay){

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, Fragment1.newInstance(data)).commit();
        }
        //data list
        if (item.getItemId()==R.id.nav_chalet){

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,Fragment2.newInstance(parcelDataList)).commit();
        }

        dLayout.closeDrawer(GravityCompat.START);

        return true;
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    public void onGestureStarted(GestureOverlayView overlay, MotionEvent event) {

    }

    @Override
    public void onGesture(GestureOverlayView overlay, MotionEvent event) {

    }

    @Override
    public void onGestureEnded(GestureOverlayView overlay, MotionEvent event) {

    }

    @Override
    public void onGestureCancelled(GestureOverlayView overlay, MotionEvent event) {

    }

    @Override
    public boolean onSingleTapConfirmed(@NonNull MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDoubleTap(@NonNull MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(@NonNull MotionEvent e) {
        return false;
    }
}
