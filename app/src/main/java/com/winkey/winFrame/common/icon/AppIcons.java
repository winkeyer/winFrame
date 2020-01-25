package com.winkey.winFrame.common.icon;

import com.joanzapata.iconify.Icon;

/**
 * APP图标库
 * @author xiongz
 * @date 2019-07-18
 */
public enum AppIcons implements Icon {

    ic_close('\ue7f5'),
    bg_circle('\ue601'),
    ic_scan('\ue630'),
    ic_contract('\ue61d'),
    ic_insurance('\ue6ba'),
    ic_monitor('\ue6ef'),
    ic_inspection('\ue625'),
    ic_repair('\ue6a5'),
    ic_train('\ue701'),
    ic_rescue('\ue676'),
    ic_lift('\ue63a'),
    ic_location('\ue635'),
    ic_edit('\ue636'),
    ic_banner_click('\ue602'),
    ic_camera_upload('\ue6a8'),
    ic_down('\ue645'),
    ic_pwd('\ue634'),
    ic_setting('\ue614'),
    ic_repair_plan('\ue6a6'),
    ic_repair_order('\ue617'),
    ic_big_repair_plan('\ue631'),
    ic_purchase('\ue60a'),
    ic_report('\ue67f'),
    ic_pay_info('\ue6f9'),
    ic_project('\ue680'),
    ic_todo_list('\ue6a9'),
    ic_base_info('\ue660'),
    ic_assess_info('\ue65b'),
    ic_plus('\ue67e'),
    ic_minus('\ue67d'),
    ic_popup_up('\ue60b'),
    ic_popup_down('\ue60c'),
    ic_btn_phone('\ue607'),
    ic_img('\ue611'),
    ic_image_remove('\ue664'),
    ic_clear('\ue61f'),
    ic_template('\ue632'),
    ic_menu_home('\ue600');

    private char character;

    AppIcons(char character) {
        this.character = character;
    }

    @Override
    public String key() {
        return name().replace('_', '-');
    }

    @Override
    public char character() {
        return character;
    }
}
