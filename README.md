# SaltedfishFixBottomSheetDialog
 Fixed a problem that ViewPager can not scroll in BottomSheetDialog
## How to use

### 1. Add a dependency

Add the following dependency to your build.gradle:
```gradle
dependencies {
    implementation 'com.saltedfish:library:1.0'
    //or
    //compile 'com.saltedfish:library:1.0'
}
```

You can also do it manually, by downloading the source code, importing the `library` folder as an Android Library Module, and adding a dependency on your project to that module.

### 2. Use like BottomSheetDialog

too simple
```java
     SaltedFishBottomSheetDialog dialog = new SaltedFishBottomSheetDialog(this);
        View rootView = ...;
        TabLayout tab = ...;
        ViewPager pager = ...;
        for (int i = 0,count = ...; i <count ; i++) {
            String title = ...;
            tab.addTab(tab.newTab().setText(title));//add tab
        }

        PagerAdapter pagerAdapter = new PagerAdapter(this,data);
        pager.setAdapter(pagerAdapter);
        tab.setupWithViewPager(pager);
        dialog.setupWithViewPager(pager);
        dialog.setContentView(rootView);
        dialog.show();
```
## Thanks
[ViewPagerBottomSheet][1]

[1]: https://github.com/laenger/ViewPagerBottomSheet
