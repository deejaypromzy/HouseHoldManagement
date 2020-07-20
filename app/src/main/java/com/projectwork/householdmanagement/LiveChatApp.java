//package com.projectwork.householdmanagement;
//
//import android.app.Application;
//import android.provider.Settings;
//
//import com.google.android.gms.common.api.Response;
//
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
//
//public class LiveChatApp extends Application {
//
//
//    @Override
//    public void onCreate() {
//        super.onCreate();
//        // Initialize Smooch with your app id
//        // Get your own at https://app.smooch.io/
//        // and paste it here!
//        Smooch.init(this, new Settings("5aaed64c891651002256f5dd"), new SmoochCallback() {
//            @Override
//            public void run(Response response) {
//                // Handle init response here!
//            }
//        });
//        addSomeProperties(User.getCurrentUser());
//    }
//
//
//    private void addSomeProperties(final User user) {
//        final Map<String, Object> customProperties = new HashMap<>();
//        // Identify user with default properties
//
//            user.setFirstName("HouseHoldApp");
//            user.setLastName("App");
//
//          /* user.setEmail("demo.app@smooch.io");*/
//        user.setSignedUpAt(new Date(1420070400000L));
//
//        // Add your own custom properties
//        customProperties.put("Last Seen", new Date());
//        customProperties.put("Awesome", true);
//        customProperties.put("Karma", 1337);
//        user.addProperties(customProperties);
//    }
//}
