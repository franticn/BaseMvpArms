package cn.dao.app.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import cn.dao.app.di.module.PracticeModule

import com.jess.arms.di.scope.FragmentScope
import cn.dao.app.mvp.ui.fragment.PracticeFragment


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 08/26/2019 21:43
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@FragmentScope
@Component(modules = arrayOf(PracticeModule::class), dependencies = arrayOf(AppComponent::class))
interface PracticeComponent {
    fun inject(fragment: PracticeFragment)
}
