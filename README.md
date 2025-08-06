# CaseAPI

![Version](https://img.shields.io/badge/version-1.0.0-blue)

CaseAPI is a lightweight API designed to integrate seamlessly with the CaseOpening plugin. It allows other plugins to interact with cases, track statistics, and extend functionality.

**Note**: This API requires the CaseOpening plugin to be installed and running.

## 🔧 Installation

### **Maven**
```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>

<dependency>
    <groupId>com.github.cubexa-studio</groupId>
    <artifactId>CaseAPI</artifactId>
    <version>1.0.0</version>
    <scope>provided</scope>
</dependency>
```

### **Gradle (Kotlin DSL)**
```kotlin
repositories {
    maven("https://jitpack.io")
}

dependencies {
    compileOnly("com.github.cubexa-studio:CaseAPI:1.0.0")
}
```

## 🚀 Getting Started

### **1. Hook into CaseAPI**
Before using the API, you need to obtain an instance of `CaseAPI`. This can be done using the Bukkit Services Manager:

```java
private CaseAPI caseAPI;

@Override
public void onEnable() {
    RegisteredServiceProvider<CaseAPI> provider = Bukkit.getServicesManager().getRegistration(CaseAPI.class);
    if (provider != null) {
        caseAPI = provider.getProvider();
    }
}
```

### **2. Add the Plugin as a Dependency**
To ensure your plugin loads after CaseOpening, you need to declare it as a (soft-)dependency in your plugin.yml:

```yaml
depend: [CaseOpening]
```

This ensures that the CaseAPI is available during your plugin’s `onEnable()` phase.

### **3. Listening to Case Events**
You can listen to CaseOpening events to trigger custom actions. To do this, you first need to create a `CaseOpeningEventListener`:

```java
public class MyListener implements CaseOpeningEventListener {
    
    @Override
    public void onCaseOpen(CaseOpenEvent event) { }
    
    @Override
    public void onCaseOpenComplete(CaseOpenCompleteEvent event) { }
    
    @Override
    public void onFailedCaseOpen(FailedCaseOpenEvent event) { }
    
    @Override
    public void onCaseRewardAnnounce(CaseRewardAnnounceEvent event) { }
}
```

If you don't want to listen for certain events, simply leave the method empty.

Now you just need to register the `CaseOpeningEventListener`. This can be done via the `CaseAPI`:

```java
caseAPI.registerListener(new MyListener());
```

## ❓ Need Help?
If you need assistance, feel free to open an issue on this repository or join our community [Discord](https://discord.com/invite/BKsZxh4D6W)!

## 📝 License

This project is licensed under the **Cubexa Custom License** (based on the MIT License, with additional restrictions).

You are allowed to use and modify the software for private purposes, but you may not distribute modified versions or claim the software as your own.  
Please refer to the [LICENSE](./LICENSE) file for the full terms.