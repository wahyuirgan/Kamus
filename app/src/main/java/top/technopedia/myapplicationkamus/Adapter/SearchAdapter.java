package top.technopedia.myapplicationkamus.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;

import top.technopedia.myapplicationkamus.ViewHolder.SearchViewHolder;
import top.technopedia.myapplicationkamus.R;
import top.technopedia.myapplicationkamus.Model.KamusModel;


public class SearchAdapter extends RecyclerView.Adapter<SearchViewHolder> {

    private ArrayList<KamusModel> list = new ArrayList<>();

    public SearchAdapter() {
    }

    public void replaceAll(ArrayList<KamusModel> items) {
        list = items;
        notifyDataSetChanged();
    }

    @Override
    public SearchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SearchViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.list_item, parent, false
                )
        );
    }

    @Override
    public void onBindViewHolder(SearchViewHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}
