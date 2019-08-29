package cn.dao.app.di.module

import com.jess.arms.di.scope.FragmentScope

import dagger.Module
import dagger.Provides

import cn.dao.app.mvp.contract.PracticeContract
import cn.dao.app.mvp.model.PracticeModel


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
@Module
//构建PracticeModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class PracticeModule(private val view: PracticeContract.View) {
    @FragmentScope
    @Provides
    fun providePracticeView(): PracticeContract.View {
        return this.view
    }

    @FragmentScope
    @Provides
    fun providePracticeModel(model: PracticeModel): PracticeContract.Model {
        return model
    }
}
