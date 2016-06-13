package com.daxia.espressosample.listview;

import android.support.test.espresso.contrib.DrawerActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.SmallTest;
import android.view.View;
import android.widget.ListView;

import com.daxia.espressosample.MainActivity;
import com.daxia.espressosample.R;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.anything;
import static org.hamcrest.core.AllOf.allOf;

/**
 * Created by daxia on 2016/6/1.
 */
@RunWith(AndroidJUnit4.class)
@SmallTest
public class SuperheroListFragmentTest {

    @Rule
    public ActivityTestRule<MainActivity> mMainActivityRule = new ActivityTestRule(MainActivity.class);

    @Before
    public void gotoGallery() {
        //get DrawerList name
        //String[] teacherDrawerList = mMainActivityRule.getActivity().getResources().getStringArray(R.array.planets_teacher_login_array);
        //open drawer
        onView(withId(R.id.drawer_layout)).perform(DrawerActions.open());
        //go to Gallery page
        onView(withText("SuperHeroList")).perform(click());
    }


    /**
     * Test deleteItem
     */
    @Test
    public void deleteItem() {
        //get listview count
        final int[] oldListviewCount = new int[1];
        onView(allOf(withId(R.id.Listview_Gallery), isDisplayed()))
                .check(matches(new TypeSafeMatcher<View>() {
                    @Override
                    public boolean matchesSafely(View view) {
                        ListView listView = (ListView) view;
                        oldListviewCount[0] = listView.getCount();
                        return true;
                    }

                    @Override
                    public void describeTo(Description description) {

                    }
                }));

        //delete
        onData(anything()).inAdapterView(allOf(withId(R.id.Listview_Gallery), isDisplayed()))
                .atPosition(0)
                .onChildView(withId(R.id.But_gallery_delete))
                .perform(click());


        //Check Listview count is right
        onView(allOf(withId(R.id.Listview_Gallery), isDisplayed())).check(matches(new TypeSafeMatcher<View>() {
            @Override
            public boolean matchesSafely(View view) {
                ListView listView = (ListView) view;
                if (listView.getCount() == (oldListviewCount[0] - 1)) {
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


    /**
     * Test CountItem
     */
    @Test
    public void CountItem() {
        final int mustCount = 3;
        onView(allOf(withId(R.id.Listview_Gallery), isDisplayed()))
                .check(matches(new TypeSafeMatcher<View>() {
                    @Override
                    public boolean matchesSafely(View view) {
                        ListView listView = (ListView) view;
                        if (listView.getCount() == mustCount) {
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
