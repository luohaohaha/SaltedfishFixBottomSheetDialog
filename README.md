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
## License
    Copyright 2014 LuoHao

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

## Thanks
[ViewPagerBottomSheet][1]

[1]: https://github.com/laenger/ViewPagerBottomSheet
