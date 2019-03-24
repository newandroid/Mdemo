package css.com.applab.countrylist;


import android.content.Context;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.zip.GZIPInputStream;

import css.com.applab.R;

public class SearchEngine {
    private static final String DB_FILE = "smssdk_pydb";
    private static HashMap<String, Object> hanzi2Pinyin;
    private boolean caseSensitive;
    private ArrayList<SearchIndex> index;

    public SearchEngine() {
    }

    public static void prepare(final Context context, final Runnable afterPrepare) {
        Runnable act = new Runnable() {
            public void run() {
                String var1 = "smssdk_pydb";
                synchronized("smssdk_pydb") {
                    if (SearchEngine.hanzi2Pinyin == null || SearchEngine.hanzi2Pinyin.size() <= 0) {
                        try {
                            int resId = R.getRawRes(context, "smssdk_pydb");
                            if (resId <= 0) {
                                SearchEngine.hanzi2Pinyin = new HashMap();
                            } else {
                                InputStream is = context.getResources().openRawResource(resId);
                                GZIPInputStream gzis = new GZIPInputStream(is);
                                InputStreamReader isr = new InputStreamReader(gzis);
                                BufferedReader br = new BufferedReader(isr);
                                String json = br.readLine();
                                br.close();
                                SearchEngine.hanzi2Pinyin = (new Hashon()).fromJson(json);
                            }
                        } catch (Throwable var9) {
                            SMSLog.getInstance().w(var9);
                            SearchEngine.hanzi2Pinyin = new HashMap();
                        }
                    }

                    if (afterPrepare != null) {
                        afterPrepare.run();
                    }

                }
            }
        };
        if (afterPrepare != null) {
            (new Thread(act)).start();
        } else {
            act.run();
        }

    }

    public void setCaseSensitive(boolean caseSensitive) {
        this.caseSensitive = caseSensitive;
    }

    public void setIndex(ArrayList<String> index) {
        this.index = new ArrayList();
        Iterator var2 = index.iterator();

        while(var2.hasNext()) {
            String i = (String)var2.next();
            this.index.add(new SearchEngine.SearchIndex(i, hanzi2Pinyin));
        }

    }

    public ArrayList<String> match(String token) {
        ArrayList<String> res = new ArrayList();
        if (this.index == null) {
            return res;
        } else {
            Iterator var3 = this.index.iterator();

            while(var3.hasNext()) {
                SearchEngine.SearchIndex si = (SearchEngine.SearchIndex)var3.next();
                if (si.match(token, this.caseSensitive)) {
                    res.add(si.getText());
                }
            }

            return res;
        }
    }

    private static class SearchIndex {
        private String text;
        private ArrayList<String> pinyin;
        private ArrayList<String> firstLatters;

        public SearchIndex(String text, HashMap<String, Object> hanzi2Pinyin) {
            this.text = text;
            this.pinyin = new ArrayList();
            this.firstLatters = new ArrayList();
            this.createPinyinList(hanzi2Pinyin);
        }

        private void createPinyinList(HashMap<String, Object> hanzi2Pinyin) {
            if (hanzi2Pinyin != null && hanzi2Pinyin.size() > 0) {
                char[] cArr = this.text.toCharArray();
                ArrayList<String[]> pinyin = new ArrayList();
                char[] var4 = cArr;
                int var5 = cArr.length;

                for(int var6 = 0; var6 < var5; ++var6) {
                    char c = var4[var6];
                    String s = String.valueOf(c);
                    ArrayList<HashMap<String, Object>> yins = (ArrayList)hanzi2Pinyin.get(s);
                    int size = yins == null ? 0 : yins.size();
                    String[] py = new String[size];

                    for(int i = 0; i < size; ++i) {
                        String yin = (String)((HashMap)yins.get(i)).get("yin");
                        if ("none".equals(yin)) {
                            yin = "";
                        }

                        py[i] = yin;
                    }

                    pinyin.add(py);
                }

                HashSet<String> pyRes = new HashSet();
                HashSet<String> flRes = new HashSet();
                this.toPinyinArray("", "", pyRes, flRes, pinyin);
                this.pinyin.addAll(pyRes);
                this.firstLatters.addAll(flRes);
            }

        }

        private void toPinyinArray(String base, String firstLatter, HashSet<String> pyRes, HashSet<String> flRes, ArrayList<String[]> pys) {
            if (pys.size() > 0) {
                String[] py = (String[])pys.get(0);
                ArrayList<String[]> cpys = new ArrayList();
                cpys.addAll(pys);
                cpys.remove(0);
                String[] var8 = py;
                int var9 = py.length;

                for(int var10 = 0; var10 < var9; ++var10) {
                    String y = var8[var10];
                    if (y.length() > 0) {
                        this.toPinyinArray(base + y, firstLatter + y.charAt(0), pyRes, flRes, cpys);
                    } else {
                        this.toPinyinArray(base, firstLatter, pyRes, flRes, cpys);
                    }
                }
            } else {
                pyRes.add(base);
                flRes.add(firstLatter);
            }

        }

        public String getText() {
            return this.text;
        }

        private boolean match(String token, boolean caseSensitive) {
            if (token != null && token.trim().length() > 0) {
                String keyToSearch = token;
                if (!caseSensitive) {
                    keyToSearch = token.toLowerCase();
                }

                if (this.text != null && this.text.toLowerCase().contains(keyToSearch)) {
                    return true;
                } else {
                    Iterator var4 = this.pinyin.iterator();

                    String fl;
                    do {
                        if (!var4.hasNext()) {
                            var4 = this.firstLatters.iterator();

                            do {
                                if (!var4.hasNext()) {
                                    return false;
                                }

                                fl = (String)var4.next();
                            } while(!fl.contains(keyToSearch));

                            return true;
                        }

                        fl = (String)var4.next();
                    } while(!fl.contains(keyToSearch));

                    return true;
                }
            } else {
                return true;
            }
        }

        public String toString() {
            HashMap<String, Object> map = new HashMap();
            map.put("text", this.text);
            map.put("pinyin", this.pinyin);
            map.put("firstLatters", this.firstLatters);
            return map.toString();
        }
    }
}
