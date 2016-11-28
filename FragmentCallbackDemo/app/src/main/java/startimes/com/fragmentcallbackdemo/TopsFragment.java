package startimes.com.fragmentcallbackdemo;


import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class TopsFragment extends Fragment implements View.OnClickListener {


    public TopsFragment() {
        // Required empty public constructor
    }
    @Override
    public void onClick(View view) {
    if(listener!=null){
        listener.onClick("Top Fragment Demo");
    }
    }

    private  OnTopButtonClickedListener listener;

    public interface  OnTopButtonClickedListener{
        public void onClick(String name);
    }

    @Override
    public void onAttach(Activity activity) {
        if(getActivity() instanceof OnTopButtonClickedListener){
            listener= (OnTopButtonClickedListener) getActivity();
        }
        super.onAttach(activity);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tops, container, false);
        view.setOnClickListener(this);
        return view;
    }

}
