package css.com.applab.view;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Region;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ActionMode;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;
import android.view.ViewParent;
import android.view.ViewStructure;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Animation;
import android.view.animation.LayoutAnimationController;
import android.view.animation.Transformation;

import java.util.ArrayList;
import java.util.Collection;

import androidx.annotation.NonNull;

public class LifeCycleViewGroup extends ViewGroup {
    private static final String TAG = "ViewGroupLiftCycle";

    public LifeCycleViewGroup(Context context) {
        super(context);
        Log.d(TAG, "ViewGroupLiftCycle() called with: context = [" + context + "]");
    }

    public LifeCycleViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        Log.d(TAG, "ViewGroupLiftCycle() called with: context = [" + context + "], attrs = [" + attrs + "]");
    }

    public LifeCycleViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Log.d(TAG, "ViewGroupLiftCycle() called with: context = [" + context + "], attrs = [" + attrs + "], defStyleAttr = [" + defStyleAttr + "]");
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        Log.d(TAG, "onLayout() called with: changed = [" + changed + "], l = [" + l + "], t = [" + t + "], r = [" + r + "], b = [" + b + "]");
    }

    @Override
    public int getDescendantFocusability() {
        Log.d(TAG, "getDescendantFocusability() called");
        return super.getDescendantFocusability();
    }

    @Override
    public void setDescendantFocusability(int focusability) {
        Log.d(TAG, "setDescendantFocusability() called with: focusability = [" + focusability + "]");
        super.setDescendantFocusability(focusability);
    }

    @Override
    public void requestChildFocus(View child, View focused) {
        Log.d(TAG, "requestChildFocus() called with: child = [" + child + "], focused = [" + focused + "]");
        super.requestChildFocus(child, focused);
    }

    @Override
    public void focusableViewAvailable(View v) {
        Log.d(TAG, "focusableViewAvailable() called with: v = [" + v + "]");
        super.focusableViewAvailable(v);
    }

    @Override
    public boolean showContextMenuForChild(View originalView) {
        Log.d(TAG, "showContextMenuForChild() called with: originalView = [" + originalView + "]");
        return super.showContextMenuForChild(originalView);
    }

    @Override
    public boolean showContextMenuForChild(View originalView, float x, float y) {
        Log.d(TAG, "showContextMenuForChild() called with: originalView = [" + originalView + "], x = [" + x + "], y = [" + y + "]");
        return super.showContextMenuForChild(originalView, x, y);
    }

    @Override
    public ActionMode startActionModeForChild(View originalView, ActionMode.Callback callback) {
        Log.d(TAG, "startActionModeForChild() called with: originalView = [" + originalView + "], callback = [" + callback + "]");
        return super.startActionModeForChild(originalView, callback);
    }

    @Override
    public ActionMode startActionModeForChild(View originalView, ActionMode.Callback callback, int type) {
        Log.d(TAG, "startActionModeForChild() called with: originalView = [" + originalView + "], callback = [" + callback + "], type = [" + type + "]");
        return super.startActionModeForChild(originalView, callback, type);
    }

    @Override
    public View focusSearch(View focused, int direction) {
        Log.d(TAG, "focusSearch() called with: focused = [" + focused + "], direction = [" + direction + "]");
        return super.focusSearch(focused, direction);
    }

    @Override
    public boolean requestChildRectangleOnScreen(View child, Rect rectangle, boolean immediate) {
        Log.d(TAG, "requestChildRectangleOnScreen() called with: child = [" + child + "], rectangle = [" + rectangle + "], immediate = [" + immediate + "]");
        return super.requestChildRectangleOnScreen(child, rectangle, immediate);
    }

    @Override
    public boolean requestSendAccessibilityEvent(View child, AccessibilityEvent event) {
        Log.d(TAG, "requestSendAccessibilityEvent() called with: child = [" + child + "], event = [" + event + "]");
        return super.requestSendAccessibilityEvent(child, event);
    }

    @Override
    public boolean onRequestSendAccessibilityEvent(View child, AccessibilityEvent event) {
        Log.d(TAG, "onRequestSendAccessibilityEvent() called with: child = [" + child + "], event = [" + event + "]");
        return super.onRequestSendAccessibilityEvent(child, event);
    }

    @Override
    public void childHasTransientStateChanged(View child, boolean childHasTransientState) {
        Log.d(TAG, "childHasTransientStateChanged() called with: child = [" + child + "], childHasTransientState = [" + childHasTransientState + "]");
        super.childHasTransientStateChanged(child, childHasTransientState);
    }

    @Override
    public boolean hasTransientState() {
        Log.d(TAG, "hasTransientState() called");
        return super.hasTransientState();
    }

    @Override
    public boolean dispatchUnhandledMove(View focused, int direction) {
        Log.d(TAG, "dispatchUnhandledMove() called with: focused = [" + focused + "], direction = [" + direction + "]");
        return super.dispatchUnhandledMove(focused, direction);
    }

    @Override
    public void clearChildFocus(View child) {
        Log.d(TAG, "clearChildFocus() called with: child = [" + child + "]");
        super.clearChildFocus(child);
    }

    @Override
    public void clearFocus() {
        Log.d(TAG, "clearFocus() called");
        super.clearFocus();
    }

    @Override
    public View getFocusedChild() {
        Log.d(TAG, "getFocusedChild() called");
        return super.getFocusedChild();
    }

    @Override
    public boolean hasFocus() {
        Log.d(TAG, "hasFocus() called");
        return super.hasFocus();
    }

    @Override
    public View findFocus() {
        Log.d(TAG, "findFocus() called");
        return super.findFocus();
    }

    @Override
    public void addFocusables(ArrayList<View> views, int direction, int focusableMode) {
        Log.d(TAG, "addFocusables() called with: views = [" + views + "], direction = [" + direction + "], focusableMode = [" + focusableMode + "]");
        super.addFocusables(views, direction, focusableMode);
    }

    @Override
    public void addKeyboardNavigationClusters(Collection<View> views, int direction) {
        Log.d(TAG, "addKeyboardNavigationClusters() called with: views = [" + views + "], direction = [" + direction + "]");
        super.addKeyboardNavigationClusters(views, direction);
    }

    @Override
    public void setTouchscreenBlocksFocus(boolean touchscreenBlocksFocus) {
        Log.d(TAG, "setTouchscreenBlocksFocus() called with: touchscreenBlocksFocus = [" + touchscreenBlocksFocus + "]");
        super.setTouchscreenBlocksFocus(touchscreenBlocksFocus);
    }

    @Override
    public boolean getTouchscreenBlocksFocus() {
        Log.d(TAG, "getTouchscreenBlocksFocus() called");
        return super.getTouchscreenBlocksFocus();
    }

    @Override
    public void findViewsWithText(ArrayList<View> outViews, CharSequence text, int flags) {
        Log.d(TAG, "findViewsWithText() called with: outViews = [" + outViews + "], text = [" + text + "], flags = [" + flags + "]");
        super.findViewsWithText(outViews, text, flags);
    }

    @Override
    public void dispatchWindowFocusChanged(boolean hasFocus) {
        Log.d(TAG, "dispatchWindowFocusChanged() called with: hasFocus = [" + hasFocus + "]");
        super.dispatchWindowFocusChanged(hasFocus);
    }

    @Override
    public void addTouchables(ArrayList<View> views) {
        Log.d(TAG, "addTouchables() called with: views = [" + views + "]");
        super.addTouchables(views);
    }

    @Override
    public void dispatchDisplayHint(int hint) {
        Log.d(TAG, "dispatchDisplayHint() called with: hint = [" + hint + "]");
        super.dispatchDisplayHint(hint);
    }

    @Override
    protected void dispatchVisibilityChanged(View changedView, int visibility) {
        Log.d(TAG, "dispatchVisibilityChanged() called with: changedView = [" + changedView + "], visibility = [" + visibility + "]");
        super.dispatchVisibilityChanged(changedView, visibility);
    }

    @Override
    public void dispatchWindowVisibilityChanged(int visibility) {
        Log.d(TAG, "dispatchWindowVisibilityChanged() called with: visibility = [" + visibility + "]");
        super.dispatchWindowVisibilityChanged(visibility);
    }

    @Override
    public void dispatchConfigurationChanged(Configuration newConfig) {
        Log.d(TAG, "dispatchConfigurationChanged() called with: newConfig = [" + newConfig + "]");
        super.dispatchConfigurationChanged(newConfig);
    }

    @Override
    public void recomputeViewAttributes(View child) {
        Log.d(TAG, "recomputeViewAttributes() called with: child = [" + child + "]");
        super.recomputeViewAttributes(child);
    }

    @Override
    public void bringChildToFront(View child) {
        Log.d(TAG, "bringChildToFront() called with: child = [" + child + "]");
        super.bringChildToFront(child);
    }

    @Override
    public boolean dispatchDragEvent(DragEvent event) {
        Log.d(TAG, "dispatchDragEvent() called with: event = [" + event + "]");
        return super.dispatchDragEvent(event);
    }

    @Override
    public void dispatchWindowSystemUiVisiblityChanged(int visible) {
        Log.d(TAG, "dispatchWindowSystemUiVisiblityChanged() called with: visible = [" + visible + "]");
        super.dispatchWindowSystemUiVisiblityChanged(visible);
    }

    @Override
    public void dispatchSystemUiVisibilityChanged(int visible) {
        Log.d(TAG, "dispatchSystemUiVisibilityChanged() called with: visible = [" + visible + "]");
        super.dispatchSystemUiVisibilityChanged(visible);
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
    public void dispatchPointerCaptureChanged(boolean hasCapture) {
        Log.d(TAG, "dispatchPointerCaptureChanged() called with: hasCapture = [" + hasCapture + "]");
        super.dispatchPointerCaptureChanged(hasCapture);
    }

    @Override
    public PointerIcon onResolvePointerIcon(MotionEvent event, int pointerIndex) {
        Log.d(TAG, "onResolvePointerIcon() called with: event = [" + event + "], pointerIndex = [" + pointerIndex + "]");
        return super.onResolvePointerIcon(event, pointerIndex);
    }

    @Override
    protected boolean dispatchHoverEvent(MotionEvent event) {
        Log.d(TAG, "dispatchHoverEvent() called with: event = [" + event + "]");
        return super.dispatchHoverEvent(event);
    }

    @Override
    public void addChildrenForAccessibility(ArrayList<View> outChildren) {
        Log.d(TAG, "addChildrenForAccessibility() called with: outChildren = [" + outChildren + "]");
        super.addChildrenForAccessibility(outChildren);
    }

    @Override
    public boolean onInterceptHoverEvent(MotionEvent event) {
        Log.d(TAG, "onInterceptHoverEvent() called with: event = [" + event + "]");
        return super.onInterceptHoverEvent(event);
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
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d(TAG, "dispatchTouchEvent() called with: ev = [" + ev + "]");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public void setMotionEventSplittingEnabled(boolean split) {
        Log.d(TAG, "setMotionEventSplittingEnabled() called with: split = [" + split + "]");
        super.setMotionEventSplittingEnabled(split);
    }

    @Override
    public boolean isMotionEventSplittingEnabled() {
        Log.d(TAG, "isMotionEventSplittingEnabled() called");
        return super.isMotionEventSplittingEnabled();
    }

    @Override
    public boolean isTransitionGroup() {
        Log.d(TAG, "isTransitionGroup() called");
        return super.isTransitionGroup();
    }

    @Override
    public void setTransitionGroup(boolean isTransitionGroup) {
        Log.d(TAG, "setTransitionGroup() called with: isTransitionGroup = [" + isTransitionGroup + "]");
        super.setTransitionGroup(isTransitionGroup);
    }

    @Override
    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        Log.d(TAG, "requestDisallowInterceptTouchEvent() called with: disallowIntercept = [" + disallowIntercept + "]");
        super.requestDisallowInterceptTouchEvent(disallowIntercept);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.d(TAG, "onInterceptTouchEvent() called with: ev = [" + ev + "]");
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean requestFocus(int direction, Rect previouslyFocusedRect) {
        Log.d(TAG, "requestFocus() called with: direction = [" + direction + "], previouslyFocusedRect = [" + previouslyFocusedRect + "]");
        return super.requestFocus(direction, previouslyFocusedRect);
    }

    @Override
    protected boolean onRequestFocusInDescendants(int direction, Rect previouslyFocusedRect) {
        Log.d(TAG, "onRequestFocusInDescendants() called with: direction = [" + direction + "], previouslyFocusedRect = [" + previouslyFocusedRect + "]");
        return super.onRequestFocusInDescendants(direction, previouslyFocusedRect);
    }

    @Override
    public boolean restoreDefaultFocus() {
        Log.d(TAG, "restoreDefaultFocus() called");
        return super.restoreDefaultFocus();
    }

    @Override
    public void dispatchStartTemporaryDetach() {
        Log.d(TAG, "dispatchStartTemporaryDetach() called");
        super.dispatchStartTemporaryDetach();
    }

    @Override
    public void dispatchFinishTemporaryDetach() {
        Log.d(TAG, "dispatchFinishTemporaryDetach() called");
        super.dispatchFinishTemporaryDetach();
    }

    @Override
    public void dispatchProvideStructure(ViewStructure structure) {
        Log.d(TAG, "dispatchProvideStructure() called with: structure = [" + structure + "]");
        super.dispatchProvideStructure(structure);
    }

    @Override
    public void dispatchProvideAutofillStructure(ViewStructure structure, int flags) {
        Log.d(TAG, "dispatchProvideAutofillStructure() called with: structure = [" + structure + "], flags = [" + flags + "]");
        super.dispatchProvideAutofillStructure(structure, flags);
    }

    @Override
    public CharSequence getAccessibilityClassName() {
        Log.d(TAG, "getAccessibilityClassName() called");
        return super.getAccessibilityClassName();
    }

    @Override
    public void notifySubtreeAccessibilityStateChanged(View child, View source, int changeType) {
        Log.d(TAG, "notifySubtreeAccessibilityStateChanged() called with: child = [" + child + "], source = [" + source + "], changeType = [" + changeType + "]");
        super.notifySubtreeAccessibilityStateChanged(child, source, changeType);
    }

    @Override
    public boolean onNestedPrePerformAccessibilityAction(View target, int action, Bundle args) {
        Log.d(TAG, "onNestedPrePerformAccessibilityAction() called with: target = [" + target + "], action = [" + action + "], args = [" + args + "]");
        return super.onNestedPrePerformAccessibilityAction(target, action, args);
    }

    @Override
    protected void dispatchSaveInstanceState(SparseArray<Parcelable> container) {
        Log.d(TAG, "dispatchSaveInstanceState() called with: container = [" + container + "]");
        super.dispatchSaveInstanceState(container);
    }

    @Override
    protected void dispatchFreezeSelfOnly(SparseArray<Parcelable> container) {
        Log.d(TAG, "dispatchFreezeSelfOnly() called with: container = [" + container + "]");
        super.dispatchFreezeSelfOnly(container);
    }

    @Override
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> container) {
        Log.d(TAG, "dispatchRestoreInstanceState() called with: container = [" + container + "]");
        super.dispatchRestoreInstanceState(container);
    }

    @Override
    protected void dispatchThawSelfOnly(SparseArray<Parcelable> container) {
        Log.d(TAG, "dispatchThawSelfOnly() called with: container = [" + container + "]");
        super.dispatchThawSelfOnly(container);
    }

    @Override
    protected void setChildrenDrawingCacheEnabled(boolean enabled) {
        Log.d(TAG, "setChildrenDrawingCacheEnabled() called with: enabled = [" + enabled + "]");
        super.setChildrenDrawingCacheEnabled(enabled);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        Log.d(TAG, "dispatchDraw() called with: canvas = [" + canvas + "]");
        super.dispatchDraw(canvas);
    }

    @Override
    public ViewGroupOverlay getOverlay() {
        Log.d(TAG, "getOverlay() called");
        return super.getOverlay();
    }

    @Override
    protected int getChildDrawingOrder(int childCount, int i) {
        Log.d(TAG, "getChildDrawingOrder() called with: childCount = [" + childCount + "], i = [" + i + "]");
        return super.getChildDrawingOrder(childCount, i);
    }

    @Override
    protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
        Log.d(TAG, "drawChild() called with: canvas = [" + canvas + "], child = [" + child + "], drawingTime = [" + drawingTime + "]");
        return super.drawChild(canvas, child, drawingTime);
    }

    @Override
    public boolean getClipChildren() {
        Log.d(TAG, "getClipChildren() called");
        return super.getClipChildren();
    }

    @Override
    public void setClipChildren(boolean clipChildren) {
        Log.d(TAG, "setClipChildren() called with: clipChildren = [" + clipChildren + "]");
        super.setClipChildren(clipChildren);
    }

    @Override
    public void setClipToPadding(boolean clipToPadding) {
        Log.d(TAG, "setClipToPadding() called with: clipToPadding = [" + clipToPadding + "]");
        super.setClipToPadding(clipToPadding);
    }

    @Override
    public boolean getClipToPadding() {
        Log.d(TAG, "getClipToPadding() called");
        return super.getClipToPadding();
    }

    @Override
    public void dispatchSetSelected(boolean selected) {
        Log.d(TAG, "dispatchSetSelected() called with: selected = [" + selected + "]");
        super.dispatchSetSelected(selected);
    }

    @Override
    public void dispatchSetActivated(boolean activated) {
        Log.d(TAG, "dispatchSetActivated() called with: activated = [" + activated + "]");
        super.dispatchSetActivated(activated);
    }

    @Override
    protected void dispatchSetPressed(boolean pressed) {
        Log.d(TAG, "dispatchSetPressed() called with: pressed = [" + pressed + "]");
        super.dispatchSetPressed(pressed);
    }

    @Override
    public void dispatchDrawableHotspotChanged(float x, float y) {
        Log.d(TAG, "dispatchDrawableHotspotChanged() called with: x = [" + x + "], y = [" + y + "]");
        super.dispatchDrawableHotspotChanged(x, y);
    }

    @Override
    protected void setStaticTransformationsEnabled(boolean enabled) {
        Log.d(TAG, "setStaticTransformationsEnabled() called with: enabled = [" + enabled + "]");
        super.setStaticTransformationsEnabled(enabled);
    }

    @Override
    protected boolean getChildStaticTransformation(View child, Transformation t) {
        Log.d(TAG, "getChildStaticTransformation() called with: child = [" + child + "], t = [" + t + "]");
        return super.getChildStaticTransformation(child, t);
    }

    @Override
    public void addView(View child) {
        Log.d(TAG, "addView() called with: child = [" + child + "]");
        super.addView(child);
    }

    @Override
    public void addView(View child, int index) {
        Log.d(TAG, "addView() called with: child = [" + child + "], index = [" + index + "]");
        super.addView(child, index);
    }

    @Override
    public void addView(View child, int width, int height) {
        Log.d(TAG, "addView() called with: child = [" + child + "], width = [" + width + "], height = [" + height + "]");
        super.addView(child, width, height);
    }

    @Override
    public void addView(View child, LayoutParams params) {
        Log.d(TAG, "addView() called with: child = [" + child + "], params = [" + params + "]");
        super.addView(child, params);
    }

    @Override
    public void addView(View child, int index, LayoutParams params) {
        Log.d(TAG, "addView() called with: child = [" + child + "], index = [" + index + "], params = [" + params + "]");
        super.addView(child, index, params);
    }

    @Override
    public void updateViewLayout(View view, LayoutParams params) {
        Log.d(TAG, "updateViewLayout() called with: view = [" + view + "], params = [" + params + "]");
        super.updateViewLayout(view, params);
    }

    @Override
    protected boolean checkLayoutParams(LayoutParams p) {
        Log.d(TAG, "checkLayoutParams() called with: p = [" + p + "]");
        return super.checkLayoutParams(p);
    }

    @Override
    public void setOnHierarchyChangeListener(OnHierarchyChangeListener listener) {
        Log.d(TAG, "setOnHierarchyChangeListener() called with: listener = [" + listener + "]");
        super.setOnHierarchyChangeListener(listener);
    }

    @Override
    public void onViewAdded(View child) {
        Log.d(TAG, "onViewAdded() called with: child = [" + child + "]");
        super.onViewAdded(child);
    }

    @Override
    public void onViewRemoved(View child) {
        Log.d(TAG, "onViewRemoved() called with: child = [" + child + "]");
        super.onViewRemoved(child);
    }

    @Override
    protected void onAttachedToWindow() {
        Log.d(TAG, "onAttachedToWindow() called");
        super.onAttachedToWindow();
    }

    @Override
    protected void onDetachedFromWindow() {
        Log.d(TAG, "onDetachedFromWindow() called");
        super.onDetachedFromWindow();
    }

    @Override
    protected boolean addViewInLayout(View child, int index, LayoutParams params) {
        Log.d(TAG, "addViewInLayout() called with: child = [" + child + "], index = [" + index + "], params = [" + params + "]");
        return super.addViewInLayout(child, index, params);
    }

    @Override
    protected boolean addViewInLayout(View child, int index, LayoutParams params, boolean preventRequestLayout) {
        Log.d(TAG, "addViewInLayout() called with: child = [" + child + "], index = [" + index + "], params = [" + params + "], preventRequestLayout = [" + preventRequestLayout + "]");
        return super.addViewInLayout(child, index, params, preventRequestLayout);
    }

    @Override
    protected void cleanupLayoutState(View child) {
        Log.d(TAG, "cleanupLayoutState() called with: child = [" + child + "]");
        super.cleanupLayoutState(child);
    }

    @Override
    protected void attachLayoutAnimationParameters(View child, LayoutParams params, int index, int count) {
        Log.d(TAG, "attachLayoutAnimationParameters() called with: child = [" + child + "], params = [" + params + "], index = [" + index + "], count = [" + count + "]");
        super.attachLayoutAnimationParameters(child, params, index, count);
    }

    @Override
    public void removeView(View view) {
        Log.d(TAG, "removeView() called with: view = [" + view + "]");
        super.removeView(view);
    }

    @Override
    public void removeViewInLayout(View view) {
        Log.d(TAG, "removeViewInLayout() called with: view = [" + view + "]");
        super.removeViewInLayout(view);
    }

    @Override
    public void removeViewsInLayout(int start, int count) {
        Log.d(TAG, "removeViewsInLayout() called with: start = [" + start + "], count = [" + count + "]");
        super.removeViewsInLayout(start, count);
    }

    @Override
    public void removeViewAt(int index) {
        Log.d(TAG, "removeViewAt() called with: index = [" + index + "]");
        super.removeViewAt(index);
    }

    @Override
    public void removeViews(int start, int count) {
        Log.d(TAG, "removeViews() called with: start = [" + start + "], count = [" + count + "]");
        super.removeViews(start, count);
    }

    @Override
    public void setLayoutTransition(LayoutTransition transition) {
        Log.d(TAG, "setLayoutTransition() called with: transition = [" + transition + "]");
        super.setLayoutTransition(transition);
    }

    @Override
    public LayoutTransition getLayoutTransition() {
        Log.d(TAG, "getLayoutTransition() called");
        return super.getLayoutTransition();
    }

    @Override
    public void removeAllViews() {
        Log.d(TAG, "removeAllViews() called");
        super.removeAllViews();
    }

    @Override
    public void removeAllViewsInLayout() {
        Log.d(TAG, "removeAllViewsInLayout() called");
        super.removeAllViewsInLayout();
    }

    @Override
    protected void removeDetachedView(View child, boolean animate) {
        Log.d(TAG, "removeDetachedView() called with: child = [" + child + "], animate = [" + animate + "]");
        super.removeDetachedView(child, animate);
    }

    @Override
    protected void attachViewToParent(View child, int index, LayoutParams params) {
        Log.d(TAG, "attachViewToParent() called with: child = [" + child + "], index = [" + index + "], params = [" + params + "]");
        super.attachViewToParent(child, index, params);
    }

    @Override
    protected void detachViewFromParent(View child) {
        Log.d(TAG, "detachViewFromParent() called with: child = [" + child + "]");
        super.detachViewFromParent(child);
    }

    @Override
    protected void detachViewFromParent(int index) {
        Log.d(TAG, "detachViewFromParent() called with: index = [" + index + "]");
        super.detachViewFromParent(index);
    }

    @Override
    protected void detachViewsFromParent(int start, int count) {
        Log.d(TAG, "detachViewsFromParent() called with: start = [" + start + "], count = [" + count + "]");
        super.detachViewsFromParent(start, count);
    }

    @Override
    protected void detachAllViewsFromParent() {
        Log.d(TAG, "detachAllViewsFromParent() called");
        super.detachAllViewsFromParent();
    }

    @Override
    public void onDescendantInvalidated(@NonNull View child, @NonNull View target) {
        Log.d(TAG, "onDescendantInvalidated() called with: child = [" + child + "], target = [" + target + "]");
        super.onDescendantInvalidated(child, target);
    }

    @Override
    public ViewParent invalidateChildInParent(int[] location, Rect dirty) {
        Log.d(TAG, "invalidateChildInParent() called with: location = [" + location + "], dirty = [" + dirty + "]");
        return super.invalidateChildInParent(location, dirty);
    }

    @Override
    public boolean getChildVisibleRect(View child, Rect r, Point offset) {
        Log.d(TAG, "getChildVisibleRect() called with: child = [" + child + "], r = [" + r + "], offset = [" + offset + "]");
        return super.getChildVisibleRect(child, r, offset);
    }

    @Override
    protected boolean canAnimate() {
        Log.d(TAG, "canAnimate() called");
        return super.canAnimate();
    }

    @Override
    public void startLayoutAnimation() {
        Log.d(TAG, "startLayoutAnimation() called");
        super.startLayoutAnimation();
    }

    @Override
    public void scheduleLayoutAnimation() {
        Log.d(TAG, "scheduleLayoutAnimation() called");
        super.scheduleLayoutAnimation();
    }

    @Override
    public void setLayoutAnimation(LayoutAnimationController controller) {
        Log.d(TAG, "setLayoutAnimation() called with: controller = [" + controller + "]");
        super.setLayoutAnimation(controller);
    }

    @Override
    public LayoutAnimationController getLayoutAnimation() {
        Log.d(TAG, "getLayoutAnimation() called");
        return super.getLayoutAnimation();
    }

    @Override
    public boolean isAnimationCacheEnabled() {
        Log.d(TAG, "isAnimationCacheEnabled() called");
        return super.isAnimationCacheEnabled();
    }

    @Override
    public void setAnimationCacheEnabled(boolean enabled) {
        Log.d(TAG, "setAnimationCacheEnabled() called with: enabled = [" + enabled + "]");
        super.setAnimationCacheEnabled(enabled);
    }

    @Override
    public boolean isAlwaysDrawnWithCacheEnabled() {
        Log.d(TAG, "isAlwaysDrawnWithCacheEnabled() called");
        return super.isAlwaysDrawnWithCacheEnabled();
    }

    @Override
    public void setAlwaysDrawnWithCacheEnabled(boolean always) {
        Log.d(TAG, "setAlwaysDrawnWithCacheEnabled() called with: always = [" + always + "]");
        super.setAlwaysDrawnWithCacheEnabled(always);
    }

    @Override
    protected boolean isChildrenDrawnWithCacheEnabled() {
        Log.d(TAG, "isChildrenDrawnWithCacheEnabled() called");
        return super.isChildrenDrawnWithCacheEnabled();
    }

    @Override
    protected void setChildrenDrawnWithCacheEnabled(boolean enabled) {
        Log.d(TAG, "setChildrenDrawnWithCacheEnabled() called with: enabled = [" + enabled + "]");
        super.setChildrenDrawnWithCacheEnabled(enabled);
    }

    @Override
    protected boolean isChildrenDrawingOrderEnabled() {
        Log.d(TAG, "isChildrenDrawingOrderEnabled() called");
        return super.isChildrenDrawingOrderEnabled();
    }

    @Override
    protected void setChildrenDrawingOrderEnabled(boolean enabled) {
        Log.d(TAG, "setChildrenDrawingOrderEnabled() called with: enabled = [" + enabled + "]");
        super.setChildrenDrawingOrderEnabled(enabled);
    }

    @Override
    public int getPersistentDrawingCache() {
        Log.d(TAG, "getPersistentDrawingCache() called");
        return super.getPersistentDrawingCache();
    }

    @Override
    public void setPersistentDrawingCache(int drawingCacheToKeep) {
        Log.d(TAG, "setPersistentDrawingCache() called with: drawingCacheToKeep = [" + drawingCacheToKeep + "]");
        super.setPersistentDrawingCache(drawingCacheToKeep);
    }

    @Override
    public int getLayoutMode() {
        Log.d(TAG, "getLayoutMode() called");
        return super.getLayoutMode();
    }

    @Override
    public void setLayoutMode(int layoutMode) {
        Log.d(TAG, "setLayoutMode() called with: layoutMode = [" + layoutMode + "]");
        super.setLayoutMode(layoutMode);
    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        Log.d(TAG, "generateLayoutParams() called with: attrs = [" + attrs + "]");
        return super.generateLayoutParams(attrs);
    }

    @Override
    protected LayoutParams generateLayoutParams(LayoutParams p) {
        Log.d(TAG, "generateLayoutParams() called with: p = [" + p + "]");
        return super.generateLayoutParams(p);
    }

    @Override
    protected LayoutParams generateDefaultLayoutParams() {
        Log.d(TAG, "generateDefaultLayoutParams() called");
        return super.generateDefaultLayoutParams();
    }

    @Override
    protected void debug(int depth) {
        Log.d(TAG, "debug() called with: depth = [" + depth + "]");
        super.debug(depth);
    }

    @Override
    public int indexOfChild(View child) {
        Log.d(TAG, "indexOfChild() called with: child = [" + child + "]");
        return super.indexOfChild(child);
    }

    @Override
    public int getChildCount() {
        Log.d(TAG, "getChildCount() called");
        return super.getChildCount();
    }

    @Override
    public View getChildAt(int index) {
        Log.d(TAG, "getChildAt() called with: index = [" + index + "]");
        return super.getChildAt(index);
    }

    @Override
    protected void measureChildren(int widthMeasureSpec, int heightMeasureSpec) {
        Log.d(TAG, "measureChildren() called with: widthMeasureSpec = [" + widthMeasureSpec + "], heightMeasureSpec = [" + heightMeasureSpec + "]");
        super.measureChildren(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void measureChild(View child, int parentWidthMeasureSpec, int parentHeightMeasureSpec) {
        Log.d(TAG, "measureChild() called with: child = [" + child + "], parentWidthMeasureSpec = [" + parentWidthMeasureSpec + "], parentHeightMeasureSpec = [" + parentHeightMeasureSpec + "]");
        super.measureChild(child, parentWidthMeasureSpec, parentHeightMeasureSpec);
    }

    @Override
    protected void measureChildWithMargins(View child, int parentWidthMeasureSpec, int widthUsed, int parentHeightMeasureSpec, int heightUsed) {
        Log.d(TAG, "measureChildWithMargins() called with: child = [" + child + "], parentWidthMeasureSpec = [" + parentWidthMeasureSpec + "], widthUsed = [" + widthUsed + "], parentHeightMeasureSpec = [" + parentHeightMeasureSpec + "], heightUsed = [" + heightUsed + "]");
        super.measureChildWithMargins(child, parentWidthMeasureSpec, widthUsed, parentHeightMeasureSpec, heightUsed);
    }

    @Override
    public void clearDisappearingChildren() {
        Log.d(TAG, "clearDisappearingChildren() called");
        super.clearDisappearingChildren();
    }

    @Override
    public void startViewTransition(View view) {
        Log.d(TAG, "startViewTransition() called with: view = [" + view + "]");
        super.startViewTransition(view);
    }

    @Override
    public void endViewTransition(View view) {
        Log.d(TAG, "endViewTransition() called with: view = [" + view + "]");
        super.endViewTransition(view);
    }

    @Override
    public boolean gatherTransparentRegion(Region region) {
        Log.d(TAG, "gatherTransparentRegion() called with: region = [" + region + "]");
        return super.gatherTransparentRegion(region);
    }

    @Override
    public void requestTransparentRegion(View child) {
        Log.d(TAG, "requestTransparentRegion() called with: child = [" + child + "]");
        super.requestTransparentRegion(child);
    }

    @Override
    public WindowInsets dispatchApplyWindowInsets(WindowInsets insets) {
        Log.d(TAG, "dispatchApplyWindowInsets() called with: insets = [" + insets + "]");
        return super.dispatchApplyWindowInsets(insets);
    }

    @Override
    public Animation.AnimationListener getLayoutAnimationListener() {
        Log.d(TAG, "getLayoutAnimationListener() called");
        return super.getLayoutAnimationListener();
    }

    @Override
    protected void drawableStateChanged() {
        Log.d(TAG, "drawableStateChanged() called");
        super.drawableStateChanged();
    }

    @Override
    public void jumpDrawablesToCurrentState() {
        Log.d(TAG, "jumpDrawablesToCurrentState() called");
        super.jumpDrawablesToCurrentState();
    }

    @Override
    protected int[] onCreateDrawableState(int extraSpace) {
        Log.d(TAG, "onCreateDrawableState() called with: extraSpace = [" + extraSpace + "]");
        return super.onCreateDrawableState(extraSpace);
    }

    @Override
    public void setAddStatesFromChildren(boolean addsStates) {
        Log.d(TAG, "setAddStatesFromChildren() called with: addsStates = [" + addsStates + "]");
        super.setAddStatesFromChildren(addsStates);
    }

    @Override
    public boolean addStatesFromChildren() {
        Log.d(TAG, "addStatesFromChildren() called");
        return super.addStatesFromChildren();
    }

    @Override
    public void childDrawableStateChanged(View child) {
        Log.d(TAG, "childDrawableStateChanged() called with: child = [" + child + "]");
        super.childDrawableStateChanged(child);
    }

    @Override
    public void setLayoutAnimationListener(Animation.AnimationListener animationListener) {
        Log.d(TAG, "setLayoutAnimationListener() called with: animationListener = [" + animationListener + "]");
        super.setLayoutAnimationListener(animationListener);
    }

    @Override
    public boolean shouldDelayChildPressedState() {
        Log.d(TAG, "shouldDelayChildPressedState() called");
        return super.shouldDelayChildPressedState();
    }

    @Override
    public boolean onStartNestedScroll(View child, View target, int nestedScrollAxes) {
        Log.d(TAG, "onStartNestedScroll() called with: child = [" + child + "], target = [" + target + "], nestedScrollAxes = [" + nestedScrollAxes + "]");
        return super.onStartNestedScroll(child, target, nestedScrollAxes);
    }

    @Override
    public void onNestedScrollAccepted(View child, View target, int axes) {
        Log.d(TAG, "onNestedScrollAccepted() called with: child = [" + child + "], target = [" + target + "], axes = [" + axes + "]");
        super.onNestedScrollAccepted(child, target, axes);
    }

    @Override
    public void onStopNestedScroll(View child) {
        Log.d(TAG, "onStopNestedScroll() called with: child = [" + child + "]");
        super.onStopNestedScroll(child);
    }

    @Override
    public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        Log.d(TAG, "onNestedScroll() called with: target = [" + target + "], dxConsumed = [" + dxConsumed + "], dyConsumed = [" + dyConsumed + "], dxUnconsumed = [" + dxUnconsumed + "], dyUnconsumed = [" + dyUnconsumed + "]");
        super.onNestedScroll(target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
    }

    @Override
    public void onNestedPreScroll(View target, int dx, int dy, int[] consumed) {
        Log.d(TAG, "onNestedPreScroll() called with: target = [" + target + "], dx = [" + dx + "], dy = [" + dy + "], consumed = [" + consumed + "]");
        super.onNestedPreScroll(target, dx, dy, consumed);
    }

    @Override
    public boolean onNestedFling(View target, float velocityX, float velocityY, boolean consumed) {
        Log.d(TAG, "onNestedFling() called with: target = [" + target + "], velocityX = [" + velocityX + "], velocityY = [" + velocityY + "], consumed = [" + consumed + "]");
        return super.onNestedFling(target, velocityX, velocityY, consumed);
    }

    @Override
    public boolean onNestedPreFling(View target, float velocityX, float velocityY) {
        Log.d(TAG, "onNestedPreFling() called with: target = [" + target + "], velocityX = [" + velocityX + "], velocityY = [" + velocityY + "]");
        return super.onNestedPreFling(target, velocityX, velocityY);
    }

    @Override
    public int getNestedScrollAxes() {
        Log.d(TAG, "getNestedScrollAxes() called");
        return super.getNestedScrollAxes();
    }
}
