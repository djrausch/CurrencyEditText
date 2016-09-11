# CurrencyEditText
[![](https://jitpack.io/v/djrausch/CurrencyEditText.svg)](https://jitpack.io/#djrausch/CurrencyEditText)

CurrencyEditText is a simple extension of EditText to provide support for currency input.

## Usage
In your root build.gradle, add the JitPack.io repo
```
    allprojects {
		repositories {
			...
			maven { url "https://jitpack.io" }
		}
	}
```

In your app build.gradle, add the dependency
```
    dependencies {
	        compile 'com.github.djrausch:CurrencyEditText:1.0'
	}
```

## Thanks
Thanks to [Val Okafor on Stack Overflow](http://stackoverflow.com/questions/27027070/android-edittext-addtextchangelistener-currency-format) for the initial TextWatcher algorithm.