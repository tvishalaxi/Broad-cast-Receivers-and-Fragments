package com.project.vishalaxi.receiveractivity;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

//Several Activity and Fragment lifecycle methods are instrumented to emit LogCat output
//so you can follow the class' lifecycle
public class IndianapolisWebFragment extends Fragment {

	private static final String TAG = "IndWebFragment";

	//private TextView mQuoteView = null;
	private WebView webView = null;
	private int mCurrIdx = -1;
	private int mCWebArrLen;

	int getShownIndex() {
		return mCurrIdx;
	}

	// Show the Web Page at position newIndex
	void showWebPageAtIndex(int newIndex) {
		if (newIndex < 0 || newIndex >= mCWebArrLen)
			return;
		mCurrIdx = newIndex;
		webView.setInitialScale(1);
		webView.getSettings().setJavaScriptEnabled(true);
		webView.getSettings().setLoadWithOverviewMode(true);
		webView.getSettings().setUseWideViewPort(true);
		webView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
		webView.setScrollbarFadingEnabled(false);
		webView.setWebViewClient(new WebViewClient());
		webView.loadUrl(IndianapolisViewerActivity.mIWebArray[mCurrIdx]);
	}

	private class MyBrowser extends WebViewClient {
		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			view.loadUrl(url);
			return true;
		}
	}

	@Override
	public void onAttach(Activity activity) {
		Log.i(TAG, getClass().getSimpleName() + ":entered onAttach()");
		super.onAttach(activity);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		Log.i(TAG, getClass().getSimpleName() + ":entered onCreate()");
		super.onCreate(savedInstanceState);
		// Retain this Fragment across Activity reconfigurations
		setRetainInstance(true);
	}

	// Called to create the content view for this Fragment
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		Log.i(TAG, getClass().getSimpleName() + ":entered onCreateView()");
		// Inflate the layout defined in ind_quote_fragment.xmlml
		// The last parameter is false because the returned view does not need to be attached to the container ViewGroup
		return inflater.inflate(R.layout.ind_quote_fragment, container, false);
	}

	// Set up some information about the mQuoteView TextView 
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		Log.i(TAG, getClass().getSimpleName() + ":entered onActivityCreated()");
		super.onActivityCreated(savedInstanceState);
		webView = (WebView) getActivity().findViewById(R.id.webView_2);
		mCWebArrLen = IndianapolisViewerActivity.mIWebArray.length;
	}

	@Override
	public void onStart() {
		Log.i(TAG, getClass().getSimpleName() + ":entered onStart()");
		super.onStart();
	}

	@Override
	public void onResume() {
		Log.i(TAG, getClass().getSimpleName() + ":entered onResume()");
		super.onResume();
	}

	@Override
	public void onPause() {
		Log.i(TAG, getClass().getSimpleName() + ":entered onPause()");
		super.onPause();
	}

	@Override
	public void onStop() {
		Log.i(TAG, getClass().getSimpleName() + ":entered onStop()");
		super.onStop();
	}

	@Override
	public void onDetach() {
		Log.i(TAG, getClass().getSimpleName() + ":entered onDetach()");
		super.onDetach();
	}

	@Override
	public void onDestroy() {
		Log.i(TAG, getClass().getSimpleName() + ":entered onDestroy()");
		super.onDestroy();
	}

	@Override
	public void onDestroyView() {
		Log.i(TAG, getClass().getSimpleName() + ":entered onDestroyView()");
		super.onDestroyView();
	}
}