package startimes.com.layoutdemo1;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends ListActivity {

    private List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_second);
        list = new ArrayList<>();
        for(int i=0;i<=20;i++){
            list.add("kitkat"+i);
        }
        ArrayAdapter<String> adapter=new InnerAdapter(this,R.layout.list_item,R.id.tv1,list);
        View footerView = View.inflate(this, R.layout.footer_view_1, null);
        getListView().addFooterView(footerView);
        setListAdapter(adapter);

    }
    class InnerAdapter extends  ArrayAdapter<String>{

        public InnerAdapter(
                Context context,
                int resource,
                int textViewResourceId,
                List<String> objects) {
            super(context, resource, textViewResourceId, objects);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = super.getView(position, convertView, parent);
            Button btn = (Button) v.findViewById(R.id.button1);
            btn.setTag(position);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos= (Integer) view.getTag();
                    //从list集合中的数据删除
                    list.remove(pos);
                    //通知更新数据
                    notifyDataSetChanged();
                }
            });
            return v;
        }

    }
}
