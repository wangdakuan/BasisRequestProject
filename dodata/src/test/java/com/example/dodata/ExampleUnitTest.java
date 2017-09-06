package com.example.dodata;


import com.dodata.appnet.model.UserInfoModel;
import com.dodata.appnet.user.UserPresenterImpl;
import com.dodata.net.presenter.SucceedCallback;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(RobolectricTestRunner.class)
@Config(manifest = Config.NONE)
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
        GAppTest gAppTest = new GAppTest();
        gAppTest.initOkGo(RuntimeEnvironment.application);
        UserPresenterImpl presenter = new UserPresenterImpl(null);
        presenter.checkSignIn("", new SucceedCallback<UserInfoModel>() {
            @Override
            public void onData(UserInfoModel infoModel) {

            }
        });
    }
}