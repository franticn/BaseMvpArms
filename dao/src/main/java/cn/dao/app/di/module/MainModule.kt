package cn.dao.app.di.module

import androidx.fragment.app.Fragment
import com.flyco.tablayout.listener.CustomTabEntity
import com.jess.arms.di.scope.ActivityScope

import dagger.Module
import dagger.Provides
import cn.dao.app.R

import cn.dao.app.mvp.contract.MainContract
import cn.dao.app.mvp.model.MainModel
import cn.dao.app.mvp.model.entity.MainTabEntity


@Module
//构建MainModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class MainModule(private val view: MainContract.View) {
    @ActivityScope
    @Provides
    fun provideMainView(): MainContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideMainModel(model: MainModel): MainContract.Model {
        return model
    }

    @ActivityScope
    @Provides
    fun provideFragmentList():ArrayList<Fragment>{
        return arrayListOf()
    }

    @ActivityScope
    @Provides
    fun provideTabEntityList():ArrayList<CustomTabEntity>{
        return arrayListOf(
                cn.dao.app.mvp.model.entity.MainTabEntity("首页", R.mipmap.ic_home_selected, R.mipmap.ic_home),
                cn.dao.app.mvp.model.entity.MainTabEntity("修行", R.mipmap.ic_practice_selected, R.mipmap.ic_practice),
                cn.dao.app.mvp.model.entity.MainTabEntity("功德", R.mipmap.ic_kindness_selected, R.mipmap.ic_kindness),
                cn.dao.app.mvp.model.entity.MainTabEntity("我的", R.mipmap.ic_mine_selected, R.mipmap.ic_mine)
        )
    }
}
