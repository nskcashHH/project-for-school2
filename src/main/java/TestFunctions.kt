import GlobalVariables.androidDriver
import GlobalVariables.iosDriver
import GlobalVariables.platformType
import io.appium.java_client.AppiumBy
import org.openqa.selenium.WebElement

object TestFunctions {

    fun clickToElement(
        locatorAndroid: String,
        locatorTypeAndroid: LocatorType,
        locatorIOS: String,
        locatorTypeIOS: LocatorType
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
        val element = findElement(finalLocator, finalLocatorType)
        element.click()
    }

    fun sendText(locator: String, locatorType: LocatorType, text: String) {
        val element = findElement(locator, locatorType)
        element.sendKeys(text)
    }

    fun clearField(locator: String, locatorType: LocatorType) {
        val element = findElement(locator, locatorType)
        element.clear()
    }

    fun checkAvailableElement(locator: String, locatorType: LocatorType): Boolean {
        val element = findElement(locator, locatorType)
        return element.isEnabled
    }


    private fun findElement(locator: String, locatorType: LocatorType): WebElement {
        lateinit var element: WebElement
        when (locatorType) {
            LocatorType.ID -> {
                if (platformType == TypeOS.ANDROID) {
                    element = androidDriver.findElement(AppiumBy.id(locator))
                } else element = iosDriver.findElement(AppiumBy.id(locator))
            }

            LocatorType.XPATH -> {
                if (platformType == TypeOS.ANDROID) {
                    element = androidDriver.findElement(AppiumBy.xpath(locator))
                } else element = iosDriver.findElement(AppiumBy.xpath(locator))
            }

            LocatorType.ACCESSIBILITY_ID -> {
                if (platformType == TypeOS.ANDROID) {
                    element = androidDriver.findElement(AppiumBy.accessibilityId(locator))
                } else element = iosDriver.findElement(AppiumBy.accessibilityId(locator))
            }

            LocatorType.IOS_CLASS_CHAIN -> element = iosDriver.findElement(AppiumBy.iOSClassChain(locator))
            LocatorType.IOS_PREDICATE_STRING -> element = iosDriver.findElement(AppiumBy.iOSNsPredicateString(locator))
            else -> {}
        }

        return element
    }


}

