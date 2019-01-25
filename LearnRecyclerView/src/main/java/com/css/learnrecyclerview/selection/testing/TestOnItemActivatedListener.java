/*
 * Copyright 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.css.learnrecyclerview.selection.testing;

import android.view.MotionEvent;

import com.css.learnrecyclerview.selection.ItemDetailsLookup;
import com.css.learnrecyclerview.selection.OnItemActivatedListener;

import static org.junit.Assert.assertEquals;


public final class TestOnItemActivatedListener<K> implements OnItemActivatedListener<K> {

    private ItemDetailsLookup.ItemDetails<K> mActivated;

    @Override
    public boolean onItemActivated(ItemDetailsLookup.ItemDetails<K> item, MotionEvent e) {
        mActivated = item;
        return true;
    }

    public void assertActivated(ItemDetailsLookup.ItemDetails<K> expected) {
        assertEquals(expected, mActivated);
    }
}
