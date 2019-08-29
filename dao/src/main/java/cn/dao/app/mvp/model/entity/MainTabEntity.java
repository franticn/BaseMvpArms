package cn.dao.app.mvp.model.entity;

import com.flyco.tablayout.listener.CustomTabEntity;

/**
 * @author fang.xc@outlook.com
 * @date 2019-08-26
 */
public class MainTabEntity implements CustomTabEntity {
    String title;
    int selectedIcon;
    int unSelectedIcon;

    public MainTabEntity(
            String _title,
            int _selectedIcon,
            int _unSelectedIcon
            ) {
        this.title = _title;
        this.selectedIcon = _selectedIcon;
        this.unSelectedIcon = _unSelectedIcon;
    }

    @Override
    public String getTabTitle() {
        return this.title;
    }

    @Override
    public int getTabSelectedIcon() {
        return this.selectedIcon;
    }

    @Override
    public int getTabUnselectedIcon() {
        return this.unSelectedIcon;
    }
}
