package cn.dao.app.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import cn.dao.app.di.module.KindnessModule

import com.jess.arms.di.scope.FragmentScope
import cn.dao.app.mvp.ui.fragment.KindnessFragment


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 08/26/2019 21:44
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@FragmentScope
@Component(modules = arrayOf(KindnessModule::class), dependencies = arrayOf(AppComponent::class))
interface KindnessComponent {
    fun inject(fragment: KindnessFragment)
}
