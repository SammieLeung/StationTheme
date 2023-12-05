# Station OS 通用主题

![图片alt](./ScreenShoot/sample.png "sample")

### 主题
<文件：<b>theme.xml</b>>


**使用方法：**


**Manifest.xml->application使用主题StationTheme或继承StationTheme的主题**


```xml

<application
    ...
    android:theme="@style/Theme.PluginsCenter"
    ...
></application>

<style name="Theme.PluginsCenter" parent="StationTheme" />

```
**StationDialogFragment**

```java
            StationDialogFragment dialogFragment = new StationDialogFragment.Builder(getBaseContext())
                    .setTitle("标题和自定义View")
                    .setCustomView(R.layout.station_custom_view)
                    .setMessage("这是一个消息对话框")
                    .setNegativeButton("取消", (dialog, which) -> {
                        dialog.dismiss();
                    })
                    .setPositiveButton("确定", (dialog, which) -> {
                        dialog.dismiss();
                    })
                    .setNeutralButton("中立", (dialog, which) -> {
                        dialog.dismiss();
                    })
                    .build();
            dialogFragment.show(SampleActivity.this.getSupportFragmentManager(), "dialog");
```
![图片alt](./ScreenShoot/stationdialog.png "StationDialogFragment")

**字体**

字体替换为阿里巴巴普惠体，使用该字体可能会发生字体无法垂直居中的问题。目前正在定位问题

-------------

### 样式
<文件:  <b>style.xml</b>  >

控件样式列表

Station.Widget.3D.Button

Station.Widget.Button

Station.Widget.EditText

Station.Widget.Switch

Station.Widget.ImageButton

Station.Widget.Spinner

Station.Widget.SpinnerItem

Station.Widget.DropDownItem

Station.Widget.ProgressBar


