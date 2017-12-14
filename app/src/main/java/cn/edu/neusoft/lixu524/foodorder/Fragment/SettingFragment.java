package cn.edu.neusoft.lixu524.foodorder.Fragment;

import android.net.Uri;
import android.widget.Toast;

import cn.edu.neusoft.lixu524.foodorder.R;

/**
 * Created by www44 on 2017/11/20.
 */

public class SettingFragment extends BaseFragment {
    @Override
    void initLayout() {
        setLayout_file(R.layout.fragment_setting);
    }

    @Override
    void initView() {

        System.out.println(this.layout_file+"  "+0x7f040021);

//        public static final int fragment_collect=0x7f04001f;
//        public static final int fragment_search=0x7f040020;
//        public static final int fragment_shop=0x7f040022;
//        Toast.makeText(getActivity(),"search",Toast.LENGTH_SHORT);
    }

    @Override
    void initEvent() {

    }

    @Override
    void initData() {

    }

    public SettingFragment(){

    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
