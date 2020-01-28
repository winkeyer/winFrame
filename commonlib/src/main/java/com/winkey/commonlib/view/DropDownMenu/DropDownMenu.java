package com.winkey.commonlib.view.DropDownMenu;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.blankj.utilcode.util.ScreenUtils;
import com.joanzapata.iconify.IconDrawable;
import com.winkey.commonlib.R;
import com.winkey.commonlib.icon.AppIcons;

import java.util.List;

/**
 * 查询下拉菜单
 *
 * @author xiongz
 * @date 2018/9/20
 */
public class DropDownMenu extends LinearLayout {

    //顶部菜单布局
    private LinearLayout tabMenuView;
    //底部容器，包含popupMenuViews，maskView
    private FrameLayout containerView;
    //弹出菜单父布局
    private FrameLayout popupMenuViews;
    //遮罩半透明View，点击可关闭DropDownMenu
    private View maskView;
    //tabMenuView里面选中的tab位置，-1表示未选中
    private int curTab = -1;

    //tab选中颜色
    private int textSelectedColor = 0xff890c85;
    //tab未选中颜色
    private int textUnselectedColor = 0xff111111;
    //遮罩颜色
    private int maskColor = 0x88888888;
    //tab字体大小
    private int menuTextSize = 14;

    //tab选中图标
    private int menuSelectedIcon;
    //tab未选中图标
    private int menuUnselectedIcon;
    //弹窗占比
    private float menuHeighPercent = 0.5f;
    //向上箭头
    private IconDrawable mUpDrawable;
    //向下箭头
    private IconDrawable mDownDrawable;

    public DropDownMenu(Context context) {
        super(context, null);
    }

