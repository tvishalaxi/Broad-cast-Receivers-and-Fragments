package com.project.vishalaxi.receiveractivity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.project.vishalaxi.receiveractivity.ChicagoTitlesFragment.ListSelectionListener;

//Several Activity lifecycle methods are instrumented to emit LogCat output
//so you can follow this class' lifecycle
public class ChicagoViewerActivity extends AppCompatActivity implements
		ListSelectionListener {

	public static String[] mCTitleArray;
	public static String[] mCWebArray;
	private final ChicagoWebFragment mChicagoWebFragment = new ChicagoWebFragment();
	private FragmentManager mFragmentManager;
	private FrameLayout mCTitleFrameLayout, mCWebFrameLayout;
	private static final int MATCH_PARENT = LinearLayout.LayoutParams.MATCH_PARENT;
	private static final String TAG = "ChicagoViewerActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		Log.i(TAG, getClass().getSimpleName() + ":entered onCreate()");

		super.onCreate(savedInstanceState);

		// Get the string arrays with the titles and qutoes
		mCTitleArray = getResources().getStringArray(R.array.ChicagoTitles);
		mCWebArray = getResources().getStringArray(R.array.ChicagoLinks);

		setContentView(R.layout.chicago_activity_main);
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
		fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
						.setAction("Action", null).show();
			}
		});

		// Get references to the TitleFragment and to the ChicagoWebFragment
		mCTitleFrameLayout = (FrameLayout) findViewById(R.id.ctitle_fragment_container);
		mCWebFrameLayout = (FrameLayout) findViewById(R.id.cweb_fragment_container);

		ChicagoTitlesFragment ctf= new ChicagoTitlesFragment();
		// Get a reference to the FragmentManager
		mFragmentManager = getFragmentManager();
		// Start a new FragmentTransaction
		FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
		// Add the TitleFragment to the layout
		fragmentTransaction.replace(R.id.ctitle_fragment_container, ctf);
		// Commit the FragmentTransaction
		fragmentTransaction.commit();
		// Add a OnBackStackChangedListener to reset the layout when the back stack changes
		mFragmentManager
				.addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
					public void onBackStackChanged() {
						setLayout();
					}
				});
	}

	private void setLayout() {
		// Determine whether the ChicagoWebFragment has been added
		if (!mChicagoWebFragment.isAdded()) {
			// Make the ChicagoTitlesFragment occupy the entire layout
			mCTitleFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(
					MATCH_PARENT, MATCH_PARENT));
			mCWebFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(0,
					MATCH_PARENT));
		} else {
			if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
				// Make the TitleLayout take 1/3 of the layout's width
				mCTitleFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(0,
						MATCH_PARENT, 1f));
				// Make the WebLayout take 2/3's of the layout's width
				mCWebFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(0,
						MATCH_PARENT, 2f));
			}else{
				mCTitleFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(
						0, MATCH_PARENT));
				mCWebFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(MATCH_PARENT,
						MATCH_PARENT));
			}
		}
	}

	// Called when the user selects an item in the ChicagoTitlesFragment
	@Override
	public void onListSelection(int index) {
		// If the WebFragment has not been added, add it now
		if (!mChicagoWebFragment.isAdded()) {
			// Start a new FragmentTransaction
			FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
			// Add the WebFragment to the layout
			fragmentTransaction.add(R.id.cweb_fragment_container, mChicagoWebFragment);
			// Add this FragmentTransaction to the backstack
			fragmentTransaction.addToBackStack(null);
			// Commit the FragmentTransaction
			fragmentTransaction.commit();
			// Force Android to execute the committed FragmentTransaction
			mFragmentManager.executePendingTransactions();
		}
		if (mChicagoWebFragment.getShownIndex() != index) {
			// Tell the WebFragment to show the Web page at position index
			mChicagoWebFragment.showWebPageAtIndex(index);
		}
	}

	@Override
	protected void onDestroy() {
		Log.i(TAG, getClass().getSimpleName() + ":entered onDestroy()");
		super.onDestroy();
	}

	@Override
	protected void onPause() {
		Log.i(TAG, getClass().getSimpleName() + ":entered onPause()");
		super.onPause();
	}

	@Override
	protected void onRestart() {
		Log.i(TAG, getClass().getSimpleName() + ":entered onRestart()");
		super.onRestart();
	}

	@Override
	protected void onResume() {
		Log.i(TAG, getClass().getSimpleName() + ":entered onResume()");
		super.onResume();
	}

	@Override
	protected void onStart() {
		Log.i(TAG, getClass().getSimpleName() + ":entered onStart()");
		super.onStart();
	}

	@Override
	protected void onStop() {
		Log.i(TAG, getClass().getSimpleName() + ":entered onStop()");
		super.onStop();
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
        //start ChicagoViewerActivity
		if (id == R.id.action_chicago) {
			Intent i=new Intent(ChicagoViewerActivity.this,ChicagoViewerActivity.class);
			startActivity(i);
		}
		//start IndianapolisViewerActivity
		if (id == R.id.action_indianapolis) {
			Intent i=new Intent(ChicagoViewerActivity.this,IndianapolisViewerActivity.class);
			startActivity(i);
		}
		return super.onOptionsItemSelected(item);
	}
	@Override
	public void onBackPressed(){
		if(getFragmentManager().getBackStackEntryCount()>0){
			getFragmentManager().popBackStack();
		}
		else{
			super.onBackPressed();
		}
	}
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		Log.i(TAG, getClass().getSimpleName() + ":onConfigurationChanged()");
		super.onConfigurationChanged(newConfig);
		setLayout();
	}
}