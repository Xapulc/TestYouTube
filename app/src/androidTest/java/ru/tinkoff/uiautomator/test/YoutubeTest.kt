package ru.tinkoff.uiautomator.test

import android.support.test.runner.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith
import ru.tinkoff.uiautomator.application.YouTube
import ru.tinkoff.uiautomator.util.getDevice

@RunWith(AndroidJUnit4::class)
class YoutubeTest : AbstractApplicationTest<YouTube>(YouTube()) {

    @Test
    fun stopVideoOn10Second() {
        app.open()
        app.clickSearch()
        app.typeToSearch("Шапоников Станислав Валерьевич лекции")
        getDevice().pressEnter()
        app.clickRandomVideo()
        app.waitAd()
        app.stop10Second()
    }

}