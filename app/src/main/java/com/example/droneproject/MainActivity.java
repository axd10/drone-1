package com.example.droneproject;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.widget.Toast;

        import com.naver.maps.geometry.LatLng;
        import com.naver.maps.map.NaverMapSdk;
        import com.naver.maps.map.overlay.Marker;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        NaverMapSdk.getInstance(this).setClient(new NaverMapSdk.NaverCloudPlatformClient("5dnt5fafi4"));


    }
}
