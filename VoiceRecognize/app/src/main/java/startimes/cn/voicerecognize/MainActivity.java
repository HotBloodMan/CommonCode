package startimes.cn.voicerecognize;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.iflytek.cloud.ErrorCode;
import com.iflytek.cloud.InitListener;
import com.iflytek.cloud.RecognizerListener;
import com.iflytek.cloud.RecognizerResult;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.SpeechRecognizer;
import com.iflytek.cloud.SpeechUtility;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class MainActivity extends Activity {

    private static final String APPID="57709d8d";//"578c4896";   //"57709d8d";//讯飞语音ID
    private static String TAG = MainActivity.class.getSimpleName();

    private SpeechRecognizer mSpeechRecognizer;
    //语音识别结果
    private String mRecognizerResult;
    private SharedPreferences mSharedPreferences;
    // 用HashMap存储听写结果
    private HashMap<String, String> mIatResults = new LinkedHashMap<String, String>();
    private TextView tvShowInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        SpeechUtility.createUtility(this, SpeechConstant.APPID+"="+APPID);
        setContentView(R.layout.activity_main);

        // 使用SpeechRecognizer对象，可根据回调消息自定义界面；
        mSpeechRecognizer = SpeechRecognizer.createRecognizer(MainActivity.this, mInitListener);
        mSpeechRecognizer = SpeechRecognizer.createRecognizer(this, null);
        mSharedPreferences = getSharedPreferences(IatSettings.PREFER_NAME,
                Activity.MODE_PRIVATE);
        tvShowInfo = (TextView) findViewById(R.id.tv_showinfo);
        // 设置参数
        mSpeechRecognizer.startListening(mRecognizerListener);

    }
    int ret=0;
    public void doGet(View view) {
        tvShowInfo.setText(null);
        mIatResults.clear();
        // 设置参数
        setParam();
        mSpeechRecognizer.startListening(mRecognizerListener);
        if (ret != ErrorCode.SUCCESS) {
              Log.d(TAG,"听写失败,错误码：" + ret);
        } else {
            Log.d(TAG,"vvvv===>"+getString(R.string.text_begin));
        }
    }

    /**
     * 初始化监听器。
     */
    private InitListener mInitListener = new InitListener() {

        @Override
        public void onInit(int code) {
            Log.d(TAG, "SpeechRecognizer init() code = " + code);
            if (code != ErrorCode.SUCCESS) {
                Log.d("TAG","xxx 初始化失败，错误码：" + code);
            }
        }
    };

    /**
     * 语音识别监听器
     */
    private RecognizerListener mRecognizerListener = new RecognizerListener() {
        @Override
        public void onVolumeChanged(int i, byte[] bytes) {
        }
        @Override
        public void onBeginOfSpeech() {
        }
        @Override
        public void onEndOfSpeech() {
        }
        @Override
        public void onResult(RecognizerResult recognizerResult, boolean b) {
//            if (recognizerResult == null ){
//                mSpeechRecognizer.startListening(mRecognizerListener);
//                return;
//            }
//            mRecognizerResult = JsonParser.parseIatResult(recognizerResult.getResultString());
//            List<String> list = new ArrayList<>();
//            list.add(mRecognizerResult);
//            Log.d("HHHHHH","xxxx mRecognizerResult===>"+ mRecognizerResult);
//            if(mRecognizerResult!=null){
//                tvShowInfo.setText(list.get(0).toString());
//            }

            Log.d(TAG, "xxxx  recognizerResult===> "+recognizerResult.getResultString());
            printResult(recognizerResult);

            if (b) {
                // TODO 最后的结果
            }


        }
        @Override
        public void onError(SpeechError speechError) {
            //mSpeechRecognizer.startListening(mRecognizerListener);
            speechError.getPlainDescription(true);
            Log.d("HHHHHH", "xxxxx error==>>>" + speechError);
        }
        @Override
        public void onEvent(int i, int i1, int i2, Bundle bundle) {
        }
    };


    private void printResult(RecognizerResult results) {
        String text = JsonParser.parseIatResult(results.getResultString());

        String sn = null;
        // 读取json结果中的sn字段
        try {
            JSONObject resultJson = new JSONObject(results.getResultString());
            sn = resultJson.optString("sn");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        mIatResults.put(sn, text);

        StringBuffer resultBuffer = new StringBuffer();
        for (String key : mIatResults.keySet()) {
            resultBuffer.append(mIatResults.get(key));
        }

        tvShowInfo.setText(resultBuffer.toString());
        tvShowInfo.setSelected(true);
    }



    /**
     * 初始化讯飞的服务 语音识别对象
     */
    private void setParam(){
//        1.创建语音听写对象   第二个参数与服务方式关联  本地服务的话传初始化监听器，云服务的话传null
//        if (mSpeechRecognizer == null) {
//            mSpeechRecognizer = SpeechRecognizer.createRecognizer(MainActivity.this, null);
//        }
        //2.设置参数
//       mSpeechRecognizer.setParameter(SpeechConstant.DOMAIN, "iat");
//        mSpeechRecognizer.setParameter(SpeechConstant.LANGUAGE, "zh_cn");
//        mSpeechRecognizer.setParameter(SpeechConstant.ACCENT, "mandarin");
//        // 设置标点符号,设置为"0"返回结果无标点,设置为"1"返回结果有标点
//        mSpeechRecognizer.setParameter(SpeechConstant.ASR_PTT, mSharedPreferences.getString("iat_punc_preference", "0"));



// 清空参数
        mSpeechRecognizer.setParameter(SpeechConstant.PARAMS, null);

        // 设置听写引擎
        mSpeechRecognizer.setParameter(SpeechConstant.ENGINE_TYPE, SpeechConstant.TYPE_CLOUD);
        // 设置返回结果格式
        mSpeechRecognizer.setParameter(SpeechConstant.RESULT_TYPE, "json");

        String lag = mSharedPreferences.getString("iat_language_preference",
                "mandarin");
        if (lag.equals("en_us")) {
            // 设置语言
            mSpeechRecognizer.setParameter(SpeechConstant.LANGUAGE, "en_us");
        } else {
            // 设置语言
            mSpeechRecognizer.setParameter(SpeechConstant.LANGUAGE, "zh_cn");
            // 设置语言区域
            mSpeechRecognizer.setParameter(SpeechConstant.ACCENT, lag);
        }

        // 设置语音前端点:静音超时时间，即用户多长时间不说话则当做超时处理
        mSpeechRecognizer.setParameter(SpeechConstant.VAD_BOS, mSharedPreferences.getString("iat_vadbos_preference", "4000"));

        // 设置语音后端点:后端点静音检测时间，即用户停止说话多长时间内即认为不再输入， 自动停止录音
        mSpeechRecognizer.setParameter(SpeechConstant.VAD_EOS, mSharedPreferences.getString("iat_vadeos_preference", "1000"));

        // 设置标点符号,设置为"0"返回结果无标点,设置为"1"返回结果有标点
        mSpeechRecognizer.setParameter(SpeechConstant.ASR_PTT, mSharedPreferences.getString("iat_punc_preference", "1"));

        // 设置音频保存路径，保存音频格式支持pcm、wav，设置路径为sd卡请注意WRITE_EXTERNAL_STORAGE权限
        // 注：AUDIO_FORMAT参数语记需要更新版本才能生效
        mSpeechRecognizer.setParameter(SpeechConstant.AUDIO_FORMAT,"wav");
        mSpeechRecognizer.setParameter(SpeechConstant.ASR_AUDIO_PATH, Environment.getExternalStorageDirectory()+"/msc/iat.wav");


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mSpeechRecognizer.cancel();
        mSpeechRecognizer.destroy();
    }
}
