package com.freelancing.ahmed.fondooy;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.SparseIntArray;

/**
 * Created by ahmed on 10/28/2017.
 */

public abstract class AbsRuntimePermission extends Activity {
    private SparseIntArray mErrorString;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mErrorString= new SparseIntArray();
    }

}
