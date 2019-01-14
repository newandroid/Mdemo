package css.com.applab.view;

import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Display;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewOverlay;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.ViewStructure;
import android.view.ViewTreeObserver;
import android.view.WindowId;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.animation.Animation;
import android.view.autofill.AutofillId;
import android.view.autofill.AutofillValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;

import java.util.ArrayList;
import java.util.Collection;

public class LifeCycleView extends View {
    private static final String TAG = "ViewLiftCycle";
    public LifeCycleView(Context context) {
        super(context);
        Log.d(TAG, "ViewLiftCycle() called with: context = [" + context + "]");
    }

    public LifeCycleView(Context context, @androidx.annotation.Nullable AttributeSet attrs) {
        super(context, attrs);
        Log.d(TAG, "ViewLiftCycle() called with: context = [" + context + "], attrs = [" + attrs + "]");
    }

    public LifeCycleView(Context context, @androidx.annotation.Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Log.d(TAG, "ViewLiftCycle() called with: context = [" + context + "], attrs = [" + attrs + "], defStyleAttr = [" + defStyleAttr + "]");
    }


    @Override
    public String toString() {
        Log.d(TAG, "toString() called");
        return super.toString();
    }

    @Override
    public int getVerticalFadingEdgeLength() {
        Log.d(TAG, "getVerticalFadingEdgeLength() called");
        return super.getVerticalFadingEdgeLength();
    }

    @Override
    public void setFadingEdgeLength(int length) {
        Log.d(TAG, "setFadingEdgeLength() called with: length = [" + length + "]");
        super.setFadingEdgeLength(length);
    }

    @Override
    public int getHorizontalFadingEdgeLength() {
        Log.d(TAG, "getHorizontalFadingEdgeLength() called");
        return super.getHorizontalFadingEdgeLength();
    }

    @Override
    public int getVerticalScrollbarWidth() {
        Log.d(TAG, "getVerticalScrollbarWidth() called");
        return super.getVerticalScrollbarWidth();
    }

    @Override
    protected int getHorizontalScrollbarHeight() {
        Log.d(TAG, "getHorizontalScrollbarHeight() called");
        return super.getHorizontalScrollbarHeight();
    }

    @Override
    public void setVerticalScrollbarPosition(int position) {
        Log.d(TAG, "setVerticalScrollbarPosition() called with: position = [" + position + "]");
        super.setVerticalScrollbarPosition(position);
    }

    @Override
    public int getVerticalScrollbarPosition() {
        Log.d(TAG, "getVerticalScrollbarPosition() called");
        return super.getVerticalScrollbarPosition();
    }

    @Override
    public void setScrollIndicators(int indicators) {
        Log.d(TAG, "setScrollIndicators() called with: indicators = [" + indicators + "]");
        super.setScrollIndicators(indicators);
    }

    @Override
    public void setScrollIndicators(int indicators, int mask) {
        Log.d(TAG, "setScrollIndicators() called with: indicators = [" + indicators + "], mask = [" + mask + "]");
        super.setScrollIndicators(indicators, mask);
    }

    @Override
    public int getScrollIndicators() {
        Log.d(TAG, "getScrollIndicators() called");
        return super.getScrollIndicators();
    }

    @Override
    public void setOnScrollChangeListener(OnScrollChangeListener l) {
        Log.d(TAG, "setOnScrollChangeListener() called with: l = [" + l + "]");
        super.setOnScrollChangeListener(l);
    }

    @Override
    public void setOnFocusChangeListener(OnFocusChangeListener l) {
        Log.d(TAG, "setOnFocusChangeListener() called with: l = [" + l + "]");
        super.setOnFocusChangeListener(l);
    }

    @Override
    public void addOnLayoutChangeListener(OnLayoutChangeListener listener) {
        Log.d(TAG, "addOnLayoutChangeListener() called with: listener = [" + listener + "]");
        super.addOnLayoutChangeListener(listener);
    }

    @Override
    public void removeOnLayoutChangeListener(OnLayoutChangeListener listener) {
        Log.d(TAG, "removeOnLayoutChangeListener() called with: listener = [" + listener + "]");
        super.removeOnLayoutChangeListener(listener);
    }

    @Override
    public void addOnAttachStateChangeListener(OnAttachStateChangeListener listener) {
        Log.d(TAG, "addOnAttachStateChangeListener() called with: listener = [" + listener + "]");
        super.addOnAttachStateChangeListener(listener);
    }

    @Override
    public void removeOnAttachStateChangeListener(OnAttachStateChangeListener listener) {
        Log.d(TAG, "removeOnAttachStateChangeListener() called with: listener = [" + listener + "]");
        super.removeOnAttachStateChangeListener(listener);
    }

    @Override
    public OnFocusChangeListener getOnFocusChangeListener() {
        Log.d(TAG, "getOnFocusChangeListener() called");
        return super.getOnFocusChangeListener();
    }

    @Override
    public void setOnClickListener(@androidx.annotation.Nullable View.OnClickListener l) {
        Log.d(TAG, "setOnClickListener() called with: l = [" + l + "]");
        super.setOnClickListener(l);
    }

    @Override
    public boolean hasOnClickListeners() {
        Log.d(TAG, "hasOnClickListeners() called");
        return super.hasOnClickListeners();
    }

    @Override
    public void setOnLongClickListener(@androidx.annotation.Nullable View.OnLongClickListener l) {
        Log.d(TAG, "setOnLongClickListener() called with: l = [" + l + "]");
        super.setOnLongClickListener(l);
    }

    @Override
    public void setOnContextClickListener(@androidx.annotation.Nullable View.OnContextClickListener l) {
        Log.d(TAG, "setOnContextClickListener() called with: l = [" + l + "]");
        super.setOnContextClickListener(l);
    }

    @Override
    public void setOnCreateContextMenuListener(OnCreateContextMenuListener l) {
        Log.d(TAG, "setOnCreateContextMenuListener() called with: l = [" + l + "]");
        super.setOnCreateContextMenuListener(l);
    }

    @Override
    public boolean performClick() {
        Log.d(TAG, "performClick() called");
        return super.performClick();
    }

    @Override
    public boolean callOnClick() {
        Log.d(TAG, "callOnClick() called");
        return super.callOnClick();
    }

    @Override
    public boolean performLongClick() {
        Log.d(TAG, "performLongClick() called");
        return super.performLongClick();
    }

    @Override
    public boolean performLongClick(float x, float y) {
        Log.d(TAG, "performLongClick() called with: x = [" + x + "], y = [" + y + "]");
        return super.performLongClick(x, y);
    }

    @Override
    public boolean performContextClick(float x, float y) {
        Log.d(TAG, "performContextClick() called with: x = [" + x + "], y = [" + y + "]");
        return super.performContextClick(x, y);
    }

    @Override
    public boolean performContextClick() {
        Log.d(TAG, "performContextClick() called");
        return super.performContextClick();
    }

    @Override
    public boolean showContextMenu() {
        Log.d(TAG, "showContextMenu() called");
        return super.showContextMenu();
    }

    @Override
    public boolean showContextMenu(float x, float y) {
        Log.d(TAG, "showContextMenu() called with: x = [" + x + "], y = [" + y + "]");
        return super.showContextMenu(x, y);
    }

    @Override
    public ActionMode startActionMode(ActionMode.Callback callback) {
        Log.d(TAG, "startActionMode() called with: callback = [" + callback + "]");
        return super.startActionMode(callback);
    }

    @Override
    public ActionMode startActionMode(ActionMode.Callback callback, int type) {
        Log.d(TAG, "startActionMode() called with: callback = [" + callback + "], type = [" + type + "]");
        return super.startActionMode(callback, type);
    }

    @Override
    public void setOnKeyListener(OnKeyListener l) {
        Log.d(TAG, "setOnKeyListener() called with: l = [" + l + "]");
        super.setOnKeyListener(l);
    }

    @Override
    public void setOnTouchListener(OnTouchListener l) {
        Log.d(TAG, "setOnTouchListener() called with: l = [" + l + "]");
        super.setOnTouchListener(l);
    }

    @Override
    public void setOnGenericMotionListener(OnGenericMotionListener l) {
        Log.d(TAG, "setOnGenericMotionListener() called with: l = [" + l + "]");
        super.setOnGenericMotionListener(l);
    }

    @Override
    public void setOnHoverListener(OnHoverListener l) {
        Log.d(TAG, "setOnHoverListener() called with: l = [" + l + "]");
        super.setOnHoverListener(l);
    }

    @Override
    public void setOnDragListener(OnDragListener l) {
        Log.d(TAG, "setOnDragListener() called with: l = [" + l + "]");
        super.setOnDragListener(l);
    }

    @Override
    public boolean requestRectangleOnScreen(Rect rectangle) {
        Log.d(TAG, "requestRectangleOnScreen() called with: rectangle = [" + rectangle + "]");
        return super.requestRectangleOnScreen(rectangle);
    }

    @Override
    public boolean requestRectangleOnScreen(Rect rectangle, boolean immediate) {
        Log.d(TAG, "requestRectangleOnScreen() called with: rectangle = [" + rectangle + "], immediate = [" + immediate + "]");
        return super.requestRectangleOnScreen(rectangle, immediate);
    }

    @Override
    public void clearFocus() {
        Log.d(TAG, "clearFocus() called");
        super.clearFocus();
    }

    @Override
    public boolean hasFocus() {
        Log.d(TAG, "hasFocus() called");
        return super.hasFocus();
    }

    @Override
    public boolean hasFocusable() {
        Log.d(TAG, "hasFocusable() called");
        return super.hasFocusable();
    }

    @Override
    public boolean hasExplicitFocusable() {
        Log.d(TAG, "hasExplicitFocusable() called");
        return super.hasExplicitFocusable();
    }

    @Override
    protected void onFocusChanged(boolean gainFocus, int direction, @androidx.annotation.Nullable Rect previouslyFocusedRect) {
        Log.d(TAG, "onFocusChanged() called with: gainFocus = [" + gainFocus + "], direction = [" + direction + "], previouslyFocusedRect = [" + previouslyFocusedRect + "]");
        super.onFocusChanged(gainFocus, direction, previouslyFocusedRect);
    }

    @Override
    public void setAccessibilityPaneTitle(@androidx.annotation.Nullable CharSequence accessibilityPaneTitle) {
        Log.d(TAG, "setAccessibilityPaneTitle() called with: accessibilityPaneTitle = [" + accessibilityPaneTitle + "]");
        super.setAccessibilityPaneTitle(accessibilityPaneTitle);
    }

    @androidx.annotation.Nullable
    @Override
    public CharSequence getAccessibilityPaneTitle() {
        Log.d(TAG, "getAccessibilityPaneTitle() called");
        return super.getAccessibilityPaneTitle();
    }

    @Override
    public void sendAccessibilityEvent(int eventType) {
        Log.d(TAG, "sendAccessibilityEvent() called with: eventType = [" + eventType + "]");
        super.sendAccessibilityEvent(eventType);
    }

    @Override
    public void announceForAccessibility(CharSequence text) {
        Log.d(TAG, "announceForAccessibility() called with: text = [" + text + "]");
        super.announceForAccessibility(text);
    }

    @Override
    public void sendAccessibilityEventUnchecked(AccessibilityEvent event) {
        Log.d(TAG, "sendAccessibilityEventUnchecked() called with: event = [" + event + "]");
        super.sendAccessibilityEventUnchecked(event);
    }

