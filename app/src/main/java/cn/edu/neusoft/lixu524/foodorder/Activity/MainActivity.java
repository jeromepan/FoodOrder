package cn.edu.neusoft.lixu524.foodorder.Activity;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import cn.edu.neusoft.lixu524.foodorder.Fragment.CollectFragment;
import cn.edu.neusoft.lixu524.foodorder.Fragment.SearchFragment;
import cn.edu.neusoft.lixu524.foodorder.Fragment.SettingFragment;
import cn.edu.neusoft.lixu524.foodorder.Fragment.ShopFragment;
import cn.edu.neusoft.lixu524.foodorder.R;

public class MainActivity extends BaseActivity implements
    ShopFragment.OnFragmentInteractionListener,
    CollectFragment.OnFragmentInteractionListener,
    SearchFragment.OnFragmentInteractionListener,
    SettingFragment.OnFragmentInteractionListener{

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    LinearLayout tab_favor,tab_shouye,tab_shequ,tab_setting;
    ImageButton btn_favor,btn_shouye,btn_shequ,btn_setting;
    Fragment fragment_favor;
    Fragment fragment_shouye;
    Fragment fragment_shequ;
    Fragment fragment_setting;
//    View.OnClickListener onClickListener;

    @Override
    void initView() {
        setLayout_file(R.layout.activity_main);
        btn_favor = (ImageButton)findViewById(R.id.imageButton_like);
        btn_shouye = (ImageButton)findViewById(R.id.imageButton_home);
        btn_shequ = (ImageButton)findViewById(R.id.imageButton_community);
        btn_setting = (ImageButton)findViewById(R.id.imageButton_setting);

        tab_favor = (LinearLayout)findViewById(R.id.layout1);
        tab_shouye = (LinearLayout)findViewById(R.id.layout2);
        tab_shequ = (LinearLayout)findViewById(R.id.layout3) ;
        tab_setting = (LinearLayout)findViewById(R.id.layout4) ;

        tab_favor.setOnClickListener(onClickListener);
        tab_shouye.setOnClickListener(onClickListener);
        tab_shequ.setOnClickListener(onClickListener);
        tab_setting.setOnClickListener(onClickListener);
        selectTab(0);
    }
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            resetImage();
            switch (view.getId()) {
                case R.id.layout1:
                    selectTab(0);
                    break;
                case R.id.layout2:
                    selectTab(1);
                    break;
                case R.id.layout3:
                    selectTab(2);
                    break;
                case R.id.layout4:
                    selectTab(3);
                    break;
            }
        }
    };
    @Override
    void initEvent() {

    }

    private void selectTab(int i){
        fragmentManager=getSupportFragmentManager();
        fragmentTransaction=fragmentManager.beginTransaction();
        hideFragment(fragmentTransaction);
        switch (i){
            case 0:
                if (fragment_favor==null){
                    fragment_favor=new ShopFragment();
                    fragmentTransaction.add(R.id.framelayout,fragment_favor);
                }
                else{
                    fragmentTransaction.show(fragment_favor);
                }
                btn_favor.setImageResource(R.drawable.ic_shouye_press);
                break;
            case 1:
                if (fragment_shouye==null){
                    fragment_shouye=new CollectFragment();
                    fragmentTransaction.add(R.id.framelayout,fragment_shouye);
                }
                else{
                    fragmentTransaction.show(fragment_shouye);
                }
                btn_shouye.setImageResource(R.drawable.ic_favor_press);
                break;
            case 2:
                if (fragment_shequ==null){
                    fragment_shequ=new SearchFragment();
                    fragmentTransaction.add(R.id.framelayout,fragment_shequ);
                }
                else{
                    fragmentTransaction.show(fragment_shequ);
                }
                btn_shequ.setImageResource(R.drawable.ic_search_press);
                break;
            case 3:
                if (fragment_setting==null){
                    fragment_setting=new SettingFragment();
                    fragmentTransaction.add(R.id.framelayout,fragment_setting);
                }
                else{
                    fragmentTransaction.show(fragment_setting);
                }
                btn_setting.setImageResource(R.drawable.ic_setting_pressed);
                break;
            default:
                break;
        }
        fragmentTransaction.commit();
    }

    @Override
    void initData() {

    }
    private void resetImage(){
        btn_favor.setImageResource(R.drawable.ic_shouye_normal);
        btn_shouye.setImageResource(R.drawable.ic_favor_nomal);
        btn_shequ.setImageResource(R.drawable.ic_search_normal);
        btn_setting.setImageResource(R.drawable.ic_setting_normal);
    }

    private void hideFragment(FragmentTransaction fragmentTransaction){
        if(fragment_favor!=null){
            fragmentTransaction.hide(fragment_favor);
        }
        if (fragment_shouye!=null){
            fragmentTransaction.hide(fragment_shouye);
        }
        if (fragment_shequ!=null){
            fragmentTransaction.hide(fragment_shequ);
        }
        if (fragment_setting!=null){
            fragmentTransaction.hide(fragment_setting);
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
