package com.map.baidu.flutter_plugin_map;

import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.MapView;

import java.util.Map;

import io.flutter.app.FlutterActivity;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry.Registrar;

/**
 * Created by yangxiong on 2019/9/29.
 */
public class FlutterPluginMapPlugin implements MethodChannel.MethodCallHandler {

    public static void registerWith(Registrar registrar){
        FlutterActivity activity  = (FlutterActivity) registrar.activity();
        // 初始化百度地图 SDK
        SDKInitializer.initialize(activity.getApplicationContext());
        SDKInitializer.setCoordType(CoordType.BD09LL);
        MapView mapView = new MapView(activity);
        MapRegistrant.registerWith(activity, mapView);

        MethodChannel channel =new  MethodChannel(registrar.messenger(), "flutter_plugin_map");
        channel.setMethodCallHandler(new FlutterPluginMapPlugin());

    }

    @Override
    public void onMethodCall(MethodCall call, MethodChannel.Result result) {
        if (call.method.equals("getPlatformVersion")) {
            //开始定位
           /* mLocationClient.start();*/
            result.success("getPlatformVersion666");
        }else if (call.method.equals("poi_search")){
            final Map<String, Object> arguments = call.arguments();
            String city = (String) arguments.get("city");
            String poi = (String) arguments.get("poi");

     /*       mPoiSearch.searchInCity(new PoiCitySearchOption()
                    .city(city) //必填
                    .keyword(poi) //必填
                    .pageNum(10));
            result.success("poi_search");*/
            result.success("poi_search");
        } else {
            result.notImplemented();
        }
    }
}
