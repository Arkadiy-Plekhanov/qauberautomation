#importing WebDriver
require "selenium-webdriver";

#Specifying Browser for Webdriver
driver = Selenium::WebDriver.for :chrome;

#TC: Verify "Config icons" in Users are functional  https://bidqa.testrail.net/index.php?/tests/view/76685

#navigate to login page
driver.get("http://testwave.qabidder.net/#/page/login");
sleep(3)

#login
driver.find_element(:xpath, "//input[@id='exampleInputEmail1']").send_keys("arkadiy.plekhanov@yahoo.com");
driver.find_element(:xpath, "//input[@id='exampleInputPassword1']").send_keys("qwerty123");
driver.find_element(:xpath, "//button[@type='submit']").click;
sleep(3)

#Navigating to "Users" page
driver.find_element(:xpath, "//span[contains(.,'Users')]").click;
sleep(3)

#Checking if the configuration button is functional
driver.find_element(:xpath, "//em[@class='icon-settings ng-scope']").click;
sleep(2)

#Verifying if "Assign User Permissions" pop-up appears.
if (driver.find_element(:xpath, "//p[contains(.,'Assign User Permissions')]")).displayed?
  puts "Passed"
else
  puts "Failed"
end;

#clearing cache
driver.manage.delete_all_cookies;

#closing Browser
driver.quit;