    @Override
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        Log.d(TAG, "dispatchPopulateAccessibilityEvent() called with: event = [" + event + "]");
        return super.dispatchPopulateAccessibilityEvent(event);
    }

    @Override
    public void onPopulateAccessibilityEvent(AccessibilityEvent event) {
        Log.d(TAG, "onPopulateAccessibilityEvent() called with: event = [" + event + "]");
        super.onPopulateAccessibilityEvent(event);
    }

    @Override
    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        Log.d(TAG, "onInitializeAccessibilityEvent() called with: event = [" + event + "]");
        super.onInitializeAccessibilityEvent(event);
    }

    @Override
    public AccessibilityNodeInfo createAccessibilityNodeInfo() {
        Log.d(TAG, "createAccessibilityNodeInfo() called");
        return super.createAccessibilityNodeInfo();
    }

    @Override
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        Log.d(TAG, "onInitializeAccessibilityNodeInfo() called with: info = [" + info + "]");
        super.onInitializeAccessibilityNodeInfo(info);
    }

    @Override
    public CharSequence getAccessibilityClassName() {
        Log.d(TAG, "getAccessibilityClassName() called");
        return super.getAccessibilityClassName();
    }

    @Override
    public void onProvideStructure(ViewStructure structure) {
        Log.d(TAG, "onProvideStructure() called with: structure = [" + structure + "]");
        super.onProvideStructure(structure);
    }

    @Override
    public void onProvideAutofillStructure(ViewStructure structure, int flags) {
        Log.d(TAG, "onProvideAutofillStructure() called with: structure = [" + structure + "], flags = [" + flags + "]");
        super.onProvideAutofillStructure(structure, flags);
    }

    @Override
    public void onProvideVirtualStructure(ViewStructure structure) {
        Log.d(TAG, "onProvideVirtualStructure() called with: structure = [" + structure + "]");
        super.onProvideVirtualStructure(structure);
    }

    @Override
    public void onProvideAutofillVirtualStructure(ViewStructure structure, int flags) {
        Log.d(TAG, "onProvideAutofillVirtualStructure() called with: structure = [" + structure + "], flags = [" + flags + "]");
        super.onProvideAutofillVirtualStructure(structure, flags);
    }

    @Override
    public void autofill(AutofillValue value) {
        Log.d(TAG, "autofill() called with: value = [" + value + "]");
        super.autofill(value);
    }

    @Override
    public void autofill(@androidx.annotation.NonNull SparseArray<AutofillValue> values) {
        Log.d(TAG, "autofill() called with: values = [" + values + "]");
        super.autofill(values);
    }

    @Override
    public void setAutofillId(@androidx.annotation.Nullable AutofillId id) {
        Log.d(TAG, "setAutofillId() called with: id = [" + id + "]");
        super.setAutofillId(id);
    }

    @Override
    public int getAutofillType() {
        Log.d(TAG, "getAutofillType() called");
        return super.getAutofillType();
    }

    @androidx.annotation.Nullable
    @Override
    public String[] getAutofillHints() {
        Log.d(TAG, "getAutofillHints() called");
        return super.getAutofillHints();
    }

    @androidx.annotation.Nullable
    @Override
    public AutofillValue getAutofillValue() {
        Log.d(TAG, "getAutofillValue() called");
        return super.getAutofillValue();
    }

    @Override
    public int getImportantForAutofill() {
        Log.d(TAG, "getImportantForAutofill() called");
        return super.getImportantForAutofill();
    }

    @Override
    public void setImportantForAutofill(int mode) {
        Log.d(TAG, "setImportantForAutofill() called with: mode = [" + mode + "]");
        super.setImportantForAutofill(mode);
    }

    @Override
    public void dispatchProvideStructure(ViewStructure structure) {
        Log.d(TAG, "dispatchProvideStructure() called with: structure = [" + structure + "]");
        super.dispatchProvideStructure(structure);
    }

    @Override
    public void dispatchProvideAutofillStructure(@androidx.annotation.NonNull ViewStructure structure, int flags) {
        Log.d(TAG, "dispatchProvideAutofillStructure() called with: structure = [" + structure + "], flags = [" + flags + "]");
        super.dispatchProvideAutofillStructure(structure, flags);
    }

    @Override
    public void addExtraDataToAccessibilityNodeInfo(@androidx.annotation.NonNull AccessibilityNodeInfo info, @androidx.annotation.NonNull String extraDataKey, @androidx.annotation.Nullable Bundle arguments) {
        Log.d(TAG, "addExtraDataToAccessibilityNodeInfo() called with: info = [" + info + "], extraDataKey = [" + extraDataKey + "], arguments = [" + arguments + "]");
        super.addExtraDataToAccessibilityNodeInfo(info, extraDataKey, arguments);
    }

    @Override
    public boolean isVisibleToUserForAutofill(int virtualId) {
        Log.d(TAG, "isVisibleToUserForAutofill() called with: virtualId = [" + virtualId + "]");
        return super.isVisibleToUserForAutofill(virtualId);
    }

    @Override
    public void setAccessibilityDelegate(@androidx.annotation.Nullable View.AccessibilityDelegate delegate) {
        Log.d(TAG, "setAccessibilityDelegate() called with: delegate = [" + delegate + "]");
        super.setAccessibilityDelegate(delegate);
    }

    @Override
    public AccessibilityNodeProvider getAccessibilityNodeProvider() {
        Log.d(TAG, "getAccessibilityNodeProvider() called");
        return super.getAccessibilityNodeProvider();
    }

    @Override
    public void setContentDescription(CharSequence contentDescription) {
        Log.d(TAG, "setContentDescription() called with: contentDescription = [" + contentDescription + "]");
        super.setContentDescription(contentDescription);
    }

    @Override
    public void setAccessibilityTraversalBefore(int beforeId) {
        Log.d(TAG, "setAccessibilityTraversalBefore() called with: beforeId = [" + beforeId + "]");
        super.setAccessibilityTraversalBefore(beforeId);
    }

    @Override
    public int getAccessibilityTraversalBefore() {
        Log.d(TAG, "getAccessibilityTraversalBefore() called");
        return super.getAccessibilityTraversalBefore();
    }

    @Override
    public void setAccessibilityTraversalAfter(int afterId) {
        Log.d(TAG, "setAccessibilityTraversalAfter() called with: afterId = [" + afterId + "]");
        super.setAccessibilityTraversalAfter(afterId);
    }

    @Override
    public int getAccessibilityTraversalAfter() {
        Log.d(TAG, "getAccessibilityTraversalAfter() called");
        return super.getAccessibilityTraversalAfter();
    }

    @Override
    public int getLabelFor() {
        Log.d(TAG, "getLabelFor() called");
        return super.getLabelFor();
    }

    @Override
    public void setLabelFor(int id) {
        Log.d(TAG, "setLabelFor() called with: id = [" + id + "]");
        super.setLabelFor(id);
    }

    @Override
    public boolean isFocused() {
        Log.d(TAG, "isFocused() called");
        return super.isFocused();
    }

    @Override
    public View findFocus() {
        Log.d(TAG, "findFocus() called");
        return super.findFocus();
    }

    @Override
    public boolean isScrollContainer() {
        Log.d(TAG, "isScrollContainer() called");
        return super.isScrollContainer();
    }

    @Override
    public void setScrollContainer(boolean isScrollContainer) {
        Log.d(TAG, "setScrollContainer() called with: isScrollContainer = [" + isScrollContainer + "]");
        super.setScrollContainer(isScrollContainer);
    }

    @Override
    public int getDrawingCacheQuality() {
        Log.d(TAG, "getDrawingCacheQuality() called");
        return super.getDrawingCacheQuality();
    }

    @Override
    public void setDrawingCacheQuality(int quality) {
        Log.d(TAG, "setDrawingCacheQuality() called with: quality = [" + quality + "]");
        super.setDrawingCacheQuality(quality);
    }

    @Override
    public boolean getKeepScreenOn() {
        Log.d(TAG, "getKeepScreenOn() called");
        return super.getKeepScreenOn();
    }

    @Override
    public void setKeepScreenOn(boolean keepScreenOn) {
        Log.d(TAG, "setKeepScreenOn() called with: keepScreenOn = [" + keepScreenOn + "]");
        super.setKeepScreenOn(keepScreenOn);
    }

    @Override
    public int getNextFocusLeftId() {
        Log.d(TAG, "getNextFocusLeftId() called");
        return super.getNextFocusLeftId();
    }

    @Override
    public void setNextFocusLeftId(int nextFocusLeftId) {
        Log.d(TAG, "setNextFocusLeftId() called with: nextFocusLeftId = [" + nextFocusLeftId + "]");
        super.setNextFocusLeftId(nextFocusLeftId);
    }

    @Override
    public int getNextFocusRightId() {
        Log.d(TAG, "getNextFocusRightId() called");
        return super.getNextFocusRightId();
    }

    @Override
    public void setNextFocusRightId(int nextFocusRightId) {
        Log.d(TAG, "setNextFocusRightId() called with: nextFocusRightId = [" + nextFocusRightId + "]");
        super.setNextFocusRightId(nextFocusRightId);
    }

    @Override
    public int getNextFocusUpId() {
        Log.d(TAG, "getNextFocusUpId() called");
        return super.getNextFocusUpId();
    }

    @Override
    public void setNextFocusUpId(int nextFocusUpId) {
        Log.d(TAG, "setNextFocusUpId() called with: nextFocusUpId = [" + nextFocusUpId + "]");
        super.setNextFocusUpId(nextFocusUpId);
    }

    @Override
    public int getNextFocusDownId() {
        Log.d(TAG, "getNextFocusDownId() called");
        return super.getNextFocusDownId();
    }

    @Override
    public void setNextFocusDownId(int nextFocusDownId) {
        Log.d(TAG, "setNextFocusDownId() called with: nextFocusDownId = [" + nextFocusDownId + "]");
        super.setNextFocusDownId(nextFocusDownId);
    }

    @Override
    public int getNextFocusForwardId() {
        Log.d(TAG, "getNextFocusForwardId() called");
        return super.getNextFocusForwardId();
    }

    @Override
    public void setNextFocusForwardId(int nextFocusForwardId) {
        Log.d(TAG, "setNextFocusForwardId() called with: nextFocusForwardId = [" + nextFocusForwardId + "]");
        super.setNextFocusForwardId(nextFocusForwardId);
    }

    @Override
    public int getNextClusterForwardId() {
        Log.d(TAG, "getNextClusterForwardId() called");
        return super.getNextClusterForwardId();
    }

    @Override
    public void setNextClusterForwardId(int nextClusterForwardId) {
        Log.d(TAG, "setNextClusterForwardId() called with: nextClusterForwardId = [" + nextClusterForwardId + "]");
        super.setNextClusterForwardId(nextClusterForwardId);
    }

    @Override
    public boolean isShown() {
        Log.d(TAG, "isShown() called");
        return super.isShown();
    }

    @Override
    protected boolean fitSystemWindows(Rect insets) {
        Log.d(TAG, "fitSystemWindows() called with: insets = [" + insets + "]");
        return super.fitSystemWindows(insets);
    }

    @Override
    public WindowInsets onApplyWindowInsets(WindowInsets insets) {
        Log.d(TAG, "onApplyWindowInsets() called with: insets = [" + insets + "]");
        return super.onApplyWindowInsets(insets);
    }

    @Override
    public void setOnApplyWindowInsetsListener(OnApplyWindowInsetsListener listener) {
        Log.d(TAG, "setOnApplyWindowInsetsListener() called with: listener = [" + listener + "]");
        super.setOnApplyWindowInsetsListener(listener);
    }

    @Override
    public WindowInsets dispatchApplyWindowInsets(WindowInsets insets) {
        Log.d(TAG, "dispatchApplyWindowInsets() called with: insets = [" + insets + "]");
        return super.dispatchApplyWindowInsets(insets);
    }

    @Override
    public WindowInsets getRootWindowInsets() {
        Log.d(TAG, "getRootWindowInsets() called");
        return super.getRootWindowInsets();
    }

    @Override
    public WindowInsets computeSystemWindowInsets(WindowInsets in, Rect outLocalInsets) {
        Log.d(TAG, "computeSystemWindowInsets() called with: in = [" + in + "], outLocalInsets = [" + outLocalInsets + "]");
        return super.computeSystemWindowInsets(in, outLocalInsets);
    }

    @Override
    public void setFitsSystemWindows(boolean fitSystemWindows) {
        Log.d(TAG, "setFitsSystemWindows() called with: fitSystemWindows = [" + fitSystemWindows + "]");
        super.setFitsSystemWindows(fitSystemWindows);
    }

    @Override
    public boolean getFitsSystemWindows() {
        Log.d(TAG, "getFitsSystemWindows() called");
        return super.getFitsSystemWindows();
    }

    @Override
    public void requestFitSystemWindows() {
        Log.d(TAG, "requestFitSystemWindows() called");
        super.requestFitSystemWindows();
    }

    @Override
    public void requestApplyInsets() {
        Log.d(TAG, "requestApplyInsets() called");
        super.requestApplyInsets();
    }

    @Override
    public int getVisibility() {
        Log.d(TAG, "getVisibility() called");
        return super.getVisibility();
    }

    @Override
    public void setVisibility(int visibility) {
        Log.d(TAG, "setVisibility() called with: visibility = [" + visibility + "]");
        super.setVisibility(visibility);
    }

    @Override
    public boolean isEnabled() {
        Log.d(TAG, "isEnabled() called");
        return super.isEnabled();
    }

    @Override
    public void setEnabled(boolean enabled) {
        Log.d(TAG, "setEnabled() called with: enabled = [" + enabled + "]");
        super.setEnabled(enabled);
    }

    @Override
    public void setFocusable(boolean focusable) {
        Log.d(TAG, "setFocusable() called with: focusable = [" + focusable + "]");
        super.setFocusable(focusable);
    }

    @Override
    public void setFocusable(int focusable) {
        Log.d(TAG, "setFocusable() called with: focusable = [" + focusable + "]");
        super.setFocusable(focusable);
    }

    @Override
    public void setFocusableInTouchMode(boolean focusableInTouchMode) {
        Log.d(TAG, "setFocusableInTouchMode() called with: focusableInTouchMode = [" + focusableInTouchMode + "]");
        super.setFocusableInTouchMode(focusableInTouchMode);
    }

    @Override
    public void setAutofillHints(@androidx.annotation.Nullable String... autofillHints) {
        Log.d(TAG, "setAutofillHints() called with: autofillHints = [" + autofillHints + "]");
        super.setAutofillHints(autofillHints);
    }

    @Override
    public void setSoundEffectsEnabled(boolean soundEffectsEnabled) {
        Log.d(TAG, "setSoundEffectsEnabled() called with: soundEffectsEnabled = [" + soundEffectsEnabled + "]");
        super.setSoundEffectsEnabled(soundEffectsEnabled);
    }

    @Override
    public boolean isSoundEffectsEnabled() {
        Log.d(TAG, "isSoundEffectsEnabled() called");
        return super.isSoundEffectsEnabled();
    }

    @Override
    public void setHapticFeedbackEnabled(boolean hapticFeedbackEnabled) {
        Log.d(TAG, "setHapticFeedbackEnabled() called with: hapticFeedbackEnabled = [" + hapticFeedbackEnabled + "]");
        super.setHapticFeedbackEnabled(hapticFeedbackEnabled);
    }

    @Override
    public boolean isHapticFeedbackEnabled() {
        Log.d(TAG, "isHapticFeedbackEnabled() called");
        return super.isHapticFeedbackEnabled();
    }

    @Override
    public void setLayoutDirection(int layoutDirection) {
        Log.d(TAG, "setLayoutDirection() called with: layoutDirection = [" + layoutDirection + "]");
        super.setLayoutDirection(layoutDirection);
    }

    @Override
    public int getLayoutDirection() {
        Log.d(TAG, "getLayoutDirection() called");
        return super.getLayoutDirection();
    }

    @Override
    public boolean hasTransientState() {
        Log.d(TAG, "hasTransientState() called");
        return super.hasTransientState();
    }

    @Override
    public void setHasTransientState(boolean hasTransientState) {
        Log.d(TAG, "setHasTransientState() called with: hasTransientState = [" + hasTransientState + "]");
        super.setHasTransientState(hasTransientState);
    }

    @Override
    public boolean isAttachedToWindow() {
        Log.d(TAG, "isAttachedToWindow() called");
        return super.isAttachedToWindow();
    }

    @Override
    public boolean isLaidOut() {
        Log.d(TAG, "isLaidOut() called");
        return super.isLaidOut();
    }

    @Override
    public void setWillNotDraw(boolean willNotDraw) {
        Log.d(TAG, "setWillNotDraw() called with: willNotDraw = [" + willNotDraw + "]");
        super.setWillNotDraw(willNotDraw);
    }

    @Override
    public boolean willNotDraw() {
        Log.d(TAG, "willNotDraw() called");
        return super.willNotDraw();
    }

    @Override
    public void setWillNotCacheDrawing(boolean willNotCacheDrawing) {
        Log.d(TAG, "setWillNotCacheDrawing() called with: willNotCacheDrawing = [" + willNotCacheDrawing + "]");
        super.setWillNotCacheDrawing(willNotCacheDrawing);
    }

    @Override
    public boolean willNotCacheDrawing() {
        Log.d(TAG, "willNotCacheDrawing() called");
        return super.willNotCacheDrawing();
    }

    @Override
    public boolean isClickable() {
        Log.d(TAG, "isClickable() called");
        return super.isClickable();
    }

    @Override
    public void setClickable(boolean clickable) {
        Log.d(TAG, "setClickable() called with: clickable = [" + clickable + "]");
        super.setClickable(clickable);
    }

    @Override
    public boolean isLongClickable() {
        Log.d(TAG, "isLongClickable() called");
        return super.isLongClickable();
    }

    @Override
    public void setLongClickable(boolean longClickable) {
        Log.d(TAG, "setLongClickable() called with: longClickable = [" + longClickable + "]");
        super.setLongClickable(longClickable);
    }

    @Override
    public boolean isContextClickable() {
        Log.d(TAG, "isContextClickable() called");
        return super.isContextClickable();
    }

    @Override
    public void setContextClickable(boolean contextClickable) {
        Log.d(TAG, "setContextClickable() called with: contextClickable = [" + contextClickable + "]");
        super.setContextClickable(contextClickable);
    }

    @Override
    public void setPressed(boolean pressed) {
        Log.d(TAG, "setPressed() called with: pressed = [" + pressed + "]");
        super.setPressed(pressed);
    }

    @Override
    protected void dispatchSetPressed(boolean pressed) {
        Log.d(TAG, "dispatchSetPressed() called with: pressed = [" + pressed + "]");
        super.dispatchSetPressed(pressed);
    }

    @Override
    public boolean isPressed() {
        Log.d(TAG, "isPressed() called");
        return super.isPressed();
    }

    @Override
    public boolean isSaveEnabled() {
        Log.d(TAG, "isSaveEnabled() called");
        return super.isSaveEnabled();
    }

    @Override
    public void setSaveEnabled(boolean enabled) {
        Log.d(TAG, "setSaveEnabled() called with: enabled = [" + enabled + "]");
        super.setSaveEnabled(enabled);
    }

    @Override
    public boolean getFilterTouchesWhenObscured() {
        Log.d(TAG, "getFilterTouchesWhenObscured() called");
        return super.getFilterTouchesWhenObscured();
    }

    @Override
    public void setFilterTouchesWhenObscured(boolean enabled) {
        Log.d(TAG, "setFilterTouchesWhenObscured() called with: enabled = [" + enabled + "]");
        super.setFilterTouchesWhenObscured(enabled);
    }

    @Override
    public boolean isSaveFromParentEnabled() {
        Log.d(TAG, "isSaveFromParentEnabled() called");
        return super.isSaveFromParentEnabled();
    }

    @Override
    public void setSaveFromParentEnabled(boolean enabled) {
        Log.d(TAG, "setSaveFromParentEnabled() called with: enabled = [" + enabled + "]");
        super.setSaveFromParentEnabled(enabled);
    }

    @Override
    public int getFocusable() {
        Log.d(TAG, "getFocusable() called");
        return super.getFocusable();
    }

    @Override
    public boolean isScreenReaderFocusable() {
        Log.d(TAG, "isScreenReaderFocusable() called");
        return super.isScreenReaderFocusable();
    }

    @Override
    public void setScreenReaderFocusable(boolean screenReaderFocusable) {
        Log.d(TAG, "setScreenReaderFocusable() called with: screenReaderFocusable = [" + screenReaderFocusable + "]");
        super.setScreenReaderFocusable(screenReaderFocusable);
    }

    @Override
    public boolean isAccessibilityHeading() {
        Log.d(TAG, "isAccessibilityHeading() called");
        return super.isAccessibilityHeading();
    }

    @Override
    public void setAccessibilityHeading(boolean isHeading) {
        Log.d(TAG, "setAccessibilityHeading() called with: isHeading = [" + isHeading + "]");
        super.setAccessibilityHeading(isHeading);
    }

    @Override
    public View focusSearch(int direction) {
        Log.d(TAG, "focusSearch() called with: direction = [" + direction + "]");
        return super.focusSearch(direction);
    }

    @Override
    public void setKeyboardNavigationCluster(boolean isCluster) {
        Log.d(TAG, "setKeyboardNavigationCluster() called with: isCluster = [" + isCluster + "]");
        super.setKeyboardNavigationCluster(isCluster);
    }

    @Override
    public void setFocusedByDefault(boolean isFocusedByDefault) {
        Log.d(TAG, "setFocusedByDefault() called with: isFocusedByDefault = [" + isFocusedByDefault + "]");
        super.setFocusedByDefault(isFocusedByDefault);
    }

    @Override
    public View keyboardNavigationClusterSearch(View currentCluster, int direction) {
        Log.d(TAG, "keyboardNavigationClusterSearch() called with: currentCluster = [" + currentCluster + "], direction = [" + direction + "]");
        return super.keyboardNavigationClusterSearch(currentCluster, direction);
    }

    @Override
    public boolean dispatchUnhandledMove(View focused, int direction) {
        Log.d(TAG, "dispatchUnhandledMove() called with: focused = [" + focused + "], direction = [" + direction + "]");
        return super.dispatchUnhandledMove(focused, direction);
    }

    @Override
    public void setDefaultFocusHighlightEnabled(boolean defaultFocusHighlightEnabled) {
        Log.d(TAG, "setDefaultFocusHighlightEnabled() called with: defaultFocusHighlightEnabled = [" + defaultFocusHighlightEnabled + "]");
        super.setDefaultFocusHighlightEnabled(defaultFocusHighlightEnabled);
    }

    @Override
    public ArrayList<View> getFocusables(int direction) {
        Log.d(TAG, "getFocusables() called with: direction = [" + direction + "]");
        return super.getFocusables(direction);
    }

    @Override
    public void addFocusables(ArrayList<View> views, int direction) {
        Log.d(TAG, "addFocusables() called with: views = [" + views + "], direction = [" + direction + "]");
        super.addFocusables(views, direction);
    }

    @Override
    public void addFocusables(ArrayList<View> views, int direction, int focusableMode) {
        Log.d(TAG, "addFocusables() called with: views = [" + views + "], direction = [" + direction + "], focusableMode = [" + focusableMode + "]");
        super.addFocusables(views, direction, focusableMode);
    }

    @Override
    public void addKeyboardNavigationClusters(@androidx.annotation.NonNull Collection<View> views, int direction) {
        Log.d(TAG, "addKeyboardNavigationClusters() called with: views = [" + views + "], direction = [" + direction + "]");
        super.addKeyboardNavigationClusters(views, direction);
    }

    @Override
    public void findViewsWithText(ArrayList<View> outViews, CharSequence searched, int flags) {
        Log.d(TAG, "findViewsWithText() called with: outViews = [" + outViews + "], searched = [" + searched + "], flags = [" + flags + "]");
        super.findViewsWithText(outViews, searched, flags);
    }

    @Override
    public ArrayList<View> getTouchables() {
        Log.d(TAG, "getTouchables() called");
        return super.getTouchables();
    }

    @Override
    public void addTouchables(ArrayList<View> views) {
        Log.d(TAG, "addTouchables() called with: views = [" + views + "]");
        super.addTouchables(views);
    }

    @Override
    public boolean isAccessibilityFocused() {
        Log.d(TAG, "isAccessibilityFocused() called");
        return super.isAccessibilityFocused();
    }

    @Override
    public boolean restoreDefaultFocus() {
        Log.d(TAG, "restoreDefaultFocus() called");
        return super.restoreDefaultFocus();
    }

    @Override
    public boolean requestFocus(int direction, Rect previouslyFocusedRect) {
        Log.d(TAG, "requestFocus() called with: direction = [" + direction + "], previouslyFocusedRect = [" + previouslyFocusedRect + "]");
        return super.requestFocus(direction, previouslyFocusedRect);
    }

    @Override
    public int getImportantForAccessibility() {
        Log.d(TAG, "getImportantForAccessibility() called");
        return super.getImportantForAccessibility();
    }

    @Override
    public void setAccessibilityLiveRegion(int mode) {
        Log.d(TAG, "setAccessibilityLiveRegion() called with: mode = [" + mode + "]");
        super.setAccessibilityLiveRegion(mode);
    }

    @Override
    public int getAccessibilityLiveRegion() {
        Log.d(TAG, "getAccessibilityLiveRegion() called");
        return super.getAccessibilityLiveRegion();
    }

    @Override
    public void setImportantForAccessibility(int mode) {
        Log.d(TAG, "setImportantForAccessibility() called with: mode = [" + mode + "]");
        super.setImportantForAccessibility(mode);
    }

    @Override
    public boolean isImportantForAccessibility() {
        Log.d(TAG, "isImportantForAccessibility() called");
        return super.isImportantForAccessibility();
    }

    @Override
    public ViewParent getParentForAccessibility() {
        Log.d(TAG, "getParentForAccessibility() called");
        return super.getParentForAccessibility();
    }

    @Override
    public void addChildrenForAccessibility(ArrayList<View> outChildren) {
        Log.d(TAG, "addChildrenForAccessibility() called with: outChildren = [" + outChildren + "]");
        super.addChildrenForAccessibility(outChildren);
    }

    @Override
    public boolean dispatchNestedPrePerformAccessibilityAction(int action, Bundle arguments) {
        Log.d(TAG, "dispatchNestedPrePerformAccessibilityAction() called with: action = [" + action + "], arguments = [" + arguments + "]");
        return super.dispatchNestedPrePerformAccessibilityAction(action, arguments);
    }

    @Override
    public boolean performAccessibilityAction(int action, Bundle arguments) {
        Log.d(TAG, "performAccessibilityAction() called with: action = [" + action + "], arguments = [" + arguments + "]");
        return super.performAccessibilityAction(action, arguments);
    }

    @Override
    public void dispatchStartTemporaryDetach() {
        Log.d(TAG, "dispatchStartTemporaryDetach() called");
        super.dispatchStartTemporaryDetach();
    }

    @Override
    public void onStartTemporaryDetach() {
        Log.d(TAG, "onStartTemporaryDetach() called");
        super.onStartTemporaryDetach();
    }

    @Override
    public void dispatchFinishTemporaryDetach() {
        Log.d(TAG, "dispatchFinishTemporaryDetach() called");
        super.dispatchFinishTemporaryDetach();
    }

    @Override
    public void onFinishTemporaryDetach() {
        Log.d(TAG, "onFinishTemporaryDetach() called");
        super.onFinishTemporaryDetach();
    }

    @Override
    public KeyEvent.DispatcherState getKeyDispatcherState() {
        Log.d(TAG, "getKeyDispatcherState() called");
        return super.getKeyDispatcherState();
    }

    @Override
    public boolean dispatchKeyEventPreIme(KeyEvent event) {
        Log.d(TAG, "dispatchKeyEventPreIme() called with: event = [" + event + "]");
        return super.dispatchKeyEventPreIme(event);
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        Log.d(TAG, "dispatchKeyEvent() called with: event = [" + event + "]");
        return super.dispatchKeyEvent(event);
    }

    @Override
    public boolean dispatchKeyShortcutEvent(KeyEvent event) {
        Log.d(TAG, "dispatchKeyShortcutEvent() called with: event = [" + event + "]");
        return super.dispatchKeyShortcutEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.d(TAG, "dispatchTouchEvent() called with: event = [" + event + "]");
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onFilterTouchEventForSecurity(MotionEvent event) {
        Log.d(TAG, "onFilterTouchEventForSecurity() called with: event = [" + event + "]");
        return super.onFilterTouchEventForSecurity(event);
    }

    @Override
    public boolean dispatchTrackballEvent(MotionEvent event) {
        Log.d(TAG, "dispatchTrackballEvent() called with: event = [" + event + "]");
        return super.dispatchTrackballEvent(event);
    }

    @Override
    public boolean dispatchCapturedPointerEvent(MotionEvent event) {
        Log.d(TAG, "dispatchCapturedPointerEvent() called with: event = [" + event + "]");
        return super.dispatchCapturedPointerEvent(event);
    }

    @Override
    public boolean dispatchGenericMotionEvent(MotionEvent event) {
        Log.d(TAG, "dispatchGenericMotionEvent() called with: event = [" + event + "]");
        return super.dispatchGenericMotionEvent(event);
    }

    @Override
    protected boolean dispatchHoverEvent(MotionEvent event) {
        Log.d(TAG, "dispatchHoverEvent() called with: event = [" + event + "]");
        return super.dispatchHoverEvent(event);
    }

    @Override
    protected boolean dispatchGenericPointerEvent(MotionEvent event) {
        Log.d(TAG, "dispatchGenericPointerEvent() called with: event = [" + event + "]");
        return super.dispatchGenericPointerEvent(event);
    }

    @Override
    protected boolean dispatchGenericFocusedEvent(MotionEvent event) {
        Log.d(TAG, "dispatchGenericFocusedEvent() called with: event = [" + event + "]");
        return super.dispatchGenericFocusedEvent(event);
    }

    @Override
    public void dispatchWindowFocusChanged(boolean hasFocus) {
        Log.d(TAG, "dispatchWindowFocusChanged() called with: hasFocus = [" + hasFocus + "]");
        super.dispatchWindowFocusChanged(hasFocus);
    }

    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        Log.d(TAG, "onWindowFocusChanged() called with: hasWindowFocus = [" + hasWindowFocus + "]");
        super.onWindowFocusChanged(hasWindowFocus);
    }

    @Override
    public boolean hasWindowFocus() {
        Log.d(TAG, "hasWindowFocus() called");
        return super.hasWindowFocus();
    }

    @Override
    protected void dispatchVisibilityChanged(@androidx.annotation.NonNull View changedView, int visibility) {
        Log.d(TAG, "dispatchVisibilityChanged() called with: changedView = [" + changedView + "], visibility = [" + visibility + "]");
        super.dispatchVisibilityChanged(changedView, visibility);
    }

    @Override
    protected void onVisibilityChanged(@androidx.annotation.NonNull View changedView, int visibility) {
        Log.d(TAG, "onVisibilityChanged() called with: changedView = [" + changedView + "], visibility = [" + visibility + "]");
        super.onVisibilityChanged(changedView, visibility);
    }

    @Override
    public void dispatchDisplayHint(int hint) {
        Log.d(TAG, "dispatchDisplayHint() called with: hint = [" + hint + "]");
        super.dispatchDisplayHint(hint);
    }

    @Override
    protected void onDisplayHint(int hint) {
        Log.d(TAG, "onDisplayHint() called with: hint = [" + hint + "]");
        super.onDisplayHint(hint);
    }

    @Override
    public void dispatchWindowVisibilityChanged(int visibility) {
        Log.d(TAG, "dispatchWindowVisibilityChanged() called with: visibility = [" + visibility + "]");
        super.dispatchWindowVisibilityChanged(visibility);
    }

    @Override
    protected void onWindowVisibilityChanged(int visibility) {
        Log.d(TAG, "onWindowVisibilityChanged() called with: visibility = [" + visibility + "]");
        super.onWindowVisibilityChanged(visibility);
    }

    @Override
    public void onVisibilityAggregated(boolean isVisible) {
        Log.d(TAG, "onVisibilityAggregated() called with: isVisible = [" + isVisible + "]");
        super.onVisibilityAggregated(isVisible);
    }

    @Override
    public int getWindowVisibility() {
        Log.d(TAG, "getWindowVisibility() called");
        return super.getWindowVisibility();
    }

    @Override
    public void getWindowVisibleDisplayFrame(Rect outRect) {
        Log.d(TAG, "getWindowVisibleDisplayFrame() called with: outRect = [" + outRect + "]");
        super.getWindowVisibleDisplayFrame(outRect);
    }

    @Override
    public void dispatchConfigurationChanged(Configuration newConfig) {
        Log.d(TAG, "dispatchConfigurationChanged() called with: newConfig = [" + newConfig + "]");
        super.dispatchConfigurationChanged(newConfig);
    }

    @Override
    protected void onConfigurationChanged(Configuration newConfig) {
        Log.d(TAG, "onConfigurationChanged() called with: newConfig = [" + newConfig + "]");
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean isInTouchMode() {
        Log.d(TAG, "isInTouchMode() called");
        return super.isInTouchMode();
    }

    @Override
    public boolean onKeyPreIme(int keyCode, KeyEvent event) {
        Log.d(TAG, "onKeyPreIme() called with: keyCode = [" + keyCode + "], event = [" + event + "]");
        return super.onKeyPreIme(keyCode, event);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Log.d(TAG, "onKeyDown() called with: keyCode = [" + keyCode + "], event = [" + event + "]");
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        Log.d(TAG, "onKeyLongPress() called with: keyCode = [" + keyCode + "], event = [" + event + "]");
        return super.onKeyLongPress(keyCode, event);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        Log.d(TAG, "onKeyUp() called with: keyCode = [" + keyCode + "], event = [" + event + "]");
        return super.onKeyUp(keyCode, event);
    }

    @Override
    public boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event) {
        Log.d(TAG, "onKeyMultiple() called with: keyCode = [" + keyCode + "], repeatCount = [" + repeatCount + "], event = [" + event + "]");
        return super.onKeyMultiple(keyCode, repeatCount, event);
    }

    @Override
    public boolean onKeyShortcut(int keyCode, KeyEvent event) {
        Log.d(TAG, "onKeyShortcut() called with: keyCode = [" + keyCode + "], event = [" + event + "]");
        return super.onKeyShortcut(keyCode, event);
    }

    @Override
    public boolean onCheckIsTextEditor() {
        Log.d(TAG, "onCheckIsTextEditor() called");
        return super.onCheckIsTextEditor();
    }

    @Override
    public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
        Log.d(TAG, "onCreateInputConnection() called with: outAttrs = [" + outAttrs + "]");
        return super.onCreateInputConnection(outAttrs);
    }

    @Override
    public boolean checkInputConnectionProxy(View view) {
        Log.d(TAG, "checkInputConnectionProxy() called with: view = [" + view + "]");
        return super.checkInputConnectionProxy(view);
    }

    @Override
    public void createContextMenu(ContextMenu menu) {
        Log.d(TAG, "createContextMenu() called with: menu = [" + menu + "]");
        super.createContextMenu(menu);
    }

    @Override
    protected ContextMenu.ContextMenuInfo getContextMenuInfo() {
        Log.d(TAG, "getContextMenuInfo() called");
        return super.getContextMenuInfo();
    }

    @Override
    protected void onCreateContextMenu(ContextMenu menu) {
        Log.d(TAG, "onCreateContextMenu() called with: menu = [" + menu + "]");
        super.onCreateContextMenu(menu);
    }

    @Override
    public boolean onTrackballEvent(MotionEvent event) {
        Log.d(TAG, "onTrackballEvent() called with: event = [" + event + "]");
        return super.onTrackballEvent(event);
    }

    @Override
    public boolean onGenericMotionEvent(MotionEvent event) {
        Log.d(TAG, "onGenericMotionEvent() called with: event = [" + event + "]");
        return super.onGenericMotionEvent(event);
    }

    @Override
    public boolean onHoverEvent(MotionEvent event) {
        Log.d(TAG, "onHoverEvent() called with: event = [" + event + "]");
        return super.onHoverEvent(event);
    }

    @Override
    public boolean isHovered() {
        Log.d(TAG, "isHovered() called");
        return super.isHovered();
    }

    @Override
    public void setHovered(boolean hovered) {
        Log.d(TAG, "setHovered() called with: hovered = [" + hovered + "]");
        super.setHovered(hovered);
    }

    @Override
    public void onHoverChanged(boolean hovered) {
        Log.d(TAG, "onHoverChanged() called with: hovered = [" + hovered + "]");
        super.onHoverChanged(hovered);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(TAG, "onTouchEvent() called with: event = [" + event + "]");
        return super.onTouchEvent(event);
    }

    @Override
    public void cancelLongPress() {
        Log.d(TAG, "cancelLongPress() called");
        super.cancelLongPress();
    }

    @Override
    public void setTouchDelegate(TouchDelegate delegate) {
        Log.d(TAG, "setTouchDelegate() called with: delegate = [" + delegate + "]");
        super.setTouchDelegate(delegate);
    }

    @Override
    public TouchDelegate getTouchDelegate() {
        Log.d(TAG, "getTouchDelegate() called");
        return super.getTouchDelegate();
    }

    @Override
    public void bringToFront() {
        Log.d(TAG, "bringToFront() called");
        super.bringToFront();
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        Log.d(TAG, "onScrollChanged() called with: l = [" + l + "], t = [" + t + "], oldl = [" + oldl + "], oldt = [" + oldt + "]");
        super.onScrollChanged(l, t, oldl, oldt);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        Log.d(TAG, "onSizeChanged() called with: w = [" + w + "], h = [" + h + "], oldw = [" + oldw + "], oldh = [" + oldh + "]");
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        Log.d(TAG, "dispatchDraw() called with: canvas = [" + canvas + "]");
        super.dispatchDraw(canvas);
    }

    @Override
    public void setScrollX(int value) {
        Log.d(TAG, "setScrollX() called with: value = [" + value + "]");
        super.setScrollX(value);
    }

    @Override
    public void setScrollY(int value) {
        Log.d(TAG, "setScrollY() called with: value = [" + value + "]");
        super.setScrollY(value);
    }

    @Override
    public void getDrawingRect(Rect outRect) {
        Log.d(TAG, "getDrawingRect() called with: outRect = [" + outRect + "]");
        super.getDrawingRect(outRect);
    }

    @Override
    public Matrix getMatrix() {
        Log.d(TAG, "getMatrix() called");
        return super.getMatrix();
    }

    @Override
    public float getCameraDistance() {
        Log.d(TAG, "getCameraDistance() called");
        return super.getCameraDistance();
    }

    @Override
    public void setCameraDistance(float distance) {
        Log.d(TAG, "setCameraDistance() called with: distance = [" + distance + "]");
        super.setCameraDistance(distance);
    }

    @Override
    public float getRotation() {
        Log.d(TAG, "getRotation() called");
        return super.getRotation();
    }

    @Override
    public void setRotation(float rotation) {
        Log.d(TAG, "setRotation() called with: rotation = [" + rotation + "]");
        super.setRotation(rotation);
    }

    @Override
    public float getRotationY() {
        Log.d(TAG, "getRotationY() called");
        return super.getRotationY();
    }

    @Override
    public void setRotationY(float rotationY) {
        Log.d(TAG, "setRotationY() called with: rotationY = [" + rotationY + "]");
        super.setRotationY(rotationY);
    }

    @Override
    public float getRotationX() {
        Log.d(TAG, "getRotationX() called");
        return super.getRotationX();
    }

    @Override
    public void setRotationX(float rotationX) {
        Log.d(TAG, "setRotationX() called with: rotationX = [" + rotationX + "]");
        super.setRotationX(rotationX);
    }

    @Override
    public float getScaleX() {
        Log.d(TAG, "getScaleX() called");
        return super.getScaleX();
    }

    @Override
    public void setScaleX(float scaleX) {
        Log.d(TAG, "setScaleX() called with: scaleX = [" + scaleX + "]");
        super.setScaleX(scaleX);
    }

    @Override
    public float getScaleY() {
        Log.d(TAG, "getScaleY() called");
        return super.getScaleY();
    }

    @Override
    public void setScaleY(float scaleY) {
        Log.d(TAG, "setScaleY() called with: scaleY = [" + scaleY + "]");
        super.setScaleY(scaleY);
    }

    @Override
    public float getPivotX() {
        Log.d(TAG, "getPivotX() called");
        return super.getPivotX();
    }

    @Override
    public void setPivotX(float pivotX) {
        Log.d(TAG, "setPivotX() called with: pivotX = [" + pivotX + "]");
        super.setPivotX(pivotX);
    }

    @Override
    public float getPivotY() {
        Log.d(TAG, "getPivotY() called");
        return super.getPivotY();
    }

    @Override
    public void setPivotY(float pivotY) {
        Log.d(TAG, "setPivotY() called with: pivotY = [" + pivotY + "]");
        super.setPivotY(pivotY);
    }

    @Override
    public boolean isPivotSet() {
        Log.d(TAG, "isPivotSet() called");
        return super.isPivotSet();
    }

    @Override
    public void resetPivot() {
        Log.d(TAG, "resetPivot() called");
        super.resetPivot();
    }

    @Override
    public float getAlpha() {
        Log.d(TAG, "getAlpha() called");
        return super.getAlpha();
    }

    @Override
    public void forceHasOverlappingRendering(boolean hasOverlappingRendering) {
        Log.d(TAG, "forceHasOverlappingRendering() called with: hasOverlappingRendering = [" + hasOverlappingRendering + "]");
        super.forceHasOverlappingRendering(hasOverlappingRendering);
    }

    @Override
    public boolean hasOverlappingRendering() {
        Log.d(TAG, "hasOverlappingRendering() called");
        return super.hasOverlappingRendering();
    }

    @Override
    public void setAlpha(float alpha) {
        Log.d(TAG, "setAlpha() called with: alpha = [" + alpha + "]");
        super.setAlpha(alpha);
    }

    @Override
    public boolean isDirty() {
        Log.d(TAG, "isDirty() called");
        return super.isDirty();
    }

    @Override
    public float getX() {
        Log.d(TAG, "getX() called");
        return super.getX();
    }

    @Override
    public void setX(float x) {
        Log.d(TAG, "setX() called with: x = [" + x + "]");
        super.setX(x);
    }

    @Override
    public float getY() {
        Log.d(TAG, "getY() called");
        return super.getY();
    }

    @Override
    public void setY(float y) {
        Log.d(TAG, "setY() called with: y = [" + y + "]");
        super.setY(y);
    }

    @Override
    public float getZ() {
        Log.d(TAG, "getZ() called");
        return super.getZ();
    }

    @Override
    public void setZ(float z) {
        Log.d(TAG, "setZ() called with: z = [" + z + "]");
        super.setZ(z);
    }

    @Override
    public float getElevation() {
        Log.d(TAG, "getElevation() called");
        return super.getElevation();
    }

    @Override
    public void setElevation(float elevation) {
        Log.d(TAG, "setElevation() called with: elevation = [" + elevation + "]");
        super.setElevation(elevation);
    }

    @Override
    public float getTranslationX() {
        Log.d(TAG, "getTranslationX() called");
        return super.getTranslationX();
    }

    @Override
    public void setTranslationX(float translationX) {
        Log.d(TAG, "setTranslationX() called with: translationX = [" + translationX + "]");
        super.setTranslationX(translationX);
    }

    @Override
    public float getTranslationY() {
        Log.d(TAG, "getTranslationY() called");
        return super.getTranslationY();
    }

    @Override
    public void setTranslationY(float translationY) {
        Log.d(TAG, "setTranslationY() called with: translationY = [" + translationY + "]");
        super.setTranslationY(translationY);
    }

    @Override
    public float getTranslationZ() {
        Log.d(TAG, "getTranslationZ() called");
        return super.getTranslationZ();
    }

    @Override
    public void setTranslationZ(float translationZ) {
        Log.d(TAG, "setTranslationZ() called with: translationZ = [" + translationZ + "]");
        super.setTranslationZ(translationZ);
    }

    @Override
    public StateListAnimator getStateListAnimator() {
        Log.d(TAG, "getStateListAnimator() called");
        return super.getStateListAnimator();
    }

    @Override
    public void setStateListAnimator(StateListAnimator stateListAnimator) {
        Log.d(TAG, "setStateListAnimator() called with: stateListAnimator = [" + stateListAnimator + "]");
        super.setStateListAnimator(stateListAnimator);
    }

    @Override
    public void setClipToOutline(boolean clipToOutline) {
        Log.d(TAG, "setClipToOutline() called with: clipToOutline = [" + clipToOutline + "]");
        super.setClipToOutline(clipToOutline);
    }

    @Override
    public void setOutlineProvider(ViewOutlineProvider provider) {
        Log.d(TAG, "setOutlineProvider() called with: provider = [" + provider + "]");
        super.setOutlineProvider(provider);
    }

    @Override
    public ViewOutlineProvider getOutlineProvider() {
        Log.d(TAG, "getOutlineProvider() called");
        return super.getOutlineProvider();
    }

    @Override
    public void invalidateOutline() {
        Log.d(TAG, "invalidateOutline() called");
        super.invalidateOutline();
    }

    @Override
    public void setOutlineSpotShadowColor(int color) {
        Log.d(TAG, "setOutlineSpotShadowColor() called with: color = [" + color + "]");
        super.setOutlineSpotShadowColor(color);
    }

    @Override
    public int getOutlineSpotShadowColor() {
        Log.d(TAG, "getOutlineSpotShadowColor() called");
        return super.getOutlineSpotShadowColor();
    }

    @Override
    public void setOutlineAmbientShadowColor(int color) {
        Log.d(TAG, "setOutlineAmbientShadowColor() called with: color = [" + color + "]");
        super.setOutlineAmbientShadowColor(color);
    }

    @Override
    public int getOutlineAmbientShadowColor() {
        Log.d(TAG, "getOutlineAmbientShadowColor() called");
        return super.getOutlineAmbientShadowColor();
    }

    @Override
    public void getHitRect(Rect outRect) {
        Log.d(TAG, "getHitRect() called with: outRect = [" + outRect + "]");
        super.getHitRect(outRect);
    }

    @Override
    public void getFocusedRect(Rect r) {
        Log.d(TAG, "getFocusedRect() called with: r = [" + r + "]");
        super.getFocusedRect(r);
    }

    @Override
    public boolean getGlobalVisibleRect(Rect r, Point globalOffset) {
        Log.d(TAG, "getGlobalVisibleRect() called with: r = [" + r + "], globalOffset = [" + globalOffset + "]");
        return super.getGlobalVisibleRect(r, globalOffset);
    }

    @Override
    public void offsetTopAndBottom(int offset) {
        Log.d(TAG, "offsetTopAndBottom() called with: offset = [" + offset + "]");
        super.offsetTopAndBottom(offset);
    }

    @Override
    public void offsetLeftAndRight(int offset) {
        Log.d(TAG, "offsetLeftAndRight() called with: offset = [" + offset + "]");
        super.offsetLeftAndRight(offset);
    }

    @Override
    public ViewGroup.LayoutParams getLayoutParams() {
        Log.d(TAG, "getLayoutParams() called");
        return super.getLayoutParams();
    }

    @Override
    public void setLayoutParams(ViewGroup.LayoutParams params) {
        Log.d(TAG, "setLayoutParams() called with: params = [" + params + "]");
        super.setLayoutParams(params);
    }

    @Override
    public void scrollTo(int x, int y) {
        Log.d(TAG, "scrollTo() called with: x = [" + x + "], y = [" + y + "]");
        super.scrollTo(x, y);
    }

    @Override
    public void scrollBy(int x, int y) {
        Log.d(TAG, "scrollBy() called with: x = [" + x + "], y = [" + y + "]");
        super.scrollBy(x, y);
    }

    @Override
    protected boolean awakenScrollBars() {
        Log.d(TAG, "awakenScrollBars() called");
        return super.awakenScrollBars();
    }

    @Override
    protected boolean awakenScrollBars(int startDelay) {
        Log.d(TAG, "awakenScrollBars() called with: startDelay = [" + startDelay + "]");
        return super.awakenScrollBars(startDelay);
    }

    @Override
    protected boolean awakenScrollBars(int startDelay, boolean invalidate) {
        Log.d(TAG, "awakenScrollBars() called with: startDelay = [" + startDelay + "], invalidate = [" + invalidate + "]");
        return super.awakenScrollBars(startDelay, invalidate);
    }

    @Override
    public void invalidate(Rect dirty) {
        Log.d(TAG, "invalidate() called with: dirty = [" + dirty + "]");
        super.invalidate(dirty);
    }

    @Override
    public void invalidate(int l, int t, int r, int b) {
        Log.d(TAG, "invalidate() called with: l = [" + l + "], t = [" + t + "], r = [" + r + "], b = [" + b + "]");
        super.invalidate(l, t, r, b);
    }

    @Override
    public void invalidate() {
        Log.d(TAG, "invalidate() called");
        super.invalidate();
    }

    @Override
    public boolean isOpaque() {
        Log.d(TAG, "isOpaque() called");
        return super.isOpaque();
    }

    @Override
    public Handler getHandler() {
        Log.d(TAG, "getHandler() called");
        return super.getHandler();
    }

    @Override
    public boolean post(Runnable action) {
        Log.d(TAG, "post() called with: action = [" + action + "]");
        return super.post(action);
    }

    @Override
    public boolean postDelayed(Runnable action, long delayMillis) {
        Log.d(TAG, "postDelayed() called with: action = [" + action + "], delayMillis = [" + delayMillis + "]");
        return super.postDelayed(action, delayMillis);
    }

    @Override
    public void postOnAnimation(Runnable action) {
        Log.d(TAG, "postOnAnimation() called with: action = [" + action + "]");
        super.postOnAnimation(action);
    }

    @Override
    public void postOnAnimationDelayed(Runnable action, long delayMillis) {
        Log.d(TAG, "postOnAnimationDelayed() called with: action = [" + action + "], delayMillis = [" + delayMillis + "]");
        super.postOnAnimationDelayed(action, delayMillis);
    }

    @Override
    public boolean removeCallbacks(Runnable action) {
        Log.d(TAG, "removeCallbacks() called with: action = [" + action + "]");
        return super.removeCallbacks(action);
    }

    @Override
    public void postInvalidate() {
        Log.d(TAG, "postInvalidate() called");
        super.postInvalidate();
    }

    @Override
    public void postInvalidate(int left, int top, int right, int bottom) {
        Log.d(TAG, "postInvalidate() called with: left = [" + left + "], top = [" + top + "], right = [" + right + "], bottom = [" + bottom + "]");
        super.postInvalidate(left, top, right, bottom);
    }

    @Override
    public void postInvalidateDelayed(long delayMilliseconds) {
        Log.d(TAG, "postInvalidateDelayed() called with: delayMilliseconds = [" + delayMilliseconds + "]");
        super.postInvalidateDelayed(delayMilliseconds);
    }

    @Override
    public void postInvalidateDelayed(long delayMilliseconds, int left, int top, int right, int bottom) {
        Log.d(TAG, "postInvalidateDelayed() called with: delayMilliseconds = [" + delayMilliseconds + "], left = [" + left + "], top = [" + top + "], right = [" + right + "], bottom = [" + bottom + "]");
        super.postInvalidateDelayed(delayMilliseconds, left, top, right, bottom);
    }

    @Override
    public void postInvalidateOnAnimation() {
        Log.d(TAG, "postInvalidateOnAnimation() called");
        super.postInvalidateOnAnimation();
    }

    @Override
    public void postInvalidateOnAnimation(int left, int top, int right, int bottom) {
        Log.d(TAG, "postInvalidateOnAnimation() called with: left = [" + left + "], top = [" + top + "], right = [" + right + "], bottom = [" + bottom + "]");
        super.postInvalidateOnAnimation(left, top, right, bottom);
    }

    @Override
    public void computeScroll() {
        Log.d(TAG, "computeScroll() called");
        super.computeScroll();
    }

    @Override
    public boolean isHorizontalFadingEdgeEnabled() {
        Log.d(TAG, "isHorizontalFadingEdgeEnabled() called");
        return super.isHorizontalFadingEdgeEnabled();
    }

    @Override
    public void setHorizontalFadingEdgeEnabled(boolean horizontalFadingEdgeEnabled) {
        Log.d(TAG, "setHorizontalFadingEdgeEnabled() called with: horizontalFadingEdgeEnabled = [" + horizontalFadingEdgeEnabled + "]");
        super.setHorizontalFadingEdgeEnabled(horizontalFadingEdgeEnabled);
    }

    @Override
    public boolean isVerticalFadingEdgeEnabled() {
        Log.d(TAG, "isVerticalFadingEdgeEnabled() called");
        return super.isVerticalFadingEdgeEnabled();
    }

    @Override
    public void setVerticalFadingEdgeEnabled(boolean verticalFadingEdgeEnabled) {
        Log.d(TAG, "setVerticalFadingEdgeEnabled() called with: verticalFadingEdgeEnabled = [" + verticalFadingEdgeEnabled + "]");
        super.setVerticalFadingEdgeEnabled(verticalFadingEdgeEnabled);
    }

    @Override
    protected float getTopFadingEdgeStrength() {
        Log.d(TAG, "getTopFadingEdgeStrength() called");
        return super.getTopFadingEdgeStrength();
    }

    @Override
    protected float getBottomFadingEdgeStrength() {
        Log.d(TAG, "getBottomFadingEdgeStrength() called");
        return super.getBottomFadingEdgeStrength();
    }

    @Override
    protected float getLeftFadingEdgeStrength() {
        Log.d(TAG, "getLeftFadingEdgeStrength() called");
        return super.getLeftFadingEdgeStrength();
    }

    @Override
    protected float getRightFadingEdgeStrength() {
        Log.d(TAG, "getRightFadingEdgeStrength() called");
        return super.getRightFadingEdgeStrength();
    }

    @Override
    public boolean isHorizontalScrollBarEnabled() {
        Log.d(TAG, "isHorizontalScrollBarEnabled() called");
        return super.isHorizontalScrollBarEnabled();
    }

    @Override
    public void setHorizontalScrollBarEnabled(boolean horizontalScrollBarEnabled) {
        Log.d(TAG, "setHorizontalScrollBarEnabled() called with: horizontalScrollBarEnabled = [" + horizontalScrollBarEnabled + "]");
        super.setHorizontalScrollBarEnabled(horizontalScrollBarEnabled);
    }

    @Override
    public boolean isVerticalScrollBarEnabled() {
        Log.d(TAG, "isVerticalScrollBarEnabled() called");
        return super.isVerticalScrollBarEnabled();
    }

    @Override
    public void setVerticalScrollBarEnabled(boolean verticalScrollBarEnabled) {
        Log.d(TAG, "setVerticalScrollBarEnabled() called with: verticalScrollBarEnabled = [" + verticalScrollBarEnabled + "]");
        super.setVerticalScrollBarEnabled(verticalScrollBarEnabled);
    }

    @Override
    public void setScrollbarFadingEnabled(boolean fadeScrollbars) {
        Log.d(TAG, "setScrollbarFadingEnabled() called with: fadeScrollbars = [" + fadeScrollbars + "]");
        super.setScrollbarFadingEnabled(fadeScrollbars);
    }

    @Override
    public boolean isScrollbarFadingEnabled() {
        Log.d(TAG, "isScrollbarFadingEnabled() called");
        return super.isScrollbarFadingEnabled();
    }

    @Override
    public int getScrollBarDefaultDelayBeforeFade() {
        Log.d(TAG, "getScrollBarDefaultDelayBeforeFade() called");
        return super.getScrollBarDefaultDelayBeforeFade();
    }

    @Override
    public void setScrollBarDefaultDelayBeforeFade(int scrollBarDefaultDelayBeforeFade) {
        Log.d(TAG, "setScrollBarDefaultDelayBeforeFade() called with: scrollBarDefaultDelayBeforeFade = [" + scrollBarDefaultDelayBeforeFade + "]");
        super.setScrollBarDefaultDelayBeforeFade(scrollBarDefaultDelayBeforeFade);
    }

    @Override
    public int getScrollBarFadeDuration() {
        Log.d(TAG, "getScrollBarFadeDuration() called");
        return super.getScrollBarFadeDuration();
    }

    @Override
    public void setScrollBarFadeDuration(int scrollBarFadeDuration) {
        Log.d(TAG, "setScrollBarFadeDuration() called with: scrollBarFadeDuration = [" + scrollBarFadeDuration + "]");
        super.setScrollBarFadeDuration(scrollBarFadeDuration);
    }

    @Override
    public int getScrollBarSize() {
        Log.d(TAG, "getScrollBarSize() called");
        return super.getScrollBarSize();
    }

    @Override
    public void setScrollBarSize(int scrollBarSize) {
        Log.d(TAG, "setScrollBarSize() called with: scrollBarSize = [" + scrollBarSize + "]");
        super.setScrollBarSize(scrollBarSize);
    }

    @Override
    public void setScrollBarStyle(int style) {
        Log.d(TAG, "setScrollBarStyle() called with: style = [" + style + "]");
        super.setScrollBarStyle(style);
    }

    @Override
    public int getScrollBarStyle() {
        Log.d(TAG, "getScrollBarStyle() called");
        return super.getScrollBarStyle();
    }

    @Override
    protected int computeHorizontalScrollRange() {
        Log.d(TAG, "computeHorizontalScrollRange() called");
        return super.computeHorizontalScrollRange();
    }

    @Override
    protected int computeHorizontalScrollOffset() {
        Log.d(TAG, "computeHorizontalScrollOffset() called");
        return super.computeHorizontalScrollOffset();
    }

    @Override
    protected int computeHorizontalScrollExtent() {
        Log.d(TAG, "computeHorizontalScrollExtent() called");
        return super.computeHorizontalScrollExtent();
    }

    @Override
    protected int computeVerticalScrollRange() {
        Log.d(TAG, "computeVerticalScrollRange() called");
        return super.computeVerticalScrollRange();
    }

    @Override
    protected int computeVerticalScrollOffset() {
        Log.d(TAG, "computeVerticalScrollOffset() called");
        return super.computeVerticalScrollOffset();
    }

    @Override
    protected int computeVerticalScrollExtent() {
        Log.d(TAG, "computeVerticalScrollExtent() called");
        return super.computeVerticalScrollExtent();
    }

    @Override
    public boolean canScrollHorizontally(int direction) {
        Log.d(TAG, "canScrollHorizontally() called with: direction = [" + direction + "]");
        return super.canScrollHorizontally(direction);
    }

    @Override
    public boolean canScrollVertically(int direction) {
        Log.d(TAG, "canScrollVertically() called with: direction = [" + direction + "]");
        return super.canScrollVertically(direction);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Log.d(TAG, "onDraw() called with: canvas = [" + canvas + "]");
        super.onDraw(canvas);
    }

    @Override
    protected void onAttachedToWindow() {
        Log.d(TAG, "onAttachedToWindow() called");
        super.onAttachedToWindow();
    }

    @Override
    public void onScreenStateChanged(int screenState) {
        Log.d(TAG, "onScreenStateChanged() called with: screenState = [" + screenState + "]");
        super.onScreenStateChanged(screenState);
    }

    @Override
    public void onRtlPropertiesChanged(int layoutDirection) {
        Log.d(TAG, "onRtlPropertiesChanged() called with: layoutDirection = [" + layoutDirection + "]");
        super.onRtlPropertiesChanged(layoutDirection);
    }

    @Override
    public boolean canResolveLayoutDirection() {
        Log.d(TAG, "canResolveLayoutDirection() called");
        return super.canResolveLayoutDirection();
    }

    @Override
    public boolean isLayoutDirectionResolved() {
        Log.d(TAG, "isLayoutDirectionResolved() called");
        return super.isLayoutDirectionResolved();
    }

    @Override
    protected void onDetachedFromWindow() {
        Log.d(TAG, "onDetachedFromWindow() called");
        super.onDetachedFromWindow();
    }

    @Override
    protected int getWindowAttachCount() {
        Log.d(TAG, "getWindowAttachCount() called");
        return super.getWindowAttachCount();
    }

    @Override
    public IBinder getWindowToken() {
        Log.d(TAG, "getWindowToken() called");
        return super.getWindowToken();
    }

    @Override
    public WindowId getWindowId() {
        Log.d(TAG, "getWindowId() called");
        return super.getWindowId();
    }

    @Override
    public IBinder getApplicationWindowToken() {
        Log.d(TAG, "getApplicationWindowToken() called");
        return super.getApplicationWindowToken();
    }

    @Override
    public Display getDisplay() {
        Log.d(TAG, "getDisplay() called");
        return super.getDisplay();
    }

    @Override
    public void onCancelPendingInputEvents() {
        Log.d(TAG, "onCancelPendingInputEvents() called");
        super.onCancelPendingInputEvents();
    }

    @Override
    public void saveHierarchyState(SparseArray<Parcelable> container) {
        Log.d(TAG, "saveHierarchyState() called with: container = [" + container + "]");
        super.saveHierarchyState(container);
    }

    @Override
    protected void dispatchSaveInstanceState(SparseArray<Parcelable> container) {
        Log.d(TAG, "dispatchSaveInstanceState() called with: container = [" + container + "]");
        super.dispatchSaveInstanceState(container);
    }

    @androidx.annotation.Nullable
    @Override
    protected Parcelable onSaveInstanceState() {
        Log.d(TAG, "onSaveInstanceState() called");
        return super.onSaveInstanceState();
    }

    @Override
    public void restoreHierarchyState(SparseArray<Parcelable> container) {
        Log.d(TAG, "restoreHierarchyState() called with: container = [" + container + "]");
        super.restoreHierarchyState(container);
    }

    @Override
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> container) {
        Log.d(TAG, "dispatchRestoreInstanceState() called with: container = [" + container + "]");
        super.dispatchRestoreInstanceState(container);
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        Log.d(TAG, "onRestoreInstanceState() called with: state = [" + state + "]");
        super.onRestoreInstanceState(state);
    }

    @Override
    public long getDrawingTime() {
        Log.d(TAG, "getDrawingTime() called");
        return super.getDrawingTime();
    }

    @Override
    public void setDuplicateParentStateEnabled(boolean enabled) {
        Log.d(TAG, "setDuplicateParentStateEnabled() called with: enabled = [" + enabled + "]");
        super.setDuplicateParentStateEnabled(enabled);
    }

    @Override
    public boolean isDuplicateParentStateEnabled() {
        Log.d(TAG, "isDuplicateParentStateEnabled() called");
        return super.isDuplicateParentStateEnabled();
    }

    @Override
    public void setLayerType(int layerType, @androidx.annotation.Nullable Paint paint) {
        Log.d(TAG, "setLayerType() called with: layerType = [" + layerType + "], paint = [" + paint + "]");
        super.setLayerType(layerType, paint);
    }

    @Override
    public void setLayerPaint(@androidx.annotation.Nullable Paint paint) {
        Log.d(TAG, "setLayerPaint() called with: paint = [" + paint + "]");
        super.setLayerPaint(paint);
    }

    @Override
    public int getLayerType() {
        Log.d(TAG, "getLayerType() called");
        return super.getLayerType();
    }

    @Override
    public void buildLayer() {
        Log.d(TAG, "buildLayer() called");
        super.buildLayer();
    }

    @Override
    public void setDrawingCacheEnabled(boolean enabled) {
        Log.d(TAG, "setDrawingCacheEnabled() called with: enabled = [" + enabled + "]");
        super.setDrawingCacheEnabled(enabled);
    }

    @Override
    public boolean isDrawingCacheEnabled() {
        Log.d(TAG, "isDrawingCacheEnabled() called");
        return super.isDrawingCacheEnabled();
    }

    @Override
    public Bitmap getDrawingCache() {
        Log.d(TAG, "getDrawingCache() called");
        return super.getDrawingCache();
    }

    @Override
    public Bitmap getDrawingCache(boolean autoScale) {
        Log.d(TAG, "getDrawingCache() called with: autoScale = [" + autoScale + "]");
        return super.getDrawingCache(autoScale);
    }

    @Override
    public void destroyDrawingCache() {
        Log.d(TAG, "destroyDrawingCache() called");
        super.destroyDrawingCache();
    }

    @Override
    public void setDrawingCacheBackgroundColor(int color) {
        Log.d(TAG, "setDrawingCacheBackgroundColor() called with: color = [" + color + "]");
        super.setDrawingCacheBackgroundColor(color);
    }

    @Override
    public int getDrawingCacheBackgroundColor() {
        Log.d(TAG, "getDrawingCacheBackgroundColor() called");
        return super.getDrawingCacheBackgroundColor();
    }

    @Override
    public void buildDrawingCache() {
        Log.d(TAG, "buildDrawingCache() called");
        super.buildDrawingCache();
    }

    @Override
    public void buildDrawingCache(boolean autoScale) {
        Log.d(TAG, "buildDrawingCache() called with: autoScale = [" + autoScale + "]");
        super.buildDrawingCache(autoScale);
    }

    @Override
    public boolean isInEditMode() {
        Log.d(TAG, "isInEditMode() called");
        return super.isInEditMode();
    }

    @Override
    protected boolean isPaddingOffsetRequired() {
        Log.d(TAG, "isPaddingOffsetRequired() called");
        return super.isPaddingOffsetRequired();
    }

    @Override
    protected int getLeftPaddingOffset() {
        Log.d(TAG, "getLeftPaddingOffset() called");
        return super.getLeftPaddingOffset();
    }

    @Override
    protected int getRightPaddingOffset() {
        Log.d(TAG, "getRightPaddingOffset() called");
        return super.getRightPaddingOffset();
    }

    @Override
    protected int getTopPaddingOffset() {
        Log.d(TAG, "getTopPaddingOffset() called");
        return super.getTopPaddingOffset();
    }

    @Override
    protected int getBottomPaddingOffset() {
        Log.d(TAG, "getBottomPaddingOffset() called");
        return super.getBottomPaddingOffset();
    }

    @Override
    public boolean isHardwareAccelerated() {
        Log.d(TAG, "isHardwareAccelerated() called");
        return super.isHardwareAccelerated();
    }

    @Override
    public void setClipBounds(Rect clipBounds) {
        Log.d(TAG, "setClipBounds() called with: clipBounds = [" + clipBounds + "]");
        super.setClipBounds(clipBounds);
    }

    @Override
    public Rect getClipBounds() {
        Log.d(TAG, "getClipBounds() called");
        return super.getClipBounds();
    }

    @Override
    public boolean getClipBounds(Rect outRect) {
        Log.d(TAG, "getClipBounds() called with: outRect = [" + outRect + "]");
        return super.getClipBounds(outRect);
    }

    @Override
    public void draw(Canvas canvas) {
        Log.d(TAG, "draw() called with: canvas = [" + canvas + "]");
        super.draw(canvas);
    }

    @Override
    public ViewOverlay getOverlay() {
        Log.d(TAG, "getOverlay() called");
        return super.getOverlay();
    }

    @Override
    public int getSolidColor() {
        Log.d(TAG, "getSolidColor() called");
        return super.getSolidColor();
    }

    @Override
    public boolean isLayoutRequested() {
        Log.d(TAG, "isLayoutRequested() called");
        return super.isLayoutRequested();
    }

    @Override
    public void layout(int l, int t, int r, int b) {
        Log.d(TAG, "layout() called with: l = [" + l + "], t = [" + t + "], r = [" + r + "], b = [" + b + "]");
        super.layout(l, t, r, b);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        Log.d(TAG, "onLayout() called with: changed = [" + changed + "], left = [" + left + "], top = [" + top + "], right = [" + right + "], bottom = [" + bottom + "]");
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onFinishInflate() {
        Log.d(TAG, "onFinishInflate() called");
        super.onFinishInflate();
    }

    @Override
    public Resources getResources() {
        Log.d(TAG, "getResources() called");
        return super.getResources();
    }

    @Override
    public void invalidateDrawable(@androidx.annotation.NonNull Drawable drawable) {
        Log.d(TAG, "invalidateDrawable() called with: drawable = [" + drawable + "]");
        super.invalidateDrawable(drawable);
    }

    @Override
    public void scheduleDrawable(@androidx.annotation.NonNull Drawable who, @androidx.annotation.NonNull Runnable what, long when) {
        Log.d(TAG, "scheduleDrawable() called with: who = [" + who + "], what = [" + what + "], when = [" + when + "]");
        super.scheduleDrawable(who, what, when);
    }

    @Override
    public void unscheduleDrawable(@androidx.annotation.NonNull Drawable who, @androidx.annotation.NonNull Runnable what) {
        Log.d(TAG, "unscheduleDrawable() called with: who = [" + who + "], what = [" + what + "]");
        super.unscheduleDrawable(who, what);
    }

    @Override
    public void unscheduleDrawable(Drawable who) {
        Log.d(TAG, "unscheduleDrawable() called with: who = [" + who + "]");
        super.unscheduleDrawable(who);
    }

    @Override
    protected boolean verifyDrawable(@androidx.annotation.NonNull Drawable who) {
        Log.d(TAG, "verifyDrawable() called with: who = [" + who + "]");
        return super.verifyDrawable(who);
    }

    @Override
    protected void drawableStateChanged() {
        Log.d(TAG, "drawableStateChanged() called");
        super.drawableStateChanged();
    }

    @Override
    public void drawableHotspotChanged(float x, float y) {
        Log.d(TAG, "drawableHotspotChanged() called with: x = [" + x + "], y = [" + y + "]");
        super.drawableHotspotChanged(x, y);
    }

    @Override
    public void dispatchDrawableHotspotChanged(float x, float y) {
        Log.d(TAG, "dispatchDrawableHotspotChanged() called with: x = [" + x + "], y = [" + y + "]");
        super.dispatchDrawableHotspotChanged(x, y);
    }

    @Override
    public void refreshDrawableState() {
        Log.d(TAG, "refreshDrawableState() called");
        super.refreshDrawableState();
    }

    @Override
    protected int[] onCreateDrawableState(int extraSpace) {
        Log.d(TAG, "onCreateDrawableState() called with: extraSpace = [" + extraSpace + "]");
        return super.onCreateDrawableState(extraSpace);
    }

    @Override
    public void jumpDrawablesToCurrentState() {
        Log.d(TAG, "jumpDrawablesToCurrentState() called");
        super.jumpDrawablesToCurrentState();
    }

    @Override
    public void setBackgroundColor(int color) {
        Log.d(TAG, "setBackgroundColor() called with: color = [" + color + "]");
        super.setBackgroundColor(color);
    }

    @Override
    public void setBackgroundResource(int resid) {
        Log.d(TAG, "setBackgroundResource() called with: resid = [" + resid + "]");
        super.setBackgroundResource(resid);
    }

    @Override
    public void setBackground(Drawable background) {
        Log.d(TAG, "setBackground() called with: background = [" + background + "]");
        super.setBackground(background);
    }

    @Override
    public void setBackgroundDrawable(Drawable background) {
        Log.d(TAG, "setBackgroundDrawable() called with: background = [" + background + "]");
        super.setBackgroundDrawable(background);
    }

    @Override
    public Drawable getBackground() {
        Log.d(TAG, "getBackground() called");
        return super.getBackground();
    }

    @Override
    public void setBackgroundTintList(@androidx.annotation.Nullable ColorStateList tint) {
        Log.d(TAG, "setBackgroundTintList() called with: tint = [" + tint + "]");
        super.setBackgroundTintList(tint);
    }

    @androidx.annotation.Nullable
    @Override
    public ColorStateList getBackgroundTintList() {
        Log.d(TAG, "getBackgroundTintList() called");
        return super.getBackgroundTintList();
    }

    @Override
    public void setBackgroundTintMode(@androidx.annotation.Nullable PorterDuff.Mode tintMode) {
        Log.d(TAG, "setBackgroundTintMode() called with: tintMode = [" + tintMode + "]");
        super.setBackgroundTintMode(tintMode);
    }

    @androidx.annotation.Nullable
    @Override
    public PorterDuff.Mode getBackgroundTintMode() {
        Log.d(TAG, "getBackgroundTintMode() called");
        return super.getBackgroundTintMode();
    }

    @Override
    public Drawable getForeground() {
        Log.d(TAG, "getForeground() called");
        return super.getForeground();
    }

    @Override
    public void setForeground(Drawable foreground) {
        Log.d(TAG, "setForeground() called with: foreground = [" + foreground + "]");
        super.setForeground(foreground);
    }

    @Override
    public int getForegroundGravity() {
        Log.d(TAG, "getForegroundGravity() called");
        return super.getForegroundGravity();
    }

    @Override
    public void setForegroundGravity(int gravity) {
        Log.d(TAG, "setForegroundGravity() called with: gravity = [" + gravity + "]");
        super.setForegroundGravity(gravity);
    }

    @Override
    public void setForegroundTintList(@androidx.annotation.Nullable ColorStateList tint) {
        Log.d(TAG, "setForegroundTintList() called with: tint = [" + tint + "]");
        super.setForegroundTintList(tint);
    }

    @androidx.annotation.Nullable
    @Override
    public ColorStateList getForegroundTintList() {
        Log.d(TAG, "getForegroundTintList() called");
        return super.getForegroundTintList();
    }

    @Override
    public void setForegroundTintMode(@androidx.annotation.Nullable PorterDuff.Mode tintMode) {
        Log.d(TAG, "setForegroundTintMode() called with: tintMode = [" + tintMode + "]");
        super.setForegroundTintMode(tintMode);
    }

    @androidx.annotation.Nullable
    @Override
    public PorterDuff.Mode getForegroundTintMode() {
        Log.d(TAG, "getForegroundTintMode() called");
        return super.getForegroundTintMode();
    }

    @Override
    public void onDrawForeground(Canvas canvas) {
        Log.d(TAG, "onDrawForeground() called with: canvas = [" + canvas + "]");
        super.onDrawForeground(canvas);
    }

    @Override
    public void setPadding(int left, int top, int right, int bottom) {
        Log.d(TAG, "setPadding() called with: left = [" + left + "], top = [" + top + "], right = [" + right + "], bottom = [" + bottom + "]");
        super.setPadding(left, top, right, bottom);
    }

    @Override
    public void setPaddingRelative(int start, int top, int end, int bottom) {
        Log.d(TAG, "setPaddingRelative() called with: start = [" + start + "], top = [" + top + "], end = [" + end + "], bottom = [" + bottom + "]");
        super.setPaddingRelative(start, top, end, bottom);
    }

    @Override
    public int getPaddingTop() {
        Log.d(TAG, "getPaddingTop() called");
        return super.getPaddingTop();
    }

    @Override
    public int getPaddingBottom() {
        Log.d(TAG, "getPaddingBottom() called");
        return super.getPaddingBottom();
    }

    @Override
    public int getPaddingLeft() {
        Log.d(TAG, "getPaddingLeft() called");
        return super.getPaddingLeft();
    }

    @Override
    public int getPaddingStart() {
        Log.d(TAG, "getPaddingStart() called");
        return super.getPaddingStart();
    }

    @Override
    public int getPaddingRight() {
        Log.d(TAG, "getPaddingRight() called");
        return super.getPaddingRight();
    }

    @Override
    public int getPaddingEnd() {
        Log.d(TAG, "getPaddingEnd() called");
        return super.getPaddingEnd();
    }

    @Override
    public boolean isPaddingRelative() {
        Log.d(TAG, "isPaddingRelative() called");
        return super.isPaddingRelative();
    }

    @Override
    public void setSelected(boolean selected) {
        Log.d(TAG, "setSelected() called with: selected = [" + selected + "]");
        super.setSelected(selected);
    }

    @Override
    protected void dispatchSetSelected(boolean selected) {
        Log.d(TAG, "dispatchSetSelected() called with: selected = [" + selected + "]");
        super.dispatchSetSelected(selected);
    }

    @Override
    public boolean isSelected() {
        Log.d(TAG, "isSelected() called");
        return super.isSelected();
    }

    @Override
    public void setActivated(boolean activated) {
        Log.d(TAG, "setActivated() called with: activated = [" + activated + "]");
        super.setActivated(activated);
    }

    @Override
    protected void dispatchSetActivated(boolean activated) {
        Log.d(TAG, "dispatchSetActivated() called with: activated = [" + activated + "]");
        super.dispatchSetActivated(activated);
    }

    @Override
    public boolean isActivated() {
        Log.d(TAG, "isActivated() called");
        return super.isActivated();
    }

    @Override
    public ViewTreeObserver getViewTreeObserver() {
        Log.d(TAG, "getViewTreeObserver() called");
        return super.getViewTreeObserver();
    }

    @Override
    public View getRootView() {
        Log.d(TAG, "getRootView() called");
        return super.getRootView();
    }

    @Override
    public void getLocationOnScreen(int[] outLocation) {
        Log.d(TAG, "getLocationOnScreen() called with: outLocation = [" + outLocation + "]");
        super.getLocationOnScreen(outLocation);
    }

    @Override
    public void getLocationInWindow(int[] outLocation) {
        Log.d(TAG, "getLocationInWindow() called with: outLocation = [" + outLocation + "]");
        super.getLocationInWindow(outLocation);
    }

    @Override
    public void setId(int id) {
        Log.d(TAG, "setId() called with: id = [" + id + "]");
        super.setId(id);
    }

    @Override
    public int getId() {
        Log.d(TAG, "getId() called");
        return super.getId();
    }

    @Override
    public Object getTag() {
        Log.d(TAG, "getTag() called");
        return super.getTag();
    }

    @Override
    public void setTag(Object tag) {
        Log.d(TAG, "setTag() called with: tag = [" + tag + "]");
        super.setTag(tag);
    }

    @Override
    public Object getTag(int key) {
        Log.d(TAG, "getTag() called with: key = [" + key + "]");
        return super.getTag(key);
    }

    @Override
    public void setTag(int key, Object tag) {
        Log.d(TAG, "setTag() called with: key = [" + key + "], tag = [" + tag + "]");
        super.setTag(key, tag);
    }

    @Override
    public int getBaseline() {
        Log.d(TAG, "getBaseline() called");
        return super.getBaseline();
    }

    @Override
    public boolean isInLayout() {
        Log.d(TAG, "isInLayout() called");
        return super.isInLayout();
    }

    @Override
    public void requestLayout() {
        Log.d(TAG, "requestLayout() called");
        super.requestLayout();
    }

    @Override
    public void forceLayout() {
        Log.d(TAG, "forceLayout() called");
        super.forceLayout();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Log.d(TAG, "onMeasure() called with: widthMeasureSpec = [" + MeasureSpec.getSize(widthMeasureSpec) + "], heightMeasureSpec = [" + MeasureSpec.getSize(heightMeasureSpec) + "]");
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        setMeasuredDimension(10000,100);
    }

    @Override
    protected int getSuggestedMinimumHeight() {
        Log.d(TAG, "getSuggestedMinimumHeight() called");
        return super.getSuggestedMinimumHeight();
    }

    @Override
    protected int getSuggestedMinimumWidth() {
        Log.d(TAG, "getSuggestedMinimumWidth() called");
        return super.getSuggestedMinimumWidth();
    }

    @Override
    public int getMinimumHeight() {
        Log.d(TAG, "getMinimumHeight() called");
        return super.getMinimumHeight();
    }

    @Override
    public void setMinimumHeight(int minHeight) {
        Log.d(TAG, "setMinimumHeight() called with: minHeight = [" + minHeight + "]");
        super.setMinimumHeight(minHeight);
    }

    @Override
    public int getMinimumWidth() {
        Log.d(TAG, "getMinimumWidth() called");
        return super.getMinimumWidth();
    }

    @Override
    public void setMinimumWidth(int minWidth) {
        Log.d(TAG, "setMinimumWidth() called with: minWidth = [" + minWidth + "]");
        super.setMinimumWidth(minWidth);
    }

    @Override
    public Animation getAnimation() {
        Log.d(TAG, "getAnimation() called");
        return super.getAnimation();
    }

    @Override
    public void startAnimation(Animation animation) {
        Log.d(TAG, "startAnimation() called with: animation = [" + animation + "]");
        super.startAnimation(animation);
    }

    @Override
    public void clearAnimation() {
        Log.d(TAG, "clearAnimation() called");
        super.clearAnimation();
    }

    @Override
    public void setAnimation(Animation animation) {
        Log.d(TAG, "setAnimation() called with: animation = [" + animation + "]");
        super.setAnimation(animation);
    }

    @Override
    protected void onAnimationStart() {
        Log.d(TAG, "onAnimationStart() called");
        super.onAnimationStart();
    }

    @Override
    protected void onAnimationEnd() {
        Log.d(TAG, "onAnimationEnd() called");
        super.onAnimationEnd();
    }

    @Override
    protected boolean onSetAlpha(int alpha) {
        Log.d(TAG, "onSetAlpha() called with: alpha = [" + alpha + "]");
        return super.onSetAlpha(alpha);
    }

    @Override
    public void playSoundEffect(int soundConstant) {
        Log.d(TAG, "playSoundEffect() called with: soundConstant = [" + soundConstant + "]");
        super.playSoundEffect(soundConstant);
    }

    @Override
    public boolean performHapticFeedback(int feedbackConstant) {
        Log.d(TAG, "performHapticFeedback() called with: feedbackConstant = [" + feedbackConstant + "]");
        return super.performHapticFeedback(feedbackConstant);
    }

    @Override
    public boolean performHapticFeedback(int feedbackConstant, int flags) {
        Log.d(TAG, "performHapticFeedback() called with: feedbackConstant = [" + feedbackConstant + "], flags = [" + flags + "]");
        return super.performHapticFeedback(feedbackConstant, flags);
    }

    @Override
    public void setSystemUiVisibility(int visibility) {
        Log.d(TAG, "setSystemUiVisibility() called with: visibility = [" + visibility + "]");
        super.setSystemUiVisibility(visibility);
    }

    @Override
    public int getSystemUiVisibility() {
        Log.d(TAG, "getSystemUiVisibility() called");
        return super.getSystemUiVisibility();
    }

    @Override
    public int getWindowSystemUiVisibility() {
        Log.d(TAG, "getWindowSystemUiVisibility() called");
        return super.getWindowSystemUiVisibility();
    }

    @Override
    public void onWindowSystemUiVisibilityChanged(int visible) {
        Log.d(TAG, "onWindowSystemUiVisibilityChanged() called with: visible = [" + visible + "]");
        super.onWindowSystemUiVisibilityChanged(visible);
    }

    @Override
    public void dispatchWindowSystemUiVisiblityChanged(int visible) {
        Log.d(TAG, "dispatchWindowSystemUiVisiblityChanged() called with: visible = [" + visible + "]");
        super.dispatchWindowSystemUiVisiblityChanged(visible);
    }

    @Override
    public void setOnSystemUiVisibilityChangeListener(OnSystemUiVisibilityChangeListener l) {
        Log.d(TAG, "setOnSystemUiVisibilityChangeListener() called with: l = [" + l + "]");
        super.setOnSystemUiVisibilityChangeListener(l);
    }

    @Override
    public void dispatchSystemUiVisibilityChanged(int visibility) {
        Log.d(TAG, "dispatchSystemUiVisibilityChanged() called with: visibility = [" + visibility + "]");
        super.dispatchSystemUiVisibilityChanged(visibility);
    }

    @Override
    public boolean onDragEvent(DragEvent event) {
        Log.d(TAG, "onDragEvent() called with: event = [" + event + "]");
        return super.onDragEvent(event);
    }

    @Override
    public boolean dispatchDragEvent(DragEvent event) {
        Log.d(TAG, "dispatchDragEvent() called with: event = [" + event + "]");
        return super.dispatchDragEvent(event);
    }

    @Override
    protected boolean overScrollBy(int deltaX, int deltaY, int scrollX, int scrollY, int scrollRangeX, int scrollRangeY, int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent) {
        Log.d(TAG, "overScrollBy() called with: deltaX = [" + deltaX + "], deltaY = [" + deltaY + "], scrollX = [" + scrollX + "], scrollY = [" + scrollY + "], scrollRangeX = [" + scrollRangeX + "], scrollRangeY = [" + scrollRangeY + "], maxOverScrollX = [" + maxOverScrollX + "], maxOverScrollY = [" + maxOverScrollY + "], isTouchEvent = [" + isTouchEvent + "]");
        return super.overScrollBy(deltaX, deltaY, scrollX, scrollY, scrollRangeX, scrollRangeY, maxOverScrollX, maxOverScrollY, isTouchEvent);
    }

    @Override
    protected void onOverScrolled(int scrollX, int scrollY, boolean clampedX, boolean clampedY) {
        Log.d(TAG, "onOverScrolled() called with: scrollX = [" + scrollX + "], scrollY = [" + scrollY + "], clampedX = [" + clampedX + "], clampedY = [" + clampedY + "]");
        super.onOverScrolled(scrollX, scrollY, clampedX, clampedY);
    }

    @Override
    public int getOverScrollMode() {
        Log.d(TAG, "getOverScrollMode() called");
        return super.getOverScrollMode();
    }

    @Override
    public void setOverScrollMode(int overScrollMode) {
        Log.d(TAG, "setOverScrollMode() called with: overScrollMode = [" + overScrollMode + "]");
        super.setOverScrollMode(overScrollMode);
    }

    @Override
    public void setNestedScrollingEnabled(boolean enabled) {
        Log.d(TAG, "setNestedScrollingEnabled() called with: enabled = [" + enabled + "]");
        super.setNestedScrollingEnabled(enabled);
    }

    @Override
    public boolean isNestedScrollingEnabled() {
        Log.d(TAG, "isNestedScrollingEnabled() called");
        return super.isNestedScrollingEnabled();
    }

    @Override
    public boolean startNestedScroll(int axes) {
        Log.d(TAG, "startNestedScroll() called with: axes = [" + axes + "]");
        return super.startNestedScroll(axes);
    }

    @Override
    public void stopNestedScroll() {
        Log.d(TAG, "stopNestedScroll() called");
        super.stopNestedScroll();
    }

    @Override
    public boolean hasNestedScrollingParent() {
        Log.d(TAG, "hasNestedScrollingParent() called");
        return super.hasNestedScrollingParent();
    }

    @Override
    public boolean dispatchNestedScroll(int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, @androidx.annotation.Nullable int[] offsetInWindow) {
        Log.d(TAG, "dispatchNestedScroll() called with: dxConsumed = [" + dxConsumed + "], dyConsumed = [" + dyConsumed + "], dxUnconsumed = [" + dxUnconsumed + "], dyUnconsumed = [" + dyUnconsumed + "], offsetInWindow = [" + offsetInWindow + "]");
        return super.dispatchNestedScroll(dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, offsetInWindow);
    }

    @Override
    public boolean dispatchNestedPreScroll(int dx, int dy, @androidx.annotation.Nullable int[] consumed, @androidx.annotation.Nullable int[] offsetInWindow) {
        Log.d(TAG, "dispatchNestedPreScroll() called with: dx = [" + dx + "], dy = [" + dy + "], consumed = [" + consumed + "], offsetInWindow = [" + offsetInWindow + "]");
        return super.dispatchNestedPreScroll(dx, dy, consumed, offsetInWindow);
    }

    @Override
    public boolean dispatchNestedFling(float velocityX, float velocityY, boolean consumed) {
        Log.d(TAG, "dispatchNestedFling() called with: velocityX = [" + velocityX + "], velocityY = [" + velocityY + "], consumed = [" + consumed + "]");
        return super.dispatchNestedFling(velocityX, velocityY, consumed);
    }

    @Override
    public boolean dispatchNestedPreFling(float velocityX, float velocityY) {
        Log.d(TAG, "dispatchNestedPreFling() called with: velocityX = [" + velocityX + "], velocityY = [" + velocityY + "]");
        return super.dispatchNestedPreFling(velocityX, velocityY);
    }

    @Override
    public void setTextDirection(int textDirection) {
        Log.d(TAG, "setTextDirection() called with: textDirection = [" + textDirection + "]");
        super.setTextDirection(textDirection);
    }

    @Override
    public int getTextDirection() {
        Log.d(TAG, "getTextDirection() called");
        return super.getTextDirection();
    }

    @Override
    public boolean canResolveTextDirection() {
        Log.d(TAG, "canResolveTextDirection() called");
        return super.canResolveTextDirection();
    }

    @Override
    public boolean isTextDirectionResolved() {
        Log.d(TAG, "isTextDirectionResolved() called");
        return super.isTextDirectionResolved();
    }

    @Override
    public void setTextAlignment(int textAlignment) {
        Log.d(TAG, "setTextAlignment() called with: textAlignment = [" + textAlignment + "]");
        super.setTextAlignment(textAlignment);
    }

    @Override
    public int getTextAlignment() {
        Log.d(TAG, "getTextAlignment() called");
        return super.getTextAlignment();
    }

    @Override
    public boolean canResolveTextAlignment() {
        Log.d(TAG, "canResolveTextAlignment() called");
        return super.canResolveTextAlignment();
    }

    @Override
    public boolean isTextAlignmentResolved() {
        Log.d(TAG, "isTextAlignmentResolved() called");
        return super.isTextAlignmentResolved();
    }

    @Override
    public PointerIcon onResolvePointerIcon(MotionEvent event, int pointerIndex) {
        Log.d(TAG, "onResolvePointerIcon() called with: event = [" + event + "], pointerIndex = [" + pointerIndex + "]");
        return super.onResolvePointerIcon(event, pointerIndex);
    }

    @Override
    public void setPointerIcon(PointerIcon pointerIcon) {
        Log.d(TAG, "setPointerIcon() called with: pointerIcon = [" + pointerIcon + "]");
        super.setPointerIcon(pointerIcon);
    }

    @Override
    public PointerIcon getPointerIcon() {
        Log.d(TAG, "getPointerIcon() called");
        return super.getPointerIcon();
    }

    @Override
    public boolean hasPointerCapture() {
        Log.d(TAG, "hasPointerCapture() called");
        return super.hasPointerCapture();
    }

    @Override
    public void requestPointerCapture() {
        Log.d(TAG, "requestPointerCapture() called");
        super.requestPointerCapture();
    }

    @Override
    public void releasePointerCapture() {
        Log.d(TAG, "releasePointerCapture() called");
        super.releasePointerCapture();
    }

    @Override
    public void onPointerCaptureChange(boolean hasCapture) {
        Log.d(TAG, "onPointerCaptureChange() called with: hasCapture = [" + hasCapture + "]");
        super.onPointerCaptureChange(hasCapture);
    }

    @Override
    public void dispatchPointerCaptureChanged(boolean hasCapture) {
        Log.d(TAG, "dispatchPointerCaptureChanged() called with: hasCapture = [" + hasCapture + "]");
        super.dispatchPointerCaptureChanged(hasCapture);
    }

    @Override
    public boolean onCapturedPointerEvent(MotionEvent event) {
        Log.d(TAG, "onCapturedPointerEvent() called with: event = [" + event + "]");
        return super.onCapturedPointerEvent(event);
    }

    @Override
    public void setOnCapturedPointerListener(OnCapturedPointerListener l) {
        Log.d(TAG, "setOnCapturedPointerListener() called with: l = [" + l + "]");
        super.setOnCapturedPointerListener(l);
    }

    @Override
    public ViewPropertyAnimator animate() {
        Log.d(TAG, "animate() called");
        return super.animate();
    }

    @Override
    public String getTransitionName() {
        Log.d(TAG, "getTransitionName() called");
        return super.getTransitionName();
    }

    @Override
    public void setTooltipText(@androidx.annotation.Nullable CharSequence tooltipText) {
        Log.d(TAG, "setTooltipText() called with: tooltipText = [" + tooltipText + "]");
        super.setTooltipText(tooltipText);
    }

    @androidx.annotation.Nullable
    @Override
    public CharSequence getTooltipText() {
        Log.d(TAG, "getTooltipText() called");
        return super.getTooltipText();
    }

    @Override
    public void addOnUnhandledKeyEventListener(OnUnhandledKeyEventListener listener) {
        Log.d(TAG, "addOnUnhandledKeyEventListener() called with: listener = [" + listener + "]");
        super.addOnUnhandledKeyEventListener(listener);
    }

    @Override
    public void removeOnUnhandledKeyEventListener(OnUnhandledKeyEventListener listener) {
        Log.d(TAG, "removeOnUnhandledKeyEventListener() called with: listener = [" + listener + "]");
        super.removeOnUnhandledKeyEventListener(listener);
    }
}
