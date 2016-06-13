package com.daxia.espressosample;

import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.test.suitebuilder.annotation.SmallTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.BundleMatchers.hasEntry;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasExtras;
import static android.support.test.espresso.intent.matcher.IntentMatchers.toPackage;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by daxia on 2016/6/8.
 */

@RunWith(JUnit4.class)
@SmallTest
public class SecondActivityTest {

    @Rule
    public IntentsTestRule<MainActivity> mMainActivityRule = new IntentsTestRule(MainActivity.class);

    @Test
    public void openSecondActivity() {
        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());
        onView(withText(mMainActivityRule.getActivity().getResources().getString(R.string.action_goto_secondactivity)))
                .perform(click());

        intended(allOf(toPackage("com.daxia.espressosample"),
                hasExtras(
                        //Key, value
                        hasEntry(equalTo("Str"), equalTo("From First Activity!")))));
    }


}
