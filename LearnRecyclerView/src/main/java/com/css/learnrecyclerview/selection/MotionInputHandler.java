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

package com.css.learnrecyclerview.selection;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

import com.css.learnrecyclerview.widget.RecyclerView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import static com.css.learnrecyclerview.ext.Preconditions.checkArgument;
import static com.css.learnrecyclerview.ext.Preconditions.checkState;


/**
 * Base class for handlers that can be registered w/ {@link GestureRouter}.
 */
abstract class MotionInputHandler<K> extends SimpleOnGestureListener {

    protected final SelectionTracker<K> mSelectionTracker;

    private final ItemKeyProvider<K> mKeyProvider;
    private final FocusDelegate<K> mFocusDelegate;

    MotionInputHandler(
            @NonNull SelectionTracker<K> selectionTracker,
            @NonNull ItemKeyProvider<K> keyProvider,
            @NonNull FocusDelegate<K> focusDelegate) {

        checkArgument(selectionTracker != null);
        checkArgument(keyProvider != null);
        checkArgument(focusDelegate != null);

        mSelectionTracker = selectionTracker;
        mKeyProvider = keyProvider;
        mFocusDelegate = focusDelegate;
    }

    final boolean selectItem(@NonNull ItemDetailsLookup.ItemDetails<K> details) {
        checkArgument(details != null);
        checkArgument(hasPosition(details));
        checkArgument(hasSelectionKey(details));

        if (mSelectionTracker.select(details.getSelectionKey())) {
            mSelectionTracker.anchorRange(details.getPosition());
        }

        // we set the focus on this doc so it will be the origin for keyboard events or shift+clicks
        // if there is only a single item selected, otherwise clear focus
        if (mSelectionTracker.getSelection().size() == 1) {
            mFocusDelegate.focusItem(details);
        } else {
            mFocusDelegate.clearFocus();
        }
        return true;
    }

    protected final boolean focusItem(@NonNull ItemDetailsLookup.ItemDetails<K> details) {
        checkArgument(details != null);
        checkArgument(hasSelectionKey(details));

        mSelectionTracker.clearSelection();
        mFocusDelegate.focusItem(details);
        return true;
    }

    protected final void extendSelectionRange(@NonNull ItemDetailsLookup.ItemDetails<K> details) {
        checkState(mKeyProvider.hasAccess(ItemKeyProvider.SCOPE_MAPPED));
        checkArgument(hasPosition(details));
        checkArgument(hasSelectionKey(details));

        mSelectionTracker.extendRange(details.getPosition());
        mFocusDelegate.focusItem(details);
    }

    final boolean isRangeExtension(@NonNull MotionEvent e) {
        return MotionEvents.isShiftKeyPressed(e)
                && mSelectionTracker.isRangeActive()
                // Without full corpus access we can't reliably implement range
                // as a user can scroll *anywhere* then SHIFT+click.
                && mKeyProvider.hasAccess(ItemKeyProvider.SCOPE_MAPPED);
    }

    boolean shouldClearSelection(@NonNull MotionEvent e, @NonNull ItemDetailsLookup.ItemDetails<K> item) {
        return !MotionEvents.isCtrlKeyPressed(e)
                && !item.inSelectionHotspot(e)
                && !mSelectionTracker.isSelected(item.getSelectionKey());
    }

    static boolean hasSelectionKey(@Nullable ItemDetailsLookup.ItemDetails<?> item) {
        return item != null && item.getSelectionKey() != null;
    }

    static boolean hasPosition(@Nullable ItemDetailsLookup.ItemDetails<?> item) {
        return item != null && item.getPosition() != RecyclerView.NO_POSITION;
    }
}
