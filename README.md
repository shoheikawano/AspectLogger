## AspectLogger

Simple aspect oriented annotation debugging library for Android development. Development started for the purpose of 'revealing' the causes of bugs and erorrs just by simple one annotation. Ironically, `@Reveal` to your methods only does measure their execution time for now.. 

(More functionality and usable annotations will be available in the future release.)

MainActivity
```java
    @Reveal
    private static void toJson() {
        String json = "";
        for (int i = 0; i < 1000; i++) {
            json = GSON.toJson(newObject());
        }
    }
```
logcat

```java
	V/AspectRevealer﹕ MainActivity#toJson :: [62 ms]
```

Hugely inspired by and finely minified version of [JakeWharton/hugo](https://github.com/JakeWharton/hugo).

## Todo

- [ ] Sync to mavenCentral
- [ ] Separate jars for annotation and library module
- [ ] Method parameter support to extend its `toString()`

## Download

As noted in Todo, AspectLogger has not been synced to mavenCentral yet; **only supports jcenter for now**. Also, AspectJ is required to actually use it. I thought just adding [gradle-android-aspectj-plugin library](https://github.com/uPhyca/gradle-android-aspectj-plugin) to your project would be the easiest way for set up. (I know all of these setup process sucks and will improve it in the future release).

```groovy
buildscript {
  repositories {
    jcenter()
  }
  dependencies {
    classpath 'com.uphyca.gradle:gradle-android-aspectj-plugin:0.9.12'
  }
}

apply plugin: 'com.android.application'
apply plugin: 'android-aspectj'

dependencies {
    compile('com.s_hei.aspectlogger:reveal:0.1.0@aar')
}
```

## License

```
Copyright 2015 Shohei Shaun Kawano

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
