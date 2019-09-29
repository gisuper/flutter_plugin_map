import 'dart:async';
import 'dart:collection';

import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

class FlutterPluginMap {
  static const MethodChannel _channel =
      const MethodChannel('flutter_plugin_map');

  static Future<String> get platformVersion async {
    final String version = await _channel.invokeMethod('getPlatformVersion');
    return version;
  }
  static  Widget get mapView  {
    AndroidView androidView  = AndroidView(viewType: 'MyMap');
    return androidView;
  }
}
