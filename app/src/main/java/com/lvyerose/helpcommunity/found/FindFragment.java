package com.lvyerose.helpcommunity.found;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lvyerose.helpcommunity.R;
import com.lvyerose.helpcommunity.base.BaseFragment;

/**
 * author: lvyeRose
 * objective:
 * mailbox: lvyerose@163.com
 * time: 15/11/1 20:11
 */
public class FindFragment extends BaseFragment{
    private View mView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_find , container , false);
        return mView;
    }
}
