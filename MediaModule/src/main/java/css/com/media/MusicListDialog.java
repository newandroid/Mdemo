package css.com.media;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import css.com.testdev.R;


public class MusicListDialog extends Dialog{
	private Context mContext;

	private View mRoot;
	private TextView mVTitle;
	private View mVTitleLine;
	private ListView mVList;

	private Button mBtCancel;
//	private List<String> mOperateList;
//	private ChoiceAdapter mAdapter;
	private OnItemClickListener mListener;

	private String mTitleText;

	public MusicListDialog(Context context,  OnItemClickListener listener) {
		super(context);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setCancelable(true);
		setCanceledOnTouchOutside(true);
		this.mContext=context;
		this.mListener = listener;
		
//		View contentView = LayoutInflater.from(context).inflate(
//				R.layout.choice_list_dialog, null);
//		initView(contentView);
//		setContentView(contentView);
	}
	
	public void setListener(OnItemClickListener mListener) {
		this.mListener = mListener;
	}


	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
//		requestWindowFeature(Window.FEATURE_NO_TITLE);
		Window wind = getWindow();
		wind.setBackgroundDrawableResource(android.R.color.transparent);
//		wind.addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
//		wind.setWindowAnimations(android.R.style.Animation_Dialog);
//		
		setContentView(R.layout.music_list_dialog);
		initView();
		getWindow().getDecorView().setOnClickListener(mDismissClick);
	}
	
	public void initView(){
		mRoot = findViewById(R.id.root);
		mVTitle=(TextView)findViewById(R.id.title);
		mVTitleLine = findViewById(R.id.title_line);
		mVList = (ListView) findViewById(R.id.list);
		mBtCancel = ((Button) findViewById(R.id.cancel));
		mBtCancel.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(MusicListDialog.this.isShowing())MusicListDialog.this.cancel();
			}
		});
		
//		mAdapter = new ChoiceAdapter(mOperateList);
//		mVList.setAdapter(mAdapter);
//		mVList.setOnItemClickListener(new OnItemClickListener() {
//
//			@Override
//			public void onItemClick(AdapterView<?> parent, View view,
//					int position, long id) {
//				if (mListener != null) {
//					mListener.onItemClick(parent, view, position, id);
//				}
//				dismiss();
//			}
//
//		});
		
		if (mTitleText != null) {
			setTitle(mTitleText);
		}
		mRoot.setOnClickListener(mDismissClick);
		if (mRoot.getParent() != null && mRoot.getParent() instanceof View) {
			( (View)mRoot.getParent()).setOnClickListener(mDismissClick);
		}
	}
	
	public void setTitle(String title) {
		mTitleText = title;
		if (mVTitle != null) {
			mVTitle.setVisibility(View.VISIBLE);
//			mVTitleLine.setVisibility(View.VISIBLE);
			mVTitle.setText(title);
		}
	}

	public ListView getDilogListView(){
		return mVList;
	}

	
//	private class ChoiceAdapter extends BaseAdapter {
//
//		private List<String> mData;
//
//		public ChoiceAdapter(List<String> data) {
//			mData = data;
//		}
//
//		@Override
//		public int getCount() {
//			return mData == null ? 0 : mData.size();
//		}
//
//		@Override
//		public Object getItem(int position) {
//			// TODO Auto-generated method stub
//			return null;
//		}
//
//		@Override
//		public long getItemId(int position) {
//			// TODO Auto-generated method stub
//			return 0;
//		}
//
//		@Override
//		public View getView(int position, View convertView, ViewGroup parent) {
//			if (convertView == null) {
//				convertView = LayoutInflater.from(mContext).inflate(R.layout.choice_list_item, null);
//			}
//			TextView textView = (TextView) convertView.findViewById(R.id.operate);
//			textView.setText(mData.get(position));
//			if (position == getCount()-1) {
//				convertView.findViewById(R.id.line).setVisibility(View.GONE);
//			} else {
//				convertView.findViewById(R.id.line).setVisibility(View.VISIBLE);
//			}
//			return convertView;
//		}
//
//	}
	
	View.OnClickListener mDismissClick = new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			cancel();
		}
	};
	
}
