
package com.czt.mp3recorder.sample;

import java.io.File;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.czt.mp3recorder.MP3Recorder;
import com.czt.mp3recorder.RecordExceptionListener;

public class MainActivity extends Activity {

	private MP3Recorder mRecorder = new MP3Recorder(new File(Environment.getExternalStorageDirectory(),"test.mp3"));

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		final Button startButton = (Button) findViewById(R.id.StartButton);
		startButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mRecorder.start();
				Toast.makeText(getApplicationContext(),"开始录音",Toast.LENGTH_LONG).show();
			}
		});
		Button stopButton = (Button) findViewById(R.id.StopButton);
		stopButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mRecorder.stop();
				Toast.makeText(getApplicationContext(),"结束录音",Toast.LENGTH_LONG).show();

			}
		});

		mRecorder.setRecordExceptionListener(new RecordExceptionListener() {
			@Override
			public void onError(final Throwable e) {
				e.printStackTrace();
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
					}
				});
			}
		});
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		mRecorder.stop();
	}
}
