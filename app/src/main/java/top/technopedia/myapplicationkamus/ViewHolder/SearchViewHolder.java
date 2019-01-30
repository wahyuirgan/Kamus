package top.technopedia.myapplicationkamus.ViewHolder;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import top.technopedia.myapplicationkamus.DetailActivity;
import top.technopedia.myapplicationkamus.Model.KamusModel;
import top.technopedia.myapplicationkamus.R;


public class SearchViewHolder extends RecyclerView.ViewHolder {

    private TextView tvKosakata, tvArti;

    public SearchViewHolder(View itemView) {
        super(itemView);

        tvKosakata  = itemView.findViewById(R.id.tvKosakata);
        tvArti      = itemView.findViewById(R.id.tvArti);
    }

    public void bind(final KamusModel kamusModel) {
        tvKosakata.setText(kamusModel.getKata());
        tvArti.setText(kamusModel.getDeskripsi());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(itemView.getContext(), DetailActivity.class);
                intent.putExtra(DetailActivity.ITEM_KOSAKATA, kamusModel.getKata());
                intent.putExtra(DetailActivity.ITEM_ARTI, kamusModel.getDeskripsi());
                intent.putExtra(DetailActivity.ITEM_CATEGORY, kamusModel.getCategory());
                itemView.getContext().startActivity(intent);
            }
        });
    }
}
