package com.example.ac_2_view_binding;
//https://docs.google.com/document/d/1gqk3uqwQJSxBYNAwg4zrN8qQxNuVn0_zll2kgjT3fe8/edit#heading=h.woccthcumzt4
//網址:https://blog.csdn.net/u012124438/article/details/85765566
//文件:https://developer.android.com/topic/libraries/data-binding
//影片:https://www.youtube.com/watch?v=Mp8hy2KBjHw



//1.API加入
/*dataBinding {
        enabled = true
    }
 */

//2.創建要綁定的類別這邊
/* ex. Studend class類別
 * */

//3.xml => layout data 綁定data類別
/*
A.<layout>包覆整個xml</layout>,並且當最外層所以設定在此
        xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        xmlns:tools="http://schemas.android.com/tools">

B.data綁定Student類別方式
<data>  //data設定
<variable //變量
            name="student" //要綁定的類別名稱
            type="com.example.ac_2_view_binding.Student" /> //要綁定的類別
</data>

C.使用@{}語法:直接將這邊的text => 設定為寫好的類別的屬性
        android:text="@{student.firstName}" //將textView設定為student類別的屬性firstName值
        android:text="@{student.lasttName}" //將textView設定為student類別的屬性lastName值
*/

/*
* 4.設定DataBinding方式的ContentView
* //設定畫面兩個相等:setContentView(R.layout.activity_main) == activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
* setContentView(@NonNull Activity activity,int layoutId):(回傳<T extends ViewDataBinding> T)
* activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);//設定ContentView(1.要綁定的Activity,2.要綁定的Activity.xnl)
*
* //5.在建構時將屬性給值
*Student student = new Student("Jason","Kidd");
*
* //6.直接用ActivityMainBinding.設定Student的值
*activityMainBinding.setStudent(student);
* */
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.ac_2_view_binding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding  activityMainBinding ; //我用dataBinding綁定的MainActivity的xml物件
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //設定畫面兩個相等:setContentView(R.layout.activity_main) == activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        //4.設定DataBinding方式的ContentView
        //setContentView(@NonNull Activity activity,int layoutId):(回傳<T extends ViewDataBinding> T)
        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);//設定ContentView(1.要綁定的Activity,2.要綁定的Activity.xnl)

        //5.在建構時將屬性給值
        Student student = new Student("Jason","Kidd");

        //6.直接用ActivityMainBinding.設定Student的值
        activityMainBinding.setStudent(student);
    }
}
