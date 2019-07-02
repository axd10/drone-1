package com.example.droneproject;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.UiThread;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.widget.Toast;

import com.naver.maps.geometry.LatLng;
import com.naver.maps.map.CameraUpdate;
import com.naver.maps.map.LocationTrackingMode;
import com.naver.maps.map.MapFragment;
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.OnMapReadyCallback;
import com.naver.maps.map.overlay.Align;
import com.naver.maps.map.overlay.InfoWindow;
import com.naver.maps.map.overlay.Marker;
import com.naver.maps.map.overlay.PathOverlay;
import com.naver.maps.map.overlay.PolylineOverlay;
import com.naver.maps.map.util.FusedLocationSource;

import java.util.Arrays;

public class MapFragmentActivity extends FragmentActivity
        implements OnMapReadyCallback {

    Context context;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        MapFragment mapFragment = (MapFragment)fm.findFragmentById(R.id.map);
        if (mapFragment == null) {
            mapFragment = MapFragment.newInstance();
            fm.beginTransaction().add(R.id.map, mapFragment).commit();
        }

        context = getApplicationContext();
        mapFragment.getMapAsync(this);
    }

/*    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng SEOUL = new LatLng(37.56, 126.97);
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(SEOUL);
        markerOptions.title("서울");
        markerOptions.snippet("수도");
        googleMap.addMarker(markerOptions);
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(SEOUL);
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(13));
    }*/



    @UiThread
    @Override
    public void onMapReady(@NonNull NaverMap naverMap) {
        LatLng location = new LatLng(35.945021, 126.682829);

        LatLng location2 = new LatLng( 35.967652, 126.736895);
        LatLng location3 = new LatLng( 35.970483, 126.954788);

        LatLng location4 = new LatLng( 35.844426, 127.129364);


        CameraUpdate cameraUpdate = CameraUpdate.scrollAndZoomTo(location, 9);
        Marker marker = new Marker();
        Marker marker2 = new Marker();
        Marker marker3 = new Marker();
        Marker marker4 = new Marker();

      /*  marker.setCaptionText("군산대");
        marker2.setCaptionText("군산시청");
        marker3.setCaptionText("원광대");
        marker4.setCaptionText("전북대");
        marker.setCaptionAlign(Align.Top);
        marker2.setCaptionAlign(Align.Top);
        marker3.setCaptionAlign(Align.Top);
        marker4.setCaptionAlign(Align.Top);*/






        marker4.setPosition(location4);
        marker4.setMap(naverMap);

        marker3.setPosition(location3);
        marker3.setMap(naverMap);

        marker2.setPosition(location2);
        marker2.setMap(naverMap);

        marker.setPosition(location);
        marker.setMap(naverMap);

        ;

        PolylineOverlay polyline = new PolylineOverlay();
        polyline.setCoords(Arrays.asList(
                location,
                location2,
                location3,
                location4
        ));
        polyline.setMap(naverMap);



        InfoWindow infoWindow = new InfoWindow();
        infoWindow.setAdapter(new InfoWindow.DefaultTextAdapter(context) {
            @NonNull
            @Override
            public CharSequence getText(@NonNull InfoWindow infoWindow) {
                return "군산대";
            }
        });
        infoWindow.open(marker);

        InfoWindow infoWindow2 = new InfoWindow();
        infoWindow2.setAdapter(new InfoWindow.DefaultTextAdapter(context) {
            @NonNull
            @Override
            public CharSequence getText(@NonNull InfoWindow infoWindow) {
                return "군산시청";
            }
        });
        infoWindow2.open(marker2);

        InfoWindow infoWindow3 = new InfoWindow();
        infoWindow3.setAdapter(new InfoWindow.DefaultTextAdapter(context) {
            @NonNull
            @Override
            public CharSequence getText(@NonNull InfoWindow infoWindow) {
                return "원광대";
            }
        });
        infoWindow3.open(marker3);

        InfoWindow infoWindow4 = new InfoWindow();
        infoWindow4.setAdapter(new InfoWindow.DefaultTextAdapter(context) {
            @NonNull
            @Override
            public CharSequence getText(@NonNull InfoWindow infoWindow) {
                return "전북대";
            }
        });
        infoWindow4.open(marker4);

        naverMap.moveCamera(cameraUpdate);
       // naverMap.setMapType(NaverMap.MapType.Hybrid);








    }
}