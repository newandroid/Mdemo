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

import com.css.learnrecyclerview.selection.OnContextClickListener;

import static org.junit.Assert.assertTrue;


public final class TestOnContextClickListener implements OnContextClickListener {

    private MotionEvent mLastContextEvent;

    @Override
    public boolean onContextClick(MotionEvent e) {
        mLastContextEvent = e;
        return false;
    }

    public void assertLastEvent(MotionEvent expected) {
        // sadly, MotionEvent doesn't implement equals, so we compare references.
        assertTrue(expected == mLastContextEvent);
    }
}
