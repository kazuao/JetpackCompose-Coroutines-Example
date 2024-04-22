https://at-sushi.work/blog/48/
composableでflowの変数を`callAsState()`で読み込むとStateとして使える


# 
https://www.youtube.com/watch?v=LFlobqW8Sy8&ab_channel=NativeMobileBits

## 手順
compileSdk, targetSdkを34
compileOptionsのJavaVersion.VERSION_17
jvmTargetも17

app -> project
new > directry > buildSrc > build.gradle.kts
いろいろ

new buildSrc/src/main/java/
→create Dependencies, Versions

new Project > module > Android Library > utilityies

Dependencies > object Modules
build.gradle.kts(:app) implementation(project(Modules.utilities))

Applicationを継承したclassの作成
MainActivityに@AndroidEntryPointの付与