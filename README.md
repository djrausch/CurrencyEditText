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

To use the view, include it in your XML the same way you would an EditText:
```
<com.djrausch.currencyedittext.CurrencyEditText
        android:id="@+id/currency"
        android:hint="Amount"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"/>
```

To get the value in double format, use:
```
mCurrencyEditText.getValue();
```

To get the value as a String, including the currency symbol, use the usual getText():
```
mCurrencyEditText.getText().toString();
```

## Thanks
Thanks to [Val Okafor on Stack Overflow](http://stackoverflow.com/questions/27027070/android-edittext-addtextchangelistener-currency-format) for the initial TextWatcher algorithm.