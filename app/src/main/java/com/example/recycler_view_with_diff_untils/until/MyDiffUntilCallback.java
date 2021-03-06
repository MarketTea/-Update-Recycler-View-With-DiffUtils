package com.example.recycler_view_with_diff_untils.until;

import androidx.recyclerview.widget.DiffUtil;

import java.util.List;

public class MyDiffUntilCallback extends DiffUtil.Callback {

    private List<String> oldList;
    private List<String> newList;

    public MyDiffUntilCallback(List<String> oldList, List<String> newList) {
        this.oldList = oldList;
        this.newList = newList;
    }

    @Override
    public int getOldListSize() {
        return oldList.size();
    }

    @Override
    public int getNewListSize() {
        return newList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return oldItemPosition == newItemPosition;
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition) == newList.get(newItemPosition);
    }
}
