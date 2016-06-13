package com.daxia.espressosample.textview;

import android.support.test.espresso.contrib.DrawerActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.SmallTest;
import android.view.View;
import android.widget.TextView;

import com.daxia.espressosample.MainActivity;
import com.daxia.espressosample.R;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by daxia on 2016/6/8.
 */
@RunWith(AndroidJUnit4.class)
@SmallTest
public class TextchangeFragmentTest {


    @Rule
    public ActivityTestRule<MainActivity> mMainActivityRule = new ActivityTestRule(MainActivity.class);

    @Before
    public void gotoImport() {
        //open drawer
        onView(ViewMatchers.withId(R.id.drawer_layout)).perform(DrawerActions.open());
        //go to Gallery page
        onView(withText("TextChange")).perform(click());
    }

    @Test
    public void ButtonTest1() {
        onView(withId(R.id.But_change)).perform(click());
        onView(withId(R.id.TV_import_str))
                .check(matches(new TypeSafeMatcher<View>() {
                    @Override
                    public boolean matchesSafely(View view) {
                        TextView textView = (TextView) view;
                        if ("HelloWorld".equals(textView.getText())) {
                            return true;
                        } else {
                            return false;
                        }
                    }

                    @Override
                    public void describeTo(Description description) {

                    }
                }));
    }

    @Test
    public void ButtonTest2() {
        onView(withId(R.id.But_change)).perform(click());
        onView(withId(R.id.TV_import_str))
                .check(matches(new TypeSafeMatcher<View>() {
                    @Override
                    public boolean matchesSafely(View view) {
                        TextView textView = (TextView) view;
                        if ("HelloKitty".equals(textView.getText())) {
                            return true;
                        } else {
                            return false;
                        }
                    }

                    @Override
                    public void describeTo(Description description) {

                    }
                }));
    }
}
