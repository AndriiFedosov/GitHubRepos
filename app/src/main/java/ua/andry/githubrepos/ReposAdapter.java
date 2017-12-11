package ua.andry.githubrepos;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;


import ua.andry.githubrepos.models.Item;
import ua.andry.githubrepos.models.ReposList;

import ua.andry.githubrepos.models.User;

/**
 * Created by shink on 10.12.2017.
 */

public class ReposAdapter extends RecyclerView.Adapter<ReposAdapter.ViewHolder> {
        private ReposList repos;
        private List<Item> items;
        private User user;



        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.repos_item, parent, false);
            return new ViewHolder(v);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            List<Item> items = repos.getItems();
            Item item = items.get(position);

            holder.name.setText(item.getName());
            holder.desc.setText(item.getDescription());
            Picasso.with(holder.avatar.getContext()).load(item.getOwner().getAvatarUrl()).placeholder(R.drawable.octocat)
                    .into(holder.avatar);
            holder.followers.setText(user.getFollowers());
            holder.folks.setText(item.getForks());
        }

        @Override
        public int getItemCount() {
            if (repos == null)
                return 0;
            return items.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            ImageView avatar;
            TextView name;
            TextView desc;
            TextView followers;
            TextView folks;


            public ViewHolder(View itemView) {
                super(itemView);
                avatar = (ImageView) itemView.findViewById(R.id.avatar_user);
                name = (TextView) itemView.findViewById(R.id.name_repo);
                desc = (TextView) itemView.findViewById(R.id.desc_repo);
                followers = (TextView) itemView.findViewById(R.id.foll_count);
                folks = (TextView) itemView.findViewById(R.id.folks_count);
            }
        }
}
