#import "FlutterPluginMapPlugin.h"
#import <flutter_plugin_map/flutter_plugin_map-Swift.h>

@implementation FlutterPluginMapPlugin
+ (void)registerWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar {
  [SwiftFlutterPluginMapPlugin registerWithRegistrar:registrar];
}
@end
