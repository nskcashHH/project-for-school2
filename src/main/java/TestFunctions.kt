import GlobalVariables.androidDriver
import GlobalVariables.iosDriver
import GlobalVariables.platformType
import io.appium.java_client.AppiumBy
import io.qameta.allure.Attachment
import io.qameta.allure.Step
import org.openqa.selenium.OutputType
import org.openqa.selenium.TakesScreenshot
import org.openqa.selenium.WebElement
import org.testng.Assert

import java.util.*

object TestFunctions {

    @Step("Нажатие на {elementName}")
    fun clickToElement(
        locatorAndroid: String,
        locatorTypeAndroid: LocatorType,
        locatorIOS: String,
        locatorTypeIOS: LocatorType,
        elementName: String,
        findElementWithoutCatching: Boolean = false
    ) {
        val finalLocator: String
        val finalLocatorType: LocatorType
        if (platformType == TypeOS.ANDROID) {
            finalLocator = locatorAndroid
            finalLocatorType = locatorTypeAndroid
        } else {
            finalLocator = locatorIOS
            finalLocatorType = locatorTypeIOS
        }

        val element = findElement(finalLocator, finalLocatorType, findElementWithoutCatching)

        element.click()
    }

    @Step("Ввод текста {text} в поле {elementName}")
    fun sendText(locator: String, locatorType: LocatorType, text: String) {
        val element = findElement(locator, locatorType)
        element.sendKeys(text)
    }

    @Step
    fun clearField(locator: String, locatorType: LocatorType) {
        val element = findElement(locator, locatorType)
        element.clear()
    }

    @Step()
    fun checkAvailableElement(locator: String, locatorType: LocatorType): Boolean {
        val element = findElement(locator, locatorType)
        return element.isEnabled
    }


    private fun findElement(
        locator: String,
        locatorType: LocatorType,
        findElementWithoutCatching: Boolean = false
    ): WebElement {
        lateinit var element: WebElement

        if (findElementWithoutCatching) {
            when (locatorType) {
                LocatorType.ID -> {
                    element = if (platformType == TypeOS.ANDROID) {
                        androidDriver.findElement(AppiumBy.id(locator))
                    } else iosDriver.findElement(AppiumBy.id(locator))
                }

                LocatorType.XPATH -> {
                    element = if (platformType == TypeOS.ANDROID) {
                        androidDriver.findElement(AppiumBy.xpath(locator))
                    } else iosDriver.findElement(AppiumBy.xpath(locator))
                }

                LocatorType.ACCESSIBILITY_ID -> {
                    element = if (platformType == TypeOS.ANDROID) {
                        androidDriver.findElement(AppiumBy.accessibilityId(locator))
                    } else iosDriver.findElement(AppiumBy.accessibilityId(locator))
                }

                LocatorType.IOS_CLASS_CHAIN -> element = iosDriver.findElement(AppiumBy.iOSClassChain(locator))
                LocatorType.IOS_PREDICATE_STRING -> element =
                    iosDriver.findElement(AppiumBy.iOSNsPredicateString(locator))

                else -> {}
            }
        } else {
            runCatching {
                when (locatorType) {
                    LocatorType.ID -> {
                        element = if (platformType == TypeOS.ANDROID) {
                            androidDriver.findElement(AppiumBy.id(locator))
                        } else iosDriver.findElement(AppiumBy.id(locator))
                    }

                    LocatorType.XPATH -> {
                        element = if (platformType == TypeOS.ANDROID) {
                            androidDriver.findElement(AppiumBy.xpath(locator))
                        } else iosDriver.findElement(AppiumBy.xpath(locator))
                    }

                    LocatorType.ACCESSIBILITY_ID -> {
                        element = if (platformType == TypeOS.ANDROID) {
                            androidDriver.findElement(AppiumBy.accessibilityId(locator))
                        } else iosDriver.findElement(AppiumBy.accessibilityId(locator))
                    }

                    LocatorType.IOS_CLASS_CHAIN -> element = iosDriver.findElement(AppiumBy.iOSClassChain(locator))
                    LocatorType.IOS_PREDICATE_STRING -> element =
                        iosDriver.findElement(AppiumBy.iOSNsPredicateString(locator))

                    else -> {}
                }
            }.onSuccess {

            }.onFailure {
                makeScreenshotOfScreen(Date().toString())
                Assert.fail("Элемент не был найден по локатору - $locator")
            }
        }

        return element
    }

    @Attachment(value = "Screenshot - {dateOnSystem}", type = "image/png")
    fun makeScreenshotOfScreen(dateOnSystem: String?): ByteArray {
        return if (platformType == TypeOS.IOS) {
            (iosDriver as TakesScreenshot?)!!.getScreenshotAs(OutputType.BYTES)
        } else (androidDriver as TakesScreenshot?)!!.getScreenshotAs(OutputType.BYTES)

        // использование - makeScreenshotOfScreen(Date().toString())
    }


}

