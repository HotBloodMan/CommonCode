package startimes.com.androidartsearchc15;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 1 on 2016/9/26.
 */
public class TestManager {
    private List<OnDataArrivedListener> mOnDataArrivedListeners=new ArrayList<OnDataArrivedListener>();

    private static class SingletonHolder{
        public static final TestManager INSTANCE=new TestManager();
    }
  private TestManager(){}

    public static TestManager getInstance(){
        return SingletonHolder.INSTANCE;
    }

    public synchronized  void registerListener(OnDataArrivedListener listener){
       if(!mOnDataArrivedListeners.contains(listener)){
           mOnDataArrivedListeners.add(listener);
       }
    }

    public synchronized  void unregisterListener(OnDataArrivedListener listener){
        mOnDataArrivedListeners.remove(listener);
    }
    public interface OnDataArrivedListener{
        public void onDataArrived(Object data);
    }
}
