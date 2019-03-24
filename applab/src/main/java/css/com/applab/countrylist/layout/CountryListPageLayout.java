
package css.com.applab.countrylist.layout;


import android.content.Context;
import android.widget.LinearLayout;

import css.com.applab.countrylist.CountryListView;

public class CountryListPageLayout extends BasePageLayout {
    public CountryListPageLayout(Context c) {
        super(c, true);
    }

    protected void onCreateContent(LinearLayout parent) {
        CountryListView countryList = new CountryListView(this.context);
        countryList.setId(1881145362);
        LayoutParams listParams = new LayoutParams(-1, -2, 1.0F);
        countryList.setLayoutParams(listParams);
        parent.addView(countryList);
    }
}
