package screens

object Onboarding {

    val selectRusButton = ScreenConstructor(
        androidXpath = "//android.view.View[@content-desc=\"Русский\"]",
        iosClassChain = "**/XCUIElementTypeStaticText[`label == \"Закуски\"`]",
        elementName = "Выбор русского языка на экране онбординга"
    )

    val nextButton = ScreenConstructor(
        androidAccessibilityId = "Далее",
        elementName = "Кнопка Далее на экране онбординга"
    )

}