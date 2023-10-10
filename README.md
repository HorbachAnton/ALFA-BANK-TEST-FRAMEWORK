# ALFA-BANK-TEST-FRAMEWORK
## How to run?
### 1. Start your appium server. For example, use the following config. The command to start you server by the specified config is 'appium server --config path/to/you/config.json'.

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
### 2. Open the serenity.properties file and change settings according to your Android simulator.

### 3. Use the following command: mvn clean verify.

### 4. Open the following folders: target -> site -> serenity. Open the index.html file. You will be able to investigate a generated report.