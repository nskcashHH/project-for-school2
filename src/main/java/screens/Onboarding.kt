package screens

import LocatorType
import TestFunctions.clickToElement


class Onboarding {

    fun clickSelectRusButton(findElementWithoutCatching: Boolean = false) {
        clickToElement(
            locatorTypeAndroid = LocatorType.XPATH,
            locatorAndroid = locatorMap[OnboardingElements.SELECT_RUS_BUTTON_ANDROID].toString(),
            locatorTypeIOS = LocatorType.IOS_CLASS_CHAIN,
            locatorIOS = locatorMap[OnboardingElements.SELECT_RUS_BUTTON_IOS].toString(),
            elementName =  locatorMap[OnboardingElements.SELECT_RUS_BUTTON_ELEMENT_NAME].toString(),
            findElementWithoutCatching = findElementWithoutCatching
        )
    }

    fun clickNextButton() {
        clickToElement(
            locatorTypeAndroid = LocatorType.ACCESSIBILITY_ID,
            locatorAndroid = "Далее",
            locatorTypeIOS = LocatorType.IOS_CLASS_CHAIN,
            locatorIOS = "**/XCUIElementTypeStaticText[`label == \"Далее\"`]",
            elementName = "Кнопка Далее на экране онбординга"
        )
    }

    private val selectRusButton = ScreenConstructor(
        androidXpath = "//android.view.View[@content-desc=\"Русский\"]",
        iosClassChain = "**/XCUIElementTypeStaticText[`label == \"Закуски\"`]",
        elementName = "Выбор русского языка на экране онбординга"
    )

    private val nextButton = ScreenConstructor(
        androidAccessibilityId = "Далее",
        elementName = "Кнопка Далее на экране онбординга"
    )

    private enum class OnboardingElements {
        SELECT_RUS_BUTTON_ANDROID,
        SELECT_RUS_BUTTON_IOS,
        SELECT_RUS_BUTTON_ELEMENT_NAME,

        NEXT_BUTTON_ANDROID,
        NEXT_BUTTON_IOS,
        NEXT_BUTTON_ELEMENT_NAME,
    }

    private val locatorMap: LinkedHashMap<OnboardingElements, String> = linkedMapOf(
        OnboardingElements.SELECT_RUS_BUTTON_ANDROID to "//android.view.View[@content-desc=\"Русский\"]",
        OnboardingElements.SELECT_RUS_BUTTON_IOS to "**/XCUIElementTypeStaticText[`label == \"Закуски\"`]",
        OnboardingElements.SELECT_RUS_BUTTON_ELEMENT_NAME to "Выбор русского языка на экране онбординга",

        OnboardingElements.NEXT_BUTTON_ANDROID to "Далее",
        OnboardingElements.NEXT_BUTTON_IOS to "тоже далее",
        OnboardingElements.NEXT_BUTTON_ELEMENT_NAME to "Кнопка Далее на экране онбординга"




    )

}