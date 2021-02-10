$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/EditBooks.feature");
formatter.feature({
  "name": "Edit Books",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@wip"
    }
  ]
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "the user is on the login page",
  "keyword": "Given "
});
formatter.match({
  "location": "com.SysLibrary.step_definitions.loginDefs.the_user_is_on_the_login_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user enters the librarian information",
  "keyword": "When "
});
formatter.match({
  "location": "com.SysLibrary.step_definitions.loginDefs.the_user_enters_the_librarian_information()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user should be able to login",
  "keyword": "Then "
});
formatter.match({
  "location": "com.SysLibrary.step_definitions.loginDefs.the_user_should_be_able_to_login()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Verify that librarian can edit books",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@wip"
    }
  ]
});
formatter.step({
  "name": "the user should be able to click Books button",
  "keyword": "When "
});
formatter.match({
  "location": "com.SysLibrary.step_definitions.EditBookDefs.the_user_should_be_able_to_click_Books_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user should be able click Edit Book button",
  "keyword": "Then "
});
formatter.match({
  "location": "com.SysLibrary.step_definitions.EditBookDefs.the_user_should_be_able_click_Edit_Book_button()"
});
formatter.result({
  "error_message": "org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {\"method\":\"css selector\",\"selector\":\".portlet-title\u003espan\u003ea\"}\n  (Session info: chrome\u003d88.0.4324.146)\nFor documentation on this error, please visit: https://www.seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027DESKTOP-CEHUVP3\u0027, ip: \u0027192.168.1.46\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u002714.0.2\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 88.0.4324.146, chrome: {chromedriverVersion: 88.0.4324.96 (68dba2d8a0b14..., userDataDir: C:\\Users\\me\\AppData\\Local\\T...}, goog:chromeOptions: {debuggerAddress: localhost:57811}, javascriptEnabled: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: WINDOWS, platformName: WINDOWS, proxy: Proxy(), setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify, webauthn:extension:largeBlob: true, webauthn:virtualAuthenticators: true}\nSession ID: f3305ceb78366a1accf4a8296e14dfb2\n*** Element info: {Using\u003dcss selector, value\u003d.portlet-title\u003espan\u003ea}\r\n\tat java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\r\n\tat java.base/jdk.internal.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.base/java.lang.reflect.Constructor.newInstanceWithCaller(Constructor.java:500)\r\n\tat java.base/java.lang.reflect.Constructor.newInstance(Constructor.java:481)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:187)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:122)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:49)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:323)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByCssSelector(RemoteWebDriver.java:420)\r\n\tat org.openqa.selenium.By$ByCssSelector.findElement(By.java:431)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:315)\r\n\tat org.openqa.selenium.support.pagefactory.DefaultElementLocator.findElement(DefaultElementLocator.java:69)\r\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:38)\r\n\tat com.sun.proxy.$Proxy19.click(Unknown Source)\r\n\tat com.SysLibrary.step_definitions.EditBookDefs.the_user_should_be_able_click_Edit_Book_button(EditBookDefs.java:23)\r\n\tat ✽.the user should be able click Edit Book button(file:///C:/Users/me/IdeaProjects/SysLibrary-Automation/src/test/resources/features/EditBooks.feature:12)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "the user enters valid book information and click save button",
  "keyword": "And "
});
formatter.match({
  "location": "com.SysLibrary.step_definitions.EditBookDefs.the_user_enters_valid_book_information_and_click_save_button()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "the user should see the book has been created message",
  "keyword": "Then "
});
formatter.match({
  "location": "com.SysLibrary.step_definitions.EditBookDefs.the_user_should_see_the_book_has_been_created_message()"
});
formatter.result({
  "status": "skipped"
});
formatter.embedding("image/png", "embedded0.png", "screenshot");
formatter.after({
  "status": "passed"
});
});