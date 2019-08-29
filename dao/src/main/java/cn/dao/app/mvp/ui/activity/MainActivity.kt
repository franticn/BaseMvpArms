package cn.dao.app.mvp.ui.activity

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.flyco.tablayout.listener.CustomTabEntity
import com.flyco.tablayout.listener.OnTabSelectListener

import com.jess.arms.di.component.AppComponent

import cn.dao.app.di.component.DaggerMainComponent
import cn.dao.app.di.module.MainModule
import cn.dao.app.mvp.contract.MainContract
import cn.dao.app.mvp.presenter.MainPresenter
import cn.dao.app.app.base.BaseArmActivity

import cn.dao.app.R
import cn.dao.app.mvp.ui.fragment.HomeFragment
import cn.dao.app.mvp.ui.fragment.KindnessFragment
import cn.dao.app.mvp.ui.fragment.MineFragment
import cn.dao.app.mvp.ui.fragment.PracticeFragment
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


/**
 *
 */
class MainActivity : BaseArmActivity<MainPresenter>(), MainContract.View, View.OnClickListener {


    @Inject
    lateinit var mFragments: ArrayList<Fragment>

    @Inject
    lateinit var mTabEntityList: ArrayList<CustomTabEntity>

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerMainComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .mainModule(MainModule(this))
                .build()
                .inject(this)
    }


    override fun initView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_main //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }


    override fun initData(savedInstanceState: Bundle?) {
        mFragments.add(HomeFragment.newInstance())
        mFragments.add(PracticeFragment.newInstance())
        mFragments.add(KindnessFragment.newInstance())
        mFragments.add(MineFragment.newInstance())
        initUI()
    }

    /**
     * 初始化UI
     */
    private fun initUI() {
        configClickListener()

        //初始化ViewPager和TabLayout
        tabLayout.setTabData(mTabEntityList, this, R.id.flContent, mFragments)
        tabLayout.setOnTabSelectListener(object: OnTabSelectListener{
            override fun onTabSelect(position: Int) {

            }

            override fun onTabReselect(position: Int) {
            }

        })

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            else -> {
            }
        }
    }

}
