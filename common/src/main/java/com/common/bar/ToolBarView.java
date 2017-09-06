package com.common.bar;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.common.R;

/**
 * 作者：wangdakuan
 * 日期：2017/9/4 13:05
 * 邮箱：wangdakuan@kjtpay.com.cn
 * 功能：
 */
public class ToolBarView extends Toolbar {

    private Context context;
    private LayoutInflater inflater;

    private Integer mImgBack; //返回图片
    private String mTextTitle; //标题文字
    private String mRightText; //右边文字
    private Integer mRightTextColor; //右边文字字体颜色
    private float mRightTextSize; //右边字体大小
    private Integer mRightImg; //右边控件图片
    private boolean mIsShowRightPic; //右边是否是使用图片 默认为不使用 false
    private boolean mIsShowRight; //右边控件是否显示 默认为不显示 false
    private boolean mIsShowLeft; //左边返回控件是否显示  默认为显示  true

    private static final int DEFAULT_TIPS_TEXT_SIZE = 14;
    private ImageView mImagBack; //左边返回按钮
    private TextView mTvTitle; //标题
    private TextView mTvRight; //右边文字控件
    private ImageView mImgRight; //右边图片控件

    public ToolBarView(Context context) {
        super(context);
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public ToolBarView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        inflater = LayoutInflater.from(context);
        init(attrs);
    }

    public ToolBarView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        inflater = LayoutInflater.from(context);
        init(attrs);
    }

    /**
     * 自定义属性初始化
     *
     * @param attrs
     */
    private void init(AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ToolBarView);
        try {
            mImgBack = a.getInteger(R.styleable.ToolBarView_imgBack, R.mipmap.nav_back);
            mTextTitle = a.getString(R.styleable.ToolBarView_textTitle);
            mRightText = a.getString(R.styleable.ToolBarView_rightText);
            mRightTextColor = a.getColor(R.styleable.ToolBarView_rightTextColor, getResources().getColor(android.R.color.white));
            mRightTextSize = a.getDimension(R.styleable.ToolBarView_rightTextSize, TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, DEFAULT_TIPS_TEXT_SIZE, getResources().getDisplayMetrics()));
            mRightImg = a.getInteger(R.styleable.ToolBarView_rightImg, 0);
            mIsShowRightPic = a.getBoolean(R.styleable.ToolBarView_isShowRightPic, false);
            mIsShowRight = a.getBoolean(R.styleable.ToolBarView_isShowRight, false);
            mIsShowLeft = a.getBoolean(R.styleable.ToolBarView_isShowLeft, true);
        } finally {
            a.recycle();
        }
        initView();
        doBusiness();
    }

    /**
     * 控件初始化
     */
    private void initView() {
        View view = inflater.inflate(R.layout.view_toolbar, this);
        mImagBack = view.findViewById(R.id.img_back);
        mTvTitle = view.findViewById(R.id.tv_title);
        mTvRight = view.findViewById(R.id.tv_right);
        mImgRight = view.findViewById(R.id.img_right);
    }

    /**
     * 赋值
     */
    private void doBusiness() {
        mTvTitle.setText(mTextTitle);
        mTvRight.setText(mRightText);
        mTvRight.setTextColor(mRightTextColor);
        mTvRight.setTextSize(mRightTextSize);
        mImgRight.setImageResource(mRightImg);
        if (!mIsShowRight) {
            mTvRight.setVisibility(View.INVISIBLE);
            mImgRight.setVisibility(View.INVISIBLE);
        } else {
            mTvRight.setVisibility(mIsShowRightPic ? View.INVISIBLE : View.VISIBLE);
            mImgRight.setVisibility(mIsShowRightPic ? View.VISIBLE : View.INVISIBLE);
        }
        mImagBack.setImageResource(mImgBack);
        mImagBack.setVisibility(mIsShowLeft ? View.VISIBLE : View.INVISIBLE);
    }

    /**
     * 返回按钮图片
     *
     * @param mImgBack
     */
    public ToolBarView setImgBack(Integer mImgBack) {
        this.mImgBack = mImgBack;
        return this;
    }

    /**
     * 标题
     *
     * @param mTextTitle
     */
    public ToolBarView setTextTitle(String mTextTitle) {
        this.mTextTitle = mTextTitle;
        return this;
    }

    /**
     * 右边按钮文字
     *
     * @param mRightText
     */
    public ToolBarView setRightText(String mRightText) {
        this.mRightText = mRightText;
        return this;
    }

    /**
     * 右边按钮文字颜色
     *
     * @param mRightTextColor
     */
    public ToolBarView setRightTextColor(Integer mRightTextColor) {
        this.mRightTextColor = mRightTextColor;
        return this;
    }

    /**
     * 右边按钮文字大小
     *
     * @param mRightTextSize
     */
    public ToolBarView setRightTextSize(float mRightTextSize) {
        this.mRightTextSize = mRightTextSize;
        return this;
    }

    /**
     * 右边按钮图片
     *
     * @param mRightImg
     */
    public ToolBarView setRightImg(Integer mRightImg) {
        this.mRightImg = mRightImg;
        return this;
    }

    /**
     * 是否显示右边按钮图片（显示图片按钮就不会显示文字按钮）
     *
     * @param mIsShowRightPic
     */
    public ToolBarView setIsShowRightPic(boolean mIsShowRightPic) {
        this.mIsShowRightPic = mIsShowRightPic;
        return this;
    }

    /**
     * 是否显示右边按钮 默认为不显示
     *
     * @param mIsShowRight
     */
    public ToolBarView setIsShowRight(boolean mIsShowRight) {
        this.mIsShowRight = mIsShowRight;
        return this;
    }

    /**
     * 是否显示左边返回按钮 默认显示
     *
     * @param mIsShowLeft
     */
    public ToolBarView setIsShowLeft(boolean mIsShowLeft) {
        this.mIsShowLeft = mIsShowLeft;
        return this;
    }

    /**
     * 完成
     */
    public void show() {
        doBusiness();
    }
}
