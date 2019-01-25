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

import androidx.recyclerview.selection.ItemDetailsLookup;

import javax.annotation.Nullable;

/**
 * Test impl of ItemDetailsLookup.
 */
public class TestItemDetailsLookup extends ItemDetailsLookup<String> {

    private @Nullable TestItemDetails mItem;

    @Override
    public @Nullable ItemDetails<String> getItemDetails(MotionEvent e) {
        return mItem;
    }

    /**
     * Creates/installs/returns a new test document. Subsequent calls to
     * any EventDocLookup methods will consult the newly created doc.
     */
    public TestItemDetails initAt(int position) {
        TestItemDetails doc = new TestItemDetails();
        doc.at(position);
        mItem = doc;
        return doc;
    }
}
