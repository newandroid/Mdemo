package css.com.applab.countrylist.layout;


import android.content.Context;
import android.widget.LinearLayout;

import css.com.applab.countrylist.ContactsListView;

public class ContactListPageLayout extends BasePageLayout {
    public ContactListPageLayout(Context c) {
        super(c, true);
    }

    protected void onCreateContent(LinearLayout parent) {
        ContactsListView contactsList = new ContactsListView(this.context);
        contactsList.setId(1881145361);
        LayoutParams listParams = new LayoutParams(-1, -2, 1.0F);
        contactsList.setLayoutParams(listParams);
        parent.addView(contactsList);
    }
}
