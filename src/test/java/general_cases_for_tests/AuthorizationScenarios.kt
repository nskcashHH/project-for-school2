package general_cases_for_tests

import LocatorType
import TestFunctions.checkAvailableElement

object AuthorizationScenarios {

    fun checkAuthorizationUser(needAuthorizationUser: Boolean) {
        /* тут должна быть логика проверки авторизации пользователя
        на входе одна и нужных булевых переменных, вторую нужно получить путем
        проверки доступности элемента

         */

        // нужно описать 4 ветки
        var userIsAuthorization: Boolean
        try {
            // нам нужно получить true, что это сделать, нужно найти элемент, если он не будет
            // найден, то должна обработаться ошибка и установить значение false
            userIsAuthorization = checkAvailableElement("locator", LocatorType.XPATH)
        } catch (e: org.openqa.selenium.NoSuchElementException) {
            userIsAuthorization = false
        }
        when {
            needAuthorizationUser && userIsAuthorization -> {}
            needAuthorizationUser && !userIsAuthorization -> {}
            !needAuthorizationUser && userIsAuthorization -> {}
            !needAuthorizationUser && !userIsAuthorization -> {}
        }

    }
}