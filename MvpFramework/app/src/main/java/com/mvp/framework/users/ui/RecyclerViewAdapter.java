package com.mvp.framework.users.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mvp.framework.R;
import com.mvp.framework.users.data.ViewModel;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ItemViewHolder> {

    private List<ViewModel> list;
    private Context context;

    RecyclerViewAdapter(List<ViewModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_list_row, parent, false);
        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {

        ViewModel viewModel = list.get(position);
        holder.userName.setText(viewModel.getFirstName().concat(" " + viewModel.getLastName()));
        Picasso.with(context).
                load(viewModel.getAvatar())
                .placeholder(R.drawable.person_image_empty)
                .into(holder.userImageView);
    }

    @Override
    public int getItemCount() {

        return list.size();
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.name)
        TextView userName;

        @BindView(R.id.user_image)
        CircularImageView userImageView;

        ItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

