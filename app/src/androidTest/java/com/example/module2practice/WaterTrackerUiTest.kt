package com.example.module2practice

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import org.junit.Rule
import org.junit.Test

class WaterTrackerUiTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun testWaterTrackerFlow() {
        composeTestRule.setContent {
            WaterTracker()
        }

        composeTestRule.onNodeWithText("Трекер воды").assertIsDisplayed()
        composeTestRule.onNodeWithText("0 мл").assertIsDisplayed()
        composeTestRule.onNodeWithText("Дней подряд (1500 мл и более): 0").assertIsDisplayed()
        composeTestRule.onNodeWithText("+250 мл").assertIsDisplayed().assertHasClickAction()
        composeTestRule.onNodeWithText("Завершить день").assertIsDisplayed().assertHasClickAction()
    }
}
