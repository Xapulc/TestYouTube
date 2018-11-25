package ru.tinkoff.uiautomator.application

import ru.tinkoff.uiautomator.util.*

class YouTube : AbstractApplication("com.google.android.youtube") {

    fun clickSearch() {
        byContentDesc("Введите запрос").waitFindObject().click()
    }

    fun typeToSearch(text: String) {
        byStringRes("com.google.android.youtube:id/search_edit_text").waitFindObject().text = text
    }

    fun clickRandomVideo() {
        byStringRes("com.google.android.youtube:id/thumbnail").waitFindObject().click()
    }

    fun waitAd() {
        while (byStringText("На сайт рекламодателя").waitHasObject()) {
            println("I skip ad")
        }
    }

    fun stop10Second() {
        Thread.sleep(1500)
        clickOnVideo()
        val timeLeft = 10 - (getCurTime() + 1) // waiting is so long
        Thread.sleep(timeLeft * 1000)
        clickOnVideo()
        pause()
    }

    private fun clickOnVideo() {
        byStringRes("com.google.android.youtube:id/player_view").waitFindObject().click()
    }

    private fun getCurTime() : Long {
        val textTime = byStringRes("com.google.android.youtube:id/time_bar_current_time")
            .waitFindObject().text.toString()
        return textTime.substringAfter(':').toLong()
    }

    private fun pause() {
        byStringRes("com.google.android.youtube:id/player_control_play_pause_replay_button")
            .waitFindObject().click()
    }
}