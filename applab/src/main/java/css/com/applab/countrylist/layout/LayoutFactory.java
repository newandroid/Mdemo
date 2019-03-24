//
package css.com.applab.countrylist.layout;

import android.content.Context;
import android.view.ViewGroup;

public class LayoutFactory {
    public LayoutFactory() {
    }

    static ViewGroup create(Context context, String name) {
        ViewGroup v = null;
        if (name.equals("smssdk_back_verify_dialog")) {
            v = BackVerifyDialogLayout.create(context);
        } else if (name.equals("smssdk_contact_detail_page")) {
            ContactDetailPageLayout page = new ContactDetailPageLayout(context);
            v = page.getLayout();
        } else if (name.equals("smssdk_contact_list_page")) {
            ContactListPageLayout page = new ContactListPageLayout(context);
            v = page.getLayout();
        } else if (name.equals("smssdk_contacts_listview_item")) {
            v = ContactsListviewItemLayout.create(context);
        } else if (name.equals("smssdk_country_list_page")) {
            CountryListPageLayout page = new CountryListPageLayout(context);
            v = page.getLayout();
        } else if (name.equals("smssdk_input_identify_num_page")) {
            IdentifyNumPageLayout page = new IdentifyNumPageLayout(context);
            v = page.getLayout();
        } else if (name.equals("smssdk_progress_dialog")) {
            v = cn.smssdk.gui.layout.ProgressDialogLayout.create(context);
        } else if (name.equals("smssdk_register_page")) {
            cn.smssdk.gui.layout.RegisterPageLayout layout = new cn.smssdk.gui.layout.RegisterPageLayout(context);
            v = layout.getLayout();
        } else if (name.equals("smssdk_send_msg_dialog")) {
            v = cn.smssdk.gui.layout.SendMsgDialogLayout.create(context);
        }

        return (ViewGroup)v;
    }
}
