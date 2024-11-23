package com.example.hackathon.presentation.grouplist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hackathon.R;
import com.example.hackathon.data.MainGroup;

import java.util.List;

public class GroupListAdapter extends RecyclerView.Adapter<GroupListAdapter.GroupListViewHolder> {

    public List<MainGroup> groupList;

    public GroupListAdapter(List<MainGroup> groupList) {
        this.groupList = groupList;
    }

    @NonNull
    @Override
    public GroupListAdapter.GroupListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_group_list,viewGroup,false);
        return new GroupListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GroupListAdapter.GroupListViewHolder holder, int position) {
        MainGroup mainGroup = groupList.get(position);
        holder.groupName.setText(mainGroup.getGroupName());
    }

    @Override
    public int getItemCount() {
        return (groupList != null) ? groupList.size() : 0;
    }

    public class GroupListViewHolder extends RecyclerView.ViewHolder{
        TextView groupName;

        public GroupListViewHolder(@NonNull View itemView) {
            super(itemView);
            groupName = itemView.findViewById(R.id.item_group_name);
        }
    }
}