    public DropDownMenu(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DropDownMenu(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        setOrientation(VERTICAL);

        //为DropDownMenu添加自定义属性
        int menuBackgroundColor = 0xffffffff;
        int underlineColor = 0xffcccccc;
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.DropDownMenu);
        underlineColor = a.getColor(R.styleable.DropDownMenu_ddunderlineColor, underlineColor);
        textSelectedColor = a.getColor(R.styleable.DropDownMenu_ddtextSelectedColor, textSelectedColor);
        textUnselectedColor = a.getColor(R.styleable.DropDownMenu_ddtextUnselectedColor, textUnselectedColor);
        menuBackgroundColor = a.getColor(R.styleable.DropDownMenu_ddmenuBackgroundColor, menuBackgroundColor);
        maskColor = a.getColor(R.styleable.DropDownMenu_ddmaskColor, maskColor);
        menuTextSize = a.getDimensionPixelSize(R.styleable.DropDownMenu_ddmenuTextSize, menuTextSize);
        menuSelectedIcon = a.getResourceId(R.styleable.DropDownMenu_ddmenuSelectedIcon, menuSelectedIcon);
        menuUnselectedIcon = a.getResourceId(R.styleable.DropDownMenu_ddmenuUnselectedIcon, menuUnselectedIcon);
        menuHeighPercent = a.getFloat(R.styleable.DropDownMenu_ddmenuMenuHeightPercent, menuHeighPercent);
        a.recycle();

        mUpDrawable = new IconDrawable(getContext(), AppIcons.ic_popup_up).colorRes(R.color.colorPrimary).actionBarSize();
        mUpDrawable.setBounds(0, 0 , dpTpPx(7), dpTpPx(7));
        mDownDrawable = new IconDrawable(getContext(), AppIcons.ic_popup_down).colorRes(R.color.icon_gray).actionBarSize();
        mDownDrawable.setBounds(0, 0 , dpTpPx(7), dpTpPx(7));

        //初始化tabMenuView并添加到tabMenuView
        tabMenuView = new LinearLayout(context);
        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        tabMenuView.setOrientation(HORIZONTAL);
        tabMenuView.setBackgroundColor(menuBackgroundColor);
        tabMenuView.setLayoutParams(params);
        addView(tabMenuView, 0);

        //为tabMenuView添加下划线
        View underLine = new View(getContext());
        underLine.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dpTpPx(1.0f)));
        underLine.setBackgroundColor(underlineColor);
        addView(underLine, 1);

        //初始化containerView并将其添加到DropDownMenu
        containerView = new FrameLayout(context);
        containerView.setLayoutParams(new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT));
        addView(containerView, 2);

    }

    /**
     * 初始化DropDownMenu
     *
     * @param tabTexts
     * @param popupViews
     * @param contentView
     */
    public void setDropDownMenu(@NonNull List<String> tabTexts, @NonNull List<View> popupViews, @NonNull View contentView) {
        if (tabTexts.size() != popupViews.size()) {
            throw new IllegalArgumentException("params not match, tabTexts.size() should be equal popupViews.size()");
        }

        for (int i = 0; i < tabTexts.size(); i++) {
            addTab(tabTexts, i);
        }
        containerView.addView(contentView, 0);

        maskView = new View(getContext());
        maskView.setLayoutParams(new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT));
        maskView.setBackgroundColor(maskColor);
        maskView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                closeMenu();
            }
        });
        containerView.addView(maskView, 1);
        maskView.setVisibility(GONE);
        if (containerView.getChildAt(2) != null) {
            containerView.removeViewAt(2);
        }

        popupMenuViews = new FrameLayout(getContext());
        popupMenuViews.setLayoutParams(new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, (int) (ScreenUtils.getScreenHeight() * menuHeighPercent)));
        popupMenuViews.setVisibility(GONE);
        containerView.addView(popupMenuViews, 2);

        for (int i = 0; i < popupViews.size(); i++) {
            popupViews.get(i).setLayoutParams(new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            popupMenuViews.addView(popupViews.get(i), i);
        }

    }

    /**
     * 添加tab
     * @param tabTexts
     * @param i
     */
    private void addTab(@NonNull List<String> tabTexts, int i) {
        final LinearLayout tabLayout = new LinearLayout(getContext());
        tabLayout.setLayoutParams(new LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1.0f));
        tabLayout.setGravity(Gravity.CENTER);

        final TextView tab = new TextView(getContext());
        tab.setSingleLine();
        tab.setEllipsize(TextUtils.TruncateAt.END);
        tab.setGravity(Gravity.CENTER);
        tab.setTextSize(TypedValue.COMPLEX_UNIT_PX, menuTextSize);
        tab.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT));
        tab.setTextColor(textUnselectedColor);
        tab.setCompoundDrawablePadding(dpTpPx(3));
        tab.setCompoundDrawables(null, null, mDownDrawable, null);
        tab.setText(tabTexts.get(i));
        tab.setPadding(dpTpPx(5), dpTpPx(12), dpTpPx(5), dpTpPx(12));
        tabLayout.addView(tab);
        tabLayout.setTag(i);
        //添加点击事件
        tabLayout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                int tag = (int) v.getTag();
                switchMenu(tag);
            }
        });
        tabMenuView.addView(tabLayout);
    }

    /**
     * 设置当前选中的tab
     *
     * @param curTab
     */
    public void setCurTab(int curTab) {
        this.curTab = curTab;
    }

    /**
     * 改变tab文字
     *
     * @param text
     */
    public void setTabText(String text) {
        if (curTab != -1) {
            LinearLayout tabLayout = (LinearLayout) tabMenuView.getChildAt(curTab);
            TextView tab = (TextView) tabLayout.getChildAt(0);
            tab.setText(text);
        }
    }

    /**
     * 关闭菜单
     */
    public void closeMenu() {
        if (curTab != -1) {
            LinearLayout tabLayout = (LinearLayout) tabMenuView.getChildAt(curTab);
            TextView tab = (TextView) tabLayout.getChildAt(0);
            tab.setTextColor(textUnselectedColor);
            tab.setCompoundDrawables(null, null, mDownDrawable, null);
            popupMenuViews.setVisibility(View.GONE);
            popupMenuViews.setAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.popup_out));
            maskView.setVisibility(GONE);
            maskView.setAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.alpha_out));
            curTab = -1;
        }
    }

    /**
     * 打开菜单
     */
    public void openMenu(int tag) {
        popupMenuViews.setVisibility(View.VISIBLE);
        maskView.setVisibility(VISIBLE);
        // 未弹出的情况下才显示弹出动画
        if (curTab == -1) {
            popupMenuViews.setAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.popup_in));
            maskView.setAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.alpha_in));
        }
        // 切换tab
        for (int i = 0; i < tabMenuView.getChildCount(); i++) {
            LinearLayout tabLayout = (LinearLayout) tabMenuView.getChildAt(i);
            TextView tab = (TextView) tabLayout.getChildAt(0);
            if (tag == i) {
                tab.setTextColor(textSelectedColor);
                tab.setCompoundDrawables(null, null, mUpDrawable, null);
                popupMenuViews.getChildAt(i).setVisibility(VISIBLE);
            } else {
                tab.setTextColor(textUnselectedColor);
                tab.setCompoundDrawables(null, null, mDownDrawable, null);
                popupMenuViews.getChildAt(i).setVisibility(GONE);
            }
        }
        curTab = tag;
    }

    /**
     * DropDownMenu是否处于可见状态
     *
     * @return
     */
    public boolean isShowing() {
        return curTab != -1;
    }

    /**
     * 切换菜单
     *
     * @param tag
     */
    private void switchMenu(int tag) {
        if (curTab == tag) { // 点击当前tab
            closeMenu();
        } else { // 点击非当前tab
            openMenu(tag);
        }
    }

    /**
     * 切换菜单
     *
     * @param target
     */
    private void switchMenu2(View target) {
        for (int i = 0; i < tabMenuView.getChildCount(); i++) {
            if (target == tabMenuView.getChildAt(i)) {
                if (curTab == i) {
                    closeMenu();
                } else {
                    if (curTab == -1) {
                        popupMenuViews.setVisibility(View.VISIBLE);
                        popupMenuViews.setAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.popup_in));
                        maskView.setVisibility(VISIBLE);
                        maskView.setAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.alpha_in));
                        popupMenuViews.getChildAt(i).setVisibility(View.VISIBLE);
                    } else {
                        popupMenuViews.getChildAt(i).setVisibility(View.VISIBLE);
                    }
                    curTab = i;
                    LinearLayout tabLayout = (LinearLayout) tabMenuView.getChildAt(curTab);
                    TextView tab = (TextView) tabLayout.getChildAt(0);
                    tab.setTextColor(textSelectedColor);
                    tab.setCompoundDrawables(null, null, mUpDrawable, null);
                }
            } else {
                LinearLayout tabLayout = (LinearLayout) tabMenuView.getChildAt(curTab);
                TextView tab = (TextView) tabLayout.getChildAt(0);
                tab.setTextColor(textUnselectedColor);
                tab.setCompoundDrawables(null, null, mDownDrawable, null);
                popupMenuViews.getChildAt(i).setVisibility(View.GONE);
            }
        }
    }

    public int dpTpPx(float value) {
        DisplayMetrics dm = getResources().getDisplayMetrics();
        return (int) (TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, dm) + 0.5);
    }
}
