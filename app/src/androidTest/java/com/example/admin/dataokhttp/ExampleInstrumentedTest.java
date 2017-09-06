package com.example.admin.dataokhttp;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.app.view.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Test
    public void useAppContext() throws Exception {
//        GAppTest appTest = new GAppTest();
//        appTest.initOkGo(mActivityRule.getActivity().getApplicationContext());
//
//        // Context of the app under test.
//        Context appContext = InstrumentationRegistry.getTargetContext();
//
//        assertEquals("com.example.admin.dataokhttp", appContext.getPackageName());
//        UserPresenterImpl presenter = new UserPresenterImpl(null);
//        presenter.checkSignIn("", new SucceedCallback<UserInfoModel>() {
//            @Override
//            public void onData(UserInfoModel infoModel) {
//
//            }
//        });
    }
}
