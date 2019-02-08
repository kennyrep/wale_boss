package com.example.kennyrep.stanbic;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kennyrep.stanbic.database.User;

import java.util.ArrayList;
import java.util.List;

class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    List<User> users;

    public UserAdapter(List<User> users) {
        this.users = users;
    }

    @NonNull
    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.ViewHolder holder, int position) {
        holder.name.setText(users.get(position).getFirstName() + " " + users.get(position).getLastName());
        holder.email.setText(users.get(position).getEmail());


    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView email;


        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            email = itemView.findViewById(R.id.email);


        }
    }
}
