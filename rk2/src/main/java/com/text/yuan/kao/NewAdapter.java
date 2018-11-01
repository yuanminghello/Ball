package com.text.yuan.kao;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * date:2018/11/01
 * author:袁明磊(123)
 * function:
 */
class NewAdapter extends BaseAdapter {
    Context context;
    ArrayList<NewResponse.NewItemBean> list;
    public NewAdapter(Context context) {
        this.context=context;

        list = new ArrayList<>();
    }

    public void setData(List<NewResponse.NewItemBean> newResponses) {
        this.list.clear();
        if(newResponses!=null){
            this.list.addAll(newResponses);
        }
        notifyDataSetChanged();

    }

    @Override
    public int getItemViewType(int position) {

        if(position%2==0){
            return super.getItemViewType(position);
        }else if(position%2==1){
            return 1;
        }
        return super.getItemViewType(position);

    }

    @Override
    public int getViewTypeCount() {
        return super.getViewTypeCount()+1;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder2 holder2;
        ViewHolder1 holder1;
        if(i%2==0){
            if(view==null){
                view = View.inflate(context,R.layout.item_img,null);

                holder1 = new ViewHolder1(view);
            }else {
                 holder1 = (ViewHolder1) view.getTag();
            }

            holder1.BindData(list.get(i));
        }else if(i%2==1){
            if(view==null){
                view = View.inflate(context,R.layout.item_text,null);

                holder2 = new ViewHolder2(view);

            }else {
                holder2 = (ViewHolder2) view.getTag();
            }

            holder2.BindData(list.get(i));
        }

        return view;
    }

    class ViewHolder1{
        ImageView icon;
        TextView title;
        TextView date;
        View view;
        public ViewHolder1(View view) {
            this.view=view;
            icon = view.findViewById(R.id.icon);
            title = view.findViewById(R.id.title);
            date = view.findViewById(R.id.date);
            view.setTag(this);
        }

        public void BindData(NewResponse.NewItemBean da){
            title.setText(da.getTitle());
            ImageLoader.getInstance().displayImage(da.getImg(),icon);
        }
    }

    class ViewHolder2{
        TextView title;
        TextView date;
        View view;
        public ViewHolder2(View view) {
            this.view=view;
            title = view.findViewById(R.id.title);
            date = view.findViewById(R.id.date);
            view.setTag(this);
        }
        public void BindData(NewResponse.NewItemBean da){
            title.setText(da.getTitle());

        }
    }

}
