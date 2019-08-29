package cn.dao.app.app.base

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.view.Gravity
import android.view.View
import androidx.core.content.ContextCompat
import com.blankj.utilcode.util.BarUtils
import com.blankj.utilcode.util.ToastUtils
import com.jess.arms.base.BaseActivity
import com.jess.arms.mvp.IPresenter
import com.jess.arms.mvp.IView
import com.jess.arms.utils.ArmsUtils
import com.lxj.xpopup.XPopup
import com.wuhenzhizao.titlebar.widget.CommonTitleBar
import cn.dao.app.R

/**
 * @author fang.xc@outlook.com
 * @date 2019/06/03
 */
abstract class BaseArmActivity<P : IPresenter> : BaseActivity<P>(), IView, View.OnClickListener {
//    /**
//     * 仿ios加载框
//     */
//    var mProgressDialog: KProgressHUD? = null
    /**
     * 是否需要沉浸式状态栏
     */
    var needTransStatusBar = true

    var colorRes: Int = 0

    // 两次点击按钮之间的点击间隔不能少于1000毫秒
    private val MIN_CLICK_DELAY_TIME = 1500L


    lateinit var mXPopupBuilder: XPopup.Builder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        //初始化ProgressBar
//        mProgressDialog = KProgressHUD.create(this)
//                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
//                .setLabel("加载中...")
        //初始化Xpopup.builder
        mXPopupBuilder = XPopup.Builder(this)
        ToastUtils.setGravity(Gravity.CENTER, 0, 0)
        initTitleBar()
    }

    private fun initTitleBar() {
        val titleBar = findViewById<CommonTitleBar>(R.id.titleBar)
        if (titleBar != null && titleBar.centerTextView != null) {
            titleBar.centerTextView.typeface = Typeface.defaultFromStyle(Typeface.BOLD)
        }

    }


    /**
     * 显示信息
     *
     * @param message 消息内容, 不能为 `null`
     */
    override fun showMessage(message: String) {
        checkNotNull(message)
        ToastUtils.showShort(message)
    }


    open fun showErrorMessage(msg: String) {
        mXPopupBuilder
                .asConfirm("错误", msg) {
                    //confirm 确认操作

                }
                .show()
    }

    /**
     * 显示'加载中...'的loading控件
     */
    override fun showLoading() {
        this.showLoading(getString(R.string.loading))
    }

    /**
     * 根据传入的msg显示对应的loading控件
     */
    open fun showLoading(msg: String?) {
//        if (mProgressDialog != null && !TextUtils.isEmpty(msg)) {
//            mProgressDialog!!.dismiss()
//            mProgressDialog!!
//                    .setLabel(msg)
//                    .show()
//        }
    }

    /**
     * 隐藏loading控件
     */
    override fun hideLoading() {
        hideLoading(500)
    }

    open fun hideLoading(mills: Long = 500) {
//        if (mills <= 0) {
//            if (mProgressDialog != null) {
//                mProgressDialog!!.dismiss()
//            }
//        } else {
//            //延迟mills ms结束,防止用户看见loading框闪一下没了
//            Flowable.interval(mills, TimeUnit.MILLISECONDS)
//                    .observeOn(AndroidSchedulers.mainThread())
//                    .compose(RxLifecycleUtils.bindToLifecycle(this as IView))
//                    .subscribe {
//                        if (mProgressDialog != null) {
//                            mProgressDialog!!.dismiss()
//                        }
//
//                    }
//        }

    }

    /**
     * 跳转到Login页面
     */
    open fun go2Login() {


    }

    /**
     * 启动页面
     */
    override fun launchActivity(intent: Intent) {
        checkNotNull(intent)
        ArmsUtils.startActivity(intent)
    }

    override fun onDestroy() {
//        if (mProgressDialog != null) {
//            this.mProgressDialog!!.dismiss()
//            this.mProgressDialog = null
//        }
        super.onDestroy()
    }

    /**
     * 结束
     */
    override fun killMyself() {
        finish()
    }

    /**
     * 是否需要沉浸式状态栏
     * @param need -> true 需要  反之 不需要
     */
    fun needTransStatusBar(need: Boolean, colorRes: Int?) {
        this.needTransStatusBar = need
        if (colorRes != null) {
            this.colorRes = colorRes
        } else {
            this.colorRes = ContextCompat.getColor(this, R.color.white)
        }

    }

    override fun initData(savedInstanceState: Bundle?) {
        if (this.needTransStatusBar) {
            BarUtils.setStatusBarColor(this, if (this.colorRes != 0) this.colorRes else ContextCompat.getColor(this, R.color.white))
        }
    }

    /**
     * 配置点击事件
     */
    fun configClickListener(vararg views: View?) {
        for (view in views) {
            if (view != null) {
                view.setOnClickListener(this@BaseArmActivity)
            }
        }
    }


    override fun onClick(v: View?) {
        when (v?.id) {
            else -> {
            }
        }
    }
}