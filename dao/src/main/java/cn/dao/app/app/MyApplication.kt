package cn.dao.app.app

import android.annotation.SuppressLint
import android.content.Context
import androidx.multidex.MultiDex
import com.blankj.utilcode.util.LogUtils
import com.blankj.utilcode.util.ProcessUtils
import com.jess.arms.base.BaseApplication
import com.lxj.xpopup.XPopup
import io.reactivex.plugins.RxJavaPlugins
import cn.dao.app.R


/**
 * @author fang.xc@outlook.com
 * @date 2019-06-03
 */
open class MyApplication : BaseApplication() {
    companion object {
        /**
         * Application实例
         */
        var instance: MyApplication? = null
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        initFlipper()
        setMaxTimeOut()
        initDataBase()
        initBugly()
        if (ProcessUtils.isMainProcess()) {
            initUmeng()
        }
        initPopup()
        initRxJavaError()
        initImagePicker()
        initDownload()
    }

    /**
     * 初始化文件下载器
     */
    private fun initDownload() {
    }

    /**
     * 初始化图片选择器
     */
    private fun initImagePicker() {

    }

    /**
     * 初始化Flipper 用于调试 查看bug
     */
    private fun initFlipper() {

    }

    /**
     * 初始化友盟统计
     */
    private fun initUmeng() {

    }

    /**
     * 初始化数据库
     */
    private fun initDataBase() {

    }

    /**
     * 初始化Bugly
     */
    @SuppressLint("MissingPermission")
    private fun initBugly() {

    }

    /**
     * 初始化RxJava错误处理类
     */
    private fun initRxJavaError() {
        RxJavaPlugins.setErrorHandler { throwable ->
            LogUtils.e(throwable)
        }
    }

    /**
     * 初始化 xPopup
     */
    private fun initPopup() {
        XPopup.setPrimaryColor(resources.getColor(R.color.colorPrimaryDark))
    }

    /**
     * 解决
     * TimeoutException android.content.res.AssetManager.finalize() timed out after 120 s
     */
    private fun setMaxTimeOut() {
        try {
            val clazz = Class.forName("java.lang.Daemons")
            val field = clazz.getDeclaredField("MAX_FINALIZE_NANOS")
            field.isAccessible = true
            field.set(null, Int.MAX_VALUE)
        } catch (e: Exception) {
            e.printStackTrace();
        }
    }


}