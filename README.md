# ALFA-BANK-TEST-FRAMEWORK
## How to run?
### 1. Build the test app from here:https://github.com/lunin-vadim/qa-mobile. Install it on your Android emulator.

### 2. Start your appium server. For example, use the following config. The command to start you server by the specified config is 'appium server --config path/to/you/config.json'.

```
{
    "server": {
        "address": "127.0.0.1",
        "port": 4723,
        "relaxed-security": true,
        "use-plugins": ["images"],
        "driver": {
            "xcuitest": {
                "webdriveragent-port": 8100
            },
            "uiautomator2": {
                "webdriveragent-port": 8100
            }
        }
    }
}
```
### 3. Open the serenity.properties file and change settings according to your Android simulator.

### 4. Use the following command: mvn clean verify.

### 5. Open the following folders: target -> site -> serenity. Open the index.html file. You will be able to investigate a generated report.
