package tests

import MainActivity
import org.testng.annotations.Test
import screens.Onboarding
import java.util.concurrent.TimeUnit

// запускать тесты именно через класс если все, или каждый тест по 1
class TestClassOne : MainActivity(){

    // пока что все тесты, которые у вас есть, реализуем именно в этом классе, пока что вы
    // не сможете запустить тесты сразу с нескольких классов
    @Test
    fun testOne(){

        val onboarding = Onboarding() // объявляем экземпляр класса 1
        val onboarding1 = Onboarding() // объявляем экземпляр класса 2


        onboarding.clickSelectRusButton() // делаем клик 1
        onboarding.clickNextButton() // делаем клик 2
        onboarding.clickNextButton()
        onboarding

    }

}